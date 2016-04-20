package com.epicodus.bogglesolitaire;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class PlayActivity extends AppCompatActivity {

    private String[] consonants = new String[] {"b", "c", "d", "f", "g", "h"};
    private String[] vowels = new String [] {"a", "e", "i", "o", "u"};
    private String word;
    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

//        Log.d(TAG, vowels.length);
        word = vowels[(int) (Math.random() * vowels.length)] + vowels[(int) (Math.random() * vowels.length)] + consonants[(int) (Math.random() * consonants.length)];

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
    }
}
