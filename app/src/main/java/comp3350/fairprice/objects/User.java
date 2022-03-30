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
