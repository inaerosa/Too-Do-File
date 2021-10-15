import java.io.IOException;

public interface ControlUserTask <T> {
    public void insert(T ob) ;
    public T get(int id);
    public void update(T ob);
    public void delete(int id);
}

