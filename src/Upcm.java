public class Upcm {

    SimilarityMatrix sim;
    adjMatrix adjaceny;

    public Upcm(int size, int length){
        sim = new SimilarityMatrix(size, length);
        sim.fillSimilarity();
        adjaceny = new adjMatrix(sim);
    }

    public Upcm(String words){
        sim = new SimilarityMatrix(words);
        sim.fillSimilarity();
        adjaceny = new adjMatrix(sim);
    }

    public Upcm(float[][] temp, String words){
        sim = new SimilarityMatrix(temp, words);
        adjaceny = new adjMatrix(sim);
    }

}
