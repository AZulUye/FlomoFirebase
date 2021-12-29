package com.example.flom;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.AsyncTaskLoader;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.flom.databinding.ActivityKondisiAirBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class KondisiAirActivity extends AppCompatActivity {

    ActivityKondisiAirBinding binding;
    private StorageReference storageReference;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityKondisiAirBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.getImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                progressDialog = new ProgressDialog(KondisiAirActivity.this);
                progressDialog.setMessage("Fetching image...");
                progressDialog.setCancelable(false);
                progressDialog.show();

                String imageID = binding.etimageId.getText().toString();

                storageReference = FirebaseStorage.getInstance().getReference("upload/"+imageID+".jpg");

                try {
                    File localfile = File.createTempFile("tempfile", ".jpeg");
                    storageReference.getFile(localfile)
                            .addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                                @Override
                                public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {

                                    if(progressDialog.isShowing())
                                        progressDialog.dismiss();

                                    Bitmap bitmap = BitmapFactory.decodeFile(localfile.getAbsolutePath());
                                    binding.imageView.setImageBitmap(bitmap);
                                    

                                }
                            }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                            if(progressDialog.isShowing())
                                progressDialog.dismiss();

                            Toast.makeText(KondisiAirActivity.this, "Failed to retrieve", Toast.LENGTH_SHORT).show();
                            
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });



    }

    public void home(View view) {
        Intent intent = new Intent(this, Success.class);
        startActivity(intent);
        finish();
    }
}