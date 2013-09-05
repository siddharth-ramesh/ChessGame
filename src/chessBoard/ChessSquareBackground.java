package chessBoard;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.chess.coordinates.Coordinate;
import com.chess.coordinates.ValidateMove;
import com.chess.main.main.Side;
import com.chess.pieceRules.ChessPiece;

public class ChessSquareBackground extends JPanel implements MouseListener {
	public BufferedImage squareImg;
	private JLabel pieceLabel;
	public BufferedImage invSquareImg;
	public BufferedImage selSquareImg;
	private BufferedImage piecePic;
	public BufferedImage whiteSquareImage;
	public BufferedImage blackSquareImage;
	public Side Colour;
	public MoveSwitcher moveTracker;
	public ChessPiece thisPiece;
	private ValidateMove moveValidater;
	private boolean isInverted;
	protected Coordinate cellCoord;
	
	public ChessSquareBackground() {
		this.addMouseListener(this);
	}
	
	public void insertWp(ChessPiece thisPiece) {
		try{
			if (this.pieceLabel != null) {
				this.remove(pieceLabel);
			}
			this.thisPiece=thisPiece;
			piecePic = ImageIO.read(new File("C:/Users/Siddharth/ChessProject/ChessGame/images/wp.png"));    	
			pieceLabel = new JLabel(new ImageIcon( piecePic ));    	
    		this.add( pieceLabel, BorderLayout.CENTER );
    		this.revalidate();
    		this.repaint();
    		} catch(IOException e) {
				e.printStackTrace();
			}
	}
	
	public void insertWr(ChessPiece thisPiece) {
		try{
			if (this.pieceLabel != null) {
				this.remove(pieceLabel);
			}
			this.thisPiece=thisPiece;
			piecePic = ImageIO.read(new File("C:/Users/Siddharth/ChessProject/ChessGame/images/wr.png"));    	
			pieceLabel = new JLabel(new ImageIcon( piecePic ));    	
    		this.add( pieceLabel, BorderLayout.CENTER );
    		this.revalidate();
    		this.repaint();
    		} catch(IOException e) {
				e.printStackTrace();
			}
	}
	
	public void insertWk(ChessPiece thisPiece) {
		try{
			if (this.pieceLabel != null) {
				this.remove(pieceLabel);
			}
			this.thisPiece=thisPiece;
			piecePic = ImageIO.read(new File("C:/Users/Siddharth/ChessProject/ChessGame/images/wk.png"));    	
			pieceLabel = new JLabel(new ImageIcon( piecePic ));    	
    		this.add( pieceLabel, BorderLayout.CENTER );
    		this.revalidate();
    		this.repaint();
    		} catch(IOException e) {
				e.printStackTrace();
			}
	}
	
	public void insertWb(ChessPiece thisPiece) {
		try{
			if (this.pieceLabel != null) {
				this.remove(pieceLabel);
			}
			this.thisPiece=thisPiece;
			piecePic = ImageIO.read(new File("C:/Users/Siddharth/ChessProject/ChessGame/images/wb.png"));    	
			pieceLabel = new JLabel(new ImageIcon( piecePic ));    	
    		this.add( pieceLabel, BorderLayout.CENTER );
    		this.revalidate();
    		this.repaint();
    		} catch(IOException e) {
				e.printStackTrace();
			}
	}
	
	public void insertWq(ChessPiece thisPiece) {
		try{
			if (this.pieceLabel != null) {
				this.remove(pieceLabel);
			}
			this.thisPiece=thisPiece;
			piecePic = ImageIO.read(new File("C:/Users/Siddharth/ChessProject/ChessGame/images/wq.png"));    	
			pieceLabel = new JLabel(new ImageIcon( piecePic ));    	
    		this.add( pieceLabel, BorderLayout.CENTER );
    		this.revalidate();
    		this.repaint();
    		} catch(IOException e) {
				e.printStackTrace();
			}
	}
	
	public void insertWking(ChessPiece thisPiece) {
		try{
			if (this.pieceLabel != null) {
				this.remove(pieceLabel);
			}
			this.thisPiece=thisPiece;
			piecePic = ImageIO.read(new File("C:/Users/Siddharth/ChessProject/ChessGame/images/wKing.png"));    	
			pieceLabel = new JLabel(new ImageIcon( piecePic ));    	
    		this.add( pieceLabel, BorderLayout.CENTER );
    		this.revalidate();
    		this.repaint();
    		} catch(IOException e) {
				e.printStackTrace();
			}
	}
	
	public void insertBp(ChessPiece thisPiece) {
		try{
			if (this.pieceLabel != null) {
				this.remove(pieceLabel);
			}
			this.thisPiece=thisPiece;
			piecePic = ImageIO.read(new File("C:/Users/Siddharth/ChessProject/ChessGame/images/bp.png"));    	
			pieceLabel = new JLabel(new ImageIcon( piecePic ));    	
    		this.add( pieceLabel, BorderLayout.CENTER );
    		this.revalidate();
    		this.repaint();
    		} catch(IOException e) {
				e.printStackTrace();
			}
	}
	
	public void insertBr(ChessPiece thisPiece) {
		try{
			if (this.pieceLabel != null) {
				this.remove(pieceLabel);
			}
			this.thisPiece=thisPiece;
			piecePic = ImageIO.read(new File("C:/Users/Siddharth/ChessProject/ChessGame/images/br.png"));    	
			pieceLabel = new JLabel(new ImageIcon( piecePic ));    	
    		this.add( pieceLabel, BorderLayout.CENTER );
    		this.revalidate();
    		this.repaint();
    		} catch(IOException e) {
				e.printStackTrace();
			}
	}
	
	public void insertBk(ChessPiece thisPiece) {
		try{			
			if (this.pieceLabel != null) {
				this.remove(pieceLabel);
			}
			this.thisPiece=thisPiece;
			piecePic = ImageIO.read(new File("C:/Users/Siddharth/ChessProject/ChessGame/images/bk.png"));    	
			pieceLabel = new JLabel(new ImageIcon( piecePic ));    	
    		this.add( pieceLabel, BorderLayout.CENTER );
    		this.revalidate();
    		this.repaint();
    		} catch(IOException e) {
				e.printStackTrace();
			}
	}
	
	public void insertBb(ChessPiece thisPiece) {
		try{
			if (this.pieceLabel != null) {
				this.remove(pieceLabel);
			}
			this.thisPiece=thisPiece;
			piecePic = ImageIO.read(new File("C:/Users/Siddharth/ChessProject/ChessGame/images/bb.png"));    	
			pieceLabel = new JLabel(new ImageIcon( piecePic ));    	
    		this.add( pieceLabel, BorderLayout.CENTER );
    		this.revalidate();
    		this.repaint();
    		} catch(IOException e) {
				e.printStackTrace();
			}
	}
	
	public void insertBq(ChessPiece thisPiece) {
		try{
			if (this.pieceLabel != null) {
				this.remove(pieceLabel);
			}
			this.thisPiece=thisPiece;
			piecePic = ImageIO.read(new File("C:/Users/Siddharth/ChessProject/ChessGame/images/bq.png"));    	
			pieceLabel = new JLabel(new ImageIcon( piecePic ));    	
    		this.add( pieceLabel, BorderLayout.CENTER );
    		this.revalidate();
    		this.repaint();
    		} catch(IOException e) {
				e.printStackTrace();
			}
	}
	
	public void insertBking(ChessPiece thisPiece) {
		try{
			if (this.pieceLabel != null) {
				this.remove(pieceLabel);
			}
			this.thisPiece=thisPiece;
			piecePic = ImageIO.read(new File("C:/Users/Siddharth/ChessProject/ChessGame/images/bKing.png"));    	
			pieceLabel = new JLabel(new ImageIcon( piecePic ));    	
    		this.add( pieceLabel, BorderLayout.CENTER );
    		this.revalidate();
    		this.repaint();
    		} catch(IOException e) {
				e.printStackTrace();
			}
	}
	
	public void setMoveValidater( ValidateMove moveValidater ) {
		this.moveValidater = moveValidater;
	}
	
	public void clearPiece() {
		if (this.pieceLabel != null) {
			this.remove(pieceLabel);
			this.pieceLabel = null;
			this.thisPiece = null;
		}
	}
	
	public void unSelect() {
		this.isInverted = false;
		
		if( this.Colour.equals( Side.WHITE )) {
			this.squareImg = this.whiteSquareImage;
		}
		else {
			this.squareImg = this.blackSquareImage;
		}
		
		this.setPreferredSize(new Dimension(86,86));
        this.setMinimumSize(new Dimension(86,86));
        this.setMaximumSize(new Dimension(86,86));  
        this.revalidate();
		this.repaint();  
	}
	
	public void invert() {
    	
    		this.squareImg = this.invSquareImg;
    		
            this.setPreferredSize(new Dimension(86,86));
            this.setMinimumSize(new Dimension(86,86));
            this.setMaximumSize(new Dimension(86,86));  
            this.revalidate();
    		this.repaint();  
    		this.isInverted = true;
    }  
    
    public void select() {
    	    	
    	this.squareImg = this.selSquareImg;
    	            
        this.setPreferredSize(new Dimension(86,86));
        this.setMinimumSize(new Dimension(86,86));        
        this.setMaximumSize(new Dimension(86,86));        
        this.revalidate();
    	this.repaint();
            	
    }
	
	 public void paintComponent(Graphics g)
	    {
	        super.paintComponent(g);
	    	g.drawImage(squareImg, 0, 0, null);
	    }
	 
	 public void addListener() {
		 this.addMouseListener(this);
	 }
	 
	 public void removeListener() {
		 this.removeMouseListener(this);
	 }
	 
	 public void mouseClicked( MouseEvent e ) {
		 
	 }
	 public void mouseEntered( MouseEvent e ) {
		 
	 }
	 public void mouseExited( MouseEvent e ) {
		 
	 }
	 public void mousePressed( MouseEvent e ) {
		 if (!moveTracker.isSomethingSelected){
			 if (moveValidater.attemptMove(thisPiece, moveTracker)) {
				 this.select();
				 this.moveTracker.allowAll();
				 this.moveTracker.setSelectedPiece(this);
				 this.moveTracker.setIsSomethingSelected(true);				 
			 }			 
		 }
		 else {
			 if(this.isInverted) {
				 this.moveValidater.makeMove(this.cellCoord);
			 }
			 
			 this.moveTracker.unselectSelected();
			 this.moveTracker.setSelectedPiece(null);
			 this.moveTracker.setIsSomethingSelected(false);
			 
		 }
		 
	 }
	 public void mouseReleased( MouseEvent e ) {
		 
	 }
}
