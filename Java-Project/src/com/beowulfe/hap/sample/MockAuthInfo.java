package com.beowulfe.hap.sample;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.beowulfe.hap.HomekitAuthInfo;
import com.beowulfe.hap.HomekitServer;

/**
 * This is a simple implementation that should never be used in actual production. The mac, salt, and privateKey
 * are being regenerated every time the application is started. The user store is also not persisted. This means pairing
 * needs to be re-done every time the app restarts.
 *
 * @author Andy Lintner
 */
public class MockAuthInfo implements HomekitAuthInfo, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MockAuthInfo(String mac, BigInteger salt, byte[] privateKey) {
		super();
		this.mac = mac;
		this.salt = salt;
		this.privateKey = privateKey;
	}

	private static final String PIN = "123-45-678";
	
	private final String mac;
	private final BigInteger salt;
	private final byte[] privateKey;
	private final ConcurrentMap<String, byte[]> userKeyMap = new ConcurrentHashMap<>();
	
	public MockAuthInfo() throws InvalidAlgorithmParameterException {
		mac = HomekitServer.generateMac();
		//mac = "aa:bb:cc:dd:ee:ff";
		
		salt = HomekitServer.generateSalt();
		//salt = new BigInteger ("1234567890123456");
		
		privateKey = HomekitServer.generateKey();
//		privateKey = "dasinsteintest".getBytes();
		
		// System.out.println("Auth info is generated each time the sample application is started. Pairings are not persisted.");
		// System.out.println("The PIN for pairing is "+PIN);
	}

	@Override
	public String getPin() {
		return PIN;
	}

	@Override
	public String getMac() {
		return mac;
	}

	@Override
	public BigInteger getSalt() {
		return salt;
	}

	@Override
	public byte[] getPrivateKey() {
		return privateKey;
	}

	@Override
	public void createUser(String username, byte[] publicKey) {
		userKeyMap.putIfAbsent(username, publicKey);
		System.out.println("Added pairing for "+username);
		try {
			FileOutputStream fout = new FileOutputStream("Test.auth");
			ObjectOutputStream oout = new ObjectOutputStream (fout);
			oout.writeObject(this); oout.close();
			System.out.println("Saved AuthInfo");
		} catch (FileNotFoundException e) {
			System.out.println("Cannot Save AuthInfo");
		} catch (IOException e) {
			System.out.println("Cannot Save AuthInfo");
		}
	}

	@Override
	public void removeUser(String username) {
		userKeyMap.remove(username);
		System.out.println("Removed pairing for "+username);
	}

	@Override
	public byte[] getUserPublicKey(String username) {
		return userKeyMap.get(username);
	}

}