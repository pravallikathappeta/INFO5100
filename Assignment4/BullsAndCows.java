nice try, but I suggest you use a clear logic to solve the problem , please look at my answer and learn it:

 public String getHint(String secret, String guess) {
        if(guess.equals("") || guess.length() == 0){
            return "";
        }
        int countA = 0, countB = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(char ch : secret.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0) + 1);
        }
        for(int i = 0 ;i < secret.length(); i++){
            if(secret.charAt(i) == guess.charAt(i)){
                countA++;
                map.put(secret.charAt(i), map.get(secret.charAt(i)) - 1);
            }
        } 
        for(int i = 0 ;i < secret.length(); i++){
            if(secret.charAt(i) != guess.charAt(i) && map.containsKey(guess.charAt(i))){
                if(map.get(guess.charAt(i)) > 0){
                    map.put(guess.charAt(i), map.get(guess.charAt(i)) - 1);
                    countB++;
            }  
        }
        }
        return countA + "A" + countB + "B";
    }


more simple approach: 

public String getHint(String secret, String guess) {
    int bulls = 0;
    int cows = 0;
    int[] numbers = new int[10];
    for (int i = 0; i<secret.length(); i++) {
        int s = Character.getNumericValue(secret.charAt(i));
        int g = Character.getNumericValue(guess.charAt(i));
        if (s == g) bulls++;
        else {
            if (numbers[s] < 0) cows++;
            if (numbers[g] > 0) cows++;
            numbers[s] ++;
            numbers[g] --;
        }
    }
    return bulls + "A" + cows + "B";
}


scores:  1.5 / 2.0









import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;
class BullsAndCows{
    public static void main(String args[]){
        int i,j,bull=0,cow=0;
        int[] secretDigit,arr;
        Scanner scan=new Scanner(System.in);
        String msg, ans, playNextGame;
        secretDigit=new int[4];
        arr=new int[4];
        Random rand=new Random();
        Pattern regex=Pattern.compile("^\\d{4}$|^quit$");
        do{
            String secret="";
            playNextGame="";
            for(i=0;i<4;i++){
                secretDigit[i]=rand.nextInt(10);
                secret+=secretDigit[i];
            }
            do{
                do{
                    System.out.print("Please enter a 4-digit number (or type 'quit' to exit):");
                    ans=scan.nextLine().trim();
                    System.out.println(ans);
                }while(!regex.matcher(ans).find());
                if(ans.equals("quit")){
                    System.out.println("The secret number is: " + secret);
                }else{
                    cow=0;
                    bull=0;
                    for(i=0;i<4;i++)
                        try{
                            arr[i]=Integer.parseInt(ans.substring(i,i+1));
                            if(arr[i]==secretDigit[i]) bull++;
                        }catch(NumberFormatException nfe){}
                    for(i=0;i<4;i++)
                        for(j=0;j<4;j++)
                            if(arr[j]==secretDigit[i]){
                                cow++;
                                arr[j]=-1;
                                break;
                            }
                    cow-=bull;
                    msg="";
                    if(cow==0 && bull==0){
                        msg="Neither a bull nor a cow!";
                    }else{
                        if(bull==4)
                            msg="4 bulls! You are a genius!";
                        else{
                            if(cow==0){
                                if(bull==1)
                                    msg="1 bull only.";
                                else
                                    msg=bull + " bulls only.";
                            }else if(bull==0){
                                if(cow==1)
                                    msg="1 cow only.";
                                else
                                    msg=cow + " cows only.";
                            }else{
                                if(bull==1)
                                    msg="1 bull and ";
                                else
                                    msg=bull + " bulls and ";
                                if(cow==1)
                                    msg+="1 cow.";
                                else
                                    msg+=cow + " cows.";
                            }
                        }
                    }
                    System.out.println(msg);
                }
            }while(bull!=4 && !ans.equals("quit"));
            if(!ans.equals("quit")){
                do{
                    System.out.print("Do you want to play a new game (Y/N)?");
                    playNextGame=scan.nextLine().trim();
                    System.out.println(playNextGame);
                }while(!playNextGame.toUpperCase().equals("Y") && !playNextGame.toUpperCase().equals("N"));
            }
        } while (playNextGame.toUpperCase().equals("Y") && !ans.equals("quit"));

    }
}
