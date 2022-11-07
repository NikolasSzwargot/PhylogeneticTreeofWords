public class Main {
    public static void main(String[] args) {

        SimilarityMatrix test = new SimilarityMatrix();

        test.letters.printMatrix();
        test.fillSimilarity();
        test.printSimilarity();
    }
}