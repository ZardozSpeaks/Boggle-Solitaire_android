package com.epicodus.bogglesolitaire;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

import butterknife.Bind;
import butterknife.ButterKnife;


public class PlayActivity extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.letterArray) TextView mLetterArray;
    @Bind(R.id.inputEditText) EditText mInputEditText;
    @Bind(R.id.addWordButton) Button mAddWordButton;
    public ArrayList<String> list = new ArrayList<String>();
    private String[] consonants = new String[] {"b", "c", "c", "c", "c", "c", "d", "d", "d", "d", "d", "d", "f", "f", "f", "f", "g", "g", "g", "h", "h", "h", "h", "h", "j", "k", "l", "l", "l", "l", "l", "m", "m", "m", "m", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "p", "p", "p", "p", "qu", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "s", "s", "s", "s", "s", "s", "s", "s", "s", "t", "t", "t", "t", "t", "t", "t", "t", "t", "t", "t", "t", "t", "v", "w","w", "x", "y", "y", "y", "z"};
    private String[] vowels = new String [] {"a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "e",  "e",  "e",  "e",  "e",  "e",  "e",  "e",  "e",  "e",  "e",  "e",  "e",  "e",  "e",  "e",  "e",  "e",  "e", "i", "o", "i", "o", "i", "o", "i", "o", "i", "o", "i", "o", "i", "o", "i", "o", "i", "o", "i", "o", "i", "o", "u", "u", "u", "u"};
    private ArrayList<String> letters = new ArrayList<String>();
    private int vowelQty;
    HashSet<String> dictionary = new HashSet<>();
    public static final String TAG = PlayActivity.class.getSimpleName();

    public void LoadDictionary() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(getAssets().open("dict")));
            String mLine;
            while((mLine = reader.readLine()) != null) {
                dictionary.add(mLine);
            }
        } catch (IOException e) {

        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {

                }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        ButterKnife.bind(this);
        LoadDictionary();
        mAddWordButton.setOnClickListener(this);

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

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.addWordButton) {
            String userInput = mInputEditText.getText().toString();
            String randomGeneratedString = mLetterArray.getText().toString();
            char[] randomGeneratedCharArray = randomGeneratedString.toCharArray();
            String testString = new String();

            if (userInput.length() >= 3) {
                if (dictionary.contains(userInput)) {
                    for (int i = 0; i < userInput.length(); i++) {

                        for (int j = 0; j < randomGeneratedCharArray.length; j++) {

                            if (userInput.charAt(i) == randomGeneratedCharArray[j]) {
                                testString += userInput.charAt(i);
                                randomGeneratedCharArray[j] = 0;
                            }
                        }
                    }
                } else {
                    Toast.makeText(PlayActivity.this, "It's not a word, partner!", Toast.LENGTH_SHORT).show();
                }
            }
            if (!userInput.matches("")) {
                if (testString.equals(userInput)) {
                    if (list.size() > 0) {
                        boolean isRepeat = false;
                        for (int i = 0; i < list.size(); i++) {
                            if (list.get(i).equals(userInput)) {
                                Toast.makeText(PlayActivity.this, "No Repeats!", Toast.LENGTH_SHORT).show();
                                isRepeat = true;
                                break;
                            }
                        }
                        if (isRepeat == false) {
                            list.add(userInput);
                            Toast.makeText(PlayActivity.this, "Good job!", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        list.add(userInput);
                        Toast.makeText(PlayActivity.this, "Good job!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(PlayActivity.this, "illegal word!", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(PlayActivity.this, "you must enter a word", Toast.LENGTH_SHORT).show();
            }

            Log.d(TAG, list.toString());
            mInputEditText.setText(null);
        }
    }
}
