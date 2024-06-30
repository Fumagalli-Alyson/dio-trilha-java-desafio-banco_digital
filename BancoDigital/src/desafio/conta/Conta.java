package desafio.conta;

import desafio.banco.Banco;
import desafio.cliente.Cliente;
import desafio.exception.SaldoInsuficienteException;
import lombok.Getter;

@Getter
public abstract class Conta {
	
	protected Integer agencia;
	protected Integer numero;
	protected Double saldo = 0.0;
	protected Cliente cliente;
	protected Banco banco;
	
	public Conta(Integer agencia, Cliente cliente, Banco banco) {
		this.agencia = agencia;
		this.cliente = cliente;
		this.banco = banco;
		if (this instanceof ContaCorrente)
			banco.getContasCorrente().add(this);
		else
			banco.getContasPoupanca().add(this);
	}
	
	public void sacar(Double saque) {
		try {
			validarSaque(saque);
		} catch (SaldoInsuficienteException e) {
			System.err.println("Saldo insuficiente.\n");
		}
	}
	
	public void depositar(Double saque) {
		saldo += saque;
	}
	
	public void transferir(Double transferencia, Conta destino) {
		sacar(transferencia);
		destino.depositar(transferencia);
	}
	
	private void validarSaque(Double saque) throws SaldoInsuficienteException {
		if (saque.compareTo(this.saldo) > 0)
			throw new SaldoInsuficienteException();
		saldo -= saque;
	}
	
	public void imprimirExtrato() {
		System.out.println(String.format("Titular: %s", cliente.getNome()));
		System.out.println(String.format("Banco: %s", this.banco.getNome()));
		System.out.println(String.format("Agência: %d", this.agencia));
		System.out.println(String.format("Número: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f\n", this.saldo));
	}
}