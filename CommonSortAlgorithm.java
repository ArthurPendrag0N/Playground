public class CommonSortAlgorithm {
    public static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
    private static void print(String s){
        System.out.println(s);
    }
    public static void printArray(int[] array) {
        for(int i=0;i<array.length;i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    public static void BubbleSort(int[] array, int length) {
        for (int i=0;i<length;i++) {
            for(int j = 0; j< length-i-1;j++) {
                if(array[j]>array[j+1]) {
                    swap(array, j, j+1);
                }
            }
        }
    }

    public static void CocktailSort(int[] array, int length) {
        int left = 0;
        int right = length -1;
        while (left<right){
            for(int j = left; j< right;j++) {
                if(array[j]>array[j+1]) {
                    swap(array, j, j+1);
                }
            }
            right--;
            for(int j = right; j >left ; j--) {
                if(array[j-1]>array[j]) {
                    swap(array, j, j-1);
                }
            }
            left++;
        }
    }
    public static void SelectionSort(int[] array, int length) {
        for(int i=0;i<length-1;i++) {
            int min = i;
            for (int j=i+1;j<length;j++) {
                if(array[j]< array[min]) {
                    min = j;
                }
            }
            if(min!=i) {
                swap(array, min, i);
            }
        }
    }

    public static void InsertionSort(int[] array, int length) {
        for(int i = 1; i<length;i++) {
            int tmp = array[i];
            int j = i-1;
            while(j>=0 && tmp<array[j]) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] =tmp;//zhuyi j+1
        }
    }

    public static void ShellSort(int[] array)
    {
        int inner, outer;
        int temp;
    
        int h = 1;
        while (h <= array.length / 3) {
            h = h * 3 + 1;
        }
        while (h > 0) {
            for (outer = h; outer < array.length; outer++) {
                temp = array[outer];
                inner = outer;
        
                while (inner > h - 1 && array[inner - h] >= temp) {
                    array[inner] = array[inner - h];
                    inner -= h;
                }
                array[inner] = temp;
            }
            h = (h - 1) / 3;
        }
    }
    public static void QuickSort(int[] array, int length) {
        _quickSort(array, 0, length-1);
    }

    private static void _quickSort(int[] array, int low, int high) {
        if (low < high) {
            int middle = getMiddle1(array, low, high);
            print("middle: "+middle);
            _quickSort(array, 0, middle-1);
            _quickSort(array, middle+1, high);
        }
    }

    private static int getMiddle(int[] array, int low, int high) {
        int temp = array[low];
        while (low < high) {
            if (low < high && array[high] >= temp) {
                high--;
            }
            array[low] = array[high];
            if (low < high && array[low] <= temp) {
                low++;
            }
            array[high] = array[low];
        }
        array[low] = temp;
        return low;
    }

    private static int getMiddle1(int[] array, int low, int high) {
        int x = array[high];
        int j = low -1;
        for (int i = low; i< high;i++) {
            if(array[i]>=x) {
                j=j+1;
                swap(array, j, i);
            }
        }
        swap(array, j+1, high);
        return j+1;
    }

    private static int getMiddle2(int[] array, int low, int high) {
        int x = array[high];
        int j = low -1;
        int flag = 1;
        for (int i = low; i< high;i++) {
            if(array[i]<=x && flag>0) {
                j=j+1;
                swap(array, j, i);
            }
            if(array[i]==x) {flag = -flag;}
        }
        swap(array, j+1, high);
        return j+1;
    }
    public static void RadixSort(int[] array, int digit) {
        for (int i=1; i< array.length; i++) {
            int[] tempArray = new int[array.length];
            //temp array for countingsort
            //int tmpCountingSortArray[] = new int[10]{0,0,0,0,0,0,0,0,0,0};
        }

    }
    public static void main(String[] args) {
        int[] array = {2,3,1,7,1,5};
        //int[] array = {3,3,3,3};
        ShellSort(array);
        printArray(array);
    }
}