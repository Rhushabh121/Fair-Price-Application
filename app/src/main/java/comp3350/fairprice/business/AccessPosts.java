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

     private static int counterID ;

    public AccessPosts() {
        postPersistence = Services.getPostPersistence();
        posts = null;
        post = null;

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
//determine the postId for the new post
        if(posts.isEmpty()){
            counterID=0;
        }else{
            Post lastPost = posts.get(posts.size()-1);
            counterID = lastPost.getPostId();
        }

        counterID++;
        Log.d("tester","Adding post with ID:" + (counterID));
        post = new Post(counterID, title, description, price, category);
        return postPersistence.insertPost(post);
    }

    public void deletePost(Post currentPost)
    {
        postPersistence.deletePost(currentPost);
    }

}
