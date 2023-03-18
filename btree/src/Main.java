import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random rng = new Random();
        BinaryTree<Integer> btree = new BinaryTree<>();

        for (int i = 0; i < 10000000; i++) {
            btree.push(Math.abs(rng.nextInt() % 1000000));
        }

        btree.push(123);

        Scanner sc = new Scanner(System.in);
        sc.nextInt();
        System.out.println("Binary tree created");

        if (btree.contains(123)) {
            System.out.println("Lo contiene");
        } else System.out.println("No lo contiene");
        sc.close();
    }
}