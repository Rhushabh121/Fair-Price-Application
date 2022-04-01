package comp3350.fairprice.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import comp3350.fairprice.objects.Post;
import comp3350.fairprice.objects.User;
import comp3350.fairprice.persistence.PostPersistence;
import comp3350.fairprice.persistence.PostPersistenceStub;
import comp3350.fairprice.persistence.UserPersistenceStub;

public class AccessPostsTest {
    //private AccessPosts accessPosts;
    private PostPersistence postPersistence;

    @Before
    public void setUp() {
        //this.accessPosts = new AccessPosts(new PostPersistenceStub());
        this.postPersistence = new PostPersistenceStub();
    }

    @Test
    public void test1() {

        final Post post;
        postPersistence = new PostPersistenceStub();
        assertNotNull(postPersistence);
        post = postPersistence.getPostList().get(0);
        assertNotNull(post);
        assertTrue(1 == post.getPostId());
    }


}
