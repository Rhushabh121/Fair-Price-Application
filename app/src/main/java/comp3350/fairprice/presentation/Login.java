package comp3350.fairprice.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.SearchView;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import comp3350.fairprice.R;
import comp3350.fairprice.application.Main;
import comp3350.fairprice.business.AccessPosts;
import comp3350.fairprice.business.AccessUsers;
import comp3350.fairprice.databinding.ActivityMainBinding;
import comp3350.fairprice.objects.Post;
import comp3350.fairprice.objects.User;
import comp3350.fairprice.presentation.Welcome;
import comp3350.fairprice.presentation.HomepageActivity;




public class Login extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

    }


    /**
     * Authenticate the user when the "Sign in" button is clicked.
     * Ensure username exists and the corresponding password matches
     * If user is authenticated
     *      take them to welcome page
     * Else
     *      Display error
     * @param view
     */
    public void authenticate(View view) {

        Intent intent = new Intent(this, Welcome.class);

        // get inputs from username and password fields
        EditText username = (EditText) findViewById(R.id.editTextTextPersonName);
        EditText password = (EditText) findViewById(R.id.editTextTextPersonName3);

        String message = "";
        if(username.length() != 0 && password.length() != 0) {
             message = "Username: \t"+username.getText().toString()+"\nPassword: \t"+password.getText().toString();

        }
        else {
            message = "Unable to login the account.\nUsername or password does not exist.";
        }

        intent.putExtra("username", username.getText().toString());
        intent.putExtra("password", password.getText().toString());
        intent.putExtra("message", message);

        startActivity(intent);

    }

    /**
     * this function on button click will open the main
     * page where all the products are listed
     */
    public void goBack(View view) {

        Intent intent = new Intent(this, HomepageActivity.class);
        startActivity(intent);

    }




}