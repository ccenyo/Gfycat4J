import commands.authentication.GfycatCheckUserExistCommand;
import exceptions.GfycatException;
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
