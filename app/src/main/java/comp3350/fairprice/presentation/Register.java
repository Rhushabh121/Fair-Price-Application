package comp3350.fairprice.presentation;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.List;

import comp3350.fairprice.R;
import comp3350.fairprice.business.AccessUsers;
import comp3350.fairprice.objects.User;
import comp3350.fairprice.presentation.HomepageActivity;
import comp3350.fairprice.presentation.Welcome;


public class Register extends AppCompatActivity {


    private AccessUsers accessUsers;
    private List<User> userList;

    private ArrayAdapter<User> userArrayAdapter;

    private int selectedCoursePosition = -1;
    public static int userID = 0;

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

        //send it to the main activity so it can be shown
        Intent registerIntent = new Intent(this, Welcome.class);

        //store the input passed by the user
        String username = ((EditText)findViewById(R.id.editTextTextPersonName4)).getText().toString();
        String password = ((EditText)findViewById(R.id.editTextTextPersonName5)).getText().toString();



        String message = "";
        if(username.length() != 0 && password.length() != 0) {
             message = "Username: \t" + username + "\nPassword: \t"
                    + password + "\n\nYour account has been successfully created.";
        }
        else {
            message = "Unable to create the account.\nUsername and password did not meet specification";
        }

        registerIntent.putExtra("username", username);
        registerIntent.putExtra("password", password);
        registerIntent.putExtra("message", message);


        User user = new User("", username,"", password, "");
        String result;

        try {
            user = accessUsers.addUser(user);
            userList = accessUsers.getUsers();
            userArrayAdapter.notifyDataSetChanged();

        }
        catch (final Exception e) {

        }

        startActivity(registerIntent);

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