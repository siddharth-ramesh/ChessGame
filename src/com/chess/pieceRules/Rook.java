package com.chess.pieceRules;

import chessBoard.ChessSquareBackground;

import com.chess.coordinates.Coordinate;
import com.chess.coordinates.ValidateMove;
import com.chess.main.main.Piece;
import com.chess.main.main.Side;

public class Rook extends ChessPiece{
	
	public Rook( Coordinate position, Side colour, ChessSquareBackground[][] chessSquares ) {
    	super( position );
    	this.piece = Piece.ROOK;
    	canMoveBackward = true;
    	canJump = false;
    	horzVertRule = new Coordinate[] {new Coordinate(inf,0), new Coordinate(0,inf)};
    	diagonalRule = new Coordinate[] {new Coordinate(0,0)};
    	moveRule = new Coordinate[][] {horzVertRule,diagonalRule};  
    	this.colour = colour;
    	this.chessSquares = chessSquares;
    	if (colour == Side.WHITE) {
    	chessSquares[position.invCoordinate().getxCoord()][position.getyCoord()].insertWr(this); 
    	}
    	else {
    		chessSquares[position.invCoordinate().getxCoord()][position.getyCoord()].insertBr(this); 
    	}
    }
}
