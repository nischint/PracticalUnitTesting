package chap4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static junitparams.JUnitParamsRunner.$;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(JUnitParamsRunner.class)
public class FootballTeamTest {
	
	private static final Object[] getNumOfGamesWon() {
		return $(0, 1, 10);
	}
	
	private static final Object[] getIllegalNumOfGamesWon() {
		return $(-10, -1);
	}
	
	@Test
	@Parameters(method = "getNumOfGamesWon")
	public void constructorShouldSetGamesWon(int numOfGamesWon) {
		FootballTeam team = new FootballTeam(numOfGamesWon);
		assertEquals(numOfGamesWon + " games passed to constructor, but "
		+ team.getGamesWon() + " returned\n", numOfGamesWon, team.getGamesWon());
	}
	
	@Test(expected = IllegalArgumentException.class)
	@Parameters(method = "getIllegalNumOfGamesWon")
	public void constructorShouldThrowIAEForInvalidNumOfGamesWon(int illegalNumOfGamesWon) {
		FootballTeam team = new FootballTeam(illegalNumOfGamesWon);
	}
	
	private static final int ANY_NUMBER = 123;
	
	@Test
	public void shouldBePossibleToCompareTeams() {
		FootballTeam team = new FootballTeam(ANY_NUMBER);
		
		assertTrue("Football team should implement Comparable", team instanceof Comparable);
	}
	
	private static final int BIG_NUMBER = 5;
	private static final int BIGGER_NUMBER = 10;
	
	@Test
	public void teamWithMoreGamesWonShouldBeGreater() {
		FootballTeam team5 = new FootballTeam(BIG_NUMBER);
		FootballTeam team10 = new FootballTeam(BIGGER_NUMBER);
		
		assertTrue("team with 10 wins should be ranked before team with 5 wins", team10.compareTo(team5) > 0);
	}
	
	
	@Test
	public void teamWithLessGamesWonShouldBeLesser() {
		FootballTeam team5 = new FootballTeam(BIG_NUMBER);
		FootballTeam team10 = new FootballTeam(BIGGER_NUMBER);
		
		assertTrue("team with 5 wins should be rannked after team with 10 wins", team5.compareTo(team10) < 0);
	}
	
	@Test
	public void teamWithSameGamesWonShouldBeEqual() {
		FootballTeam teamA = new FootballTeam(BIG_NUMBER);
		FootballTeam teamB = new FootballTeam(BIG_NUMBER);
		
		assertTrue("both teams having same number of wins should be equal", + teamA.compareTo(teamB) == 0);
	}
	
}
