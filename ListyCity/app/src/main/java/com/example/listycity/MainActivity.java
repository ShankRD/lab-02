package com.example.listycity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ListView cityList;
    ArrayAdapter<String> cityAdapter;
    ArrayList<String> dataList;

    Button cityAdd;
    Button cityDelete;
    EditText nameOfCity;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityList = findViewById(R.id.city_list);

        String []cities = {"Edmonton", "Vancouver", "Moscow", "Sydney", "Berlin", "Vienna", "Tokyo", "Beijing", "Osaka", "New Delhi"};

        dataList = new ArrayList<>();
        dataList.addAll(Arrays.asList(cities));

        cityAdapter = new ArrayAdapter<>(this, R.layout.content, dataList);
        cityList.setAdapter(cityAdapter);

        cityAdd = findViewById(R.id.addButton);
        cityDelete = findViewById(R.id.deleteButton);
        nameOfCity = findViewById(R.id.userInput);

        cityAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cityName = nameOfCity.getText().toString();
                if (!cityName.isEmpty()) {
                    dataList.add(cityName);
                    cityAdapter.notifyDataSetChanged();
                    nameOfCity.setText("");
                }

            }
        });

        cityDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cityName = nameOfCity.getText().toString();
                if (!cityName.isEmpty()) {
                    dataList.remove(cityName);
                    cityAdapter.notifyDataSetChanged();
                    nameOfCity.setText("");
                }

            }
        });
    }
}