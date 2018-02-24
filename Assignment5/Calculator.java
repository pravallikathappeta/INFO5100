
import java.util.Scanner;

public class Calculator
{
    public void cal()
    {
        System.out.println("What do you want to perform?\n1.Arithmetic operations\n2.Root and Cube Operations\n3.Conversions\n4.quadratic equations ");
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        switch (choice) {
            case 1:
                arithmeticOperations();
                break;

            case 2:
                rootOperations();
                break;

            case 3:
                conversion();
                break;

            case 4:
                quadratic();
                break;

            default:
                System.out.println("Invalid choice. Try Again");
                cal();
        }
    }

    public static void arithmeticOperations()
    {
        {
            System.out.println("Enter two numbers");
            Scanner scan = new Scanner(System.in);
            float num1 = scan.nextInt();
            float num2 = scan.nextInt();
            float sum,difference,product,division,remainder;
            sum = num1 + num2;
            difference = num1 - num2;
            product = num1 * num2;
            division = num1/num2;
            remainder = num1%num2;
            System.out.println("Sum: "+num1+ " + "+num2 + " = "+sum);
            System.out.println("Difference: "+num1+ " - "+num2+ " = "+difference);
            System.out.println("Product: "+num1+" * "+num2+ " = "+product);
            System.out.println("Division: "+num1+" / "+num2+ " = "+division);
            System.out.println("Remainder: "+remainder);

        }
    }

    public static void rootOperations()
    {
        System.out.println("Enter a number");
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        int sqr,cube;
        double sqroot = Math.sqrt(number);
        sqr = number * number;
        cube = number * number * number;
        System.out.println("Square root of "+number+" = "+sqroot);
        System.out.println("Square of "+number+" = "+sqr);
        System.out.println("Cube of "+number+" = "+cube);
    }

    public static void conversion()
    {
        System.out.println("What do you want to convert\n1.Fahrenheit to Celsius\n2.Celsius to Fahrenheit\n3.Feet to Inches\n4.Inches to Inches to Feet");
        Scanner scan = new Scanner(System.in);
        int conchoice = scan.nextInt();
        switch (conchoice){
            case 1:
                System.out.println("Fahrenheit to Celsius");
                System.out.println("Enter temperature in Fahrenheits");
                double tempf = scan.nextDouble();
                double tempc;
                tempc = ((tempf - 32)/1.8);
                System.out.println(tempf+"F"+" = "+tempc+"C");
                break;

            case 2:
                System.out.println("Celsius to Fahrenheit");
                System.out.println("Enter tempertaure in Celsius");
                double temc = scan.nextDouble();
                double temf;
                temf = ((temc * 1.8) + 32);
                System.out.println(temc+"C"+" = "+temf+"F");
                break;

            case 3:
                System.out.println("Feet to Inches");
                System.out.println("Enter feet");
                double feet = scan.nextDouble();
                double inches = 8 * feet;
                System.out.println(feet+"Feet"+" = "+inches+"inches");
                break;

            case 4:
                System.out.println("Inches to Feet");
                System.out.println("Enter inches");
                double inch = scan.nextDouble();
                double fet = inch/12;
                System.out.println(inch+"inches"+" = "+fet+"feet");
                break;
        }
    }

    public static void quadratic()
    {
        System.out.println("The quadratic equation is of the form a(x.x)+b(x)+c");
        System.out.println("Enter the values of a,b,c");
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        double discriminant,temp;
        double result1,result2;
        double[] roots = new double[2];
        temp = ((b*b) - (4 * a * c));
        discriminant = Math.sqrt(temp);
        result1 = ((-b + discriminant)/(2*a));
        result2 = ((-b - discriminant)/(2*a));
        roots[0] = result1;
        roots[1] = result2;
        System.out.println("roots are ");
        for (int i=0;i<2;i++)
        {
            System.out.println(roots[i]);
        }
    }

    public static void main(String[] args) {
        Calculator numbers = new Calculator();
        numbers.cal();
    }
}
