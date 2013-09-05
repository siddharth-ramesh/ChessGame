package com.chess.pieceRules;

import chessBoard.ChessSquareBackground;

import com.chess.coordinates.Coordinate;
import com.chess.coordinates.ValidateMove;
import com.chess.main.main.Piece;
import com.chess.main.main.Side;

public class Knight extends ChessPiece{
	
	public Knight( Coordinate position, Side colour, ChessSquareBackground[][] chessSquares ) {
    	super( position );
    	this.piece = Piece.KNIGHT;
    	canMoveBackward = true;
    	canJump = true;
    	horzVertRule = new Coordinate[] {new Coordinate(2,1), new Coordinate(1,2)};
    	diagonalRule = new Coordinate[] {new Coordinate(0,0)};
    	moveRule = new Coordinate[][] {horzVertRule,diagonalRule}; 
    	this.colour = colour;
    	this.chessSquares = chessSquares;
    	if (colour == Side.WHITE) {
    	chessSquares[position.invCoordinate().getxCoord()][position.getyCoord()].insertWk(this); 
    	}
    	else {
    		chessSquares[position.invCoordinate().getxCoord()][position.getyCoord()].insertBk(this); 
    	}
    }
}