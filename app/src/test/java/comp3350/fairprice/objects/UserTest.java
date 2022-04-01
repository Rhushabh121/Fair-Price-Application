package comp3350.fairprice.objects;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
//Test the user class
public class UserTest {
    @Test
    public void testUser() {
        User user;

        System.out.println("\nStarting testUser");
        //check if the user is instantiated
        user= new User("user1", "Bob","BobbyD@gmail.com", "BobbyisCool", "15210094");

        assertNotNull(user);
        //check if the parameters are set to the right things
        assertTrue("user1".equals(user.getUserId()));
        assertTrue("Bob".equals(user.getName()));
        assertTrue("BobbyD@gmail.com".equals(user.getEmail()));
        assertTrue("BobbyisCool".equals(user.getPassword()));
        assertTrue("15210094".equals(user.getCreditCard()));

        System.out.println("Finished testUser");
    }
}