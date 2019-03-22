package common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Util {
	   /**
	    * �н����� hash
	    * @param str:  hash ȭ ��ų ���ڿ�
	    * @param algorithm : hash �˰���
	    * @return
	    */
	   public static String getHash(String str, String algorithm) {
	      String hex = "";
	      try {
	         byte[] buffer = str.getBytes();
	         MessageDigest md = MessageDigest.getInstance(algorithm);
	         md.update(buffer);
	         byte[] digest = md.digest();
	         for(int i = 0 ; i < digest.length ; i++) {
	            int b = digest[i];
	            String toHex = Integer.toHexString(b);
	            if (toHex.length() < 2) {
	               toHex = "0" +toHex;
	            } else {
	               toHex = toHex.substring(toHex.length()-2);
	            }
	            hex += toHex;
	         }
	      } catch(NoSuchAlgorithmException e) {
	         System.out.println("����");
	      }
	      return hex;
	   }
}
