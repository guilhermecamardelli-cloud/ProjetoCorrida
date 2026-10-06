public class Onibus extends Veiculo {

    public Onibus(String nome) {
        super(nome);
    }

    @Override
    public void mover() {
        posicao += 5 + random.nextInt(4); // anda de 5 a 8
    }
}

