import java.util.ArrayList;
public class Queen extends ChessPiece
{
    public Queen(boolean side, Point p)
    {
        setSide(side);
        setName("Queen");
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
        for(int x = myPosition.getX(); x<=7; x++)
        {
            for(int y = myPosition.getY(); y<=7; y++)
            {
                if(whereTo[myPosition.getX()][myPosition.getY()].getPiece() != null)
                {
                    if(whereTo[myPosition.getX()][myPosition.getY()].getPiece().darkSide == darkSide)
                    {
                        break;
                    }
                    else
                    {
                        possibleMoves.add(new Point(myPosition.getX(), myPosition.getY()));
                        break;
                    }
                }
                else
                {
                    possibleMoves.add(new Point(myPosition.getX(), myPosition.getY()));
                }
            }
        }

        //right up
        for(int x = myPosition.getX(); x<=7; x++)
        {
            for(int y = myPosition.getY(); y>=0; y--)
            {
                if(whereTo[myPosition.getX()][myPosition.getY()].getPiece() != null)
                {
                    if(whereTo[myPosition.getX()][myPosition.getY()].getPiece().darkSide == darkSide)
                    {
                        break;
                    }
                    else
                    {
                        possibleMoves.add(new Point(myPosition.getX(), myPosition.getY()));
                        break;
                    }
                }
                else
                {
                    possibleMoves.add(new Point(myPosition.getX(), myPosition.getY()));
                }
            }
        }

        //left down
        for(int x = myPosition.getX(); x>=0; x--)
        {
            for(int y = myPosition.getY(); y<=7; y++)
            {
                if(whereTo[myPosition.getX()][myPosition.getY()].getPiece() != null)
                {
                    if(whereTo[myPosition.getX()][myPosition.getY()].getPiece().darkSide == darkSide)
                    {
                        break;
                    }
                    else
                    {
                        possibleMoves.add(new Point(myPosition.getX(), myPosition.getY()));
                        break;
                    }
                }
                else
                {
                    possibleMoves.add(new Point(myPosition.getX(), myPosition.getY()));
                }
            }
        }

        //left up
        for(int x = myPosition.getX(); x>=0; x--)
        {
            for(int y = myPosition.getY(); y<=7; y++)
            {
                if(whereTo[myPosition.getX()][myPosition.getY()].getPiece() != null)
                {
                    if(whereTo[myPosition.getX()][myPosition.getY()].getPiece().darkSide == darkSide)
                    {
                        break;
                    }
                    else
                    {
                        possibleMoves.add(new Point(myPosition.getX(), myPosition.getY()));
                        break;
                    }
                }
                else
                {
                    possibleMoves.add(new Point(myPosition.getX(), myPosition.getY()));
                }
            }
        }
        return possibleMoves;
    }

}
