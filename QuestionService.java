import java.util.*;
public class QuestionService {
    Question[] questions = new Question[5];
    String selection[] = new String[5];
    public QuestionService(){
        questions[0] = new Question(1, "What makes java platform independent?", "jvm", "code", "nothing", "compiler", "jvm");
        questions[1] = new Question(2, "What's the latest jdk version?", "17", "21", "24", "30", "24");
        questions[2] = new Question(3, "What does it mean by method overloading?", "same method signature and body", "same method name but different para or type", "option1", "none of the above", "same method name but different para or type");
        questions[3] = new Question(4, "What makes java reusable?", "jvm", "code", "functions", "compiler", "functions");
        questions[4] = new Question(5, "Java is which type of lang?", "procedural", "functional", "object oriented", "none of the above", "object oriented");
    }

    public void playQuiz(){
        int i = 0;
        for(Question q : questions){
           System.out.println("Question no. : " + q.getId());
           System.out.println(q.getQuestion());
           System.out.println(q.getOpt1());
           System.out.println(q.getOpt2());
           System.out.println(q.getOpt3());
           System.out.println(q.getOpt4());
           Scanner scn = new Scanner(System.in);
           selection[i] = scn.nextLine();
           i++;
        }
        
        for(String s : selection){
            System.out.println(s);
        }
    }
    public void printScore(){
        int score = 0;
        for(int i = 0; i < (questions.length); i++){
            Question que = questions[i];
            String actualAnswer = que.getAnswer();
            String userAnswer = selection[i];
            if(actualAnswer.equals(userAnswer)){
                score++;
            }
        }
        System.out.println("Your score is: " + score);
    }
}
