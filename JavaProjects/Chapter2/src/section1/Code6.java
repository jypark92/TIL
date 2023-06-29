package section1;

import java.util.Scanner;

public class Code6 {
    static Polynomial [] polys = new Polynomial[100];
    static int n = 0;
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        while (true) {
            System.out.print("$ ");
            String command = kb.next();
            if (command.equals("create")) {
                polys[n] = new Polynomial();
                polys[n].name = kb.next().charAt(0);
                n++;
            }
            else if (command.equals("add")) {
                char name = kb.next().charAt(0);
                int index = find(name);
                if (index == -1) {
                    System.out.println("No such polynomial exists.");
                }
                else {
                    int c = kb.nextInt();
                    int e = kb.nextInt();
                    addTerm(polys[index], c, e);
                }
            }
            else if (command.equals("calc")) {
                char name = kb.next().charAt(0);
                int index = find(name);
                if (index == -1) {
                    System.out.println("No such polynomial exists.");
                }
                else {
                    int x = kb.nextInt();
                    int result = calcPolynomial(polys[index], x);
                    System.out.println(result);
                }
            }
            else if (command.equals("print")) {
                char name = kb.next().charAt(0);
                int index = find(name);
                if (index == -1) {
                    System.out.println("No such polynomial exists.");
                }
                else {
                    printPolynomial(polys[index]);
                }
            }
            else if (command.equals("exit"))
                break;
        }
        kb.close();
    }

    static int find(char name) {
        for (int i = 0; i < n; i++)
            if (polys[i].name == name)
                return i;
        return -1;
    }
    static void addTerm(Polynomial p, int c, int e) {
        int index = findTerm(p, e);
        if (index != -1){
            p.terms[index].coef += c;
            if (p.terms[index].coef == 0) {
                Term tmp = p.terms[index];
                for (int i = p.nTerms - 1; i > index; i--)
                    p.terms[i - 1] = p.terms[i];
                p.terms[p.nTerms - 1] = tmp;
                p.nTerms--;
            }
        }
        else {
            int i = p.nTerms - 1;
            while (i >= 0 && p.terms[i].expo < e) {
                p.terms[i + 1] = p.terms[i];
                i--;
            }
            p.terms[i + 1] = new Term();
            p.terms[i + 1].coef = c;
            p.terms[i + 1].expo = e;
            p.nTerms++;
        }
    }
    static int findTerm(Polynomial p, int e) {
        for (int i = 0; i < p.nTerms && p.terms[i].expo >= e; i++)
            if (p.terms[i].expo == e)
                return i;
        return -1;
    }
    static void printPolynomial(Polynomial p) {
        if (p.nTerms == 0)
            System.out.println(0);
        else {
            for (int i = 0; i < p.nTerms - 1; i++){
                printTerm(p.terms[i]);
                System.out.print("+");
            }
            printTerm(p.terms[p.nTerms - 1]);
            System.out.println();
        }

    }
    static void printTerm(Term term) {
        System.out.print(term.coef + "x^" + term.expo);
    }
    static int calcPolynomial(Polynomial p, int x) {
        int result = 0;
        for (int i = 0; i < p.nTerms; i++)
            result += calcTerm(p.terms[i], x);
        return result;
    }
    static int calcTerm(Term term, int x) {
        return (int) (term.coef * Math.pow(x, term.expo));
    }
}
