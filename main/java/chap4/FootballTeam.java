package chap4;

public class FootballTeam implements Comparable<FootballTeam> {

	private int gamesWon;

	public FootballTeam(int gamesWon) {

		if (gamesWon < 0) {
			throw new IllegalArgumentException("illegal gamesWon : ["
					+ gamesWon + "]. Cannot be negative");
		}

		this.gamesWon = gamesWon;
	}

	public int getGamesWon() {
		return this.gamesWon;
	}

	@Override
	public int compareTo(FootballTeam otherTeam) {
		return getGamesWon() - otherTeam.getGamesWon();
	}

}
