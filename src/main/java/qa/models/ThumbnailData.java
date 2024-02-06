package qa.models;

import lombok.Getter;

@Getter
public class ThumbnailData {

    private final String category;
    private final int number;
    private final String productPageUrl;

    public ThumbnailData(String category, int number, String urlPart) {

        this.category = category;
        this.number = number;
        this.productPageUrl = "https://fakestore.testelka.pl/product/" + urlPart;
    }
}
