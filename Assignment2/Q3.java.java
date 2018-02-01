
/*problem 3*/

import java.util.Scanner;

public class Assignment2
{
    public static void main(String args[])
    {
        Assignment2 obj = new Assignment2();
        obj.indices();

    }

    public void indices()
    {
        int[] nums = {2,7,11,15,1,3};
        int target;
        int[] solution=new int[2];
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter target number");
        target = scan.nextInt();

        //checking sum
        for (int m=0; m<nums.length; m++)
        {
            for (int n=m+1; n<nums.length; n++)
            {
                if(nums[m] + nums[n] == target)
                {
                    solution[0] = m;
                    solution[1] = n;
                    System.out.println("[ "+m+","+n+" ]");
                    System.out.println(nums[m] + " + "+nums[n] + " == target");
                    break;
                }

            }
        }
        if(solution[0] == 0 && solution[1] == 0)
            System.out.println("No solution found");

    }
}
