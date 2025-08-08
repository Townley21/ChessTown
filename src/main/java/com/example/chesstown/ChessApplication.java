package com.example.chesstown;

import com.example.chesstown.model.board.Board;
import com.example.chesstown.model.board.IBoard;
import com.example.chesstown.view.ChessBoardController;
import com.example.chesstown.view.ChessBoardView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ChessApplication extends Application
{
    @Override
    public void start(Stage stage)
    {
        IBoard board = new Board();
        ChessBoardView view = new ChessBoardView();
        ChessBoardController controller = new ChessBoardController(board, view);

        Scene scene = new Scene(view.getRoot(), 640, 640);
        stage.setTitle("Chess Engine");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        controller.refresh();
    }

    public static void main(String[] args)
    {
        launch();
    }
}