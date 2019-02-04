package com.throwner.engine.character.paladin;

import com.throwner.engine.character.CharacterFactory;
import com.throwner.engine.character.CharacterType;
import com.throwner.engine.character.Charater;

public class PaladinFactory implements CharacterFactory{

	@Override
	public Charater createCharacter(CharacterType c) {
		return new PaladinCharacter(CharacterType.PALADIN);
		
	}

}
