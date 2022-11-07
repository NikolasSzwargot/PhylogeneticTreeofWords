import java.util.*;

public class LettersMatrix {
    public String[] words = {"ana", "anka", "olka", "alka"};

    public List<Character> letters;

    public int[][] letterCounters;

    public LettersMatrix(){
        for (int i = 0; i < words.length; i++){
            for (int j = 0; j < words[i].length(); j++){
                if (!letters.contains(words[i].charAt(j))){
                    letters.add(words[i].charAt(j));
                }
            }
        }

        letterCounters = new int[words.length][letters.size()];

        for (int i = 0; i < letterCounters.length; i++){
            for (int j = 0; j < letterCounters[i].length; j++){
                letterCounters[i][j] = 0;
            }
        }

        for (int i = 0; i < words.length; i++){
            for (int j = 0; j < words[i].length(); j++){
                letterCounters[i][letters.indexOf(words[i].charAt(j))]++;
            }
        }

    }
};