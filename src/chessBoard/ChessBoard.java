package chessBoard;

import com.chess.coordinates.Coordinate;
import com.chess.pieceRules.ChessPiece;

public class ChessBoard {
	
	ChessPiece[][] localBoard;
	
	public ChessBoard() {
		localBoard = new NewGame().arrangeNewBoard();		
	}
	
	public void movePiece( Coordinate oldLocation, Coordinate newLocation ) {
		localBoard[newLocation.getxCoord()][newLocation.getyCoord()] = 
				localBoard[oldLocation.getxCoord()][oldLocation.getyCoord()];

		localBoard[oldLocation.getxCoord()][oldLocation.getyCoord()] = null;				
	}
}
