import java.io.IOException;
import java.util.List;

public class TestUser {
    public static void main(String[] args) throws IOException {
       User inae = new User("Inae", "inae@inae", 1);
       SaveUser sv = new SaveUser();

        User usuario = sv.get(1);
        usuario.setName("Inaê");
        sv.update(usuario);








    }
}
