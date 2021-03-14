package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private NotesAdapter notesAdapter;
    private List<ListItem> listItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listItems = new ArrayList<>();
        ListItem listItem = new ListItem();
        listItem.setTask("This is our test task");
        listItem.setStatus(0);
        listItem.setColor(R.color.teal_200);
        listItems.add(listItem);
        listItems.add(listItem);
        listItems.add(listItem);
        listItems.add(listItem);
        listItems.add(listItem);

        recyclerView = findViewById(R.id.r1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        notesAdapter = new NotesAdapter(listItems,this);
        recyclerView.setAdapter(notesAdapter);
    }
}