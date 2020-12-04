import java.util.Arrays;

public class Main {
    static SortingAlgorithms sort = new SortingAlgorithms(500, 500);

    public static void main (String[] args) {

        //Initial array
        int[] arr = sort.createArray();
        System.out.println("INITIAL UNSORTED ARRAY");
        System.out.println(Arrays.toString(arr));
        System.out.println("Array is sorted:" + " " + sort.sorted(arr));
        System.out.println();

        //Bubble sort
        System.out.println("BUBBLE SORT");
        sort.bubbleSort(arr);
        printAndShuffle(arr);

        //What is this sort called??
        System.out.println("WHAT IS THIS SORT CALLED??");
        sort.whatIsThisSortCalled(arr);
        printAndShuffle(arr);

        //Selection sort
        System.out.println("SELECTION SORT");
        sort.selectionSort(arr);
        printAndShuffle(arr);

        //Cocktail shaker sort
        System.out.println("COCKTAIL SHAKER SORT");
        sort.cocktailShakerSort(arr);
        printAndShuffle(arr);

        //Insertion sort
        System.out.println("INSERTION SORT");
        sort.insertionSort(arr);
        printAndShuffle(arr);

        //Gnome sort
        System.out.println("GNOME SORT");
        sort.gnomeSort(arr);
        printAndShuffle(arr);

        //Bogosort
        /*System.out.println("BOGOSORT");
        sort.bogoSort(arr);
        printAndShuffle(arr);
        */
    }

    private static void printAndShuffle(int[] arr){
        System.out.println(Arrays.toString(arr));
        System.out.println("Array is sorted:" + " " + sort.sorted(arr));
        System.out.println();
        sort.shuffleArray(arr);
    }
}
