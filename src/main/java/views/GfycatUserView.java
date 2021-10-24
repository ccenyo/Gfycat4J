package views;

public class GfycatUserView {

    /**
     * A unique identifier for the user.
     */
    private String userid;

    /**
     * The user’s username on Gfycat.
     */
    private String username;

    /**
     * The user’s email on Gfycat.
     */
    private String email;

    /**
     * The user’s profile description.
     */
    private String description;

    /**
     * The user’s profile link.
     */
    private String profileUrl;

    /**
     * The user’s name on Gfycat.
     */
    private String name;

    /**
     * AThe number of user’s gfy views on Gfycat.
     */
    private Integer views;

    /**
     * 	The user’s upload notices settings, whether the user wants to get notified of uploads or not.
     */
    private boolean uploadNotices;

    /**
     * The user’s email verification status.
     */
    private boolean emailVerified;

    /**
     * 	The URL to the user’s profile on Gfycat
     */
    private String url;

    /**
     * The unix timestamp of the date the user created their account
     */
    private Integer createDate;

    /**
     * The URL to the user’s avatar on Gfycat
     */
    private String profileImageUrl;

    /**
     * 	The account’s verified status.
     */
    private boolean verified;

    /**
     * The number of user’s followers.
     */
    private Integer followers;

    /**
     * 	The number of users this user follows.
     */
    private Integer following;

    /**
     * The user’s geo whitelist on Gfycat.
     */
    private String geoWhitelist;

    /**
     * The user’s domain whitelist on Gfycat.
     */
    private String domainWhitelist;

    /**
     * The user’s associated provider details (has the user linked their facebook or twitter account and selected details from the provider)
     */
    private String associatedProviders;

    /**
     * The user’s profile image visibility on the iframe
     */
    private boolean iframeProfileImageVisible;


    public String getUserid() {
        return userid;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getDescription() {
        return description;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public String getName() {
        return name;
    }

    public Integer getViews() {
        return views;
    }

    public boolean isUploadNotices() {
        return uploadNotices;
    }

    public boolean isEmailVerified() {
        return emailVerified;
    }

    public String getUrl() {
        return url;
    }

    public Integer getCreateDate() {
        return createDate;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public boolean isVerified() {
        return verified;
    }

    public Integer getFollowers() {
        return followers;
    }

    public Integer getFollowing() {
        return following;
    }

    public String getGeoWhitelist() {
        return geoWhitelist;
    }

    public String getDomainWhitelist() {
        return domainWhitelist;
    }

    public String getAssociatedProviders() {
        return associatedProviders;
    }

    public boolean isIframeProfileImageVisible() {
        return iframeProfileImageVisible;
    }
}
