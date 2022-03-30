<<<<<<< HEAD
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
=======
package comp3350.fairprice.objects;

//import java.util.*;

import java.util.Locale;

//This class represents an Object post that can be added to a database
public class Post {
    //information a post has
    private final String title;
    private final String description;
    private final float price;
    private int PostId;
    //constructor
    public Post(final int PosId)
    {
        this.PostId= PosId;
        this.description = null;
        this.price = 0.0f;
        this.title = null;
    }
    public Post(final int PostId, final String title, final String description, final float price) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.PostId = PostId;
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
    public float getPriceFloat(){return price;}
}
>>>>>>> fixed-db
