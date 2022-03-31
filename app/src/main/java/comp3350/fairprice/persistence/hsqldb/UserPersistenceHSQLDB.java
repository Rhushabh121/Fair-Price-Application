
package comp3350.fairprice.persistence.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import comp3350.fairprice.objects.User;
import comp3350.fairprice.persistence.UserPersistence;

public class UserPersistenceHSQLDB implements UserPersistence {
    private final String dbPath;

    public UserPersistenceHSQLDB(final String dbPath) {
        this.dbPath = dbPath;
    }

    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }

    private User fromResultSet(final ResultSet rs) throws SQLException {
        final String studentID = rs.getString("userID");
        final String studentName = rs.getString("name");
        final String password = rs.getString("password");
        final String email = rs.getString("email");

        return new User(studentID, studentName, email, password, "");
    }
    @Override
    public List<User> getUserList() {
        final List<User> users = new ArrayList<>();
        try (final Connection c = connection()) {
            final Statement st = c.createStatement();
            final ResultSet rs = st.executeQuery("SELECT * FROM users");
            while (rs.next()) {
                final User user = fromResultSet(rs);
                users.add(user);
            }
            rs.close();
            st.close();

            return users;
        } catch (final SQLException e) {
            //will change this later
            //throw new PersistenceException(e);
            System.out.println(e);
        }
        return users;
    }

    @Override
    public User insertUser(User user) {
        try (final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("INSERT INTO users VALUES(?, ?, ?, ?)");
            st.setString(1, user.getUserId());
            st.setString(2, user.getName());
            st.setString(3, user.getPassword());
            st.setString(4, user.getEmail());
            st.executeUpdate();
            return user;
        } catch (final SQLException e) {
            //will change this later
            //throw new PersistenceException(e);
            System.out.println(e);
        }
        return user;
    }

    @Override
    public void deleteUser(User currentUser) {
        try (final Connection c = connection()) {
            final PreparedStatement sc = c.prepareStatement("DELETE FROM userposts WHERE userID = ?");
            sc.setString(1, currentUser.getUserId());
            sc.executeUpdate();
            final PreparedStatement st = c.prepareStatement("DELETE FROM users WHERE userID = ?");
            st.setString(1, currentUser.getUserId());
            st.executeUpdate();
        } catch (final SQLException e) {
            //will change this later
            //throw new PersistenceException(e);
        }
    }
}
