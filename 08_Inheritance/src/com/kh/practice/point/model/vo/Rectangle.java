package com.kh.practice.point.model.vo;

public class Rectangle extends Point {

	private int width;
	private int height;

	public Rectangle() {
		super();

	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return this.getX() + ", " + this.getY() + ", " + this.getHeight() + ", " + this.getWidth();
	}

}
