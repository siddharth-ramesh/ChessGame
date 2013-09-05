package com.chess.pieceRules;

import chessBoard.ChessSquareBackground;

import com.chess.coordinates.Coordinate;
import com.chess.coordinates.ValidateMove;
import com.chess.main.main.Piece;
import com.chess.main.main.Side;

public class ChessPiece {
			
			public int inf = Integer.MAX_VALUE;
	
		    public boolean canMoveBackward;
		    public boolean canJump;
		    public  boolean firstMove;
		    public boolean isPawn = false;
		    public boolean isQueen = false;
		    public Coordinate position;
		    public Coordinate[] horzVertRule;
		    public Coordinate[] diagonalRule;
		    public Coordinate[][] moveRule;
		    public Side colour;
		    protected Piece piece;
		    protected ChessSquareBackground[][] chessSquares;
		    private boolean isDeleted;
		    		    		    
			public ChessPiece( Coordinate startingPosition ) {
				this.firstMove = true;
		    	this.position = startingPosition;
		    	isDeleted = false;
		    	
		    }
			
		    public boolean getCanMoveBackward() {
		    	return this.canMoveBackward;
		    }
		    
		    public boolean getCanJump() {
		    	return this.canJump;
		    }
		    
		    public Coordinate[][] getMoveRule() {
		    	return this.moveRule;
		    }
		    
		    public Coordinate getPosition() {
		    	return this.position;
		    }
		    
		    public Side getColour() {
		    	return colour;
		    }		    

			public boolean getIsPawn() {
				return isPawn;
			}	
			public boolean getIsDeleted() {
				return isDeleted;
			}
			public void setIsDeleted( boolean isDeleted ) {
				this.isDeleted = isDeleted;
			}
			public void setPosition( Coordinate position ) {
		    	if (firstMove) {
		    		firstMove = false;
		    	}
		    	chessSquares[this.getPosition().invCoordinate().getxCoord()][this.getPosition().getyCoord()].clearPiece();
		    	this.position = position;
		    	if (this.piece.equals(Piece.PAWN)){
		    		if (colour == Side.WHITE) {
		    			chessSquares[this.getPosition().invCoordinate().getxCoord()][position.getyCoord()].insertWp(this);
		    		}
		    		else {
		    			chessSquares[this.getPosition().invCoordinate().getxCoord()][position.getyCoord()].insertBp(this);
		    		}
		    	}
		    	else if (this.piece.equals(Piece.BISHOP)){
		    		if (colour == Side.WHITE) {
		    			chessSquares[this.getPosition().invCoordinate().getxCoord()][position.getyCoord()].insertWb(this);
		    		}
		    		else {
		    			chessSquares[this.getPosition().invCoordinate().getxCoord()][position.getyCoord()].insertBb(this);
		    		}
		    	}
		    	else if (this.piece.equals(Piece.KNIGHT)){
		    		if (colour == Side.WHITE) {
		    			chessSquares[this.getPosition().invCoordinate().getxCoord()][position.getyCoord()].insertWk(this);
		    		}
		    		else {
		    			chessSquares[this.getPosition().invCoordinate().getxCoord()][position.getyCoord()].insertBk(this);
		    		}
		    	}
		    	else if (this.piece.equals(Piece.ROOK)){
		    		if (colour == Side.WHITE) {
		    			chessSquares[this.getPosition().invCoordinate().getxCoord()][position.getyCoord()].insertWr(this);
		    		}
		    		else {
		    			chessSquares[this.getPosition().invCoordinate().getxCoord()][position.getyCoord()].insertBr(this);
		    		}
		    	}
		    	else if (this.piece.equals(Piece.QUEEN)){
		    		if (colour == Side.WHITE) {
		    			chessSquares[this.getPosition().invCoordinate().getxCoord()][position.getyCoord()].insertWq(this);
		    		}
		    		else {
		    			chessSquares[this.getPosition().invCoordinate().getxCoord()][position.getyCoord()].insertBq(this);
		    		}
		    	}
		    	else if (this.piece.equals(Piece.KING)){
		    		if (colour == Side.WHITE) {
		    			chessSquares[this.getPosition().invCoordinate().getxCoord()][position.getyCoord()].insertWking(this);
		    		}
		    		else {
		    			chessSquares[this.getPosition().invCoordinate().getxCoord()][position.getyCoord()].insertBking(this);
		    		}
		    	}
		}
}
