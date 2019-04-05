package com.habibcse009.studentinfodatabase;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AddInfoActivity extends AppCompatActivity {
    Button btnSave;
    TextView txtName,txtDepartment, txtUniversity, txtMobile, txtEmail;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_info);
        btnSave = findViewById(R.id.btn_save);
        txtName = findViewById(R.id.txt_name);
        txtDepartment = findViewById(R.id.txt_department);
        txtUniversity = findViewById(R.id.txt_university);
        txtMobile = findViewById(R.id.txt_cell);
        txtEmail = findViewById(R.id.txt_email);
        //Initialize font
        Typeface tf = Typeface.createFromAsset(getAssets(), "Milkshake.ttf");
        Typeface tf1 = Typeface.createFromAsset(getAssets(), "Quicksand-Regular.otf");
        Typeface tf2 = Typeface.createFromAsset(getAssets(), "aqua.ttf");
        btnSave.setTypeface(tf2);
        txtName.setTypeface(tf1);
        txtDepartment.setTypeface(tf1);
        txtUniversity.setTypeface(tf1);
        txtMobile.setTypeface(tf1);
        txtEmail.setTypeface(tf1);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String studentname = txtName.getText().toString();
                String department = txtDepartment.getText().toString();
                String university = txtUniversity.getText().toString();
                String mobile = txtMobile.getText().toString();
                String email = txtEmail.getText().toString();

                if (studentname.isEmpty())
                {
                    txtName.setError("Please enter Name!");
                    txtName.requestFocus();
                }

                else if (department.isEmpty())
                {
                    txtDepartment.setError("Please enter Department!");
                    txtDepartment.requestFocus();
                }
                else if (university.isEmpty())
                {
                    txtUniversity.setError("Please enter University!");
                    txtUniversity.requestFocus();
                }
                else if (mobile.isEmpty())
                {
                    txtMobile.setError("Please enter Mobile Number!");
                    txtMobile.requestFocus();
                }
                else if (email.isEmpty())
                {
                    txtEmail.setError("Please enter Email Address!");
                    txtEmail.requestFocus();
                }
                else {
                    DbHandler dbHandler = new DbHandler(AddInfoActivity.this);
                    dbHandler.insertUserDetails(studentname, department,university,mobile,email);
                    intent = new Intent(AddInfoActivity.this, ListInfoActivity.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "Information Inserted Successfully", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
