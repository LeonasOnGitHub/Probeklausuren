package Klausur21S1;

public class AutomatImpl implements Automat {
    private String zeichenkette;
    private boolean endzustanderreicht;
    private char sign;
    private boolean readable = true;
    private int marker;


    @Override
    public void readSign(char sign) throws UknownWordExeption {
        this.sign = sign;
        if (!endzustanderreicht) {
            if (this.marker == 0) {
                if (sign == 'A') {
                    this.zeichenkette = String.valueOf(sign);
                    this.sign = '0';
                    q1();
                } else if (sign == 'B') {
                    this.zeichenkette = String.valueOf(sign);
                    this.sign = '0';
                    q2();
                } else {
                    System.out.println(sign);
                    throw new UknownWordExeption("Dieses Symbol wird in diesm zusatnd nicht angenommen");
                }
            } else if (this.marker == 1) {
                q1();
            } else {
                q2();
            }
        }
    }

    @Override
    public String getZeichenkette() throws UknownWordExeption {
        if (endzustanderreicht) {
            return zeichenkette;
        }
        throw new UknownWordExeption("Es wurde kein entzustanderreicht");
    }

    @Override
    public boolean readable() {
        return readable;
    }

    private void q1() throws UknownWordExeption {
        if (this.sign != '0') {
            if (this.sign == 'A') {
                this.zeichenkette=zeichenkette + sign;
                this.sign = '0';
                q1();
            } else if (this.sign == 'C') {
                this.zeichenkette=zeichenkette + sign;
                this.sign = '0';
                q3();
            } else {
                throw new UknownWordExeption("Dieses Symbol wird in diesm zusatnd nicht angenommen");
            }
        } else {
            this.marker = 1;
        }
    }

    private void q2() throws UknownWordExeption {
        if (this.sign != '0') {
            if (this.sign == 'A' || this.sign == 'B') {
                this.zeichenkette=zeichenkette + sign;
                this.sign = '0';
                q1();
            } else if (this.sign == 'D') {
                this.zeichenkette=zeichenkette + sign;
                this.sign = '0';
                q3();
            } else {
                throw new UknownWordExeption("Dieses Symbol wird in diesm zusatnd nicht angenommen");
            }
        } else {
            this.marker = 2;
        }
    }

    private void q3() {
        this.readable = false;
        this.endzustanderreicht = true;
    }
}
