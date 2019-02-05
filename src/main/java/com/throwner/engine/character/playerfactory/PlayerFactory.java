package com.throwner.engine.character.playerfactory;

import com.throwner.engine.character.CharacterFactory;
import com.throwner.engine.character.CharacterType;
import com.throwner.engine.character.Charater;

public class PlayerFactory implements CharacterFactory{

	@Override
	public Charater createCharacter(CharacterType c) {
		return new PlayerCharacter(c);
		
	}


}
