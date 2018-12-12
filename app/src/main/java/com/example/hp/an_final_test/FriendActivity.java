package com.example.hp.an_final_test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FriendActivity extends AppCompatActivity {
    List<Pro> list = new ArrayList<>();
    ListViewAdapt adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend);
        list.add(new Pro(R.drawable.shuaige1, "好友昵称", "充满活力的一天......", R.drawable.fafa2, R.drawable.white1, R.drawable.white1, "30分钟前"));
        list.add(new Pro(R.drawable.shuaige2, "好友昵称","笔芯",R.drawable.bb,R.drawable.white1,R.drawable.white1,"30分钟前"));
        list.add(new Pro(R.drawable.miao, "好友昵称","嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻",R.drawable.fafa3,R.drawable.xiong,R.drawable.white1,"30分钟前"));
        adapter = new ListViewAdapt(this, R.layout.list_view_layout, list);
        ListView listView = ((ListView) findViewById(R.id.show_list));
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), ((TextView) view.findViewById(R.id.title)).getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
        Button button = (Button) findViewById(R.id.fabu);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FriendActivity.this,fabuActivity.class);
                startActivityForResult(intent,1);
                //startActivityForResult(intent,1);
                //startActivity(intent2);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            list.add(new Pro(R.drawable.miao, "zw", data.getExtras().getString("key"), R.drawable.white1, R.drawable.white1, R.drawable.white1, "1分钟前"));
            adapter.notifyDataSetChanged();
    }
    /*
    private void startActivityForResult(Intent intent) {
        Intent i=getIntent();
        String content=i.getStringExtra("key");
        if(content!=""&&content!=null)
        {
            list.add(new Pro(R.drawable.miao,"zw",content,R.drawable.white1,R.drawable.white1,R.drawable.white1,"1分钟前"));
        }

    }*/


}
