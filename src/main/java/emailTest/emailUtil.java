package emailTest;
import java.util.Random;


public class emailUtil {


	/**
	 * 6글자의 엑세스 코드만들기 (숫자로만)
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



















































