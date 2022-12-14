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
import android.widget.TextView;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
    private List<User> users;
    AccessUsers accessUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        accessUsers = new AccessUsers();
        users = new ArrayList<User>();

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

        users = accessUsers.getUsers();
        User user = new User(username.getText().toString(), username.getText().toString(),"", password.getText().toString(), "");

        boolean found = false;
        if(users.size() > 0)            // user exists
        {
            for(int i = 0; i < users.size(); i++)
            {
                if(users.get(i).getName().equalsIgnoreCase(username.getText().toString()))
                {
                    found = true;
                    if(users.get(i).getPassword().equalsIgnoreCase(password.getText().toString()))
                    {
                        startActivity(intent);
                    }
                    else
                    {
                        TextView displayMessage = findViewById(R.id.message);
                        displayMessage.setText("Password does not match with username.");
                    }

                }
            }
        }
        if(!found)              // take him back to home page
        {
            TextView displayMessage = findViewById(R.id.message);
            displayMessage.setText("User does not exist, enter login details again.");
        }
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