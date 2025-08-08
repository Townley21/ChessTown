package com.example.chesstown.view;

import com.example.chesstown.model.board.IBoard;
import com.example.chesstown.model.board.square.Square;
import com.example.chesstown.model.piece.IPiece;
import com.example.chesstown.model.piece.Piece;
import com.example.chesstown.model.piece.PieceColor;
import com.example.chesstown.model.piece.PieceType;

public class ChessBoardController
{
    private final IBoard board;
    private final ChessBoardView view;
    private Square selected;

    public ChessBoardController(IBoard board, ChessBoardView view)
    {
        this.board = board;
        this.view = view;
    }

    public void refresh()
    {
        // clear highlights
        for (int x = 0; x < 8; x++) for (int y = 0; y < 8; y++) view.setHighlight(x, y, false);

        // draw pieces
        for (int x = 0; x < 8; x++)
        {
            for (int y = 0; y < 8; y++)
            {
                IPiece piece = buildPieceFromPosition(x, y);
                view.setPieceNode(x, y, piece == null ? null : new PieceNode(piece));
            }
        }
    }

    private IPiece buildPieceFromPosition(int x, int y)
    {
        if (y == 1) return new Piece(PieceColor.BLACK, PieceType.PAWN);
        if (y == 6) return new Piece(PieceColor.WHITE, PieceType.PAWN);

        if (!(y == 0 || y == 7))
        {
            return null;
        }

        return switch (x)
        {
            case 0 -> y == 0 ? new Piece(PieceColor.BLACK, PieceType.ROOK) : new Piece(PieceColor.WHITE, PieceType.ROOK);
            case 1 -> y == 0 ? new Piece(PieceColor.BLACK, PieceType.KNIGHT) : new Piece(PieceColor.WHITE, PieceType.KNIGHT);
            case 2 -> y == 0 ? new Piece(PieceColor.BLACK, PieceType.BISHOP) : new Piece(PieceColor.WHITE, PieceType.BISHOP);
            case 3 -> y == 0 ? new Piece(PieceColor.BLACK, PieceType.QUEEN) : new Piece(PieceColor.WHITE, PieceType.QUEEN);
            case 4 -> y == 0 ? new Piece(PieceColor.BLACK, PieceType.KING) : new Piece(PieceColor.WHITE, PieceType.KING);
            case 5 -> y == 0 ? new Piece(PieceColor.BLACK, PieceType.BISHOP) : new Piece(PieceColor.WHITE, PieceType.BISHOP);
            case 6 -> y == 0 ? new Piece(PieceColor.BLACK, PieceType.KNIGHT) : new Piece(PieceColor.WHITE, PieceType.KNIGHT);
            case 7 -> y == 0 ? new Piece(PieceColor.BLACK, PieceType.ROOK) : new Piece(PieceColor.WHITE, PieceType.ROOK);
            default -> null;
        };
    }
}
