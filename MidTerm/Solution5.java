import java.util.ArrayList;

class Cell{
    int x,y;
    Cell(int x, int y){
        this.x = x;
        this.y = y;
    }
    public String toString(){
        return "("+this.x +", "+this.y+ ")";
    }
}

public class Solution5
{
    public static void main(String[] args)
    {
        int[][] a= {{1,0,0,0},{1,1,1,1},{0,1,0,0}};
        System.out.println(findPath(a));
    }

    public static ArrayList<Cell> findPath(int[][] maze)
    {
        ArrayList<Cell> result=new ArrayList<>();
        if (maze.length==0 || maze[0].length==0)
            return result;
        ArrayList<Cell> cell=new ArrayList<>();
        cell.add(new Cell(0,0));
        findPathTest(maze, result, cell);
        return result;
    }

    static void findPathTest(int[][] maze, ArrayList<Cell> result, ArrayList<Cell> cell)
    {
        int x=cell.get(cell.size()-1).x;
        int y=cell.get(cell.size()-1).y;

        if (x==maze.length-1 && y==maze[0].length-1)
        {
            if (!result.isEmpty()) result.add(null);
            result.addAll(cell);
        }

        if ( (x<maze.length-1 && maze[x+1][y]==1) )
        {
            cell.add(new Cell(x+1,y));
            findPathTest(maze, result, cell);
            cell.remove(cell.size()-1);
        }

        if ( y<maze[0].length-1 && maze[x][y+1]==1 )
        {
            cell.add(new Cell(x,y+1));
            findPathTest(maze, result, cell);
            cell.remove(cell.size()-1);
        }
    }


}
