package com.habibcse009.studentinfodatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class ListInfoActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_info);
        recyclerView = findViewById(R.id.recyleview);
        LinearLayoutManager manager = new LinearLayoutManager(ListInfoActivity.this);
        recyclerView.setLayoutManager(manager);

        DbHandler db = new DbHandler(this);
        ArrayList<HashMap<String, String>> userList = db.GetUsers();

        CustomAdapter customAdapter = new CustomAdapter(ListInfoActivity.this, userList);
        recyclerView.setAdapter(customAdapter);



    }
}
