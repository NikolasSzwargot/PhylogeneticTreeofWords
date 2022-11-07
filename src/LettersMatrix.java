import java.util.*;

public class LettersMatrix {
    public String[] words = {"ana", "anka", "olka", "alka"};

    public Vector<Character> letters;

    public int[][] letterCounters;

    public LettersMatrix(){
        letters = new Vector<>();
        for (String word : words) {
            for (int j = 0; j < word.length(); j++) {
                if (!letters.contains(word.charAt(j))) {
                    letters.add(word.charAt(j));
                }
            }
        }

        letterCounters = new int[words.length][letters.size()];

        for (int[] letterCounter : letterCounters) {
            Arrays.fill(letterCounter, 0);
        }

        for (int i = 0; i < words.length; i++){
            for (int j = 0; j < words[i].length(); j++){
                letterCounters[i][letters.indexOf(words[i].charAt(j))]++;
            }
        }

    }
    public void printMatrix(){
        System.out.print("Macierz liter:\n  ");
        for (Character letter : letters) {
            System.out.print(letter + " ");
        }
        System.out.print("\n");
        for (int i = 0; i < letterCounters.length; i++){
            System.out.print(words[i] + " ");
            for (int j = 0; j < letterCounters[i].length; j++){
                System.out.print(letterCounters[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}