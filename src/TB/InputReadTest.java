package TB;

import java.io.*;

/**
 * Created by Konstantin on 11.01.2017.
 */
public class InputReadTest {
    public static void main(String[] args) {
        File f = new File("src/input/in.txt");
        FileInputStream fis = null;


        try {
            fis = new FileInputStream(f);

            InputStreamReader isr = new InputStreamReader(fis);

            int test;
            test = readInt(isr);
            System.out.println(test);
            test = readInt(isr);
            System.out.println(test);
            test = readInt(isr);
            System.out.println(test);
            isr.read();
            test = readInt(isr);
            System.out.println(test);
            test = readInt(isr);
            System.out.println(test);
//            while(test != -1){
////                System.out.println(test  - '0');
//                test = isr.read();
//            }
            isr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int readInt(InputStreamReader isr) throws IOException {
        int result = 0, bfr;
        while((bfr = isr.read()) > 47){
            result = result*10 + bfr - '0';
        }
        return result;
    }
}
