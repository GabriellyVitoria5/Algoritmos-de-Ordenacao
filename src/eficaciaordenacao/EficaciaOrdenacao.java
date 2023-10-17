package eficaciaordenacao;

import java.util.Arrays;
import java.util.Random;

public class EficaciaOrdenacao {
    
    //gerar um vetor com números aleatórios de 0 a 5000
    public static int[] numberGenerator(int length){
        int[] result = new int[length];
        Random random = new Random();

        for (int i = 0; i < result.length; i++) {
                result[i] = random.nextInt(5000);
        }

        return result;
    }

    public static void main(String[] args) {
        int array[] = numberGenerator(10);
        long startTime, endTime;
        String totalTime;
        
        //System.out.println("Array desosdenado: " + Arrays.toString(array));
        
        //----------------------------------------------------------------------
        //utilizando o algoritmo mergesort
        
        //vetor utilizado na parte 2 do trabalho
        //int [] arrayMerge = {42, 115, 89, 5, 73, 14, 21, 64, 33, 112, 7, 94, 59, 128, 11, 137};
        
        int[] arrayMerge = Arrays.copyOf(array, array.length);
        startTime = System.currentTimeMillis();
        Mergesort merge = new Mergesort();
        merge.mergeSort(arrayMerge); 
        endTime = System.currentTimeMillis();
        
        totalTime = ("Tempo de execução: " + 
                    ((endTime - startTime) / 3600000) + "h "
                    + ((endTime - startTime) % 3600000 / 60000) + "min "
                    + ((endTime - startTime) % 60000 / 1000) + "seg "
                    + ((endTime - startTime) % 1000) + "ms");
        
        System.out.println("Tempo total da ordenação do MergeSort: " + totalTime);
        System.out.println("Quantidade de trocas feitas: " + merge.trocasMerge);
        System.out.println("Quantidade de comparações feitas: " + merge.comparacoesMerge);
        
        //----------------------------------------------------------------------
        //utilizando o algoritmo insertionsort
        
        int[] arrayInsertion = Arrays.copyOf(array, array.length);
        startTime = System.currentTimeMillis();
        Insertionsort inserction = new Insertionsort();
        inserction.ordena(arrayInsertion, 0);
        endTime = System.currentTimeMillis();
        totalTime = ("Tempo de execução: " + 
                    ((endTime - startTime) / 3600000) + "h "
                    + ((endTime - startTime) % 3600000 / 60000) + "min "
                    + ((endTime - startTime) % 60000 / 1000) + "seg "
                    + ((endTime - startTime) % 1000) + "ms");
        
        System.out.println("\nTempo total da ordenação do InsertionSort: " + totalTime);
        System.out.println("Quantidade de trocas feitas: " + inserction.trocasInsertion);
        System.out.println("Quantidade de comparações feitas: " + inserction.comparacoesInsertion);
        
        //----------------------------------------------------------------------
        //utilizando o algoritmo quicksort
        
        int[] arrayQuick = Arrays.copyOf(array, array.length);
        startTime = System.currentTimeMillis();
        Quicksort quick = new Quicksort();
        quick.sort(arrayQuick, 0, array.length - 1);
        endTime = System.currentTimeMillis();
        
        totalTime = ("Tempo de execução: " + 
                    ((endTime - startTime) / 3600000) + "h "
                    + ((endTime - startTime) % 3600000 / 60000) + "min "
                    + ((endTime - startTime) % 60000 / 1000) + "seg "
                    + ((endTime - startTime) % 1000) + "ms");
        
        System.out.println("\nTempo total da ordenação do QuickSort: " + totalTime);
        System.out.println("Quantidade de trocas feitas: " + quick.trocasQuick);
        System.out.println("Quantidade de comparações feitas: " + quick.comparacoesQuick);
    }
    
}
