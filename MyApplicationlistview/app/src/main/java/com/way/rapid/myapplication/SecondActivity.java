package com.way.rapid.myapplication;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class SecondActivity extends AppCompatActivity {
    private EditText red1,red2,red3;
    private Button bt3,bt4;
    private Boolean b=false,b1=false,b2=false,b3=true,b4=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        red1 = (EditText) findViewById(R.id.red1);
        red2 = (EditText) findViewById(R.id.red2);
        red3 = (EditText) findViewById(R.id.red3);
        bt3 = (Button) findViewById(R.id.bt3);
        bt4 = (Button) findViewById(R.id.bt4);
        creatTable();
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b4 = check();
                if (b4) {
                    String sql2 = "insert into User(UserName,UserPasswd) values('" + red1.getText().toString()
                            + "','" + red2.getText().toString() + "')";
                    getDataBase().execSQL(sql2);
                }
                Toast.makeText(SecondActivity.this, "注册成功，请返回登录", Toast.LENGTH_SHORT).show();
                b = false;
                b4 = false;
            }
        });
    }


    public boolean check(){
        Cursor cursor = getDataBase().query("User",null,null,null,null,null,null);
        while(cursor.moveToNext()){
            String name = cursor.getString(0);
            if(name.equals(red1.getText().toString())){
                red1.setText(null);
                red1.setHint("该用户已存在");
                b3 = false;
                break;
            }
        }
        if(red1.length()==0||red2.length()==0||red3.length()==0){
            b1=false;
            Toast.makeText(this,"内容不能为空！",Toast.LENGTH_SHORT).show();
        }else{
            b1 = true;
        }
        if(red2.getText().toString().equals(red3.getText().toString())){
            b2 = true;
        }else{
            b2 = false;
            red2.setText(null);
            red3.setText(null);
            red2.setHint("密码不一致或空！");
            red3.setHint("密码不一致或空！");
        }
        b = b1&&b2&&b3;
        b1 = false;
        b2 = false;
        b3 = true;
        return b;
    }
    public SQLiteDatabase getDataBase(){
        return openOrCreateDatabase("client",MODE_PRIVATE,null);
    }
    public void creatTable(){
        String sql = "create table if not exists User(UserName varChar(20) primary key,UserPasswd varchar(20));";
        getDataBase().execSQL(sql);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_second, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
