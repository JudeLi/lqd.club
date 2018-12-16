package com.way.rapid.myapplication;

import android.content.Intent;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;


import android.widget.Button;

import android.widget.ListView;








public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                Intent intent = new Intent(MainActivity.this, ShowActivity.class);
                startActivity(intent);
            }
        });




        FirstAdapter adapter1 = new FirstAdapter(this, R.layout.layout, StaticList.list1);
        ListView listView = ((ListView) findViewById(R.id.first_list_view));
        listView.setAdapter(adapter1);


    }



}