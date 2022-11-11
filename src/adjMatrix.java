import java.util.ArrayList;
import java.util.Vector;

public class adjMatrix {
    public Vector<String> labels;
    public ArrayList<Integer> adjacency;
    int nodeCounter = 0;

    public adjMatrix(){
        labels = null;
        adjacency = null;
    }

    public adjMatrix(SimilarityMatrix similarity){
        adjacency = null;
        labels = null;
        do{
            similarity.findMinimumSimilarity();
            similarity.updateMinimumNode();
            System.out.println("Minimum: " + similarity.minimumRowIndex + " " + similarity.minimumColumnIndex);
            similarity.printSimilarity();
        } while (similarity.minimumRowIndex != 0 || similarity.minimumColumnIndex != 0);
    }
}
