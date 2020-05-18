public class Datum {
	private int dag;
	private int maand;
	private int jaar;

	/**
	 * Constructor
	 */
	public Datum() {
		dag = 0;
		maand = 0;
		jaar = 0;
	}

	/**
	 * Constructor
	 * @param dag
	 * @param maand
	 * @param jaar
	 */
	public Datum(int dag, int maand, int jaar) {
		this();

		if (bestaatDatum(dag, maand, jaar)) {
			this.dag = dag;
			this.maand = maand;
			this.jaar = jaar;
		}
	}

	public int getDag() {
		return dag;
	}

	public void setDag(int dag) {
		this.dag = dag;
	}

	public int getMaand() {
		return maand;
	}

	public void setMaand(int maand) {
		this.maand = maand;
	}

	public int getJaar() {
		return jaar;
	}

	public void setJaar(int jaar) {
		this.jaar = jaar;
	}

	public boolean bestaatDatum(int dag, int maand, int jaar) {
		int daysInMonth = 0;

		// dagen beginnen bij 1
		if (dag < 1) return false;

		// niet alle maanden hebben evenveel dagen
		switch(maand) {
			// maanden met 31 dagen
			case 1:;
			case 3:;
			case 5:;
			case 7:;
			case 8:;
			case 10:;
			case 12:
				daysInMonth = 31;
				break;

			// februari heeft 28 dagen als het geen schrikkeljaar is en 29 als het wel een schrikkeljaar is.
			case 2:
				daysInMonth = isSchrikkeljaar(jaar) ? 29 : 28;
				break;

			// maanden met 30 dagen
			case 4:;
			case 6:;
			case 9:;
			case 11:
				daysInMonth = 30;
				break;

			// alles buiten de bovenstaande waardes wordt als foutief geïnterpreteerd.
			default:
				return false;
		}

		if (dag > daysInMonth) return false;

		return true;
	}

	private boolean isSchrikkeljaar(int jaar) {
		boolean value = false;

		if (jaar % 4 == 0) value = true;

		if (jaar % 100 == 0) value = false;

		if (jaar % 400 == 0) value = true;

		return value;
	}

	/**
	 * Getter voor Sting weergave van datum
	 *
	 * @return Geboortedatum
	 */
	public String getDatumAsString() {
		// TODO
		return "";
	}
}
