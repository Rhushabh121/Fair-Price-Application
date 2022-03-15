package comp3350.fairprice.persistence.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
    @Override
    public List<User> getUserList() {
        //code here
        return null;
    }

    @Override
    public User insertUser(User user) {
        //code here
        return null;
    }

    @Override
    public void deleteUser(User user) {
        //code here
    }
}
