package com.example.chesstown.model.board.square;

import com.example.chesstown.model.common.IPosition;
import com.example.chesstown.model.piece.IPiece;

import java.util.Optional;

public interface ISquare
{
    int getRank();
    int getFile();
    Optional<IPiece> getPiece();
    void setPiece(IPiece piece);
    default boolean isBackRank()
    {
        return getRank() == 0 || getRank() == 7;
    }
}
