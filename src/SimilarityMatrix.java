import java.lang.Math;

public class SimilarityMatrix {
    public LettersMatrix letters;

    public int[][] similarityValues;

    public SimilarityMatrix(){
        letters = new LettersMatrix();

        similarityValues = new int[letters.words.length][];

        for (int i = 0; i < similarityValues.length; i++){
            similarityValues[i] = new int[similarityValues.length - i];
        }
    }

    public int calculateSimilarity(int mainWordIndex, int hypoSimilarIndex){
        int result = 0;
        for (int i = 0; i < letters.letterCounters[mainWordIndex].length; i++){
            result += Math.abs(letters.letterCounters[mainWordIndex][i] - letters.letterCounters[hypoSimilarIndex][i]);
        }

        return result;
    }

    public void fillSimilarity(){
        for (int i = 0; i < similarityValues.length; i++){
            similarityValues[i][0] = 0;
            for (int j = 1; j < similarityValues[i].length; j++){
                similarityValues[i][j] = calculateSimilarity(i, i + j);
            }
        }
    }

    public void printSimilarity(){
        System.out.print("Macierz podobienstwa:\n");
        for (int i = 0; i < similarityValues.length; i++){
            System.out.print(letters.words[i] + " ");
            for (int j = 0; j < similarityValues[i].length; j++){
                System.out.print(similarityValues[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}
