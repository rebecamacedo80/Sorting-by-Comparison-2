import java.util.Arrays;
import java.util.Scanner;

public class SortByDivision {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Insira os números que compõem o vetor: \n");
        String in = scan.nextLine();
        String[] input = in.split(" ");
        int[] vector = new int[input.length];

        for(int i = 0; i < input.length; i++){
            vector[i] = Integer.parseInt(input[i]);

        }


        System.out.println("Vetor não ordenado: " + Arrays.toString(vector));

        System.out.println("Quick Sort: " + Arrays.toString(quickSort(vector.clone(), 0, vector.length-1)));

        System.out.println("Merge Sort: " + Arrays.toString(mergeSort(vector.clone(), 0, vector.length-1)));

    }

    public static int[] mergeSort(int[] vector, int e, int d){
        if (e < d){
            // Find the middle point
            int m = (e+d)/2;

            // Sort first and second halves
            mergeSort(vector, e, m);
            mergeSort(vector, m+1, d);

            // Merge the sorted halves
            merge(vector, e, m, d);
        }
        return vector;
    }

    public static void merge(int[] vector, int esq, int meio, int dir) {
        // Find sizes of two subarrays to be merged
        int n1 = meio - esq + 1;
        int n2 = dir - meio;

        /* Create temp arrays */
        int e[] = new int[n1];
        int d[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i){
            e[i] = vector[esq + i];
        }

        for (int j = 0; j < n2; ++j){
            d[j] = vector[meio + 1+ j];
        }

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = esq;
        while (i < n1 && j < n2){
            if (e[i] <= d[j]){
                vector[k] = e[i];
                i++;
            }else{
                vector[k] = d[j];
                j++;
            }
            k++;
        }
        /* Copy remaining elements of L[] if any */
        while (i < n1){
            vector[k] = e[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2){
            vector[k] = d[j];
            j++;
            k++;
        }
    }

    public static int[] quickSort(int[] vector, int inicio, int fim){
        if (inicio < fim) {
            int posPivo = partition(vector, inicio, fim);
            quickSort(vector, inicio, posPivo - 1);
            quickSort(vector, posPivo + 1, fim);
        }

        return vector;
    }

    public static int partition(int[] vector, int inicio, int fim){
        int pivo = vector[inicio];
        int i = inicio + 1, f = fim;
        while (i <= f) {
            if (vector[i] <= pivo)
                i++;
            else{
                if (pivo < vector[f])
                f--;
                else {
                    int troca = vector[i];
                    vector[i] = vector[f];
                    vector[f] = troca;
                    i++;
                    f--;
                }
            }
        }
        vector[inicio] = vector[f];
        vector[f] = pivo;
        return f;

    }
}
