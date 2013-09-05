package com.chess.coordinates;

import chessBoard.ChessSquareBackground;
import chessBoard.MoveSwitcher;

import com.chess.main.main.Side;
import com.chess.pieceRules.ChessPiece;

public class ValidateMove {
	
	private ChessPiece[][] localBoard;
	private ChessSquareBackground[][] chessSquares;
	private int inf = Integer.MAX_VALUE;
	private MoveSwitcher moveTracker;
	private ChessPiece thisPiece;
	
	public ValidateMove(ChessPiece[][] localBoard, MoveSwitcher moveTracker ) {
		this.localBoard = localBoard;	
		this.moveTracker = moveTracker;
	}
	
	public void setChessSquares( ChessSquareBackground[][] chessSquares ) {
		this.chessSquares = chessSquares;
	}
	public boolean attemptMove( ChessPiece thisPiece, MoveSwitcher moveTracker ) {
				
		this.thisPiece = thisPiece;
		Coordinate[][] moveRule = thisPiece.getMoveRule();
		boolean canJump = thisPiece.getCanJump();
		boolean isPawn = thisPiece.getIsPawn();
		boolean canMoveBackward = thisPiece.getCanMoveBackward();
		Coordinate[] horzVertRule = moveRule[0];
		Coordinate[] diagonalRule = moveRule[1];
		int x,y;
		if (moveTracker.getColour().equals(Side.WHITE)){
			x = thisPiece.getPosition().getxCoord();
			y = thisPiece.getPosition().getyCoord();
		}
		else {
			x = 7-thisPiece.getPosition().getxCoord();
			y = 7-thisPiece.getPosition().getyCoord();
		}
		boolean anySelectedHorz = horzCheck( thisPiece, moveTracker, x, y, horzVertRule, canJump, isPawn, canMoveBackward );
		boolean anySelectedDiag = diagCheck( thisPiece, moveTracker, x, y, diagonalRule, canJump, isPawn, canMoveBackward );
		
		return (anySelectedHorz || anySelectedDiag);
	}
	
	private boolean horzCheck( ChessPiece thisPiece, MoveSwitcher moveTracker, int x, int y, Coordinate[] horzVertRule, boolean canJump, boolean isPawn, boolean canMoveBackward ) {
		boolean anySelected = false;
		try{
		for (Coordinate rule:horzVertRule){
			int xNP;
			int yNP;
			int xNM;
			int yNM;
			if (canJump) {
				xNP = x+rule.getxCoord();
				yNP = y+rule.getyCoord();
				xNM = x-rule.getxCoord();
				yNM = y-rule.getyCoord();
				if((xNP<=7)&&(xNP>=0)){
					if((yNP<=7)&&(yNP>=0)){
						if ((localBoard[xNP][yNP] == null)) {
							chessSquares[7-xNP][yNP].invert();
							anySelected = true;
						}
						else if ((localBoard[xNP][yNP].getColour() != thisPiece.getColour() )) {
							chessSquares[7-xNP][yNP].invert();
							anySelected = true;
						}
					}
					if((yNM<=7)&&(yNM>=0)){
						if ((localBoard[xNP][yNM] == null)) {
							chessSquares[7-xNP][yNM].invert();
							anySelected = true;
						}
						else if ((localBoard[xNP][yNM].getColour() != thisPiece.getColour() )) {
							chessSquares[7-xNP][yNM].invert();
							anySelected = true;
						}
					}
				}
				if((xNM<=7)&&(xNM>=0)){
					if((yNP<=7)&&(yNP>=0)){
						if ((localBoard[xNM][yNP] == null)) {
							chessSquares[7-xNM][yNP].invert();
							anySelected = true;
						}
						else if ((localBoard[xNM][yNP].getColour() != thisPiece.getColour() )) {
							chessSquares[7-xNM][yNP].invert();
							anySelected = true;
						}
					}
					if((yNM<=7)&&(yNM>=0)){
						if ((localBoard[xNM][yNM] == null)) {
							chessSquares[7-xNM][yNM].invert();
							anySelected = true;
						}
						else if ((localBoard[xNM][yNM].getColour() != thisPiece.getColour() )) {
							chessSquares[7-xNM][yNM].invert();
							anySelected = true;
						}
					}
				}
			}
			else if(isPawn) {
				xNP = x+rule.getxCoord();
				yNP = y+rule.getyCoord();
				if ((xNP<=7)&&(xNP>=0)&&(yNP<=7)&&(yNP>=0)){
					if ((localBoard[xNP][yNP] == null ) && (localBoard[x+1][y] == null )) {
						chessSquares[7-xNP][yNP].invert();
						anySelected = true;
					}
				
					if(((x+1)<=7)&&((x+1)>=0)&&((y+1)<=7)&&((y+1)>=0)){
						if (localBoard[x+1][y+1] != null){
						if ((localBoard[x+1][y+1].getColour() != thisPiece.getColour())){
							chessSquares[7-(x+1)][y+1].invert();
							anySelected = true;
						}
						}
					}
					if(((x+1)<=7)&&((x+1)>=0)&&((y-1)<=7)&&((y-1)>=0)){
						if (localBoard[x+1][y-1] != null){
						if ((localBoard[x+1][y-1].getColour() != thisPiece.getColour())){
							chessSquares[7-(x+1)][y-1].invert();
							anySelected = true;
						}
						}
					}
			}
			}
			else if((rule.getxCoord() == 1) || (rule.getyCoord() == 1)){
				xNP = x+rule.getxCoord();
				xNM = x-rule.getxCoord();
				yNP = y+rule.getyCoord();
				yNM = y-rule.getyCoord();
				if (rule.getxCoord() == 1) {
					if ((xNP<8)&&(xNP>=0)){
					if (localBoard[xNP][y] != null) {
						if (localBoard[xNP][y].getColour() != thisPiece.getColour()){
							chessSquares[7-xNP][y].invert();
							anySelected = true;
						}
						
					}
					else {
						chessSquares[7-xNP][y].invert();
						anySelected = true;
					}
					}
					
					if ((xNM<8)&&(xNM>=0)){
					if (localBoard[xNM][y] != null) {
						if (localBoard[xNM][y].getColour() != thisPiece.getColour()){
							chessSquares[7-xNM][y].invert();
							anySelected = true;
						}
					}
					
					else {
						chessSquares[7-xNM][y].invert();
						anySelected = true;
					}
					}
				}
				if (rule.getyCoord() == 1) {
					if ((yNP<8)&&(yNP>=0)){
					if (localBoard[x][yNP] != null) {
						if (localBoard[x][yNP].getColour() != thisPiece.getColour()){
							chessSquares[7-x][yNP].invert();
							anySelected = true;
						}
					}
					
					else {
						chessSquares[7-x][yNP].invert();
						anySelected = true;
					}
					}
					
					if ((yNM<8)&&(yNM>=0)){
					if (localBoard[x][yNM] != null) {
						if (localBoard[x][yNM].getColour() != thisPiece.getColour()){
							chessSquares[7-x][yNM].invert();
							anySelected = true;
						}
					}
					
					else {
						chessSquares[7-x][yNM].invert();
						anySelected = true;
					}
					}
				}
			}
			else {
				if (rule.getxCoord() == inf) {
					if ((x+1)<=8){
					for(int row = (x+1); row <8; row++) {
						if (localBoard[row][y] != null) {
							if (localBoard[row][y].getColour() != thisPiece.getColour()){
								chessSquares[7-row][y].invert();
								anySelected = true;
							}
							break;
						}
						else {
							chessSquares[7-row][y].invert();
							anySelected = true;
						}
					}
					}
					if ((x-1)>=0){
						for(int row = (x-1); row >=0; row--) {
							if (localBoard[row][y] != null) {
								if (localBoard[row][y].getColour() != thisPiece.getColour()){
									chessSquares[7-row][y].invert();
									anySelected = true;
								}
								break;
							}
							else {
								chessSquares[7-row][y].invert();
								anySelected = true;
							}
						}
						}
				}
				
				if (rule.getyCoord() == inf) {
					if ((y+1)<=8){
					for(int col = (y+1); col <8; col++) {
						if (localBoard[x][col] != null) {
							if (localBoard[x][col].getColour() != thisPiece.getColour()){
								chessSquares[7-x][col].invert();
								anySelected = true;
							}
							break;
						}
						else {
							chessSquares[7-x][col].invert();
							anySelected = true;
						}
					}
					}
					if ((y-1)>=0){
						for(int col = (y-1); col >=0; col--) {
							if (localBoard[x][col] != null) {
								if (localBoard[x][col].getColour() != thisPiece.getColour()){
									chessSquares[7-x][col].invert();
									anySelected = true;
								}
								break;
							}
							else {
								chessSquares[7-x][col].invert();
								anySelected = true;
							}
						}
						}
				}
				
				
			}
			
		}
	}catch(Exception e) {
		e.printStackTrace();		
	}
		return anySelected;
	}
	
	public boolean diagCheck( ChessPiece thisPiece, MoveSwitcher moveTracker, int x, int y, Coordinate[] diagonalRule, boolean canJump, boolean isPawn, boolean canMoveBackward ) {
		boolean anySelected = false;
		try {
		for (Coordinate rule:diagonalRule){
		if ((rule.getxCoord() == inf) && (rule.getyCoord() == inf)) {
			
			for(int counter = 1; counter <8; counter++) {
				if ((((x+counter<8)&& ((x+counter)>=0))) && (((y+counter)<8)&& ((y+counter)>=0))) {
				if (localBoard[x+counter][y+counter] != null) {
					if (localBoard[x+counter][y+counter].getColour() != thisPiece.getColour()){
						chessSquares[7-(x+counter)][(y+counter)].invert();
						anySelected = true;
					}
					break;
				}
				else {
					chessSquares[7-(x+counter)][(y+counter)].invert();
					anySelected = true;
				}		
				
			}
			}
			
			for(int counter = 1; counter <8; counter++) {
				if ((((x-counter<8)&& ((x-counter)>=0))) && (((y-counter)<8)&& ((y-counter)>=0))) {
				if (localBoard[x-counter][y-counter] != null) {
					if (localBoard[x-counter][y-counter].getColour() != thisPiece.getColour()){
						chessSquares[7-(x-counter)][(y-counter)].invert();
						anySelected = true;
					}
					break;
				}
				else {
					chessSquares[7-(x-counter)][(y-counter)].invert();
					anySelected = true;
				}		
				
			}
			}
			
			for(int counter = 1; counter <8; counter++) {
				if ((((x+counter<8)&& ((x+counter)>=0))) && (((y-counter)<8)&& ((y-counter)>=0))) {
				if (localBoard[x+counter][y-counter] != null) {
					if (localBoard[x+counter][y-counter].getColour() != thisPiece.getColour()){
						chessSquares[7-(x+counter)][(y-counter)].invert();
						anySelected = true;
					}
					break;
				}
				else {
					chessSquares[7-(x+counter)][(y-counter)].invert();
					anySelected = true;
				}		
				
			}
			}
			
			for(int counter = 1; counter <8; counter++) {
				if ((((x-counter<8)&& ((x-counter)>=0))) && (((y+counter)<8)&& ((y+counter)>=0))) {
				if (localBoard[x-counter][y+counter] != null) {
					if (localBoard[x-counter][y+counter].getColour() != thisPiece.getColour()){
						chessSquares[7-(x-counter)][(y+counter)].invert();
						anySelected = true;
					}
					break;
				}
				else {
					chessSquares[7-(x-counter)][(y+counter)].invert();
					anySelected = true;
				}		
				}
			}
				
				
		}
		
		else if ((rule.getxCoord() == 1) && (rule.getyCoord() == 1)) {
			
			if (((((x+1)<8)&& ((x+1)>=0))) && (((y+1)<8)&& ((y+1)>=0))) {
				if (localBoard[x+1][y+1] != null) {
					if (localBoard[x+1][y+1].getColour() != thisPiece.getColour()){
						chessSquares[7-(x+1)][(y+1)].invert();
						anySelected = true;
					}
				}
				else {
					chessSquares[7-(x+1)][(y+1)].invert();
					anySelected = true;
				}		
				
			}
						
			if (((((x-1)<8)&& ((x-1)>=0))) && (((y-1)<8)&& ((y-1)>=0))) {
				if (localBoard[x-1][y-1] != null) {
					if (localBoard[x-1][y-1].getColour() != thisPiece.getColour()){
						chessSquares[7-(x-1)][(y-1)].invert();
						anySelected = true;
					}
				}
				else {
					chessSquares[7-(x-1)][(y-1)].invert();
					anySelected = true;
				}		
				
			}
			
			if (((((x+1)<8)&& ((x+1)>=0))) && (((y-1)<8)&& ((y-1)>=0))) {
				if (localBoard[x+1][y-1] != null) {
					if (localBoard[x+1][y-1].getColour() != thisPiece.getColour()){
						chessSquares[7-(x+1)][(y-1)].invert();
						anySelected = true;
					}
				}
				else {
					chessSquares[7-(x+1)][(y-1)].invert();
					anySelected = true;
				}		
				
			}
				
			if (((((x-1)<8)&& ((x-1)>=0))) && (((y+1)<8)&& ((y+1)>=0))) {
				if (localBoard[x-1][y+1] != null) {
					if (localBoard[x-1][y+1].getColour() != thisPiece.getColour()){
						chessSquares[7-(x-1)][(y+1)].invert();
						anySelected = true;
					}
				}
				else {
					chessSquares[7-(x-1)][(y+1)].invert();
					anySelected = true;
				}		
				
			}
				
				
		}
		
	}
	}catch(Exception e) {
		e.printStackTrace();		
	}
	return anySelected;
	}
	
	public void makeMove(Coordinate cellCoord) {
		if(moveTracker.getColour().equals(Side.WHITE)){
			if(localBoard[7-cellCoord.getxCoord()][cellCoord.getyCoord()] != null){
			localBoard[7-cellCoord.getxCoord()][cellCoord.getyCoord()].setIsDeleted(true);
			}
			localBoard[7-cellCoord.getxCoord()][cellCoord.getyCoord()] = localBoard[thisPiece.getPosition().getxCoord()][thisPiece.getPosition().getyCoord()];
			localBoard[thisPiece.getPosition().getxCoord()][thisPiece.getPosition().getyCoord()] = null;
		}
		else{
			if ( localBoard[cellCoord.getxCoord()][7-cellCoord.getyCoord()] != null){
			localBoard[cellCoord.getxCoord()][7-cellCoord.getyCoord()].setIsDeleted(true);
			}
			localBoard[cellCoord.getxCoord()][7-cellCoord.getyCoord()] = localBoard[7-thisPiece.getPosition().getxCoord()][7-thisPiece.getPosition().getyCoord()];
			localBoard[7-thisPiece.getPosition().getxCoord()][7-thisPiece.getPosition().getyCoord()] = null;
		}
		this.thisPiece.setPosition(new Coordinate(7-cellCoord.getxCoord(),cellCoord.getyCoord()));
		moveTracker.changeSide();
		reflect();
	}
	public void reflect(){
		if(moveTracker.getColour().equals(Side.BLACK)){
		ChessPiece[][] reflectedLocalBoard = new ChessPiece[8][8];
		for (int row=0; row < 8; row++){
			for (int col=0; col < 8; col++){
				reflectedLocalBoard[row][col]=this.localBoard[7-row][7-col];
			}
		}
		this.localBoard = reflectedLocalBoard;
		
		ChessSquareBackground[][] reflectedChessSquares = new ChessSquareBackground[8][8];
		for (int row=0; row < 8; row++){
			for (int col=0; col < 8; col++){
				reflectedChessSquares[row][col]=this.chessSquares[7-row][7-col];
			}
		}
		this.chessSquares = reflectedChessSquares;
		}
		else {
			ChessPiece[][] reflectedLocalBoard = new ChessPiece[8][8];
			for (int row=0; row < 8; row++){
				for (int col=0; col < 8; col++){
					reflectedLocalBoard[row][col]=this.localBoard[7-row][7-col];
				}
			}
			this.localBoard = reflectedLocalBoard;
			
			ChessSquareBackground[][] reflectedChessSquares = new ChessSquareBackground[8][8];
			for (int row=0; row < 8; row++){
				for (int col=0; col < 8; col++){
					reflectedChessSquares[row][col]=this.chessSquares[7-row][7-col];
				}
			}
			this.chessSquares = reflectedChessSquares;
		}
	}
}