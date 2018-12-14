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

    public boolean hasNext(){
      return (next != null);
    }

    public Node next(){
      return next;
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
    if (ans.length() > 1){
      ans = ans.substring(0,ans.length()-2);
    }
    return ans + "]";
  }

  public int size(){
    current = start;
    size = 0;
    while ( current.hasNext() ){
      size++;
      current = current.next();
    }
    return size;
  }

  public boolean add(Integer value){
    if (start == null){
      start = new Node(value, end, null);
      end = start;
    }

    Node newEnd = new Node(value, null, end);
    size++;
    boolean worked = end.nextChange(newEnd);
    end = newEnd;
    return worked;
  }

}
