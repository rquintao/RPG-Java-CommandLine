package com.throwner.engine.character;

public class PaladinCharacter extends Character{
	
	private CharacterType character;
	
	public PaladinCharacter(CharacterType character){
		this.character = character;
	}

	public CharacterType getCharacterType() {
		return this.character;
	}

}
