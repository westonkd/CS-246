/**
 * A highly special class with a narrowly focused purpose.
 */
public class Generation {
	/**
	* Name of this generation's father
	*/
	String genFather;

	/**
	* Name of first son in generatin
	*/
	String genSon;

	/**
	* variables containg information about father's age.
	* all default to 0.
	*/
	String yearsBeforeBirth;
	String yearsAfterBirth;
	String totalYears;

	/**
	* Non-default constructor
	* Constructor sets the father and son's names
	*/
	Generation(String father, String son) {
		setFather(father);
		setSon(son);
	}

	Generation(String dataString) {
		
	}

	/**
	* setFather
	* set the name of the generation's fatehr
	*/
	public void setFather(String name) {
		genFather = name;
	}

	/**
	* getFather
	* get the name of the generation's fatehr
	*/
	public String setFather() {
		return genFather;
	}

	/**
	* setSon
	* set the name of the son
	*/
	public void setSon(String name) {
		genSon = name;
	}

	/**
	* getSon
	* get the name of the son
	*/
	public String getSon() {
		return genSon;
	}

	/**
	* setYearsBefore
	* set the number of years the father
	* lived before the birth of genSon
	*/
	public boolean setYearsBefore(String yearsBefore) {
		//TODO check for valid year
		yearsBeforeBirth = yearsBefore;
		return true;
	}

	/**
	* getYearsBefore
	* get the number of years the father
	* lived before the birth of genSon
	*/
	public String getYearsBefore() {
		return yearsBeforeBirth;
	}

	/**
	* setYearsAfter
	* set the number of years the father
	* lived after the birth of genSon
	*/
	public boolean setYearsAfter(String yearsAfter) {
		//TODO check for valid year
		yearsAfterBirth = yearsAfter;
		return true;
	}

	/**
	* getYearsAfter
	* get the number of years the father
	* lived after the birth of genSon
	*/
	public String getYearsAfter() {
		return yearsAfterBirth;
	}

	/**
  * displayGeneration
  * Paramaters: dataString - string of data to add to verse
  *             starVerse - number of first verse
  * Returns:    number of the last verse displayed as an int
  *
  * This function parses a data string and displays the 
  * data in the context of a verse of scripture
  */
  public int displayGeneration(String dataString, int startVerse) {
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
