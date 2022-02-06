package com.example.checked;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.vision.v1.Vision;
import com.google.api.services.vision.v1.VisionRequestInitializer;
import com.google.api.services.vision.v1.model.AnnotateImageRequest;
import com.google.api.services.vision.v1.model.BatchAnnotateImagesRequest;
import com.google.api.services.vision.v1.model.BatchAnnotateImagesResponse;
import com.google.api.services.vision.v1.model.Feature;
import com.google.api.services.vision.v1.model.Image;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MaskCheck extends AppCompatActivity {

    private static final int pic_id = 69;
    ImageView facePhoto;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mask_check);
        getSupportActionBar().hide();
    }

    public void openCamera(View view) {
        //Toast.makeText(this, "Opened Camera!", Toast.LENGTH_SHORT).show(); // Delete this line once shit is done
        Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(camera_intent, pic_id);
    }

    // This method will help to retrieve the image
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Match the request 'pic id with requestCode
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == pic_id) {

            // BitMap is data structure of image file which store the image in memory
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            facePhoto = (ImageView) findViewById(R.id.imageView12);

            // Set the image in imageview for display
            facePhoto.setImageBitmap(photo);

            Log.d("RETURNED", callCloudVision(photo));
        }
    }

    private String callCloudVision(final Bitmap bitmap) {
        final String[] message = {""};

        new AsyncTask<Object, Void, String>() {
            @Override
            protected String doInBackground(Object... params) {

                try {

                    //Init protocol
                    HttpTransport httpTransport = AndroidHttp.newCompatibleTransport();
                    JsonFactory jsonFactory = GsonFactory.getDefaultInstance();

                    //Instantiate Vision
                    Vision.Builder builder = new Vision.Builder(httpTransport, jsonFactory, null);
                    builder.setVisionRequestInitializer(new VisionRequestInitializer("AIzaSyDREDpUSgusjTyG6BReKAV9ss_o96Q3KDY"));
                    Vision vision = builder.build();

                    //Create request
                    BatchAnnotateImagesRequest batchAnnotateImagesRequest = new BatchAnnotateImagesRequest();
                    batchAnnotateImagesRequest.setRequests(new ArrayList<AnnotateImageRequest>() {{

                        AnnotateImageRequest annotateImageRequest = new AnnotateImageRequest();

                        Image img = new Image();
                        // Convert the bitmap to a JPEG
                        ByteArrayOutputStream stream = new ByteArrayOutputStream();
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream);
                        byte[] imageBytes = stream.toByteArray();
                        // Base64 encode the JPEG
                        img.encodeContent(imageBytes);

                        annotateImageRequest.setImage(img);

                        annotateImageRequest.setFeatures(new ArrayList<Feature>() {{
                            Feature labelDetection = new Feature();
                            labelDetection.setType("LABEL_DETECTION");
                            labelDetection.setMaxResults(10);
                            add(labelDetection);
                        }});

                        add(annotateImageRequest);
                    }});

                    //Add properties
                    Vision.Images.Annotate annotateRequest = vision.images().annotate(batchAnnotateImagesRequest);
                    annotateRequest.setDisableGZipContent(true);

                    BatchAnnotateImagesResponse response = annotateRequest.execute();
                    message[0] = response.toString();
                    return response.toString();
                } catch (Exception e) {

                    Log.e(TAG, "failed to make API request because " + e.toString());
                }

                return "Cloud Vision API request failed. Check logs for details.";
            }
        }.execute();

        return message[0];
    }
}