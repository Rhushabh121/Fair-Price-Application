package comp3350.fairprice.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import comp3350.fairprice.R;
import comp3350.fairprice.presentation.HomepageActivity;
import comp3350.fairprice.presentation.Welcome;


public class Register extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    /**
     * Validate the user when the "Create Account" button is clicked.
     * Ensure username does not exist in database
     * If user is valid
     *      take them to welcome page
     * Else
     *      Display error
     * @param view
     */
    public void validate(View view) {

        Intent intent = new Intent(this, Welcome.class);

        // get inputs from username and password fields
        EditText username = (EditText) findViewById(R.id.editTextTextPersonName4);
        EditText password = (EditText) findViewById(R.id.editTextTextPersonName5);
        String message = "";
        if(username.length() != 0 && password.length() != 0) {
             message = "Username: \t" + username.getText().toString() + "\nPassword: \t"
                    + password.getText().toString() + "\n\nYour account has been successfully created.";
        }
        else {
            message = "Unable to create the account.\nUsername and password did not meet specification";
        }
        intent.putExtra(EXTRA_MESSAGE, message);
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