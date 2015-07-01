package fr.npellegrin.xebia.mower.orientation;

public class Position {
	private int x;
	private int y;

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void push(Orientation orientation) {
		this.x += orientation.getXVector();
		this.y += orientation.getYVector();
	}

}