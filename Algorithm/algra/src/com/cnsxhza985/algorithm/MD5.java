package com.cnsxhza985.algorithm;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author wangfan
 * @since 2014-02-14
 * 
 * MD5 algorithm
 *
 * <ul>
 *   <li> <p><b>MD5</b> -- if a string is md5ed, we can got an 32 digit hexadecimal number.different string will got different 32 digit hexadecimal number</p>
 *   	  <p><b>wiki-exlain1</b> -- The MD5 message-digest algorithm is a widely used cryptographic hash function producing a 128-bit (16-byte) hash value, typically expressed in text format as a 32 digit hexadecimal number. MD5 has been utilized in a wide variety of cryptographic applications, and is also commonly used to verify data integrity.</p>
 * </ul>
 *  */
public class MD5 {
	
	/**
	 * get 32 digit hexadecimal number from a string
	 * @param param
	 * @return
	 */
	public static String md5String(String param) {
		return md5ByteArray(param.getBytes());
    }

	/**
	 * get 32 digit hexadecimal number from bytearray 
	 * @param bytes 
	 * @return
	 */
   public static String md5ByteArray(byte[] bytes){
	   MessageDigest md = null;
	   byte[] b = null;
	   StringBuffer buf = null;
	   int i = 0;
	   try {
			md = MessageDigest.getInstance("MD5");
			md.update(bytes);
			b = md.digest();
			buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			return buf.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return "";
		}finally{
			md = null;
			b =null;
		}
	   
   }
   
   /**
    * get 32 digit hexadecimal number from a local file.
    * eg. "/Users/wangfan/Desktop/123.txt"
    * @param localFilePath
    * @return
    */
   public static String md5LocalFile(String localFilePath) {
	   
       InputStream fis;

       byte[] buffer = new byte[1024];
       
       byte[] b = null;

       int numRead = 0;

       MessageDigest md5;
       
       int i = 0;
       
       StringBuffer buf = null;

       try{

           fis = new FileInputStream(localFilePath);

           md5 = MessageDigest.getInstance("MD5");

           while((numRead=fis.read(buffer)) > 0) {

               md5.update(buffer,0,numRead);

           }

           fis.close();
           
           b = md5.digest();
		   buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			return buf.toString();

       } catch (Exception e) {
    	   e.printStackTrace();
           return "";
       }
   }

   /**
    * get 32 digit hexadecimal number from a net file.
    * eg. "http://www.baidu.com/img/bdlogo.gif"
    * @param url
    * @return
    */
   public static String md5NetFile(String url) {
	   
       InputStream fis;

       byte[] buffer = new byte[1024];
       
       byte[] b = null;

       int numRead = 0;

       MessageDigest md5;
       
       int i = 0;
       
       StringBuffer buf = null;

       try{

    	   URL mUrl = new URL(url);
    	   
    	   fis = mUrl.openStream();

    	   md5 = MessageDigest.getInstance("MD5");

           while((numRead=fis.read(buffer)) > 0) {

               md5.update(buffer,0,numRead);

           }

           fis.close();
           
           b = md5.digest();
		   buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			return buf.toString();

       } catch (Exception e) {
    	   e.printStackTrace();
           return "";
       }
   }   
}
	
