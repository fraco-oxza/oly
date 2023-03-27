package ProblemB;

import java.util.ArrayList;
import java.util.Scanner;

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Line {
    int a;
    int b;


    Line(int a, int b) {
        this.a = a;
        this.b = b;
    }

    int eval(int x) {
        return a * x + b;
    }
}

class Solution {
    String solve(ArrayList<Point> points, ArrayList<Line> lines) {
        StringBuilder result = new StringBuilder();
        ArrayList<Integer> availablePoints = new ArrayList<>();
        for (int i = 0; i < points.size(); i++) availablePoints.add(i);

        for (Line line : lines) {

            int counter = 0;
            StringBuilder match_points = new StringBuilder();
            for (int i = 0; i < availablePoints.size(); i++) {
                int index = availablePoints.get(i);
                Point p = points.get(index);
                if (line.eval(p.x) > p.y) {
                    match_points.append(index + 1).append(" ");
                    counter++;
                    availablePoints.remove(i);
                    i--;
                }
            }

            result.append(counter).append(" ").append(match_points).append("\n");
        }


        return result.toString();
    }
}

public class App {
    public static void main(String[] args) {
        int points_len;
        Scanner sc = new Scanner(System.in);
        ArrayList<Point> points = new ArrayList<>();

        points_len = sc.nextInt();

        for (int i = 0; i < points_len; i++) {
            points.add(new Point(sc.nextInt(), sc.nextInt()));
        }

        int players = sc.nextInt();
        ArrayList<Line> lines = new ArrayList<>();

        for (int i = 0; i < players; i++) {
            lines.add(new Line(sc.nextInt(), sc.nextInt()));
        }

        Solution solution = new Solution();
        System.out.println(solution.solve(points, lines));
    }
}
