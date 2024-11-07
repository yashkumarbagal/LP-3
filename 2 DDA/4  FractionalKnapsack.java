import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Item {
    int price;
    int weight;

    Item(int price, int weight) {
        this.price = price;
        this.weight = weight;
    }
}

public class FractionalKnapsack {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of items: ");
        int n = scanner.nextInt(); // Number of items
        Item[] arr = new Item[n];

        // Input prices and weights from user
        for (int i = 0; i < n; i++) {
            System.out.print("Enter price of item " + (i + 1) + ": ");
            int price = scanner.nextInt();
            System.out.print("Enter weight of item " + (i + 1) + ": ");
            int weight = scanner.nextInt();
            arr[i] = new Item(price, weight);
        }

        System.out.print("Enter the weight limit: ");
        int w = scanner.nextInt(); // Weight limit
        double price = 0;

        // Sort items by value-to-weight ratio in descending order
        Arrays.sort(arr, new Comparator<Item>() {
            public int compare(Item a, Item b) {
                double r1 = (double) a.price / a.weight;
                double r2 = (double) b.price / b.weight;
                return Double.compare(r2, r1); // Descending order
            }
        });

        // Calculate maximum price
        for (int i = 0; i < arr.length; i++) {
            int itemWt = arr[i].weight;
            int itemP = arr[i].price;
            if (itemWt > w) {
                price += w * ((double) itemP / itemWt);
                break;
            } else {
                price += itemP;
                w -= itemWt;
            }
        }

        System.out.println("Maximum price that can be obtained: " + price);
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
 * Maximum price that can be obtained: 1033.3333333333335
 */