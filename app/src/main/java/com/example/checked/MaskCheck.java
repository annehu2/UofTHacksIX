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

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MaskCheck extends AppCompatActivity {

    private static final int pic_id = 69;
    ImageView facePhoto;
    private static final String TAG = "MainActivity";
    boolean photoTaken = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mask_check);
        getSupportActionBar().hide();
    }

    public void openCamera(View view) {

        if (photoTaken) {
            finish();
            return;
        }

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
            photoTaken = true;

            // Set the image in imageview for display
            facePhoto.setImageBitmap(photo);

        }
    }
}