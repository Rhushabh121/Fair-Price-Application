package comp3350.fairprice.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

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


    public  static int userCount = 0;
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    /**
     * Validate the user when the "Create Account" button is clicked in  activity_register.xml.
     *
     * Ensure username does not exist in database
     * If user is valid
     *      take them to welcome page
     * Else
     *      Display error
     * @param view
     */
    public void registerUser(View view) {

        // --------------- DATABASE Changes -----------------

        User user = createUserFromEditText();
        String result;

        result = validateUserData(user, true);

        if (result == null)
        {
            try {
                user = accessUsers.addUser(user);
                userList = accessUsers.getUsers();
                userArrayAdapter.notifyDataSetChanged();

                int pos = userList.indexOf(user);


            } catch (final Exception e) {
                System.out.println(e.getMessage());
            }
        }

        else
        {
            System.out.println(result);
        }

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
     * Create a user object when the create account button is clicked in activity_register and
     *
     * @return User object is returned
     */
    private User createUserFromEditText() {

        // get inputs from the fields required for registration of user
        EditText username = (EditText)findViewById(R.id.editTextTextPersonName4);
        EditText password = (EditText)findViewById(R.id.editTextTextPersonName5);


        User user = new User(Integer.toString(userCount), username.getText().toString(), "", password.getText().toString(), "");
        userCount++;
        return user;
    }


    /**
     *
     * @param user
     * @param isNewUser
     * @return
     */
    private String validateUserData(User user, boolean isNewUser) {
        if (user.getName().length() == 0) {
            return "Username required";
        }

        if (user.getPassword().length() == 0) {
            return "Password required";
        }

        return null;
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
