package br.com.unialfa.tableview.util;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Utils {
	public static void showMessageError(String content) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Erro!");
		alert.setHeaderText(null);
		alert.setContentText(content);
		alert.showAndWait();
	}
}
