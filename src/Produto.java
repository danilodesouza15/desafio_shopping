public class Produto {

    private String nome;
    private double preco;
    private Data dataValidade;

    public Produto(String nome, double preco, Data dataValidade) {
        this.nome = nome;
        this.preco = preco;
        this.dataValidade = dataValidade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setDataDeValidade(Data dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public Data getDataValidade() {
        return dataValidade;
    }

    public boolean estaVencido(Data dataAtual) {
        // Verifica se o ano de validade é menor que o ano atual
        if (dataValidade.getAno() < dataAtual.getAno()) {
            return true; //venceu
            // Verifica se o ano de validade é igual ao ano atual
        } else if (dataValidade.getAno() == dataAtual.getAno()) {
            // Verifica se o mês de validade é menor que o mês atual
            if (dataValidade.getMes() < dataAtual.getMes())
                return true; //venceu
            // Verifica se o mês de validade é igual ao mês atual
        } else if (dataValidade.getMes() == dataAtual.getMes()) {
            // Verifica se o dia de validade é menor que o dia atual
            return dataValidade.getDia() < dataAtual.getDia(); //retorna true se estiver vencido
        }
        return false;
    }
    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                ", dataValidade=" + dataValidade +
                '}';
    }
}


