package com.throwner.engine.character.dwarf;

import com.throwner.engine.character.CharacterFactory;
import com.throwner.engine.character.CharacterType;
import com.throwner.engine.character.Charater;

public class DwarfFactory implements CharacterFactory{

	@Override
	public Charater createCharacter(CharacterType c) {
		return new DwarfCharacter(CharacterType.DWARF);
		
	}

}
