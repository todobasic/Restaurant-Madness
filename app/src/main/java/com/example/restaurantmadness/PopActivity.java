package com.example.restaurantmadness;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class PopActivity extends Activity {

    private Button buttonAddBook;
    private EditText etName;
    private EditText etTime;
    private EditText etNumber;
    ArrayList<Book> mBookList = BookingsActivity.getBookList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop);

        buttonAddBook = findViewById(R.id.buttonAddBook);
        etName = findViewById(R.id.edit_Name);
        etTime = findViewById(R.id.edit_Time);
        etNumber = findViewById(R.id.edit_Number);

        buttonAddBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBookList.add(new Book(etName.getText().toString(),etTime.getText().toString(),etNumber.getText().toString()));
            }
        });

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.8), (int)(height*.7));

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x = 0;
        params.y = -20;

        getWindow().setAttributes(params);
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);

    }
}