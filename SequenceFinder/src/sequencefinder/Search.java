package sequencefinder;

/**
 *
 * @author KusyMat
 */
public class Search {
    
     public static String search (String sequence, String lookedFor) {
        // We are cutting long sequence into smaller fragments in places where 
        // are lookedFor sequences. Table between contains fragments of long 
        // sequence which are located between the places where lookFor sequences are        
        String[] between = sequence.split(lookedFor);
        // Here will be targeted sequence with marked places of lookedFor sequence
        String inResult = "";
        // If atleast 1 lookedFor is found the table between contains atleast 2 fragments
        if (between.length > 1) {
            // We take next fragments which are present between places of lookedFor sequence
            //until the one before last
            
            for(int i = 0; i < between.length - 1 ; i++ ) {
                // We are adding "|" to the result, lookedFor sequence which is present
                // in this place, another mark "|" and next fragment of long sequence
                // In the first place of lookedFor presence we need to add previous fragment
                if (inResult.length()==0)
                    inResult = inResult + between[i] + "|" + lookedFor + "|" + between[i+1];
                    
                else 
                    inResult = inResult + "|" + lookedFor + "|" + between[i+1];
                    
            }
            // We need to add this if the lookedFor sequence is present at the end
            //of long sequence
            if (sequence.indexOf(lookedFor, sequence.length()-lookedFor.length()) > 0) {
                inResult = inResult + "|" + lookedFor + "|";
            }
        }
        // If lookedFor sequence is not found, we are returning sequence without 
        // any changes
        else {
            inResult = sequence;
        }
        return inResult;
        
    }
}

