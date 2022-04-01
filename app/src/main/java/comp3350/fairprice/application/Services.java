package comp3350.fairprice.application;

import comp3350.fairprice.persistence.PUPersistence;
import comp3350.fairprice.persistence.PostPersistence;
import comp3350.fairprice.persistence.UserPersistence;
import comp3350.fairprice.persistence.hsqldb.PUPersistenceHSQLDB;
import comp3350.fairprice.persistence.hsqldb.PostPersistenceHSQLDB;
import comp3350.fairprice.persistence.hsqldb.UserPersistenceHSQLDB;

public class Services {
    private static UserPersistence userPersistence = null;
    private static PostPersistence postPersistence = null;
    private static PUPersistence puPersistence = null;

    public static synchronized UserPersistence getUserPersistence()
    {
        if (userPersistence == null)
        {
            userPersistence = new UserPersistenceHSQLDB(Main.getDBPathName());
        }

        return userPersistence;
    }
    public static synchronized PostPersistence getPostPersistence()
    {
        if (postPersistence == null)
        {
            postPersistence = new PostPersistenceHSQLDB(Main.getDBPathName());
        }

        return postPersistence;
    }
    public static synchronized PUPersistence getPuPersistence()
    {
        if (puPersistence == null)
        {
            puPersistence = new PUPersistenceHSQLDB(Main.getDBPathName());
        }

        return puPersistence;
    }

}
