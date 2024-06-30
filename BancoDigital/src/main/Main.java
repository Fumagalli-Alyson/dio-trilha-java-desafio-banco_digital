package main;

import desafio.banco.Banco;
import desafio.cliente.Cliente;
import desafio.conta.Conta;
import desafio.conta.ContaCorrente;
import desafio.conta.ContaPoupanca;

public class Main {

	public static void main(String[] args) {
		
		Banco banco = Banco.builder().nome("Banco Legal").build();
		
		Cliente cliente1 = Cliente.builder().nome("Cliente 1").build();
		
		Conta contaCorrenteCliente1 = ContaCorrente.builder().agencia(1234).cliente(cliente1).banco(banco).build();
		Conta contaPoupancaCliente1 = ContaPoupanca.builder().banco(banco).agencia(1234).cliente(cliente1).build();
		
		contaCorrenteCliente1.depositar(15000.0);
		contaCorrenteCliente1.transferir(3000.0, contaPoupancaCliente1);
		contaCorrenteCliente1.sacar(1000.0);
		
		contaCorrenteCliente1.imprimirExtrato();
		contaPoupancaCliente1.imprimirExtrato();
		
		Cliente cliente2 = Cliente.builder().nome("Cliente 2").build();

		Conta contaCorrenteCliente2 = ContaCorrente.builder().agencia(1234).cliente(cliente2).banco(banco).build();
		
		contaCorrenteCliente2.depositar(5000.0);
		contaCorrenteCliente2.sacar(6000.0);
		
		contaCorrenteCliente2.imprimirExtrato();
		
		banco.getContasCorrente().forEach(System.out::println);
		System.out.println();
		banco.getContasPoupanca().forEach(System.out::println);
	}
}