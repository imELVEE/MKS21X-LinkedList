public class MyLinkedList{

  private class Node{
    private Integer data;
    private Node next, prev;

    public Node(Integer num, Node nextOne, Node previous){
      data = num;
      next = nextOne;
      prev = previous;
    }

    public Integer get(){
      return data;
    }

    public boolean set(Integer value){
      if (value != null){
        data = value;
        return true;
      }
      return false;
    }

    public boolean hasNext(){
      return (next != null);
    }

    public Node next(){
      return next;
    }

    public Node prev(){
      return prev;
    }

    public boolean prevChange(Node changeTo){
      if (changeTo != null){
        prev = changeTo;
        return true;
      }
      return false;
    }

    public boolean nextChange(Node changeTo){
      if (changeTo != null){
        next = changeTo;
        return true;
      }
      return false;
      }
  }

//----------------------------------------------------------------------------


  private int size = 0;
  private Node start,end;
  private Node current = start;

  public MyLinkedList(){
  }

  public String toString(){
    String ans = "[";
    current = start;
    while ( current.hasNext() ){
      ans += current.get() + ", ";
      current = current.next();
    }
    return ans + end.get() + "]";
  }

  public int size(){
    /*
    current = start;
    size = 0;
    while ( current.hasNext() ){
      size++;
      current = current.next();
    }
    */
    return size;
  }

  public boolean add(Integer value){
    if (start == null){
      start = new Node(value, end, null);
      end = start;
      size++;
      return true;
    }
    else{
      Node newEnd = new Node(value, null, end);
      size++;
      boolean worked = end.nextChange(newEnd);
      end = newEnd;
      return worked;
    }
  }

  public Integer get(int index){
    if (index < (size / 2) ){
      current = start;
      for (int i = 0 ; i < index ; i++){
        current = current.next();
      }
    }
    else{
      current = end;
      for (int i = size - 1 ; i > index ; i--){
        current = current.prev();
      }
    }

    return current.get();
  }

  public Integer set(int index, Integer value){
    //does a single loop, so it is still 0(N^2)
    get(index);
    current.set(value);
    return value;
  }

  public boolean contains(Integer value){
    current = start;
    while (current.hasNext() && current.get() != value){
      current = current.next();
    }
    //return true if the loop found a matching value before the end OR value == end value
    return (current != end || value == end.get());
  }

  public void add(int index, Integer value){
    get(index);
    Node toBeAdded = new Node(value, current, current.prev());
    current.prev().nextChange(toBeAdded);
    current.prevChange(toBeAdded);
    size++;
  }

  public Integer remove(int index){
    get(index);
    current.prev().nextChange(current.next());
    current.next().prevChange(current.prev());
    size--;
    return current.get();
  }

  public boolean remove(Integer value){
    return false;
  }

}
