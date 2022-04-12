package comp3350.fairprice.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Arrays;
import java.util.List;

import comp3350.fairprice.R;

import comp3350.fairprice.presentation.MainActivity;

//This activity allows a user to create a new post
public class NewPostActivity extends AppCompatActivity {
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);

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

        //send it to the main activity so it can be shown
        Intent newPostIntent = new Intent(this, MainActivity.class);
        newPostIntent.putExtra("class", "NPA");
        newPostIntent.putExtra("title", title);
        newPostIntent.putExtra("description", description);
        newPostIntent.putExtra("price", price);
        newPostIntent.putExtra("category", category);

        startActivity(newPostIntent);


    }
}