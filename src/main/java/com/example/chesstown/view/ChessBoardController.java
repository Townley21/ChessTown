package com.example.chesstown.view;

import com.example.chesstown.model.board.IBoard;
import com.example.chesstown.model.board.square.ISquare;
import com.example.chesstown.model.piece.IPiece;

import java.util.Optional;

public class ChessBoardController
{
    private final IBoard board;
    private final ChessBoardView view;
    private ISquare selectedSquare;

    public ChessBoardController(IBoard board, ChessBoardView view)
    {
        this.board = board;
        this.view = view;

        view.setOnSquareClicked(this::handleSquareClick);
    }

    public void handleSquareClick(Integer rank, Integer file)
    {
        System.out.println(rank + " " + file);
        ISquare square = board.getSquare(rank, file);

        if (selectedSquare == null)
        {
            selectedSquare = square;
            return;
        }

        if (selectedSquare.getPiece().isPresent())
        {
            square.setPiece(selectedSquare.getPiece().get());
            selectedSquare.setPiece(null);
            selectedSquare = null;
            refresh();
        }
    }

    public void refresh()
    {
        // draw pieces
        for (int x = 0; x < 8; x++)
        {
            for (int y = 0; y < 8; y++)
            {
                Optional<IPiece> piece = board.getSquare(x, y).getPiece();
                view.setPieceNode(x, y, piece.map(PieceNode::new).orElse(null));
            }
        }
    }


}
