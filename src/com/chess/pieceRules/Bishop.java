package com.chess.pieceRules;

import chessBoard.ChessSquareBackground;

import com.chess.coordinates.Coordinate;
import com.chess.coordinates.ValidateMove;
import com.chess.main.main.Piece;
import com.chess.main.main.Side;

public class Bishop extends ChessPiece{
	
	public Bishop( Coordinate position, Side colour, ChessSquareBackground[][] chessSquares ) {
    	super( position );
    	this.piece = Piece.BISHOP;
    	canMoveBackward = true;
    	canJump = false;
    	horzVertRule = new Coordinate[] {new Coordinate(0,0)};
    	diagonalRule = new Coordinate[] {new Coordinate(inf,inf)};
    	moveRule = new Coordinate[][] {horzVertRule,diagonalRule};  
    	this.colour = colour;
    	this.chessSquares = chessSquares;
    	if (colour == Side.WHITE) {
    	chessSquares[position.invCoordinate().getxCoord()][position.getyCoord()].insertWb(this); 
    	}
    	else {
    		chessSquares[position.invCoordinate().getxCoord()][position.getyCoord()].insertBb(this); 
    	}
    }
}