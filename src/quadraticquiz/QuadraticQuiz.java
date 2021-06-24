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
import java.util.Random;


/**
 * @author Chun Wai PAU <1155136412@link.cuhk.edu.hk>
 * @version 1.0
 * @since 22/10/2020
 */
public class QuadraticQuiz {

    public static void main(String[] args) {
        // TODO code application logic here
        boolean correct;
        int score=0;
        int x,y;
        Random rngObj = new Random(); 
        PanelDisplay scoreBoard=new PanelDisplay();
        QuadraticQuestion[] Trial = new QuadraticQuestion[3];
        QuadraticQuestion[] Question = new QuadraticQuestion[6];
        
        //Trial Section
        Trial[0]= new QuadraticQuestion("Trial 1",-2,2);
        Trial[1]= new QuadraticQuestion("Trial 2",-1);
        Trial[2]= new QuadraticQuestion("Trial 3",5,0);
        for(int i=0;i<3;i++){
            Trial[i].getUserInputAnswer();
        }
        
        for(int i=0;i<6;i++){
            x=rngObj.nextInt(11)- 5;    
            
            do{
                y=rngObj.nextInt(11)- 5;  //prevent x == y when the question type is 1
            }while (y==x);
                             
            int questionType=rngObj.nextInt(3);
            
            //6 Questions Section
            switch (questionType) {
                case 1:
                    Question[i] = new QuadraticQuestion("Q."+(int)(i+1),x);
                    break;
                case 2:
                    Question[i] = new QuadraticQuestion("Q."+(int)(i+1),x,y);
                    break;
                case 0:
                    Question[i] = new QuadraticQuestion("Q."+(int)(i+1));
                    break;
                default:
                    break;
            }
            
            correct=Question[i].checkAnswer(Question[i].getUserInputAnswer());
            if (correct)scoreBoard.setScore(++score);
        }
        System.out.println("The End");
    }
    
}
