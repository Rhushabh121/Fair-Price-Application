//used sample project
package comp3350.fairprice.persistence.hsqldb;

import android.util.Log;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import comp3350.fairprice.objects.PU;
import comp3350.fairprice.objects.Post;
import comp3350.fairprice.objects.User;
import comp3350.fairprice.persistence.PUPersistence;

public class PUPersistenceHSQLDB implements PUPersistence {
    private final String dbPath;

    public PUPersistenceHSQLDB(final String dbPath) {
        this.dbPath = dbPath;
    }

    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }

    private PU fromResultSet(final ResultSet rs) throws SQLException {
        final String rsUserID = rs.getString("userID");
        final int postId = rs.getInt("postID");
        final String Ddate = rs.getString("postDate");

        final User user = new User(rsUserID);
        final Post post = new Post(postId);
        final String date = Ddate;
        return new PU(user, post, date);
    }
    @Override
    public List<PU> getUP(String userId)
    {
        final List<PU> userPosts = new ArrayList<>();
        try (final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("SELECT * FROM posts,userposts WHERE posts.postID=userposts.postID AND userID = ?");
            st.setString(1, userId);

            final ResultSet rs = st.executeQuery();

            while (rs.next()) {
                final PU record = fromResultSet(rs);
                userPosts.add(record);
            }

            rs.close();
            st.close();

            return userPosts;
        }
        catch (final SQLException e)
        {
            throw new PersistenceException(e);
            //System.out.println(e);
        }
        //return userPosts;
    }


    public PU insertPU(PU pu)
    {
        try (final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("INSERT INTO userposts VALUES(?, ?, ?)");
            st.setInt(1, pu.getPostID());
            st.setString(2, pu.getUserID());
            st.setString(3, pu.getPostDate());



            st.executeUpdate();

            return pu;
        } catch (final SQLException e) {
            throw new PersistenceException(e);
            //Log.d("tester", e.toString());
        }
        //return post;
    }

}
