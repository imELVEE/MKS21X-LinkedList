public class mydriver{
  public static void main(String[] args){
    int amount = Integer.parseInt(args[0]);

    MyLinkedList testList = new MyLinkedList();

    System.out.println(testList);

    for (int i = 0 ; i < amount ; i++){
      testList.add( (Integer)(int) (Math.random() * 100) );
    }

    //testList.add( (Integer) 90 );
    //testList.add(null);

    System.out.println(testList);
    System.out.println("size: " + testList.size());
    System.out.println("index 3: " + testList.get(3));
    System.out.println("index 8: " + testList.get(8));
    System.out.println("index 8 change to 90: " + testList.set(8, (Integer) 90));
    System.out.println(testList);
    System.out.println(testList.contains(testList.get(3)));
    System.out.println(testList.contains(testList.get(0)));
    System.out.println(testList.contains((Integer) 90));
    System.out.println(testList.contains((Integer) 30000));

    System.out.println("---------------------------------------------");

    System.out.println(testList);
    testList.add(4, (Integer) 400);
    System.out.println(testList);
    testList.add(7, (Integer) 700);
    System.out.println(testList);

    System.out.println("---------------------------------------------");

    System.out.println(testList);
    System.out.println("size: " + testList.size());
    System.out.println("index 3: " + testList.get(3));
    System.out.println("index 10: " + testList.get(11));
    System.out.println("index 10 change to 20: " + testList.set(10, (Integer) 20));
    System.out.println(testList);
    System.out.println(testList.contains(testList.get(3)));
    System.out.println(testList.contains(testList.get(0)));
    System.out.println(testList.contains((Integer) 20));
    System.out.println(testList.contains((Integer) 30000));

    System.out.println("--------------------------------------------");

    System.out.println(testList);
    System.out.println(testList.remove(4));
    System.out.println(testList);
    System.out.println(testList.remove(6));
    System.out.println(testList);

    System.out.println("--------------------------------------------");

    System.out.println(testList);
    System.out.println("size: " + testList.size());
    System.out.println("index 3: " + testList.get(3));
    System.out.println("index 8: " + testList.get(8));
    System.out.println("index 8 change to 90: " + testList.set(8, (Integer) 90));
    System.out.println(testList);
    System.out.println(testList.contains(testList.get(3)));
    System.out.println(testList.contains(testList.get(0)));
    System.out.println(testList.contains((Integer) 90));
    System.out.println(testList.contains((Integer) 30000));

    System.out.println("--------------------------------------------");

    System.out.println(testList.remove((Integer) 90));
    System.out.println(testList);
    System.out.println("index " + testList.get(3) + ": " + testList.indexOf(testList.get(3)));
    System.out.println("index " + testList.get(7) + ": " + testList.indexOf(testList.get(7)));
    System.out.println("index 600000000: " + testList.indexOf(600000000));

    System.out.println("--------------------------------------------");

    MyLinkedList other = new MyLinkedList();
    for (int i = 0 ; i < amount ; i++){
      other.add( (Integer)(int) (Math.random() * 100) );
    }
    System.out.println(testList);
    System.out.println(other);
    System.out.println();
    testList.extend(other);
    System.out.println(testList);
    System.out.println(other);
  }
}
