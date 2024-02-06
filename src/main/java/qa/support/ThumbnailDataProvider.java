package qa.support;

import qa.models.ThumbnailData;

import java.util.HashMap;

public class ThumbnailDataProvider {

    private static final HashMap<String, ThumbnailData> map = new HashMap<>() { {

        put("Windsurfing w Lanzarote (Costa Teguise)", new ThumbnailData("Popularne", 0, "windsurfing-w-lanzarote-costa-teguise/"));
        put("Yoga i pilates w Portugalii", new ThumbnailData("W promocji", 1, "yoga-i-pilates-w-portugalii/"));
        put("Wakacje z yogą w Kraju Kwitnącej Wiśni", new ThumbnailData("W promocji", 0, "wakacje-z-yoga-w-kraju-kwitnacej-wisni/"));
    }};

    public static ThumbnailData getThumbnailData(String name) {

        return map.get(name);
    }
}
