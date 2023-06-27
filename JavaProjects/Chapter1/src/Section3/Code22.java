package Section3;

import java.io.*;
import java.util.Scanner;

public class Code22 {
    static String [] words = new String [100000];
    static int [] count = new int [100000];
    static int n = 0;
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        while (true) {
            System.out.print("$ ");
            String command = kb.next();
            if (command.equals("read")){
                String fileName = kb.next();
                makeIndex(fileName);
            } else if (command.equals("find")) {
                String str = kb.next();
                int index = findWord(str);
                if (index > -1) {
                    System.out.println("The word " + words[index] + " appears "+ count[index] + " times.");
                }
                else
                    System.out.println("The word" + str + " does not appear.");
            } else if (command.equals("saveas")) {
                String fileName = kb.next();
                saveAs(fileName);
            } else if (command.equals("exit"))
                break;
        }
        kb.close();
    }
    static void saveAs(String fileName) {
        try{
            PrintWriter outFile = new PrintWriter(new FileWriter(fileName));

            for (int i = 0; i < n; i++)
                outFile.println(words[i] + " " + count[i]);

            outFile.close();
        } catch (IOException e) {
            System.out.println("Save failed");
            return;
        }
    }
    static void makeIndex(String fileName) {
        try {
            Scanner inFile = new Scanner(new File(fileName));
            while (inFile.hasNext()) {
                String str = inFile.next();
                addWord(str);
            }
            inFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("No File");
            return;
        }
    }
    static void addWord(String str) {
        int index = findWord(str);
        if (index != -1) {
            count[index]++;
        }
        else {
            words[n] = str;
            count[n] = 1;
            n++;
        }
    }
    static int findWord(String str) {
        for (int i = 0; i < n; i++)
            if (words[i].equalsIgnoreCase(str))
                return i;
        return -1;
    }
}
