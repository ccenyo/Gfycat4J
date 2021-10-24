package views;

import java.util.List;

public class GfycatSearchResult {

    private List<GfycatView> gfycats;
    private String cursor;

    public List<GfycatView> getGfycats() {
        return gfycats;
    }

    public String getCursor() {
        return cursor;
    }
}
