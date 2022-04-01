//used sample project
package comp3350.fairprice.persistence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import comp3350.fairprice.objects.User;

public class UserPersistenceStub implements UserPersistence{
    private List<User> users;
    public UserPersistenceStub()
    {
        users = new ArrayList<>();

        users.add(new User("user1", "tony", "123", "xyz12@outlook.com", "1234"));
        users.add(new User("user2", "ezekiel", "234", "xyz123@outlook.com", "1234"));
        users.add(new User("user3", "chris rock", "345", "xyz1234@outlook.com", "1234"));
        users.add(new User("user4", "will smith", "456", "xyz12345@outlook.com", "1234"));

    }
    @Override
    public User insertUser(User user) {
        users.add(user);
        return user;
    }

    @Override
    public List<User> getUserList() {
        return Collections.unmodifiableList(users);
    }

    @Override
    public void deleteUser(User CurrentUser) {
        int index;

        index = users.indexOf(CurrentUser);
        if (index >= 0)
        {
            users.remove(index);
        }
    }
}
