package commands.authentication;

import commands.PostCommand;
import exceptions.GfycatAuthenticationException;
import views.GfycatClientPasswordGrantView;

import java.util.HashMap;
import java.util.Map;

public class GfycatClientRefreshTokenCommand extends PostCommand<GfycatClientPasswordGrantView> {

    private final String clientId;
    private final String clientSecret;
    private final String refresh_token;

    public GfycatClientRefreshTokenCommand(String clientId, String clientSecret, String refresh_token) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.refresh_token = refresh_token;
    }

    @Override
    protected Map<String, String> getParams() {
        return Map.of(
                "grant_type", "refresh",
                "client_id", this.clientId,
                "client_secret",this.clientSecret,
                "refresh_token",this.refresh_token
        );
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
    protected Class<GfycatClientPasswordGrantView> getClassForMapper() {
        return GfycatClientPasswordGrantView.class;
    }

    @Override
    protected void validate() {
        if(this.clientId == null) throw  new GfycatAuthenticationException("The clientId is mandatory");
        if(this.clientSecret == null) throw  new GfycatAuthenticationException("The client secret is mandatory");
        if(this.refresh_token == null) throw  new GfycatAuthenticationException("The refresh token is mandatory");
    }
}
