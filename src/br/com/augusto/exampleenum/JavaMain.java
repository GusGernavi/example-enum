package br.com.augusto.exampleenum;

import java.util.Arrays;
import java.util.List;

import br.com.augusto.exampleenum.model.AvaliacaoEnum;
import br.com.augusto.exampleenum.model.Funcionario;

public class JavaMain {

	private static List<Funcionario> funcionarios = Arrays.asList(
			new Funcionario("Pedro", 2000.0, AvaliacaoEnum.ABAIXO_DA_MEDIA),
			new Funcionario("Rodrigo", 2000.0, AvaliacaoEnum.MUITO_ABAIXO_DA_MEDIA),
			new Funcionario("Rafael", 2000.0, AvaliacaoEnum.ACIMA_DA_MEDIA),
			new Funcionario("Maria", 2000.0, AvaliacaoEnum.NA_MEDIA),
			new Funcionario("Joana", 2000.0, AvaliacaoEnum.MUITO_ACIMA_DA_MEDIA),
			new Funcionario("Nico", 2000.0, AvaliacaoEnum.ACIMA_DA_MEDIA),
			new Funcionario("Daniel", 2000.0, AvaliacaoEnum.NA_MEDIA),
			new Funcionario("Sheila", 2000.0, AvaliacaoEnum.NA_MEDIA));

	public static void main(String[] args) {
		System.out.println("• Jeito muito errado: ");
		funcionarios.forEach(funcionario -> {
			Double plrRecebida = metodoMuitoErrado(funcionario);
			System.out.println("Funcionário " + funcionario.nome() + " recebeu R$ " + plrRecebida + " de PLR");
		});

		System.out.println("\n\n• Jeito que todo mundo faz: ");
		funcionarios.forEach(funcionario -> {
			Double plrRecebida = metodoQueTodoMundoFazMasAindaEstaErrado(funcionario);
			System.out.println("Funcionário " + funcionario.nome() + " recebeu R$ " + plrRecebida + " de PLR");
		});

		System.out.println("\n\n• Jeito que acho mais correto: ");
		funcionarios.forEach(funcionario -> {
			Double plrRecebida = metodoQueAchoMaisCorreto(funcionario);
			System.out.println("Funcionário " + funcionario.nome() + " recebeu R$ " + plrRecebida + " de PLR");
		});
	}

	private static Double metodoMuitoErrado(Funcionario funcionario) {
		switch (funcionario.avaliacao()) {
		case MUITO_ABAIXO_DA_MEDIA: {
			return funcionario.salario() * 0;
		}
		case ABAIXO_DA_MEDIA: {
			return funcionario.salario() * 0.25;
		}
		case NA_MEDIA: {
			return funcionario.salario() * 0.50;
		}
		case ACIMA_DA_MEDIA: {
			return funcionario.salario() * 0.75;
		}
		case MUITO_ACIMA_DA_MEDIA: {
			return funcionario.salario() * 1;
		}
		default:
			throw new IllegalArgumentException("Não foi possível calcular o valor de PLR");
		}
	}

	private static Double metodoQueTodoMundoFazMasAindaEstaErrado(Funcionario funcionario) {

		if (funcionario.avaliacao().equals(AvaliacaoEnum.MUITO_ABAIXO_DA_MEDIA)) {
			return funcionario.salario() * 0;
		}
		if (funcionario.avaliacao().equals(AvaliacaoEnum.ABAIXO_DA_MEDIA)) {
			return funcionario.salario() * 0.25;
		}
		if (funcionario.avaliacao().equals(AvaliacaoEnum.NA_MEDIA)) {
			return funcionario.salario() * 0.50;
		}
		if (funcionario.avaliacao().equals(AvaliacaoEnum.ACIMA_DA_MEDIA)) {
			return funcionario.salario() * 0.75;
		}
		if (funcionario.avaliacao().equals(AvaliacaoEnum.MUITO_ACIMA_DA_MEDIA)) {
			return funcionario.salario() * 1;
		}
		return null;
	}

	private static Double metodoQueAchoMaisCorreto(Funcionario funcionario) {
		return funcionario.avaliacao().calculaParticipacaoDeLucros(funcionario.salario());
	}

}
