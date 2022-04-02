package com.example.beeradviser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private BeerExpert expert = new BeerExpert();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickFindBeer(View view) {
        // Get a reference to the Text View
        TextView brands = (TextView) findViewById(R.id.brands);

        // Get a reference to the Spinner
        Spinner color = (Spinner) findViewById(R.id.color);

        // Get the selected items in the Spinner
        String beerType = String.valueOf(color.getSelectedItem());

        // Get recommendations from the BeerExpert class
        List<String> brandList = expert.getBrands(beerType);
        StringBuilder brandFormatted = new StringBuilder();
        for (String brand : brandList) {
            brandFormatted.append(brand).append('\n');
        }

        // Display the selected item
        brands.setText(brandFormatted);
    }
}
