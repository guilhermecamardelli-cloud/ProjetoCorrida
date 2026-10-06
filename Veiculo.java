import java.util.Random; //para importar o modo aleatorio

public abstract class Veiculo {

    protected String nome;
    protected int posicao = 0;
    protected Random random = new Random(); // cria um sortedor de numero para a posição do veículo

    public Veiculo(String nome) {
        this.nome = nome;
    }

    // Cada veículo vai andar de um jeito
    public abstract void mover();

    public String getNome() {
        return nome;
    }

    public int getPosicao() {
        return posicao;
    }
}

