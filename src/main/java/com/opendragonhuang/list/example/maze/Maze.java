package com.opendragonhuang.list.example.maze;

import com.opendragonhuang.list.adt.MyStack;
import com.opendragonhuang.list.implement.MyLinkedStack;

/**
 * @author opendragonhuang
 * @version 1.0
 * @date 2019/8/9
 */
public class Maze {
    private class Point{
        int ord;
        Position seat;
        // 1 : east 2：south 3：west 4：north
        int dir;

        public Point(int ord, Position seat, int dir) {
            this.ord = ord;
            this.seat = seat;
            this.dir = dir;
        }
    }
    // 1 有墙 0 空旷 走过 2
    private int[][] maze;
    private Position start;
    private Position end;


    public Maze(int[][] maze, Position start, Position end) {
        this.maze = maze;
        this.start = start;
        this.end = end;
    }

    public boolean path(){
        MyStack<Point> stack = new MyLinkedStack<>();
        // 设定当前路口为开始位置
        Position curPos = new Position(start.getX(), start.getY());
        int curStep = 1;

        do{
            if(isPass(curPos)){
                foodPrint(curPos);
                Point p = new Point(curStep, curPos, 1);
                stack.push(p);
                if(curPos.equals(start)){
                    return true;
                }
                curPos = nextPos(curPos, 1);
                curStep++;
            }else {
                if(!stack.empty()){
                    Point p = stack.pop();
                    while (p.dir == 4 && !stack.empty()){
                        stack.pop();
                    }
                    if(p.dir < 4){
                        p.dir++;
                        stack.push(p);
                        curPos = nextPos(p.seat, p.dir);
                    }
                }
            }

        }while (!stack.empty());

        return false;
    }

    private boolean isPass(Position pos){
        boolean ret = false;
        switch (maze[pos.getY()][pos.getX()]){
            case 0:
                ret = true;
                break;
            case 1:
            case 2:
                ret =  false;
                break;
        }
        return ret;
    }

    private void foodPrint(Position pos){
        maze[pos.getY()][pos.getX()] = 2;
    }


    private Position nextPos(Position pos, int dir){
        Position newPos = new Position();

        switch (dir){
            case 1:
                newPos.setX(pos.getX());
                newPos.setY(pos.getY()+1);
                break;
            case 2:
                newPos.setX(pos.getX()+1);
                newPos.setY(pos.getY());
                break;
            case 3:
                newPos.setX(pos.getX());
                newPos.setY(pos.getY()-1);
                break;
            case 4:
                newPos.setX(pos.getX()-1);
                newPos.setY(pos.getY());
                break;
        }

        return newPos;
    }


}
