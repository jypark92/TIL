package section2;

public class Term3 {
    public int coef;
    public int expo;
    public Term3(int c, int e) {
        coef = c;
        expo = e;
    }
    public int calcTerm(int x) {

        return (int) (coef * Math.pow(x, expo));
    }
    public void printTerm() {
        System.out.print(coef + "x^" + expo);
    }
}
