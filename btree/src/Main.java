import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rng = new Random();
        BinaryTree bt = new BinaryTree();

        for (int i = 0; i < 11; i++) {
            bt.push(Math.abs(rng.nextInt()) % 100);
        }

        // comment
        bt.print();
    }
}