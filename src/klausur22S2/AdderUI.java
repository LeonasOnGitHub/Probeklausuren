package klausur22S2;

import java.io.*;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class AdderUI {
    Adder add = new AdderImpl();
    private final BufferedReader inBufferedReader;

    public AdderUI(InputStream is) {
        this.inBufferedReader = new BufferedReader(new InputStreamReader(is));
    }

    public static void main(String[] args) {

        AdderUI ui = new AdderUI(System.in);
        ui.printUsage();
        ui.runCommandLoop();
    }

    public void printUsage() {
        StringBuilder b = new StringBuilder();

        b.append("\n");
        b.append("\n");
        b.append("how to enter:");
        b.append("\n");
        b.append("+ (positive integer number1) (positive integer number 2)");
        b.append("\n");
        b.append("example:+ 42  42");
        b.append("\n");
        b.append("or if you want to calculater further with your last result");
        b.append("\n");
        b.append("+ (positive integer number1)");
        b.append("\n");
        b.append("example:+ 42");

        System.out.println(b.toString());
    }

    public void runCommandLoop() {
        boolean again = true;

        while (again) {
            boolean rememberCommand = true;
            String cmdLineString = null;

            try {
                // read user input
                cmdLineString = inBufferedReader.readLine();

                // finish that loop if less than nothing came in
                if (cmdLineString == null) break;

                // trim whitespaces on both sides
                cmdLineString = cmdLineString.trim();

                // extract command
                int spaceIndex = cmdLineString.indexOf(' ');
                spaceIndex = spaceIndex != -1 ? spaceIndex : cmdLineString.length();

                // got command string
                String commandString = cmdLineString.substring(0, spaceIndex);

                // extract parameters string - can be empty
                String parameterString = cmdLineString.substring(spaceIndex);
                parameterString = parameterString.trim();

                //splits the parameterString to an int (yCoord) and a String (xCoord)
                StringTokenizer st = new StringTokenizer(parameterString);

                int num1 = Integer.parseInt(st.nextToken());

                if (st.hasMoreTokens()){
                    int num2 = Integer.parseInt(st.nextToken());
                    add.add(num1, num2);
                } else {
                    add.add(num1);
                }

                System.out.println("= " + add.getResult());
            } catch (NumberFormatException ex) {
                System.out.println("The number is not an integer ");
            } catch (adderException ex) {
                System.out.println(ex.getLocalizedMessage());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NoSuchElementException e){
                System.out.println("you have just enternet a wrong input please try again");
            }
        }
    }

}
//go to File -> project structure -> artifacts -> + -> jar -> from moduls... -> choose a main class
//go to build -> build artefacts -> build
// go to the ..._jar folder and open it and type java -jar [filenmae].jar