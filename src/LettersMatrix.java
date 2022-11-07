import java.util.*;

public class LettersMatrix {
    public String[] words = {"ana", "alka", "olka", "lena"};

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

    }
};