import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rng = new Random();
        BinaryTree<Integer> btree = new BinaryTree<>();
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < 31; i++) {
            int num = rng.nextInt() % 50 + 50;
            btree.push(num);
            arr.add(num);
        }


        System.out.println("Initialization Done");
        System.out.println("Three in pre order:");
        btree.print();
        System.out.println("Testing...");
        while (btree.maxDeep() > 5) {
            //System.out.println("-".repeat(20));

            if (btree.size() != 31) {
                System.out.println(btree.size());
                System.out.println("Error");
            }

            //btree.print();
            Integer num = rng.nextInt() % 50 + 50;

            btree.push(num);
            arr.add(num);


            int indexToDelete = rng.nextInt(arr.size());
            Integer numToDelete = arr.get(indexToDelete);

            // System.out.println("To add    : " + num);
            //System.out.println("To delete : " + numToDelete);

            arr.remove(indexToDelete);
            btree.delete(numToDelete);

            //System.out.println("-".repeat(20));

        }
        System.out.println("Test ended");
        System.out.println("Tree in pre order:");
        btree.print();
        System.out.println("MAX DEEP: " + btree.maxDeep());
    }
}