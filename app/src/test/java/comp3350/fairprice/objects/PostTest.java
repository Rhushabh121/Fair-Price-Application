package comp3350.fairprice.objects;

import static org.junit.Assert.*;

import org.junit.Test;

public class PostTest {
    @Test
    //Test the post class
    public void testPost() {
        Post post;

        System.out.println("\nStarting testPost");
        //check if the post is instantiated
        post = new Post(1,"Title", "Description", 10, "category");
        assertNotNull(post);
        //check if the parameters are set to the right things
        assertTrue("Title".equals(post.getTitle()));
        assertTrue("Description".equals(post.getDescription()));
        assertTrue("category".equals(post.getCategory()));
        System.out.println(post.getPrice());
        assertTrue("$10.00".equals(post.getPrice()));

        System.out.println("Finished testPost");
    }
}