
public class CryptoManager {

	public static boolean main(String[] args) {
		return false;
		
	//* In this program the Bellaso Cipher is used to encrypt a string in this approach. 
	//	Which eventually returns.
	// programmed by Angel Agyei
	}


	  private static final char LOWER_BOUND=' ' ;
      private static final char UPPER_BOUND='_';
      private static final int RANGE=UPPER_BOUND-LOWER_BOUND+1;

      /**This method determines if the string is within the allowable bounds of ASCII codes
       * according to the LOWER_BOUND and UPPER_BOUND characters**/
      public static boolean stringInBounds(String plainText)
      {
              for(int i=0;i<plainText.length();i++)
              {
                      //Check if not character falls in the bound
                      if(!(plainText.charAt(i)>=LOWER_BOUND && plainText.charAt(i) <=UPPER_BOUND))
                              return false;
              }
              return true;
      }

      /**Encrypts string according to caesar cipher. **/
      public static String encryptCaesar(String plainText, int key)
      {
              String encryptedStr="";

              for (int i=0; i<plainText.length(); i++)
              {
                      if (Character.isUpperCase(plainText.charAt(i)))
                      {
                              char ch = (char)(((int)plainText.charAt(i) +
                                              key - 65) % 26 + 65);
                              encryptedStr+=ch;
                      }
                      else
                      {
                              char ch = (char)(((int)plainText.charAt(i) +
                                              key - 97) % 26 + 97);
                              encryptedStr+=ch;
                      }
              }

              return encryptedStr;
      }

      /**Encrypts a string according to the Bellaso Cipher **/
      public static String encryptBellaso(String plainText, String bellasoStr)
      {
              String encryptedStr = "";
              for (int i = 0, j = 0; i < plainText.length(); i++)
              {
                      char c = plainText.charAt(i);
                      if (c < 'A' || c > 'Z')
                              continue;
                      encryptedStr += (char) ((c + bellasoStr.charAt(j) - 2 * 'A') % 26 + 'A');
                      j = ++j % bellasoStr.length();
              }
              return encryptedStr;
      }

      /** Decrypts a string according to Caesar cipher**/
      public static String decryptCaesar(String encryptedText, int key)
      {
              String decryptedMessage = "";

              for(int i = 0; i < encryptedText.length(); ++i){
                      char ch = encryptedText.charAt(i);
                      if(ch >= 'a' && ch <= 'z'){
                              ch = (char)(ch - key);

                              if(ch < 'a'){
                                      ch = (char)(ch + 'z' - 'a' + 1);
                              }

                              decryptedMessage += ch;
                      }
                      else if(ch >= 'A' && ch <= 'Z'){
                              ch = (char)(ch - key);

                              if(ch < 'A'){
                                      ch = (char)(ch + 'Z' - 'A' + 1);
                              }

                              decryptedMessage += ch;
                      }
                      else {
                              decryptedMessage += ch;
                      }
              }
              return decryptedMessage;

      }


      public static void main1(String args[])
      {
              String test="TEST";
              System.out.println(stringInBounds(test));
              test="HAVEANICEDAY";
              String encryptedStr=encryptCaesar(test, 4);
              System.out.println("Encrypted String:"+encryptedStr);
              System.out.println("Decrypted String:"+decryptCaesar(encryptedStr, 4));
              System.out.println(encryptBellaso(test, "BELLASOCIPHER"));
      
	}// end of class

}// end of main
