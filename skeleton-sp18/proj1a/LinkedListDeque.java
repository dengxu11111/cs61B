public class LinkedListDeque<GenType>{
    private class Node{
        public Node prev;
        public GenType item;
        public Node next;
        public Node(Node prev,GenType item,Node next){
            this.prev=prev;
            this.item=item;
            this.next=next;
        }
    }

    private int size;
    private Node sentinel;
    private GenType genType;
    public LinkedListDeque(){

        sentinel=new Node(null,genType,null);
        size=0;
        sentinel.prev=sentinel;
        sentinel.next=sentinel;
    }

    public void addFirst(GenType item){
        if(size==0) {
            sentinel.next = new Node(sentinel, item, sentinel.next);
            sentinel.prev = sentinel.next;
        }
        else{
            sentinel.next.prev = new Node(sentinel, item, sentinel.next);
            sentinel.next=sentinel.next.prev;
        }
        size++;
    }

    public void addLast(GenType item){

        if(size==0) {
            sentinel.next = new Node(sentinel, item, sentinel.next);
            sentinel.prev = sentinel.next;
        }
        else{
            sentinel.prev.next=new Node(sentinel.prev,item,sentinel);
            sentinel.prev=sentinel.prev.next;
        }

        size++;
    }

    public boolean isEmpty(){
        if(size==0){
            return true;
        }
        else{
            return false;
        }
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        Node temp=sentinel;
        for(int i=0;i<size;i++){
            temp=temp.next;
            System.out.print(temp.item+" ");
        }

    }

    public GenType removeFirst(){
        if(size>0){
            size--;
            Node temp=sentinel.next;
            sentinel.next=sentinel.next.next;
            return temp.item;
        }
        return null;
    }

    public GenType removeLast(){
        if(size>0){
            size--;
            Node temp=sentinel.prev;
            sentinel.prev=sentinel.prev.prev;
            return temp.item;
        }
        return null;
    }

    public GenType get(int index){
        if(index>=size){
            return null;
        }
        Node temp=sentinel;
        for(int i=0;i<index;i++){
            temp=temp.next;
        }
        return temp.item;
    }

    public GenType getRecursive(int index){
        if(index>=size){
            return null;
        }
        Node temp=sentinel;
        GenType i=getRecursiveHelper(temp,index);
        return i;
    }

    public GenType getRecursiveHelper(Node front,int index){
        if(index==0){
            return front.next.item;
        }
        return getRecursiveHelper(front.next,--index);
    }

}
