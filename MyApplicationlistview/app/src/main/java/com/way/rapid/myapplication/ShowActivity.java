package com.way.rapid.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ShowActivity extends AppCompatActivity {
    EditText proText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show);
        Button btn= (Button) findViewById(R.id.btn2);
        Button btna=(Button)findViewById(R.id.btn1);//返回
        btna.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {


                Intent intent=new Intent(ShowActivity.this,MainActivity.class);
                startActivity(intent);
               ShowActivity.this.finish();

            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//发表
                Intent intent = new Intent(ShowActivity.this, MainActivity.class);
                proText = (EditText) findViewById(R.id.edit);
                Bean ad = new Bean(R.drawable.ic_rr, "我", proText.getText().toString());
                StaticList.list1.add(0,ad);
                startActivity(intent);
            }
        });
    }
}
