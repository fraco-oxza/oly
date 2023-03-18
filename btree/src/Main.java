import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random rng = new Random();
        LinkedList<Integer> ll = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            ll.push(rng.nextInt());
        }

        ll.print();
        System.out.println(ll.index(2));


        for (int i = 0; i < 10; i++) {
            ll.pop_back();

        }
        System.out.println("=".repeat(10));
        ll.print();
        System.out.println("=".repeat(10));


    }
}