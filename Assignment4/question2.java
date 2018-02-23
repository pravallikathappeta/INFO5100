feedback: 
1. keep main function short and write the logic in the method function.
2. in the map, you use index as key and the elements as value. if you want to delete one element, we always search it by map.get(element)
so you should keep the value in the key postion, and count the time in the value part.
3. about delete function, the requirement is delete the element 6,8. You shouldn't assume you know their index, then delete it.
4. please pay attention to coding style. use if(){} else{}.
5. give return value and system print the function in "main".
  
    scores : 1.5 / 2
      
     total : 9 / 10




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
