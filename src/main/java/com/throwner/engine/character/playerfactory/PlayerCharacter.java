package com.throwner.engine.character.playerfactory;

import java.io.Serializable;

import com.throwner.engine.character.CharacterType;
import com.throwner.engine.character.Charater;
import com.throwner.engine.character.stats.CharacterStats;

public class PlayerCharacter extends Charater implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7377955355289945964L;
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
