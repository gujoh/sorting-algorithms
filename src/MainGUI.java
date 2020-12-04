import java.awt.*;
import java.util.Random;
import javax.swing.*;

public class MainGUI extends JPanel {

    private final static int ARRAY_LENGTH = 200;
    private final static int WIDTH = 1000;
    private final static int HEIGHT = 800;
    private final static int ELEMENT_HEIGHT = 4;
    private final static int ELEMENT_WIDTH = WIDTH/ARRAY_LENGTH;
    private final static int WAIT = 2000;
    Random rand = new Random();
    int[] arr;

    public MainGUI(){
        arr = createArray();
        sort();
    }

    private void drawElement(Graphics g, int item, int index) {
        int height = item * ELEMENT_HEIGHT;
        int y = HEIGHT - height;
        int x = index * ELEMENT_WIDTH;
        g.fillRect(x, y, ELEMENT_WIDTH, height);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < arr.length; i++) {
            drawElement(g, arr[i], i);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WIDTH, HEIGHT);
    }

    private void sortingAlgorithms(){
        wait(WAIT);
        bubbleSort();
        wait(WAIT);
        shuffleArray();
        wait(WAIT);
        selectionSort();
        wait(WAIT);
        shuffleArray();
        wait(WAIT);
        selectionSort2();
        wait(WAIT);
        shuffleArray();
        wait(WAIT);
        cocktailShakerSort();
        wait(WAIT);
        shuffleArray();
        wait(WAIT);
        insertionSort();
        /*wait(2000);                   //Uncomment for Bogosort
        shuffleArray();
        bogoSort();
        wait(5000);
        shuffleArray();
        */
    }

    private int[] createArray(){
        int[] arr = new int[ARRAY_LENGTH];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(ARRAY_LENGTH);
        }
        return arr;
    }

    private void shuffleArray(){
        for(int i = 0; i < arr.length; i++){
            int randElement = rand.nextInt(arr.length), temp = arr[i];
            arr[i] = arr[randElement];
            arr[randElement] = temp;
            wait(8);
            repaint();
        }
    }

    private void swap (int[] arr, int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
        repaint();
        wait(3);
    }

    private boolean sorted (){
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1])
                return false;
        }
        return true;
    }

    private void bubbleSort () {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j, j - 1);
                }
            }
        }
    }

    private void selectionSort(){               //Do not think this is a selection sort.
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i])
                    swap(arr, j, i);
            }
        }
    }

    private void selectionSort2(){
        for (int i = 0; i < arr.length; i++) {
            wait(60);
            repaint();
            int temp = arr[i], index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < temp) {
                    temp = arr[j];
                    index = j;
                }
            }
            arr[index] = arr[i];
            arr[i] = temp;
        }
    }

    private void cocktailShakerSort(){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1] > arr[j])
                    swap(arr, j, j - 1);
            }
            for (int k = arr.length - i - 1; k > 0; k--) {
                if (arr[k] < arr[k - 1])
                    swap(arr, k, k - 1);
            }
        }
    }

    private void insertionSort(){
        for (int i = 0; i < arr.length; i++) {
            repaint();
            for (int j = i; j > 0 ; j--) {
                repaint();
                if (arr[j] < arr[j - 1])
                    swap(arr, j, j  - 1);
            }
        }
    }

    private void bogoSort(){
        while(!sorted())
            shuffleArray();
    }

    private void wait(int ms){
        try{
            Thread.sleep(ms);
        }
        catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

    private void sort(){
        SwingWorker<Void, Void> swingWorker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                sortingAlgorithms();
                return null;
            }
        };
        swingWorker.execute();
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Sorting Algorithm Visualizer");
            frame.add(new MainGUI());
            frame.pack();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
