package competitiveProgramming.random;

public class BarterMarket {
    public static void main(String[] args) {
        System.out.println(barterMarket(393, 896, 787, 920));
    }

    public static int barterMarket(int comicBooksCount, int totalCoins, int costInCoins, int comicSellingPrice) {
        int fiction = 0;
        while(comicBooksCount > 0) {
            if(totalCoins > costInCoins) {
                totalCoins = totalCoins - costInCoins;
                fiction++;
            } else {
                totalCoins += comicSellingPrice;
            }
            comicBooksCount--;
        }
        return fiction;
    }
}
