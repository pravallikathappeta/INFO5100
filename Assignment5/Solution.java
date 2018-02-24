public class Solution
{
    public boolean isValid(String s)
    {
        boolean valid = false;

        if(s.length() % 2 !=0 )
        {
            valid = false;
        }

        else
        {
        for(int i=0;i<s.length();i+=2)
        {
            inner:
            for (int j = i + 1; j < s.length(); j++) {
                char open = s.charAt(i);
                char close = s.charAt(j);

                if ((open == '(' && close == ')') || (open == '{' && close == '}') || (open == '[' && close == ']')) {
                    valid = true;
                } else {
                    valid = false;
                    break;
                }
                break inner;
            }
        }
        }
        return valid;
    }

    public static void main(String[] args) {
        Solution question4 = new Solution();
        boolean  sol = question4.isValid("[]{}[" );
        if(sol == true)
        {
            System.out.println("String is valid");
        }
        else
        {
            System.out.println("String is not valid");
        }
    }
}
