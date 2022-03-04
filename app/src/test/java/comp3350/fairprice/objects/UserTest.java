package comp3350.fairprice.objects;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

public class UserTest {
    @Test
    public void testUser() {
        User user;

        System.out.println("\nStarting testUser");

        user= new User("Bob", "BobbyD@gmail.com", "BobbyisCool", "15210094");

        assertNotNull(user);
        assertTrue("Bob".equals(user.getName()));
        assertTrue("BobbyD@gmail.com".equals(user.getEmail()));
        assertTrue("BobbyisCool".equals(user.getPassword()));
        assertTrue("15210094".equals(user.getCreditCard()));

        System.out.println("Finished testUser");
    }
}