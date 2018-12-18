public class MyLinkedList{

  private class Node{
    private Integer data;
    private Node next, prev;

    public Node(Integer num, Node nextOne, Node prevOne){
      data = num;
      next = nextOne;
      prev = prevOne;
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

    public void nextExnull(Node val){
      next = val;
    }

    public void prevExnull(Node val){
      prev = val;
    }
  }

//----------------------------------------------------------------------------


  private int size = 0;
  private Node start,end;
  private Node current = start;

  public MyLinkedList(){
  }

/*
  public MyLinkedList(int[] ary){
    for (int i = 0 ; i < ary.length ; i++){
      add((Integer) ary[i]);
    }
  }
  */

  public String toString(){
    String ans = "[";
    current = start;
    for (int i = 0 ; i < size ; i++){
      ans += current.get() + ", ";
      current = current.next();
    }
    if (ans.length() > 1){
      ans = ans.substring(0,ans.length()-2);
    }
    return ans + "]";
  }

  public int size(){
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
    if (index < 0 || index > size - 1){
      throw new IndexOutOfBoundsException("Please input an index between 0 and " + size);
    }
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
    Integer old = get(index);
    current.set(value);
    return old;
  }

  public boolean contains(Integer value){
    current = start;
    while (current.hasNext() && current.get() != value){
      current = current.next();
    }
    //return true if the loop found a matching value before the end OR value == end value
    return (current != end || value == end.get());
  }

  public int indexOf(Integer value){
    current = start;
    int i = 0;
    while (i < size && current.get() != value){
      current = current.next();
      i++;
    }
    if (i == size)
      return -1;
    return i;
  }

  public void add(int index, Integer value){
    if (index == size){
      add(value);
    }
    else if (index == 0){
      start.prevChange(new Node(value, start, null));
      start = start.prev();
      size++;
    }
    else{
      get(index);
      Node toBeAdded = new Node(value, current, current.prev());
      current.prev().nextChange(toBeAdded);
      current.prevChange(toBeAdded);
      size++;
    }
  }

  public Integer remove(int index){
    get(index);
    if (index == 0 || index == size - 1){
      if (index == 0)
        start = current.next();
      else
        end = current.prev();
    }
    else{
      current.prev().nextChange(current.next());
      current.next().prevChange(current.prev());
    }
    size--;
    return current.get();
  }

  public boolean remove(Integer value){
    boolean worked = contains(value);
    if (current.prev() != null)
      current.prev().nextExnull(current.next());
    else{
      remove(0);
      size++;
    }
    if (current.next() != null)
      current.next().prevExnull(current.prev());
    else{
      remove(size - 1);
      size++;
    }
    size--;
    return worked;
  }

  public void extend(MyLinkedList other){
    while (other.size() > 0){
      add(other.get(0));
      other.remove(0);
    }
  }

}
