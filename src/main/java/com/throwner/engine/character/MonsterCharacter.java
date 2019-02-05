package com.throwner.engine.character;

import com.throwner.engine.character.stats.CharacterStats;
import com.throwner.engine.character.stats.GenericStats;

public class MonsterCharacter extends GenericCharacter {
	
	private GenericStats charStats;
	
	public MonsterCharacter(CharacterType characterType){
		super(characterType);
		this.charStats = new CharacterStats(characterType.getStrenght(), characterType.getHealth(), characterType.getAgility());
	}

	public GenericStats getCharStats() {
		return charStats;
	}

	public void setCharStats(GenericStats charStats) {
		this.charStats = charStats;
	}

}
