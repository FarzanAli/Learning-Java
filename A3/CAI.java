import java.util.Random;

public class CAI {
		
	//---  Constants   ----------------------------------------------------------------------------

	/** Number of distinct protocols for each encryption type*/
	private static final int SIZE_OUROBOROS_KEYS = 2;
	private static final int SIZE_CEREBUS_KEYS = 2;
		
	//---  Instance Variables   -------------------------------------------------------------------
		
	/** Index reference values for which protocol to use for each encryption type*/
	private static final int OUROBOROS_KEY_ONE = 0;
	private static final int OUROBOROS_KEY_TWO = 1;
	private static final int CEREBUS_KEY_ONE = 0;
	private static final int CEREBUS_KEY_TWO = 1;
	
	/**Assigned index reference value for which protocol the security site should use for that particular type*/
	private int securitySiteOneCerebus;
	private int securitySiteOneOuroboros;
	private int securitySiteTwoCerebus;
	private int securitySiteTwoOuroboros;
	private int securitySiteThreeCerebus;
	private int securitySiteThreeOuroboros;
		
	private Random rand;
		
	//---  Constructors   -------------------------------------------------------------------------
		
	public CAI() {
		rand = new Random();
	}	
		
	//---  Operations   ---------------------------------------------------------------------------
		
	/**
	 * Roughly simulates the CAI behaviour for assigning new encryption protocols to each security site
	 * 
	 */
	
	public void simulateCAI() {
		assignSiteOneCerebusKey(rand.nextInt(SIZE_CEREBUS_KEYS));
		assignSiteOneOuroborosKey(rand.nextInt(SIZE_OUROBOROS_KEYS));
		assignSiteTwoCerebusKey(rand.nextInt(SIZE_CEREBUS_KEYS));
		assignSiteTwoOuroborosKey(rand.nextInt(SIZE_OUROBOROS_KEYS));
		assignSiteThreeCerebusKey(rand.nextInt(SIZE_CEREBUS_KEYS));
		assignSiteThreeOuroborosKey(rand.nextInt(SIZE_OUROBOROS_KEYS));
	}
	
	/**
	 * Multitude of functions for decrypting received messages at each security site
	 * 
	 */
	
	public String receiveOuroborosMessageSiteOne(String in) {
		return decryptMessageOuroboros(securitySiteOneOuroboros, in);
	}
	
	public String receiveCerebusMessageSiteOne(String in) {
		return decryptMessageCerebus(securitySiteOneCerebus, in);
	}
	
	public String receiveOuroborosMessageSiteTwo(String in) {
		return decryptMessageOuroboros(securitySiteTwoOuroboros, in);
	}
	
	public String receiveCerebusMessageSiteTwo(String in) {
		return decryptMessageCerebus(securitySiteTwoCerebus, in);
	}
	
	public String receiveOuroborosMessageSiteThree(String in) {
		return decryptMessageOuroboros(securitySiteThreeOuroboros, in);
	}
	
	public String receiveCerebusMessageSiteThree(String in) {
		return decryptMessageCerebus(securitySiteThreeCerebus, in);
	}
	
	/**
	 * Multitude of functions for encrypting outgoing messages from security sites
	 * 
	 */

	public String sendOuroborosMessageSiteOne(String in) {
		return encryptMessageOuroboros(securitySiteOneOuroboros, in);
	}
	
	public String sendCerebusMessageSiteOne(String in) {
		return encryptMessageCerebus(securitySiteOneCerebus, in);
	}
	
	public String sendOuroborosMessageSiteTwo(String in) {
		return encryptMessageOuroboros(securitySiteTwoOuroboros, in);
	}
	
	public String sendCerebusMessageSiteTwo(String in) {
		return encryptMessageCerebus(securitySiteTwoCerebus, in);
	}
	
	public String sendOuroborosMessageSiteThree(String in) {
		return encryptMessageOuroboros(securitySiteThreeOuroboros, in);
	}
	
	public String sendCerebusMessageSiteThree(String in) {
		return encryptMessageCerebus(securitySiteThreeCerebus, in);
	}
		
	//---  Setter Methods   -----------------------------------------------------------------------
		
	/**
	 * Multitide of functions for assigning protocol type for each security site's encryption type
	 * 
	 */
	
	private void assignSiteOneCerebusKey(int type) {
		securitySiteOneCerebus = type;
	}
	
	private void assignSiteOneOuroborosKey(int type) {
		securitySiteOneOuroboros = type;
	}
	
	private void assignSiteTwoCerebusKey(int type) {
		securitySiteTwoCerebus = type;
	}
	
	private void assignSiteTwoOuroborosKey(int type) {
		securitySiteTwoOuroboros = type;
	}
	
	private void assignSiteThreeCerebusKey(int type) {
		securitySiteThreeCerebus = type;
	}
	
	private void assignSiteThreeOuroborosKey(int type) {
		securitySiteThreeOuroboros = type;
	}

	//---  Helper Methods   -----------------------------------------------------------------------
		
	/**
	 * Helper functions to smooth out the process of encrypting/decrypting messages based on the
	 * security site's current protocol for the relevant cryptographic algorithm
	 * 
	 * If unfamiliar, a switch() structure like this is equivalent to a series of if statements, where
	 * it compares the 'type' value to each case value as if it were doing:
	 * if(type == value1){
	 * }
	 * else if(type == value2){
	 * }
	 * and the default keyword is the 'else' case.
	 * 
	 */
	
	private String encryptMessageOuroboros(int type, String message) {
		switch(type) {
			case OUROBOROS_KEY_ONE:
				return EncryptionProtocols.encryptOuroborosOne(message);
			case OUROBOROS_KEY_TWO:
				return EncryptionProtocols.encryptOuroborosTwo(message);
			default:
				return null;
		}
	}
	
	private String decryptMessageOuroboros(int type, String message) {
		switch(type) {
			case OUROBOROS_KEY_ONE:
				return EncryptionProtocols.decryptOuroborosOne(message);
			case OUROBOROS_KEY_TWO:
				return EncryptionProtocols.decryptOuroborosTwo(message);
			default:
				return null;
		}
	}
	
	private String encryptMessageCerebus(int type, String message) {
		switch(type) {
			case CEREBUS_KEY_ONE:
				return EncryptionProtocols.encryptCerebusOne(message);
			case CEREBUS_KEY_TWO:
				return EncryptionProtocols.encryptCerebusTwo(message);
			default:
				return null;
		}
	}
	
	private String decryptMessageCerebus(int type, String message) {
		switch(type) {
			case CEREBUS_KEY_ONE:
				return EncryptionProtocols.decryptCerebusOne(message);
			case CEREBUS_KEY_TWO:
				return EncryptionProtocols.decryptCerebusTwo(message);
			default:
				return null;
		}
	}
		
}

