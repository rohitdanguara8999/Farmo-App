package com.farmo.activities.farmerActivities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.farmo.R;

public class MyProductsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_products);
        findViewById(R.id.btnBack).setOnClickListener(v -> finish());
    }
}