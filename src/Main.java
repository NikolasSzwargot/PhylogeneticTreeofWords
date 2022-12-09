import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        if (args.length > 2){
            Upcm tree = new Upcm(String.join(" ", args));
        }
        else if(args.length == 2){
            int numOfWords, size;
            numOfWords = Integer.parseInt(args[0]);
            size = Integer.parseInt(args[1]);

            Upcm tree = new Upcm(numOfWords, size);
        }
        else {
            Scanner input = new Scanner(System.in);
            int choice;
            System.out.println("----WYBIERZ OPCJE DANYCH WEJSCIOWYCH----");
            System.out.println("1. Generuj losowe slowa");
            System.out.println("2. Podaj gotowe slowa");
            System.out.println("3. Podaj gotowe slowa i macierz podobienstwa");
            System.out.println("4. Wyjdz z programu\n");
            System.out.print("Wybierz numer opcji: ");

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Podaj ile slow losowych chcesz wygenerowac: ");
                    int numOfWords = input.nextInt();
                    System.out.print("Podaj maksymalna dlugosc slowa wygenerowanego: ");
                    int leng = input.nextInt();
                    Upcm tree = new Upcm(numOfWords, leng);
                }
                case 2 -> {
                    System.out.println("Podaj slowa oddzielone spacja: ");
                    String data = input.nextLine();
                    Upcm custom_tree = new Upcm(data);
                }
                case 3 -> {
                    System.out.println("Podaj slowa oddzielone spacja: ");
                    String data = input.nextLine();
                    String[] temp;
                    float[][] sim = new float[data.split(" ").length][data.split("").length];
                    for (int i = 0; i < sim.length; i++) {
                        sim[i][i] = 0;
                        if (i != sim.length - 1) {
                            System.out.println("Podaj po spacji wartosci sasiedztwa dla tego rzedu:");
                            for (int j = 0; j <= i; j++) {
                                System.out.print(sim[i][j] + " ");
                            }

                            temp = input.nextLine().split(" ");
                            for (int k = i + 1; k < sim.length; k++) {
                                sim[i][k] = Float.parseFloat(temp[k - i - 1]);
                                sim[k][i] = sim[i][k];
                            }
                        }
                    }
                    Upcm custom_adj_tree = new Upcm(sim, data);
                }
                case 4 -> System.exit(0);
                default -> System.out.println("Podano niewlasciwy numer, prosze sprobowac ponownie");
            }
        }
    }

}