package com.mycompany.app;
import java.util.ArrayList;
import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;


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
    public static void main(String[] args) {
        port(getHerokuAssignedPort());

        get("/", (req, res) -> "Hello, World");

        post("/compute", (req,res) -> {
          //System.out.println(req.queryParams("input1"));
          //System.out.println(req.queryParams("input2"));
	  String input1 = req.queryParams("input1");
	  String input2 = req.queryParams("input2");
	  String input3 = req.queryParams("input3");
          java.util.Scanner sc1 = new java.util.Scanner(input1);
	  java.util.Scanner sc2 = new java.util.Scanner(input2);
	  java.util.Scanner sc3 = new java.util.Scanner(input3);
          sc1.useDelimiter("[;\r\n]+");
	  sc2.useDelimiter("[;\r\n]+");
	  sc3.useDelimiter("[;\r\n]+");
          java.util.ArrayList<Integer> inputList1 = new java.util.ArrayList<>();
	  java.util.ArrayList<Integer> inputList2 = new java.util.ArrayList<>();
          java.util.ArrayList<Integer> inputList3 = new java.util.ArrayList<>();
          while (sc1.hasNext())
          {
            int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
            inputList1.add(value);
          }
          System.out.println(inputList1);
	  while (sc2.hasNext())
          {
            int value = Integer.parseInt(sc2.next().replaceAll("\\s",""));
            inputList2.add(value);
          }
          System.out.println(inputList2);
	  while (sc3.hasNext())
          {
            int value = Integer.parseInt(sc3.next().replaceAll("\\s",""));
            inputList3.add(value);
          }
          System.out.println(inputList3);

          String input4 = req.queryParams("input4").replaceAll("\\s","");
          int input4AsInt = Integer.parseInt(input4);

          int result = App.search(inputList1, inputList2,inputList3,input4AsInt);

          Map map = new HashMap();
          map.put("result", result);
          return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());


        get("/compute",
            (rq, rs) -> {
              Map map = new HashMap();
              map.put("result", "not computed yet!");
              return new ModelAndView(map, "compute.mustache");
            },
            new MustacheTemplateEngine());
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }


}
