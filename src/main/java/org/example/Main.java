package org.example;


import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        String nome = null;


        while (continuar) {
            if (nome == null) {
                System.out.println("Digite o nome completo: ");
                nome = scanner.nextLine();
            }


            System.out.println("Escolha um saldo (0 a 10000): ");
            double saldo = scanner.nextDouble();


            System.out.println("Escolha o tipo de conta: ");
            System.out.println("1. Conta Corrente");
            System.out.println("2. Conta Poupança");
            System.out.println("3. Conta Investimento");
            System.out.println("4. Conta Salário");
            System.out.println("5. Conta Investimento Alto Risco");
            int tipoConta = scanner.nextInt();


            ContaBancaria conta = null;


            try {
                switch (tipoConta) {
                    case 1:
                        conta = new ContaCorrente("123", nome, saldo, 500);
                        break;
                    case 2:
                        conta = new ContaPoupanca("456", nome, saldo);
                        break;
                    case 3:
                        conta = new ContaInvestimento("789", nome, saldo);
                        break;
                    case 4:
                        conta = new ContaSalario("101", nome, saldo, 300);
                        break;
                    case 5:
                        conta = new ContaInvestimentoAltoRisco("202", nome, saldo);
                        break;
                    default:
                        System.out.println("Tipo de conta inválido.");
                        return;
                }
                conta.exibirInformacoes();


                boolean depositoValido = false;
                while (!depositoValido) {
                    System.out.println("Digite o valor para depósito: ");
                    double valorDeposito = scanner.nextDouble();
                    if (valorDeposito > saldo) {
                        System.out.println("Valor de depósito maior que o saldo atual.");
                        System.out.println("Deseja alterar o saldo? (s/n)");
                        String resposta = scanner.next();
                        if (resposta.equalsIgnoreCase("s")) {
                            System.out.println("Escolha um novo saldo (0 a 10000): ");
                            saldo = scanner.nextDouble();
                            conta.saldo = saldo;
                        } else {
                            System.out.println("Digite um novo valor para depósito.");
                        }
                    } else {
                        conta.depositar(valorDeposito);
                        depositoValido = true;
                    }
                }
                conta.exibirInformacoes();


                System.out.println("Digite o valor para saque: ");
                double valorSaque = scanner.nextDouble();
                conta.sacar(valorSaque);
                conta.exibirInformacoes();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }


            scanner.nextLine();
            System.out.println("Gostaria de realizar novamente? Aperte Enter.");
            String resposta = scanner.nextLine();
            if (!resposta.isEmpty()) {
                continuar = false;
            }
        }


        scanner.close();
    }
}
