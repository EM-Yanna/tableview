package br.com.unialfa.tableview.model.enumerator;

public enum SexoEnum {

	MASCULINO(1L, "MASCULINO", "M"), FEMININO(2L, "FEMININO", "F");

	private Long id;
	private String descricao;
	private String sigla;

	private SexoEnum(Long id, String descricao, String sigla) {
		this.id = id;
		this.descricao = descricao;
		this.sigla = sigla;
	}

	public Long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getSigla() {
		return sigla;
	}
	
	@Override
	public String toString() {
		return this.descricao;
	}

}
