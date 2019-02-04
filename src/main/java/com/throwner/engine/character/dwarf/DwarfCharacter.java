package com.throwner.engine.character.dwarf;

import com.throwner.engine.character.CharacterStats;
import com.throwner.engine.character.CharacterType;
import com.throwner.engine.character.Charater;

public class DwarfCharacter extends Charater{
	
	private CharacterType character;
	
	public DwarfCharacter(CharacterType character){
		super(CharacterType.DWARF);
		
		this.character = character;
		
		CharacterStats charStats = new CharacterStats();
		
		charStats.setAgility(CharacterType.DWARF.getAgility());
		charStats.setHealth(CharacterType.DWARF.getHealth());
		charStats.setStrenght(CharacterType.DWARF.getStrenght());
		
		super.setCharStats(charStats);
	}

	public CharacterType getCharacterType() {
		return this.character;
	}

}
