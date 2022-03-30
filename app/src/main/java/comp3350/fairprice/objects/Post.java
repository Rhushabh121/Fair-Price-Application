package comp3350.fairprice.objects;

//import java.util.*;

import java.util.Locale;

//This class represents an Object post that can be added to a database
public class Post {
    //information a post has
    private final String title;
    private final String description;
    private final double price;

    //constructor
    public Post(final String title, final String description, final double price) {
        this.title = title;
        this.description = description;
        this.price = price;
    }
//getter methods
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return "$" + String.format(Locale.CANADA, "%.2f", price);
    }
}
