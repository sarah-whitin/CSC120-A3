import java.util.Scanner;
import java.lang.Math;

class Conversation implements ConversationRequirements {

  // Attributes
  String [] goodbyes;

  String [] phrases;

  /**
   * Constructor 
   */
  Conversation(String [] g, String [] p) {
    this.goodbyes = g;
    this.phrases = p;
  }

  public String response(){
    // defining the range 
    int max = 5;
    int min = 0;
    int range = max - min + 1;
    
    int rand = (int)(Math.random() * range) + min;
    // getting that string from the array

    String respo = this.phrases[rand];
    return respo;
  };

  public String bye(){// defining the range 
    int max = 3;
    int min = 0;
    int range = max - min + 1;
    
    int rand = (int)(Math.random() * range) + min;
    // getting that string from the array

    String respo = this.goodbyes[rand];
    return respo;};

  public void chat() {
    Scanner input = new Scanner(System.in);

    // ask for how many chats you want
    System.out.println("How many rounds of chatting do you want?");
    int rounds = input.nextInt();

    // what to do if someone types in not a number?

    int counter = 0;
    // while True
    while (true){
      // get an input
      String userInput = input.nextLine();

      // give a print statement 
      String respo = this.response();
      System.out.println(respo);

      // add to counter
      counter = counter+1;
      if (counter == rounds+1){
        String bye = this.bye();
        System.out.println(bye);
        break;
      }
      // when counter == rounds
        // break
    }
    

  }
    // gets user input
    // responds that many time

  /**
   * Prints transcript of conversation
   */
  public void printTranscript() {

  }

  /**
   * Gives appropriate response (mirrored or canned) to user input
   * @param inputString the users last line of input
   * @return mirrored or canned response to user input  
   */
  public String respond(String inputString) {
    String returnString = ""; 
    return returnString; 
  }

  public static void main(String[] arguments) {
    String [] goodbyes = {"See ya", "Bye-bye", "Bye now", "Catch ya later!"};

    String [] phrases = {"Whoa", "Yeah ...", "Hm-mm", "I see", "Understood", "Heh"};

    Conversation myConversation = new Conversation(goodbyes,phrases);
    myConversation.chat();
  //  myConversation.printTranscript();

  }
}
