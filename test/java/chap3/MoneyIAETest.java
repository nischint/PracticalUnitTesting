package chap3;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class MoneyIAETest {

	private static final int VALID_AMOUNT = 5;
	private static final String VALID_CURRENCY = "USD";

	private static final Object[] getInvalidAmount() {
		return new Integer[][] { { -12 }, { -1234 }, { -45123 } };
	}

	@Test(expected = IllegalArgumentException.class)
	@Parameters(method = "getInvalidAmount")
	public void constructorShouldThrowIAEForInvalidAmount(int invalidAmount) {
		Money money = new Money(invalidAmount, VALID_CURRENCY);
	}
	
	private static final Object[] getInvalidCurrency() {
		return new String[][] {{null},{""}};
	}
	
	@Test(expected = IllegalArgumentException.class)
	@Parameters(method = "getInvalidCurrency")
	public void constructorShouldThrowIAEForInvalidCurrency(String invalidCurrency){
		Money money = new Money(VALID_AMOUNT, invalidCurrency);
	}
}
