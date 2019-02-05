package com.throwner.engine.character;

public class GenericCharacter {
	private CharacterType characterType;
	private String name;
	private int charXpos;
	private int charYpos;
	
	public GenericCharacter(CharacterType characterType){
		setCharacterType(characterType);
	}

	public CharacterType getCharacterType() {
		return characterType;
	}

	public void setCharacterType(CharacterType characterType) {
		this.characterType = characterType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCharXpos() {
		return charXpos;
	}

	public void setCharXpos(int charXpos) {
		this.charXpos = charXpos;
	}

	public int getCharYpos() {
		return charYpos;
	}

	public void setCharYpos(int charYpos) {
		this.charYpos = charYpos;
	}
}
