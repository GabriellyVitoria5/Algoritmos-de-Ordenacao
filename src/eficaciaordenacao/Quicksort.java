package eficaciaordenacao;

public class Quicksort {

    //variável para contar a quantidade de trocas e comparações feitas
    public static long trocasQuick = 0;
    public static long comparacoesQuick = 0;
    
    //código disponível em: https://gist.github.com/jayeshsolanki93/10404303
    public static void sort(int arr[], int start, int end) {
        if (start < end) {
            int pIndex = partition(arr, start, end);
            sort(arr, start, pIndex - 1);
            sort(arr, pIndex + 1, end);
        }
    }

    public static int partition(int arr[], int start, int end) {
        int pivot = arr[end];
        int pIndex = start;
        for (int i = start; i < end; i++) {
            comparacoesQuick++; //contar as comparações 
            if (arr[i] <= pivot) {
                swap(arr, i, pIndex);
                pIndex++;
                trocasQuick ++; //contar as trocas 
            }
        }
        swap(arr, pIndex, end);
        return pIndex;
    }

    public static void swap(int arr[], int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
