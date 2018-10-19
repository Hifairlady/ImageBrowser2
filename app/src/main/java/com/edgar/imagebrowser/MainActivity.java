package com.edgar.imagebrowser;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        MangaListFragment fragment = new MangaListFragment();
        transaction.replace(R.id.main_fragment_container, fragment);
        transaction.commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.menu_item_help:
                // TODO: 2018/10/19 finish help messages
                Toast.makeText(this, "Hello Help", Toast.LENGTH_SHORT).show();
                break;

            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
