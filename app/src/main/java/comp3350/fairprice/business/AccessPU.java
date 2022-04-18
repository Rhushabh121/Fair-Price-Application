package comp3350.fairprice.business;

import java.util.List;

import comp3350.fairprice.application.Services;
import comp3350.fairprice.objects.PU;
import comp3350.fairprice.persistence.PUPersistence;

public class AccessPU {
    private PUPersistence dataAccess;
    private List<PU> elements;
//    private PU userPost;
//    private int currentUP;

    public AccessPU()
    {
        dataAccess = Services.getPuPersistence();
        elements = null;
//        userPost = null;
//        currentUP = 0;
    }
    public AccessPU(final PUPersistence puPersistence)
    {
        this();
        this.dataAccess = puPersistence;
    }
    public List<PU> getUP(String userID)
    {
       //for iteration_3
        elements = dataAccess.getUP(userID);
        return elements;
    }
}
