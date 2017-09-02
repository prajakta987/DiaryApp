package com.example.prajaktaawaghade.hello;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ReadWrite extends AppCompatActivity {
    Button red;
    Button wrt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_write);
        red=(Button)findViewById(R.id.read);
        wrt=(Button)findViewById(R.id.write);

        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go= new Intent(ReadWrite.this,Saved.class);
                startActivity(go);
            }
        });
        wrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ab=new Intent(ReadWrite.this,second.class);
                startActivity(ab);
            }

        });
    }
}
