package br.com.unialfa.tableview.controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.unialfa.tableview.model.entity.Paciente;
import br.com.unialfa.tableview.model.enumerator.SexoEnum;
import br.com.unialfa.tableview.model.enumerator.TipoAbordagemEnum;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class PacienteController implements Initializable {

	@FXML
	private TableView<Paciente> tblPaciente;

	@FXML
	private TableColumn<Paciente, Number> clnID;

	@FXML
	private TableColumn<Paciente, String> clnNome;

	@FXML
	private TableColumn<Paciente, String> clnEmail;

	@FXML
	private TextField txtID;

	@FXML
	private TextField txtNome;

	@FXML
	private TextField txtEmail;

	@FXML
	private Button btnSalvar;

	@FXML
	private Button btnExcluir;

	@FXML
	private Button btnNovo;

	@FXML
	private GridPane grdConteudo;

	@FXML
	private ComboBox<TipoAbordagemEnum> cmbAbordagem;
    
	@FXML
    private ToggleGroup tgrSexo;

	private ObservableList<Paciente> pacientes = FXCollections.observableArrayList();

	private Paciente pacienteSelected;

	@FXML
	void excluir(ActionEvent event) {
		if (pacienteSelected != null) {
			pacientes.remove(pacienteSelected);
			clear(grdConteudo);
		}
	}

	@FXML
	void selected() {
		pacienteSelected = this.tblPaciente.getSelectionModel().getSelectedItem();
		this.txtEmail.setText(pacienteSelected.getEmail());
		this.txtID.setText(String.valueOf(pacienteSelected.getId()));
		this.txtNome.setText(pacienteSelected.getNome());
		this.cmbAbordagem.getSelectionModel().select(pacienteSelected.getTipoAbordagem());
	}

	@FXML
	void novo(ActionEvent event) {
		clear(grdConteudo);
	}

	@FXML
	void salvar(ActionEvent event) {
		Paciente p = new Paciente(Long.valueOf(txtID.getText()), txtNome.getText(), txtEmail.getText(),
				cmbAbordagem.getSelectionModel().getSelectedItem());
		RadioButton selectedRadioButton = returnSelectedRadioButton();
		if(selectedRadioButton.getText().equals("M")) {
			p.setSexo(SexoEnum.MASCULINO);
		} else if (selectedRadioButton.getText().equals("F")){
			p.setSexo(SexoEnum.FEMININO);
		} else {
			System.out.println("Deu bug... deveria ter selecionado algo.");
		}
		pacientes.add(p);
		clear(grdConteudo);
		System.out.println(p);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		carregarTipoAbordagem();
		pacientes.add(new Paciente(1L, "João da Silva", "joao@gmail.com", TipoAbordagemEnum.ANALISE_DO_COMPORTAMENTO));
		clnID.setCellValueFactory(c -> c.getValue().idProperty());
		clnNome.setCellValueFactory(c -> c.getValue().nomeProperty());
		clnEmail.setCellValueFactory(c -> c.getValue().emailProperty());
		this.tblPaciente.setItems(pacientes);
	}

	private void clear(Pane pane) {
		ObservableList<Node> nodes = pane.getChildren();
		for (Node node : nodes) {
			if (node instanceof TextField) {
				((TextField) node).setText("");
			}
			if (node instanceof ComboBox) {
				((ComboBox) node).getSelectionModel().clearSelection();
			}
		}
	}

	private void carregarTipoAbordagem() {
		cmbAbordagem.getItems().add(null);
		cmbAbordagem.getItems().addAll((TipoAbordagemEnum.values()));
		// cmbAbordagem.getSelectionModel().clearSelection();
		// cmbAbordagem.setItems(FXCollections.observableArrayList(null,
		// TipoAbordagemEnum.values()));
	}
	
	private RadioButton returnSelectedRadioButton() {
		if(tgrSexo != null) {
			RadioButton r = (RadioButton) this.tgrSexo.getSelectedToggle();
			return r;
		}
		return null;
	}
}
