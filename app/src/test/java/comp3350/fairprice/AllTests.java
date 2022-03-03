package comp3350.fairprice;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import comp3350.fairprice.business.AccessPostsTest;
import comp3350.fairprice.objects.PostTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        PostTest.class,
        AccessPostsTest.class
})

public class AllTests {
}
