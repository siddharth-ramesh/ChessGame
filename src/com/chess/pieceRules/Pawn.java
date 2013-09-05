package com.chess.pieceRules;

import chessBoard.ChessSquareBackground;

import com.chess.coordinates.Coordinate;
import com.chess.coordinates.ValidateMove;
import com.chess.main.main.Piece;
import com.chess.main.main.Side;

public class Pawn extends ChessPiece {
	
	private Coordinate[][] firstMoveRule;
	public Pawn( Coordinate position, Side colour, ChessSquareBackground[][] chessSquares) {
    	super( position );
    	this.piece = Piece.PAWN;
    	canMoveBackward = false;
    	canJump = false;
    	isPawn = true;
    	horzVertRule = new Coordinate[] {new Coordinate(1,0)};
    	diagonalRule = new Coordinate[] {new Coordinate(0,0)};
    	moveRule = new Coordinate[][] {horzVertRule,diagonalRule}; 
    	firstMoveRule = new Coordinate[][] {(new Coordinate[] {new Coordinate(2,0), new Coordinate(1,0)}),diagonalRule}; 
    	this.colour = colour;
    	this.chessSquares = chessSquares;
    	if (colour == Side.WHITE) {
    	chessSquares[position.invCoordinate().getxCoord()][position.getyCoord()].insertWp(this); 
    	}
    	else {
    		chessSquares[position.invCoordinate().getxCoord()][position.getyCoord()].insertBp(this); 
    	}
    }
	
    public Coordinate[][] getMoveRule() {
    	if (firstMove) {
    		return this.firstMoveRule;
    	}
    	else {
    		return this.moveRule;
    	}    	
    }
}
