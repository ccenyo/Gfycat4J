package commands.authentication;

import commands.PostCommand;
import exceptions.GfycatAuthenticationException;
import views.GfycatClientPasswordGrantView;

import java.util.HashMap;
import java.util.Map;

public class GfycatClientPasswordGrantCommand extends PostCommand<GfycatClientPasswordGrantView> {

    private final String clientId;
    private final String clientSecret;
    private final String username;
    private final String password;

    public GfycatClientPasswordGrantCommand(String clientId, String clientSecret,String username,String password) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.username = username;
        this.password = password;
    }

    @Override
    protected Map<String, String> getParams() {
        return Map.of(
                "grant_type", "password",
                "client_id", this.clientId,
                "client_secret",this.clientSecret,
                "username",this.username,
                "password",this.password
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
        if(this.username == null) throw  new GfycatAuthenticationException("The username secret is mandatory");
        if(this.password == null) throw  new GfycatAuthenticationException("The password secret is mandatory");

    }
}
