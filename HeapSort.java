public class HeapSort {

    public static void heap_sort(int[] array) {
        int size = array.length;
        
        for (int i = (size - 1)/2; i >= 1; i--) {
            MaxHeapify(array, i, size - 1);
        }

        for (int i = size - 1; i >= 2; i--) {
            swap(1, i, array);
            MaxHeapify(array, 1, i - 1);
        }

    }

    private static void MaxHeapify(int[] array, int i, int size) {
        
        int l = 2 * i;
        int r = 2 * i + 1;
        int largest;

        if (l <= size && array[l] > array[i]) {
            largest = l;
        } else {
            largest = i;
        }

        if (r <= size && array[r] > array[largest]) {
            largest = r;
        }

        if (largest != i) {
            swap(i, largest, array);
            MaxHeapify(array, largest, size);
        }
    }

    private static void swap(int ind1, int ind2, int[] array) {
        int temp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = temp;
    }

    private static void print_array(int[] array) {
        System.out.print("[");

        for (int i = 0; i < array.length; ++i)
            System.out.print(array[i] + ((i < array.length - 1) ? "," : ""));

        System.out.println("]");
    }

    public static void main(String[] args) {
        int[] arr1 = {-1, 6,5,4,1,2,3};
        int[] arr2 = {-1,99,19,9,7,11,3,3,2,2,1};
        int[] arr3 = {-1,4,5,1,7,22,13,31,2,4,1};

        heap_sort(arr1);
        heap_sort(arr2);
        heap_sort(arr3);
        print_array(arr1);
        print_array(arr2);
        print_array(arr3);
    }
    
}
