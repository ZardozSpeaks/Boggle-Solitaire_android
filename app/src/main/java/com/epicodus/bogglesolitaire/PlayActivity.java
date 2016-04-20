package com.epicodus.bogglesolitaire;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import java.util.ArrayList;


public class PlayActivity extends AppCompatActivity {

    TextView mLetterArray;

    private String[] consonants = new String[] {"b", "c", "c", "c", "c", "c", "d", "d", "d", "d", "d", "d", "f", "f", "f", "f", "g", "g", "g", "h", "h", "h", "h", "h", "j", "k", "l", "l", "l", "l", "l", "m", "m", "m", "m", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "p", "p", "p", "p", "qu", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "s", "s", "s", "s", "s", "s", "s", "s", "s", "t", "t", "t", "t", "t", "t", "t", "t", "t", "t", "t", "t", "t", "v", "w","w", "x", "y", "y", "y", "z"};
    private String[] vowels = new String [] {"a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "e",  "e",  "e",  "e",  "e",  "e",  "e",  "e",  "e",  "e",  "e",  "e",  "e",  "e",  "e",  "e",  "e",  "e",  "e", "i", "o", "i", "o", "i", "o", "i", "o", "i", "o", "i", "o", "i", "o", "i", "o", "i", "o", "i", "o", "i", "o", "u", "u", "u", "u"};
    private ArrayList<String> letters = new ArrayList<String>();
    private int vowelQty;
    public static final String TAG = PlayActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

//puts letter array contents into textView

        mLetterArray = (TextView) findViewById(R.id.letterArray);

//generates letter array

        vowelQty = ((int) (Math.random() * 2 ) + 2);
        Log.d(TAG, vowelQty + "");

        for(int i = 0; i < vowelQty; i ++ ) {
            letters.add(vowels[(int) (Math.random() * vowels.length)]);
        }

        for(int i = 0; i < 8 - vowelQty; i ++) {
            letters.add(consonants[(int) (Math.random() * consonants.length)]);
        }


        Log.v("letterLog", letters.toString());

        String letterString = letters.toString();
        letterString = letterString.replaceAll("\\[|\\]|,", "");


//outputs letter array to textView

        mLetterArray.setText(letterString);

//        Log.d(TAG, letters);

//        letters = vowels[(int) (Math.random() * vowels.length)] + vowels[(int) (Math.random() * vowels.length)] + consonants[(int) (Math.random() * consonants.length)];

    }
}
