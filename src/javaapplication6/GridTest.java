package javaapplication6;

import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GridTest extends JFrame
{
    private JPanel panel;
    private int cantMovimientos = 0;
    private int cantMovimientos2 = 0;

    public int getCantMovimientos() {
        return cantMovimientos;
    }

    public void setCantMovimientos(int cantMovimientos) {
        this.cantMovimientos = cantMovimientos;
    }

    public int getCantMovimientos2() {
        return cantMovimientos2;
    }

    public void setCantMovimientos2(int cantMovimientos2) {
        this.cantMovimientos2 = cantMovimientos2;
    }
    private JButton[][]buttons;
    private int turno = 1;
    private int estado = 0;
    private ArrayList<Integer> pos = new ArrayList<Integer>();
    private String color1 = null;
    private String color2 = null;

    public String getColor1() {
        return color1;
    }

    public void setColor1(String color1) {
        this.color1 = color1;
    }

    public String getColor2() {
        return color2;
    }

    public void setColor2(String color2) {
        this.color2 = color2;
    }
    public ArrayList<Integer> getPos() {
        return pos;
    }

    public void setPos(ArrayList<Integer> pos) {
        this.pos = pos;
    }
    
    private int SIZE=0;
    private int SIZECol=0;
    private GridLayout experimentLayout;
    private int numberOfPlayer=0;
    private int playerOrder=0;
    private static int livingCellNumber=0; 
    ImageIcon empty = new ImageIcon(getClass().getResource("WhiteSpace.png"));
    ImageIcon player1 = null;
    ImageIcon player2 = null;

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public int getSIZE() {
        return SIZE;
    }

    public void setSIZE(int SIZE) {
        this.SIZE = SIZE;
    }

    public int getSIZECol() {
        return SIZECol;
    }

    public void setSIZECol(int SIZECol) {
        this.SIZECol = SIZECol;
    }

    public GridLayout getExperimentLayout() {
        return experimentLayout;
    }

    public void setExperimentLayout(GridLayout experimentLayout) {
        this.experimentLayout = experimentLayout;
    }

    public int getPlayerOrder() {
        return playerOrder;
    }

    public void setPlayerOrder(int playerOrder) {
        this.playerOrder = playerOrder;
    }

    public static int getLivingCellNumber() {
        return livingCellNumber;
    }

    public static void setLivingCellNumber(int livingCellNumber) {
        GridTest.livingCellNumber = livingCellNumber;
    }

    public ImageIcon getEmpty() {
        return empty;
    }

    public void setEmpty(ImageIcon empty) {
        this.empty = empty;
    }

    public ImageIcon getPlayer1() {
        return player1;
    }

    public void setPlayer1(ImageIcon player1) {
        this.player1 = player1;
    }

    public ImageIcon getPlayer2() {
        return player2;
    }

    public void setPlayer2(ImageIcon player2) {
        this.player2 = player2;
    }

    public int getEsNuevo() {
        return esNuevo;
    }

    public void setEsNuevo(int esNuevo) {
        this.esNuevo = esNuevo;
    }
    private Cell gameBoard[][];
    private int esNuevo = 0;
    public GridTest(int esNuevo)
      
    {
        
        super("Connect 4");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000,800);
        setResizable(true);
        setLocationRelativeTo(null);
        
        if(esNuevo==0){
         playerNumberAndBoardSize();
          Inicializar();
        }
       }
         
        
    
    
    public void Inicializar(){
        
        dynamicAllocation();
        experimentLayout =  new GridLayout(SIZE+1,SIZECol);

        panel = new JPanel();
        panel.setLayout(experimentLayout);
        this.esNuevo=esNuevo;
        buttons = new JButton[SIZE+1][SIZECol];
        addButtons(panel);
        

        add(panel);
        setVisible(true);
    }
 
public void colorJugador(){
  if(this.color1.equals("Azul")){
    setPlayer1(new ImageIcon(getClass().getResource("BlueSpace.png")));
  }
  else if(this.color1.equals("Rojo")){
    setPlayer1(new ImageIcon(getClass().getResource("RedSpace.png")));
  }
  else if(this.color1.equals("Amarillo")){
    setPlayer1(new ImageIcon(getClass().getResource("YellowSpace.png")));
  }
  else if(this.color1.equals("Naranja")){
    setPlayer1(new ImageIcon(getClass().getResource("OrangeSpace.png")));
  }
  else if(this.color1.equals("Verde")){
    setPlayer1(new ImageIcon(getClass().getResource("GreenSpace.png")));
  }
  else if(this.color1.equals("Negro")){
    setPlayer1(new ImageIcon(getClass().getResource("BlackSpace.png")));
  }
  else if(this.color1.equals("Purpura")){
    setPlayer1(new ImageIcon(getClass().getResource("PurpleSpace.png")));
  }
  
  if(this.color2.equals("Azul")){
    setPlayer2(new ImageIcon(getClass().getResource("BlueSpace.png")));
  }
  else if(this.color2.equals("Rojo")){
    setPlayer2(new ImageIcon(getClass().getResource("RedSpace.png")));
  }
  else if(this.color2.equals("Amarillo")){
    setPlayer2(new ImageIcon(getClass().getResource("YellowSpace.png")));
  }
  else if(this.color2.equals("Naranja")){
    setPlayer2(new ImageIcon(getClass().getResource("OrangeSpace.png")));
  }
  else if(this.color2.equals("Verde")){
    setPlayer2(new ImageIcon(getClass().getResource("GreenSpace.png")));
  }
  else if(this.color2.equals("Negro")){
    setPlayer2(new ImageIcon(getClass().getResource("BlackSpace.png")));
  }
  else if(this.color2.equals("Purpura")){
    setPlayer2(new ImageIcon(getClass().getResource("PurpleSpace.png")));
  }
}
 
public void addButtons(JPanel panel) {
    for (int k = 0; k < SIZE; k++) {
        System.out.println(Integer.toString(k));
       for (int j = 0; j < SIZECol; j++) {
           System.out.println(Integer.toString(j));
                   buttons[k][j] = new JButton(empty);
                   buttons[k][j].addActionListener(new listenButtonTwoPlayers());
                   panel.add(buttons[k][j]);
           }
       
      }
   // buttons[SIZE][0] = new JButton("Mensaje");
   // panel.add(buttons[SIZE][0]);
    for(int i = 0; i<SIZECol; i++){
      if(i==0){
        buttons[SIZE][i] = new JButton("Abandonar");
        panel.add(buttons[SIZE][i]);
      }else{
        buttons[SIZE][i] = new JButton("");
        panel.add(buttons[SIZE][i]);
      }
    }
}


 public void dynamicAllocation()
    {
      // Create dynamic Cell array to game board
        setGameBoard(new Cell[getBoardSize()][getBoardSizeCol()]);
        for (int i = 0; i <getBoardSize(); i++)
        {
            for (int j = 0; j <getBoardSizeCol(); j++)
            {
                getGameBoard() [i][j]=new Cell();
            }
        }
    }  
 
 public void movimiento(JButton e){
   ArrayList<Integer>posiciones = new ArrayList<Integer>();
   try {
                
                int eventFlag = 0;
                int flagPlayerOrder=0;

                for(int i=getBoardSize()-1; i>=0; --i)
                {
                    for(int j=0; j<=getBoardSizeCol()-1; ++j)
                    {
                        if(eventFlag==0 && getButtons()[i][j]==e) // Get the button component that was clicked
                        {  
                            posiciones.add(i);
                            posiciones.add(j);
                            setPos(posiciones);
                           if(flagPlayerOrder==0 && playerOrder%2==0) 
                           { 
                               // Player 1 Operations                           
                               // Fill the board from down to up
                                for(int k=0; k<=getBoardSize(); ++i)    
                                {
                                    if(getGameBoard()[i-k][j].getCellState()==0 && playerOrder%2==0)
                                    {
                                       if(i+1==getBoardSize() && getGameBoard()[i][j].getCellState()==0)
                                       {
                                       System.out.println("Entered i+1==getBoardSize()");
                                        getButtons()[i-k][j].setIcon(player1);          // Set new icon to player 1 
                                        getGameBoard()[i-k][j].setAllPosition('X', i);  // Set cell parameters
                                        getGameBoard()[i-k][j].setCellState(1);
                                       ++livingCellNumber;  // Increase living cell number
                                       estado=1;
                                       cantMovimientos++;
                                       winnerPlayer(1);     // Check player 1 winning state
                                       flagPlayerOrder=1;   
                                       eventFlag=1;
                                       
                                       break; 
                                       }else{
                                           if(getGameBoard()[i+1][j].getCellState()!=0 && getGameBoard()[i][j].getCellState()!=2 && getGameBoard()[i][j].getCellState()!=1){
                                               System.out.println("Entered gameBoard[i+1][j].getCellState()!=0");
                                               getButtons()[i-k][j].setIcon(player1);            // Set new icon to player 2
                                               getGameBoard()[i-k][j].setAllPosition('X', i);    // Set cell parameters    
                                               getGameBoard()[i-k][j].setCellState(1);           // Set cell state
                                               ++livingCellNumber;
                                               estado=1;
                                               cantMovimientos++;
                                               winnerPlayer(1);
                                               flagPlayerOrder=1;
                                               eventFlag=1;
                                               
                                               break;
                                           }
                                       }
                                    } 
                                }

                                setUpperCellToEmpty(i,j);   // Set upper cell to empty 
                                System.out.println("... Player 1 played ... ");
                                ++playerOrder; // Change order from player 1 to player 2
                                break;
                            }

                            // Player 2 operations
                            if(flagPlayerOrder==0 && playerOrder%2==1) 
                            { 
                                for(int k=0; k<=getBoardSize(); ++i)
                                {
                                    if(getGameBoard()[i-k][j].getCellState()==0 && playerOrder%2==1);
                                    {
                                       if(i+1==getBoardSize() && getGameBoard()[i][j].getCellState()==0)
                                       {
                                       System.out.println("Entered i+1==getBoardSize()");
                                        getButtons()[i-k][j].setIcon(player2);            // Set new icon to player 2
                                        getGameBoard()[i-k][j].setAllPosition('O', i);    // Set cell parameters    
                                        getGameBoard()[i-k][j].setCellState(2);           // Set cell state
                                       ++livingCellNumber;
                                       estado=1;
                                       cantMovimientos2++;
                                       winnerPlayer(2);
                                       flagPlayerOrder=1;
                                       eventFlag=1;
                                       
                                       break;
                                       }else{
                                           if(getGameBoard()[i+1][j].getCellState()!=0 && getGameBoard()[i][j].getCellState()!=1 && getGameBoard()[i][j].getCellState()!=2){
                                               System.out.println("Entered gameBoard[i+1][j].getCellState()!=0");
                                               getButtons()[i-k][j].setIcon(player2);            // Set new icon to player 2
                                               getGameBoard()[i-k][j].setAllPosition('O', i);    // Set cell parameters    
                                               getGameBoard()[i-k][j].setCellState(2);           // Set cell state
                                               ++livingCellNumber;
                                               estado=1;
                                               cantMovimientos2++;
                                               winnerPlayer(2);
                                               flagPlayerOrder=1;
                                               eventFlag=1;
                                               
                                               break;
                                           }
                                       }
                                    } 
                                }
                                setUpperCellToEmpty(i,j);
                                System.out.println("... Player 2 played ... ");
                                ++playerOrder;
                                break;
                            }
                        } // END EVENT SOURCE
                    } // END SECOND FOR LOOP         
                } // END FIRST FOR LOOP     
                System.out.println(estado);
        }catch(Exception ex) 
        { 
            warningMessage(); 
        }     
       }

    /**
     * @return the gameBoard
     */
    public Cell[][] getGameBoard() {
        return gameBoard;
    }

    /**
     * @param gameBoard the gameBoard to set
     */
    public void setGameBoard(Cell[][] gameBoard) {
        this.gameBoard = gameBoard;
    }

    /**
     * @return the turno
     */
    public int getTurno() {
        return turno;
    }

    /**
     * @param turno the turno to set
     */
    public void setTurno(int turno) {
        this.turno = turno;
    }

    /**
     * @return the estado
     */
    public int getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(int estado) {
        this.estado = estado;
    }

    /**
     * @return the buttons
     */
    public JButton[][] getButtons() {
        return buttons;
    }

    /**
     * @param buttons the buttons to set
     */
    public void setButtons(JButton[][] buttons) {
        this.buttons = buttons;
    }

    /**
     * @return the numberOfPlayer
     */
    public int getNumberOfPlayer() {
        return numberOfPlayer;
    }

    /**
     * @param numberOfPlayer the numberOfPlayer to set
     */
    public void setNumberOfPlayer(int numberOfPlayer) {
        this.numberOfPlayer = numberOfPlayer;
    }
    

 
 private class listenButtonTwoPlayers implements ActionListener
    {           
        @Override
        public void actionPerformed(ActionEvent e)
        { 
           if(getTurno()==1){
           JButton boton = (JButton) e.getSource();
           movimiento(boton);
           }else{
                JOptionPane.showMessageDialog(null, "No es tu turno");
           }
        }
 };
        
 
public void warningMessage()
    {
        JFrame frameWarning = new JFrame();           
        JOptionPane.showMessageDialog(frameWarning,
        "Invalid Movement !!\nThe cell is not empty.", "Warning",
        JOptionPane.WARNING_MESSAGE);
    }


public void playerNumberAndBoardSize()
    {
        
        // User inputs from input dialogs
        String boardSize = JOptionPane.showInputDialog( "Game Board Size(Vertical)" );
        String boardSizeCol = JOptionPane.showInputDialog( "Game Board Length(Horizontal)" );
        String color1 = JOptionPane.showInputDialog( "Elige un color para las fichas del jugador1"+ "\n"+"1.Azul"+ "\n"+"2.Rojo"+ "\n"+"3.Amarillo"+ "\n"+"4.Naranja"+ "\n"+"5.Verde"+ "\n"+"6.Negro"+ "\n"+"7.Purpura");
        String color2 = JOptionPane.showInputDialog( "Elige un color para las fichas del jugador1"+ "\n"+"1.Azul"+ "\n"+"2.Rojo"+ "\n"+"3.Amarillo"+ "\n"+"4.Naranja"+ "\n"+"5.Verde"+ "\n"+"6.Negro"  + "\n"+"7.Purpura");

        if (boardSize.length()==0 || boardSizeCol.length()==0 || color1.length()==0 || color2.length()==0 )
        {
            JFrame frameInputError = new JFrame();
            JOptionPane.showMessageDialog(frameInputError,
                    "Blank spaces found, error !!",
                    "Insufficient Data to Start game",
                    JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
        }
        
        if (color1.equals(color2))
        {
            JFrame frameInputError = new JFrame();
            JOptionPane.showMessageDialog(frameInputError,
                    "Error",
                    "Los colores de las fichas deben de ser distintos",
                    JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
        }
        // Get player number and size of board
        setNumberOfPlayer(2); 
        int sizeOfBoard = Integer.parseInt(boardSize);
        int lengthOfBoard = Integer.parseInt(boardSizeCol);
        int colorJugador1 = Integer.parseInt(color1);
        int colorJugador2 = Integer.parseInt(color2);
        
        if(colorJugador2==1){
          setColor2("Azul");
          setPlayer2(new ImageIcon(getClass().getResource("BlueSpace.png")));
        }
        
        if(colorJugador2==2){
          setColor2("Rojo");
          setPlayer2(new ImageIcon(getClass().getResource("RedSpace.png")));
        }
        
        if(colorJugador2==3){
          setColor2("Amarillo");
          setPlayer2(new ImageIcon(getClass().getResource("YellowSpace.png")));
        }
        
        if(colorJugador2==4){
          setColor2("Naranja");
          setPlayer2(new ImageIcon(getClass().getResource("OrangeSpace.png")));
        }
        
        if(colorJugador2==5){
          setColor2("Verde");
          setPlayer2(new ImageIcon(getClass().getResource("GreenSpace.png")));
        }
        if(colorJugador2==6){
          setColor2("Negro");
          setPlayer2(new ImageIcon(getClass().getResource("BlackSpace.png")));
        }
        
        if(colorJugador2==7){
          setColor2("Purpura");
          setPlayer2(new ImageIcon(getClass().getResource("PurpleSpace.png")));
        }
        
        if(colorJugador1==1){
          setColor1("Azul");
          setPlayer1(new ImageIcon(getClass().getResource("BlueSpace.png")));
        }
        
        if(colorJugador1==2){
          setColor1("Rojo");
          setPlayer1(new ImageIcon(getClass().getResource("RedSpace.png")));
        }
        
        if(colorJugador1==3){
          setColor1("Amarillo");
          setPlayer1(new ImageIcon(getClass().getResource("YellowSpace.png")));
        }
        
        if(colorJugador1==4){
          setColor1("Naranja");
          setPlayer1(new ImageIcon(getClass().getResource("OrangeSpace.png")));
        }
        
        if(colorJugador1==5){
          setColor1("Verde");
          setPlayer1(new ImageIcon(getClass().getResource("GreenSpace.png")));
        }
        if(colorJugador1==6){
          setColor1("Negro");
          setPlayer1(new ImageIcon(getClass().getResource("BlackSpace.png")));
        }
        
        if(colorJugador1==7){
          setColor1("Purpura");
          setPlayer1(new ImageIcon(getClass().getResource("PurpleSpace.png")));
        }
        // User input check to game board
        if(sizeOfBoard < 6)
        {
           JFrame frameInputError = new JFrame();
           JOptionPane.showMessageDialog(frameInputError,
           "Board size must be greater than 6  !!",
           "Board Size Error",
           JOptionPane.ERROR_MESSAGE);
           System.exit(0);
        }
        
        
        if (lengthOfBoard < 8)
        {
           JFrame frameInputError = new JFrame();
           JOptionPane.showMessageDialog(frameInputError,
           "Board Length must be greater than 8  !!",
           "Board Length Error",
           JOptionPane.ERROR_MESSAGE);
           System.exit(0);
        }
        
        setBoardSize(sizeOfBoard);
        setBoardSizeCol(lengthOfBoard);
        
    }

public void setBoardSize(int newSize)
    {
        SIZE = newSize;
    }
public int getBoardSize(){
    return SIZE;
}
public void setBoardSizeCol(int newSize)
    {
        SIZECol = newSize;
    }
public int getBoardSizeCol(){
    return SIZECol;
}
public void setUpperCellToEmpty(int rowPos, int columnPos)
    {
        try 
        {
            getGameBoard()[rowPos-1][columnPos].setCellState(0);    
        }   
        catch (Exception ex) 
        { }      
    } 
public void startAgain()
   {
       
        for(int i=0; i<getBoardSize(); ++i)
        {         
            for(int j=0; j<getBoardSizeCol(); ++j)
            {
                getGameBoard()[i][j].setCellState(-99);  // Initial Value
                getButtons()[i][j].setIcon(empty);       // Put the empty cell icon
            }
        }
        
        setVisible(false);                            // Unvisible previous game board
        GridTest newGame = new GridTest(0);           // New Game Object
   }

public void showResult(int winnerPlayer)
   {
       JFrame frameShowResult = new JFrame();       
       if(winnerPlayer==1)
       {
           estado=2;
            JOptionPane.showMessageDialog(frameShowResult,
            "\nWinner : Player 1\n\nThe new game will start.\n\n",
            "End Game",
            JOptionPane.INFORMATION_MESSAGE);
            //startAgain(); 
       }
       else
       {
           estado = 3;
            JOptionPane.showMessageDialog(frameShowResult,
            "\nWinner : Player 2\n\nThe new game will start.\n\n",
            "End Game",
            JOptionPane.INFORMATION_MESSAGE); 
            //startAgain();    
       }
   }
public void winnerPlayer(int winner)
    {
        for(int i=0; i<getBoardSize(); ++i)
        {         
            for(int j=0; j<getBoardSizeCol(); ++j)
            {     
                if(getGameBoard()[i][j].getCellState() == winner)
                {    
                    // CHECK UP TO DOWN POSITIONS
                    if(i+3<getBoardSize())
                    {
                        if(getGameBoard()[i+1][j].getCellState() == winner && getGameBoard()[i+2][j].getCellState() == winner && getGameBoard()[i+3][j].getCellState() == winner)  
                        {
                            if(winner==1)
                                showResult(1);
                            else
                                showResult(2);
                        }
                    }
                    // CHECK LEFT TO RIGHT POSITION
                    if(j + 3 <getBoardSizeCol())
                    { 
                        if(getGameBoard()[i][j+1].getCellState() == winner && getGameBoard()[i][j+2].getCellState() == winner && getGameBoard()[i][j+3].getCellState() == winner)
                        { 
                            if(winner==1)
                                showResult(1);
                            else
                                showResult(2);
                        }
                    }

                    // CHECK DIAGONAL LEFT TO RIGHT POSITION
                    if(i  < getBoardSize()- 3 && j<getBoardSizeCol()-3)
                    {
                        if(getGameBoard()[i+1][j+1].getCellState() == winner && getGameBoard()[i+2][j+2].getCellState() == winner && getGameBoard()[i+3][j+3].getCellState() == winner)
                        {  
                            if(winner==1)
                                showResult(1);
                            else
                                showResult(2);
                        }   
                    }

                    // CHECK DIAGONAL RIGHT TO LEFT POSITION
                    if(i  < getBoardSize()- 3 && j - 3 >= 0 )
                    {
                        if(getGameBoard()[i+1][j-1].getCellState() == winner && getGameBoard()[i+2][j-2].getCellState() == winner && getGameBoard()[i+3][j-3].getCellState() == winner)
                        {
                            if(winner==1)
                                showResult(1);
                            else
                                showResult(2);
                        } 
                    }
                    
                }         
            }             
        } 
    }
}