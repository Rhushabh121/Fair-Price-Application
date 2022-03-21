package comp3350.fairprice.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import comp3350.fairprice.R;
import comp3350.fairprice.presentation.MainActivity;

public class HomepageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
    }

    /**
     * this function on button click will open the main
     * page where all the products are listed
     */
    public void openMain(View view) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);


    }

}