import org.junit.Assert;
import org.junit.Test;
import views.GfycatClientPasswordGrantView;

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

    @Test
    public void connect_with_password_and_successWithRefresh() {
        String clientId = "2_sQvENC";
        String clientSecret = "ALLOT3VjIDAEcZrc32iDLCz25FiS0GhwfHW9uqtJKZigARmptvTWAs98pb5oNLHD";
        String userName = "test_dev_account";
        String password = "4xKkn52RaqZ9X7myNQX";

        GfycatClient client =  GfycatBuilder.connect(clientId, clientSecret, userName, password);
        GfycatClientPasswordGrantView refresh = GfycatBuilder.refresh(clientId, clientSecret, client.getRefreshToken());

        Assert.assertNotNull(refresh);
        Assert.assertNotNull(refresh.getAccess_token());
        Assert.assertNotNull(refresh.getRefresh_token());
    }

    @Test
    public void check_user_exist() {
        String clientId = "2_sQvENC";
        String clientSecret = "ALLOT3VjIDAEcZrc32iDLCz25FiS0GhwfHW9uqtJKZigARmptvTWAs98pb5oNLHD";

        GfycatClient client =  GfycatBuilder.connect(clientId, clientSecret);
        var unreal_proton = client.isUserExist("unreal_proton");

        Assert.assertTrue(unreal_proton);
    }

    @Test
    public void get_authenticated_user_details() {
        String clientId = "2_sQvENC";
        String clientSecret = "ALLOT3VjIDAEcZrc32iDLCz25FiS0GhwfHW9uqtJKZigARmptvTWAs98pb5oNLHD";
        String userName = "test_dev_account";
        String password = "4xKkn52RaqZ9X7myNQX";

        GfycatClient client =  GfycatBuilder.connect(clientId, clientSecret, userName, password);
        var userInfo = client.me();

        Assert.assertNotNull(userInfo);
        Assert.assertNotNull(client.getToken());
    }

    @Test
    public void get_user_info() {
        String clientId = "2_sQvENC";
        String clientSecret = "ALLOT3VjIDAEcZrc32iDLCz25FiS0GhwfHW9uqtJKZigARmptvTWAs98pb5oNLHD";

        GfycatClient client =  GfycatBuilder.connect(clientId, clientSecret);
        var unreal_proton = client.user("unreal_proton");

        Assert.assertNotNull(unreal_proton);
    }

    @Test
    public void search_term() {
        String clientId = "2_sQvENC";
        String clientSecret = "ALLOT3VjIDAEcZrc32iDLCz25FiS0GhwfHW9uqtJKZigARmptvTWAs98pb5oNLHD";

        GfycatClient client =  GfycatBuilder.connect(clientId, clientSecret);
        var result = client.search("omg", 20);

        Assert.assertNotNull(result);
    }

}
