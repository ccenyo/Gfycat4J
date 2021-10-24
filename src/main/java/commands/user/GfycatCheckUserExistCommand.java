package commands.user;

import commands.HeadCommand;
import commands.PostCommand;
import exceptions.GfycatAuthenticationException;
import exceptions.GfycatUserException;
import views.EmptyView;
import views.GfycatClientCredentialsGrantView;

import java.util.HashMap;
import java.util.Map;

public class GfycatCheckUserExistCommand extends HeadCommand<EmptyView> {

    private final String userName;
    private final String token;

    public GfycatCheckUserExistCommand(String userName, String token) {
        this.userName = userName;
        this.token = token;
    }


    @Override
    protected Map<String, Object> getHeaders() {
        return Map.of(
                "Authorization", "Bearer "+token);
    }

    @Override
    protected String getEndPoint() {
        return "https://api.gfycat.com/v1/users/"+userName;
    }

    @Override
    protected Class<EmptyView> getClassForMapper() {
        return EmptyView.class;
    }

    @Override
    protected void validate() {
        if(this.userName == null) throw  new GfycatUserException("The username is mandatory");
        if(this.token == null) throw  new GfycatUserException("The token is mandatory");
    }
}
