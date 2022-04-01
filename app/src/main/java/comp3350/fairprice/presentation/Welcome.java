package comp3350.fairprice.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import comp3350.fairprice.R;
import comp3350.fairprice.presentation.Register;



/**
 * This class is a landing page for user once the login page authenticates the username
 * and password. This will display multiple options for user to proceed throughout the app.
 */

public class Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(Login.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView);
        textView.setText(message);
    }


    /**
     * this function on button click will open the main
     * page where all the products are listed
     */
    public void goBack(View view) {

        Intent intent = new Intent(this, Register.class);
        startActivity(intent);

    }

    /**
     * Open the main page where all the listings are present.
     * @param view
     */
    public void openExplore(View view) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

}