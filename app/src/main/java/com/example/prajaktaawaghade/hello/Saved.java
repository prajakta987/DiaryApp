package com.example.prajaktaawaghade.hello;

import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Saved extends AppCompatActivity {
    Button btns;
    Spinner dats;
    Spinner mnths;
    Spinner yrs;
    String fileName;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        dats=(Spinner) findViewById(R.id.dte);
        mnths=(Spinner) findViewById(R.id.mn);
        yrs=(Spinner) findViewById(R.id.yr);
        btns=(Button)findViewById(R.id.but);
        tv=(TextView)findViewById(R.id.tvShow);

        btns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fileName=dats.getSelectedItem().toString();
                fileName= fileName.concat(mnths.getSelectedItem().toString());
                fileName=fileName.concat(yrs.getSelectedItem().toString());

                try{
                    String Message;
                    FileInputStream fileInputStream=openFileInput(fileName);
                    InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    StringBuffer stringBuffer= new StringBuffer();
                    while((Message=bufferedReader.readLine())!=null)
                    {
                        stringBuffer.append(Message +"\n");
                    }
                    tv.setText(stringBuffer.toString());

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
