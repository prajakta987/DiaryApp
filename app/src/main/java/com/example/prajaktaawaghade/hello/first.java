package com.example.prajaktaawaghade.hello;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class first extends AppCompatActivity {
    Button btn;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        btn=(Button)findViewById(R.id.btn1);
        password=(EditText)findViewById(R.id.editpin);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(password.getText().toString().equals("pooja"))
                {
                    password.setText("");
                Intent demo=new Intent(first.this,ReadWrite.class);
                startActivity(demo);
            }
            else
                {
                    password.setText("");
                    Toast.makeText(first.this, "wrong password......!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
