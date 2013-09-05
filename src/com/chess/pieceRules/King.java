package com.chess.pieceRules;

import chessBoard.ChessSquareBackground;

import com.chess.coordinates.Coordinate;
import com.chess.coordinates.ValidateMove;
import com.chess.main.main.Piece;
import com.chess.main.main.Side;

public class King extends ChessPiece{
	
	public King( Coordinate position, Side colour, ChessSquareBackground[][] chessSquares ) {
    	super( position );
    	this.piece = Piece.KING;
    	canMoveBackward = true;
    	canJump = false;
    	horzVertRule = new Coordinate[] {new Coordinate(1,0), new Coordinate(0,1)};
    	diagonalRule = new Coordinate[] {new Coordinate(1,1)};
    	moveRule = new Coordinate[][] {horzVertRule,diagonalRule};    
    	this.colour = colour;
    	this.chessSquares = chessSquares;
    	if (colour == Side.WHITE) {
    	chessSquares[position.invCoordinate().getxCoord()][position.getyCoord()].insertWking(this); 
    	}
    	else {
    		chessSquares[position.invCoordinate().getxCoord()][position.getyCoord()].insertBking(this); 
    	}
    }
}
