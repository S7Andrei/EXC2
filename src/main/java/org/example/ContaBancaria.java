package org.example;


public abstract class ContaBancaria {
    String numeroConta;
    String titular;
    double saldo;


    public ContaBancaria(String numeroContaParam, String titularParam, double saldoParam) {
        if (saldoParam < 0 || saldoParam > 10000) {
            throw new IllegalArgumentException("Saldo inválido. Deve ser entre 0 e 10000.");
        }
        numeroConta = numeroContaParam;
        titular = titularParam;
        saldo = saldoParam;
    }


    public void depositar(double valor) {
        if (valor > saldo) {
            System.out.println("Valor de depósito maior que o saldo atual.");
        } else {
            saldo += valor;
        }
    }


    public abstract void sacar(double valor);


    public void exibirInformacoes() {
        System.out.println("Conta: " + numeroConta + ", Titular: " + titular + ", Saldo: " + saldo);
    }
}
