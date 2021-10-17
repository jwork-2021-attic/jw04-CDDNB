package world;

/*
 * Copyright (C) 2015 s-zhouj
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
/**
 *
 * @author s-zhouj
 */
public class WorldBuilder {

    private int width;
    private int height;
    private Tile[][] tiles;

    public WorldBuilder(int width, int height) {
        this.width = width;
        this.height = height;
        this.tiles = new Tile[width][height];
    }

    public World build() {
        return new World(tiles);
    }

    /*private WorldBuilder randomizeTiles() {
        for (int width = 0; width < this.width; width++) {
            for (int height = 0; height < this.height; height++) {
                Random rand = new Random();
                switch (rand.nextInt(World.TILE_TYPES)) {
                    case 0:
                        tiles[width][height] = Tile.FLOOR;
                        break;
                    case 1:
                        tiles[width][height] = Tile.WALL;
                        break;
                }
            }
        }
        return this;
    }*/
    private WorldBuilder buildTiles() {
        MazeGenerator mazeGenerator = new MazeGenerator(width<height?width : height);
        for (int width = 0; width < this.width; width++) {
            for (int height = 0; height < this.height; height++) {
                
                switch (mazeGenerator.getMaze()[width][height]){
                //switch (new MazeGenerator(40).getMaze()[width][height]) {
                    case 1:
                        tiles[width][height] = Tile.FLOOR;
                        break;
                    case 0:
                        tiles[width][height] = Tile.WALL;
                        break;
                }
            }
        }
        return this;
    }

    public WorldBuilder makeMaze() {
        return buildTiles();
    }
}
