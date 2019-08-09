import java.util.Scanner;




public class Calculator {


    enum Operations {
        ADD, SUBTRACT, MULTIPLY, DIVIDE;
    }

    Operations op;

    public Calculator(Operations op) {
        this.op = op;
    }

    public void calci(int x, int y) {
        switch (op) {
            case ADD:
                System.out.println(x + y);
                break;

            case SUBTRACT:
                System.out.println(x - y);
                break;

            case MULTIPLY:
                System.out.println(x * y);
                break;

            case DIVIDE:
                try {
                    System.out.println(x / y);
                } catch (ArithmeticException ae) {

                }
                break;
            default:
                System.out.println("Wrong choice entered!");
        }

    }


    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int x, y, ans = 0;
        do {
            System.out.println("Enter 2 numbers");
            x = sc.nextInt();
            y = sc.nextInt();
            System.out.println("Enter the operation to perform\nADD\nSUBTRACT\nMULTIPLY\nDIVIDE");
            String s = sc.next();
            Calculator c = new Calculator(Operations.valueOf(s));
            c.calci(x, y);
            System.out.println("Do you want to continue?(1/0)");
            ans = sc.nextInt();
        } while (ans == 1);

    }
}
