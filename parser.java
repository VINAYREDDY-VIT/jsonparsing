/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsonparser;

import java.io.*;
import java.util.ArrayList;

import org.json.simple.*;
import org.json.simple.parser.*;
/**
 *
 * @author reddy
 */
public class parser {
	static int count=1;
    public static void main(String[] krishna){
        try{
            JSONParser parser = new JSONParser();
            //getting the file from the desktop
            //location of the file "/Users/reddy/Desktop/result.json".
            Object obj = parser.parse(new FileReader("/Users/reddy/Desktop/result.json"));
            //reading the file into jsonobject.
            JSONObject jsonobject = (JSONObject)obj;
            //getting json file with tag "quiz"
            JSONObject quiz = (JSONObject)jsonobject.get("quiz");
            //getting json file with tag "maths"
            JSONObject math = (JSONObject)quiz.get("maths");
            //getting json file with tag "q1" from "maths"
            JSONObject mathq1 = (JSONObject)math.get("q1");
            connect(mathq1,"math");
            //getting json file with tag "q2" from "maths"
            JSONObject mathq2 = (JSONObject)math.get("q2");
            connect(mathq2,"math");
            //getting json file with tag "maths"
            JSONObject sport = (JSONObject)quiz.get("sport");
            //getting json file with tag "q1" from "sport"
            JSONObject sportq1 = (JSONObject)sport.get("q1");
            connect(sportq1,"sport");
            //pringting the total change in the number of rows
            System.out.print(--count);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public static void connect(JSONObject question,String subject) {
    	//extracting question, answer, and options for the question
    	String que = (String)question.get("question");
        String ans = (String)question.get("answer");
        JSONArray options = (JSONArray)question.get("options");
        ArrayList<String> arr= new ArrayList<>();
        for(int i=0;i<4;i++){
            String option = (String) options.get(i);
            arr.add(option);
        }
        dbconnection obj = new dbconnection();
        obj.add(que,ans,arr,subject);
        count++;
    }
}
