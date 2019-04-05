package com.habibcse009.studentinfodatabase;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnAdd, btnView;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAdd = findViewById(R.id.btn_add);
        btnView = findViewById(R.id.btn_view);
        text = findViewById(R.id.txt_home);
        //Initialize font
        Typeface tf = Typeface.createFromAsset(getAssets(), "Milkshake.ttf");
        Typeface tf1 = Typeface.createFromAsset(getAssets(), "Quicksand-Regular.otf");
        Typeface tf2 = Typeface.createFromAsset(getAssets(), "aqua.ttf");
        btnAdd.setTypeface(tf2);
        btnView.setTypeface(tf2);
        text.setTypeface(tf);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddInfoActivity.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "Add Information", Toast.LENGTH_SHORT).show();
            }
        });


        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ListInfoActivity.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "Add Information", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
