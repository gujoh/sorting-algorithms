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
    private final static int SHORT_WAIT = 3;
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
        waitAndShuffle();
        whatIsThisSortCalled();
        waitAndShuffle();
        selectionSort();
        waitAndShuffle();
        cocktailShakerSort();
        waitAndShuffle();
        insertionSort();
        waitAndShuffle();
        gnomeSort();
        waitAndShuffle();
        oddEvenSort();
        waitAndShuffle();
        combSort();
        waitAndShuffle();
        shellSort();
        waitAndShuffle();
        weirdShellSortVariation();
        /*waitAndShuffle();         //Uncomment for Bogosort
        bogoSort();
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

    private void waitAndShuffle(){
        wait(WAIT);
        shuffleArray();
        wait(WAIT);
    }

    private void swap (int[] arr, int x, int y, int waitTime){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
        repaint();
        wait(waitTime);
    }

    private boolean notSorted(){
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1])
                return true;
        }
        return false;
    }

    private void bubbleSort () {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j, j - 1, SHORT_WAIT);
                }
            }
        }
    }

    private void whatIsThisSortCalled(){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i])
                    swap(arr, j, i, SHORT_WAIT);
            }
        }
    }

    private void selectionSort(){
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
                    swap(arr, j, j - 1, SHORT_WAIT);
            }
            for (int k = arr.length - i - 1; k > 0; k--) {
                if (arr[k] < arr[k - 1])
                    swap(arr, k, k - 1, SHORT_WAIT);
            }
        }
    }

    private void insertionSort(){
        for (int i = 0; i < arr.length; i++) {
            repaint();
            for (int j = i; j > 0 ; j--) {
                repaint();
                if (arr[j] < arr[j - 1])
                    swap(arr, j, j  - 1, SHORT_WAIT);
            }
        }
    }

    private void bogoSort(){
        while(notSorted())
            shuffleArray();
    }

    private void gnomeSort() {
        int i = 0;
        while (i < arr.length) {
            if (i == 0 || arr[i - 1] <= arr[i])
                i++;
            else if (arr[i - 1] > arr[i]) {
                swap(arr, i, i - 1, SHORT_WAIT);
                i--;
            }
        }
    }

    private void oddEvenSort(){
        while (notSorted()){
            for (int i = 0; i < arr.length - 1; i+=2) {
                if (arr[i] > arr[i + 1])
                    swap(arr, i, i + 1, SHORT_WAIT);
            }
            for (int i = 1; i < arr.length - 1; i+=2) {
                if (arr[i] > arr[i + 1])
                    swap(arr, i, i + 1, SHORT_WAIT);
            }
        }
    }

    public void combSort(){
        double k = 1.3;                     //1.3 is apparently a good number. Check Wikipedia page for Comb sort.
        int initialOffset = arr.length - 1, offset = initialOffset;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - offset; j++) {
                if (arr[j] > arr[j + offset])
                    swap(arr, j, j + offset, 20);
            }
            offset = Math.max(initialOffset/(int)Math.pow(k, i), 1);
        }
    }

    public void shellSort(){
        int offset = arr.length/2;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - offset; j++) {
                if (arr[j] > arr[j + offset])
                    swap(arr, j, j + offset, 10);
            }
            offset = (int)Math.max(offset/1.2, 1);              //1.2 chosen arbitrarily.
        }                                                       //Worked well with this array size (200).
    }

    public void weirdShellSortVariation() {
        int offset = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - offset; j++) {
                if (arr[j] > arr[j + offset])
                    swap(arr, j, j + offset, 10);
            }
            offset = Math.max(--offset, 1);
        }
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
