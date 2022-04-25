package comp3350.fairprice.persistence;

import java.util.List;

import comp3350.fairprice.objects.PU;
import comp3350.fairprice.objects.Post;
import comp3350.fairprice.objects.User;
public interface PUPersistence {
    List<PU> getUP(final String userId);

    PU insertPU(PU pu);
}
