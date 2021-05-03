package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String FILE_NAME = "result.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button AddButton = (Button) findViewById(R.id.button2);
        AddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText firstET =(EditText) findViewById(R.id.editTextNumber);
                EditText secondET = (EditText)findViewById(R.id.editTextNumber2);
                TextView resultTV = (TextView) findViewById(R.id.textView);
                int firstNum = Integer.parseInt(firstET.getText().toString());
                int secondNum = Integer.parseInt(secondET.getText().toString());
                int sum = firstNum + secondNum;
                resultTV.setText(sum+"");
            }
        });
        Button SubButton = (Button) findViewById(R.id.button3);
        SubButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText firstET =(EditText) findViewById(R.id.editTextNumber);
                EditText secondET = (EditText)findViewById(R.id.editTextNumber2);
                TextView resultTV = (TextView) findViewById(R.id.textView);
                int firstNum = Integer.parseInt(firstET.getText().toString());
                int secondNum = Integer.parseInt(secondET.getText().toString());
                int sub = firstNum - secondNum;
                resultTV.setText(sub+"");
            }
        });
        Button MulButton = (Button) findViewById(R.id.button4);
        MulButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText firstET =(EditText) findViewById(R.id.editTextNumber);
                EditText secondET = (EditText)findViewById(R.id.editTextNumber2);
                TextView resultTV = (TextView) findViewById(R.id.textView);
                int firstNum = Integer.parseInt(firstET.getText().toString());
                int secondNum = Integer.parseInt(secondET.getText().toString());
                int mul = firstNum * secondNum;
                resultTV.setText(mul+"");
            }
        });
        Button DivButton = (Button) findViewById(R.id.button5);
        DivButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText firstET =(EditText) findViewById(R.id.editTextNumber);
                EditText secondET = (EditText)findViewById(R.id.editTextNumber2);
                TextView resultTV = (TextView) findViewById(R.id.textView);
                int firstNum = Integer.parseInt(firstET.getText().toString());
                int secondNum = Integer.parseInt(secondET.getText().toString());
                int div = firstNum / secondNum;
                resultTV.setText(div+"");
            }
        });

        Button SaveButton = (Button) findViewById(R.id.button6);
        SaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();

            }
        });


    }
    void save(){
        TextView resultTV = (TextView) findViewById(R.id.textView);
        String text = resultTV.getText().toString();
        FileOutputStream fos = null;
        Toast.makeText(this,"Saved to " + getFilesDir() + "/" + FILE_NAME,Toast.LENGTH_LONG).show();

        try {
            fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
            fos.write(text.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            }
    }



}