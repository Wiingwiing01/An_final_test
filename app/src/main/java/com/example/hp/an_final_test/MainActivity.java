package com.example.hp.an_final_test;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button zhuce= (Button) findViewById(R.id.zhuce);
        zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * 开辟一个子线程访问网络，否则会抛出异常
                 */
                new Thread() {
                    @Override
                    public void run() {
                        EditText name= (EditText) findViewById(R.id.ed_username);
                        EditText pwd= (EditText) findViewById(R.id.ed_pass);
                        EditText phone=(EditText)findViewById(R.id.ed_phone);
                        //TextView result= (TextView) findViewById(R.id.showResult);
                        String uname=name.getText().toString();
                        String upwd=pwd.getText().toString();
                        String uphone=phone.getText().toString();
                        StringBuffer stringBuffer=new StringBuffer();
                        BufferedReader bufferedReader=null;
                        HttpURLConnection httpURLConnection=null;
                        //ObjectOutputStream objectOutputStream=null;
                        URL url= null;
                        try {
                            url = new URL("http://192.168.56.1:8080/an_http/an_http");
                        } catch (MalformedURLException e) {

                        }
                        try {
                            httpURLConnection=(HttpURLConnection)url.openConnection();
                            //设置允许输出，默认为false
                            httpURLConnection.setDoOutput(true);
                            httpURLConnection.setConnectTimeout(5 * 1000);
                            httpURLConnection.setReadTimeout(10 * 1000);
                            httpURLConnection.setRequestMethod("POST");
                            //objectOutputStream=new ObjectOutputStream(httpURLConnection.getOutputStream());
                            //向服务端写数据
                            String body = "userName="+ URLEncoder.encode(uname, "utf-8") +"&phoneNumber="
                                    +URLEncoder.encode(uphone, "utf-8")+"&passWord="+URLEncoder.encode(upwd, "utf-8");
                            httpURLConnection.getOutputStream().write(body.getBytes());
                            //获得服务端的返回数据
                            InputStream inputStream = httpURLConnection.getInputStream();
                            InputStreamReader inputStreamReader = new InputStreamReader(inputStream,
                                    "utf-8");
                            bufferedReader=new BufferedReader(inputStreamReader);
                            String line="";
                            while((line = bufferedReader.readLine())!=null)
                            {
                                stringBuffer.append(line);
                            }
                            Message message = new Message();
                            message.obj = stringBuffer.toString();
                            handler.sendMessage(message);

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        finally {
                            if(bufferedReader!=null)
                            {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            if(httpURLConnection!=null)
                            {
                                httpURLConnection.disconnect();
                            }
                        }
                    }
                }.start();
            }
        });
    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            ((TextView)findViewById(R.id.showResult)).setText(msg.obj.toString());
        }
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
