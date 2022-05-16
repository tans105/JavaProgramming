package competitiveProgramming.interview.groupon;

import java.util.*;

//Given The product and its price, find the number of products that were sold in incorrect price
public class ErrorToSell {
    public static void main(String[] args) {
        List<String> products = Arrays.asList("e", "m", "c");
        List<Float> productPrices = Arrays.asList(2.89f, 3.29f, 5.79f);
        List<String> productSold = Arrays.asList("e", "e", "c", "m");
        List<Float> soldPrice = Arrays.asList(2.89f, 2.99f, 5.97f, 3.29f);
        System.out.println(priceCheck(products, productPrices, productSold, soldPrice));

    }

    public static int priceCheck(List<String> products, List<Float> productPrices, List<String> productSold, List<Float> soldPrice) {
        Map<String, List<Float>> pricesMap = new HashMap<>();
        Map<String, Float> correctPriceMap = new HashMap<>();

        for (int i = 0; i < productSold.size(); i++) {
            List<Float> price = pricesMap.getOrDefault(productSold.get(i), new ArrayList<>());
            price.add(soldPrice.get(i));
            pricesMap.put(productSold.get(i), price);
        }

        for (int i = 0; i < products.size(); i++) {
            correctPriceMap.put(products.get(i), productPrices.get(i));
        }

        int errors = 0;

        for (Map.Entry<String, List<Float>> entry : pricesMap.entrySet()) {
            Float correctPrice = correctPriceMap.get(entry.getKey());
            List<Float> prices = entry.getValue();

            for (Float price : prices) {
                if(!price.equals(correctPrice)) errors++;
            }
        }

        return errors;
    }
}
