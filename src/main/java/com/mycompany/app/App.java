package com.mycompany.app;
import java.util.ArrayList;
/**
 * Hello world!
 *
 */
public class App 
{
public static int search(ArrayList<Integer> array1,ArrayList<Integer> array2,ArrayList<Integer> array3, int e) {
	        System.out.println("inside search");
	        if (array1 == null&&array2 == null&&array3 == null) return 0;
	        int sum=0;
	        if (array1 != null){
		        for (int elt : array1) {
		          if (elt == e){
		        	  sum++;
		          }
		        }
	        }
	        if (array2 != null){
		        for (int elt2: array2) {
			          if (elt2 == e){
			        	  sum++;
			          }
			    }
	        }
	        if (array3 != null){
	        for (int elt3 : array3) {
		          if (elt3 == e) {
		        	  sum++;
		          }
		        }
	        }
	        return sum;
	      }
}
