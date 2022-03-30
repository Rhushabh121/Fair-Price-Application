package comp3350.fairprice;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import comp3350.fairprice.business.AccessPostsTest;
import comp3350.fairprice.objects.PostTest;
import comp3350.fairprice.objects.UserTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        PostTest.class,
        AccessPostsTest.class,
        UserTest.class
})

public class AllTests {
}
