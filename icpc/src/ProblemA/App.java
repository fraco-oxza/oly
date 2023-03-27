package ProblemA;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Solution {
    public String solve(ArrayList<ArrayList<Integer>> people) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < people.size(); i++) {
            boolean canLose = false;
            boolean canReturn = false;

            boolean isUniqueChild1 = true;
            boolean isUniqueChild2 = true;

            int child1 = people.get(i).get(0);
            int child2 = people.get(i).get(1);

            for (int j = 0; j < people.size() && !canLose; j++) {
                if (i == j) continue;
                ArrayList<Integer> trace = new ArrayList<>(people.get(j));

                for (int k = 0; k < trace.size(); k++) {
                    if (!(isUniqueChild1 && isUniqueChild2) && canReturn) {
                        canLose = true;
                        break;
                    }

                    if (trace.get(k) == i) {
                        canReturn = true;
                        continue;
                    }
                    if (child1 == trace.get(k)) isUniqueChild1 = false;
                    if (child2 == trace.get(k)) isUniqueChild2 = false;

                    int next1 = people.get(trace.get(k)).get(0);
                    int next2 = people.get(trace.get(k)).get(1);

                    if (!trace.contains(next1)) trace.add(next1);
                    if (!trace.contains(next2)) trace.add(next2);
                }
            }

            if (!(isUniqueChild1 && isUniqueChild2) && canReturn) result.append("Y");
            else result.append("N");
            System.out.print(".");
        }
        System.out.println();

        return result.toString();
    }
}

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rng = new Random();
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();

        int len = 1000;
        ArrayList<Integer> ith;

        for (int i = 0; i < len; i++) {
            ith = new ArrayList<>();
            int posible1;
            do {
                posible1 = rng.nextInt(0, len);
            } while (posible1 == i);

            int posible2;
            do {
                posible2 = rng.nextInt(0, len);
            } while (posible2 == i || posible1 == posible2);

            ith.add(posible1);
            ith.add(posible2);

            input.add(ith);
        }

        sc.close();
        System.out.println(input);

        Solution solution = new Solution();

        String output = solution.solve(input);
        System.out.println(output);
    }
}
