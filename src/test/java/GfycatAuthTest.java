import org.junit.Assert;
import org.junit.Test;

public class GfycatAuthTest {

    @Test
    public void connect_and_success() {
        String clientId = "2_sQvENC";
        String clientSecret = "ALLOT3VjIDAEcZrc32iDLCz25FiS0GhwfHW9uqtJKZigARmptvTWAs98pb5oNLHD";

        GfycatClient client =  GfycatBuilder.connect(clientId, clientSecret);

        Assert.assertNotNull(client);
        Assert.assertNotNull(client.getToken());
    }

    @Test
    public void connect_with_password_and_success() {
        String clientId = "2_sQvENC";
        String clientSecret = "ALLOT3VjIDAEcZrc32iDLCz25FiS0GhwfHW9uqtJKZigARmptvTWAs98pb5oNLHD";
        String userName = "test_dev_account";
        String password = "4xKkn52RaqZ9X7myNQX";

        GfycatClient client =  GfycatBuilder.connect(clientId, clientSecret, userName, password);

        Assert.assertNotNull(client);
        Assert.assertNotNull(client.getToken());
    }
}
