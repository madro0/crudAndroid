package com.example.crud;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.crud.controller.RecyclerViewListUsers;
import com.example.crud.dataAccess.ConnectionDb;
import com.example.crud.model.UserModel;

import java.util.ArrayList;
import java.util.List;

public class ListUsers extends AppCompatActivity {

    private RecyclerView recyclerViewUser;
    private RecyclerViewListUsers adapadorUser;
    private CardView car;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_users);

        recyclerViewUser= (RecyclerView)findViewById(R.id.recyclerView);
        recyclerViewUser.setLayoutManager(new LinearLayoutManager(this));


        ConnectionDb db = new ConnectionDb(getApplicationContext());

        adapadorUser = new RecyclerViewListUsers(db.showListUsers());
        recyclerViewUser.setAdapter(adapadorUser);


        //registerForContextMenu(car);
    }
    //cod para llenar a mano una lista
    /* public List<UserModel> obtenerUsuarios(){
        List<UserModel> user = new ArrayList<>();
        user.add(new UserModel("Daniel","Madroñero","daanii2013@gmail.com","123",1));
        user.add(new UserModel("Esteban","Muñoz","danniesteban1200@hotmail.com","123",1));
        return user;
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.selected_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switchecase(item);
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.selected_item,menu);
    }

    public boolean switchecase(MenuItem item){
        switch (item.getItemId()){
            case R.id.itemEdit:
                Toast.makeText(this, "Edite", Toast.LENGTH_SHORT).show();
                return  true;
            case R.id.itemDelete:
                Toast.makeText(this, "Delete", Toast.LENGTH_SHORT).show();
                return  true;
            
            default:
                return super.onContextItemSelected(item);
        }
    }
}
