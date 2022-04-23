package comp3350.fairprice.business;

import android.util.Log;

import java.util.List;

import comp3350.fairprice.application.Services;
import comp3350.fairprice.objects.PU;
import comp3350.fairprice.objects.Post;
import comp3350.fairprice.objects.User;
import comp3350.fairprice.persistence.PUPersistence;

public class AccessPU {
    private PUPersistence dataAccess;
    private List<PU> elements;
//    private PU userPost;
//    private int currentUP;
private PU pu ;
    public AccessPU()
    {
        dataAccess = Services.getPuPersistence();
        elements = null;
          pu = null;
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
        Log.d("listing", "element size: " + elements.size());
        return elements;
    }


    public PU addPU(Post post, User user, String date) {

        pu = new PU(user, post, date);
//        Log.d("listing", "user name: " + pu.getUserID());
//        Log.d("listing", "post title: " + pu.getPost().getTitle());
//        Log.d("listing", "date: " + pu.getPostDate());
        return dataAccess.insertPU(pu);
    }
}
