package desafio.conta;

import desafio.banco.Banco;
import desafio.cliente.Cliente;
import lombok.Builder;

public class ContaPoupanca extends Conta {
	
	private static Integer SEQUENCIAL = 1;
	
	@Builder
	public ContaPoupanca(Integer agencia, Cliente cliente, Banco banco) {
		super(agencia, cliente, banco);
		this.numero = SEQUENCIAL++;
	}
	
	@Override
	public void imprimirExtrato() {
		System.out.println("/----- Extrato da Conta Poupança -----/");
		super.imprimirExtrato();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("Conta [ Banco: %s, Agência: %d, Tipo: Poupança, Número: %d]", banco.getNome(), agencia, numero);
	}
}
