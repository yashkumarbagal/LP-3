import java.util.Scanner;

class Item {
    int price;
    int weight;

    Item(int price, int weight) {
        this.price = price;
        this.weight = weight;
    }
}

public class ZeroOneKnapsack {

    public static int knapsack(Item[] items, int n, int weightLimit) {
        // Create a DP table to store the maximum price for each weight limit
        int[][] dp = new int[n + 1][weightLimit + 1];

        // Fill DP table
        for (int i = 1; i <= n; i++) {
            int itemWeight = items[i - 1].weight;
            int itemPrice = items[i - 1].price;

            for (int w = 0; w <= weightLimit; w++) {
                if (itemWeight <= w) {
                    // Include or exclude the item
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - itemWeight] + itemPrice);
                } else {
                    // Exclude the item
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        // The last cell of the table contains the maximum price for the given weight
        // limit
        return dp[n][weightLimit];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of items: ");
        int n = scanner.nextInt(); // Number of items
        Item[] items = new Item[n];

        // Input prices and weights from user
        for (int i = 0; i < n; i++) {
            System.out.print("Enter price of item " + (i + 1) + ": ");
            int price = scanner.nextInt();
            System.out.print("Enter weight of item " + (i + 1) + ": ");
            int weight = scanner.nextInt();
            items[i] = new Item(price, weight);
        }

        System.out.print("Enter the weight limit: ");
        int weightLimit = scanner.nextInt();

        // Get the maximum price possible with the given weight limit
        int maxPrice = knapsack(items, n, weightLimit);

        System.out.println("Maximum price that can be obtained: " + maxPrice);
        scanner.close();
    }
}
/*
 * OUTPUT:
 * 
 * Enter the number of items: 3
 * Enter price of item 1: 500
 * Enter weight of item 1: 30
 * Enter price of item 2: 400
 * Enter weight of item 2: 20
 * Enter price of item 3: 300
 * Enter weight of item 3: 10
 * Enter the weight limit: 50
 * Maximum price that can be obtained: 900
 */