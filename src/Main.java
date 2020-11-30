import java.util.Arrays;

public class Main {
    static SortingAlgorithms sort = new SortingAlgorithms(40, 100);

    public static void main (String[] args) {

        //Initial array
        int[] arr = sort.createArray();
        System.out.println("Initial array");
        System.out.println(Arrays.toString(arr));

        //Bubble sort
        System.out.println("Bubble sort");
        sort.bubbleSort(arr);
        printAndShuffle(arr);

        //Selection sort v.1
        System.out.println("Selection sort v.1");
        sort.selectionSort(arr);
        printAndShuffle(arr);

        //Selection sort v.2
        System.out.println("Selection sort v.2");
        sort.selectionSort2(arr);
       printAndShuffle(arr);
        //Cocktail shaker sort
        System.out.println("Cocktail shaker sort");
        sort.cocktailShakerSort(arr);
        printAndShuffle(arr);

        //Insertion sort
        System.out.println("Insertion sort");
        sort.insertionSort(arr);
        printAndShuffle(arr);

        //Bogosort
        /*System.out.println("Bogosort");
        sort.bogoSort(arr);
        printAndShuffle(arr);
        */
    }
    private static void printAndShuffle(int[] arr){
        System.out.println(Arrays.toString(arr));
        System.out.println("Array is sorted:" + " " + sort.sorted(arr));
        sort.shuffleArray(arr);
    }
}
