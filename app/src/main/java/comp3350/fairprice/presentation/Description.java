package comp3350.fairprice.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import comp3350.fairprice.R;

public class Description extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        Intent thisIntent = getIntent();
        String description = thisIntent.getStringExtra("Description");
        String title = thisIntent.getStringExtra("title");
        String price = thisIntent.getStringExtra("price");
        String category = thisIntent.getStringExtra("category");

        TextView des = findViewById(R.id.description);
        TextView titles = findViewById(R.id.titleDes);
        TextView categories = findViewById(R.id.categoryD);
        TextView prices = findViewById(R.id.priceView);

        titles.setText(title);
        prices.setText(price);
        des.setText(description);
        categories.setText("Category: " + category);

    }

}