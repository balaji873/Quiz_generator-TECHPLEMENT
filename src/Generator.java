import java.util.Scanner;

public class Generator {
    String nameofQuiz;
    int noofQuo;
    String[][] quesOpts;
    int[] ansKey;
    int seloptNum;
    int score = 0;
    int percentage;


    Scanner input = new Scanner(System.in);

    public Generator(int nuofquo, String nameofQuiz) {
        this.noofQuo = nuofquo;
        this.nameofQuiz = nameofQuiz;

        //initializing the arrays.
        quesOpts = new String[noofQuo][5];
        ansKey = new int[noofQuo];
    }


    public void  setquesOpts(){
        for(int i =0;i<noofQuo;i++){
            for(int j=0;j<5;j++){
                if(j==0){
                    System.out.println("Enter your Question "+ (i+1) +":-");
                } else {
                    System.out.println("Enter your option " + j + ":-");
                }
                quesOpts[i][j] = input.nextLine();
            }
            System.out.println("Enter the correct option number(1-4):-");
            ansKey[i] = input.nextInt();
            input.nextLine();
        }
    }

    public void getquesOpts(){
        for(int i=0;i<noofQuo;i++){
            for(int j=0;j<5;j++){
                if(j==0){
                    System.out.print("Quo "+ (i+1) +":- ");
                }else{
                    System.out.print("Option ("+j+") ");
                }
                System.out.println(quesOpts[i][j]);
            }
            System.out.println("Enter the correct option number:-");
            seloptNum = input.nextInt();
            input.nextLine();
            if(seloptNum == ansKey[i])
                this.score++;
        }
        this.getTotalScore();
    }

    public void getTotalScore(){
        System.out.println("Your score in "+ this.nameofQuiz +" quiz is: "+score+"/"+noofQuo);
        this.percentage = (score*100)/noofQuo;
        System.out.println("Your percentage is "+ this.percentage);
    }

}
