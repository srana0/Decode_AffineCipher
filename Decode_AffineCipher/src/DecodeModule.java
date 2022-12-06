/**
* The Program will analyze the ciphertext and produce plaintext
* 
*
* @author  SUBHABRATA RANA
* @version 1.0
* @since   2022-10-13
* @assignment : 01 
*/
import java.math.*;;

public class DecodeModule {
   
     private static int module = 26;
    
	public static void main(String[] args) {
	
		String plaintext="";
	
		String cipherText="KDNSWSQQKBEKQBZSCYBZSFYDKNXSNBKYNBZSNJSFZAJQAHXSFQKBEKQBZSCYBZSFYDWFEJBANAREQKQ";
		//E ( x ) = ( a x + b ) mod m , where a amd m are co-prime
		// So, value of a can be 1, 3, 5, 7, 9, 11, 15, 17, 19, 21, 23, and 25.
		// For each a, we can rotate b from 0 to 25 to see if the decrypted message makes any sense
		
		int firstKey_Array[]= {1,3,5,7,9,11,15,17,19,21,23,25};
		int firstKey=0;
		System.out.println("Decoded Message, Printing most relevent block containing actual decrypted message\n\n");
		for(int i=0;i<firstKey_Array.length;i++)
		{
			firstKey=firstKey_Array[i];
			for(int j=0;j<module;j++)
			{				
				plaintext=DecryptCiphertext(cipherText,firstKey,j);
				
				// After analysis of all blocks I came to know that when i=5, the word makes sense. 
				// Just for readability I am not printing any other values, but it can be seen the combination by printing
				// ANSWER: IFNECESSITYISTHEMOTHEROFINVENTIONTHENPERHAPSADVERSITYISTHEMOTHEROFCRYPTANALYSIS
				if(i==5)
				{
				System.out.println(plaintext);
				}				
			}
			
		}
	
	}
	

	static String DecryptCiphertext(String ciphertext,int firstKey, int secondKey) 
	{
	    StringBuilder builder = new StringBuilder();
	  
	    BigInteger inverse = BigInteger.valueOf(firstKey).modInverse(BigInteger.valueOf(module));

	    for (int i = 0; i < ciphertext.length(); i++) 
	    {
	        char character_in_Cipher = ciphertext.charAt(i);
	        if (Character.isLetter(character_in_Cipher)) 
	        {
	            int decoded_message = inverse.intValue() * (character_in_Cipher - 'A' - secondKey + module);
	            character_in_Cipher = (char) (decoded_message % module + 'A');
	        }
	        builder.append(character_in_Cipher);
	    }
	    return builder.toString();
	}
	
 
}
