package com.example.chesstown.view;

import com.example.chesstown.model.piece.IPiece;
import com.example.chesstown.model.piece.PieceColor;
import javafx.scene.control.Label;

public class PieceNode extends Label
{
    public PieceNode(IPiece piece)
    {
        super(symbol(piece));
        setStyle("-fx-font-size: 36px;");
        setMouseTransparent(true); // clicks go to cell
    }

    private static String symbol(IPiece piece)
    {
        // quick mapping; replace with images later
        return switch (piece.getPieceType())
        {
            case KING -> piece.getPieceColor() == PieceColor.WHITE ? "♔" : "♚";
            case QUEEN -> piece.getPieceColor() == PieceColor.WHITE ? "♕" : "♛";
            case ROOK -> piece.getPieceColor() == PieceColor.WHITE ? "♖" : "♜";
            case BISHOP -> piece.getPieceColor() == PieceColor.WHITE ? "♗" : "♝";
            case KNIGHT -> piece.getPieceColor() == PieceColor.WHITE ? "♘" : "♞";
            case PAWN -> piece.getPieceColor() == PieceColor.WHITE ? "♙" : "♟";
        };
    }
}
