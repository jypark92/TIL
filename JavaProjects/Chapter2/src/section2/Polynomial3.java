package section2;

public class Polynomial3 {
    public char name;
    public Term3[] terms;
    public int nTerms;
    public Polynomial3() {
        nTerms = 0;
        terms = new Term3[100];
    }

    public Polynomial3(char name) {
        this.name = name;
        nTerms = 0;
        terms = new Term3[100];
    }
    public void addTerm(int c, int e) {
        int index = findTerm(e);
        if (index != -1){
            terms[index].coef += c;
            if (terms[index].coef == 0) {
                Term3 tmp = terms[index];
                for (int i = nTerms - 1; i > index; i--)
                    terms[i - 1] = terms[i];
                terms[nTerms - 1] = tmp;
                nTerms--;
            }
        }
        else {
            int i = nTerms - 1;
            while (i >= 0 && terms[i].expo < e) {
                terms[i + 1] = terms[i];
                i--;
            }
            terms[i + 1] = new Term3(c, e);
            nTerms++;
        }
    }
    public int findTerm(int e) {
        for (int i = 0; i < nTerms && terms[i].expo >= e; i++)
            if (terms[i].expo == e)
                return i;
        return -1;
    }
    public void printPolynomial() {
        if (nTerms == 0)
            System.out.println(0);
        else {
            for (int i = 0; i < nTerms - 1; i++){
                terms[i].printTerm();
                System.out.print("+");
            }
            terms[nTerms - 1].printTerm();
            System.out.println();
        }

    }

    public int calcPolynomial(int x) {
        int result = 0;
        for (int i = 0; i < nTerms; i++)
            result += terms[i].calcTerm(x);
        return result;
    }

}
