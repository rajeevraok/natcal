package com.example.nativecali;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import android.view.View.OnClickListener;

import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnClickListener{
    EditText e1, e2;
    Button p, m, mu, d;
    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = (EditText) findViewById(R.id.ed1);
        e2 = (EditText) findViewById(R.id.ed2);
        p = (Button) findViewById(R.id.plus);
        m = (Button) findViewById(R.id.minus);
        mu = (Button) findViewById(R.id.multi);
        d = (Button) findViewById(R.id.div);
        t = (TextView) findViewById(R.id.result);
        p.setOnClickListener(this);
        m.setOnClickListener(this);
        mu.setOnClickListener(this);
        d.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        float n1,n2,res=0;
        String opr="";
        if(TextUtils.isEmpty(e1.getText().toString())||TextUtils.isEmpty(e2.getText().toString())){
            Toast.makeText(getApplicationContext(),"No inputs",Toast.LENGTH_LONG).show();
            return;
        }
        n1 = Float.parseFloat(e1.getText().toString());
        n2 = Float.parseFloat(e2.getText().toString());
        switch(v.getId()){
            case R.id.plus:opr="+";res=n1+n2;break;
            case R.id.minus:opr="-";res=n1-n2;break;
            case R.id.multi:opr="*";res=n1*n2;break;
            case R.id.div: {
                if(n2==0){
                    Toast.makeText(getApplicationContext(),"Error:Division by Zero",Toast.LENGTH_LONG).show();
                }
                opr = "/";
                res = n1 / n2;
                break;
            }

        }
        t.setText(n1+opr+n2+"="+res);
    }

}