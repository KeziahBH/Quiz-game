public class Question {
    private int id;
    private String question;
    private String op1;
    private String opt2;
    private String opt3;
    private String opt4;
    private String answer;

    public Question(int id, String question, String op1, String opt2, String opt3, String opt4, String answer) {
        this.id = id;
        this.question = question;
        this.op1 = op1;
        this.opt2 = opt2;
        this.opt3 = opt3;
        this.opt4 = opt4;
        this.answer = answer;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
    public String getOpt1() {
        return op1;
    }
    public void setOpt1(String op1) {
        this.op1 = op1;
    }
    public String getOpt2() {
        return opt2;
    }
    public void setOpt2(String opt2) {
        this.opt2 = opt2;
    }
    public String getOpt3() {
        return opt3;
    }
    public void setOpt3(String opt3) {
        this.opt3 = opt3;
    }
    public String getOpt4() {
        return opt4;
    }
    public void setOpt4(String opt4) {
        this.opt4 = opt4;
    }
    public String getAnswer() {
        return answer;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    @Override
    public String toString() {
        return "Question [id=" + id + ", question=" + question + ", op1=" + op1 + ", opt2=" + opt2 + ", opt3=" + opt3
                + ", opt4=" + opt4 + ", answer=" + answer + "]";
    }
    

}
