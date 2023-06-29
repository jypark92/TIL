package section2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code21 {
    static int n;
    static int [][] grid;
    static int [] offsetX = {0, 1, 1, 1, 0, -1, -1, -1};
    static int [] offsetY = {-1, -1, 0, 1, 1, 1, 0, -1};
    public static void main(String[] args) {
        try{
            Scanner inFile = new Scanner(new File("data.txt"));
            n = inFile.nextInt();
            grid = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++)
                    grid[i][j] = inFile.nextInt();
            }
            inFile.close();
            for (int x = 0; x < n; x++){
                for (int y = 0; y < n; y++){
                    for (int dir = 0; dir < 8; dir ++){
                        for (int len = 1; len <= n; len ++){
                            int val = computeValue(x, y, dir, len);
                            if (val != -1 && isPrime(val))
                                System.out.println(val);
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static int computeValue(int x, int y, int dir, int len) {
        int value = 0;
        for (int i = 0; i < len; i++) {
            int digit = getDigit(x, y, dir, i);
            if (digit == -1)
                return -1;
            value = value * 10 + digit;
        }
        return value;
    }
    public static int getDigit(int x, int y, int dir, int len) {
        int newX = x + len * offsetX[dir];
        int newY = y + len * offsetY[dir];
        if (newX < 0 || newX >= grid.length || newY < 0 || newY >= grid.length)
            return -1;
        else
            return grid[newX][newY];
    }
    public static boolean isPrime(int k) {
        if (k < 2)
            return false;
        for (int i = 2; i * i <= k; i++)
            if (k % i == 0)
                return false;
        return true;
    }
}
