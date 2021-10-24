package commands.user;

import commands.GetCommand;
import exceptions.GfycatUserException;
import views.GfycatUserView;

import java.util.HashMap;
import java.util.Map;

public class GfycatUserAuthenticatedInfoCommand extends GetCommand<GfycatUserView> {

    private final String token;

    public GfycatUserAuthenticatedInfoCommand(String token) {
        this.token = token;
    }


    @Override
    protected Map<String, Object> getHeaders() {
        return Map.of(
                "Authorization", "Bearer "+token);
    }

    @Override
    protected String getEndPoint() {
        return "https://api.gfycat.com/v1/me";
    }

    @Override
    protected Class<GfycatUserView> getClassForMapper() {
        return GfycatUserView.class;
    }

    @Override
    protected void validate() {
        if(this.token == null) throw  new GfycatUserException("The token is mandatory");
    }

    @Override
    protected Map<String, String> getParams() {
        return new HashMap<>();
    }
}
