package comp3350.fairprice.objects;

//import java.util.*;

import java.util.Locale;

//This class represents an Object post that can be added to a database
public class Post {
    //information a post has
    private final String title;
    private final String description;
    private String category;

    private final double price;
    private int PostId;
    //constructor
    public Post(final int PosId)
    {
        this.PostId= PosId;
        this.description = null;
        this.price = 0.0;
        this.title = null;
        this.category=null;
    }
    public Post(final int PostId, final String title, final String description, final double price, String category ) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.PostId = PostId;
        this.category= category;
    }
//getter methods

    public int getPostId() {
        return PostId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return "$" + String.format(Locale.CANADA, "%.2f", price);
    }
    public double getPrice1(){return price;}

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
