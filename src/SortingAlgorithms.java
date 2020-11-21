import java.util.Random;
public class SortingAlgorithms {
    Random rand = new Random();

    //A COUPLE OF METHODS TO SETUP INITIAL ARRAY AND SHUFFLE IT ONCE IT HAS BEEN SORTED//

    public int[] createArray(){
        int[] arr = new int[40];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(100);
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


    //SORTING ALGORITHMS START HERE//

    public void bubbleSort (int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1] > arr[j])
                    swap(arr, j, j - 1);
            }
        }
    }

    public void selectionSort(int[] arr){                       //Is this actually a selection sort?
        for (int i = 0; i < arr.length; i++) {                  //Or is selectionSort2() better despite being a little longer?
            for (int j = i + 1; j < arr.length; j++) {          //This method swaps the value of index i in the array
                if (arr[j] < arr[i])                            //as soon as it finds a smaller value to the right of it.
                    swap(arr, j, i);                           //selectionSort2() on the other hand only swaps index i
            }                                                   //when it has traversed the whole array to the right of i
        }                                                       //and found a value smaller than i.
    }

    public void selectionSort2(int[] arr){
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












}
