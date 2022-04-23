package comp3350.fairprice.presentation;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import comp3350.fairprice.R;
import comp3350.fairprice.business.AccessPU;
import comp3350.fairprice.business.AccessPosts;
import comp3350.fairprice.business.AccessUsers;

import comp3350.fairprice.objects.PU;
import comp3350.fairprice.objects.Post;
import comp3350.fairprice.objects.User;

public class MyListings extends AppCompatActivity {

    private AccessPosts accessPosts;
    private AccessUsers accessUsers;
    private AccessPU accessPostsUsers;
    private Button repost;
    private Button del;

    private List<Post> postList;
    private List<User> userList;
    private List<PU> puList;
    ArrayList<Post> myListings;

    private String GUsername;
    ListView listView;
    ListAdapter listAdapter;

    AlertDialog.Builder alertBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_listings);
        Intent a = this.getIntent();

        accessPosts = new AccessPosts();
        accessUsers = new AccessUsers();
        accessPostsUsers = new AccessPU();

        postList = new ArrayList<Post>();
        userList = new ArrayList<User>();
        puList = new ArrayList<PU>();


        postList = new ArrayList<>();
        postList.addAll(accessPosts.getPosts());
        listView = (ListView) findViewById(R.id.myListingView);
        myListings = new ArrayList<Post>();

        listAdapter = new ListAdapter(this, myListings);

        repost = (Button) findViewById(R.id.repost);
        del = (Button) findViewById(R.id.delete);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                view.setSelected(true);

                repost.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Post post = (Post) ((ListView) adapterView).getAdapter().getItem(i);
                        String res = post.getTitle();
                        Toast.makeText(MyListings.this, "Worked " + res, Toast.LENGTH_LONG).show();
                        //  deletePost(post);
                        repostClick(post);
                    }
                });


                    del.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Post post = (Post) ((ListView) adapterView).getAdapter().getItem(i);
                            int id = post.getPostId();
                            Toast.makeText(view.getContext(), "Item Deleted", Toast.LENGTH_LONG).show();

                            Intent dmain = new Intent(view.getContext(), MainActivity.class);
                            dmain.putExtra("class", "Deleted");
                            dmain.putExtra("id", id);
                            startActivity(dmain);
                        }
                    });
                }

        });


        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent description = new Intent(view.getContext(), Description.class);
//This ensures the right object is grabbed from the list
                Post post = (Post) ((ListView) adapterView).getAdapter().getItem(i);
                String des = post.getDescription();
                String title = post.getTitle();
                String price = post.getPrice();
                String category = post.getCategory();
                int id = post.getPostId();

                description.putExtra("class", "MyListing");
                description.putExtra("price", price);
                description.putExtra("title", title);
                description.putExtra("Description", des);
                description.putExtra("category", category);
                description.putExtra("id", id);
                startActivity(description);
                return false;
            }
        });


    }

    public void getListings(View view) {


        EditText username = (EditText) findViewById(R.id.editTextTextPersonName2);
        //put the users post in puList
        puList.clear();
        puList.addAll(accessPostsUsers.getUP(username.getText().toString()));
        GUsername = username.getText().toString();
        //Toast.makeText(this,String.valueOf( puList.size()), Toast.LENGTH_LONG).show();


        myListings.clear();
        for (int i = 0; i < puList.size(); i++) {
            //go through each item in the user has posted, use the postID to see the item and its values

            Log.d("listing", "User that posted all: " + puList.get(i).getUserID());
            Post addedPost = null;
            for (Post post : postList) {
                if (post.getPostId() == puList.get(i).getPostID()) {
                    addedPost = post;
                    myListings.add(addedPost);
                    break;
                }
            }

            Log.d("listing", "Post Title: " + addedPost.getTitle());

        }

        Collections.reverse(myListings);
        listView.setAdapter(listAdapter);
        listAdapter.notifyDataSetChanged();


        Log.d("listing", "(----)");

    }

    public void explore(View view) {
        Intent main = new Intent(this, MainActivity.class);
        startActivity(main);
    }


    public void repostClick(Post post) {
        Intent repost = new Intent(this, payment.class);
        int id = post.getPostId();
        alertBuilder = new AlertDialog.Builder(MyListings.this);
        alertBuilder.setTitle("Confirm before Continuing");
        alertBuilder.setMessage(
                "This feature allows you to put your post back" +
                        " to the Top of the List, where everyone can see it! " +
                        "To re-post this will cost $20 . \n" +
                        "Would you like to continue?");

        alertBuilder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                repost.putExtra("price", "$20");
                repost.putExtra("class", "Repost");
                repost.putExtra("username", GUsername);
                repost.putExtra("id", id);
                startActivity(repost);

            }
        });
        alertBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        AlertDialog alertDialog = alertBuilder.create();
        alertDialog.show();


    }
}