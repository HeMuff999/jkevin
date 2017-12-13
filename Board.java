import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
public class Board extends JFrame implements WindowListener,ActionListener
{

    //setting the icons for pieces
    //naming system PieceName.PieceColor.TileColor, white knight on black = knightWB
    //rooks
    ImageIcon BrookW = new ImageIcon("BrookW.png");
    ImageIcon WrookW = new ImageIcon("WrookW.png");
    ImageIcon WrookB = new ImageIcon("WrookB.png");
    ImageIcon BrookB = new ImageIcon("BrookB.png");
    //pawns
    ImageIcon BpawnW = new ImageIcon("BpawnW.png");
    ImageIcon WpawnW = new ImageIcon("WpawnW.png");
    ImageIcon WpawnB = new ImageIcon("WpawnB.png");
    ImageIcon BpawnB = new ImageIcon("BpawnB.png");
    //queens
    ImageIcon BqueenW = new ImageIcon("BqueenW.png");
    ImageIcon WqueenW = new ImageIcon("WqueenW.png");
    ImageIcon WqueenB = new ImageIcon("WqueenB.png");
    ImageIcon BqueenB = new ImageIcon("BqueenB.png");
    //kings
    ImageIcon BkingW = new ImageIcon("BkingW.png");
    ImageIcon WkingW = new ImageIcon("WkingW.png");
    ImageIcon WkingB = new ImageIcon("WkingB.png");
    ImageIcon BkingB = new ImageIcon("BkingB.png");
    //bishops
    ImageIcon BbishopW = new ImageIcon("BbishopW.png");
    ImageIcon WbishopW = new ImageIcon("WbishopW.png");
    ImageIcon WbishopB = new ImageIcon("WbishopB.png");
    ImageIcon BbishopB = new ImageIcon("BbishopB.png");
    //knights
    ImageIcon BknightW = new ImageIcon("BknightW.png");
    ImageIcon WknightW = new ImageIcon("WknightW.png");
    ImageIcon WknightB = new ImageIcon("WknightB.png");
    ImageIcon BknightB = new ImageIcon("BknightB.png");

    ImageIcon black = new ImageIcon("black.png");
    ImageIcon white = new ImageIcon("white.png");

    ImageIcon possibleMoveBlack = new ImageIcon("blackP.png");
    ImageIcon possibleMoveWhite = new ImageIcon("whiteP.png");

    int originalX;
    int originalY;

    ArrayList<Point> possibleMoves;
    //Point pointInfo = new Point();
    String whoTurn;
    Boolean alternate;

    Point[][]  spacesInfo;
    JToggleButton[][] spaces;
    Button newGame;

    public static void main (String []args)
    {
        new Board();
    }

    public Board()
    {
        setTheBoard();
    }  

    public void setTheBoard()
    {
        //y = up and down direction
        //x = left and right direction board is opposite so just watch up for that.
        /*for Rook, x moves along the columns = x x1 x2 x3 x4
         *  y counts the rows                  y
         *                                     y1
         *                                     y2
         *                                     y3
         *                                     y4 
         */
        whoTurn = "white";
        alternate = false;

        Panel main = new Panel(new BorderLayout());
        Panel grid = new Panel(new GridLayout(8,8));
        spaces = new JToggleButton[8][8];
        spacesInfo = new Point[8][8];
        setPieces();
        //setting colors;
        for(int x = 0; x < 8; x++)
        {
            for( int y = 0; y < 8; y++)
            { 
                spaces[x][y] = new JToggleButton();

                if(x%2 == y%2)
                {//black squares
                    spaces[x][y].setIcon(black);
                    //setpawns 
                    if(x == 6)
                    {
                        spaces[x][y].setIcon(WpawnB);                                                       
                    }
                    if(x ==1)
                    {
                        spaces[x][y].setIcon(BpawnB);  
                    }
                    else if (x == 0)
                    {
                        if(y == 0)
                        {
                            spaces[x][y].setIcon(BrookB);  

                        }
                        if(y == 2)
                        {
                            spaces[x][y].setIcon(BbishopB);  
                        }if(y == 4)
                        {
                            spaces[x][y].setIcon(BqueenB);  
                        }
                        if(y == 6)
                        {
                            spaces[x][y].setIcon(BknightB);  
                        }

                    }
                    else if (x == 7)
                    {
                        if(y == 1)
                        {
                            spaces[x][y].setIcon(WknightB);  
                        }
                        if(y == 3)
                        {
                            spaces[x][y].setIcon(WkingB);  
                        }
                        if(y == 5)
                        {
                            spaces[x][y].setIcon(WbishopB);  
                        }
                        if(y == 7)
                        {
                            spaces[x][y].setIcon(WrookB);  
                        }
                    }

                }
                else
                {

                    spaces[x][y].setIcon(white);
                    //set pawns, white on bottom
                    if(x == 6)
                    {
                        spaces[x][y].setIcon(WpawnW);                                                       
                    }
                    if(x ==1)
                    {
                        spaces[x][y].setIcon(BpawnW);  
                    }
                    else if (x == 7)
                    {
                        if(y == 0)
                        {
                            spaces[x][y].setIcon(WrookW);  
                        }
                        if(y == 2)
                        {
                            spaces[x][y].setIcon(WbishopW);  
                        }if(y == 4)
                        {
                            spaces[x][y].setIcon(WqueenW);  
                        }
                        if(y == 6)
                        {
                            spaces[x][y].setIcon(WknightW);  
                        }

                    }
                    else if (x == 0)
                    {
                        if(y == 1)
                        {
                            spaces[x][y].setIcon(BknightW);  
                        }
                        if(y == 3)
                        {
                            spaces[x][y].setIcon(BkingW);  
                        }
                        if(y == 5)
                        {
                            spaces[x][y].setIcon(BbishopW);  
                        }
                        if(y == 7)
                        {
                            spaces[x][y].setIcon(BrookW);  
                        }
                    }
                }
                spaces[x][y].addActionListener(this);

                grid.add(spaces[x][y]);
            }
        }
        newGame = new Button("New Game");
        main.add(newGame,BorderLayout.NORTH);

        newGame.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e)
                {

                    new Board();

                }
            });

        main.add(grid,BorderLayout.CENTER);        
        setLayout(new BorderLayout());
        add(main);
        setVisible(true);
        setSize(800,800);
        setTitle("Chess");

    }

    public void setPieces()
    {

        for(int x = 0; x < 8; x++)
        {
            for(int y = 0; y < 8; y++)
            {
                spacesInfo[x][y] = new Point(x,y,null);
            }
        }

        Pawn blackPawn0 = new Pawn(true, spacesInfo[0][1]);
        Pawn blackPawn1 = new Pawn(true, spacesInfo[1][1]);
        Pawn blackPawn2 = new Pawn(true, spacesInfo[2][1]);
        Pawn blackPawn3 = new Pawn(true, spacesInfo[3][1]);
        Pawn blackPawn4 = new Pawn(true, spacesInfo[4][1]);
        Pawn blackPawn5 = new Pawn(true, spacesInfo[5][1]);
        Pawn blackPawn6 = new Pawn(true, spacesInfo[6][1]);
        Pawn blackPawn7 = new Pawn(true, spacesInfo[7][1]);       

        spacesInfo[0][1] = new Point(0,1,blackPawn0);
        spacesInfo[1][1] = new Point(1,1,blackPawn1);
        spacesInfo[2][1] = new Point(2,1,blackPawn2);
        spacesInfo[3][1] = new Point(3,1,blackPawn3);
        spacesInfo[4][1] = new Point(4,1,blackPawn4);
        spacesInfo[5][1] = new Point(5,1,blackPawn5);
        spacesInfo[6][1] = new Point(6,1,blackPawn6);
        spacesInfo[7][1] = new Point(7,1,blackPawn7);

        Pawn whitePawn0 = new Pawn(false, spacesInfo[0][6]);
        Pawn whitePawn1 = new Pawn(false, spacesInfo[1][6]);
        Pawn whitePawn2 = new Pawn(false, spacesInfo[2][6]);
        Pawn whitePawn3 = new Pawn(false, spacesInfo[3][6]);
        Pawn whitePawn4 = new Pawn(false, spacesInfo[4][6]);
        Pawn whitePawn5 = new Pawn(false, spacesInfo[5][6]);
        Pawn whitePawn6 = new Pawn(false, spacesInfo[6][6]);
        Pawn whitePawn7 = new Pawn(false, spacesInfo[7][6]); 

        spacesInfo[0][6] = new Point(0,1,whitePawn0);
        spacesInfo[1][6] = new Point(1,1,whitePawn1);
        spacesInfo[2][6] = new Point(2,1,whitePawn2);
        spacesInfo[3][6] = new Point(3,1,whitePawn3);
        spacesInfo[4][6] = new Point(4,1,whitePawn4);
        spacesInfo[5][6] = new Point(5,1,whitePawn5);
        spacesInfo[6][6] = new Point(6,1,whitePawn6);
        spacesInfo[7][6] = new Point(7,1,whitePawn7);

        //if(spacesInfo[x][y].getPiece.equals("pawn"))
        {
            //    Pawn dummy = new Pawn(
        }

    }

    public void setSpaces()
    {

    }

    public void getPiece()
    {
        //detect the selected piece and get its info

        for(int x = 0; x < 8; x++)
        {
            for(int y = 0; y < 8; y++)
            {

                if(spaces[x][y].isSelected())
                {
                    if(whoTurn.equals(spacesInfo[y][x].getPiece().toString().substring(0,5)))
                    {
                        //System.out.println(x + "," +y);
                        //possibleMoves = spacesInfo[x][y].getPiece().move(spacesInfo);
                        possibleMoves = spacesInfo[y][x].getPiece().move(spacesInfo);
                        originalX = x;
                        originalY = y;
                        for(Point z: possibleMoves)
                        {
                            //black spaces
                            //System.out.println(z.getX() + "," +z.getY());
                            if(z.getX() %2 == z.getY()%2)
                            {
                                spaces[z.getY()][z.getX()].setIcon(possibleMoveBlack);
                            }
                            else
                            {
                                spaces[z.getY()][z.getX()].setIcon(possibleMoveWhite);
                            }

                        }
                    }
                    if(spacesInfo[y][x].getPiece().toString().substring(0,5).equals("white"))
                    {
                        whoTurn = "black";
                    }
                    else if(spacesInfo[y][x].getPiece().toString().substring(0,5).equals("black"))
                    {
                        whoTurn = "white";
                    }
                    

                    spaces[x][y].setSelected(false);
                }
            }
        }    
        for(int x = 0; x < 8; x++)
        {
            for(int y = 0; y < 8; y++)
            {
                if(spaces[x][y].getIcon() != possibleMoveBlack && spaces[x][y].getIcon() != possibleMoveWhite)
                {
                    spaces[x][y].setEnabled(false); 
                }
            }
        }
        alternate = true;

    }

    public void movePiece()
    {
        
        for(int x = 0; x < 8; x++)
        {
            for(int y = 0; y < 8; y++)
            {
                if(spaces[x][y].isSelected())
                {  
                    if(spaces[x][y].getIcon() == possibleMoveBlack || spaces[x][y].getIcon() == possibleMoveWhite)
                    {
                        //get the original point's information
                        setPieceImage(originalX, originalY, x,y);
                        alternate = false;

                    }

                }
                spaces[x][y].setSelected(false);
            }
        }
        for(int x = 0; x < 8; x++)
        {
            for(int y = 0; y < 8; y++)
            {
                if(spaces[x][y].getIcon() == possibleMoveBlack || spaces[x][y].getIcon() == possibleMoveWhite)
                {
                    if(x%2 == y%2)
                    {
                        spaces[x][y].setIcon(black);
                    }
                    else
                    {
                        spaces[x][y].setIcon(white);
                    }
                }
                spaces[x][y].setEnabled(true);

            }
        }

    }

    public void setPieceImage(int originalx, int originaly, int newX, int newY)
    {
        int x = originalx;
        int y = originaly;
        String originalPieceName = spacesInfo[y][x].getPiece().toString();
        ChessPiece originalPiece = spacesInfo[y][x].getPiece();

        if(originalPieceName.substring(0,5).equals("black"))
        {
            if(newX%2 == newY%2)
            {//new space is black
                if(originalPiece.pieceName.equals("pawn"))
                {
                    spaces[newX][newY].setIcon(BpawnB);
                    clearOriginalSpace(x,y,newX,newY,originalPiece);
                }
                if(originalPiece.pieceName.equals("rook"))
                {

                }
            }
        }
        else if(originalPieceName.substring(0,5).equals("white"))
        {

        }
    }

    public void clearOriginalSpace(int x, int y,int newX, int newY, ChessPiece piece)
    {
        //clear original picture and set the spacesInfo
        if(x%2 == y%2)
        {
            spaces[x][y].setIcon(black);
        }
        else
        {
            spaces[x][y].setIcon(white);
        }
        //set old space to be null, new = original piece
        spacesInfo[y][x] = new Point(y,x,null);
        spacesInfo[newY][newX] = new Point(newY,newX,piece);  
        

    }

    public void getPawn()
    {

    }

    public void     windowClosing(WindowEvent e)
    {
        System.exit(0);
    }

    @Override public void actionPerformed(ActionEvent e){
        //if alt = true, then its time to move the piece
        if(!alternate)
        {
            getPiece();

        }
        else
        {
            movePiece();

            
        }

    }

    public void     windowActivated(WindowEvent e){}

    public void     windowDeactivated(WindowEvent e){}

    public void     windowDeiconified(WindowEvent e){}

    public void     windowIconified(WindowEvent e){}

    public void     windowOpened(WindowEvent e){}

    public void     windowClosed(WindowEvent e){
    }
}
