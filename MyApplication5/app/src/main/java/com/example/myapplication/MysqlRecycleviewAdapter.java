package com.example.myapplication;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MysqlRecycleviewAdapter extends RecyclerView.Adapter<MysqlRecycleviewAdapter.ViewHolder> {
    Activity context;
    ArrayList<DataModel> data = new ArrayList<>();
    public MysqlRecycleviewAdapter(Activity context, ArrayList<DataModel> data){
       this.context = context;
       this.data = data;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View listItem= layoutInflater.inflate(R.layout.mysql_listview_items, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final DataModel current=data.get(position);
        holder.txtRollNo.setText(current.getId()+"");
        holder.txtName.setText(current.getName());
        holder.txtAddress.setText(current.getAddress());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtRollNo,txtName,txtAddress;
        public ViewHolder(View itemView) {
            super(itemView);
            txtRollNo = itemView.findViewById(R.id.txtRollNo);
            txtName = itemView.findViewById(R.id.txtName);
            txtAddress = itemView.findViewById(R.id.txtAddress);
        }
    }
}



