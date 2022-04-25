//used sample project
package comp3350.fairprice.persistence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import comp3350.fairprice.objects.Post;

public class PostPersistenceStub implements PostPersistence{
    private List<Post> posts;

    public PostPersistenceStub()
    {
        posts = new ArrayList<>();

        posts.add(new Post(1,"Car","Tesla",20, "vehicles"));
        posts.add(new Post(2,"book","the alchemist",20, "books"));
        posts.add(new Post(3,"mobile","google pixel 6 pro",20, "electronics"));
        posts.add(new Post(4,"Car","ford model T",20, "vehicles"));
    }

    @Override
    public List<Post> getPostList() {
        return Collections.unmodifiableList(posts);
    }

    @Override
    public Post insertPost(Post post) {
        posts.add(post);
        return post;
    }

    @Override
    public void deletePost(Post post) {
        int index;

        index = posts.indexOf(post);
        if (index >= 0)
        {
            posts.remove(index);
        }
    }

    public List<Post> getPosts() {
        return posts;
    }
}
