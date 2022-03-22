public class EncryptionProtocols {

	//---  Constants   ----------------------------------------------------------------------------
	
	private static final int CEREBUS_ONE = 18;
	private static final int CEREBUS_TWO = 31;
	private static final int CEREBUS_INIT_VALUE = 32;
	private static final int CEREBUS_ALPH_SIZE = 128;
	
	private static final int[] OUROBOROS_ONE = new int[] {3, 1, 0, 2};
	private static final int[] OUROBOROS_TWO = new int[] {2, 5, 4, 1, 3, 0};
	
	/* NOTE: Do not concern yourself too much with the actual implementation of these encryption protocols.
	 * Instead, realize once the encryption constants have been determined, each protocol shares the
	 * same API for encryption/decryption. That is, they all take a single String as input. 
	 */
	
	
	//---  Cerebus   ------------------------------------------------------------------------------
		
	private static String encryptCerebus(int am, String in) {
		StringBuilder out = new StringBuilder();
		String use = in.toLowerCase();
		for(char a : use.toCharArray()) {
			out.append((char)(((a + am - CEREBUS_INIT_VALUE) % CEREBUS_ALPH_SIZE) + CEREBUS_INIT_VALUE)+"");
		}
		return out.toString();
	}
	
	private static String decryptCerebus(int am, String in) {
		StringBuilder out = new StringBuilder();
		String use = in.toLowerCase();
		for(char a : use.toCharArray()) {
			out.append((char)(((a - am  - CEREBUS_INIT_VALUE + CEREBUS_ALPH_SIZE) % CEREBUS_ALPH_SIZE) + CEREBUS_INIT_VALUE)+"");
		}
		return out.toString();
	}
	
	public static String encryptCerebusOne(String in) {
		return encryptCerebus(CEREBUS_ONE, in);
	}
	
	public static String encryptCerebusTwo(String in) {
		return encryptCerebus(CEREBUS_TWO, in);
	}

	public static String decryptCerebusOne(String in) {
		return decryptCerebus(CEREBUS_ONE, in);
	}
	
	public static String decryptCerebusTwo(String in) {
		return decryptCerebus(CEREBUS_TWO, in);
	}
		
	//---  Ouroboros   ----------------------------------------------------------------------------
		
	private static String encryptOuroboros(int[] am, String in) {
		StringBuilder out = new StringBuilder();
		String use = in + new String(new char[am.length - (in.length() % am.length)]).replace("\0", " ");
		for(int i = 0; i < use.length(); i += am.length) {
			char[] next = new char[am.length];
			for(int j = 0; j < am.length; j++) {
				next[j] = use.charAt(i + am[j]);
			}
			out.append(new String(next));
		}
		return out.toString();
	}
	
	private static String decryptOuroboros(int[] am, String in) {
		StringBuilder out = new StringBuilder();
		String use = in+"";
		for(int i = 0; i < use.length(); i += am.length) {
			char[] next = new char[am.length];
			for(int j = 0; j < am.length; j++) {
				next[am[j]] = use.charAt(i + j);
			}
			out.append(new String(next));
		}
		return out.toString();
	}
	
	public static String encryptOuroborosOne(String in) {
		return encryptOuroboros(OUROBOROS_ONE, in);
	}
	
	public static String encryptOuroborosTwo(String in) {
		return encryptOuroboros(OUROBOROS_TWO, in);
	}
	
	public static String decryptOuroborosOne(String in) {
		return decryptOuroboros(OUROBOROS_ONE, in);
	}

	public static String decryptOuroborosTwo(String in) {
		return decryptOuroboros(OUROBOROS_TWO, in);
	}
		
}
	
