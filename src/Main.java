import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int e = -1;

        /* taking initial input requirements; */
        System.out.println("Welcome to Quiz Generator..!!");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of topics you wanted to create the quiz.. = ");
        int  noofTopics = sc.nextInt();
        sc.nextLine();

        /* creating corresponding classes to each topic with relative number of quo. */

        Generator[] quizBank = new Generator[noofTopics];

        for(int i=0;i<noofTopics;i++){
            int j= i+1;
            System.out.println("what is the name of your topic "+j);
            String tempName = sc.nextLine();
            if(i!=0){
                for(int k=0;k<i;k++){
                    if(quizBank[k].nameofQuiz.equals(tempName)){
                        System.out.println("Topic named "+ tempName+"already exists");
                        System.out.println("Please enter valid topic name");
                        e = --i;
                        break;
                    }
                }
            }
            if(i == e)
                continue;
            System.out.println("Enter the number of questions you want to add in topic :- " + tempName);
            int tempQuoCount = sc.nextInt();
            sc.nextLine();
            quizBank[i] = new Generator(tempQuoCount,tempName);

        }

        //lets take input for the questions to the topics mentioned;
        for(int i=0;i<noofTopics;i++){
            var generator = quizBank[i];
            System.out.println("Enter the Questions of the topic "+ generator.nameofQuiz+"..");
            generator.setquesOpts();
            System.out.println("Your questions has been listed to the quiz topic "+ generator.nameofQuiz);
        }

        System.out.println("Now you are all set to take quizzes that you have created.");

        int proceed = 1;
        while (proceed >= 1){
            System.out.println("select the topic number to start the specific Quiz.");
            for(int i=0;i<noofTopics;i++){
                System.out.println("Topic number :- ("+ (i+1) +") - " + quizBank[i].nameofQuiz);
            }
            System.out.println("TO EXIT PRESS 0");
            int seltopnum = sc.nextInt();
            proceed = seltopnum;
            if(proceed > 0){
                seltopnum--;
                sc.nextLine();
                System.out.println("Let us start our quiz");

                quizBank[seltopnum].getquesOpts();
            }else{
                break;
            }
        }

        System.out.println("Thankyou for using Quiz generator...!!");

    }
}