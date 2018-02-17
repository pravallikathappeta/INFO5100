
public class SumOfDigits
{
    public int addDigits(int input )
    {
        int sum=0;
        while(input>0 || sum>9)
        {
            if(input == 0)
            {
                input = sum;
                sum = 0;
            }
            sum = sum + (input%10);
            input = input/10;
        }

        return sum;
    }

    public static void main(String args[])
    {
        SumOfDigits number1 = new SumOfDigits();
        int result = number1.addDigits(1923211);
        System.out.println("Sum of digits = "+result);
    }
}
