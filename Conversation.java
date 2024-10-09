import java.util.Scanner;
import java.util.Random;

/**
 * A class creating a chatbot conversation
 */
class Conversation {
  // Attributes 
  public static String[] mirrorWords = {
    "I",
    "me",
    "am",
    "you",
    "my",
    "your"
  };
  public static String[] newWords = {
    "you",
    "you",
    "are",
    "I",
    "you",
    "my"
  };
  public static String[] cannedStrings = {
    "Hmm...",
    "Interesting...",
    "Wow!",
    "I see."
  };

  // Constructor
  Conversation() {}

  // Methods

  /**
   * A method taking the input string and breaking it into individual strings that are added to an array.
   * @param response the string to be broken up
   * @return Array of the broken up strings
   */
  public static String[] splitResponse(String response) {
    String[] separated_response = response.split(" ");
    return separated_response;
  }

  /**
   * A method checking if the given array contains any of the mirror words. 
   * @param separated_response the array of strings obtained from the user's response 
   * @return T/F whether the array contains mirror words or not
   */
  public static Boolean hasPronouns(String[] separated_response) {
    int arrayLength = separated_response.length;
    for (int i = 0; i < arrayLength; i++) {
      for (int j = 0; j < 5; j++) {
        if (separated_response[i].equals(mirrorWords[j])) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * A method replacing mirror words with their corresponding replacements. 
   * @param separated_response the array of strings obtained from the user's response. 
   * @return string of the replaced words. 
   */
  public static String replaceWords(String[] separated_response) {
    int arrayLength = separated_response.length;
    String replaced_response = "";
    if (hasPronouns(separated_response) == true) {
      for (int i = 0; i < arrayLength; i++) {
        if (separated_response[i].equals(mirrorWords[0])) {
          replaced_response += newWords[0] + " ";
        } else if (separated_response[i].equals(mirrorWords[1])) {
          replaced_response += newWords[1] + " ";
        } else if (separated_response[i].equals(mirrorWords[2])) {
          replaced_response += newWords[2] + " ";
        } else if (separated_response[i].equals(mirrorWords[3])) {
          replaced_response += newWords[3] + " ";
        } else if (separated_response[i].equals(mirrorWords[4])) {
          replaced_response += newWords[4] + " ";
        } else if (separated_response[i].equals(mirrorWords[5])) {
          replaced_response += newWords[5] + " ";
        } else {
          replaced_response += separated_response[i] + " ";
        }
      }
    }
    return replaced_response;
  }

  // Main
  public static void main(String[] arguments) {
    Scanner numRounds = new Scanner(System.in);
    Scanner userResponse = new Scanner(System.in);
    Random rand = new Random();
    int rounds = -1;
    String response = "";
    String transcript = "TRANSCRIPT" + "\n";

    // Start conversation
    System.out.println("How many rounds:");
    rounds = numRounds.nextInt();
    System.out.println("Hi! What's on your mind?");
    for (int currentRound = 0; currentRound < rounds; currentRound++) {
      response = userResponse.nextLine();
      transcript += response + "\n";
      //System.out.println(splitResponse(response));
      if (hasPronouns(splitResponse(response)) == true) {
        String computer_response = replaceWords(splitResponse(response));
        System.out.println(computer_response);
        transcript += computer_response + "\n";
      } else {
        int rand_int1 = rand.nextInt(4);
        System.out.println(cannedStrings[rand_int1]);
        transcript += cannedStrings[rand_int1] + "\n";
      }
    }
    System.out.println("Goodbye!");
    transcript += "Goodbye!" + "\n";

    System.out.println(transcript);
    numRounds.close();
    userResponse.close();
  }
}