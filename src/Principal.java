import java.util.Scanner; //Decidi desenvolver o projeto com o scanner, pois estava tendo problemas com a classe Teclado//
import java.util.Locale;

public class Principal {

    public static void main(String[] args) {
        Locale brasil = new Locale("pt", "BR");
        Scanner sc = new Scanner(System.in);
        Loja loja = null; // A loja inicia como null
        Produto produto = null; // O produto inicia como null
        int opcao;

        do {
            System.out.println("Seja bem-vindo(a)!");
            System.out.println();
            System.out.println("(1) Criar Loja");
            System.out.println("(2) Criar produto");
            System.out.println("(3) Sair");
            System.out.println();
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); //Utilizei o sc.nextLine() para remover a quebra de linha e deixar o buffer pronto para a próxima entrada de dados//

            switch(opcao) {
                case 1:
                    // Onde o usuário insere as informações para criar a loja//
                    System.out.println("Inicializando a criação da loja!");
                    System.out.print("Digite o nome da Loja: ");
                    String nomeLoja = sc.nextLine();

                    System.out.print("Digite a quantidade de funcionarios: ");
                    int quantidadeFuncionarios = sc.nextInt();

                    System.out.print("Digite o salario base dos funcionários: ");
                    double salarioBaseFuncionario = sc.nextDouble();
                    sc.nextLine();

                    // Cria DATA FUNDAÇÃO
                    System.out.println("Digite a data de fundação da loja:");
                    System.out.print("Dia: ");
                    int diaFundacao = sc.nextInt();
                    System.out.print("Mês: ");
                    int mesFundacao = sc.nextInt();
                    System.out.print("Ano: ");
                    int anoFundacao = sc.nextInt();
                    sc.nextLine(); // Consumir a quebra de linha

                    // Instancia a data de fundação da loja com construtor
                    Data dataFundacao = new Data(diaFundacao, mesFundacao, anoFundacao);

                    // Cria endereço
                    System.out.print("Digite o nome da rua: ");
                    String nomeDaRua = sc.nextLine();
                    System.out.print("Digite o número: ");
                    String numero = sc.nextLine();
                    System.out.print("Digite o complemento (Teclar 'Enter' e pular para a próxima etapa): ");
                    String complemento = sc.nextLine();
                    if (complemento.isEmpty()){
                        complemento = "Sem complemento";
                        System.out.println("Considerando 'sem complemento'.");
                    }
                    System.out.print("Digite o nome da cidade: ");
                    String cidade = sc.nextLine();
                    System.out.print("Digite o nome do estado: ");
                    String estado = sc.nextLine();
                    System.out.print("Digite o nome do país: ");
                    String pais = sc.nextLine();
                    System.out.print("Digite o CEP: ");
                    String cep = sc.nextLine();

                    // Instancia o endereço da loja com construtor
                    Endereco endereco = new Endereco(nomeDaRua, cidade, estado, pais, cep, numero, complemento);

                    // Instancia loja utilizando o construtor
                    loja = new Loja(nomeLoja, quantidadeFuncionarios, salarioBaseFuncionario, endereco, dataFundacao);

                    System.out.println("\nLoja criada com sucesso!");
                    // Exibe as informações da loja
                    System.out.println("\nInformações da Loja:");
                    System.out.println("Nome: " + loja.getNome());
                    System.out.println("Quantidade de Funcionários: " + loja.getQuantidadeFuncionarios());
                    System.out.println("Salário Base dos Funcionários: " + loja.getSalarioBaseFuncionario());
                    System.out.println("Endereço: " + loja.getEndereco().getNomeDaRua() + ", " + loja.getEndereco().getNumero() + ", "
                            + loja.getEndereco().getComplemento() + ", " + loja.getEndereco().getCidade() + ", " + loja.getEndereco().getEstado()
                            + ", " + loja.getEndereco().getPais() + ", " + loja.getEndereco().getCep());
                    System.out.println("Data de Fundação: " + loja.getDataFundacao().toString());
                    System.out.println("Gastos com salário: " + loja.gastosComSalario());
                    System.out.println("Tamanho da loja: " + loja.tamanhoDaLoja());

                    break;

                case 2:

				// if verifica se a loja existe antes que seja cadastrado um produto.
				if (loja == null) {
					System.out.println("Erro. Para cadastrar um produto é necessário que você crie uma loja primeiro.");
					break;}
                    // Criação do Produto
                    System.out.println("Criando produto...");
                    System.out.print("Digite o nome do produto: ");
                    String nomeProduto = sc.nextLine();

                    System.out.print("Digite o preço do produto: ");
                    double precoProduto = sc.nextDouble();
                    sc.nextLine();


                    //
                    System.out.println("Digite a data de validade do produto:");
                    System.out.print("Dia: ");
                    int diaValidade = sc.nextInt();
                    System.out.print("Mês: ");
                    int mesValidade = sc.nextInt();
                    System.out.print("Ano: ");
                    int anoValidade = sc.nextInt();
                    sc.nextLine(); // Consumir a quebra de linha

                    Data dataValidade = new Data(diaValidade, mesValidade, anoValidade);

                    // INSTANCIA o produto
                    produto = new Produto(nomeProduto, precoProduto, dataValidade);

                    System.out.println("Produto criado com sucesso!");

                    // Exibir as informações do produto
                    System.out.println("\nInformações do Produto:");
                    System.out.println("Nome: " + produto.getNome());
                    System.out.println("Preço: " + produto.getPreco());
                    System.out.println("Data de Validade: " + produto.getDataValidade().toString());
                    break;

                case 3:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }

            if (opcao == 2 && produto != null) {
                // Verificação da validade do produto
                Data dataAtual = new Data(20, 10, 2023);
                if (produto.estaVencido(dataAtual)) {
                    System.out.println("PRODUTO VENCIDO");
                } else {
                    System.out.println("PRODUTO NÃO VENCIDO");
                }
            }
        } while (opcao != 3); // Enquanto a opção escolhida for diferente de 3, o menu será novamente exibido na tela.

        sc.close();
    }
}