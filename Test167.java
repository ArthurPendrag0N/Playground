import java.io.*;

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = {0,0};
        if(numbers==null || numbers.length==0|| numbers.length==1) return result;
        
        for(int i = 0; i< numbers.length;i++) {
            int p = target - numbers[i];
            int start = i+1;
            int end = numbers.length-1;
            while(start<end) {
               int mid = start + (end -start)/2;
                if(numbers[mid] > p) {
                    end = mid;
                }else if (numbers[mid] < p) {
                    start = mid+1;
                } else if (numbers[mid] == p){
                    result[0] = i+1;
                    result[1] = mid+1;
                    return result;
                }
                
            }

        }
        return result;
    }
}

public class Test167 {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
          return new int[0];
        }
    
        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }
    
    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }
    
        String result = "";
        for(int index = 0; index < length; index++) {
            int number = nums[index];
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }
    
    public static String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] numbers = stringToIntegerArray(line);
            line = in.readLine();
            int target = Integer.parseInt(line);
            
            int[] ret = new Solution().twoSum(numbers, target);
            
            String out = integerArrayToString(ret);
            
            System.out.print(out);
        }
    }
}