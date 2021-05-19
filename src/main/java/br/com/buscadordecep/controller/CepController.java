package br.com.buscadordecep.controller;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.web.client.RestTemplate;

import br.com.buscadordecep.api.CepClient;
import br.com.buscadordecep.model.CepModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class CepController {
	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField txtCep;

	@FXML
	private TextField txtLogradouro;

	@FXML
	private TextField txtComplemento;

	@FXML
	private TextField txtBairro;

	@FXML
	private TextField txtLocalidade;

	@FXML
	private TextField txtUf;

	@FXML
	private Button btnPesquisar;

	@FXML
	void btnPesquisar(ActionEvent event) {
		String cep = this.txtCep.getText();
		CepClient cepCliente = new CepClient(new RestTemplate(), "https://viacep.com.br/ws/" + cep + "/json/");
		CepModel cepModel = cepCliente.buscar();
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		if (cepModel != null) {
			if (cepModel.getCep() != null) {
				this.txtLogradouro.setText(cepModel.getLogradouro());
				this.txtComplemento.setText(cepModel.getComplemento());
				this.txtBairro.setText(cepModel.getBairro());
				this.txtLocalidade.setText(cepModel.getLocalidade());
				this.txtUf.setText(cepModel.getUf());
			} else {
				alert.setContentText("Cep não encontrado!");
				alert.show();
			}
		} else {
			alert.setContentText("Cep inválido!");
			alert.show();
		}
	}

	@FXML
	void initialize() {

	}
}
