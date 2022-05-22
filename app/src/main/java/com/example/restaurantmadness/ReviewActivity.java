package com.example.restaurantmadness;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ReviewActivity extends AppCompatActivity {

    private TextView mTextViewResult;
    private RequestQueue mQueue;

    private DrawerLayout mDrawerLayout4;
    private ActionBarDrawerToggle mToggle4;
    private NavigationView mNavView4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        mTextViewResult = findViewById(R.id.json_text);
        Button buttonJson = findViewById(R.id.btn_get_json);

        mQueue = Volley.newRequestQueue(this);
        
        buttonJson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jsonParse();
            }
        });

        mNavView4 = findViewById(R.id.navView4);

        mDrawerLayout4 = findViewById(R.id.drawerLayout4);
        mToggle4 = new ActionBarDrawerToggle(this, mDrawerLayout4, R.string.open, R.string.close);

        mDrawerLayout4.addDrawerListener(mToggle4);
        mToggle4.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mNavView4.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
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

    private void jsonParse() {
        String url = "https://api.npoint.io/f24762403c787141245b";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("reviews");

                            for(int i=0;i<jsonArray.length();i++){
                                JSONObject review = jsonArray.getJSONObject(i);

                                String name = review.getString("name");
                                String sex = review.getString("sex");
                                String comment = review.getString("comment");

                                mTextViewResult.append(name + "\n" + sex + "\n" + comment +"\n\n");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mQueue.add(request);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(mToggle4.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}