package org.example;

public class ContaCorrente extends ContaBancaria {
    double limiteChequeEspecial;

    public ContaCorrente(String numeroConta, String titular, double saldo, double limiteChequeEspecialParam) {
        super(numeroConta, titular, saldo);
        limiteChequeEspecial = limiteChequeEspecialParam;
    }

    @Override
    public void sacar(double valor) {
        if (saldo + limiteChequeEspecial >= valor) {
            saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }
}
