package com.example.chesstown.model.board.square;

import com.example.chesstown.model.common.IPosition;
import com.example.chesstown.model.piece.IPiece;

import java.util.Optional;

public interface ISquare
{
    IPosition getPosition();
    Optional<IPiece> getPiece();
    void setPiece(IPiece piece);
    default boolean isBackRank()
    {
        return getPosition().getX() == 0 || getPosition().getX() == 7;
    }
}
