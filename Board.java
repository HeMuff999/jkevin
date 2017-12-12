import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
public class Board extends JFrame implements WindowListener,ActionListener
{

    //setting the icons for pieces
    //naming system PieceName.PieceColor.TileColor, white knight on black = knightWB
    //rooks
    ImageIcon BrookW = new ImageIcon("BrookW");
    ImageIcon WrookW = new ImageIcon("WrookW");
    ImageIcon WrookB = new ImageIcon("WrookB");
    ImageIcon BrookB = new ImageIcon("BrookB");
    //pawns
    ImageIcon BpawnW = new ImageIcon("BpawnW");
    ImageIcon WpawnW = new ImageIcon("WpawnW");
    ImageIcon WpawnB = new ImageIcon("WpawnB");
    ImageIcon BpawnB = new ImageIcon("BpawnB");
    //queens
    ImageIcon BqueenW = new ImageIcon("BqueenW");
    ImageIcon WqueenW = new ImageIcon("WqueenW");
    ImageIcon WqueenB = new ImageIcon("WqueenB");
    ImageIcon BqueenB = new ImageIcon("BqueenB");
    //kings
    ImageIcon BkingW = new ImageIcon("BkingW");
    ImageIcon WkingW = new ImageIcon("WkingW");
    ImageIcon WkingB = new ImageIcon("WkingB");
    ImageIcon BkingB = new ImageIcon("BkingB");
    //bishops
    ImageIcon BbishopW = new ImageIcon("BbishopW");
    ImageIcon WbishopW = new ImageIcon("WbishopW");
    ImageIcon WbishopB = new ImageIcon("WbishopB");
    ImageIcon BbishopB = new ImageIcon("BbishopB");
    //knights
    ImageIcon BknightW = new ImageIcon("BknightW");
    ImageIcon WknightW = new ImageIcon("WknightW");
    ImageIcon WknightB = new ImageIcon("WknightB");
    ImageIcon BknightB = new ImageIcon("BknightB");

    ImageIcon black = new ImageIcon("black.png");
    ImageIcon white = new ImageIcon("white.png");

    
    ArrayList<Point> possibleMoves;
    //Point pointInfo = new Point();
    Pawn whitePawn1;
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
        Panel main = new Panel(new BorderLayout());
        Panel grid = new Panel(new GridLayout(8,8));
        spaces = new JToggleButton[8][8];
        spacesInfo = new Point[8][8];
        whitePawn1 = new Pawn(false, spacesInfo[0][1]);
        //setting colors;
        for(int x = 0; x < 8; x++)
        {
            for( int y = 0; y < 8; y++)
            { 
                spaces[x][y] = new JToggleButton();
                if(x!= 7 && x!= 6 && x!= 0 && x!= 1)
                {

                    if(x%2 == y%2)
                    {//black squares
                        spaces[x][y].setIcon(black);
                        //setpawns, white on bottom
                        if(x == 6)
                        {
                            spaces[x][y].setIcon(WpawnB);
                        }
                    }
                    else
                    {
                        spaces[x][y].setIcon(white);
                    }

                }
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

    public void startingPoints()
    {
        
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
                    possibleMoves = spacesInfo[x][y].getPiece().move(spacesInfo);
                    for(Point z: possibleMoves)
                    {
                        
                    }
                }
                spaces[x][y].setSelected(false);
            }
        }

    }

    public void takeInValidMoves()
    {

        //set the spaces that are possibleMoves to have a green dot in em
        //  for (Point z : possibleMoves)
        {

        }
    }

    public void getPawn()
    {

    }

    public void     windowClosing(WindowEvent e)
    {
        System.exit(0);
    }

    @Override public void actionPerformed(ActionEvent e){
        getPiece();
        takeInValidMoves();

    }

    public void     windowActivated(WindowEvent e){}

    public void     windowDeactivated(WindowEvent e){}

    public void     windowDeiconified(WindowEvent e){}

    public void     windowIconified(WindowEvent e){}

    public void     windowOpened(WindowEvent e){}

    public void     windowClosed(WindowEvent e){

    }
}
