package com.example.chesstown.model.board.square;

import com.example.chesstown.model.common.IPosition;
import com.example.chesstown.model.piece.IPiece;

import java.util.Optional;

public class Square implements ISquare
{
    private final int x;
    private final int y;
    private IPiece piece;

    public Square(int x, int y, IPiece piece)
    {
        this.x = x;
        this.y = y;
        this.piece = piece;
    }

    @Override
    public int getRank()
    {
        return x;
    }

    @Override
    public int getFile()
    {
        return y;
    }

    @Override
    public Optional<IPiece> getPiece()
    {
        return Optional.ofNullable(piece);
    }

    @Override
    public void setPiece(IPiece piece)
    {
        this.piece = piece;
    }
}
