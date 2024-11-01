public class Data {

    private int dia;
    private int mes;
    private int ano;


    public Data(int dia, int mes, int ano) {
        // Verifica se a data informada é válida
        if (isDataValida(dia, mes, ano)) {
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        } else {

            System.out.println("Data inválida. Atribuindo data padrão: 1/1/2000.");
            this.dia = 1;
            this.mes = 1;
            this.ano = 2000;
        }
    }

    private boolean isDataValida(int dia, int mes, int ano) {

        if (ano <= 0){
            return false;
        }

        if (mes < 1 || mes > 12) {
            return false; // Mês inválido
        }

        // Variável para armazenar o número de dias no mês
        int diasNoMes;
        switch (mes) {
            // Meses com 31 dias
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                diasNoMes = 31; // Meses com 31 dias
                break;
            // Meses com 30 dias
            case 4: case 6: case 9: case 11:
                diasNoMes = 30; // Meses com 30 dias
                break;
            // Verifica se o mês é fevereiro
            case 2:
                // Calcula o número de dias em fevereiro considerando anos bissextos
                diasNoMes = (ano % 4 == 0 && (ano % 100 != 0 || ano % 400 == 0)) ? 29 : 28; // Fevereiro
                break;
            default:
                return false; // Mês inválido (caso não caia em nenhum dos casos anteriores)
        }

        // Verifica se o dia está dentro do intervalo válido para o mês
        return dia >= 1 && dia <= diasNoMes; // Retorna true se o dia for válido
    }

    public boolean verificaAnoBissexto() {
        // Um ano é bissexto se for divisível por 400 ou se for divisível por 4, mas não por 100
        return (ano % 400 == 0) || ((ano % 4 == 0) && (ano % 100 != 0));
    }

    public boolean isBefore(Data outraData) {
        // Compara ano, mês e dia para determinar se esta data é anterior à outra
        if (ano < outraData.ano) {
            return true;
        } else if (ano == outraData.ano && mes < outraData.mes) {
            return true;
        } else if (ano == outraData.ano && mes == outraData.mes && dia < outraData.dia) {
            return true;
        }
        return false;

    }

    // Métodos Getters
    public int getDia() {
        return dia; // Retorna o dia
    }

    public void setDia(int dia) {
        this.dia = dia; // Define um novo valor para o dia
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano; // Define um novo valor para o ano
    }

    // toString para exibir a data no formato "dia/mês/ano"
    @Override
    public String toString() {
        return dia + "/" + mes + "/" + ano; // Retorna a data em formato legível
    }
}