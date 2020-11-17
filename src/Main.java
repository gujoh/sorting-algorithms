import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        SortingAlgorithms sort = new SortingAlgorithms();

        //Initial array
        int[] arr = sort.createArray();
        System.out.println("Initial array");
        System.out.println(Arrays.toString(arr));

        //Bubble sort
        System.out.println("Bubble sort");
        sort.bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
        sort.shuffleArray(arr);

        //Selection sort v.1
        System.out.println("Selection sort v.1");
        sort.selectionSort(arr);
        System.out.println(Arrays.toString(arr));
        sort.shuffleArray(arr);

        //Selection sort v.2
        System.out.println("Selection sort v.2");
        sort.selectionSort2(arr);
        System.out.println(Arrays.toString(arr));
        sort.shuffleArray(arr);

        //Cocktail shaker sort
        System.out.println("Cocktail shaker sort");
        sort.cocktailShakerSort(arr);
        System.out.println(Arrays.toString(arr));
        sort.shuffleArray(arr);

        //Insertion sort
        System.out.println("Insertion sort");
        sort.insertionSort(arr);
        System.out.println(Arrays.toString(arr));
        sort.shuffleArray(arr);

    }
}
