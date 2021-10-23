package views;

public class GfycatClientPasswordGrantView {

    private String token_type;
    private Long refresh_token_expires_in;
    private Long expires_in;
    private String refresh_token;
    private String access_token;
    private String scope;

    public String getToken_type() {
        return token_type;
    }

    public Long getRefresh_token_expires_in() {
        return refresh_token_expires_in;
    }
    public Long getExpires_in() {
        return expires_in;
    }

    public String getRefresh_token() {
        return refresh_token;
    }
    public String getAccess_token() {
        return access_token;
    }

    public String getScope() {
        return scope;
    }
}
