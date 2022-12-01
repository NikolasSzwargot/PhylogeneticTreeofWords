import java.util.ArrayList;
import java.util.Vector;

public class adjMatrix {
    public Vector<String> labels;
    public ArrayList<Vector<Float>> adjacency;
    int nodeCounter = 0;

    public adjMatrix(){
        labels = null;
        adjacency = null;
    }

    public void printLabels(){
        for (String label : labels){
            System.out.print(label + " ");
        }
        System.out.print("\n");
    }

    public int fixConnection(int connection){
        boolean connFound = false;
        if (connection != -1) {
            while (!connFound) {
                connFound = true;
                for (int i = connection + 1; i < adjacency.get(connection).size(); i++) {
                    if (adjacency.get(connection).get(i) != 0) {
                        connection = i;
                        connFound = false;
                        break;
                    }
                }
            }
        }

        return connection;
    }

    public void addVertex(String name, int firstConnection, int secondConnection, float distance){
        labels.add(name);
        firstConnection = fixConnection(firstConnection);
        secondConnection = fixConnection(secondConnection);
        adjacency.add(new Vector<>());
        for (Vector<Float> vert : adjacency){
            if (adjacency.indexOf(vert) == firstConnection || adjacency.indexOf(vert) == secondConnection){
                vert.add(distance / 2);
            }
            else if(adjacency.indexOf(vert) == adjacency.size() - 1){
                for (int i = 0; i < adjacency.size(); i++)
                {
                    if (i == firstConnection || i == secondConnection){
                        vert.add(distance / 2);
                    }
                    else {
                        vert.add(0.0f);
                    }
                }
            }
            else {
                vert.add(0.0f);
            }
        }

    }

    public void printAdjMatrix(){
        System.out.println("Adjacency matrix:");
        for (Vector<Float> vert : adjacency){
            for (Float aFloat : vert) {
                System.out.print(aFloat + " ");
            }
            System.out.print("\n");
        }
    }

    public adjMatrix(SimilarityMatrix similarity){
        adjacency = new ArrayList<>();
        labels = new Vector<>();
        int firstConn, secondConn;
        do{
            similarity.findMinimumSimilarity();
            if (!labels.contains(similarity.letters.words.get(similarity.minimumRowIndex))) {
                addVertex(similarity.letters.words.get(similarity.minimumRowIndex), -1, -1, 0);
                firstConn = adjacency.size() - 1;
            }
            else {
                firstConn = labels.indexOf(similarity.letters.words.get(similarity.minimumRowIndex));
            }
            if (!labels.contains(similarity.letters.words.get(similarity.minimumColumnIndex))) {
                addVertex(similarity.letters.words.get(similarity.minimumColumnIndex), -1, -1, 0);
                secondConn = adjacency.size() - 1;
            }
            else {
                secondConn = labels.indexOf(similarity.letters.words.get(similarity.minimumColumnIndex));
            }
            if (similarity.minimumRowIndex != 0 || similarity.minimumColumnIndex != 0)
                addVertex("NODE_" + (++nodeCounter), firstConn, secondConn, similarity.similarityValues[similarity.minimumRowIndex][similarity.minimumColumnIndex]);

            similarity.updateMinimumNode();
            //System.out.println("Minimum: " + similarity.minimumRowIndex + " " + similarity.minimumColumnIndex);
            //similarity.printSimilarity();
        } while (similarity.minimumRowIndex != 0 || similarity.minimumColumnIndex != 0);
        labels.remove(labels.lastElement());
        labels.add("ROOT");
        printLabels();
        printAdjMatrix();
    }
}
