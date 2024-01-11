package qa.utils;

import java.util.HashMap;

public class ThumbnailDataProvider {

    private static final HashMap<String, ThumbnailData> map = new HashMap<>() { {

        put("Windsurfing w Lanzarote (Costa Teguise)", new ThumbnailData("Popularne", 0));
        put("Yoga i pilates w Karaibach", new ThumbnailData("W promocji", 1));
    }};

    public static ThumbnailData getThumbnailData(String name) {

        return map.get(name);
    }
}
