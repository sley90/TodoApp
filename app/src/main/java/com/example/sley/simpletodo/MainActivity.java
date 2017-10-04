package com.example.sley.simpletodo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

//import android.widget.ListView;




public class MainActivity extends AppCompatActivity {
    ArrayList<String> items;
    ArrayAdapter<String> itemsAdapter;
    ListView lvItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvItems = (ListView)findViewById(R.id.lvItems);
        items = new ArrayList<>();
        //WriteItems();
        itemsAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, items);
        lvItems.setAdapter(itemsAdapter);
        items.add("Jhon Sley");
        items.add("Mica Jhon");
        setListViewListener();
    }

    public void onAddItem(View v) {
        EditText EtNewItem = (EditText) findViewById(R.id.EtNewItem) ;
        String itemText = EtNewItem.getText().toString();
        itemsAdapter.add(itemText);
        Toast.makeText(getApplicationContext()," correct",Toast.LENGTH_SHORT).show();
        EtNewItem.setText("");
        //WriteItems();

    }

    private void setListViewListener() {
        Log.i("mainActivity","Setting up Listener Add");
        lvItems.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            public boolean onItemLongClick(AdapterView<?> parent, View view, int pos, long id) {
                items.remove(pos);
                itemsAdapter.notifyDataSetChanged();
                //WriteItems();
                return  true;
            }
        });
    }



}
