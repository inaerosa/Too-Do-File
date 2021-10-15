public class User {
    private  String name;
    private  String email;
    private int id = 0;

    public User(String name, String email, int id){
        this.name = name;
        this.email = email;
        this.id = id;
    }

    public User(){}

    public void setName(String name){
        this.name = name;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getName(){
        return this.name;
    }

    public String getEmail(){
        return this.email;
    }

    public int getID(){
        return this.id;
    }

    public void setID(int id){
        this.id = id;
    }

    @Override
    public String toString(){
        return "Name: "+ this.name + " Email: " + this.email;
    }

}
