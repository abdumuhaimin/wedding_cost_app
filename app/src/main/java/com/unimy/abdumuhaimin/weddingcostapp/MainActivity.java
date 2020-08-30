package com.unimy.abdumuhaimin.weddingcostapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.LinkedList;


public class MainActivity extends AppCompatActivity implements ItemDialog.ItemDialogListener {

    private RecyclerView mRecyclerView;
    private ItemListAdapter mAdapter;

    private LinkedList<String> list = new LinkedList<>();
    private int mCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.item_recycler_view);
        mAdapter = new ItemListAdapter(this,list);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.item_add) {
            addItem();
        }

        return super.onOptionsItemSelected(item);
    }

    public void addItem() {
        ItemDialog itemDialog = new ItemDialog();
        itemDialog.show(getSupportFragmentManager(), "item dialog");
    }

    @Override
    public void applyText(String item) {
        list.add(item);
        mRecyclerView.getAdapter().notifyItemInserted(list.size() - 1);
        Log.d("list",list.toString());
    }
}