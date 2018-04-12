public class ReverseHello extends Thread
{

    private int num;
    private String name;
    private final int end;

    public ReverseHello(int start, int end)
    {
        this.num=start;
        this.name="Thread "+start;
        this.end=end;
    }

    public void run()
    {
        if (num<end)
        {
            ReverseHello next=new ReverseHello(num+1, this.end);
            next.start();
            try
            {
                next.join();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        System.out.println("Hello from "+this.name+"!");
    }

    public static void main(String[] args)
    {
        ReverseHello t=new ReverseHello(1,50);
        t.start();
    }

}
