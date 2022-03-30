<<<<<<< HEAD
package comp3350.fairprice.objects;
//This class is the user object that allows a user to be connected to the database
public class User {
    //regular info
    private String name;
    private String password;
    private String email;

    //billing info
    private String creditCard;

    //constructor
    public User(String name, String email, String password, String creditCard){
        this.name = name;
        this.password = password;
        this.email = email;
        this.creditCard = creditCard;
    }

    //getters
    public String getName(){
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getCreditCard() {
        return creditCard;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }
}
=======
package comp3350.fairprice.objects;
//This class is the user object that allows a user to be connected to the database
public class User {
    //regular info
    private String name;
    private String password;
    private String email;
    private String UserId;
    //billing info
    private String creditCard;

    //constructor
    public User(final String UserId)
    {
        this.UserId = UserId;
        this.name = null;
        this.email = null;
        this.password = null;
        this.creditCard = null;
    }
    public User(String userId, String name, String email, String password, String creditCard){
        this.name = name;
        this.password = password;
        this.email = email;
        this.creditCard = creditCard;
        this.UserId = userId;
    }

    //getters
    public String getName(){
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public String getUserId() {
        return UserId;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }
}
>>>>>>> fixed-db
