package ru.geekbrains.lesson2;

/**
 * Утилиты для сортировки массива
 */
public class SortUtils {


    /**
     * Сортировка выбором
     *
     *  0 1 2 3 4
     *  =========
     *  5 4 1 0 1
     *
     *
     *
     * @param array массив
     */
    public static void directSort(int[] array){
        for (int i = 0; i < array.length - 1; i++){
            int saveIndex = i;
            for (int j = i + 1; j < array.length; j++){
                if (array[j] < array[saveIndex]){
                    saveIndex = j;
                }
            }
            if (i != saveIndex){
                int buf = array[i];
                array[i] = array[saveIndex];
                array[saveIndex] = buf;
            }
        }
    }


    public static void quickSort(int[] array){
        quickSort(array, 0, array.length - 1);
    }

    public static void quickSort(int[] array, int start, int end){
        int left = start;
        int right = end;
        int middle = array[(start + end) / 2];

        do{
            while (array[left] < middle){
                left++;
            }

            while (array[right] > middle){
                right--;
            }

            if (left <= right){
                if (left < right){
                    int buf = array[left];
                    array[left] = array[right];
                    array[right] = buf;
                }
                left++;
                right--;
            }
        }
        while (left <= right);

        if (left < end){
            quickSort(array, left, end);
        }

        if (start < right){
            quickSort(array, start, right);
        }
    }

    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Построение кучи (перегруппировка массива)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Один за другим извлекаем элементы из кучи
        for (int i = n - 1; i > 0; i--) {
            // Перемещаем текущий корень в конец
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Вызываем процедуру heapify на уменьшенной куче
            heapify(arr, i, 0);
        }
    }

    // Процедура для перегруппировки поддерева с корневым узлом i,
    // который является индексом в arr[]. n - размер кучи
    static void heapify(int[] arr, int n, int i) {
        int largest = i; // Инициализируем наибольший элемент как корень
        int left = 2 * i + 1; // левый = 2*i + 1
        int right = 2 * i + 2; // правый = 2*i + 2

        // Если левый дочерний элемент больше корня
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // Если правый дочерний элемент больше, чем самый большой элемент на данный момент
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // Если самый большой элемент не корень
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Рекурсивно процедура выполняется на уменьшенной куче
            heapify(arr, n, largest);
        }
    }
}
