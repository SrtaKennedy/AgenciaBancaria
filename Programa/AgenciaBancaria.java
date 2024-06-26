import java.util.ArrayList;
import java.util.Scanner;

public class AgenciaBancaria {
    static Scanner buscador = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias;
    public static void main(String[] args) {
        contasBancarias = new ArrayList<Conta>();
        operacoes();
    }

    public static void operacoes() {
        System.out.println("-------------------------------------------------------");
        System.out.println("--------------Bem vindos a nossa Agência---------------");
        System.out.println("-------------------------------------------------------");
        System.out.println("***** Selecione uma operação que deseja realizar: *****");
        System.out.println("-------------------------------------------------------");
        System.out.println("|   Opção 1 - Criar conta    |");
        System.out.println("|   Opção 2 - Depositar      |");
        System.out.println("|   Opção 3 - Sacar          |");
        System.out.println("|   Opção 4 - Transferir     |");
        System.out.println("|   Opção 5 - Listar         |");
        System.out.println("|   Opção 6 - Sair           |");

        int operacao = buscador.nextInt();

        switch (operacao) {
            case 1:
                criarConta();
                break;

            case 2:
                depositar();
                break;

            case 3:
                sacar();
                break;

            case 4:
                transferir();
                break;

            case 5:
                listarContas();
                break;

            case 6:
                System.out.println("Obrigado(a) por usar nossa agência!");
                System.exit(0);
            default:
                System.out.println("Opção inválida.");
                operacoes();
                break;
        }
    }

    public static void criarConta() {
        System.out.println("\nNome: ");
        String nome = buscador.nextLine();

        System.out.println("\nCPF: ");
        String cpf = buscador.nextLine();

        System.out.println("\nEmail: ");
        String email = buscador.nextLine();

        Pessoa cliente = new Pessoa(nome, cpf, email);

        Conta conta = new Conta(cliente);
        contasBancarias.add(conta);
        System.out.println("Sua conta foi criada com sucesso!");

        operacoes();
    }

    private static Conta encontrarConta(int numeroDaConta) {
        Conta conta = null;
        if (contasBancarias.size() > 0) {
            for(Conta c: contasBancarias) {
                if (c.getNumeroDaConta() == numeroDaConta) {
                    conta = c;
                }
            }
        }
        return conta;
    }

    public static void depositar() {
        System.out.println("N° da conta: ");
        int numeroDaConta = buscador.nextInt();

        Conta conta = encontrarConta(numeroDaConta);
        if (conta != null) {
            System.out.println("Qual valor deseja depositar? ");
            Double valorDoDeposito = buscador.nextDouble();
            conta.depositar(valorDoDeposito);
            System.out.println("O valor foi depositado com sucesso!");
        } else {
            System.out.println("A conta não foi encontrada.");
        }
        operacoes();

    }

    public static void sacar() {
        System.out.println("N° da conta: ");
        int numeroDaConta = buscador.nextInt();

        Conta conta = encontrarConta(numeroDaConta);

        if (conta != null) {
            System.out.println("Qual valor deseja sacar? ");
            Double valorDoSaque = buscador.nextDouble();
            conta.sacar(valorDoSaque);
        } else {
            System.out.println("A conta não foi encontrada.");
        }
        operacoes();
    }
    
    public static void transferir() {
            System.out.println("N° da conta do remetente: ");
            int numeroDaContaDoRemetente = buscador.nextInt();

            Conta contaDoRemente = encontrarConta(numeroDaContaDoRemetente);

            if (contaDoRemente != null) {
                System.out.println("N° da conta do destinatário: ");
                int numeroDaContaDoDestinatario = buscador.nextInt();

                Conta contaDoDestinatario = encontrarConta(numeroDaContaDoDestinatario);

                if (contaDoDestinatario != null) {
                    System.out.println("Valor da transferência: ");
                    Double valor = buscador.nextDouble();
                    
                    contaDoRemente.transferir(contaDoDestinatario, valor);
                }
            }
            operacoes();
        }

        public static void listarContas() {
            if (contasBancarias.size() > 0) {
                for(Conta conta: contasBancarias) {
                    System.out.println(conta);
                }
            } else {
                System.out.println("Não há contas cadastradas.");
            }
            operacoes();
        }
    }

