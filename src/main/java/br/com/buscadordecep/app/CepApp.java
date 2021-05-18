package br.com.buscadordecep.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CepApp extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/view/MainScreen.fxml"));
			primaryStage.setScene(new Scene(root));
			primaryStage.setTitle("BUSCADOR DE CEP");
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
