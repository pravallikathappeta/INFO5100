public class SpiralMatrix {

    public static void spiralmatrix(int matrix[][])

    {
        for (int breadth = 0; breadth <= matrix.length / 2; ++breadth)
        {
            boolean stop = true;
            for (int len =  breadth; len < matrix[0].length - breadth; ++len)
            {
                stop = false;
                System.out.println(matrix[breadth][len]);
            }
            if (stop)
            {
                break;
            }
            else
            {
                stop = true;
            }
            for (int len = 1 + breadth; len < matrix.length - breadth; ++len)
            {
                stop = false;
                System.out.println(matrix[len][matrix[0].length - 1 - breadth]);
            }

            if (stop)
            {
                break;
            }
            else
            {
                stop = true;
            }


            for (int len = matrix[0].length - 2 - breadth; len >= 0 + breadth; --len)
            {
                stop = false;
                System.out.println(matrix[matrix.length - 1 - breadth][len]);
            }

            if (stop)
            {
                break;
            }
            else
            {
                stop = true;
            }
            for (int len = matrix.length - 2 - breadth; len >= 1 + breadth; --len)
            {
                System.out.println(matrix[len][breadth]);
            }

            if (stop)
            {
                break;
            }
        }
    }

    public static void main(String args[])
    {
        int matrix[][] = { { 1, 2 ,3},
                {4,7,11},
                { 5, 6, 14 },
                { 9, 10, 64 } };
        spiralmatrix(matrix);
    }
}