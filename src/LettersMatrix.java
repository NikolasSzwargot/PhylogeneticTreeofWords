import java.util.ArrayList;

public class LettersMatrix {
    public String[] words = {"ana", "alka", "olka", "lena"};

    public ArrayList<String> letters;

    public int[][] letterCounters;

    public LettersMatrix(){
        letters = new ArrayList<String>();
        for (int i = 0; i < words.length; i++){
            for (int j = 0; j < words[i].length(); j++){
                if (!letters.contains(words[i][j])){

                }
            }
        }

    }
};