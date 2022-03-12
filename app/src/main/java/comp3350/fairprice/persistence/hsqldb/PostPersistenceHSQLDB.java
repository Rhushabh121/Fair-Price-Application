package comp3350.fairprice.persistence.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import comp3350.fairprice.objects.Post;
import comp3350.fairprice.persistence.PostPersistence;

public class PostPersistenceHSQLDB implements PostPersistence {
    private final String dbPath;

    public PostPersistenceHSQLDB(final String dbPath) {
        this.dbPath = dbPath;
    }

    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }

    public List<Post> getPostList()
    {
        final List<Post> posts = new ArrayList<>();
        //implement the code
        return posts;
    }
    public Post insertPost(Post post)
    {
        //implement the code
        return post;
    }
    public void deletePost(Post post)
    {

    }
}
