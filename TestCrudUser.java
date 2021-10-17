import java.io.IOException;

public class TestCrudUser {
    public static void main(String[] args) throws IOException {

       SaveUser sv = new SaveUser();

       User usuario = sv.get(1);
       usuario.setEmail("inae@inae.com");
       sv.update(usuario);
       usuario.toString();

       sv.delete(2);

    }
}
