public class MyList {

    public Node headNode;
    
    public MyList() {
        headNode = null;
    }
    
    public void addToEnd(int data) {
        if (headNode == null) {
            this.headNode = new Node(data);
        } else {
            headNode.addToEnd(data);
        }
    }
    
    public void addToBeginning(int data) {
        if (headNode == null) {
            headNode = new Node(data);
        } else {
            Node temp = new Node(data);
            temp.next = headNode;
            headNode = temp;
        }
    }
    
    public void addSorted(int data) {
        if (headNode == null) {
            headNode = new Node(data);
        } else if (data < headNode.data) {
                addToBeginning(data);
        } else {
            headNode.addSorted(data);
        }
    }
    
    public void print() {
        if (headNode != null) {
            headNode.print();
        }
        System.out.println();
    }
            
    private class Node {
    
        private int data;
        private Node next;
        
        public Node(int data) {
            this.data = data;
            next = null;
        }
        
        public void print() {
            System.out.print("|" + data + "|->");
            
            if (next != null) {
                next.print();
            }
        }
        
        public void addToEnd(int data) {
            if (next == null) {
                next = new Node(data);
            } else {
                next.addToEnd(data);
            }
        }
        
        public void addSorted(int data) {
            if (next == null)  {
                next = new Node(data);
            } else if (data < next.data) {
                Node temp = new Node(data);
                temp.next = this.next;
                this.next = temp;
            } else {
                next.addSorted(data);
            }
        }        
    
    }
    
}
