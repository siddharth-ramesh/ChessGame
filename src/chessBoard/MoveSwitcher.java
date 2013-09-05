package chessBoard;

import com.chess.main.main.Side;
import com.chess.pieceRules.ChessPiece;

public class MoveSwitcher {
	Side Colour;
	ChessPiece[] whitePieces;
	ChessPiece[] blackPieces;
	ChessSquareBackground[][] chessSquares;
	ChessSquareBackground selectedPiece;
	boolean isSomethingSelected;	
	
	public MoveSwitcher(ChessPiece[] whitePieces, ChessPiece[] blackPieces) {
		this.Colour = Side.WHITE;
		this.whitePieces = whitePieces;
		this.blackPieces = blackPieces;
			
	}
	public void setChessSquares( ChessSquareBackground[][] chessSquares) {
		this.chessSquares=chessSquares;
	}
	
	public void changeSide() {
		if (this.Colour.equals(Side.WHITE)){
			this.Colour = Side.BLACK;
		}
		else {
			this.Colour = Side.WHITE;
		}
		moveAllower();
	}
	
	public void moveAllower() {
		for (ChessSquareBackground[] squareRows:chessSquares){
			for (ChessSquareBackground square:squareRows) {
				square.unSelect();
				square.removeListener();
			}
		}
		
		if (this.Colour.equals(Side.WHITE)){
			for (ChessPiece piece:whitePieces){
				if (!piece.getIsDeleted()){
				chessSquares[piece.getPosition().invCoordinate().getxCoord()][7-piece.getPosition().invCoordinate().getyCoord()].addListener();
			}			
			}
		}
		else {
			for (ChessPiece piece:blackPieces){
				if (!piece.getIsDeleted()){
				chessSquares[piece.getPosition().invCoordinate().getxCoord()][7-piece.getPosition().invCoordinate().getyCoord()].addListener();
			}
			}
		}
	}
	
	public void setSelectedPiece(ChessSquareBackground selectedPiece) {
		this.selectedPiece = selectedPiece;
	}
	
	public void setIsSomethingSelected(boolean isSomethingSelected) {
		this.isSomethingSelected = isSomethingSelected;
	}
	
	public void unselectSelected() {
		selectedPiece.unSelect();
		this.moveAllower();
	}
	
	public void allowAll() {
		for (ChessSquareBackground[] squareRows:chessSquares){
			for (ChessSquareBackground square:squareRows) {
				square.removeListener();
			}
		}
		for (ChessSquareBackground[] squareRows:chessSquares){
			for (ChessSquareBackground square:squareRows) {
				square.addListener();
			}
		}
	}
	public Side getColour() {
		return this.Colour;
	}
}
