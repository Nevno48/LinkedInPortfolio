public class TestDoubleArrayList {

    public static void testDoubleArrayListA()
    {
        int score = 0;
        int maxscore = 0;      

        try {

            DoubleArrayList list1 = new DoubleArrayList( );

            //-------- Test size() method
            if (list1.size() == 0)
                score++;
            maxscore++;

            list1.addSimple( 5.0 );
            list1.addSimple( 4.0 );
            list1.addSimple( 3.0 );
            list1.addSimple( 2.0 );

            if (list1.size() == 4)
                score++;
            maxscore++;

            //-------- Test set(pos, element) method
            list1.set(0, 50.0);
            if (list1.get(0) == 50.0) 
                score++;
            maxscore++;

            list1.set(3, 20.0);
            if (list1.get(3) == 20.0) 
                score++;
            maxscore++;

            list1.set(1, 40.0);
            if (list1.get(1) == 40.0) 
                score++;
            maxscore++;

            //-------- Test remove method
            DoubleArrayList list2 = new DoubleArrayList();

            // create list {0,1,2,3,4,5,6,7,8,9}
            for (int i = 0; i < 10; i++ ) 
                list2.addSimple( i );

            if (list2.remove(3) == 3.0) 
                score++;
            maxscore++;

            if (list2.size() == 9)
                score++;
            maxscore++;

            // remove first item
            if (list2.remove( 0 ) == 0.0)
                score++;
            maxscore++;

            if (list2.get( 0 ) == 1.0)
                score++;
            maxscore++;

            if (list2.remove( 3 ) == 5.0)
                score++;
            maxscore++;

            if (list2.size() == 7)
                score++;
            maxscore++;

            // remove last item
            if (list2.remove( 6 ) == 9.0)
                score++;
            maxscore++;

            //-------- Test clear method
            list2.clear();
            if (list2.size() == 0) 
                score++;
            maxscore++;

            list2.addSimple( 1.0 );
            if (list2.size() == 1) 
                score++;
            maxscore++;

            System.out.println( "You scored " + score + " out of a possible " + maxscore + " points." );
            if ( score < maxscore ) System.out.println( "Keep working on it - you can fix the bugs!" );
            else System.out.println( "You rock -- a perfect score!" );
            MyTestCases();
        } catch(Exception e) {
            System.out.println( "     Unable to complete test program because " );
            System.out.println( "     Exception thrown: " + e.getClass().getSimpleName() );
            System.out.println( "     Use the debugger to figure out what is going on.");
            System.out.println( "     Your score before the exception was thrown was " + score);
        }
    }

    public static void MyTestCases(){
        int score = 0;
        int maxScore = 0;
        DoubleArrayList list = new DoubleArrayList();
        list.addSimple(5);
        list.addSimple(-5);
        list.addSimple(0);
        list.addSimple(-100);
        list.addSimple(20);
        list.addSimple(9001);
        if(list.contains(5)){
            score++;   
        }
        maxScore++;
        if(list.contains(2)==false){
            score++;   
        }
        maxScore++;
        if(list.contains(10)== false){
            score++;   
        }
        maxScore++;
        if(list.contains(-100)){
            score++;   
        }
        maxScore++;
        if(list.contains(20)){
            score++;   
        }
        maxScore++;
        if(list.contains(9001)){
            score++;   
        }
        maxScore++;
        System.out.println("Your Current Score is: " + score);
        System.out.println("Max Score is: " + maxScore);
        if(score == maxScore){
            System.out.println("You did it!");   
        }
        else{
            System.out.println("You don't it");
        }
    }

    public static void testDoubleArrayListB()
    {
        int score = 0;
        int maxscore = 0;      

        try {

            //-------- Test getCopy
            DoubleArrayList list3 = new DoubleArrayList();
            list3.addSimple(5.0);
            list3.addSimple(6.0);
            list3.addSimple(7.0);

            DoubleArrayList c1;
            c1 = list3.getCopy();

            if ( c1 != null ) { // make sure it is not a null reference
                if (c1.size() == 3)
                    score++;

                if (c1.getCapacity() == 10)
                    score++;

                if (c1.get(0) == 5.0) 
                    score++;

                if (c1.get(1) == 6.0) 
                    score++;

                if (c1.get(2) == 7.0) 
                    score++;

                // make sure c1 and list3 are separate and independent
                // lists - we don't want them to share a single array.
                c1.set(0,123.0);
                if (list3.get(0) == 5.0) 
                    score++;
            }
            maxscore += 6;

            //-------- Test getCapacity
            DoubleArrayList list4 = new DoubleArrayList( );

            if ( list4.getCapacity() == 10 ) 
                score++;
            maxscore++;

            //-------- Test ensureCapacity
            DoubleArrayList list6 = new DoubleArrayList();
            list6.ensureCapacity(15);
            if (list6.getCapacity() == 15)
                score++;
            maxscore++;

            // this should have no effect on capacity
            list6.ensureCapacity(12);
            if (list6.getCapacity() == 15)
                score++;
            maxscore++;

            // We should be able to add 15 values to list6, 
            // now that its capacity is 15.
            // Add first ten elements
            for (int i = 0; i<10; i++) 
                list6.addSimple(i);
            // Are we able to add 5 more elements?
            for (int i = 10; i<15; i++) {
                if (list6.addSimple(i) == true) 
                    score++;   
                maxscore++;
            }

            //-------- Test add(element) 
            // this add method should automatically double the
            // capacity of list as necessary
            DoubleArrayList list12 = new DoubleArrayList();
            // add 14 items to list, which should double its capacity
            for (int i = 0; i < 14; i++)
                list12.add(i);

            if (list12.size() == 14) {
                score++;

                if (list12.get(0) == 0.0)
                    score++;

                if (list12.get(13) == 13.0)
                    score++;

                if (list12.getCapacity() == 20)
                    score++;
            }
            maxscore += 4;

            //-------- Test add(pos,newElement)
            DoubleArrayList list7 = new DoubleArrayList();
            list7.addSimple(0.0);
            list7.addSimple(1.0);
            
            list7.add(0, 2.0); // add to the beginning
            // list should now contain {2, 0, 1}
            if (list7.size() == 3) { 
                score++;

                if (list7.get(0) == 2.0)
                    score++;

                if (list7.get(2) == 1.0)
                    score++;

                list7.add(3, 5.0); // at to the end
                // list should now contains {2, 0, 1, 5}
                if (list7.size() == 4)
                    score++;

                if (list7.get(0) == 2.0)
                    score++;

                if (list7.get(3) == 5.0)
                    score++;

                list7.add(2, 7.0); // at to the middle
                // list should now contain {2, 0, 7, 1, 5}
                if (list7.size() == 5)
                    score++;

                if (list7.get(0) == 2.0)
                    score++;

                if (list7.get(3) == 1.0)
                    score++;

                if (list7.get(2) == 7.0)
                    score++;

                // see if it doubles the capacity when necessary
                list7.add( 5, 50 );
                list7.add( 6, 60 );
                list7.add( 7, 60 );
                list7.add( 8, 60 );
                list7.add( 9, 60 );
                list7.add( 10, 60 );
               

                if (list7.getCapacity() == 20)
                    score++;
                if (list7.get( 10 ) == 60)
                    score++;
            }
            maxscore += 12;

            //-------- Test addAll( addend )
            DoubleArrayList list9 = new DoubleArrayList();
            list9.add(0.0);
            list9.add(1.0);

            DoubleArrayList list8 = new DoubleArrayList();
            list8.add(2.0);
            list8.add(3.0);
            list8.add(4.0);

            list9.addAll( list8 );
            if (list9.size() == 5) {
                score++;

                if (list9.get(0) == 0.0)
                    score++;

                if (list9.get(4) == 4.0)
                    score++;

                if (list8.size() == 3)
                    score++;
            }
            maxscore += 4;

            DoubleArrayList list10 = new DoubleArrayList();
            DoubleArrayList list11 = new DoubleArrayList();
            // put 8 items in both lists
            for (int i = 0; i < 8; i++) {
                list10.add(i);
                list11.add(i);
            }

            list10.addAll( list11 );
            if (list10.size() == 16) {
                score++;

                if (list10.get(0) == 0.0)
                    score++;

                if (list10.get(8) == 0.0)
                    score++;

                if (list10.get(15) == 7.0)
                    score++;

                if (list10.getCapacity() == 16)
                    score++;
            }
            maxscore += 5;

            //-------- Test addAll(pos, addpos)
            DoubleArrayList listA = new DoubleArrayList();
            listA.add(0.0);
            listA.add(10.0);
            listA.add(20.0);
            listA.add(30.0);

            DoubleArrayList listB = new DoubleArrayList();
            listB.add(5.0);
            listB.add(15.0);
            listB.add(25.0);
            listA.addAll( 2, listB );
            if ( listA.size() == 7 ) {
                score++;

                if ( listA.get(2) == 5 )
                    score++;

                if ( listA.get(3) == 15 )
                    score++;

                if ( listA.get(4) == 25 )
                    score++;

                if ( listA.get(5) == 20 )
                    score++;

            }
            maxscore += 5;
            System.out.println( "You scored " + score + " out of a possible " + maxscore + " points." );
            if ( score < maxscore ) System.out.println( "Keep working on it - you can fix the bugs!" );
            else System.out.println( "You rock -- a perfect score!" );
        } catch(Exception e) {
            System.out.println( "     Unable to complete test program because " );
            System.out.println( "     Exception thrown: " + e.getClass().getSimpleName() );
            System.out.println( "     Use the debugger to figure out what is going on.");
            System.out.println( "     Your score before the exception was thrown was " + score);
        }
    }

}
