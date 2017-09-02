package com.example.prajaktaawaghade.hello;

import android.content.res.AssetManager;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Date;

public class second extends AppCompatActivity {
    Button Clear;
    Button Save;
    EditText txt;
    EditText txt2;
    Spinner dat;
    Spinner mnth;
    Spinner yr;
    String fileName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Clear=(Button)findViewById(R.id.btnClear);
        Save=(Button)findViewById(R.id.btnSave);
        txt=(EditText)findViewById(R.id.editmsg);
        txt2=(EditText)findViewById(R.id.editTitle);
        dat=(Spinner) findViewById(R.id.dates);
        mnth=(Spinner) findViewById(R.id.months);
        yr=(Spinner) findViewById(R.id.years);

        Clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt.setText("");
                txt2.setText("");

            }
        });

        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //SAVE TEXT CODE IS BELOW
                fileName=dat.getSelectedItem().toString();
                fileName= fileName.concat(mnth.getSelectedItem().toString());
                fileName=fileName.concat(yr.getSelectedItem().toString());
                String Message=txt2.getText().toString();
                Message=Message.concat("\n");
                Message=Message.concat(txt.getText().toString());

                //---------------------
                //WRITE READ CODE HERE
                //--------------------
                try{
                    FileOutputStream fileOutputStream=openFileOutput(fileName,MODE_PRIVATE);
                    fileOutputStream.write(Message.getBytes());
                    fileOutputStream.close();
                    Toast.makeText(getApplicationContext(),"Message Saved...",Toast.LENGTH_SHORT).show();
                    txt.setText("");
                    txt2.setText("");
                }catch(FileNotFoundException e){
                    e.printStackTrace();
                }catch(IOException e){
                    e.printStackTrace();
                }


            }
       });
    }
    @Override
    public boolean onSupportNavigateUp()
    {
        finish();
        return true;
    }
}
