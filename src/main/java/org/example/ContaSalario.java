package org.example;

public class ContaSalario extends ContaCorrente {
    int saquesGratuitos = 1;

    public ContaSalario(String numeroConta, String titular, double saldo, double limiteChequeEspecial) {
        super(numeroConta, titular, saldo, limiteChequeEspecial);
    }

    @Override
    public void sacar(double valor) {
        if (saquesGratuitos > 0) {
            saquesGratuitos--;
            super.sacar(valor);
        } else {
            if (saldo + limiteChequeEspecial >= valor + 5) {
                saldo -= (valor + 5);
            } else {
                System.out.println("Saldo insuficiente.");
            }
        }
    }
}
