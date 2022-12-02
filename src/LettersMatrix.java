import java.util.*;

public class LettersMatrix {
    public ArrayList<String> words = new ArrayList<>();

    public Vector<Character> letters;

    public int[][] letterCounters;

    public void generateRandomWords(int numOfWords, int size){
        Random rand = new Random();
        for (int i = 0; i < numOfWords; i++){
            char[] temp = new char[rand.nextInt(size - 3) + 3];
            do {
                for (int j = 0; j < temp.length; j++){
                    temp[j] = (char)('a' + rand.nextInt(26));
                }
            }while (words.contains(new String(temp)));

            words.add(new String(temp));
        }
    }

    public void fillLetters(){
        letters = new Vector<>();

        for (String word : words) {
            for (int j = 0; j < word.length(); j++) {
                if (!letters.contains(word.charAt(j))) {
                    letters.add(word.charAt(j));
                }
            }
        }

        letterCounters = new int[words.size()][letters.size()];

        for (int[] letterCounter : letterCounters) {
            Arrays.fill(letterCounter, 0);
        }

        for (int i = 0; i < words.size(); i++){
            for (int j = 0; j < words.get(i).length(); j++){
                letterCounters[i][letters.indexOf(words.get(i).charAt(j))]++;
            }
        }
    }

    public LettersMatrix(int size, int length){
        generateRandomWords(size, length);
        fillLetters();

    }

    public LettersMatrix(String data){
        words = new ArrayList<>(Arrays.asList(data.split(" ")));
        fillLetters();
    }
    public void printMatrix(){
        System.out.print("Letters matrix:\n  ");
        for (Character letter : letters) {
            System.out.print(letter + " ");
        }
        System.out.print("\n");
        for (int i = 0; i < letterCounters.length; i++){
            System.out.print(words.get(i) + " ");
            for (int j = 0; j < letterCounters[i].length; j++){
                System.out.print(letterCounters[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

   // public void connectWords(int first, int second){
      //  words[first] = "( " + words[first] +  " , " + words[second] + " )";
       // words[second] = words[first];
   // }
}