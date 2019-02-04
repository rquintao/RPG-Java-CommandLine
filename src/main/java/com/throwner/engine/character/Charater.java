package com.throwner.engine.character;

public abstract class Charater {
	
	private CharacterType characterType;
	private CharacterStats charStats = new CharacterStats();
	private String name;
	private int playerXpos;
	private int playerYpos;
	
	public abstract CharacterType getCharacterType();
	
	public Charater(CharacterType characterType){
		this.characterType=characterType;
	}

	public CharacterStats getCharStats() {
		return charStats;
	}

	public void setCharStats(CharacterStats charStats) {
		this.charStats = charStats;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPlayerXpos() {
		return playerXpos;
	}

	public void setPlayerXpos(int playerXpos) {
		this.playerXpos = playerXpos;
	}

	public int getPlayerYpos() {
		return playerYpos;
	}

	public void setPlayerYpos(int playerYpos) {
		this.playerYpos = playerYpos;
	}
	
	


}
