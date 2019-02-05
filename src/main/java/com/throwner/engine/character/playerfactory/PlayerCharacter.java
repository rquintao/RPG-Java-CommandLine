package com.throwner.engine.character.playerfactory;

import com.throwner.engine.character.CharacterType;
import com.throwner.engine.character.Charater;
import com.throwner.engine.character.stats.CharacterStats;

public class PlayerCharacter extends Charater{
	
	private CharacterType character;
	
	public PlayerCharacter(CharacterType character){
		
		super(character);
		
		this.character = character;
		
		CharacterStats charStats = new CharacterStats(character.getStrenght(), 
													  character.getHealth(), 
													  character.getAgility());
		
		super.setCharStats(charStats);
		
	}

	public CharacterType getCharacterType() {
		return this.character;
	}

}
