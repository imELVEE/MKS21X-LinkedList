public class mydriver{
  public static void main(String[] args){
    int amount = Integer.parseInt(args[0]);

    MyLinkedList testList = new MyLinkedList();
    for (int i = 0 ; i < amount ; i++){
      testList.add( (Integer)(int) (Math.random() * 100) );
    }

    //testList.add( (Integer) 90 );
    //testList.add(null);

    System.out.println(testList);
    System.out.println("index 3: " + testList.get(3));
    System.out.println("index 9: " + testList.get(8));
    System.out.println("index 9 change to 90: " + testList.set(9, (Integer) 90));
    System.out.println(testList);
    System.out.println(testList.contains(testList.get(3)));
    System.out.println(testList.contains(testList.get(0)));
    System.out.println(testList.contains((Integer) 90));
    System.out.println(testList.contains((Integer) 30000));
  }
}
