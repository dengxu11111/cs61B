public class ArrayDeque <Ty>{
    Ty[] items;
    int size;
    int nextFirst;
    int nextlast;
    public  ArrayDeque(){
        items=(Ty[])new Object[8];
        size=0;
        nextFirst=3;
        nextlast=4;
    }

    public void addFirst(Ty item){
        if(nextFirst<0){
            nextFirst=items.length-1;
        }
        items[nextFirst]=item;
        nextFirst--;
        size++;
    }

    public void addLast(Ty item){
        if(nextlast>=items.length){
            nextlast-=items.length;
        }
        items[nextlast]=item;
        nextlast++;
        size++;
    }

    public boolean isEmpty(){
        if(size==0){
            return false;
        }
        else{
            return true;
        }
    }

    public int size(){
        return  size;
    }

    public void printDeque(){
        if(nextFirst<nextlast){
            for(int i=nextFirst+1;i<nextlast;i++){
                System.out.print(items[i]+" ");
            }
        }
        else{
            for (int i=nextFirst+1;i<nextlast+items.length;i++){
                System.out.print(items[i%items.length]+" ");
            }
        }
    }

    public Ty removeFirst(){
        Ty temp=items[++nextFirst];
        size--;
        return temp;
    }

    public Ty removeLast(){
        size--;
        return  items[--nextlast];
    }

    public Ty get(int index){
        return items[nextlast+index+1];
    }
}

