package br.com.augusto.exampleenum.model;

public enum AvaliacaoEnum {
	MUITO_ABAIXO_DA_MEDIA(0.0) {
		@Override
		public Double calculaParticipacaoDeLucros(Double salario) {
			return salario * this.fator;
		}
	},
	ABAIXO_DA_MEDIA(0.25) {
		@Override
		public Double calculaParticipacaoDeLucros(Double salario) {
			return salario * this.fator;
		}
	},
	NA_MEDIA(0.5) {
		@Override
		public Double calculaParticipacaoDeLucros(Double salario) {
			return salario * this.fator;
		}
	},
	ACIMA_DA_MEDIA(0.75) {
		@Override
		public Double calculaParticipacaoDeLucros(Double salario) {
			return salario * this.fator;
		}
	},
	MUITO_ACIMA_DA_MEDIA(1.0) {
		@Override
		public Double calculaParticipacaoDeLucros(Double salario) {
			return salario * this.fator;
		}
	};
	
	Double fator;

	AvaliacaoEnum(Double fator) {
		this.fator = fator;
	}

	
	public abstract Double calculaParticipacaoDeLucros(Double salario);
}
