package comp3350.fairprice.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import comp3350.fairprice.R;

public class Description extends AppCompatActivity {
        String price;
        int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        Intent thisIntent = getIntent();
        String description = thisIntent.getStringExtra("Description");
        String title = thisIntent.getStringExtra("title");
         price = thisIntent.getStringExtra("price");
         id = thisIntent.getIntExtra("id",0);

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

    public void clickBuy(View v) {
        Intent mainIntent = new Intent(this, payment.class);
        mainIntent.putExtra("price",price);
        mainIntent.putExtra("id",id);

        startActivity(mainIntent);
    }

}