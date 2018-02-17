package com.pavi;

import java.util.HashMap;

public class question2
{
    public static void main(String args[])
    {
        int[] A = {1,4,5,2,2,2,6,8,3,2,1};
        HashMap<Integer,Integer>initmap = new HashMap<Integer,Integer>();
        for (int i=0; i<A.length;i++)
        {
            initmap.put(i,A[i]);
        }
        System.out.println("Initially HashMap contains: "+initmap);

        initmap.remove(6);
        initmap.remove(7);

        System.out.println("After deleting elements in HashMap: "+initmap);

        boolean isValuePresent = initmap.containsValue(4);
        if(isValuePresent == true)
        System.out.println("value is present");
        else
            System.out.println("Value not present");
    }
}