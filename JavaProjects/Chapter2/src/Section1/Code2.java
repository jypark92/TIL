package Section1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code2 {
    static Person1 [] members = new Person1[100];
    static int n = 0;

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(new File("input.txt"));
            while (in.hasNext()) {
                String nm = in.next();
                String nb = in.next();
                members[n] = new Person1();
                members[n].name = nm;
                members[n].number = nb;
                n++;
            }
            in.close();
        } catch (FileNotFoundException e){
            System.out.println("No data file");
            System.exit(1);
        }

        for (int i = 0; i < n; i++)
            System.out.println(members[i].name + "'s phone number is " + members[i].number);
    }
}
