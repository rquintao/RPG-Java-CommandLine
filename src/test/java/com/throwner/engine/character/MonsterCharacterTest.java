package com.throwner.engine.character;

import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;

import junit.framework.Assert;

public class MonsterCharacterTest {
	MonsterCharacter expected;
	
	@Parameters
	public void data(){
		this.expected = new MonsterCharacter(CharacterType.MONSTER_1);
		this.expected.setName("Berto");
	}
	
	public MonsterCharacterTest(){
		data();
	}

	@Test
	public void test() {
		Assert.assertEquals(expected.getCharacterType(), CharacterType.MONSTER_1);
		Assert.assertEquals(expected.getCharStats().getHealth(), 2);
	}

}
