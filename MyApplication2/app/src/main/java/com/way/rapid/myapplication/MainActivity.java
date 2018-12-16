package com.way.rapid.myapplication;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        List<String> list = Arrays.asList("a", "b", "c","a", "b", "c","a", "b", "c","a", "b", "c","a", "b", "c");
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_multiple_choice,
//                list);
//        List<Bean> list = Arrays.asList(
//                new Bean(R.drawable.btn_weixin, "今天是下雨天", "$3000"),
//                new Bean(R.drawable.btn_weixin, "ccdd", "$3000"),
//                new Bean(R.drawable.btn_weixin, "aaa", "$3000")
//        );
//        FirstAdapter adapter = new FirstAdapter(this,
//                R.layout.layout ,
//        list);
//        ListView listView = ((ListView)findViewById(R.id.first_list_view));
//        listView.setAdapter(adapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(getApplicationContext(), "list View click", Toast.LENGTH_SHORT).show();
//            }
//        });
    }
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message message) {
            if (message != null && message.obj != null && message.obj.toString().equals("1")) {
                Toast.makeText(MainActivity.this, "ok", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "no", Toast.LENGTH_SHORT).show();
            }

        }
    };


    public void loginButton(View v) {
        myThread();
    }

    private void myThread() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
//                    String userName = ((EditText) findViewById(R.id.nameEditText)).getText().toString();
//                    String userPassword = ((EditText) findViewById(R.id.passwordEditText)).getText().toString();
                    URL url = new URL("http://119.29.60.170:8080/shopping/product");
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setConnectTimeout(5 * 1000);
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    String body = "username=" + URLEncoder.encode("aa", "utf-8") + "&password=" + URLEncoder.encode("bbb", "utf-8");
//                   BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(httpURLConnection.getOutputStream(),"utf-8"));
//                    httpURLConnection.getOutputStream().write(body.getBytes());
//                   bufferedWriter.write(body);
//                   bufferedWriter.close();
                    httpURLConnection.connect();

                                      StringBuffer stringBuffer = new StringBuffer();
                    Message message = new Message();
//                    if (httpURLConnection.getResponseCode() == 200) {
                        InputStream inputStream = httpURLConnection.getInputStream();
                        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
                        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                        String temp;
                        while ((temp = bufferedReader.readLine()) != null) {
                            stringBuffer.append(temp);
                        }
                        bufferedReader.close();
                        inputStreamReader.close();
                        inputStream.close();
                        message.what = 1;

//                    } else {
//                        message.what = -1;
//                    }
                    message.obj = stringBuffer.toString();
                    handler.sendMessage(message);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
