package emailTest;
import java.util.Random;


public class emailUtil {


	/**
	 * 6������ ������ �ڵ常��� (���ڷθ�)
	 * @return
	 */
	public static String generate_accessCode() {
		String rtn = "";
		Random random = new Random();
		for (int i = 0; i < 6; i++) {
			rtn += "" + random.nextInt(10);
		}
		return rtn;
	}


}



















































