package comp3350.fairprice.presentation;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import comp3350.fairprice.R;
import comp3350.fairprice.business.AccessPU;
import comp3350.fairprice.business.AccessPosts;
import comp3350.fairprice.business.AccessUsers;
import comp3350.fairprice.databinding.ActivityMainBinding;
import comp3350.fairprice.objects.PU;
import comp3350.fairprice.objects.Post;
import comp3350.fairprice.objects.User;

public class MyListings extends AppCompatActivity {

    private AccessPosts accessPosts;
    private AccessUsers accessUsers;
    private AccessPU accessPostsUsers;

    private List<Post> postList;
    private List<User> userList;
    private List<PU> puList;

    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_listings);


        accessPosts = new AccessPosts();
        accessUsers = new AccessUsers();
        accessPostsUsers = new AccessPU();

        postList = new ArrayList<Post>();
        userList = new ArrayList<User>();
        puList = new ArrayList<PU>();


    }

    public void getListings(View view)
    {
        EditText username = (EditText) findViewById(R.id.editTextTextPersonName2);
        userList = accessUsers.getUsers();

        puList.addAll(accessPostsUsers.getUP(username.getText().toString()));

            postList.clear();       // empty the list now

        for(int i = 0; i<puList.size(); i++)
        {
            postList.add(puList.get(i).getPost());
        }
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ListAdapter listAdapter = new ListAdapter(this, postList);

        binding.postList.setAdapter(listAdapter);
        binding.postList.setClickable(true);

    }
}