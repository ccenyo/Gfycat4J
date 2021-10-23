import views.GfycatClientCredentialsGrantView;
import views.GfycatClientPasswordGrantView;

import java.time.LocalDateTime;

public class GfycatClient {

    private String token;
    private String refreshToken;
    private LocalDateTime expiryDate;
    private LocalDateTime refreshTokenExpiresDate;


    protected GfycatClient(GfycatClientCredentialsGrantView gfycatClientCredentialsGrantResult) {
        this.token = gfycatClientCredentialsGrantResult.getAccess_token();
        this.expiryDate = LocalDateTime.now().plusSeconds(gfycatClientCredentialsGrantResult.getExpires_in());
    }

    protected GfycatClient(GfycatClientPasswordGrantView gfycatClientPasswordGrantView) {
        this.token = gfycatClientPasswordGrantView.getAccess_token();
        this.refreshToken = gfycatClientPasswordGrantView.getRefresh_token();
        this.expiryDate = LocalDateTime.now().plusSeconds(gfycatClientPasswordGrantView.getExpires_in());
        this.refreshTokenExpiresDate = LocalDateTime.now().plusSeconds(gfycatClientPasswordGrantView.getRefresh_token_expires_in());
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
