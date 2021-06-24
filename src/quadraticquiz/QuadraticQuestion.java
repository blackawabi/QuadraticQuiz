/**
 * CSCI1130 Assignment 3 Quadratic Quiz
 * 
 * I declare that the assignment here submitted is original
 * except for source material explicitly acknowledged,
 * and that the same or closely related material has not been
 * previously submitted for another course.
 * I also acknowledge that I am aware of University policy and
 * regulations on honesty in academic work, and of the disciplinary
 * guidelines and procedures applicable to breaches of suck
 * policy and regulations, as contained in the website.
 * 
 * University Guideline on Academic Honesty:
 *   http://www.cuhk.edu.hk/policy/academichonesty
 * Faculty of Engineering Guidelinmes to Academic Honesty:
 *   https://www.erg.cuhk.edu.hk/erg/AcademicHonesty
 * 
 * Student Name: Pau Chun Wai
 * Student ID  : 1155136412
 * Date        : 23/10/2020
 */
package quadraticquiz;

import static java.lang.Integer.parseInt;
import javax.swing.JOptionPane;
import java.util.Random;
import java.io.*;
/**
 * @author Chun Wai PAU <1155136412@link.cuhk.edu.hk>
 * @version 1.0
 * @since 22/10/2020
 */
public class QuadraticQuestion {
    private String questionName;
    private int numOfRoots;
    private int root1,root2;
    private final int A=1;
    private int B,C;
    /**
     * first constructor for 2 real roots
     * @param title, the question title head e.g Q.1, Trial 1
     * @param r1, root 1 of the equation
     * @param r2, root 2 of the equation
     */
    public QuadraticQuestion(String title, int r1, int r2){      
        questionName=title;
        numOfRoots=2;
        if(r1<-5||r1>5||r2<-5||r2>5){
            root1=1;
            root2=2;
        }
        else {
            root1=r1;
            root2=r2;
        }

        B=-(root1+root2);
        C=root1*root2;
    }
    /**
     * second constructor for 1 real root
     * @param title, the question title head e.g Q.1, Trial 1
     * @param r, the root of the equation
     */
    public QuadraticQuestion(String title, int r){
        questionName=title;
        numOfRoots=1;
        root1=(r<-5||r>5)?1:r;
        root2=(r<-5||r>5)?1:r;
        B=-(root1+root2);
        C=root1*root2;
        
    }
    /**
     * third constructor for no real root
     * @param title, the question title head e.g Q.1, Trial 1 
     */
    public QuadraticQuestion(String title){
        questionName=title;
        numOfRoots=0;
        root1=-10;
        root2=-10;
        do{
            Random rngObj = new Random(); 
            B=rngObj.nextInt(21)- 10; 
            C=rngObj.nextInt(50)+1;
        }while(B*B-4*A*C>=0);
        
    }
    /**
     * Exception handling, Validate whether the input can be accepted in my plan or in the execution file
     * @param input, the user input in getUserInputAnswer()
     * @throws IOException when user input outside of 0,1,2 or null
     */
    public void inputValidate(String input)throws IOException{ 
        if(!(input==null) && !("1".equals(input)) && !("2".equals(input)) && !("0".equals(input)))
            throw new IOException();
    }
    
    /**
     * a method for receiving user's answer by JOptionPane
     * @return the answer input by user
     */
    public String getUserInputAnswer() {
        String response,questionMessage=questionName+": ";
        String question="x^2";
        if (B==1)question+="+x";
        else if(B==-1)question+="-x";
        else if (B>0)question+="+"+B+"x";
        else if (B<0)question+=B+"x";
        //B don't show up if equal 0
        
        if (C>0)question+="+"+C+" = 0";
        else if(C<0)question+=C+" = 0";
        //C don't show up if equal 0
        
        questionMessage+=question+", how many real roots?";
        System.out.print(question+", "+numOfRoots+" real roots");
        if(numOfRoots==2)System.out.println(": "+root1+", "+root2);
        else if (numOfRoots==1) System.out.println(": "+root1);
        else System.out.println(".");
        do{
            try{       
                response=JOptionPane.showInputDialog(questionMessage    
                    ,"<type answer [0-2] here>");
                
                if (!questionName.contains("Trial")) //No need to validate Trial question's input
                inputValidate(response);
            }
            catch(IOException io_exception_object_ref){
                response="-1";            
            }
        }while(response==null);
        return response;
    }
    /**
     * Check whether the user input is the correct answer
     * @param response, the user input in method getUserInputAnswer()
     * @return whether true or false depending the answer comparison
     */
    public boolean checkAnswer(String response){
        return parseInt(response)==numOfRoots;
    }
    
}
