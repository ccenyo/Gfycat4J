package views;

public class GfycatClientCredentialsGrantView {

    private String token_type;
    private Long expires_in;
    private String access_token;
    private String scope;

    public String getToken_type() {
        return token_type;
    }

    public Long getExpires_in() {
        return expires_in;
    }

    public String getAccess_token() {
        return access_token;
    }

    public String getScope() {
        return scope;
    }
}
