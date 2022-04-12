package comp3350.fairprice.presentation;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import comp3350.fairprice.R;
import comp3350.fairprice.presentation.Welcome;
import comp3350.fairprice.presentation.HomepageActivity;




public class Login extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

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