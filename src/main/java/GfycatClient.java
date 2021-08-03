import responses.GfycatClientCredentialsGrantResult;

import java.time.LocalDateTime;

public class GfycatClient {

    private String token;
    private LocalDateTime expiryDate;


    protected GfycatClient(GfycatClientCredentialsGrantResult gfycatClientCredentialsGrantResult) {
        this.token = gfycatClientCredentialsGrantResult.getAccess_token();
        this.expiryDate = LocalDateTime.now().plusSeconds(gfycatClientCredentialsGrantResult.getExpires_in());
    }

    public String getToken() {
        return token;
    }
}
