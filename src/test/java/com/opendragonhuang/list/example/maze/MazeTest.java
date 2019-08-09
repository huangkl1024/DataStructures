package com.opendragonhuang.list.example.maze;

import org.junit.Test;

import static org.junit.Assert.*;

public class MazeTest {

    @Test
    public void path() {
        int[][] maze = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 1, 0, 0, 0, 1, 0, 1},
                {1, 0, 0, 1, 0, 0, 0, 1, 0, 1},
                {1, 0, 0, 0, 0, 1, 1, 0, 0, 1},
                {1, 0, 1, 1, 1, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 1, 0, 0, 0, 0, 1},
                {1, 0, 1, 0, 0, 0, 1, 0, 0, 1},
                {1, 0, 1, 1, 1, 0, 1, 1, 0, 1},
                {1, 1, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };

        Maze mazeObj = new Maze(maze, new Position(1, 1), new Position(8, 8));
        mazeObj.path();

        for (int i = 0; i < maze.length; i++) {
            for (int i1 = 0; i1 < maze[0].length; i1++) {
                switch (maze[i][i1]){
                    case 0:
                    case 3:
                        System.out.print("▯");
                        break;
                    case 1:
                        System.out.print("▮");
                        break;
                    case 2:
                        System.out.print("◉");
                        break;
                }
            }
            System.out.println();
        }
    }
}