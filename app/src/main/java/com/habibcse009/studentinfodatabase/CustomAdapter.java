package com.habibcse009.studentinfodatabase;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    String id[],studentName[],department[],university[],mobile[],email[];

    ArrayList<HashMap<String, String>> userList;
    Context context;

    public CustomAdapter(Context context, ArrayList userList) {

        this.userList=userList;
    }

    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_item,viewGroup,false);
        MyViewHolder vh=new MyViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder myViewHolder, final int possition) {
        myViewHolder.txtxId.setText(userList.get(possition).get("id"));
        myViewHolder.txtName.setText(userList.get(possition).get("name"));
        myViewHolder.txtDepartment.setText(userList.get(possition).get("department"));
        myViewHolder.txtUniversity.setText(userList.get(possition).get("university"));
        myViewHolder.txtMobile.setText(userList.get(possition).get("mobile"));
        myViewHolder.txtEmail.setText(userList.get(possition).get("email"));

        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,studentName[possition],Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(context,DetailsActivity.class);
                intent.putExtra("id",id[possition]);
                intent.putExtra("name",studentName[possition]);
                intent.putExtra("department",department[possition]);
                intent.putExtra("university",university[possition]);
                intent.putExtra("mobile",mobile[possition]);
                intent.putExtra("email",email[possition]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txtName,txtxId,txtDepartment,txtUniversity,txtMobile,txtEmail;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtxId=itemView.findViewById(R.id.txt_id_list);
            txtName=itemView.findViewById(R.id.txt_name_list);
            txtDepartment=itemView.findViewById(R.id.txt_department_list);
            txtUniversity=itemView.findViewById(R.id.txt_university_list);
            txtMobile=itemView.findViewById(R.id.txt_mobile_list);
            txtEmail=itemView.findViewById(R.id.txt_email_list);

           // Typeface tf = Typeface.createFromAsset(context.getAssets(), "aqua.ttf");
//            txtxId.setTypeface(tf);
//            txtName.setTypeface(tf);
//            txtDepartment.setTypeface(tf);
//            txtUniversity.setTypeface(tf);
//            txtMobile.setTypeface(tf);
//            txtEmail.setTypeface(tf);

        }
    }
}
