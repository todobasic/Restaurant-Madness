package com.example.restaurantmadness;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class FoodMenuActivity extends AppCompatActivity

{

    private DrawerLayout mDrawerLayout2;
    private ActionBarDrawerToggle mToggle2;
    private NavigationView mNavView2;

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_menu);

        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());

        // Add fragment here

        adapter.AddFragment(new FragmentBurger(), "Burgers");
        adapter.AddFragment(new FragmentPizza(), "Pizzas");
        adapter.AddFragment(new FragmentDessert(), "Desserts");
        adapter.AddFragment(new FragmentDrink(), "Drinks");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.round_fastfood_black_24dp);
        tabLayout.getTabAt(1).setIcon(R.drawable.round_local_pizza_black_24dp);
        tabLayout.getTabAt(2).setIcon(R.drawable.round_cake_black_24dp);
        tabLayout.getTabAt(3).setIcon(R.drawable.round_local_bar_black_24dp);



                mNavView2 = findViewById(R.id.navView2);

        mDrawerLayout2 = findViewById(R.id.drawerLayout2);
        mToggle2 = new ActionBarDrawerToggle(this,mDrawerLayout2, R.string.open, R.string.close);

        mDrawerLayout2.addDrawerListener(mToggle2);
        mToggle2.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mNavView2.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
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
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(mToggle2.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}