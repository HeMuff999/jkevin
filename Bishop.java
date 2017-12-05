import java.util.ArrayList;
public class Bishop extends ChessPiece
{
    static ArrayList<int[]> RightUp = new ArrayList<int[]>();
    static ArrayList<int[]> RightDown = new ArrayList<int[]>();
    static ArrayList<int[]> LeftUp = new ArrayList<int[]>();
    static ArrayList<int[]> LeftDown = new ArrayList<int[]>();
    public Bishop(boolean side, Point p)
    {
        setSide(side);
        setName("bishop");
        setPosition(p);
    }

    public ArrayList<Point> move(Point[][] whereTo)
    {
        listOfMoves();
        possibleMoves.clear();
        int xVector = 0;
        int yVector = 0;
        int newXPos = 0;
        int newYPos = 0;

        for(int[] a: RightUp)
        {
            xVector = a[0];
            yVector = a[1];
            newXPos = myPosition.getX() + xVector;
            newYPos = myPosition.getY() + yVector;
            if(newXPos <8 && newXPos >0 && newYPos > 0 && newYPos < 8)
            {
                //add moves that are possible
                if(whereTo[newXPos][newYPos].getPiece() == null)
                {
                    possibleMoves.add(new Point(newXPos,newYPos));

                }
                else if(whereTo[newXPos][newYPos].getPiece().darkSide !=  whereTo[myPosition.getX()][myPosition.getY()].getPiece().darkSide)
                {

                    possibleMoves.add(new Point(newXPos,newYPos));
                }
                else
                {
                    break;
                }
            }
        }

        for(int[] a: RightDown)
        {
            xVector = a[0];
            yVector = a[1];
            newXPos = myPosition.getX() + xVector;
            newYPos = myPosition.getY() + yVector;
            if(newXPos <8 && newXPos >0 && newYPos > 0 && newYPos < 8)
            {
                //add moves that are possible
                if(whereTo[newXPos][newYPos].getPiece() == null)
                {
                    possibleMoves.add(new Point(newXPos,newYPos));

                }
                else if(whereTo[newXPos][newYPos].getPiece().darkSide !=  whereTo[myPosition.getX()][myPosition.getY()].getPiece().darkSide)
                {

                    possibleMoves.add(new Point(newXPos,newYPos));
                }
                else
                {
                    break;
                }
            }
        }

        for(int[] a: LeftUp)
        {
            xVector = a[0];
            yVector = a[1];
            newXPos = myPosition.getX() + xVector;
            newYPos = myPosition.getY() + yVector;
            if(newXPos <8 && newXPos >0 && newYPos > 0 && newYPos < 8)
            {
                //add moves that are possible
                if(whereTo[newXPos][newYPos].getPiece() == null)
                {
                    possibleMoves.add(new Point(newXPos,newYPos));

                }
                else if(whereTo[newXPos][newYPos].getPiece().darkSide !=  whereTo[myPosition.getX()][myPosition.getY()].getPiece().darkSide)
                {

                    possibleMoves.add(new Point(newXPos,newYPos));
                }
                else
                {
                    break;
                }
            }
        }

        for(int[] a: LeftDown)
        {
            xVector = a[0];
            yVector = a[1];
            newXPos = myPosition.getX() + xVector;
            newYPos = myPosition.getY() + yVector;
            if(newXPos <8 && newXPos >0 && newYPos > 0 && newYPos < 8)
            {
                //add moves that are possible
                if(whereTo[newXPos][newYPos].getPiece() == null)
                {
                    possibleMoves.add(new Point(newXPos,newYPos));

                }
                else if(whereTo[newXPos][newYPos].getPiece().darkSide !=  whereTo[myPosition.getX()][myPosition.getY()].getPiece().darkSide)
                {

                    possibleMoves.add(new Point(newXPos,newYPos));
                }
                else
                {
                    break;
                }
            }
        }

        return possibleMoves;
    }

   /* public void lol(Point[][] whereTo)
    {
        int xVector = 0;
        int yVector = 0;
        int newXPos = 0;
        int newYPos = 0;

    }*/

    public static void listOfMoves()
    {
        for(int x =0; x<8; x++)
        {
            for(int y =0; y<-8; y--)
            {
                int[] RightUpDiag = {x,y};
                RightUp.add(RightUpDiag);
            }
        }

        for(int x= 0; x<8; x++)
        {
            for(int y=0; y<8; y++)
            {
                int[] RightDownDiag = {x,y};
                RightDown.add(RightDownDiag);
            }
        }

        for(int x= 0; x<-8; x--)
        {
            for(int y= 0; y<-8; y--)
            {
                int[] LeftUpDiag = {x,y};
                LeftUp.add(LeftUpDiag);
            }
        }

        for(int x=0; x<-8; x--)
        {
            for(int y =0; y<8; y++)
            {
                int[] LeftDownDiag = {x,y};
                LeftDown.add(LeftDownDiag);
            }
        }
    }
}
