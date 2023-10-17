package eficaciaordenacao;

public class Mergesort {
    
    //variável para contar a quantidade de trocas e comparações feitas
    public static long trocasMerge = 0;
    public static long comparacoesMerge = 0;

    //algoritmo disponível em: https://gist.github.com/djitz/2112434
    public int[] mergeSort(int[] input) {

        if (input.length == 1) {
            return input;
        }

        int middle = (int) Math.ceil((double) input.length / 2);
        int[] left = new int[middle];

        int rightLength = 0;
        if (input.length % 2 == 0) {
            rightLength = middle;
        } else {
            rightLength = middle - 1;
        }
        int[] right = new int[rightLength];

        int leftIndex = 0;
        int rightIndex = 0;

        for (int i = 0; i < input.length; i++) {
            if (i < middle) {
                left[leftIndex] = input[i];
                leftIndex++;
            } else {
                right[rightIndex] = input[i];
                rightIndex++;
            }
        }

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    /**
     * This method merge two integer arrays into a sorted integer array.
     *
     * @param left first array.
     * @param right second array.
     * @return a sorted integer array.
     */
    public int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int leftIndex = 0;
        int rightIndex = 0;
        int resultIndex = 0;

        while (leftIndex < left.length || rightIndex < right.length) {
            if (leftIndex < left.length && rightIndex < right.length) {
                comparacoesMerge++; // contar as comparações
                if (left[leftIndex] < right[rightIndex]) {
                    result[resultIndex] = left[leftIndex];
                    leftIndex++;
                    resultIndex++;
                } else {
                    result[resultIndex] = right[rightIndex];
                    rightIndex++;
                    resultIndex++;
                    trocasMerge++;
                }
            } else if (leftIndex < left.length) {
                for (int i = resultIndex; i < result.length; i++) {
                    result[i] = left[leftIndex];
                    leftIndex++;
                }
            } else if (rightIndex < right.length) {
                for (int i = resultIndex; i < result.length; i++) {
                    result[i] = right[rightIndex];
                    rightIndex++;
                }
            }
        }

        return result;
    }
}
