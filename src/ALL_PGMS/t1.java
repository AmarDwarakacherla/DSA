package ALL_PGMS;

public class t1 {
	public static int findJudge(int n, int[][] trust) {
        int[] count = new int[n+1];
        for(int[] i : trust)
        {
            count[i[0]]--;
            count[i[1]]++;
        }
        for(int i=1;i<=n;i++)
        {
            if(count[i]==n-1)
                return i;
        }
        return -1;
        
    }
	public static void main(String[] args)
	{
		int[][] x = {{1,2},{2,2},{3,2}};
		System.out.print(findJudge(3,x));
		
	}
	

}
