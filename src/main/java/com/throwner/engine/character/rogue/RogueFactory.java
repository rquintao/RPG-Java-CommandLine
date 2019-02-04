package com.throwner.engine.character.rogue;

import com.throwner.engine.character.CharacterFactory;
import com.throwner.engine.character.CharacterType;
import com.throwner.engine.character.Charater;

public class RogueFactory implements CharacterFactory{

	@Override
	public Charater createCharacter(CharacterType c) {
		return new RogueCharacter(CharacterType.ROGUE);
		
	}

}
