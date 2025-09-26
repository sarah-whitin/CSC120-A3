import java.util.Scanner;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

class Conversation {

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

   /**
   * Gives appropriate response (mirrored or canned) to user input
   * @param inputString the users last line of input
   * @return mirrored or canned response to user input  
   */
  public String response(String input){
    // check for the following
    // * I -> you
    // * me -> you
    // * am -> are
    // * you -> I
    // * my -> your
    // * your -> my
    boolean containsWord = 
    input.contains("I")||
    input.contains("i")||
    input.contains("me")||
    input.contains("Me")||
    input.contains("am")||
    input.contains("Am")||
    input.contains("you")||
    input.contains("You")||
    input.contains("my")||
    input.contains("My")||
    input.contains("your")||
    input.contains("Your");
    ;

    // if does not contain the trigger words:
    if (containsWord == false){
      int max = 5;
      int min = 0;
      int range = max - min + 1;
      
      int rand = (int)(Math.random() * range) + min;
      // getting that string from the array

      String respo = this.phrases[rand];
      return respo;
    }

    // if it does contain the trigger words
    else {
      // dict of replacements
      Dictionary<String, String> d = new Hashtable<>();
      d.put("I", "you");
      d.put("i", "you");
      d.put("me", "you");
      d.put("Me", "You");
      d.put("am", "are");
      d.put("Am", "Are");
      d.put("are", "am");
      d.put("Are", "Am");
      d.put("you", "I");
      d.put("You", "I");
      d.put("my", "your");
      d.put("My", "Your");
      d.put("your", "my");
      d.put("Your", "My");

    // split into words
      String regex = "[,\\.\\s]";
      String[] words = input.split(regex);


    // replace word
      for (int i=0; i < words.length; i++){
        String word = words[i];
        if (d.get(word) != null){
          words[i] = d.get(word);
        }
      }

    // put back into a string and return
    String response = String.join(" ", words);
    return response;}}

  public String bye(){// defining the range 
    int max = 3;
    int min = 0;
    int range = max - min + 1;
    
    int rand = (int)(Math.random() * range) + min;
    // getting that string from the array

    String respo = this.goodbyes[rand];
    return respo;};

  public String chat() {
    Scanner input = new Scanner(System.in);

    // ask for how many chats you want
    System.out.println("How many rounds of chatting do you want? Type numbers only:");
    int rounds = input.nextInt();

    String transcript = new String();
    String stringRounds = String.valueOf(rounds);

    transcript = transcript + "How many rounds of chatting do you want? Type numbers only:" + "\n";
    transcript = transcript + stringRounds + "\n";

    String stringStart = "We will chat for "+rounds+" rounds. Use correct grammar.";
    System.out.println(stringStart);
    transcript = transcript + stringStart;
    // what to do if someone types in not a number?

    int counter = 0;
    // while True
    while (true){
      String userInput = input.nextLine();
      transcript = transcript + userInput + "\n";

      // give a print statement 
      String respo = this.response(userInput);
      System.out.println(respo);

      transcript = transcript + respo + "\n";

      // add to counter
      counter = counter+1;
      if (counter == rounds+1){
        String bye = this.bye();
        System.out.println(bye);
        transcript = transcript + bye + "\n";
        return transcript;
      }
    }
  }
    // gets user input
    // responds that many time

  /**
   * Prints transcript of conversation
   */
  public void printTranscript(String transcript) {
    System.out.println("\nTRANSCRIPT:\n");
    System.out.println(transcript);
  }

  public static void main(String[] arguments) {
    String [] goodbyes = {"See ya", "Bye-bye", "Bye now", "Catch ya later!"};

    String [] phrases = {"Whoa", "Yeah ...", "Hm-mm", "I see", "Understood", "Heh"};

    Conversation myConversation = new Conversation(goodbyes,phrases);
    String transcript = myConversation.chat();
    myConversation.printTranscript(transcript);

  }
}
