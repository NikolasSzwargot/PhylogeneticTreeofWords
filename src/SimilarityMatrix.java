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
}
