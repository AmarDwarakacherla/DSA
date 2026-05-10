package ALL_PGMS.DynamicProgramming;
import java.util.*;
public class Fractional_Knapsack_Problem {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int capacity = 100;
		int n = 5;
		float totalprofit = 0.0f;
		int[] profit = {20,30,66,40,60};
		int[] weight = {10,20,30,40,50};
		float[] ratio = new float[n];
		for(int i=0;i<n;i++)
		{
			ratio[i] = (float)profit[i]/(float)weight[i];
		}
		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if(ratio[i]<ratio[j])
				{
					float t=ratio[i];
					ratio[i]=ratio[j];
					ratio[j]=t;
					
					int t1 = profit[i];
					profit[i]=profit[j];
					profit[j]=t1;
					
					t1 = weight[i];
					weight[i]=weight[j];
					weight[j] =t1;
				}
			}
		}
		float[] r = new float[n];
		Arrays.fill(r, 0.0f);
		System.out.println(Arrays.toString(ratio));
		System.out.println(Arrays.toString(profit));
		System.out.println(Arrays.toString(weight));
		int i=0;
		for(i=0;i<n;i++)
		{
			if(weight[i]>capacity)
				break;
			else
			{
				r[i]=1.0f;
				totalprofit+=(float)profit[i];
				capacity-=weight[i];
				
			}
		}
		if(i<n)
			r[i] = (float)capacity/(float)weight[i];
		totalprofit+=r[i]*(float)profit[i];
		System.out.println(Arrays.toString(r));
		System.out.print(totalprofit);

	}

}
