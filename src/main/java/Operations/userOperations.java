package Operations;

import hellomaven.entities.users;

import java.util.List;
import java.util.stream.Collectors;

public class userOperations
{
    public static boolean validate(List<users> list, String userId, String password) {
        boolean res = false;
        List<users> user = list.stream().filter(c -> c.getUserId().equalsIgnoreCase(userId)).collect(Collectors.toList());
        if (user.size() != 0) {
            users u = user.get(0);
            if (u.getUserPassword().equals(password)) {
                res = true;
                System.out.println("login successfull");
            }
        }
        return res;
    }
}
