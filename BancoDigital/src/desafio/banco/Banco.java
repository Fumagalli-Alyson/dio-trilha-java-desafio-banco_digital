package desafio.banco;

import java.util.ArrayList;
import java.util.List;

import desafio.conta.Conta;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Banco {
	private String nome;
	private final List<Conta> contasCorrente = new ArrayList<>();
	private final List<Conta> contasPoupanca = new ArrayList<>();
	
	@Builder
	public Banco(String nome) {
		this.nome = nome;
	}

}
