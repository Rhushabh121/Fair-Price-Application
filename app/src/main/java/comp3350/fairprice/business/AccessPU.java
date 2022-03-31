package comp3350.fairprice.business;

import java.util.List;

import comp3350.fairprice.application.Services;
import comp3350.fairprice.objects.PU;
import comp3350.fairprice.persistence.PUPersistence;

public class AccessPU {
    private PUPersistence dataAccess;
    private List<PU> elements;
    private PU userPost;
    private int currentUP;

    public AccessPU()
    {
        dataAccess = Services.getPuPersistence();
        userPost = null;
        currentUP = 0;
    }
    public AccessPU(final PUPersistence puPersistence)
    {
        this();
        this.dataAccess = puPersistence;
    }
    public PU getUP(String userID)
    {
        //discuss because in sample they are just doing gpa


//        if (elements == null)
//        {
//            elements = dataAccess.getUP(userID);
//            gpa = Calculate.gpa(elements);
//            currentSC = 0;
//        }
//        if (currentSC < elements.size())
//        {
//            userPost = elements.get(currentSC);
//            currentSC++;
//        }
//        else
//        {
//            elements = null;
//            userPost = null;
//            currentSC = 0;
//        }
//        return userPost;
        return null;
    }
}
