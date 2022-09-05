package Operations;

import hellomaven.entities.audio;

import java.util.List;
import java.util.function.Consumer;

public class audioOperations
{
    public static void display(List<audio> list) {
        Consumer<audio> c = (cust) -> System.out.println(cust);
        list.forEach(c);
    }
}
