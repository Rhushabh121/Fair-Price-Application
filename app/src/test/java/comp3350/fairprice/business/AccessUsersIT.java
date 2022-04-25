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
import comp3350.fairprice.objects.User;

import comp3350.fairprice.persistence.PostPersistence;
import comp3350.fairprice.persistence.UserPersistence;

import comp3350.fairprice.persistence.hsqldb.PostPersistenceHSQLDB;
import comp3350.fairprice.persistence.hsqldb.UserPersistenceHSQLDB;
import comp3350.fairprice.utils.TestUtils;

public class AccessUsersIT {
    private AccessUsers accessUsers;
    private File tempDB;
    private AccessPosts accessPosts;


    @Before
    public void setUp() throws IOException {
        this.tempDB = TestUtils.copyDB();
        final UserPersistence persistence = new UserPersistenceHSQLDB(this.tempDB.getAbsolutePath().replace(".script", ""));
        this.accessUsers = new AccessUsers(persistence);
        this.tempDB = TestUtils.copyDB();
        final PostPersistence persistence1 = new PostPersistenceHSQLDB(this.tempDB.getAbsolutePath().replace(".script", ""));
        this.accessPosts = new AccessPosts(persistence1);
    }

    @Test
    public void getUsers() throws IOException{
        tempDB = TestUtils.copyDB();
        UserPersistence persistence = new UserPersistenceHSQLDB(this.tempDB.getAbsolutePath().replace(".script", ""));
        accessUsers = new AccessUsers(persistence);
        final List<User> courses = accessUsers.getUsers();
        Assertions.assertEquals(1, courses.size());
    }

    @Test
    public void addUser() throws IOException{
        tempDB = TestUtils.copyDB();
        UserPersistence persistence = new UserPersistenceHSQLDB(this.tempDB.getAbsolutePath().replace(".script", ""));
        accessUsers = new AccessUsers(persistence);
        final User c = new User("user1", "tony", "123", "xyz12@outlook.com", "1234");
        accessUsers.addUser(c);
        Assertions.assertEquals(2, accessUsers.getUsers().size());
    }

    @Test
    public void deleteUser() throws IOException{
        tempDB = TestUtils.copyDB();
        UserPersistence persistence = new UserPersistenceHSQLDB(this.tempDB.getAbsolutePath().replace(".script", ""));
        accessUsers = new AccessUsers(persistence);
        final User c = accessUsers.getUsers().get(0);
        List<User> courses = accessUsers.getUsers();
        Assertions.assertEquals(1, courses.size());
        accessUsers.deleteUser(c);
        courses = accessUsers.getUsers();
        Assertions.assertEquals(0, courses.size());
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
        accessPosts.addPost("book","the alchemist",20, "books");
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