package com.example.crud.controller;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.crud.R;
import com.example.crud.model.UserModel;

import java.util.List;

public class RecyclerViewListUsers extends RecyclerView.Adapter<RecyclerViewListUsers.Holder> {


    List<UserModel> listUsers;

    public RecyclerViewListUsers(List<UserModel> listUsers) {
        this.listUsers = listUsers;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_list_users, parent, false);
        RecyclerViewListUsers.Holder holder = new RecyclerViewListUsers.Holder(v);

        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.Name.setText(listUsers.get(position).getName());
        holder.Email.setText(listUsers.get(position).getEmail());
    }

    @Override
    public int getItemCount() {
        return listUsers.size();
    }

    public class Holder  extends RecyclerView.ViewHolder{
        private TextView Name, Email;

        public Holder(@NonNull View itemView) {
            super(itemView);

            Name = (TextView) itemView.findViewById(R.id.textFullName);
            Email = (TextView) itemView.findViewById(R.id.textEmail);
        }
    }



}
