package comp3350.fairprice.business;

import static org.junit.Assert.*;

import org.junit.Test;

import comp3350.fairprice.objects.Post;

public class AccessPostsTest {
//Test if the database works well
    @Test
    public void testAccessPosts() {
        AccessPosts accessPosts;

        System.out.println("\nStarting testAccessPosts");
//test if the arrayList is created
        accessPosts = new AccessPosts();
        assertNotNull(accessPosts);

        Post newPost = new Post(1,"Title", "Description", 10);
        accessPosts.addPost(newPost);
//test if the post is added to the database
        assertTrue(newPost.equals(accessPosts.getPosts().get(accessPosts.getPosts().size()-1)));

    }
}