package br.com.unialfa.tableview.model.enumerator;

public enum TipoAbordagemEnum {
	ANALISE_DO_COMPORTAMENTO(1L, "Análise do comportamento"), 
	AVALIACAO_NEUROPSICOLOGICA(2L,"Avaliação do neuropsicologica"),
	COMPORTAMENTAL(3L,"Avaliação comportamental"), 
	CONGNICAO_COMPORTAMENTAL(4L, "Cognição comportamental"), 
	GESTALT(5L,	"Gestalt"), 
	PSICANALISE(6L, "Psicanalise"), 
	PSICODIAGNOSTICO(7L, "Psicodiagnóstico");

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
