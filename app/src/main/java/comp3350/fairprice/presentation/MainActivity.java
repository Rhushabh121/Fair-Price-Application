package comp3350.fairprice.presentation;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import comp3350.fairprice.R;
import comp3350.fairprice.application.Main;
import comp3350.fairprice.business.AccessPU;
import comp3350.fairprice.business.AccessPosts;
import comp3350.fairprice.business.AccessUsers;
import comp3350.fairprice.databinding.ActivityMainBinding;
import comp3350.fairprice.objects.PU;
import comp3350.fairprice.objects.Post;
import comp3350.fairprice.objects.User;

//This is the main page o the application that contains the list of posts.
public class MainActivity extends AppCompatActivity {

    private AccessPosts accessPosts;
    private AccessPU accessUserPosts;
    private AccessUsers accessUsers;

    private List<Post> postList;
    private List<PU> userPosts;
    private List<User> userList;

    ActivityMainBinding binding;
    SearchView searchView;

    private String selectedCategory = "all";
    private String currentSearchText ="";
    TextView currentCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        copyDatabaseToDevice();


        Intent mainIntent = this.getIntent();

        accessPosts = new AccessPosts();
        accessUserPosts = new AccessPU();
        accessUsers = new AccessUsers();


        setContentView(R.layout.activity_main);


        if (mainIntent != null) {
            //check what intent it is
            String className = mainIntent.getStringExtra("class");
            //This is for new post activity
            if (className != null && className.equals("NPA"))
            {
                String title = mainIntent.getStringExtra("title");
                String description = mainIntent.getStringExtra("description");
                String price = mainIntent.getStringExtra("price");
                String category = mainIntent.getStringExtra("category");

                String username = mainIntent.getStringExtra("username");

                userList.addAll(accessUsers.getUsers());
                String userID="";

                for (int i = 0; i < userList.size(); i++)
                {
                    if ( userList.get(i).getName().equalsIgnoreCase(username) )
                        userID = userList.get(i).getUserId();
                }

                userPosts = new ArrayList<>();
                if(!userID.equalsIgnoreCase(""))
                    userPosts.addAll(accessUserPosts.getUP(userID));

                if (title != null) {
                    accessPosts.addPost(title, description, Integer.parseInt(price), category);

                }
            }

        }


        postList = new ArrayList<>();
        postList.addAll(accessPosts.getPosts());


        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ListAdapter listAdapter = new ListAdapter(MainActivity.this, postList);

        binding.postList.setAdapter(listAdapter);
        binding.postList.setClickable(true);
        searchView=  findViewById(R.id.searchItem);
        searchItem();

        if (mainIntent != null) {
            String className = mainIntent.getStringExtra("class");
//This is if the intent is from the Categories class
            if (className != null && className.equals("Categories")) {
                String status = mainIntent.getStringExtra("status");
                selectedCategory = status;

                filterList(status);
            }
        }


        if (mainIntent != null) {
            String className = mainIntent.getStringExtra("class");
//This is if the intent is from the Payment class
            if (className != null && className.equals("Bought")) {
                int id = mainIntent.getIntExtra("id",0);
                Post dPost = null;

                //If an item is bought, grab the id and find the post
                for (Post post : postList) {
                    if(post.getPostId() == id ){
                        dPost = post;
                    }
                }

                if(dPost != null){
       //If the item is found, delete it
                    deletePost(dPost);
                }else{
                    //if the Item isn't found, (which should not be the case ever), let the user know
                    Toast.makeText(MainActivity.this, "Item could not be purchased!", Toast.LENGTH_LONG).show();
                }

            }
        }



        currentCategory=(TextView) findViewById(R.id.currentCategory);
        currentCategory.setText("Category: " + selectedCategory.toUpperCase());



        binding.postList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                binding.deleteButton.setEnabled(true);

                binding.deleteButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Post post= (Post) ((ListView) adapterView).getAdapter().getItem(i);
                        deletePost( post);
                    }
                });

            }
        });

        binding.postList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent description = new Intent(MainActivity.this, Description.class);
//This ensures the right object is grabbed from the list
                Post post= (Post) ((ListView) adapterView).getAdapter().getItem(i);
                String des = post.getDescription();
                String title= post.getTitle();
                String price = post.getPrice();
                String category = post.getCategory();
                int id =post.getPostId();

                description.putExtra("price",price);
                description.putExtra("title",title);
                description.putExtra("Description",des);
                description.putExtra("category",category);
                description.putExtra("id",id);
                startActivity(description);
                return false;
            }
        });


    }
//delete a post
    public void deletePost(Post post){

        searchView.setQuery("",false);
        searchView.clearFocus();

        accessPosts.deletePost(post);
        postList.clear();
        postList.addAll(accessPosts.getPosts());

        ListAdapter listAdapter = new ListAdapter(MainActivity.this, postList);
        binding.postList.setAdapter(listAdapter);
        binding.postList.setClickable(true);

        binding.deleteButton.setEnabled(false);
    }

        //When this method is activated by the newPost button, it goes to the newPostActivity
    public void buttonNewPost(View v) {
        Intent mainIntent = new Intent(this, NewPostActivity.class);
        startActivity(mainIntent);
    }

    public void goToHome(View v) {
        Intent mainIntent = new Intent(this, HomepageActivity.class);
        startActivity(mainIntent);
    }

    public void buttonCategories(View v) {
        Intent mainIntent = new Intent(this, Categories.class);
        startActivity(mainIntent);
    }

    public void buttonProfile(View v) {
        Intent mainIntent = new Intent(this, Welcome.class);
        startActivity(mainIntent);
    }

    private void searchItem() {
//Find a post from the postLists using the search bar
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                currentSearchText=s;
                ArrayList<Post> filteredPosts = new ArrayList<Post>();

                for (Post post : postList) {
                    if (post.getTitle().toLowerCase().contains(s.toLowerCase())) {
                        if (selectedCategory.equals("all")) {
                            filteredPosts.add(post);
                        } else {
                            if (post.getCategory().toLowerCase().contains(selectedCategory)) {
                                filteredPosts.add(post);
                            }
                        }

                    }
                }

                ListAdapter listAdapter = new ListAdapter(MainActivity.this, filteredPosts);
                listAdapter.notifyDataSetChanged();
                binding.postList.setAdapter(listAdapter);
                binding.postList.setClickable(true);

                return false;
            }
        });


    }

    private void filterList(String status) {
//Filter the posts based on the category
        selectedCategory = status;
        currentCategory=(TextView) findViewById(R.id.currentCategory);
        currentCategory.setText("Category: " + selectedCategory.toUpperCase());

        ArrayList<Post> filteredPosts = new ArrayList<Post>();
        for (Post post : postList) {
            if (post.getCategory().toLowerCase().contains(status)) {

                if(currentSearchText == ""){
                    filteredPosts.add(post);
                }
                else{
                    if (post.getCategory().toLowerCase().contains(currentSearchText.toLowerCase())) {
                        filteredPosts.add(post);
                    }

                }

            }
        }
        ListAdapter listAdapter = new ListAdapter(MainActivity.this, filteredPosts);
        binding.postList.setAdapter(listAdapter);
        binding.postList.setClickable(true);


    }

    public void allItems(View v) {
        selectedCategory = "all";
        searchView.setQuery("",false);
        searchView.clearFocus();


        currentCategory=(TextView) findViewById(R.id.currentCategory);
        currentCategory.setText("Category: " + selectedCategory.toUpperCase());

        ListAdapter listAdapter = new ListAdapter(MainActivity.this, postList);
        binding.postList.setAdapter(listAdapter);
        binding.postList.setClickable(true);
    }


    private void copyDatabaseToDevice() {
        final String DB_PATH = "db";

        String[] assetNames;
        Context context = getApplicationContext();
        File dataDirectory = context.getDir(DB_PATH, Context.MODE_PRIVATE);
        AssetManager assetManager = getAssets();

        try {

            assetNames = assetManager.list(DB_PATH);
            for (int i = 0; i < assetNames.length; i++) {
                assetNames[i] = DB_PATH + "/" + assetNames[i];
            }

            copyAssetsToDirectory(assetNames, dataDirectory);

            Main.setDBPathName(dataDirectory.toString() + "/" + Main.getDBPathName());

        } catch (final IOException ioe) {
            Log.d("tester", "Unable to access application data: " + ioe.getMessage());
        }
    }

    public void copyAssetsToDirectory(String[] assets, File directory) throws IOException {
        AssetManager assetManager = getAssets();

        for (String asset : assets) {
            String[] components = asset.split("/");
            String copyPath = directory.toString() + "/" + components[components.length - 1];

            char[] buffer = new char[1024];
            int count;

            File outFile = new File(copyPath);

            if (!outFile.exists()) {
                InputStreamReader in = new InputStreamReader(assetManager.open(asset));
                FileWriter out = new FileWriter(outFile);

                count = in.read(buffer);
                while (count != -1) {
                    out.write(buffer, 0, count);
                    count = in.read(buffer);
                }

                out.close();
                in.close();
            }
        }
    }

    public void openProfile(View view) {
        Intent openWelcomePage = new Intent(this, Welcome.class);
        startActivity(openWelcomePage);
    }
}