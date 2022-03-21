package comp3350.fairprice.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import comp3350.fairprice.R;
import comp3350.fairprice.presentation.MainActivity;
import comp3350.fairprice.presentation.Login;


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
    public void openLogin(View view) {

        Intent intent = new Intent(this, Login.class);
        startActivity(intent);

    }


    /**
     * this function on "Login" button click will open the login
     * page for user to enter username and password.
     */
    public void openRegister(View view) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }



}