package comp3350.fairprice.objects;

//import java.util.*;

public class Post {
    private final String title;
    private final String description;
    private final double price;

    public Post(final String title, final String description, final double price) {
        this.title = title;
        this.description = description;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getprice() {
        return "$" + String.valueOf(price);
    }
}
