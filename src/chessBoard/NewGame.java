package chessBoard;

import com.chess.coordinates.Coordinate;
import com.chess.coordinates.ValidateMove;
import com.chess.main.main.Side;
import com.chess.pieceRules.Bishop;
import com.chess.pieceRules.ChessPiece;
import com.chess.pieceRules.King;
import com.chess.pieceRules.Knight;
import com.chess.pieceRules.Pawn;
import com.chess.pieceRules.Queen;
import com.chess.pieceRules.Rook;

public class NewGame {
	
	ChessPiece[][] localBoard;
	ChessPiece[] whitePieces;
	ChessPiece[] blackPieces;
	ChessSquareBackground[][] chessSquares;
	MoveSwitcher moveTracker;
	ValidateMove moveValidater;
	
	public ChessPiece[][] arrangeNewBoard() {		
		this.localBoard = new ChessPiece[8][8];	
		this.whitePieces = new ChessPiece[16];
		this.blackPieces = new ChessPiece[16];
		moveTracker = new MoveSwitcher(whitePieces, blackPieces);
		moveValidater = new ValidateMove(localBoard, moveTracker);
		this.chessSquares = new ChessBoardUI().createGUI(moveTracker);
		
		for(int x = 0; x < 8; x++) {
			for(int y = 0; y < 8; y++) {
				chessSquares[x][y].setMoveValidater(moveValidater);
			}
		}
		
		moveTracker.setChessSquares(chessSquares);
		moveValidater.setChessSquares(chessSquares);
		arrangeFrontPieces();
		arrangeBackPieces();
		moveTracker.moveAllower();
		return localBoard;
	}
	private void arrangeFrontPieces() {
		ChessPiece wp1 = new Pawn(new Coordinate(1,0), Side.WHITE, chessSquares);
		whitePieces[0] = wp1;
		ChessPiece wp2 = new Pawn(new Coordinate(1,1), Side.WHITE, chessSquares);
		whitePieces[1] = wp2;
		ChessPiece wp3 = new Pawn(new Coordinate(1,2), Side.WHITE, chessSquares);
		whitePieces[2] = wp3;
		ChessPiece wp4 = new Pawn(new Coordinate(1,3), Side.WHITE, chessSquares);
		whitePieces[3] = wp4;
		ChessPiece wp5 = new Pawn(new Coordinate(1,4), Side.WHITE, chessSquares);
		whitePieces[4] = wp5;
		ChessPiece wp6 = new Pawn(new Coordinate(1,5), Side.WHITE, chessSquares);
		whitePieces[5] = wp6;
		ChessPiece wp7 = new Pawn(new Coordinate(1,6), Side.WHITE, chessSquares);
		whitePieces[6] = wp7;
		ChessPiece wp8 = new Pawn(new Coordinate(1,7), Side.WHITE, chessSquares);
		whitePieces[7] = wp8;
		
		ChessPiece bp1 = new Pawn(new Coordinate(6,0), Side.BLACK, chessSquares);
		blackPieces[0] = bp1;
		ChessPiece bp2 = new Pawn(new Coordinate(6,1), Side.BLACK, chessSquares);
		blackPieces[1] = bp2;
		ChessPiece bp3 = new Pawn(new Coordinate(6,2), Side.BLACK, chessSquares);
		blackPieces[2] = bp3;
		ChessPiece bp4 = new Pawn(new Coordinate(6,3), Side.BLACK, chessSquares);
		blackPieces[3] = bp4;
		ChessPiece bp5 = new Pawn(new Coordinate(6,4), Side.BLACK, chessSquares);
		blackPieces[4] = bp5;
		ChessPiece bp6 = new Pawn(new Coordinate(6,5), Side.BLACK, chessSquares);
		blackPieces[5] = bp6;
		ChessPiece bp7 = new Pawn(new Coordinate(6,6), Side.BLACK, chessSquares);
		blackPieces[6] = bp7;
		ChessPiece bp8 = new Pawn(new Coordinate(6,7), Side.BLACK, chessSquares);
		blackPieces[7] = bp8;
		
		localBoard[1][0] = wp1;
		localBoard[1][1] = wp2;
		localBoard[1][2] = wp3;
		localBoard[1][3] = wp4;
		localBoard[1][4] = wp5;
		localBoard[1][5] = wp6;
		localBoard[1][6] = wp7;
		localBoard[1][7] = wp8;
		
		localBoard[6][0] = bp1;
		localBoard[6][1] = bp2;
		localBoard[6][2] = bp3;
		localBoard[6][3] = bp4;
		localBoard[6][4] = bp5;
		localBoard[6][5] = bp6;
		localBoard[6][6] = bp7;
		localBoard[6][7] = bp8;
	}
	
	private void arrangeBackPieces() {
		ChessPiece wr1 = new Rook(new Coordinate(0,0), Side.WHITE, chessSquares);
		whitePieces[8] = wr1;
		ChessPiece wk1 = new Knight(new Coordinate(0,1), Side.WHITE, chessSquares);
		whitePieces[9] = wk1;
		ChessPiece wb1 = new Bishop(new Coordinate(0,2), Side.WHITE, chessSquares);
		whitePieces[10] = wb1;
		ChessPiece wq1 = new Queen(new Coordinate(0,3), Side.WHITE, chessSquares);
		whitePieces[12] = wq1;
		ChessPiece wK1 = new King(new Coordinate(0,4), Side.WHITE, chessSquares);
		whitePieces[11] = wK1;		
		ChessPiece wb2 = new Bishop(new Coordinate(0,5), Side.WHITE, chessSquares);
		whitePieces[13] = wb2;
		ChessPiece wk2 = new Knight(new Coordinate(0,6), Side.WHITE, chessSquares);
		whitePieces[14] = wk2;
		ChessPiece wr2 = new Rook(new Coordinate(0,7), Side.WHITE, chessSquares);
		whitePieces[15] = wr2;
		
		ChessPiece br1 = new Rook(new Coordinate(7,0), Side.BLACK, chessSquares);
		blackPieces[8] = br1;
		ChessPiece bk1 = new Knight(new Coordinate(7,1), Side.BLACK, chessSquares);
		blackPieces[9] = bk1;
		ChessPiece bb1 = new Bishop(new Coordinate(7,2), Side.BLACK, chessSquares);
		blackPieces[10] = bb1;
		ChessPiece bq1 = new Queen(new Coordinate(7,3), Side.BLACK, chessSquares);
		blackPieces[12] = bq1;
		ChessPiece bK1 = new King(new Coordinate(7,4), Side.BLACK, chessSquares);
		blackPieces[11] = bK1;		
		ChessPiece bb2 = new Bishop(new Coordinate(7,5), Side.BLACK, chessSquares);
		blackPieces[13] = bb2;
		ChessPiece bk2 = new Knight(new Coordinate(7,6), Side.BLACK, chessSquares);
		blackPieces[14] = bk2;
		ChessPiece br2 = new Rook(new Coordinate(7,7), Side.BLACK, chessSquares);
		blackPieces[15] = br2;
		
		localBoard[0][0] = wr1;
		localBoard[0][1] = wk1;
		localBoard[0][2] = wb1;
		localBoard[0][3] = wq1;
		localBoard[0][4] = wK1;
		localBoard[0][5] = wb2;
		localBoard[0][6] = wk2;
		localBoard[0][7] = wr2;	
		
		localBoard[7][0] = br1;
		localBoard[7][1] = bk1;
		localBoard[7][2] = bb1;
		localBoard[7][3] = bq1;
		localBoard[7][4] = bK1;
		localBoard[7][5] = bb2;
		localBoard[7][6] = bk2;
		localBoard[7][7] = br2;
	
	}	
}
