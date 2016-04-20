package com.epicodus.bogglesolitaire;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class PlayActivity extends AppCompatActivity {

    private String[] consonants = new String[] {"b", "c", "d", "f", "g", "h", "j", "k", "l", "m", "n", "p", "qu", "r", "s", "t", "v", "w", "x", "y", "z"};
    private String[] vowels = new String [] {"a", "e", "i", "o", "u"};
    private ArrayList<String> letters = new ArrayList<String>();
    private int vowelQty;
    public static final String TAG = PlayActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        vowelQty = ((int) (Math.random() * 3 ) + 2);
        Log.d(TAG, vowelQty + "");

        for(int i = 0; i < vowelQty; i ++ ) {
            letters.add(vowels[(int) (Math.random() * vowels.length)]);
        }

        for(int i = 0; i < 8 - vowelQty; i ++) {
            letters.add(consonants[(int) (Math.random() * consonants.length)]);
        }

        Log.v("letterLog", letters.toString());
//        Log.d(TAG, letters);

//        letters = vowels[(int) (Math.random() * vowels.length)] + vowels[(int) (Math.random() * vowels.length)] + consonants[(int) (Math.random() * consonants.length)];

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
    }
}
