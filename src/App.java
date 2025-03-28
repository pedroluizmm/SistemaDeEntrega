import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    static List<Cliente> clientes = new ArrayList<>();
    static List<Entregador> entregadores = new ArrayList<>();
    static List<Estabelecimento> estabelecimentos = new ArrayList<>();
    static ControladorDePedidos controlador = new ControladorDePedidos();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean executando = true;

        while (executando) {
            if (clientes.isEmpty() && entregadores.isEmpty() && estabelecimentos.isEmpty()) {
                System.out.println("===== SistemaDePedido =====");
                System.out.println("[1] Cadastrar");
                System.out.println("[2] Sair");
                String opcao = scanner.nextLine();

                switch (opcao) {
                    case "1":
                        cadastrar();
                        break;
                    case "2":
                        executando = false;
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            } else {
                System.out.println("===== Menu Principal =====");
                System.out.println("[1] Cadastrar");
                System.out.println("[2] Listar por Cliente");
                System.out.println("[3] Listar por Estabelecimento");
                System.out.println("[4] Listar por Entregador");
                System.out.println("[5] Sair");
                String opcao = scanner.nextLine();

                switch (opcao) {
                    case "1":
                        cadastrar();
                        break;
                    case "2":
                        listarClientes();
                        break;
                    case "3":
                        listarEstabelecimentos();
                        break;
                    case "4":
                        listarEntregadores();
                        break;
                    case "5":
                        executando = false;
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            }
        }

        scanner.close();
    }

    static void cadastrar() {
        System.out.println("===== Cadastro =====");
        System.out.println("[1] Cadastrar Cliente");
        System.out.println("[2] Cadastrar Entregador");
        System.out.println("[3] Cadastrar Estabelecimento");
        System.out.println("[4] Voltar");
        System.out.println("[5] Sair");
        String opcao = scanner.nextLine();

        switch (opcao) {
            case "1":
                System.out.println("Nome:");
                String nome = scanner.nextLine();
                System.out.println("Telefone:");
                String telefone = scanner.nextLine();
                System.out.println("Email:");
                String email = scanner.nextLine();
                System.out.println("Endereço:");
                String endereco = scanner.nextLine();
                System.out.println("Idade:");
                int idade = Integer.parseInt(scanner.nextLine());
                System.out.println("CPF:");
                String cpf = scanner.nextLine();
                System.out.println("Forma de pagamento [1] Pix [2] Cartão:");
                String forma = scanner.nextLine();

                MetodoPagamento metodo = null;
                if (forma.equals("1")) {
                    System.out.println("Chave Pix:");
                    String chavePix = scanner.nextLine();
                    System.out.println("Titular:");
                    String titular = scanner.nextLine();
                    metodo = new PagamentoPix(chavePix, titular);
                } else {
                    System.out.println("Número do Cartão:");
                    String numero = scanner.nextLine();
                    System.out.println("Validade:");
                    String validade = scanner.nextLine();
                    System.out.println("CVV:");
                    int cvv = Integer.parseInt(scanner.nextLine());
                    metodo = new PagamentoCartao(numero, validade, cvv);
                }

                Cliente cliente = new Cliente(nome, telefone, email, endereco, idade, cpf, metodo);
                clientes.add(cliente);
                System.out.println("Cliente cadastrado com sucesso!");
                break;
            case "2":
                System.out.println("Nome:");
                String enome = scanner.nextLine();
                System.out.println("Telefone:");
                String etelefone = scanner.nextLine();
                System.out.println("Email:");
                String eemail = scanner.nextLine();
                System.out.println("Endereço:");
                String eendereco = scanner.nextLine();
                System.out.println("Idade:");
                int eidade = Integer.parseInt(scanner.nextLine());
                System.out.println("CPF:");
                String ecpf = scanner.nextLine();
                System.out.println("Veículo:");
                String veiculo = scanner.nextLine();
                System.out.println("RG:");
                String rg = scanner.nextLine();
                System.out.println("CNH:");
                String cnh = scanner.nextLine();
                System.out.println("Seguro do veículo [true/false]:");
                boolean seguro = Boolean.parseBoolean(scanner.nextLine());
                System.out.println("Conta Bancária:");
                String conta = scanner.nextLine();

                Entregador entregador = new Entregador(enome, etelefone, eemail, eendereco, eidade, ecpf, veiculo, rg,
                        cnh, seguro, conta);
                entregadores.add(entregador);
                System.out.println("Entregador cadastrado com sucesso!");
                break;
            case "3":
                System.out.println("Nome:");
                String estNome = scanner.nextLine();
                System.out.println("CNPJ:");
                String cnpj = scanner.nextLine();
                System.out.println("Categoria:");
                String categoria = scanner.nextLine();

                Estabelecimento est = new Estabelecimento(estNome, cnpj, categoria);
                estabelecimentos.add(est);
                System.out.println("Estabelecimento cadastrado com sucesso!");
                break;
            case "4":
                return;
            case "5":
                System.exit(0);
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    static void listarClientes() {
        boolean submenu = true;
        while (submenu) {
            System.out.println("===== Clientes Cadastrados =====");
            for (int i = 0; i < clientes.size(); i++) {
                Cliente c = clientes.get(i);
                System.out.println("[" + (i + 1) + "] " + c.getNome() + " (CPF: " + c.getCpf() + ")");
            }
            System.out.println("[" + (clientes.size() + 1) + "] Voltar");
            System.out.println("[" + (clientes.size() + 2) + "] Sair");

            int escolha = Integer.parseInt(scanner.nextLine());

            if (escolha >= 1 && escolha <= clientes.size()) {
                Cliente clienteSelecionado = clientes.get(escolha - 1);
                menuCliente(clienteSelecionado);
            } else if (escolha == clientes.size() + 1) {
                submenu = false;
            } else if (escolha == clientes.size() + 2) {
                System.exit(0);
            } else {
                System.out.println("Opção inválida.");
            }
        }
    }

    static void menuCliente(Cliente cliente) {
        boolean ativo = true;

        while (ativo) {
            System.out.println("===== Cliente: " + cliente.getNome() + " =====");
            System.out.println("[1] Fazer Pedido");
            System.out.println("[2] Listar Pedidos");
            System.out.println("[3] Atualizar/Deletar Usuário");
            System.out.println("[4] Voltar");
            System.out.println("[5] Sair");

            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    System.out.println("🚧 Fazer pedido ainda será implementado...");
                    break;
                case "2":
                    List<Pedido> pedidos = cliente.getPedidos();
                    if (pedidos.isEmpty()) {
                        System.out.println("Nenhum pedido encontrado.");
                    } else {
                        for (int i = 0; i < pedidos.size(); i++) {
                            Pedido p = pedidos.get(i);
                            System.out.println(
                                    "[" + (i + 1) + "] Pedido ID: " + p.getId() + ", Total: R$" + p.getValorTotal());
                        }
                    }
                    break;
                case "3":
                    System.out.println("🚧 Atualizar/Deletar ainda será implementado...");
                    break;
                case "4":
                    ativo = false;
                    break;
                case "5":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    static void listarEstabelecimentos() {
        System.out.println("===== Estabelecimentos Cadastrados =====");
        for (int i = 0; i < estabelecimentos.size(); i++) {
            Estabelecimento e = estabelecimentos.get(i);
            System.out.println("[" + (i + 1) + "] " + e.getNome() + " (CNPJ: " + e.getCnpj() + ")");
        }
        System.out.println("[" + (estabelecimentos.size() + 1) + "] Voltar");
        System.out.println("[" + (estabelecimentos.size() + 2) + "] Sair");
    }

    static void listarEntregadores() {
        System.out.println("===== Entregadores Cadastrados =====");
        for (int i = 0; i < entregadores.size(); i++) {
            Entregador e = entregadores.get(i);
            System.out.println("[" + (i + 1) + "] " + e.getNome() + " (RG: " + e.getRg() + ")");
        }
        System.out.println("[" + (entregadores.size() + 1) + "] Voltar");
        System.out.println("[" + (entregadores.size() + 2) + "] Sair");
    }
}
