package chessBoard;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.chess.coordinates.Coordinate;
import com.chess.main.main.Side;

class WhiteSquareBackground extends ChessSquareBackground {
    
	public WhiteSquareBackground(MoveSwitcher moveTracker, Coordinate cellCoord ) {
		super();
    	try {
    		super.moveTracker = moveTracker;
    		super.Colour = Side.WHITE;
    		super.whiteSquareImage = ImageIO.read(new File("C:/Users/Siddharth/ChessProject/ChessGame/images/whiteSquare.png"));
            super.squareImg = super.whiteSquareImage;
            super.cellCoord = cellCoord;
            		
            this.setPreferredSize(new Dimension(86,86));
            this.setMinimumSize(new Dimension(86,86));
            this.setMaximumSize(new Dimension(86,86));     
            
            super.invSquareImg = ImageIO.read(new File("C:/Users/Siddharth/ChessProject/ChessGame/images/whiteSquareInv.png"));
            super.selSquareImg = ImageIO.read(new File("C:/Users/Siddharth/ChessProject/ChessGame/images/whiteSquareSel.png"));
                    	
    	} catch(IOException e) {
        	e.printStackTrace();
        }
    }     	
}