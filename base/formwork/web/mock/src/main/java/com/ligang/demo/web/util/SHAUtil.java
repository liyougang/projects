package com.ligang.demo.web.util;

import java.security.MessageDigest;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

public class SHAUtil {
	
	public static final String DIGEST_ALGORITHM = "SHA-512";
	
	
	/**
	 * 用SHA-512算法计算摘要
	 * 
	 * @param contents 加签数据
	 * @return 加签串
	 * @throws Exception
	 */
	public static String digest(byte[] contents) throws Exception {
		MessageDigest messageDigest = MessageDigest.getInstance(DIGEST_ALGORITHM);
		byte[] digestbyte = messageDigest.digest(contents);
		return new String(Hex.encodeHex(digestbyte));
	}
	
	
	/**
	 * 用SHA-512算法计算摘要
	 * 
	 * @param contents 加签数据(Base64字符串)
	 * @return 加签串
	 * @throws Exception
	 */
	public static String digest(String contents) throws Exception {
		MessageDigest messageDigest = MessageDigest.getInstance(DIGEST_ALGORITHM);
		
		byte[] digestbyte = messageDigest.digest(Base64.decodeBase64(contents));
		return new String(Hex.encodeHex(digestbyte));
	}
	

}
