import java.lang.Math;
import java.util.Arrays;

public class SimilarityMatrix {
    public LettersMatrix letters;

    public float[][] similarityValues;

    public int minimumRowIndex;
    public int minimumColumnIndex;

    boolean[] activeValues;

    public SimilarityMatrix(int size){
        letters = new LettersMatrix(size);

        similarityValues = new float[letters.words.size()][];

        Arrays.setAll(similarityValues, i -> new float[similarityValues.length]);
        activeValues = new boolean[similarityValues.length];
        Arrays.fill(activeValues, true);
    }

    public SimilarityMatrix(String data){
        letters = new LettersMatrix(data);

        similarityValues = new float[letters.words.size()][];

        Arrays.setAll(similarityValues, i -> new float[similarityValues.length]);
        activeValues = new boolean[similarityValues.length];
        Arrays.fill(activeValues, true);
    }

    public SimilarityMatrix(float[][] temp, String data){
        letters = new LettersMatrix(data);
        similarityValues = new float[temp.length][temp.length];
        for (int k = 0; k < similarityValues.length; k++) {
            System.arraycopy(temp[k], 0, similarityValues[k], 0, similarityValues.length);
        }

        activeValues = new boolean[similarityValues.length];
        Arrays.fill(activeValues, true);
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
            similarityValues[i][i] = 0;
            for (int j = i + 1; j < similarityValues[i].length; j++){
                similarityValues[i][j] = calculateSimilarity(i, j);
                similarityValues[j][i] = similarityValues[i][j];
            }
        }
    }

    public void printSimilarity(){
        System.out.print("Similarity matrix:\n");
        for (int i = 0; i < similarityValues.length; i++){
            if (activeValues[i]) {
                System.out.print(letters.words.get(i) + " ");
                for (int j = 0; j < similarityValues[i].length; j++) {
                    System.out.print(similarityValues[i][j] + " ");
                }
                System.out.print("\n");
            }
        }
    }

    public void findMinimumSimilarity(){
        minimumColumnIndex = 0;
        minimumRowIndex = 0;
        float temp = 0;

        for (int i = 0; i < similarityValues.length; i++){
            for (int j = 1; j < similarityValues[i].length; j++){
                if (activeValues[i]) {
                    if (temp != 0 && similarityValues[i][j] != 0) {
                        if (temp > similarityValues[i][j]) {
                            temp = similarityValues[i][j];
                            minimumRowIndex = i;
                            minimumColumnIndex = j;
                        }
                    } else if (similarityValues[i][j] != 0) {
                        temp = similarityValues[i][j];
                        minimumRowIndex = i;
                        minimumColumnIndex = j;
                    }
                }
            }
        }
    }

    public void updateMinimumNode(){

        //letters.connectWords(minimumRowIndex, minimumColumnIndex);

        for (int i = 0; i < similarityValues[minimumRowIndex].length; i++){
            if (activeValues[i]) {
                if (similarityValues[minimumRowIndex][i] != 0 && similarityValues[minimumColumnIndex][i] != 0) {
                    similarityValues[minimumRowIndex][i] = (similarityValues[minimumRowIndex][i] + similarityValues[minimumColumnIndex][i]) / 2;
                    similarityValues[minimumColumnIndex][i] = similarityValues[minimumRowIndex][i];
                    similarityValues[i][minimumRowIndex] = similarityValues[minimumRowIndex][i];
                    similarityValues[i][minimumColumnIndex] = similarityValues[minimumRowIndex][i];
                }
                else {
                    similarityValues[minimumRowIndex][i] = 0;
                }
            }
        }
        activeValues[minimumColumnIndex] = false;
        for (int i = 0; i < similarityValues.length; i++){
            if (activeValues[i])
                similarityValues[i][minimumColumnIndex] = 0;
        }
    }
}
