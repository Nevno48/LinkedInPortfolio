//
// Class used to test BinarySearchTree methods
//
// You do not need to modify this class.

public class TestBinarySearchTree
{
    public static void main(String args[])
    {
        

        System.out.println("--------------------------------------------");
        
        int score;
	boolean anyFailed = false;
        score = 0;
        System.out.print("Testing addIterative...");
        try {
            BinarySearchTree bst = new BinarySearchTree();
            bst.addIterative(10);
            bst.addIterative(4);
            bst.addIterative(20);
            bst.addIterative(8);
            bst.addIterative(9);
            bst.addIterative(7);
            if (bst.contains(10)) score++;
            if (bst.contains(4)) score++;
            if (bst.contains(20)) score++;
            if (bst.contains(8)) score++;
            if (bst.contains(9)) score++;
            if (bst.contains(7)) score++;
        } 
        catch (Exception e) {
            System.out.println("");
            System.out.println("      The following exception was thrown.");
            System.out.println("      " + e.toString());   
            System.out.println("      Score: " + score + "/6");
        }
        System.out.println("..." + score + "/6");
	if (score < 6) anyFailed = true;
        
        score = 0;
        System.out.print("Testing getLargestIterative...");
        try {
            BinarySearchTree bst = new BinarySearchTree();
            bst.add(10);
            bst.add(4);
            bst.add(20);
            bst.add(18);
            bst.add(19);
            bst.add(7);
            double s = bst.getLargestIterative();
            if (s == 20) score++;
            bst.add(40);
            bst.add(25);
            bst.add(27);
            s = bst.getLargestIterative();
            if (s == 40) score++;

        } 
        catch (Exception e) {
            System.out.println("");
            System.out.println("      The following exception was thrown.");
            System.out.println("      " + e.toString());   
            System.out.println("      Score: " + score + "/2");

        }
        System.out.println("..." + score + "/2");
	if (score < 2) anyFailed = true;

        
        score = 0;
        System.out.print("Testing removeLargestIterative...");
        try {
            BinarySearchTree bst1 = new BinarySearchTree();
            bst1.add(10);
            bst1.add(5);
            bst1.add(20);
            bst1.add(15);
            bst1.add(35);          
            bst1.add(25);
            bst1.add(23);
            bst1.add(27);
            bst1.removeLargestIterative();
            if (bst1.contains(35) == false) score++;
            if (bst1.contains(25) == true) score++;
            if (bst1.contains(23) == true) score++;
            if (bst1.contains(27) == true) score++;
            if (bst1.contains(15) == true) score++;
            bst1.removeLargestIterative();
            if (bst1.contains(27) == false) score++;
            if (bst1.contains(25) == true) score++;
            if (bst1.contains(23) == true) score++;
            bst1.removeLargestIterative();
            bst1.removeLargestIterative();
            if (bst1.contains(25) == false) score++;
            if (bst1.contains(23) == false) score++;
            if (bst1.contains(20) == true) score++;
            bst1.removeLargestIterative();
            if (bst1.contains(20) == false) score++;
            if (bst1.contains(15) == true) score++;
            if (bst1.contains(5) == true) score++;
        } 
        catch (Exception e) {
            System.out.println("");
            System.out.println("      The following exception was thrown.");
            System.out.println("      " + e.toString());   
            System.out.println("      Score: " + score + "/14");

        }
        System.out.println("..." + score + "/14");
	if (score < 14) anyFailed = true;
	if (!anyFailed) {
	    System.out.println("Congratulations, you have earned all 25 points for Question 7!");
	}

	anyFailed = false;
        score = 0;

        System.out.print("Testing remove(value), Case 2...");
        try {
            BinarySearchTree bst1 = new BinarySearchTree();
            bst1.add(40);
            bst1.add(10);
            bst1.add(70);
            bst1.add(50);
            bst1.add(90); 
            bst1.add(55);
            bst1.add(45);
            // remove a value at a node with no children
            bst1.remove(45);
            if (bst1.contains(45) == false) score++;
            if (bst1.contains(50) == true) score++;
            if (bst1.contains(55) == true) score++;
            if (bst1.contains(90) == true) score++;
            // remove another value at a node with no children
            bst1.remove(90);
            if (bst1.contains(90) == false) score++;
            if (bst1.contains(50) == true) score++;
            if (bst1.contains(55) == true) score++;
            if (bst1.contains(70) == true) score++;
            
            
        } 
        catch (Exception e) {
            System.out.println("");
            System.out.println("      The following exception was thrown.");
            System.out.println("      " + e.toString());   
            System.out.println("      Score: " + score + "/8");

        }
        System.out.println("..." + score + "/8");
	if (score < 8) anyFailed = true;
        
        score = 0;
        System.out.print("Testing remove(value), Case 3...");
        try {
            BinarySearchTree bst1 = new BinarySearchTree();
            bst1.add(40);
            bst1.add(50);
            bst1.add(90);
            bst1.add(80);
            bst1.add(85); 
            bst1.add(20);     
            bst1.add(10);  
            bst1.add(15);  
            bst1.add(12);  
            bst1.remove(90);
            if (bst1.contains(90) == false) score++;
            if (bst1.contains(80) == true) score++;
            if (bst1.contains(85) == true) score++;
            if (bst1.contains(50) == true) score++;
            bst1.remove(80);
            if (bst1.contains(80) == false) score++;
            if (bst1.contains(85) == true) score++;
            if (bst1.contains(50) == true) score++;
            bst1.remove(10);
            if (bst1.contains(10) == false) score++;
            if (bst1.contains(15) == true) score++;
            if (bst1.contains(12) == true) score++;
            bst1.remove(20);
            if (bst1.contains(20) == false) score++;
            if (bst1.contains(15) == true) score++;
            if (bst1.contains(12) == true) score++;
            
            
        } 
        catch (Exception e) {
            System.out.println("");
            System.out.println("      The following exception was thrown.");
            System.out.println("      " + e.toString());   
            System.out.println("      Score: " + score + "/13");

        }
        System.out.println("..." + score + "/13");
	if (score < 13) anyFailed = true;
        
        
        score = 0;
        System.out.print("Testing remove(value), Case 4...");
        try {
            BinarySearchTree bst1 = new BinarySearchTree();
            bst1.add(40);
            bst1.add(20);
            bst1.add(10);
            bst1.add(30);  
            bst1.add(5);   
            bst1.add(12);   
            bst1.add(18); 
            bst1.add(16);
            bst1.add(15);
            bst1.add(35);
            bst1.add(50);
            bst1.remove(20);
            if (bst1.contains(20) == false) score++;
            if (bst1.contains(15) == true) score++;
            if (bst1.contains(12) == true) score++;
            if (bst1.contains(16) == true) score++;
            if (bst1.contains(18) == true) score++;
            // do a sum of all the values in the tree,
            // to make sure the extra copy of the largest
            // value in the left subtree was removed.
            if (bst1.sum() == 231) score++;
        } 
        catch (Exception e) {
            System.out.println("");
            System.out.println("      The following exception was thrown.");
            System.out.println("      " + e.toString());   
            System.out.println("      Score: " + score + "/6");
        }
        System.out.println("..." + score + "/6");
	if (score < 6) anyFailed = true;
	if (!anyFailed) {
	    System.out.println("Congratulations, you have earned all 30 points for Question 8!");
	}
        
        
        System.out.println("The last two tests are for bonus points: ");
        score = 0;
        System.out.println("Testing remove(value), Case 2, when node being removed is the root...");
        System.out.println("   Don't worry about this case until everything else working...");
        try {
            // 
            BinarySearchTree bst2 = new BinarySearchTree();
            bst2.add(40);
            bst2.remove(40);
            if (bst2.contains(40) == false) score++;
        } 
        catch (Exception e) {
            System.out.println("");
            System.out.println("      The following exception was thrown.");
            System.out.println("      " + e.toString());   
            System.out.println("      Score: " + score + "/1");
        }
        System.out.println("   Score is: " + score + "/1");
        
        score = 0;
        System.out.println("Testing remove(value), Case 3, when node being removed is the root...");
        System.out.println("   Don't worry about this case until everything else working...");
        try {
            BinarySearchTree bst2 = new BinarySearchTree();
            bst2.add(40);
            bst2.add(50);
            bst2.add(95);
            bst2.add(45);
            bst2.remove(40);
            if (bst2.contains(40) == false) score++;
            if (bst2.contains(50) == true) score++;
            if (bst2.contains(45) == true) score++;
            if (bst2.contains(95) == true) score++;
        }
        catch (Exception e) {
            System.out.println("");
            System.out.println("      The following exception was thrown.");
            System.out.println("      " + e.toString());   
            System.out.println("      Score: " + score + "/4");
        }
        System.out.println("   Score is: " + score + "/4");
              
              
    }
}
