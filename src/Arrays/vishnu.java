package Arrays;
import java.util.*;
public class vishnu {
	public static void main(String[] args)
	{
Scanner input = new Scanner(System.in);
int n = input.nextInt();
int a[] =new int[n];
for(int i=0;i<n;i++)
{
	a[i]=input.nextInt();
}
input.close();
ArrayList<Integer> odd = new ArrayList<>();
ArrayList<Integer> even = new ArrayList<>();
for(int i: a)
{
	if(i%2==0)
		even.add(i);
	else
		odd.add(i);
}
int j = 0;
for(int i: even)
	a[j++]=i;
for(int i: odd)
	a[j++]=i;

System.out.print(Arrays.toString(a));
	}

}
