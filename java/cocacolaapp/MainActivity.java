package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import java.util.*;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Random myRandom = new Random();
        final Random myRandom1 = new Random();
        final Random myRandom2 = new Random();
        final Random myRandom3 = new Random();
        final Random base = new Random();
        int []arr={2480655,2580655,2100655,3060655};

        Button buttonGenerate = (Button)findViewById(R.id.generate);
        final TextView textGenerateNumber = (TextView)findViewById(R.id.generatenumber);
        buttonGenerate.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                int base2=arr[base.nextInt(4)];
                textGenerateNumber.setText(String.valueOf(base2+""+myRandom.nextInt(5)+myRandom1.nextInt(5)+myRandom2.nextInt(5)+myRandom3.nextInt(5))+"5");
            }
        });
        textView=findViewById(R.id.generatenumber);
        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboard =(ClipboardManager) getSystemService (Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText( "", textView.getText (). toString ());
                clipboard.setPrimaryClip (clip);
                        Toast.makeText( MainActivity.this,  "Copied. ", Toast.LENGTH_SHORT).show ();}
        });

    }
}