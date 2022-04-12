package comp3350.fairprice.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import comp3350.fairprice.R;
import comp3350.fairprice.business.AccessPosts;
import comp3350.fairprice.business.AccessUsers;
import comp3350.fairprice.databinding.ActivityMainBinding;
import comp3350.fairprice.objects.Post;
import comp3350.fairprice.objects.User;
import comp3350.fairprice.presentation.Register;



/**
 * This class is a landing page for user once the login page authenticates the username
 * and password. This will display multiple options for user to proceed throughout the app.
 */

public class Welcome extends AppCompatActivity {

    private AccessUsers accessUsers;
    private List<User> userList;
    ActivityMainBinding binding;
    SearchView searchView;
    public static int userID = 0;

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


        if (intent != null)
        {

            String username = intent.getStringExtra("username").toString();
            String password = intent.getStringExtra("username").toString();

            //This is for new post activity
            if (username.length() != 0 && password.length() != 0)
            {

                User user = new User(Integer.toString(userID), username, "", password, "");
                userID++;
                accessUsers.addUser(user);          //// change the parameter to User object
            }
        }

        userList = new ArrayList<>();
        userList.addAll(accessUsers.getUsers());

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