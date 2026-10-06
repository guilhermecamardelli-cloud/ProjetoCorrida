import java.util.Random;
import java.util.Scanner;

public class ProjetoCorrida {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String novaCorrida;

        do {
            System.out.println("\n=== CORRIDA DE VEICULOS ===");

            // MENU 1 - escolha do veiculo
            System.out.println("\n1 - Escolha o veiculo:");
            System.out.println("1 - Carro");
            System.out.println("2 - Moto");
            System.out.println("3 - Caminhao");
            System.out.println("4 - Bicicleta");
            System.out.println("5 - Onibus");
            int opcao = 0;
            while (opcao < 1 || opcao > 5) {
                System.out.print("Opcao: ");
                opcao = teclado.nextInt();
            }

            // Objetos criados como o tipo base (polimorfismo)
            Veiculo[] veiculos = new Veiculo[3];

            switch (opcao) {
                case 1:
                    veiculos[0] = new Carro("Carro 1");
                    veiculos[1] = new Carro("Carro 2");
                    veiculos[2] = new Carro("Carro 3");
                    break;
                case 2:
                    veiculos[0] = new Moto("Moto 1");
                    veiculos[1] = new Moto("Moto 2");
                    veiculos[2] = new Moto("Moto 3");
                    break;
                case 3:
                    veiculos[0] = new Caminhao("Caminhao 1");
                    veiculos[1] = new Caminhao("Caminhao 2");
                    veiculos[2] = new Caminhao("Caminhao 3");
                    break;
                case 4:
                    veiculos[0] = new Bicicleta("Bicicleta 1");
                    veiculos[1] = new Bicicleta("Bicicleta 2");
                    veiculos[2] = new Bicicleta("Bicicleta 3");
                    break;
                case 5:
                    veiculos[0] = new Onibus("Onibus 1");
                    veiculos[1] = new Onibus("Onibus 2");
                    veiculos[2] = new Onibus("Onibus 3");
                    break;
            }

            // Confirmando com instanceof
            for (Veiculo v : veiculos) {
                if (v instanceof Veiculo) {
                    System.out.println(v.getNome() + " e do tipo Veiculo!");
                }
            }

            // MENU 2 - aposta no vencedor
            System.out.println("\n2 - Aposte no vencedor:");
            for (int i = 0; i < veiculos.length; i++) {
                System.out.println((i + 1) + " - " + veiculos[i].getNome());
            }
            int aposta = 0;
            while (aposta < 1 || aposta > 3) {
                System.out.print("Sua aposta: ");
                aposta = teclado.nextInt();
            }

            // Corrida de 3 turnos
            System.out.println("\nA corrida vai comecar!\n");
            for (int turno = 1; turno <= 3; turno++) {
                System.out.print("Turno " + turno + ": ");
                for (Veiculo v : veiculos) {
                    v.mover(); // cada veiculo se move do seu jeito
                    System.out.print(v.getNome() + " = " + v.getPosicao() + "m | ");
                }
                System.out.println();
            }

            // Descobrindo o vencedor
            int maior = 0;
            for (Veiculo v : veiculos) {
                if (v.getPosicao() > maior) {
                    maior = v.getPosicao();
                }
            }

            // Sorteia entre os que ficaram na frente (assim nunca ha empate)
            Random sorteio = new Random();
            int indiceVencedor;
            do {
                indiceVencedor = sorteio.nextInt(3);
            } while (veiculos[indiceVencedor].getPosicao() != maior);

            // Resultado
            System.out.println();
            System.out.println("Vencedor: " + veiculos[indiceVencedor].getNome() + "!");
            if (indiceVencedor == aposta - 1) {
                System.out.println("Parabens, voce acertou a aposta!");
            } else {
                System.out.println("Voce apostou no " + veiculos[aposta - 1].getNome() + ". Nao foi dessa vez.");
            }

            // MENU 3 - nova corrida
            System.out.print("\n3 - Deseja uma nova corrida? (s/n): ");
            novaCorrida = teclado.next();

        } while (novaCorrida.equalsIgnoreCase("s"));

        System.out.println("\nFim do jogo!");
        teclado.close();
    }
}
