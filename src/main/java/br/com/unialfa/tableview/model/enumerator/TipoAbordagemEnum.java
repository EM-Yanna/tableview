package br.com.unialfa.tableview.model.enumerator;

public enum TipoAbordagemEnum {
	ANALISE_DO_COMPORTAMENTO(1L, "An�lise do comportamento"), 
	AVALIACAO_NEUROPSICOLOGICA(2L,"Avalia��o do neuropsicologica"),
	COMPORTAMENTAL(3L,"Avalia��o comportamental"), 
	CONGNICAO_COMPORTAMENTAL(4L, "Cogni��o comportamental"), 
	GESTALT(5L,	"Gestalt"), 
	PSICANALISE(6L, "Psicanalise"), 
	PSICODIAGNOSTICO(7L, "Psicodiagn�stico");

	private Long id;
	private String descricao;

	private TipoAbordagemEnum(Long id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return this.descricao;
	}

	public Long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

}
