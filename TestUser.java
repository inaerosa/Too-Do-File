public class TestUser {

    public static void main(String[] args) {
        User inae = new User("Inae", "inae@inae", 1);
        User nina = new User("Nina", "nina@au", 2);

        SaveUser sv = new SaveUser();

        sv.insert(inae);
        sv.insert(nina);

        inae.toString();
        System.out.println(nina.getName());
        System.out.println(nina.getEmail());
        System.out.println(nina.getID());

    }
}
