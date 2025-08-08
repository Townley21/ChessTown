package com.example.chesstown.model.board;

import com.example.chesstown.model.board.square.ISquare;
import com.example.chesstown.model.common.IPosition;

public interface IBoard
{
    ISquare getSquare(IPosition position);
    ISquare getSquare(int x, int y);
}
