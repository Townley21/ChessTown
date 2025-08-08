package com.example.chesstown.model.board;

import com.example.chesstown.model.board.square.ISquare;
import com.example.chesstown.model.board.square.Square;
import com.example.chesstown.model.common.IPosition;

public class Board implements IBoard
{
    private static final Square[][] board = new Square[8][8];

    public Board()
    {

    }

    @Override
    public ISquare getSquare(IPosition position)
    {
        return board[position.getX()][position.getY()];
    }

    @Override
    public ISquare getSquare(int x, int y)
    {
        return board[x][y];
    }
}
