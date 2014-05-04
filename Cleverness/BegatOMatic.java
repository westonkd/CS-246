import java.text.MessageFormat; // DO NOT REMOVE!

// DO NOT ADD any other import statements, or use anything from any other package!!

/**
 * A highly special class with a narrowly focused purpose.
 */
public class BegatOMatic implements Runnable {
  /**
  * Default value for the starting verse;
  */
  protected static final int DEFAULT_STARTVERSE = 9;

  /**
  * Default value for the field separator.
  */
  protected static final String DEFAULT_FIELD_SEPARATOR = ",";

  /**
  * Default value for the record separator.
  */
  protected static final String DEFAULT_RECORD_SEPARATOR = ":";

  /**
  * Default value for the message format.
  */
  protected static MessageFormat messageFormat = new MessageFormat(
    "{0}. And {1} lived {2} years, and begat {3}:\n" +
    "{4}. And {1} lived after he begat {3} {5} years, and begat sons and daughters:\n" +
    "{6}. And all the days of {1} were {7} years: and he died.");

  /**
  * Data lookup key.
  */
  protected static final String DKEY = "data";

  /**
  * Main starts by asserting that the args array is empty.
  *
  * Enable assertions by using the -ea option with the java interpreter, e.g.
  *
  * java -ea BegatOMatic
  *
  * @param args the command-line arguments.
  */
  public static void main(String[] args) {
    assert args.length == 0 : "No args allowed!";
    new BegatOMatic().run();
  }

  // provided here just so this stub code will compile -- you must flesh it out
  public void run() {
    //data containing words to insert to verse
    String geneology = System.getProperty(DKEY);

    //loop through each generation
    int verseNum = 9;
    for (String newGeneration : geneology.split(":")) {
      //display verses for generation
      verseNum = displayVerses(newGeneration, verseNum);  
    } 
  }

  /**
  * display Verses
  * Paramaters: dataString - string of data to add to verse
  *             starVerse - number of first verse
  * Returns:    number of the last verse displayed as an int
  *
  * This function parses a data string and displays the 
  * data in the context of a verse of scripture
  */
  public int displayVerses(String dataString, int startVerse) {
    //array to hold parsed data
    String[] words = new String[8];

    //parse the data entered
    int i = 0;
    for (String nextWord : dataString.split(",")) {
      //if we are need the verse number
      if (i == 0 || i == 4 || i == 6) {
        //add the verse number
        words[i++] = Integer.toString(startVerse++);
      }

      //add the next parsed word
      words[i++] = nextWord;
    }

    //display the verses
    System.out.println(messageFormat.format(words));

    //return the last verse displayed
    return startVerse;
  }
}
