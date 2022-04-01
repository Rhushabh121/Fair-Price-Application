package comp3350.fairprice.objects;


/**
 * THIS CLASS IS PRE-ADDED FOR ITERATION 3 - INCOMPLETE
 */
public class PU {
    private final Post post;
    private final User user;
    private final String postDate;
    public PU(final User user, final Post post, final String postDate)
    {
        this.user = user;
        this.post = post;
        this.postDate =postDate;
    }

    public String getUserID() {
        return user.getUserId();
    }
    public int getPostID()
    {
        return post.getPostId();
    }
    public String getPostDate() {
        return postDate;
    }
}
