import commands.authentication.GfycatClientCredentialsGrantCommand;
import commands.authentication.GfycatClientPasswordGrantCommand;
import commands.authentication.GfycatClientRefreshTokenCommand;
import views.GfycatClientCredentialsGrantView;
import views.GfycatClientPasswordGrantView;

public class GfycatBuilder {
    public static GfycatClient connect(String clientId, String clientSecret) {
        GfycatClientCredentialsGrantView call = new GfycatClientCredentialsGrantCommand(clientId, clientSecret).call();
        return new GfycatClient(call, clientId, clientSecret);
    }

    public static GfycatClient connect(String clientId, String clientSecret, String userName, String password) {
        GfycatClientPasswordGrantView call = new GfycatClientPasswordGrantCommand(clientId, clientSecret, userName, password).call();
        return new GfycatClient(call, clientId, clientSecret);
    }

    public static GfycatClientPasswordGrantView refresh(String clientId, String clientSecret, String refreshtoken) {
        return new GfycatClientRefreshTokenCommand(clientId, clientSecret, refreshtoken).call();
    }
}
