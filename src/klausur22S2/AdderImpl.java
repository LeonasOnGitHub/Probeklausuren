package klausur22S2;

import javax.xml.transform.Result;

public class AdderImpl implements Adder {
    private int result;

    @Override
    public void add(int num1, int num2) {
        result = num1 + num2;
    }

    @Override
    public void add(int num) {
        result += num;
    }

    @Override
    public int getResult() {
        return result;
    }

    @Override
    public void backdor(int newResult) {
    result = newResult;
    }
}
