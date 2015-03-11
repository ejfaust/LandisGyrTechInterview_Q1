import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Eric Faust
 */
public class Question_one {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter integer: ");
        try{
        	//read an integer count from the console
            int i = Integer.parseInt(br.readLine());
            
            printEachInstance(i);
        }catch(NumberFormatException nfe){
            System.err.println("Invalid Format!");
        }
	}//end main
	
	/**
	 * Takes the input count and generates that number of random double precision floating point numbers.
	 * Counts how many times the first decimal place occurs in the sequence. Prints out each digit and the
	 * number of times it occurred in ascending order of the number of times it occurred.
	 * 
	 * @param count number of random values to generate
	 */
	public static void printEachInstance(int count) {
		List<RandGeneratedValue> list = new ArrayList<RandGeneratedValue>();
		for(int i = 0; i < count; i++) {
			Double rand = Math.random();
			RandGeneratedValue rdv = new RandGeneratedValue();
			
			//Store the randomly generated value
			rdv.setRandValue(rand);
			
			//Determine the first decimal place value
			int firstDecimal = (int) (rand * 10);
			rdv.setFirstDecimal(firstDecimal);
			
			//Determine the number of instances of the first decimal place value
			String regexString = "[^"+ rdv.getFirstDecimal() + "]*";
			String randStr = rdv.getRandValue().toString();
			int instancesOfFirstDecimal = randStr.replaceAll(regexString, "").length();
			rdv.setDigitCount(instancesOfFirstDecimal);
			
			list.add(rdv);
		}
		
		//Sort the list in ascending order of number of instances
		Collections.sort(list, new Comparator<RandGeneratedValue>() {
	        @Override public int compare(RandGeneratedValue p1, RandGeneratedValue p2) {
	            return p1.getDigitCount() - p2.getDigitCount(); // Ascending
	        }
	    });

		//Output the list
		for (int j = 0; j < list.size(); j++) {
			//System.out.println("Random value generated = " + list.get(j).getRandValue());
			System.out.println("First decimal = " + list.get(j).getFirstDecimal());
			System.out.println("Number of instances of first decimal = " + list.get(j).getDigitCount());
			System.out.println("=-=-=-=-=-=-=-=-=-=-=");
		}
	}//end printEachInstance method

}//end Question_one class

