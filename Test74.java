public class Test74{
    public static int findUniquePosition(int[] array1, int[] array2) {
        if(array1==null || array1==null
                || array1.length-array2.length!=1) return -1;
        int start = 0;
        int end = array1.length-1;

        while(start < end) {
            int mid = start + end/2;
            if(mid == array1.length-1) return mid;

            if(array1[mid] != array2[mid]) {
                if(mid ==0|| array1[mid-1] == array2[mid-1]) return mid;

                end = end -1;
            } else {
                start = start+1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] array1 = {2,3,6,4,5,6};
        int[] array2 = {2,3,4,5,6};
        int pos = findUniquePosition(array1, array2);
        System.out.println("position: "+pos);
    }
}