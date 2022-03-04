package comp3350.fairprice.business;

import static org.junit.Assert.*;

import org.junit.Test;

import comp3350.fairprice.objects.Post;

public class AccessPostsTest {

    @Test
    public void testAccessPosts() {
        AccessPosts accessPosts;

        System.out.println("\nStarting testAccessPosts");

        accessPosts = new AccessPosts();
        assertNotNull(accessPosts);

        Post newPost = new Post("Title", "Description", 10);
        accessPosts.addPost(newPost);

        assertTrue(newPost.equals(accessPosts.getPosts().get(accessPosts.getPosts().size()-1)));

    }
}