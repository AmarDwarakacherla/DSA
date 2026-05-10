package ALL_PGMS.LinkedList;

import java.util.*;



public class Search {
	public static void main(String[] args)
	{
		SinglyLinkedList List =new SinglyLinkedList();
//		List.InserAtBegin(36);
//		List.InserAtBegin(30);
//		List.InserAtBegin(20);
//		List.InserAtBegin(20);
//		List.InserAtBegin(20);
//		List.InserAtBegin(10);
//		List.InserAtBegin(10);
//		
//		List.Display();
//		System.out.println();
//		List.reverse();
//		List.Display();
//		SinglyLinkedList.LL middleNode = List.GetMid();
//		System.out.println(middleNode.data);
//		System.out.println(List.GetNthNode(11));
//		List.Display();
//		System.out.println();
//		List.sort();
//		System.out.println();
////		List.RemoveDuplicatesFromSortedList();
//		List.InsertNodeInSortedList(25);
//		List.Display();
//		
//		List.delete(10);
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
		List2.Display();
		
		SinglyLinkedList result =new SinglyLinkedList();
		result.head=result.MergeList(List1.head,List2.head);
		result.Display();
		
		
		

		
		
		
		
		
		
	}

}
