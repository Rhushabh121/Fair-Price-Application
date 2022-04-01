package comp3350.fairprice.persistence;
import java.util.List;

import comp3350.fairprice.objects.User;
public interface UserPersistence {
    List<User> getUserList();
    User insertUser(User user);
    void deleteUser(User CurrentUser);
}
