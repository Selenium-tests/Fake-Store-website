package qa.utils;

import lombok.Getter;

@Getter
public class ThumbnailData {

    private final String category;
    private final int number;

    public ThumbnailData(String category, int number) {

        this.category = category;
        this.number = number;
    }
}
