package sk.posta.data.enumm;

public enum PredpisStav {
	/**
	 * Predpis je nahrany v systeme a nebol zatial spracovany
	 */
	LOADED,
	/**
	 * Predpis caka na spracovanie, prebieha batch nahratie predpisov
	 */
	WAITING,
	/**
	 * Predpis bol korektne nahrany do PEP
	 */
	PROCESSED,
	/**
	 * Predpis sa snazil nahrat do PEP ale skutek utek
	 */
	ERROR
}
