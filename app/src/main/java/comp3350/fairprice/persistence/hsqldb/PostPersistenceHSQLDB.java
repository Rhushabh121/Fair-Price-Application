package comp3350.fairprice.persistence.hsqldb;

import android.util.Log;

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

    private Post fromResultSet(final ResultSet rs) throws SQLException {
        final int postID = rs.getInt("postId");
        final String postTitle = rs.getString("title");
        final String postDescription = rs.getString("description");
        final float postPrice = rs.getFloat("price");

        return new Post(postID,postTitle,postDescription,postPrice);
    }

    public List<Post> getPostList()
    {
        final List<Post> posts = new ArrayList<>();

        try (final Connection c = connection()) {
            final Statement st = c.createStatement();
            final ResultSet rs = st.executeQuery("SELECT * FROM posts");
            while (rs.next())
            {
                final Post post = fromResultSet(rs);
                posts.add(post);
            }
            rs.close();
            st.close();


            return posts;
        }
        catch (final SQLException e)
        {
            Log.d("tester", e.toString());
        }
        return posts;
    }
    public Post insertPost(Post post)
    {
        try (final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("INSERT INTO posts VALUES(?, ?, ?, ?)");
            st.setInt(1, post.getPostId());
            st.setString(2, post.getTitle());
            st.setString(3, post.getDescription());
            st.setFloat(4, post.getPriceFloat());


            st.executeUpdate();

            return post;
        } catch (final SQLException e) {
            //throw new PersistenceException(e);
            Log.d("tester", e.toString());
        }
        return post;
    }
    public void deletePost(Post post)
    {
        try (final Connection c = connection()) {
            final PreparedStatement sc = c.prepareStatement("DELETE FROM userposts WHERE postID = ?");
            sc.setInt(1, post.getPostId());
            sc.executeUpdate();
            final PreparedStatement st = c.prepareStatement("DELETE FROM posts WHERE postID = ?");
            st.setInt(1, post.getPostId());
            st.executeUpdate();
        } catch (final SQLException e) {
            //throw new PersistenceException(e);
            Log.d("tester", e.toString());
        }
    }
}
