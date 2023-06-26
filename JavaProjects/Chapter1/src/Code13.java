import java.util.Scanner;
public class Code13 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int [] data = new int[n];

        for (int i = 0; i < n; i++)
            data[i] = kb.nextInt();
        kb.close();

        int max = 0;
        for (int i = 0; i < n; i++) {
            int val = 0;
            for (int j = i; j < n; j++) {
                // convert data[i]...data[j] into an integer
                val = val * 10 + data[j];

                // test if it is a prime
                boolean isPrime = true;
                for (int k = 2; k * k <= val && isPrime; k++)
                    if (val % k == 0)
                        isPrime = false;

                // if yes, compare to the max
                if (isPrime && val > 1 && val > max)
                    max = val;
            }
        }
        if (max > 0)
            System.out.println(max);
        else
            System.out.println("No prime number");
    }
}
