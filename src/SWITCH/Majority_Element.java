package SWITCH;

public class Majority_Element {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 1, 3, 5, 1};

        System.out.println(majorityElementApproach2(arr));
    }
    public static int majorityElementApproach1(int[] arr){
        int count = 0, majority = 0;
        for(int i=0;i<arr.length;i++){
            count = 0;
            for(int j=0;j<arr.length;j++){
                if(arr[i] == arr[j]){
                    count++;
                }
            }
            if(count > (arr.length/2)) return arr[i];
        }
        return -1;
    }
    public static int majorityElementApproach2(int [] arr){
        int count = 0, candidate = 0;
        for(int i: arr){
            if(count == 0){
                candidate = i;
            }
            if(i == candidate){
                count++;
            }else{
                count--;
            }
        }
        return candidate;
    }
}
