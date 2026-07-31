package ALL_PGMS.LinkedList;

public class  SinglyLinkedList{
	class LL
	{
		int data;
		LL next;
		LL(int data)
		{
			this.data=data;
			this.next=null;
		}
	}
	LL head;
	
	public void InserAtBegin(int data)
	{
		LL newnode = new LL(data);
		newnode.next = head;
		head = newnode;
	}
	public void InsertAtPosition(int data,int position)
	{
		LL newnode = new LL(data);
		if(position ==1)
		{
			newnode.next=head;
			head=newnode;
		}
		else
		{
			int count=1;
			LL prev = head;
			while(count<position-1)
			{
				prev=prev.next;
				count++;
			}
			LL current = prev.next;
			newnode.next = current;
			prev.next = newnode;
		}
	}
	public void InsertAtEnd(int data)
	{
		LL newnode = new LL(data);
		if(head==null)
		{
			head=newnode;
			return;
		}
		LL temp = head;
		while(temp.next!=null)
		{
			temp=temp.next;
		}
		temp.next=newnode;
	}
	
	public int DeleteFirst()
	{
		LL t=head;
		head=head.next;
		t.next=null;
		return t.data;
	}
	public int DeleteAtPostion(int position)
	{
		if(position==1)
		{
			head=head.next;
			return head.data;
		}
		else
		{
			LL previous = head;
			int count=1;
			while(count<position-1)
			{
				previous=previous.next;
				count++;
			}
			LL current=previous.next;
			previous.next=current.next;
			return current.data;
		}
	}
	public int DeleteLast()
	{
		if(head==null)
		{
			return -1;
		}
		if(head.next == null)
		{
			LL t = head;
			head=head.next;
			t.next=null;
			return t.data;
		}
		LL previous=null;
		LL current = head;
		while(current.next!=null)
		{
			previous = current;
			current = current.next;
		}
		previous.next=null;
		return current.data;
		
	}
	public void Display()
	{
		LL temp= head;
		while(temp!=null)
		{
			System.out.print(temp.data+"->");
			temp=temp.next;
		}
		System.out.print("null");
		System.out.println();
	}
	
	
	
	public boolean search(int SearchData)
	{
		if(head==null)
			return false;
		LL temp=head;
		while(temp!=null)
		{
			if(temp.data== SearchData)
			{
				return true;
			}
			temp = temp.next;
		}
		return false;
	}
	
	public void reverse()
	{
		LL current = head;
		LL previous =null;
		LL next =null;
		while(current!=null)
		{
			next=current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		head=previous;
	}
	public LL GetMid()
	{
		if(head==null)
			return null;
		LL slow=head;
		LL fast=head;
		while(fast!=null && fast.next!=null)
		{
			slow=slow.next;
			fast=fast.next.next;
		}
		return slow;
	}
	
	public int GetNthNode(int n)
	{
		if(n<=0)
			return -1;
		LL temp = head;
		int count=1;
		while(count<n && temp!=null)
		{
			temp=temp.next;
			count++;
		}
		if(temp==null)
			return -1;
		return temp.data;
	}
	
	public void sort()
	{
		int c=0;
		if(head!=null)
		{
			LL temp=head;
			while(temp!=null)
			{
				temp=temp.next;
				c++;
			}
		}
		for(int i=0;i<c;i++)
		{
			LL temp=head;
			LL temp1=temp.next;
			for(int j=0;j<c-i-1;j++)
			{
				if(temp.data>temp1.data)
				{
					int t=temp.data;
					temp.data=temp1.data;
					temp1.data=t;
				}
				temp = temp1;
				temp1=temp1.next;
			}
		}
		LL temp=head;
		while(temp!=null)
		{
			System.out.print(temp.data+"->");
			temp=temp.next;
		}
		
	}
	public void RemoveDuplicatesFromSortedList()
	{
		if(head==null)
			return;
		LL current = head;
		while(current!=null && current.next!=null)
		{
			if(current.data==current.next.data)
			{
				current.next= current.next.next;
			}
			else
			{
				current=current.next;
			}
		}
	}
	
	public void InsertNodeInSortedList(int value)
	{
		LL newnode = new LL(value);
		LL temp=null;
		LL current = head;
		while(current!=null && current.data<value)
		{
			temp=current;
			current=current.next;
		}
		newnode.next = current;
		temp.next=newnode;
	}
	
	public void delete(int value)
	{
		LL current=head;
		LL temp=null;
		if(current!=null && current.data==value)
		{
			head = current.next;
			return;
		}
		while(current!=null && current.data!=value)
		{
			temp=current;
			current=current.next;
		}
		if(current==null)
			return;
		temp.next=current.next;
		
	}
	
	public boolean ContainsLoop()
	{
		LL slow=head;
		LL fast=head;
		while(fast!=null && fast.next!=null)
		{
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast)
				return  true;
		}
		return  false;
	}
	
	public LL MergeList(LL a,LL b)
	{
		LL temp=new LL(0);
		LL tail=temp;
		while(a!=null && b!=null)
		{
			if(a.data<=b.data)
			{
				tail.next=a;
				a=a.next;
			}
			else
			{
				tail.next=b;
				b=b.next;
			}
			tail=tail.next;
		}
		if(a==null)
			tail.next=b;
		else
			tail.next=a;
		return temp.next;
		
	}
	public static void main(String[] args)
	{
//		SinglyLinkedList List =new SinglyLinkedList();
//		List.InserAtBegin(12);
//		List.InserAtBegin(20);
//		List.InsertAtEnd(25);
//		List.InsertAtPosition(500,4);
//		System.out.println(List.DeleteFirst());
//		System.out.println(List.DeleteLast());
//		System.out.println(List.DeleteAtPostion(2));
//		List.Display();
		
		SinglyLinkedList List1 =new SinglyLinkedList();
		List1.InserAtBegin(20);
		List1.InserAtBegin(15);
		List1.InserAtBegin(10);
		List1.InserAtBegin(2);
		List1.Display();
		SinglyLinkedList List2 =new SinglyLinkedList();
		List2.InserAtBegin(17);
		List2.InserAtBegin(15);
		List2.InserAtBegin(10);
		List2.InserAtBegin(3);
		List2.InsertAtEnd(25);
		List2.Display();
//		
//		SinglyLinkedList result =new SinglyLinkedList();
//		result.head=result.MergeList(List1.head,List2.head);
//		result.Display();
		
	}	
}
