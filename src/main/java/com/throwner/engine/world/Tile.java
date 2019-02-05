package com.throwner.engine.world;

import com.throwner.engine.character.Charater;
import com.throwner.engine.character.MonsterCharacter;
import com.throwner.engine.character.playerfactory.PlayerCharacter;

public class Tile {
	
	@SuppressWarnings("unused")
	private final int xPos, yPos;
	private String type;
	
	private PlayerCharacter player;
	private MonsterCharacter monster;
	
	private boolean isOccupiedbyMonster;
	private boolean isOccupiedbyPlayer;
	private boolean isDiscovered;
	private String spriteValue = ".";
	
	public Tile(int xPos, int yPos){
		this.xPos = xPos;
		this.yPos = yPos;
	}
	
	public void updateTile(){
		if(this.monster!=null){
			this.isOccupiedbyMonster = true;
		}else this.isOccupiedbyMonster = false;
		
		
		if(this.player!=null){
			this.isOccupiedbyPlayer=true;
			this.isDiscovered=true;
		} else this.isOccupiedbyPlayer = false;
		
		if (isDiscovered){
			this.spriteValue = "O";
		}
		
		if (isOccupiedbyPlayer){
			this.spriteValue = "X";
		}
		
		if (isOccupiedbyMonster){
			this.spriteValue = "M";
		}
		
		if(isOccupiedbyPlayer && isOccupiedbyMonster){
			this.spriteValue = "F";
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

	public PlayerCharacter getPlayer() {
		return player;
	}

	public void setPlayer(PlayerCharacter player) {
		this.player = player;
	}

	public MonsterCharacter getMonster() {
		return monster;
	}

	public void setMonster(MonsterCharacter monster) {
		this.monster = monster;
	}

	public boolean isOccupiedbyMonster() {
		return isOccupiedbyMonster;
	}

	public void setOccupiedbyMonster(boolean isOccupiedbyMonster) {
		this.isOccupiedbyMonster = isOccupiedbyMonster;
	}
}
