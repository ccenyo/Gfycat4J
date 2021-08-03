import org.junit.Assert;
import org.junit.Test;

public class GfycatAuthTest {

    @Test
    public void connect_and_success() {
        String clientId = "2_Dbuv6W";
        String clientSecret = "VwRvvJ-FvA3BqpkJLAE5FMWLzb5yGgeIhDVRSwd6ypv7YBPEj_wNcV0SP3JlDD0-";

        GfycatClient client =  GfycatBuilder.connect(clientId, clientSecret);

        Assert.assertNotNull(client);
        Assert.assertNotNull(client.getToken());
    }
}
