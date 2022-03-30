package comp3350.fairprice.business;

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
//    private Post post;
//    private int currentPost;
    public AccessPosts() {
       postPersistence = Services.getPostPersistence();
       posts = null;
//       post = null;
//       currentPost=0;
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
    public Post addPost(Post newPost) {
        return postPersistence.insertPost(newPost);
    }

    public void deletePost(Post currentPost)
    {
        postPersistence.deletePost(currentPost);
    }

}
