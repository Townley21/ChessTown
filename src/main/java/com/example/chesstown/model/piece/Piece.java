package com.example.chesstown.model.piece;

public class Piece implements IPiece
{
    private final PieceColor pieceColor;
    private final PieceType pieceType;

    public Piece(PieceColor pieceColor, PieceType pieceType)
    {
        this.pieceColor = pieceColor;
        this.pieceType = pieceType;
    }

    @Override
    public PieceColor getPieceColor()
    {
        return pieceColor;
    }

    @Override
    public PieceType getPieceType()
    {
        return pieceType;
    }
}
