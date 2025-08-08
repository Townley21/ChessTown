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

    public ChessBoardView()
    {
        grid.setPrefSize(640, 640);
        grid.setMaxSize(640, 640);
        grid.setMinSize(640, 640);
        grid.setGridLinesVisible(false); // flip to true for debugging

        // 8 equal rows/columns
        for (int i = 0; i < SIZE; i++)
        {
            var col = new ColumnConstraints();
            col.setPercentWidth(100.0 / SIZE);
            var row = new RowConstraints();
            row.setPercentHeight(100.0 / SIZE);
            grid.getColumnConstraints().add(col);
            grid.getRowConstraints().add(row);
        }

        // build cells, color them like a chessboard
        for (int rank = 0; rank < SIZE; rank++)
        {
            for (int file = 0; file < SIZE; file++)
            {
                var cell = new StackPane();
                cell.getStyleClass().add((file + rank) % 2 == 0 ? "light" : "dark");
                cell.setOnMouseClicked(evt -> {
                    Integer r = GridPane.getRowIndex(cell);
                    Integer f = GridPane.getColumnIndex(cell);
                    if (onCellClicked != null) onCellClicked.accept(f, r);
                });

                // keep cell square
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

    // simple piece API: you can swap to ImageView later
    public void setPieceNode(int file, int rank, Node pieceNode)
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

    public void setHighlight(int file, int rank, boolean on)
    {
        var cell = cells[rank][file];
        if (on)
        {
            if (cell.getStyleClass().stream().noneMatch(s -> s.equals("hl"))) cell.getStyleClass().add("hl");
        } else
        {
            cell.getStyleClass().remove("hl");
        }
    }

    public Parent getRoot()
    {
        return grid;
    }

    // event wiring
    private BiConsumer<Integer,Integer> onCellClicked;
    public void setOnCellClicked(BiConsumer<Integer,Integer> handler)
    {
        this.onCellClicked = handler;
    }
}
