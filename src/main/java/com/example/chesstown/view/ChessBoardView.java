package com.example.chesstown.view;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.*;

import java.util.function.BiConsumer;

public final class ChessBoardView
{
    private static final int SIZE = 8;
    private final GridPane grid = new GridPane();
    private final StackPane[][] cells = new StackPane[SIZE][SIZE];
    private BiConsumer<Integer, Integer> onSquareClicked;

    public ChessBoardView()
    {
        grid.setPrefSize(640, 640);
        grid.setMaxSize(640, 640);
        grid.setMinSize(640, 640);
        grid.setGridLinesVisible(false);

        for (int i = 0; i < SIZE; i++)
        {
            var col = new ColumnConstraints();
            col.setPercentWidth(100.0 / SIZE);
            var row = new RowConstraints();
            row.setPercentHeight(100.0 / SIZE);
            grid.getColumnConstraints().add(col);
            grid.getRowConstraints().add(row);
        }

        for (int rank = 0; rank < SIZE; rank++)
        {
            for (int file = 0; file < SIZE; file++)
            {
                var cell = new StackPane();
                cell.getStyleClass().add((file + rank) % 2 == 0 ? "light" : "dark");
                cell.setOnMouseClicked(evt -> {
                    Integer row = GridPane.getRowIndex(cell);
                    Integer column = GridPane.getColumnIndex(cell);
                    onSquareClicked.accept(row, column);
                });

                cell.minWidthProperty().bind(grid.widthProperty().divide(SIZE));
                cell.maxWidthProperty().bind(cell.minWidthProperty());
                cell.minHeightProperty().bind(grid.heightProperty().divide(SIZE));
                cell.maxHeightProperty().bind(cell.minHeightProperty());

                cells[rank][file] = cell;
                grid.add(cell, file, rank);
            }
        }

        grid.getStylesheets().add(getClass().getResource("/chessboard.css").toExternalForm());
    }

    public void setOnSquareClicked(BiConsumer<Integer, Integer> handler)
    {
        this.onSquareClicked = handler;
    }

    public void setPieceNode(int rank, int file, Node pieceNode)
    {
        var cell = cells[rank][file];
        cell.getChildren().removeIf(n -> n.getProperties().getOrDefault("piece", false).equals(true));
        if (pieceNode != null)
        {
            pieceNode.getProperties().put("piece", true);
            StackPane.setAlignment(pieceNode, Pos.CENTER);
            cell.getChildren().add(pieceNode);
        }
    }

    public Parent getRoot()
    {
        return grid;
    }
}
