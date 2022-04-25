package comp3350.fairprice.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import comp3350.fairprice.R;

public class Description extends AppCompatActivity {
    // This class will show the Description of an item ( price + detail )
    // Also include Report and Buy features in this class
    
    String price;
    int id;
    private Button buy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        Intent thisIntent = getIntent();
        buy = (Button) findViewById(R.id.btnBuy);


        if (thisIntent != null) {
            String className = thisIntent.getStringExtra("class");

            //This is if the intent is from the main activity class
            if (className != null && className.equals("MyListing")) {
                buy.setVisibility(View.GONE);
            }
        }

        // Main part of Description layout
        String description = thisIntent.getStringExtra("Description");
        String title = thisIntent.getStringExtra("title");
        price = thisIntent.getStringExtra("price");
        id = thisIntent.getIntExtra("id", 0);
        String category = thisIntent.getStringExtra("category");



        /* Binding into ids to make it dynamic for each item */
        TextView des = findViewById(R.id.description);
        TextView titles = findViewById(R.id.titleDes);
        TextView categories = findViewById(R.id.categoryD);
        TextView prices = findViewById(R.id.priceView);

        titles.setText(title);
        prices.setText(price);
        des.setText(description);
        categories.setText("Category: " + category);

    }

        // Buy feature
    public void clickBuy(View v) {
        Intent mainIntent = new Intent(this, payment.class);
        mainIntent.putExtra("price", price);
        mainIntent.putExtra("id", id);

        startActivity(mainIntent);
    }

        // Report feature
    public void report(View v){
        Intent i = new Intent(this,Report.class);
        startActivity(i);
    }
}
