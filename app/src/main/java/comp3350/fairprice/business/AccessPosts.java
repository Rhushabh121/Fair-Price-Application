package comp3350.fairprice.business;

import comp3350.fairprice.objects.Post;

import java.util.ArrayList;

public class AccessPosts {

    private ArrayList<Post> posts;

    public AccessPosts() {
        posts = new ArrayList<>();
        posts.add(new Post("Car", "2002 Toyota Corolla", 2599.99));
        posts.add(new Post("Bike", "Works well", 99.99));
        posts.add(new Post("Coffee Maker", "Really nice", 150.00));
        posts.add(new Post("Laptop", "Macbook Pro", 999.99));
        posts.add(new Post("Table", "Coffee table", 50));
        posts.add(new Post("Plant", "House plant", 19.50));
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public void addPost(Post newPost) {
        posts.add(newPost);
    }

}
