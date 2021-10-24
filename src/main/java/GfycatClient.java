import commands.authentication.GfycatCheckUserExistCommand;
import commands.authentication.GfycatUserAuthenticatedInfoCommand;
import commands.authentication.GfycatUserInfoCommand;
import exceptions.GfycatException;
import views.GfycatUserView;
import views.GfycatClientCredentialsGrantView;
import views.GfycatClientPasswordGrantView;

import java.time.LocalDateTime;
import java.util.Optional;

public class GfycatClient {

    private String token;
    private String refreshToken;
    private LocalDateTime expiryDate;
    private LocalDateTime refreshTokenExpiresDate;
    private final String clientId;
    private final String clientSecret;


    protected GfycatClient(GfycatClientCredentialsGrantView gfycatClientCredentialsGrantResult, String clientId, String clientSecret) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.token = gfycatClientCredentialsGrantResult.getAccess_token();
        this.expiryDate = LocalDateTime.now().plusSeconds(gfycatClientCredentialsGrantResult.getExpires_in());
    }

    protected GfycatClient(GfycatClientPasswordGrantView gfycatClientPasswordGrantView, String clientId, String clientSecret) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.token = gfycatClientPasswordGrantView.getAccess_token();
        this.refreshToken = gfycatClientPasswordGrantView.getRefresh_token();
        this.expiryDate = LocalDateTime.now().plusSeconds(gfycatClientPasswordGrantView.getExpires_in());
        this.refreshTokenExpiresDate = LocalDateTime.now().plusSeconds(gfycatClientPasswordGrantView.getRefresh_token_expires_in());
    }

    private void refreshIfExpired() {
        Optional.ofNullable(refreshTokenExpiresDate)
                .ifPresent(refreshTokenExpiresDate -> {
                    var gfycatClientPasswordGrantView = GfycatBuilder.refresh(clientId, clientSecret, refreshToken);
                    this.token = gfycatClientPasswordGrantView.getAccess_token();
                    this.refreshToken = gfycatClientPasswordGrantView.getRefresh_token();
                    this.expiryDate = LocalDateTime.now().plusSeconds(gfycatClientPasswordGrantView.getExpires_in());
                    this.refreshTokenExpiresDate = LocalDateTime.now().plusSeconds(gfycatClientPasswordGrantView.getRefresh_token_expires_in());
                });
    }

    boolean isUserExist(String userName) {
        refreshIfExpired();
        try {
            new GfycatCheckUserExistCommand(userName, this.token).call();
        } catch (GfycatException e) {
            return false;
        }
        return true;
    }

    GfycatUserView me() {
        refreshIfExpired();
        GfycatUserAuthenticatedInfoCommand gfycatUserAuthenticatedInfoCommand = new GfycatUserAuthenticatedInfoCommand(this.token);
        return gfycatUserAuthenticatedInfoCommand.call();
    }

    GfycatUserView user(String userId) {
        refreshIfExpired();
        GfycatUserInfoCommand gfycatUserInfoCommand = new GfycatUserInfoCommand(this.token, userId);
        return gfycatUserInfoCommand.call();
    }


    public String getToken() {
        return token;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public LocalDateTime getRefreshTokenExpiresDate() {
        return refreshTokenExpiresDate;
    }
}
