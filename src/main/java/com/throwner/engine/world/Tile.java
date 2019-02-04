package com.throwner.engine.world;

public class Tile {
	
	@SuppressWarnings("unused")
	private final int xPos, yPos;
	private String type;
	private boolean isOccupiedbyPlayer;
	private boolean isDiscovered;
	private String spriteValue = ".";
	
	public Tile(int xPos, int yPos){
		this.xPos = xPos;
		this.yPos = yPos;
	}
	
	public void updateTile(){
		if (isDiscovered){
			this.spriteValue = "O";
		}
		
		if (isOccupiedbyPlayer){
			this.spriteValue = "X";
		}
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSpriteValue() {
		return spriteValue;
	}

	public void setSpriteValue(String spriteValue) {
		this.spriteValue = spriteValue;
	}

	public boolean isDiscovered() {
		return isDiscovered;
	}

	public void setDiscovered(boolean isDiscovered) {
		this.isDiscovered = isDiscovered;
	}

	public boolean isOccupiedbyPlayer() {
		return isOccupiedbyPlayer;
	}

	public void setOccupiedbyPlayer(boolean isOccupiedbyPlayer) {
		this.isOccupiedbyPlayer = isOccupiedbyPlayer;
	}
}
