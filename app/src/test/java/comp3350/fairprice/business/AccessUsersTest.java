//used sample project
package comp3350.fairprice.business;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

//import org.junit.jupiter.api.AfterEach;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import comp3350.fairprice.objects.User;
import comp3350.fairprice.persistence.UserPersistenceStub;

public class AccessUsersTest {

    private AccessUsers accessUsers;
    @Before
    public void setUp() {
        this.accessUsers = new AccessUsers(new UserPersistenceStub());
    }

    @Test
    public void test1() {
        accessUsers = new AccessUsers(new UserPersistenceStub());
        final User user = accessUsers.getUsers().get(0);
        assertNotNull(user);
        assertTrue("user1".equals(user.getUserId()));
    }

}