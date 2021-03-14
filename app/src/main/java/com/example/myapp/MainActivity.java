package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private Adapter adapter;
    private List<ListItem> listItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listItems = new ArrayList<>();
        recyclerView = findViewById(R.id.r1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter(listItems,this);
        recyclerView.setAdapter(adapter);

        ListItem listItem = new ListItem();
        listItem.setTask("This is our test task");
        listItem.setStatus(0);

        listItems.add(listItem);
        listItems.add(listItem);
        listItems.add(listItem);
        listItems.add(listItem);
        listItems.add(listItem);

//        adapter.setTasks(listItems);
    }
}