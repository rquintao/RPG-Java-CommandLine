package com.throwner.engine.world;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class World implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6830300702630322833L;
	Tile[][] worldMap;
	List<Tile> tiles = new ArrayList<>();
	private int width;
	private int height;
	
	public World (int width, int height){
		worldMap = new Tile[width][height];
		
		for (int i = 0; i< width; i++){
			for (int j = 0; j< width; j++){
				worldMap[i][j] = new Tile(i, j);
				tiles.add(worldMap[i][j]);
			}
		}
		
		this.setHeight(height);
		this.setWidth(width);
	}
	
	public Tile getTile(int i, int y){
		return worldMap[i][y];
	}
	
    public List<Tile> getTiles(){
        return tiles;
    }

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	
}
