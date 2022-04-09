package comp3350.fairprice.business;

import android.util.Log;

import comp3350.fairprice.objects.Post;
import comp3350.fairprice.persistence.PostPersistence;
import comp3350.fairprice.application.Services;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

//This class contains the hard coded database
public class AccessPosts {
    //create anew arraylist that stores all the data
    private PostPersistence postPersistence;
    private List<Post> posts;
    private Post post;
    private int currentPost;

    public AccessPosts() {
        postPersistence = Services.getPostPersistence();
        posts = null;
        post = null;
        currentPost = 0;
    }
    public AccessPosts(final PostPersistence postPersistence)
    {
        this();
        this.postPersistence = postPersistence;
    }
    //getter
    public List<Post> getPosts() {
        posts = postPersistence.getPostList();
        return Collections.unmodifiableList(posts);
    }

    //This method takes in a post to add to the already existing database
    public Post addPost(String title, String description, double price, String category) {
        posts = postPersistence.getPostList();
        currentPost = posts.size();
        //Log.d("tester","Adding post with ID:" + currentPost+1);
        post = new Post(currentPost+1, title, description, price, category);
        return postPersistence.insertPost(post);
    }

    public void deletePost(Post currentPost)
    {
        postPersistence.deletePost(currentPost);
    }

}
