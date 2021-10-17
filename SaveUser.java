import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class SaveUser implements ControlUserTask <User> {

    private Path file;
    private Charset encode;

    public SaveUser(){
        Path folder = Paths.get("src");
        this.file = folder.resolve("UserFile.txt");
        this.encode = Charset.forName("UTF-8");
        try{
            if (!Files.exists(this.file)){
                Files.createFile(file);
            }
        } catch (IOException e) {
            System.out.println(e);
            throw new RuntimeException("Erro ao abrir o arquivo");
        }
    }

    public List<User> list(){
        List<String> data;
        List<User> users = new ArrayList<>();
        try {
            data = Files.readAllLines(this.file, this.encode);
        }catch (IOException e){
            System.out.println(e);
            throw new RuntimeException("Error");
        }
        for (String line : data){
            String[] field = line.split("-");
            User u = new User();
            u.setID(Integer.parseInt(field[0]));
            u.setName(field[1]);
            u.setEmail(field[2]);

            users.add(u);
        }
        return users;
    }

    @Override
    public void insert(User u) {
        String aux = u.getID() +"-"+ u.getName()+"-"+u.getEmail()+"\n";
        try{
            Files.writeString(this.file, aux, StandardOpenOption.APPEND);
        }catch (IOException e){
            System.out.println(e);
            throw new RuntimeException("Error");
        }
    }

    private void insertAll(List<User> users) throws IOException {
      List<String> lines = new ArrayList<>();
      for (User user : users){
          String aux = user.getID() +"-"+ user.getName()+"-"+user.getEmail();
          lines.add(aux);
      }
      Files.write(this.file, lines);

    }

    @Override
    public User get(int id) {
        List<User> users = list();
        User retorno = getUser(id, users);
        return retorno;
    }

    private User getUser(int id, List<User> users){
        User retorno = null;
        for (User user :users){
            if (user.getID() == id){
                retorno = user;
            }
        }
        if (retorno == null) throw new RuntimeException("Error: id not found");
        else return retorno;
    }

    @Override
    public void update(User ob ) throws IOException {
        List<User> listUsers = list();
        User user = getUser(ob.getID(), listUsers);
        user.setName(ob.getName());
        user.setEmail(ob.getEmail());
        insertAll(listUsers);
    }

    @Override
    public void delete(int id) throws IOException {
        List<User> listUsers = list();
        User ret = getUser(id, listUsers);
        listUsers.remove(ret);
        insertAll(listUsers);
    }
}
