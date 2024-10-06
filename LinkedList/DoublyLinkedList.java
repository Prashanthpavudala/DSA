package LinkedList;

class DNode{
    int data;
    DNode prev;
    DNode next;

    DNode(int data1, DNode prev1, DNode next1){
        this.data = data1;
        this.prev = prev1;
        this.next = next1;
    }

    DNode(int data1){
        this.data = data1;
        this.prev = null;
        this.next = null;
    }
}

public class DoublyLinkedList {

    private static DNode convertArrToDLL(int[] arr){
        DNode head = new DNode(arr[0]);
        DNode temp = head;
        for(int i=1; i<arr.length; i++){
            DNode newDNode = new DNode(arr[i], temp, null);
            temp.next = newDNode;
            temp = temp.next;
        }
        return head;
    }

    private static void print(DNode head){
        while(head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    private static DNode deleteHead(DNode head){
        if(head == null || head.next == null){
            return null;
        }
        head = head.next;
        head.prev = null;
        return head;
    }

    private static DNode deleteTail(DNode head){
        if(head == null || head.next == null){
            return null;
        }
        DNode temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next.prev = null;
        temp.next = null;
        return head;
    }

    private static DNode deleteKthElement(DNode head, int k){
        if(head != null){
            if(k==1){
                head = head.next;
                head.prev = null;
                return head;
            }
         int counter = 0;
         DNode temp = head;
         while (temp!=null) {
            counter++;
            if(counter == k){
                if(temp.prev != null){
                    temp.prev.next = temp.next;
                }
                if(temp.next != null){
                    temp.next.prev = temp.prev;
                }
                temp.next = null;
                temp.prev = null;
                break;
            }
            temp = temp.next;
         }
        }
        return head;
    }

    private static DNode deleteElement(DNode head, int ele){
        if(head != null){
            if(head.data == ele){
                head = head.next;
                head.prev.next = null;
                head.prev = null;
                return head;
            }
            DNode temp = head;
            while(temp != null){
                if(temp.data == ele){
                    if(temp.prev != null){
                        temp.prev.next = temp.next;
                    }
                    if(temp.next != null){
                        temp.next.prev = temp.prev;
                    }
                    temp.prev = null;
                    temp.next = null;
                    break;
                }
                temp = temp.next;
            }
        }
        return head;
    }

    private static DNode insertAtHead(DNode head, int ele){
        return new DNode(ele, null, head);
    }

    private static DNode insertAtTail(DNode head, int ele){
        if(head == null){
            return new DNode(ele);
        }
        DNode temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        DNode tailNew = new DNode(ele, temp, null);
        temp.next = tailNew;
        return head;
    }

    private static DNode insertAtKPosition(DNode head, int val, int k){
        if(head == null){
            if(k == 1){
                return new DNode(val);
            }else{
                //invalid case
                return head;
            }
        }
        if(k == 1){
            return new DNode(val, null, head);
        }
        DNode temp = head;
        int counter = 0;
        while(temp != null){
            counter++;
            if(counter == (k-1)){
                if(temp.next != null){
                    DNode newNode = new DNode(val, temp, temp.next);
                    temp.next.prev = newNode;
                    temp.next = newNode;
                }else{
                    DNode newNode = new DNode(val, temp, null);
                    temp.next = newNode;
                }

                break;
            }
            temp = temp.next;
        }
        return head;
    }

    private static DNode insertBeforeElement(DNode head, int ele, int val){
        if(head == null) return null;
        DNode newNode;
        if(head.data == ele){
            newNode = new DNode(val, null, head);
            head.prev = newNode;
            return newNode;
        }
        DNode temp = head.next;
        while (temp != null) {
            if(temp.data == ele){
                newNode = new DNode(val, temp.prev, temp);
                temp.prev.next = newNode;
                temp.prev = newNode;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    private static DNode reverseDLL(DNode head){
        if(head == null || head.next == null) return head;
        DNode temp = null;
        DNode current = head;
        while (current != null) {
            //swapping prev, next values
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;   
        }
        return temp.prev;
    }

    public static void main(String[] args) {
        int[] arr = {1};
        DNode head = convertArrToDLL(arr);
        // print(head);

        // head = deleteHead(head);
        // print(head);

        // head = deleteTail(head);
        // print(head);

        // head = deleteKthElement(head, 3);
        // print(head);

        // head = deleteElement(head, 1);
        // print(head);

        // head = insertAtHead(head, 1);
        // print(head);

        // head = insertAtTail(head, 100);
        // print(head);

        // head = insertAtKPosition(head, 100, 6);
        // print(head);

        // head = insertBeforeElement(head, 5, 100);
        // print(head);

        head = reverseDLL(head);
        print(head);
    }

}
