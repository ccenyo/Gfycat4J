package commands.user;

import commands.GetCommand;
import exceptions.GfycatUserException;
import views.GfycatUserView;

import java.util.HashMap;
import java.util.Map;

public class GfycatUserInfoCommand extends GetCommand<GfycatUserView> {

    private final String token;
    private final String userId;

    public GfycatUserInfoCommand(String token, String userId) {
        this.token = token;
        this.userId = userId;
    }


    @Override
    protected Map<String, Object> getHeaders() {
        return Map.of(
                "Authorization", "Bearer "+token);
    }

    @Override
    protected String getEndPoint() {
        return "https://api.gfycat.com/v1/users/"+userId;
    }

    @Override
    protected Class<GfycatUserView> getClassForMapper() {
        return GfycatUserView.class;
    }

    @Override
    protected void validate() {
        if(this.token == null) throw  new GfycatUserException("The token is mandatory");
        if(this.userId == null) throw  new GfycatUserException("The userId is mandatory");
    }

    @Override
    protected Map<String, String> getParams() {
        return new HashMap<>();
    }
}
