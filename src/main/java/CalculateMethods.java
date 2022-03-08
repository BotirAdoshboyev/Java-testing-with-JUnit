public class CalculateMethods {
    public int add(int a, int b) {
        return a + b;
    }

    public double divide(int a, int b) {
        if (b == 0) throw new ArithmeticException();
        return (double) a / b;
    }
}
