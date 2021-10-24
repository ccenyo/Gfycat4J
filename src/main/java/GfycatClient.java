import commands.search.GfycatSiteSearchCommand;
import commands.user.GfycatCheckUserExistCommand;
import commands.user.GfycatUserAuthenticatedInfoCommand;
import commands.user.GfycatUserInfoCommand;
import exceptions.GfycatException;
import views.GfycatSearchResult;
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


    public GfycatClient(GfycatClientCredentialsGrantView gfycatClientCredentialsGrantResult, String clientId, String clientSecret) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.token = gfycatClientCredentialsGrantResult.getAccess_token();
        this.expiryDate = LocalDateTime.now().plusSeconds(gfycatClientCredentialsGrantResult.getExpires_in());
    }

    public GfycatClient(GfycatClientPasswordGrantView gfycatClientPasswordGrantView, String clientId, String clientSecret) {
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

    public boolean isUserExist(String userName) {
        refreshIfExpired();
        try {
            new GfycatCheckUserExistCommand(userName, this.token).call();
        } catch (GfycatException e) {
            return false;
        }
        return true;
    }

    public GfycatUserView me() {
        refreshIfExpired();
        GfycatUserAuthenticatedInfoCommand gfycatUserAuthenticatedInfoCommand = new GfycatUserAuthenticatedInfoCommand(this.token);
        return gfycatUserAuthenticatedInfoCommand.call();
    }

    public GfycatUserView user(String userId) {
        refreshIfExpired();
        GfycatUserInfoCommand gfycatUserInfoCommand = new GfycatUserInfoCommand(this.token, userId);
        return gfycatUserInfoCommand.call();
    }

    public GfycatSearchResult search(String searchText) {
        refreshIfExpired();
        GfycatSiteSearchCommand gfycatSiteSearchCommand = new GfycatSiteSearchCommand(this.token, searchText);
        return gfycatSiteSearchCommand.call();
    }

    public GfycatSearchResult search(String searchText, Integer count) {
        refreshIfExpired();
        GfycatSiteSearchCommand gfycatSiteSearchCommand = new GfycatSiteSearchCommand(this.token, searchText)
                .setCount(count);
        return gfycatSiteSearchCommand.call();
    }

    public GfycatSearchResult search(String searchText, String cursor) {
        refreshIfExpired();
        GfycatSiteSearchCommand gfycatSiteSearchCommand = new GfycatSiteSearchCommand(this.token, searchText)
                .setCursor(cursor);
        return gfycatSiteSearchCommand.call();
    }


    public GfycatSearchResult search(String searchText, Integer count, String cursor) {
        refreshIfExpired();
        GfycatSiteSearchCommand gfycatSiteSearchCommand = new GfycatSiteSearchCommand(this.token, searchText)
                .setCount(count)
                .setCursor(cursor);
        return gfycatSiteSearchCommand.call();
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
