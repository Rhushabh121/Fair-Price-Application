package comp3350.fairprice.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import comp3350.fairprice.R;

import comp3350.fairprice.presentation.MainActivity;

public class NewPostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);
    }

    public void buttonCreatePost(View v) {
        String title = ((EditText)findViewById(R.id.NewPostTitle)).getText().toString();
        String description = ((EditText)findViewById(R.id.NewPostDescription)).getText().toString();
        String price = ((EditText)findViewById(R.id.NewPostPrice)).getText().toString();

        Intent newPostIntent = new Intent(this, MainActivity.class);
        newPostIntent.putExtra("title", title);
        newPostIntent.putExtra("description", description);
        newPostIntent.putExtra("price", price);

        startActivity(newPostIntent);


    }
}