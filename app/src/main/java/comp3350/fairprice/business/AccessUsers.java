package comp3350.fairprice.business;

import java.util.Collections;
import java.util.List;

import comp3350.fairprice.application.Services;
import comp3350.fairprice.objects.User;
import comp3350.fairprice.persistence.UserPersistence;

public class AccessUsers {
    private UserPersistence userPersistence;
    private List<User> users;
    //private User user;
    private int currentUser;

    public AccessUsers()
    {
        userPersistence = Services.getUserPersistence();
        users = null;
    }
    public AccessUsers(final UserPersistence userPersistence)
    {
        this();
        this.userPersistence=userPersistence;
    }
    public List<User> getUsers()
    {
        users = userPersistence.getUserList();
        return Collections.unmodifiableList(users);
    }
    public User addUser(User newUser)
    {
        return userPersistence.insertUser(newUser);
    }
    public void deleteUser(User user)
    {
        userPersistence.deleteUser(user);
    }
}
