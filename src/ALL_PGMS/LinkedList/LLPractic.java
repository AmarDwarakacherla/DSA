package ALL_PGMS.LinkedList;

public class LLPractic {
	private ListNode head;
	private static class ListNode{
		private int data;
		private ListNode next;
		public ListNode(int data)
		{
			this.data = data;
			this.next = null;
		}
	}
	public void display()
	{
		ListNode temp =head;
		while(temp!=null)
		{
			System.out.println(temp.data);
			temp = temp.next;
		}
		
	}
	public void insertFirst(int value)
	{
		ListNode newnode = new ListNode(value);
		newnode.next = head;
		head = newnode;
		
	}
	public void insertEnd(int value)
	{
		ListNode newnode = new ListNode(value);
		if(head == null)
		{
			head = newnode;
			return;
		}
		ListNode current = head;
		while(current.next!=null)
		{
			current = current.next;
		}
		current.next = newnode;
	}
	public void insertAtPosition(int pos,int value)
	{
		ListNode newnode = new ListNode(value);
		if(pos==1)
		{
			insertFirst(value);
			return;
		}
		else
		{
			ListNode prev = head;
			int count = 0;
			while(count<pos-1)
			{
				count++;
				prev = prev.next;
			}
			ListNode current = prev.next;
			newnode.next = current;
			prev.next = newnode;
			
		}
	}
	public void deleteFirst()
	{
		if(head==null)
			return;
		ListNode temp = head;
		head = head.next;
		temp.next = null;
	}
	public void deleteLast()
	{
		if(head==null || head.next==null)
			return;
		ListNode curr = head;
		ListNode prev = null;
		while(curr.next!=null)
		{
			prev = curr;
			curr = curr.next;
		}
		prev.next = null;
	}
	private int findlength()
	{
		if(head == null)
			return 0;
		int count = 0;
		ListNode temp = head;
		while(temp!=null)
		{
			count++;
			temp=temp.next;
		}
		return count;
	}
	public static void main(String[] args)
	{
		LLPractic ll = new LLPractic();
		ll.head = new ListNode(10);
		ListNode second = new ListNode(50);
		ListNode third = new ListNode(100);
		ll.head.next = second;
		second.next = third;
		ll.insertFirst(25);
		ll.insertFirst(2);
		ll.insertEnd(134);
		ll.insertAtPosition(4, 0);
		ll.deleteFirst();
		ll.deleteLast();
		ll.display();
		System.out.println(ll.findlength());
		
		
	}

}

