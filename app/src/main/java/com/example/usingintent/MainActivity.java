package com.example.usingintent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button,button2;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        editText=findViewById(R.id.editText);
        button=findViewById(R.id.button);
        button2=findViewById(R.id.button2);
        textView=findViewById(R.id.textView);
          final int READ_SIZE = 100;
        button.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                try {
                    FileInputStream fileInputStream=openFileInput("readFile.txt");
                    InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);
                    char[] ch=new char[READ_SIZE];
                    StringBuilder str=new StringBuilder();
                    int c;
                    while ((c=inputStreamReader.read(ch))>0){
                        String readStr=String.copyValueOf(ch,0,c);
                        str.append(readStr);
                        ch=new char[READ_SIZE];
                    }
                    textView.setText(str);
                    Toast.makeText(MainActivity.this, "File loaded successfully", Toast.LENGTH_SHORT).show();
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String data=editText.getText().toString();
                    FileOutputStream fileOutputStream=openFileOutput("readFile.txt",MODE_PRIVATE);
                    OutputStreamWriter outputStreamWriter=new OutputStreamWriter(fileOutputStream);
                    outputStreamWriter.write(data);
                    outputStreamWriter.flush();
                    outputStreamWriter.close();
                    editText.setText("");
                    Toast.makeText(MainActivity.this, "file Save Successfully", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}