package LinkedList;

class Node {
    int data;
    Node next;

    Node(int data1, Node next1) {
        this.data = data1;
        this.next = next1;
    }

    Node(int data1) {
        this.data = data1;
        this.next = null;
    }
}

public class LinkedList {

    private static Node convertArr2LL(int[] arr){
        Node head = new Node(arr[0]);
        Node temp = head;
        for(int i=1; i<arr.length; i++){
            Node newNode = new Node(arr[i]);
            temp.next = newNode;
            temp = newNode;
        }
        return head;
    }

    private static void print(Node head){
        while(head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    private static void printNode(Node node){
        if(node != null){
            System.out.println(node.data);
        }
    }

    private static int getLengthOfLinkedList(Node head){
        int count = 0;
        Node temp = head;
        while(temp!=null){
            count++;
            temp = temp.next;
        }
        return count;
    }

    private static boolean checkIfPresent(Node head, int val){
        Node temp = head;
        while(temp != null){
            if(temp.data == val)return true;
            temp = temp.next;
        }
        return false;
    }

    private static Node deleteHead(Node head){
        if(head == null || head.next == null) return null;
        head = head.next;
        return head;
    }

    private static Node deleteTail(Node head){
        if(head == null || head.next == null) return null;
        Node temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    private static Node deleteKthElement(Node head, int k){
        if(head == null) return null;
        if(k == 1){
            head = head.next;
            return head;
        }
        int counter = 0;
        Node temp = head;
        Node prev = null;
        while(temp != null){
            counter++;
            if(counter == k){
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    private static Node deleteElement(Node head, int ele){
        if(head == null) return null;
        if(head.data == ele){
            head = head.next;
            return head;
        }
        Node temp = head;
        Node prev = null;
        while(temp != null){
            if(temp.data == ele){
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    private static Node insertAtHead(Node head, int val){
        //creating a new node and pointing it to head and returing it
        return new Node(val, head);
    }

    private static Node insertAtTail(Node head, int val){
        if(head == null) return new Node(val, head);
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = new Node(val);
        return head;
    }

    private static Node insertAtKPosition(Node head, int val, int k){
        if(head == null){
            if(k == 1){
                return new Node(val);
            }else{
                //not possible case
                return head;
            }
        }
        if(k == 1){
            return new Node(val, head);
        }
        int counter = 0;
        Node temp = head;
        while(temp != null){
            counter++;
            if(counter == (k-1)){
                Node newNode = new Node(val);
                newNode.next = temp.next;
                temp.next = newNode;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    private static Node insertBeforeElement(Node head, int ele, int val){
        if(head == null) return null;
        if(head.data == ele){
            return new Node(val, head);
        }
        Node temp = head;
        while(temp.next != null){
            if(temp.next.data == ele){
                Node newNode = new Node(val);
                newNode.next = temp.next;
                temp.next = newNode;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    private static Node reverseLLUsingIteration(Node head){
        if(head == null || head.next == null) return head;
        Node temp = head;
        Node prev = null;
        while(temp!=null){
            Node front = temp.next;
            temp.next = prev;
            prev = temp;
            temp= front;
        }
        return prev;
    }

    private static Node reverseLLUsingRecursion(Node head){
        if(head == null || head.next == null) return head;
        Node newHead = reverseLLUsingRecursion(head.next);
        Node front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }

    private static Node findMiddle(Node head){
        //the Tortoise and Hare Algorithm is where the middle node can be found in just one traversal
        //The Tortoise and Hare algorithm leverages two pointers, 'slow' and 'fast', 
        //initiated at the beginning of the linked list. The 'slow' pointer advances one node at a time, 
        //while the 'fast' pointer moves two nodes at a time
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] arr = {2,4,6,8,10};

        Node head = convertArr2LL(arr);
        // print(head);

        // System.out.println(getLengthOfLinkedList(head));

        // System.out.println(checkIfPresent(head, 10));

        // head = deleteHead(head);
        // print(head);

        // head = deleteTail(head);
        // print(head);

        // head = deleteKthElement(head, 3);
        // print(head);

        // head = deleteElement(head, 6);
        // print(head);

        // head = insertAtHead(head, 0);
        // print(head);

        // head = insertAtTail(head, 14);
        // print(head);

        // head = insertAtKPosition(head, 100, 3);
        // print(head);

        // head = insertBeforeElement(head, 6, 100);
        // print(head);

        // head = reverseLLUsingIteration(head);
        // print(head);

        head = reverseLLUsingRecursion(head);
        print(head);

        // head = findMiddle(head);
        // printNode(head);

    }
}
