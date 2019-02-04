package com.throwner.engine.character;

public class PaladinFactory implements CharacterFactory{

	@Override
	public Character createCharacter(CharacterType c) {
		return new PaladinCharacter(CharacterType.PALADIN);
		
	}

}
