package com.example.virajjoshi.panditwelcome;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.VideoView;

public class Video extends AppCompatActivity implements View.OnClickListener {

    ProgressDialog progressDialog;
    VideoView videoView;
    ImageButton btnPlayPause;

    String videoURL = "https://youtu.be/oEgpGv2CF1U.mp4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);


    }

    @Override
    public void onClick(View v) {



    }
}
