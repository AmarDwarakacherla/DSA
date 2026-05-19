package SWITCH;

public class Check_if_an_array_is_sorted_and_rotated {
    public static void main(String[] args) {
        System.out.println(check(new int[]{4,5,1,2,3}, 5));
    }
    public static boolean check(int[] arr, int n)
    {
        int count = 0;
        for(int i=0;i<n;i++){
            if(arr[i] > arr[(i+1)%n]){
                count++;
            }
        }
        return count<=1;
    }
}
