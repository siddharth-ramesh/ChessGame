package chessBoard;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.chess.coordinates.Coordinate;

public class ChessBoardUI{
	
	MoveSwitcher moveTracker;

    public ChessSquareBackground[][] createGUI(MoveSwitcher moveTracker) {
    	try {
    	this.moveTracker = moveTracker;
        final JFrame boardFrame = new JFrame("Beginner's Chess");
        boardFrame.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        
        ChessSquareBackground[][] chessSquares = new ChessSquareBackground[8][8];
        for (int rows = 0; rows <8 ; rows++){
        	if (rows%2==0) {
        		for (int cols = 0; cols < 8; cols++) {
        			if (cols%2==0) {
        				chessSquares[rows][cols] = new WhiteSquareBackground(moveTracker, new Coordinate(rows, cols));        				
        				constraints.gridx = cols;
        				constraints.gridy = rows;
        				boardFrame.add(chessSquares[rows][cols], constraints);        				
        				}
        			else {
        				chessSquares[rows][cols] = new BlackSquareBackground(moveTracker,  new Coordinate(rows, cols));
        				constraints.gridx = cols;
        				constraints.gridy = rows;
        				boardFrame.add(chessSquares[rows][cols], constraints);
        				}
        		}     		
        	}
        	else {
        		for (int cols = 0; cols < 8; cols++) {
        			if (cols%2==0) {
        				chessSquares[rows][cols] = new BlackSquareBackground(moveTracker, new Coordinate(rows, cols));
        				constraints.gridx = cols;
        				constraints.gridy = rows;
        				boardFrame.add(chessSquares[rows][cols], constraints);
        				}
        			else {
        				chessSquares[rows][cols] = new WhiteSquareBackground(moveTracker, new Coordinate(rows, cols));
        				constraints.gridx = cols;
        				constraints.gridy = rows;
        				boardFrame.add(chessSquares[rows][cols], constraints);
        				}
        		}        		        		
        	} 
        	/*constraints.gridx = 0;
        	constraints.gridy = 8;
        	constraints.weightx = 7;
        	boardFrame.add(new JPanel(),constraints);*/
        }      	
        	
        boardFrame.pack();
        boardFrame.setSize(1000, 1000);
        boardFrame.repaint();
        boardFrame.setVisible(true);
        boardFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
       return chessSquares;
    	
    	}catch (Exception e) {
    		System.out.println(e);
    	}
    	return null;
    }
}