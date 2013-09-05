package com.chess.coordinates;

public class Coordinate {
	
	int xCoord;
	int yCoord;
	
	public Coordinate ( int xCoord, int yCoord ) {
		this.xCoord = xCoord;
		this.yCoord = yCoord;
	}
	
	public Coordinate invCoordinate () {
		return (new Coordinate( 7-xCoord, 7-yCoord ));
	}

	public int getxCoord() {
		return xCoord;
	}

	public void setxCoord(int xCoord) {
		this.xCoord = xCoord;
	}

	public int getyCoord() {
		return yCoord;
	}

	public void setyCoord(int yCoord) {
		this.yCoord = yCoord;
	}
}
