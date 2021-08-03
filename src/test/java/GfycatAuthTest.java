import org.junit.Assert;
import org.junit.Test;

public class GfycatAuthTest {

    @Test
    public void connect_and_success() {

        GfycatClient client =  GfycatBuilder.connect(clientId, clientSecret);

        Assert.assertNotNull(client);
        Assert.assertNotNull(client.getToken());
    }
}
