package comp3350.fairprice.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import comp3350.fairprice.R;

import comp3350.fairprice.business.AccessUsers;
import comp3350.fairprice.objects.User;
import comp3350.fairprice.presentation.MainActivity;

//This activity allows a user to create a new post
public class NewPostActivity extends AppCompatActivity {
    Spinner spinner;
    private List<User> users;
    AccessUsers accessUsers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);

        users = new ArrayList<>() ;
        accessUsers = new AccessUsers();

        List<String> Categories = Arrays.asList("Miscellaneous", "Electronics" , "Video Games","Clothing" , "Vehicles","Books", "Furnitures" );
        spinner = (Spinner) findViewById(R.id.spinner1);

        ArrayAdapter myAdapter = new ArrayAdapter(this, R.layout.spinner_item, Categories);
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(myAdapter);
    }

//The method runs when the createPost button is clicked
    public void buttonCreatePost(View v) {
        //store the input passed by the user
        String title = ((EditText)findViewById(R.id.NewPostTitle)).getText().toString();
        String description = ((EditText)findViewById(R.id.NewPostDescription)).getText().toString();
        String price = ((EditText)findViewById(R.id.NewPostPrice)).getText().toString();
        String category = spinner.getSelectedItem().toString();
        String username = ((EditText)findViewById(R.id.usernameIdentifier)).getText().toString();


        users = accessUsers.getUsers();

        boolean found = false;
        if(users.size() > 0)            // atleast 1 user exists
        {
            for(int i = 0; i < users.size(); i++)
            {
                if(users.get(i).getName().equalsIgnoreCase(username))
                {
                    found = true;

                    //send it to the main activity so it can be shown
                    Intent newPostIntent = new Intent(this, MainActivity.class);
                    newPostIntent.putExtra("class", "NPA");
                    newPostIntent.putExtra("title", title);
                    newPostIntent.putExtra("description", description);
                    newPostIntent.putExtra("price", price);
                    newPostIntent.putExtra("category", category);
                    newPostIntent.putExtra("username", username);


                    startActivity(newPostIntent);
                }
            }
        }
        if(!found)              // take him back to home page
        {
            TextView displayMessage = findViewById(R.id.messageUserValid);
            displayMessage.setText("User does not exist, enter valid username.");
        }




    }
}