import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rng = new Random();
        BinaryTree<Integer> btree = new BinaryTree<>();
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < 10; i++){
            int num = rng.nextInt() % 50 + 50;
            btree.push(num);
            arr.add(num);
        }


        System.out.println("Initialization Done");
        System.out.println("Three in pre order:");
        btree.print();
        System.out.println("Testing...");
        int i = 1_000;
        while (i > 0) {
            System.out.println("-".repeat(20));
            System.out.println(btree.size());
            btree.print();
            Integer num = rng.nextInt() % 50 + 50;

            btree.push(num);
            arr.add(num);



            int indexToDelete = rng.nextInt(arr.size());
            Integer numToDelete = arr.get(indexToDelete);

            System.out.println("To add    : " + num);
            System.out.println("To delete : " + numToDelete);

            arr.remove(indexToDelete);
            btree.delete(numToDelete);

            System.out.println("-".repeat(20));

            i--;
        }
        System.out.println("Test ended");
        System.out.println("Tree in pre order:");
        btree.print();
    }
}