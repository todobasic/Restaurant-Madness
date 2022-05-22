package com.example.restaurantmadness;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class BookingsActivity extends AppCompatActivity {

    public static ArrayList<Book> mBookList;

    Button btn_OpenPopUp;
    private DrawerLayout mDrawerLayout3;
    private ActionBarDrawerToggle mToggle3;
    private NavigationView mNavView3;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookings);

        createBookList();
        buildRecyclerView();

        btn_OpenPopUp = (Button) findViewById(R.id.btn_OpenPopUp);

        btn_OpenPopUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), PopActivity.class);
                startActivity(i);
            }
        });

        mNavView3 = findViewById(R.id.navView3);

        mDrawerLayout3 = findViewById(R.id.drawerLayout3);
        mToggle3 = new ActionBarDrawerToggle(this,mDrawerLayout3, R.string.open, R.string.close);

        mDrawerLayout3.addDrawerListener(mToggle3);
        mToggle3.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mNavView3.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case(R.id.nav_foodmenu):
                        Intent in = new Intent(getApplicationContext(), FoodMenuActivity.class);
                        startActivity(in);
                        break;
                    case(R.id.nav_home):
                        Intent inn = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(inn);
                        break;
                    case(R.id.nav_bookings):
                        Intent innn = new Intent(getApplicationContext(), BookingsActivity.class);
                        startActivity(innn);
                        break;
                    case(R.id.nav_reviews):
                        Intent innnn = new Intent(getApplicationContext(), ReviewActivity.class);
                        startActivity(innnn);
                        break;

                }
                return false;
            }
        });
    }

    public static ArrayList<Book> getBookList(){
        return mBookList;
    }



    private void createBookList() {
        mBookList = new ArrayList<>();
        mBookList.add(new Book("Tomislav Odobašić","19:00h","063250581"));
        mBookList.add(new Book("Ivona Dabić","19:00h","063250581"));
    }

    private void buildRecyclerView() {
        mRecyclerView = findViewById(R.id.bookings_Recycler);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new BookAdapter(mBookList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(mToggle3.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}