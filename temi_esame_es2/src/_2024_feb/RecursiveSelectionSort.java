package _2024_feb;

/*
 * Definire l'algoritmo di ordinamento Selection-Sort in modo
 * RICORSIVO, ovvero secondo la strategia divide-et-impera
 */

public class RecursiveSelectionSort {
    public void selectionSortRecursive(int[] arr, int a) {
        // Caso base: se l'array ha dimensione 1, è già ordinato
        if (a >= arr.length - 1) {
            return;
        }
        
        // Trova l'indice del minimo elemento nell'array
        int minIndex = findMinIndex(arr, a, a);
        
        // Scambia l'elemento minimo con il primo elemento dell'array
        int temp = arr[a];
        arr[a] = arr[minIndex];
        arr[minIndex] = temp;
        
        // Ordina ricorsivamente il sottovettore restante
        selectionSortRecursive(arr, a + 1);
    }
    
    private int findMinIndex(int[] arr, int a, int min) {
        if (a > arr.length - 1)
            return min;
        
        if(arr[a] < arr[min])
        	return findMinIndex(arr,a+1,a);
        else
        	return findMinIndex(arr,a+1, min);
        
    }
    
    public static void main(String[] args) {
        RecursiveSelectionSort sorter = new RecursiveSelectionSort();
        
        int[] arr = {5, 3, 7, 2, 8, 4};
        int n = arr.length;
        
        System.out.println("Array prima dell'ordinamento:");
        printArray(arr);
        
        sorter.selectionSortRecursive(arr, 0);
        
        System.out.println("Array dopo l'ordinamento:");
        printArray(arr);
    }
    
    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
