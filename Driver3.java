public class Driver3 {
    public static void main(String[] args) {
        //What's poppin' everybody, welcome to my driver, we chill here in the code house
        //Let's test this class and get this bread

        //Step One: Creating a valid Instance
        System.out.println("######################");
        System.out.println("##New Instance Test:##");
        System.out.println("######################");
        MyLinkedList list = new MyLinkedList();
        System.out.println(list);
        System.out.println("This should print: \"[]\"\n");

        //Step Two: Let's add some values
        System.out.println("#######################");
        System.out.println("##Adding Values Test:##");
        System.out.println("#######################");
        for(int i = 0; i < 10; i++) {
            list.add(i);
            //System.out.println(list.size()); <- Debugging
        }
        System.out.println(list);
        System.out.println("This should print: \"[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]\"");

        //Step Three: Adding a value to the middle
        System.out.println("#####################################");
        System.out.println("##Adding Values in the Middle Test:##");
        System.out.println("#####################################");
        list.add(5, 999);
        System.out.println(list);
        System.out.println("This should print: \"[0, 1, 2, 3, 4, 999, 5, 6, 7, 8, 9]\"");

        //Step Four: Removing a value from the list by index
        System.out.println("##########################");
        System.out.println("##Removing a Value Test:##");
        System.out.println("##########################");
        list.remove(5);
        System.out.println(list);
        System.out.println("This should print: \"[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]\"");

        //Step Five: Remove a value from the list by value
        System.out.println("#####################################");
        System.out.println("##Remove a Value by its Value Test:##");
        System.out.println("#####################################");
        list.remove(new Integer(9));
        System.out.println(list);
        System.out.println("This should print: \"[0, 1, 2, 3, 4, 5, 6, 7, 8]\"");

        //Step Six: Testing the Contains Method
        System.out.println("##############################");
        System.out.println("##Checking Containment Test:##");
        System.out.println("##############################");
        System.out.println(list.contains(new Integer(999)));
        System.out.println("This should print: false");

        //Step Seven: Testing the Size Method
        System.out.println("##############");
        System.out.println("##Size Test:##");
        System.out.println("##############");
        System.out.println(list.size());
        System.out.println("This should print: 9");

        //Step Eight: indexOf Method
        System.out.println("########################");
        System.out.println("##Index of Value Test:##");
        System.out.println("########################");
        System.out.println(list.indexOf(0));
        System.out.println("This should print: 0");

        //Step Nine: Exception Testing
        System.out.println("######################");
        System.out.println("##Exception Testing:##");
        System.out.println("######################");
        try {
            list.remove(-1);
        } catch(IndexOutOfBoundsException B) {
            System.out.println("Removing a negative index throws the correct exception");
        } catch(Exception e) {
            System.out.println("Incorrect Exception Thrown:");
            e.printStackTrace();
        }
        try {
            list.remove(9000);
        } catch(IndexOutOfBoundsException B) {
            System.out.println("Removing an oversized index throws the correct exception");
        } catch(Exception e) {
            System.out.println("Incorrect Exception Thrown:");
            e.printStackTrace();
        }
        try {
            list.add(-1, new Integer(9));
        } catch(IndexOutOfBoundsException B) {
            System.out.println("Adding to a negative index throws the correct exception");
        } catch(Exception e) {
            System.out.println("Incorrect Exception Thrown:");
            e.printStackTrace();
        }
        try {
            list.add(90000, new Integer(69));
        } catch(IndexOutOfBoundsException B) {
            System.out.println("Adding to an oversized index throws the correct exception");
        } catch(Exception e) {
            System.out.println("Incorrect Exception Thrown:");
            e.printStackTrace();
        }
        try {
            list.set(-1, new Integer(9));
        } catch(IndexOutOfBoundsException B) {
            System.out.println("Setting a negative index throws the correct exception");
        } catch(Exception e) {
            System.out.println("Incorrect Exception Thrown:");
            e.printStackTrace();
        }
        try {
            list.set(90000, new Integer(69));
        } catch(IndexOutOfBoundsException B) {
            System.out.println("Setting an oversized index throws the correct exception");
        } catch(Exception e) {
            System.out.println("Incorrect Exception Thrown:");
            e.printStackTrace();
        }
        try {
            list.get(-1);
        } catch(IndexOutOfBoundsException B) {
            System.out.println("Getting a negative index throws the correct exception");
        } catch(Exception e) {
            System.out.println("Incorrect Exception Thrown:");
            e.printStackTrace();
        }
        try {
            list.get(90000);
        } catch(IndexOutOfBoundsException B) {
            System.out.println("Getting an oversized index throws the correct exception");
        } catch(Exception e) {
            System.out.println("Incorrect Exception Thrown:");
            e.printStackTrace();
        }

        //Step 10: Edge Case Testing
        System.out.println("######################");
        System.out.println("##Edge-Case Testing:##");
        System.out.println("######################\n");

        System.out.println("Removing Last Element:");
        list.remove(8);
        System.out.println(list);
        System.out.println("This should print: [0, 1, 2, 3, 4, 5, 6, 7]\n");

        System.out.println("Removing First Element:");
        list.remove(0);
        System.out.println(list);
        System.out.println("This should print: [1, 2, 3, 4, 5, 6, 7]\n");

        System.out.println("Adding to Last Element:");
        list.add(7, new Integer(8));
        System.out.println(list);
        System.out.println("This should print: [1, 2, 3, 4, 5, 6, 7, 8]\n");

        System.out.println("Adding to First Element:");
        list.add(0, new Integer(666));
        System.out.println(list);
        System.out.println("This should print: [666, 1, 2, 3, 4, 5, 6, 7, 8]\n");
    }
}
