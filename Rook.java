import java.util.ArrayList;
public class Rook extends ChessPiece
{
    static ArrayList<int[]> verticalMoves = new ArrayList<int[]>(); 
    
    static ArrayList<int[]> horizontalMoves = new ArrayList<int[]>();
    public Rook(boolean side, Point p)
    {
        setSide(side);
        setName("pawn");
        setPos(p);
    }

    public ArrayList<Point> move(Point[][] whereTo)
    {
        listOfMoves();
        possibleMoves.clear();
        //for(int[] arrayOfMoves: 
        if(darkSide)
        {
            
        }
        else
        {
        }
        return possibleMoves;
    }

    public static void listOfMoves()
    {

        
        for(int x = -7; x < 8; x++)
        {
            int[] rightleft = {0,x};
            horizontalMoves.add(rightleft);
        }
        
        for(int x = -7; x < 8; x++)
        {
            int[] updown = {x,0};
            verticalMoves.add(updown);
        }
        

    }

    public static void main (String [] args)
    {
        
        // == testing if arraylist works
        
         listOfMoves();
        int[] z;
        for(int x = 0; x < 15; x++)
        {
            z = verticalMoves.get(x);
            System.out.println(z[0] + "," + z[1]);
        }
       
    }
}