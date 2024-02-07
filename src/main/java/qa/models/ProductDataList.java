package qa.models;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class ProductDataList {

    @Getter
    private static List<ProductData> products = new ArrayList<>();

    public static void addData(ProductData data) {

        products.add(data);
    }
}
