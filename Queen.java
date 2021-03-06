import java.util.ArrayList;
public class Queen extends ChessPiece
{
    public Queen(boolean side, Point p)
    {
        setSide(side);
        setName("queen");
        setPosition(p);
    }

    public ArrayList<Point> move(Point[][] whereTo)
    {
        possibleMoves.clear();

        for(int x = myPosition.getX()+1; x <= 7; x++)
        {
            if(whereTo[x][myPosition.getY()].getPiece() != null)
            {
                if(whereTo[x][myPosition.getY()].getPiece().darkSide == darkSide)
                {
                    break;
                }
                else
                {
                    possibleMoves.add(new Point(x, myPosition.getY()));
                    break;
                }
            }
            else
            {
                possibleMoves.add(new Point(x, myPosition.getY()));
            }            
        }
        for(int x = myPosition.getX()-1; x >= 0; x--)
        {
            if(whereTo[x][myPosition.getY()].getPiece() != null)
            {
                if(whereTo[x][myPosition.getY()].getPiece().darkSide == darkSide)
                {
                    break;
                }
                else
                {
                    possibleMoves.add(new Point(x, myPosition.getY()));
                    break;
                }
            }
            else
            {
                possibleMoves.add(new Point(x, myPosition.getY()));
            } 
        }
        for(int y = myPosition.getY()-1; y >= 0; y--)
        {
            if(whereTo[myPosition.getX()][y].getPiece() != null)
            {
                if(whereTo[myPosition.getX()][y].getPiece().darkSide == darkSide)
                {
                    break;
                }
                else
                {
                    possibleMoves.add(new Point(myPosition.getX(), y));
                    break;
                }
            }
            else
            {
                possibleMoves.add(new Point(myPosition.getX(), y));
            } 
        }
        for(int y = myPosition.getY()+1; y <= 7; y++)
        {
            if(whereTo[myPosition.getX()][y].getPiece() != null)
            {
                if(whereTo[myPosition.getX()][y].getPiece().darkSide == darkSide)
                {
                    break;
                }
                else
                {
                    possibleMoves.add(new Point(myPosition.getX(), y));
                    break;
                }
            }
            else
            {
                possibleMoves.add(new Point(myPosition.getX(), y));
            } 
        }

        //right down
        int y = myPosition.getY()+1;
        for(int x = myPosition.getX()+1; x<=7 &&y<=7; x++, y++)
        {
                if(whereTo[x][y].getPiece() != null)
                {
                    if(whereTo[x][y].getPiece().darkSide == darkSide)
                    {
                        break;
                    }
                    else
                    {
                        possibleMoves.add(new Point(x, y));
                        break;
                    }
                }
                else
                {
                    possibleMoves.add(new Point(x, y));
                }
        }
        y = myPosition.getY()-1;
        //right up
        for(int x = myPosition.getX()+1; x<=7&&y >= 0; x++,y--)
        {

            if(whereTo[x][y].getPiece() != null)
            {
                if(whereTo[x][y].getPiece().darkSide == darkSide)
                {
                    break;
                }
                else
                {
                    possibleMoves.add(new Point(x, y));
                    break;
                }
            }
            else
            {
                possibleMoves.add(new Point(x, y));
            }

        }
        y = myPosition.getY() +1;
            //left down
        for(int x = myPosition.getX()-1; x>=0 && y <= 7; x--,y++)
        {

            if(whereTo[x][y].getPiece() != null)
            {
                if(whereTo[x][y].getPiece().darkSide == darkSide)
                {
                    break;
                }
                else
                {
                    possibleMoves.add(new Point(x, y));
                    break;
                }
            }
            else
            {
                possibleMoves.add(new Point(x,y));
            }

        }
        y = myPosition.getY()-1;
        //left up
        for(int x = myPosition.getX()-1; x>=0 && y<=7; x--,y--)
        {

            if(whereTo[x][y].getPiece() != null)
            {
                if(whereTo[x][y].getPiece().darkSide == darkSide)
                {
                    break;
                }
                else
                {
                    possibleMoves.add(new Point(x, y));
                    break;
                }
            }
            else
            {
                possibleMoves.add(new Point(x, y));

            }
        }
        return possibleMoves;
    }

}
