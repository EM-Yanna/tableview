package br.com.unialfa.tableview.model.entity;

import br.com.unialfa.tableview.model.enumerator.SexoEnum;
import br.com.unialfa.tableview.model.enumerator.TipoAbordagemEnum;
import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.css.SimpleStyleableObjectProperty;

/**
 * @author nbtakao
 *
 */
public class Paciente {

	private LongProperty id;
	private StringProperty nome;
	private StringProperty email;
	private ObjectProperty<SexoEnum> sexo;
	private ObjectProperty<TipoAbordagemEnum> tipoAbordagem;

	public Paciente(Long id, String nome, String email, TipoAbordagemEnum tipoAbordagemEnum) {
		this.id = new SimpleLongProperty(id);
		this.nome = new SimpleStringProperty(nome);
		this.email = new SimpleStringProperty(email);
		this.tipoAbordagem = new SimpleObjectProperty<TipoAbordagemEnum>(tipoAbordagemEnum);
		this.sexo = new SimpleObjectProperty<SexoEnum>();
	}

	public final LongProperty idProperty() {
		return this.id;
	}

	public final Long getId() {
		return this.idProperty().get();
	}

	public final void setId(final Long id) {
		this.idProperty().set(id);
	}

	public final StringProperty nomeProperty() {
		return this.nome;
	}

	public final String getNome() {
		return this.nomeProperty().get();
	}

	public final void setNome(final String nome) {
		this.nomeProperty().set(nome);
	}

	public final StringProperty emailProperty() {
		return this.email;
	}

	public final String getEmail() {
		return this.emailProperty().get();
	}

	public final void setEmail(final String email) {
		this.emailProperty().set(email);
	}

	public final ObjectProperty<SexoEnum> sexoProperty() {
		return this.sexo;
	}

	public final SexoEnum getSexo() {
		return this.sexoProperty().get();
	}

	public final void setSexo(final SexoEnum sexo) {
		this.sexoProperty().set(sexo);
	}

	public final ObjectProperty<TipoAbordagemEnum> tipoAbordagemProperty() {
		return this.tipoAbordagem;
	}
	

	public final TipoAbordagemEnum getTipoAbordagem() {
		return this.tipoAbordagemProperty().get();
	}
	

	public final void setTipoAbordagem(final TipoAbordagemEnum tipoAbordagem) {
		this.tipoAbordagemProperty().set(tipoAbordagem);
	}
	
	@Override
	public String toString() {
		return "nome: "+ this.nome.get() + "TipoAbordagem id: " + this.getTipoAbordagem().getId();
	}
	

}
