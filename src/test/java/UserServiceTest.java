import org.junit.Assert;
import org.junit.Test;

public class UserServiceTest {

    UserDb MockUser = new UserDb("admin", "P455w0rd!");

    @Test
    public void testIfUserExistAndPasswordCorrect() {
        UserService connection = new UserService(MockUser);
        boolean result = connection.changePassword("admin", "N3werPassW0rd!!");
        Assert.assertTrue(result);
    }

    @Test
    public void testIfUserExistAndPasswordWeak() {
        UserService connection = new UserService(MockUser);
        boolean result = connection.changePassword("admin", "WeakPas");
        Assert.assertFalse(result);
    }

    @Test
    public void testIfUserNotExistAndPasswordCorrect() {
        UserService connection = new UserService(MockUser);
        boolean result = connection.changePassword("serviceAccount", "N3werPassW0rd!!");
        Assert.assertFalse(result);
    }
}
