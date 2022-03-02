package comp3350.fairprice.objects;

import static org.junit.Assert.*;

import org.junit.Test;

public class PostTest {
    @Test
    public void testPost() {
        Post post;

        System.out.println("\nStarting testPost");

        post = new Post("Title", "Description", 10);
        assertNotNull(post);
        assertTrue("Title".equals(post.getTitle()));
        assertTrue("Description".equals(post.getDescription()));
        System.out.println(post.getPrice());
        assertTrue("$10.00".equals(post.getPrice()));

        System.out.println("Finished testPost");
    }
}