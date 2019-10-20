package com.example.studentmanage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

public class Index extends AppCompatActivity implements
        View.OnClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater in = getMenuInflater();
        in.inflate(R.menu.index_menu, menu);
        return true;
    }

    //菜单
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_addStudent:
                Toast.makeText(Index.this, "书名:", Toast.LENGTH_SHORT).show();//弹出提示框
                break;
            case R.id.menu_help:
                break;
            case R.id.menu_clear:
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        return false;
    }
}

