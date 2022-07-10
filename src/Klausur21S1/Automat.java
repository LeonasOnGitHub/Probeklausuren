package Klausur21S1;

public interface Automat {

    /**
     *
     * @param sign
     * @throws UknownWordExeption
     * @return the accepted word
     */
    void readSign(char sign)throws UknownWordExeption;

    /**
     * prüf ob der automat mit der aktuellen Zeichenkette in einen endzustand gekommen ist
     * @return die eerfolgreiche Zeichenkette
     * @throws UknownWordExeption
     */
    String getZeichenkette() throws UknownWordExeption;

    /**
     *
     * @return ob der Automat weitere Zeichen akzeptiert
     */
    boolean readable();
}

