import java.util.ArrayList;
public class Rookfailure
 extends ChessPiece
{
    static ArrayList<int[]> verticalMoves = new ArrayList<int[]>(); 

    static ArrayList<int[]> horizontalMoves = new ArrayList<int[]>();
    public Rookfailure(boolean side, Point p)
    {
        setSide(side);
        setName("pawn");
        setPos(p);
    }

    public ArrayList<Point> move(Point[][] whereTo)
    {
        listOfMoves();
        possibleMoves.clear();
        int xVector = 0;
        int yVector = 0;
        int newXPos = 0;
        int newYPos = 0;
        //for(int[] arrayOfMoves: 

        //array of horizontal moves x is changing
        for(int[] z: horizontalMoves)
        {
            xVector = z[0];
            yVector = z[1];
            newXPos = myPosition.getX() + xVector;
            newYPos = myPosition.getY() + yVector;
            if(newXPos <8 && newXPos >0 && newYPos > 0 && newYPos < 8)
            {
                //add moves that are possible
                if(whereTo[newXPos][newYPos].getPiece() == null)
                {
                    possibleMoves.add(new Point(newXPos,newYPos));
                }
                else
                {
                    if(whereTo[newXPos][newYPos].getPiece().darkSide !=  whereTo[myPosition.getX()][myPosition.getY()].getPiece().darkSide)
                    {
                        possibleMoves.add(new Point(newXPos,newYPos));
                     }
                }
            }
        }

        return possibleMoves;
    }

    public static void listOfMoves()
    {
        int xVector = 0;
        int yVector = 0;

        /*for Rook, x moves along the columns = x x1 x2 x3 x4
         *  y counts the rows                  y
         *                                     y1
         *                                     y2
         *                                     y3
         *                                     y4 
         */

        for(int x = -7; x < 8; x++)
        {
            int[] rightleft = {x,0};
            horizontalMoves.add(rightleft);
        }

        for(int x = -7; x < 8; x++)
        {
            int[] updown = {0,x};
            verticalMoves.add(updown);
        }
        //testing x and y vectors
        for(int[] z: horizontalMoves)
        {
            xVector = z[0];
            yVector = z[1];
            System.out.println(xVector + " , " + yVector);
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
