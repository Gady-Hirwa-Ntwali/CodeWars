
// Pirates have notorious difficulty with enunciating. 
// They tend to blur all the letters together and scream at people.

// At long last, we need a way to unscramble what these pirates are saying.

// Write a function that will accept a jumble of letters as well as a dictionary, 
// and output a list of words that the pirate might have meant.

// For example:

// grabscrab( "ortsp", ["sport", "parrot", "ports", "matey"] )

// Should return ["sport", "ports"].

// Return matches in the same order as in the dictionary. 
// Return an empty array if there are no matches.

import java.util.*;
import java.util.stream.Collectors;

public class Grab {
  
  public static List<String> grabscrab(String s, List<String> words){
    List<String> match = new ArrayList<String>();
    String sortedS= sortString(s); 
    for(String c: words){
      if(sortString(c).equals(sortedS)){
        match.add(c);
      }
    }
    
    return match;
  }
   private static String sortString(String input) {
    char[] chars = input.toCharArray();
    Arrays.sort(chars);
    return new String(chars);
  }

}