package chap3;

import static org.junit.Assert.assertEquals;
import static junitparams.JUnitParamsRunner.$;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class MoneyParameterizedTest {
	
	/*
	private static final Object[] getMoney() {
		return new Object[] {
			new Object[] {10, "USD"},
			new Object[] {15, "EUR"}
		};
	}
	*/
	
	// $ notation is less verbose, but doesn't accept null values as parameters
	private static final Object[] getMoney() {
		return $(
			$(10, "USD"),
			$(15, "EUR")
		);
	}
	
	@Test
	@Parameters(method = "getMoney")
	public void constructorShouldSetAmountAndCurrency(int amount, String currency) {
		Money money = new Money(amount, currency);
		
		assertEquals(amount, money.getAmount());
		assertEquals(currency, money.getCurrency());
	}
}
