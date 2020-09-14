import java.util.Arrays;

public class returnindex {
    public int[] twoSum(int[] numbers, int target) {
        int x = numbers.length-1;
        int[] n = new int[2];
        for (int i=0;i<x;i++) {
            for(int j=i+1;j<x;j++) {
                if(target ==(numbers[i]+numbers[j])) {
                    n[0] = i+1;
                    n[1] = j+1;
                }
            }
        }
        return n;
    }

    public static void main(String[] args) {
        int[] s = {1,0,6,5,9,3};
        int value = 10;
        returnindex r = new returnindex();
        int[] a = r.twoSum(s,value);
        System.out.println(Arrays.toString(a));
    }
}
