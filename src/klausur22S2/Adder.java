package klausur22S2;

public interface Adder {
    /**
     * Add two positive integer numbers and write it into the result
     * @param num1
     * @param num2
     */
    void add(int num1, int num2) throws adderException;

    /**
     * Add a positive integer number to the last calculation and write it into the result
     * @param num
     */
    void add(int num) throws adderException;

    /**
     *
     * @return the result of the last calculation
     */
    int getResult();

    /**
     * clears the result so you can start calculation at 0
     */
    void backdor(int newResult);
}
