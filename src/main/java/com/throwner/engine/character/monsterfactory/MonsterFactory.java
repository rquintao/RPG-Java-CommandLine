package com.throwner.engine.character.monsterfactory;

import com.throwner.engine.character.CharacterFactory;
import com.throwner.engine.character.CharacterType;
import com.throwner.engine.character.GenericCharacter;
import com.throwner.engine.character.MonsterCharacter;

public class MonsterFactory implements CharacterFactory{

	@Override
	public GenericCharacter createCharacter(CharacterType c) {
		return new MonsterCharacter(c);
	}

}
