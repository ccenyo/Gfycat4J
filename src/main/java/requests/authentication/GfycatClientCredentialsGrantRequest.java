package requests.authentication;

import requests.GfycatAbstractRequest;
import responses.GfycatClientCredentialsGrantResult;

import java.util.HashMap;
import java.util.Map;

public class GfycatClientCredentialsGrantRequest extends GfycatAbstractRequest<GfycatClientCredentialsGrantResult> {

    private final String clientId;
    private final String clientSecret;

    public GfycatClientCredentialsGrantRequest(String clientId, String clientSecret) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    @Override
    protected Map<String, String> getParams() {
        return new HashMap<>();
    }

    @Override
    protected Map<String, String> getParamsInBody() {
        return Map.of(
                "grant_type", "client_credentials",
                "client_id", this.clientId,
                "client_secret",this.clientSecret);
    }

    @Override
    protected Map<String, Object> getHeaders() {
        return new HashMap<>();
    }

    @Override
    protected String getEndPoint() {
        return "https://api.gfycat.com/v1/oauth/token";
    }

    @Override
    protected Method getMethod() {
        return Method.POST;
    }

    @Override
    protected Class<GfycatClientCredentialsGrantResult> getClassForMapper() {
        return GfycatClientCredentialsGrantResult.class;
    }
}
