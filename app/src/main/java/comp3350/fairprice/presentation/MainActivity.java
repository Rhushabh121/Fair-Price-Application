package comp3350.fairprice.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import comp3350.fairprice.business.AccessPosts;
import comp3350.fairprice.objects.Post;
import comp3350.fairprice.databinding.ActivityMainBinding;

import java.util.ArrayList;

//This is the main page o the application that contains the list of posts.
public class MainActivity extends AppCompatActivity {

    private AccessPosts accessPosts;
    private ArrayList<Post> postList;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        accessPosts = new AccessPosts();
        postList = accessPosts.getPosts();

        ListAdapter listAdapter = new ListAdapter(MainActivity.this, postList);

        binding.postList.setAdapter(listAdapter);
        binding.postList.setClickable(true);

        Intent mainIntent = this.getIntent();

        if (mainIntent != null) {
            String title = mainIntent.getStringExtra("title");
            String description = mainIntent.getStringExtra("description");
            String price = mainIntent.getStringExtra("price");
            if (title != null) {
                accessPosts.addPost(new Post(title, description, Integer.valueOf(price)));
            }
        }
    }
//When this method is activated by the newPost button, it goes to the newPostActivity
    public void buttonNewPost(View v) {
        Intent mainIntent = new Intent(this, NewPostActivity.class);
        startActivity(mainIntent);
    }

    public void buttonCategories(View v) {
        Intent mainIntent = new Intent(this, Categories.class);
        startActivity(mainIntent);
    }


}