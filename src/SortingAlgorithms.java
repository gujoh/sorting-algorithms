import java.util.Random;

public class SortingAlgorithms {
    Random rand = new Random();
    private final int arrayLength;
    private final int randomizerBound;

    public SortingAlgorithms (int arrayLength, int randomizerBound){
        this.arrayLength = arrayLength;
        this.randomizerBound = randomizerBound;
    }

    public int[] createArray(){
        int[] arr = new int[arrayLength];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(randomizerBound);
        }
        return arr;
    }

    public void shuffleArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            int randElement = rand.nextInt(arr.length), temp = arr[i];
            arr[i] = arr[randElement];
            arr[randElement] = temp;
        }
    }

    public void swap (int[] arr, int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public boolean sorted (int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1])
                return false;
        }
        return true;
    }

    //SORTING ALGORITHMS START HERE//

    public void bubbleSort (int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1] > arr[j])
                    swap(arr, j, j - 1);
            }
        }
    }

    public void whatIsThisSortCalled(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i])
                    swap(arr, j, i);
            }
        }
    }

    public void selectionSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
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

    public void cocktailShakerSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1] > arr[j])
                    swap(arr, j, j - 1);
            }
            for (int k = arr.length - i - 1; k > 0; k--) {      //Just add this for-loop to a bubble sort, and
                if (arr[k] < arr[k - 1])                        //you've got a cocktail shaker sort.
                    swap(arr, k, k - 1);
            }
        }
    }

    public void insertionSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0 ; j--) {
                if (arr[j] < arr[j - 1])
                    swap(arr, j, j  - 1);
            }
        }
    }

    public void bogoSort(int[] arr){
        while(!sorted(arr))
            shuffleArray(arr);
    }

    public void gnomeSort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            if (i == 0 || arr[i - 1] <= arr[i])
                i++;
            else if (arr[i - 1] > arr[i]) {
                swap(arr, i, i - 1);
                i--;
            }
        }
    }

    public void oddEvenSort(int[] arr){
        while (!sorted(arr)){
            for (int i = 0; i < arr.length; i+=2) {
                if (i >= 2 && arr[i] < arr[i - 1])
                    swap(arr, i , i - 1);
            }
            for (int i = 1; i < arr.length; i+=2) {
                if (i >= 3 && arr[i] < arr[i - 1])
                    swap(arr, i , i - 1);
            }
        }
    }
}
