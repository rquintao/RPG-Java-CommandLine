package com.throwner.engine.core;

import java.io.Serializable;
import java.util.List;

import com.throwner.engine.character.MonsterCharacter;
import com.throwner.engine.character.playerfactory.PlayerCharacter;
import com.throwner.engine.world.World;

public class Game implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -717620134102564645L;
	
	public Game(PlayerCharacter player, World world, List<MonsterCharacter> monsters){
		setPlayer(player);
		setWorld(world);
		setMonsters(monsters);
	}
	
	private PlayerCharacter player;
	private World world;
	private List<MonsterCharacter> monsters;
	
	
	public PlayerCharacter getPlayer() {
		return player;
	}
	public void setPlayer(PlayerCharacter player) {
		this.player = player;
	}
	public World getWorld() {
		return world;
	}
	public void setWorld(World world) {
		this.world = world;
	}
	public List<MonsterCharacter> getMonsters() {
		return monsters;
	}
	public void setMonsters(List<MonsterCharacter> monsters) {
		this.monsters = monsters;
	}
	

}
