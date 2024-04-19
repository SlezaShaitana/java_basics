import java.io.PrintWriter;

public class NumberGeneration extends Thread {
    private long start;
    private int startRegionCode;
    private int finishRegionCode;
    private int threadNum;

    public NumberGeneration(long start, int startRegionCode, int finishRegionCode, int threadNum) {
        this.start = start;
        this.startRegionCode = startRegionCode;
        this.finishRegionCode = finishRegionCode;
        this.threadNum = threadNum;
    }

    private static String padNumber(int number, int numberLength) {
        StringBuilder builder = new StringBuilder(Integer.toString(number));
        int padSize = numberLength - builder.length();
        for (int i = 0; i < padSize; i++) {
            builder.insert(0, '0');
        }
        return builder.toString();
    }

    @Override
    public void run() {
        try {
            PrintWriter writer = new PrintWriter("res/numbers" + startRegionCode + "-" +
                    finishRegionCode + ".txt");
            char letters[] = {'У', 'К', 'Е', 'Н', 'Х', 'В', 'А', 'Р', 'О', 'С', 'М', 'Т'};
            for (int regionCode = startRegionCode; regionCode <= finishRegionCode; regionCode++) {
                StringBuilder builder = new StringBuilder();
                for (int number = 1; number < 1000; number++) {
                    for (char firstLetter : letters) {
                        for (char secondLetter : letters) {
                            for (char thirdLetter : letters) {
                                builder.append(firstLetter);
                                builder.append(padNumber(number, 3));
                                builder.append(secondLetter);
                                builder.append(thirdLetter);
                                builder.append(padNumber(regionCode, 2));
                                builder.append('\n');
                            }
                        }
                    }
                }
                writer.write(builder.toString());
            }
            writer.flush();
            writer.close();
            System.out.println("Thread " + threadNum + " - " + (System.currentTimeMillis() - start) + " ms");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
