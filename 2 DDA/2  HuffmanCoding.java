import java.util.PriorityQueue;
import java.util.Scanner;

class MinHeapNode {
    char data;
    int freq;
    MinHeapNode left, right;

    // Constructor for a MinHeapNode
    MinHeapNode(char data, int freq) {
        left = right = null;
        this.data = data;
        this.freq = freq;
    }
}

// Comparator class to order the heap based on frequency
class MinHeapComparator implements java.util.Comparator<MinHeapNode> {
    public int compare(MinHeapNode a, MinHeapNode b) {
        return a.freq - b.freq;
    }
}

public class HuffmanCoding {

    // Function to print the Huffman codes from the root of the Huffman Tree
    public static void printCodes(MinHeapNode root, String str) {
        if (root == null) {
            return;
        }
        // If the node is not a special internal node
        if (root.data != '$') {
            System.out.println(root.data + ": " + str);
        }
        printCodes(root.left, str + "0");
        printCodes(root.right, str + "1");
    }

    // Function to build the Huffman Tree and print the codes
    public static void HuffmanCode(char[] data, int[] freq, int size) {
        // Create a priority queue (min heap)
        PriorityQueue<MinHeapNode> minHeap = new PriorityQueue<>(size, new MinHeapComparator());

        // Add all characters to the priority queue
        for (int i = 0; i < size; i++) {
            minHeap.add(new MinHeapNode(data[i], freq[i]));
        }

        // Iterate until the heap size reduces to 1
        while (minHeap.size() != 1) {
            // Extract the two nodes with minimum frequency
            MinHeapNode left = minHeap.poll();
            MinHeapNode right = minHeap.poll();

            // Create a new internal node with a frequency equal to the sum of the two
            MinHeapNode temp = new MinHeapNode('$', left.freq + right.freq);
            temp.left = left;
            temp.right = right;

            // Add the new node to the priority queue
            minHeap.add(temp);
        }

        // Print the Huffman Codes
        printCodes(minHeap.peek(), "");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of characters: ");
        int n = scanner.nextInt();

        char[] data = new char[n];
        int[] freq = new int[n];

        // Input character data and frequencies
        for (int i = 0; i < n; i++) {
            System.out.print("Enter character " + (i + 1) + ": ");
            data[i] = scanner.next().charAt(0);
            System.out.print("Enter frequency for character '" + data[i] + "': ");
            freq[i] = scanner.nextInt();
        }

        System.out.println("Huffman Codes for the given characters:");
        HuffmanCode(data, freq, n);

        scanner.close();
    }
}

OUTPUT:

Enter the
number of characters:4
Enter character 1:
A Enter frequency for character'A':45
Enter character 2:
B Enter frequency for character'B':13
Enter character 3:
C Enter frequency for character'C':12
Enter character 4:
D Enter frequency for character'D':16
Huffman Codes for
the given characters:D:00 C:010 B:011 A:
1
