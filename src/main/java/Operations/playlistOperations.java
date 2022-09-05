package Operations;

import hellomaven.entities.playlist;

import java.util.List;
import java.util.function.Consumer;

public class playlistOperations
{
    public static void display(List<playlist> list) {
        Consumer<playlist> c = (cust) -> System.out.println(cust);
        list.forEach(c);
    }
}
