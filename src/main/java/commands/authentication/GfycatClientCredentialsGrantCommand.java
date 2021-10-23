package commands.authentication;

import commands.PostCommand;
import exceptions.GfycatAuthenticationException;
import views.GfycatClientCredentialsGrantView;

import java.util.HashMap;
import java.util.Map;

public class GfycatClientCredentialsGrantCommand extends PostCommand<GfycatClientCredentialsGrantView> {

    private final String clientId;
    private final String clientSecret;

    public GfycatClientCredentialsGrantCommand(String clientId, String clientSecret) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    @Override
    protected Map<String, String> getParams() {
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
    protected Class<GfycatClientCredentialsGrantView> getClassForMapper() {
        return GfycatClientCredentialsGrantView.class;
    }

    @Override
    protected void validate() {
        if(this.clientId == null) throw  new GfycatAuthenticationException("The clientId is mandatory");
        if(this.clientSecret == null) throw  new GfycatAuthenticationException("The client secret is mandatory");
    }
}
