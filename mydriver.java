public class mydriver{
  public static void main(String[] args){
    int amount = Integer.parseInt(args[0]);

    MyLinkedList testList = new MyLinkedList();
    for (int i = 0 ; i < amount ; i++){
      testList.add( (Integer)(int) (Math.random() * 100) );
    }

    testList.add( (Integer) 90 );
    testList.add(null);

    System.out.println(testList);
  }
}
