package com.example.learnkids;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Locale;

public class Colors extends AppCompatActivity implements TextToSpeech.OnInitListener{
    ImageView img1,img2,img3,img4,img5,img6,img7,img8,img9,img10,img11,img12,home;
    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_colors);
        tts = new TextToSpeech(this, this);
        home = (ImageView) findViewById(R.id.homebutton);
        img1 = (ImageView) findViewById(R.id.im1);
        img2 = (ImageView) findViewById(R.id.im2);
        img3 = (ImageView) findViewById(R.id.im3);
        img4 = (ImageView) findViewById(R.id.im4);
        img5 = (ImageView) findViewById(R.id.im5);
        img6 = (ImageView) findViewById(R.id.im6);
        img7 = (ImageView) findViewById(R.id.im7);
        img8 = (ImageView) findViewById(R.id.im8);
        img9 = (ImageView) findViewById(R.id.im9);
        img10 = (ImageView) findViewById(R.id.im10);
        img11 = (ImageView) findViewById(R.id.im11);
        img12 = (ImageView) findViewById(R.id.im12);

        home.bringToFront();
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Colors.this, Homescreen.class);
                startActivity(intent);
            }
        });

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speakOut("red");
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speakOut("green");
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speakOut("blue");
            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speakOut("black");
            }
        });
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speakOut("yellow");
            }
        });
        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speakOut("pink");
            }
        });
        img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speakOut("gray");
            }
        });
        img8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speakOut("aqua");
            }
        });
        img9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speakOut("lime");
            }
        });
        img10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speakOut("purple");
            }
        });
        img11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speakOut("orange");
            }
        });
        img12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speakOut("white");
            }
        });

    }


    @Override
    public void onDestroy() {
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }


    public void onInit(int status) {

        if (status == TextToSpeech.SUCCESS) {

            int result = tts.setLanguage(Locale.ENGLISH);

            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Toast.makeText(Colors.this, "This Language is not supported", Toast.LENGTH_SHORT).show();
            } else {
                img1.setEnabled(true);
                img2.setEnabled(true);
                img3.setEnabled(true);
                img4.setEnabled(true);
                img5.setEnabled(true);
                img6.setEnabled(true);
                img7.setEnabled(true);
                img8.setEnabled(true);
                img9.setEnabled(true);
                img10.setEnabled(true);
                img11.setEnabled(true);
                img12.setEnabled(true);
                speakOut("");
            }

        } else {
            Log.e("TTS", "Initialization Failed!");
        }

    }

    private void speakOut(String text)
    {
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }


}