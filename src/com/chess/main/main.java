package com.chess.main;

import java.awt.EventQueue;

import chessBoard.ChessBoard;
import chessBoard.ChessBoardUI;

public class main {

	/**
	 * @param args
	 */
	
	public enum Side {
		WHITE, BLACK
	}
	
	public enum Piece {
		PAWN, ROOK, KNIGHT, BISHOP, QUEEN, KING
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ChessBoard();
	}

}
