package ALL_PGMS.Arrays;

public class SubArraySum {
    public static void main(String[] args) {
        int a[] = {1, 2, 3, 7, 5};
        int n = a.length;
        int reqsum = 12;
        int csum = 0, start = 0;
        for (int i = 0; i < n; i++) {
            csum += a[i];
            if (csum == reqsum) {
                System.out.print((start + 1) + " " + (i + 1));
                break;
            }
            while (csum > reqsum) {
                csum = csum - a[start];
                start++;
            }
        }
    }
}
