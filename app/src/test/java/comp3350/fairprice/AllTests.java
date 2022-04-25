package comp3350.fairprice;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.jupiter.api.Test;

import comp3350.fairprice.business.AccessPostsTest;
import comp3350.fairprice.business.AccessUsersTest;
import comp3350.fairprice.objects.PostTest;
import comp3350.fairprice.objects.UserTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        PostTest.class,
        AccessPostsTest.class,
        AccessUsersTest.class,
        UserTest.class
})

public class AllTests {
}
