package com.example.chesstown.model.board;

import com.example.chesstown.model.board.square.ISquare;
import com.example.chesstown.model.board.square.Square;
import com.example.chesstown.model.common.IPosition;
import com.example.chesstown.model.piece.IPiece;
import com.example.chesstown.model.piece.Piece;
import com.example.chesstown.model.piece.PieceColor;
import com.example.chesstown.model.piece.PieceType;
import com.example.chesstown.view.PieceNode;

public class Board implements IBoard
{
    private final Square[][] board = new Square[8][8];

    public Board()
    {
        for (int x = 0; x < 8; x++)
        {
            for (int y = 0; y < 8; y++)
            {
                IPiece piece = null;

                if (x == 1) piece = new Piece(PieceColor.BLACK, PieceType.PAWN);
                if (x == 6) piece = new Piece(PieceColor.WHITE, PieceType.PAWN);

                if (!(x == 0 || x == 7))
                {
                    board[x][y] = new Square(x, y, piece);
                    continue;
                }

                switch (y)
                {
                    case 0 -> piece = x == 0 ? new Piece(PieceColor.BLACK, PieceType.ROOK) : new Piece(PieceColor.WHITE, PieceType.ROOK);
                    case 1 -> piece = x == 0 ? new Piece(PieceColor.BLACK, PieceType.KNIGHT) : new Piece(PieceColor.WHITE, PieceType.KNIGHT);
                    case 2 -> piece = x == 0 ? new Piece(PieceColor.BLACK, PieceType.BISHOP) : new Piece(PieceColor.WHITE, PieceType.BISHOP);
                    case 3 -> piece = x == 0 ? new Piece(PieceColor.BLACK, PieceType.QUEEN) : new Piece(PieceColor.WHITE, PieceType.QUEEN);
                    case 4 -> piece = x == 0 ? new Piece(PieceColor.BLACK, PieceType.KING) : new Piece(PieceColor.WHITE, PieceType.KING);
                    case 5 -> piece = x == 0 ? new Piece(PieceColor.BLACK, PieceType.BISHOP) : new Piece(PieceColor.WHITE, PieceType.BISHOP);
                    case 6 -> piece = x == 0 ? new Piece(PieceColor.BLACK, PieceType.KNIGHT) : new Piece(PieceColor.WHITE, PieceType.KNIGHT);
                    case 7 -> piece = x == 0 ? new Piece(PieceColor.BLACK, PieceType.ROOK) : new Piece(PieceColor.WHITE, PieceType.ROOK);
                    default -> piece = null;
                };

                board[x][y] = new Square(x, y, piece);
            }
        }
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
