package comp3350.fairprice.persistence;

import java.util.List;

import comp3350.fairprice.objects.Post;

public interface PostPersistence {
    List<Post> getPostList();
    Post insertPost(Post post);
    void deletePost(Post post);
}
