import requests.authentication.GfycatClientCredentialsGrantRequest;
import responses.GfycatClientCredentialsGrantResult;

public class GfycatBuilder {
    public static GfycatClient connect(String clientId, String clientSecret) {
        GfycatClientCredentialsGrantResult call = new GfycatClientCredentialsGrantRequest(clientId, clientSecret).call();
        return new GfycatClient(call);
    }
}
