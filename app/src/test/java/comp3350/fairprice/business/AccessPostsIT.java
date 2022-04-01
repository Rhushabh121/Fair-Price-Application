//used sample project
package comp3350.fairprice.business;

import org.junit.After;
import org.junit.Before;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.util.List;

import comp3350.fairprice.objects.Post;
import comp3350.fairprice.persistence.PostPersistence;
import comp3350.fairprice.persistence.hsqldb.PostPersistenceHSQLDB;
import comp3350.fairprice.utils.TestUtils;

class AccessPostsIT {

    private AccessPosts accessPosts;
    private File tempDB;
    @Before
    public void setUp() throws IOException {
        this.tempDB = TestUtils.copyDB();
        final PostPersistence persistence = new PostPersistenceHSQLDB(this.tempDB.getAbsolutePath().replace(".script", ""));
        this.accessPosts = new AccessPosts(persistence);
    }

    @Test
    public void getPosts() throws IOException {
        tempDB = TestUtils.copyDB();
        final PostPersistence persistence = new PostPersistenceHSQLDB(this.tempDB.getAbsolutePath().replace(".script", ""));
        accessPosts = new AccessPosts(persistence);
        final List<Post> courses = accessPosts.getPosts();
        Assertions.assertEquals(1, courses.size());
    }

    @Test
    public void addPost() throws IOException{
        tempDB = TestUtils.copyDB();
        final PostPersistence persistence = new PostPersistenceHSQLDB(this.tempDB.getAbsolutePath().replace(".script", ""));
        accessPosts = new AccessPosts(persistence);
        accessPosts.addPost("book","the alchemist",20);
        Assertions.assertEquals(2, accessPosts.getPosts().size());
    }

    @Test
    public void deletePost() throws IOException{
        tempDB = TestUtils.copyDB();
        final PostPersistence persistence = new PostPersistenceHSQLDB(this.tempDB.getAbsolutePath().replace(".script", ""));
        accessPosts = new AccessPosts(persistence);
        final Post c = accessPosts.getPosts().get(0);
        List<Post> courses = accessPosts.getPosts();
        Assertions.assertEquals(1, courses.size());
        accessPosts.deletePost(c);
        courses = accessPosts.getPosts();
        Assertions.assertEquals(0, courses.size());
    }
    @After
    public void tearDown() {
        this.tempDB.delete();
    }
}