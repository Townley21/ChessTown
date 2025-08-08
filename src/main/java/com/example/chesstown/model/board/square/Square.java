package com.example.chesstown.model.board.square;

import com.example.chesstown.model.common.IPosition;
import com.example.chesstown.model.piece.IPiece;

import java.util.Optional;

public class Square implements ISquare
{
    private final IPosition position;
    private IPiece piece;

    public Square(IPosition position, IPiece piece)
    {
        this.position = position;
        this.piece = piece;
    }

    @Override
    public IPosition getPosition()
    {
        return position;
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
