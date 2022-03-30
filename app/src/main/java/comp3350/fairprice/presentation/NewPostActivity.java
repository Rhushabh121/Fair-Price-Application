package comp3350.fairprice.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import comp3350.fairprice.R;

import comp3350.fairprice.presentation.MainActivity;

//This activity allows a user to create a new post
public class NewPostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);
    }
//The method runs when the createPost button is clicked
    public void buttonCreatePost(View v) {
        //store the input passed by the user
        String title = ((EditText)findViewById(R.id.NewPostTitle)).getText().toString();
        String description = ((EditText)findViewById(R.id.NewPostDescription)).getText().toString();
        String price = ((EditText)findViewById(R.id.NewPostPrice)).getText().toString();

        //send it to the main activity so it can be shown
        Intent newPostIntent = new Intent(this, MainActivity.class);
        newPostIntent.putExtra("title", title);
        newPostIntent.putExtra("description", description);
        newPostIntent.putExtra("price", price);

        startActivity(newPostIntent);


    }
}