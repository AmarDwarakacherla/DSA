package LeetCode;

public class _707_Design_Linked_List {
    private  int size=0;
    private static Node head;
    private static Node tail;
    public static void main(String[] args) {
        _707_Design_Linked_List obj_707_Design_Linked_List = new _707_Design_Linked_List();
        obj_707_Design_Linked_List.addAtHead(4);
        obj_707_Design_Linked_List.addAtHead(10);
        obj_707_Design_Linked_List.addAtHead(10);
        obj_707_Design_Linked_List.addAtTail(100);
        obj_707_Design_Linked_List.addAtIndex(1,0);

        System.out.println(head.data);
        System.out.println(tail.data);






        obj_707_Design_Linked_List.display();

    }
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public int get(int index) {
        if(index<0 || index>size)
            return -1;
        else if(index==0){
            return head.data;
        }else if(index==size-1){
            return tail.data;
        }else{
            int count = 0;
            Node temp = head;
            while(count<index-1){
                temp = temp.next;
                count++;
            }
            return temp.data;
        }
    }
    public void addAtHead(int val){
        Node newNode = new Node(val);
        if(head == null)
            head = tail = newNode;
        else{
            newNode.next = head;
            head = newNode;
        }
        size++;
    }
    public void addAtTail(int val) {
        Node newNode = new Node(val);
        if(head == null){
            head = tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }
    public void addAtIndex(int index, int val) {
        if(index<0 && index>size)
            return;
        Node newNode = new Node(val);
        if(index==0){
            addAtHead(val);
            return;
        }else if(index==size){
            addAtTail(val);
            return;
        }else{
            int count = 0;
            Node temp = head;
            while(count < index-1){
                temp = temp.next;
                count++;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
        size++;
    }
    public void deleteAtIndex(int index) {
        if(index<0 || index>size)
            return;
        if(index == 0){
            head = head.next;
        }else if(index == size-1){
            Node temp = head;
            while(temp!=tail){
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
        }else{
            int count = 0;
            Node temp = head;
            while(count<index-1){
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
    }
    public void display(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" -> ");
            temp= temp.next;
        }
    }
}
