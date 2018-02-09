/* Question 3-B */

public class UniqueTriplets
{
    public static void main(String args[])
    {
        UniqueTriplets ut = new UniqueTriplets();
        ut.sumZero();
    }

    public void sumZero()
    {
        int[] S = {-1,0,1,2,-1,-4};
        System.out.println("Initial array is: ");
        for (int a = 0; a<S.length; a++)
        {
            System.out.print(S[a] + " ");
        }

        //sorting elements
        for (int b = 0; b < S.length; b++)
        {
            for (int c = b + 1; c < S.length; c++)
            {
                if (S[b] > S[c])
                {
                    int temp = S[b];
                    S[b] = S[c];
                    S[c] = temp;
                }
            }
        }

        System.out.println("\nInitial array after sorting: ");
        for (int z = 0; z<S.length; z++)
        {
            System.out.print(S[z] + " ");
        }

        System.out.println("\n Unique triplets with sum = 0");

        //checking for sum of elements = 0;

        for(int i=0;i<S.length;i++)
        {
            if (i>1 && S[i] == S[i-1])
                    continue;
            else
            for(int j=i+1;j<S.length;j++)
            {
                    for(int k=j+1;k<S.length;k++)
                    {
                        if((S[i]+S[j]+S[k])==0 )
                        {
                            System.out.println("["+S[i]+","+S[j]+","+S[k]+"]");
                        }
                    }
            }
        }
    }
}
