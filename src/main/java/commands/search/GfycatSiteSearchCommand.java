package commands.search;

import commands.GetCommand;
import exceptions.GfycatSearchException;
import views.GfycatSearchResult;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class GfycatSiteSearchCommand extends GetCommand<GfycatSearchResult> {

    private final String token;
    private final String searchText;
    private Integer count;
    private String cursor;

    public GfycatSiteSearchCommand(String token, String searchText) {
        this.token = token;
        this.searchText = searchText;
    }

    public GfycatSiteSearchCommand setCount(Integer count) {
        this.count = count;
        return this;
    }

    public GfycatSiteSearchCommand setCursor(String cursor) {
        this.cursor = cursor;
        return this;
    }

    @Override
    protected Map<String, Object> getHeaders() {
        return Map.of(
                "Authorization", "Bearer "+token);
    }

    @Override
    protected String getEndPoint() {
        return "https://api.gfycat.com/v1/gfycats/search?search_text="+this.searchText;
    }

    @Override
    protected Class<GfycatSearchResult> getClassForMapper() {
        return GfycatSearchResult.class;
    }

    @Override
    protected void validate() {
        if(this.searchText == null) throw  new GfycatSearchException("The searchText is mandatory");
        if(this.token == null) throw  new GfycatSearchException("The token is mandatory");
    }

    @Override
    protected Map<String, String> getParams() {
        Map<String, String> map = new HashMap<>();
        Optional.ofNullable(this.count)
                .ifPresent(e -> map.put("count", String.valueOf(e)));
        Optional.ofNullable(this.cursor)
                .ifPresent(e -> map.put("cursor", e));
        return map;
    }
}
