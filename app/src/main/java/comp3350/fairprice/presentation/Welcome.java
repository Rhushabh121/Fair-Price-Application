package comp3350.fairprice.presentation;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import comp3350.fairprice.R;
import comp3350.fairprice.business.AccessUsers;
import comp3350.fairprice.objects.User;



/**
 * This class is a landing page for user once the login page authenticates the username
 * and password. This will display multiple options for user to proceed throughout the app.
 */

public class Welcome extends AppCompatActivity {

    private AccessUsers accessUsers;
    private List<User> userList;
    public static int userID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        accessUsers = new AccessUsers();
        userList = new ArrayList<User>();

        // Get the Intent that started this activity and extract the string
        Intent loginOrRegisterIntent = this.getIntent();
        String message = loginOrRegisterIntent.getStringExtra("message");


        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView);
        textView.setText(message);

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

    /**
     * When the user clicks My Listings button, take him to the list of listings he posted on the app.
     * Search from the collection of all PU objects, then find the username that matches with the user of
     * an object from PU list, display all those listings.
     * @param view
     */
    public void myListings(View view) {
    }
}