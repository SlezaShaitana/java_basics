import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Loader {
    private static final int REGION_AMOUNT = 199;
    private static final int THREAD_AMOUNT = 5;
    private static int coreCount = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        int part = REGION_AMOUNT / THREAD_AMOUNT;
        int totalWillBeWritten = REGION_AMOUNT - REGION_AMOUNT % THREAD_AMOUNT;
        ExecutorService pool = Executors.newFixedThreadPool(THREAD_AMOUNT);
        for (int i = 0; i < THREAD_AMOUNT; i++) {
            int regionStart = part * i;
            int regionFinish = regionStart + part - 1;
            pool.submit(new NumberGeneration(start, regionStart, regionFinish, i));
        }

        if (totalWillBeWritten != REGION_AMOUNT) {
            pool.submit(new NumberGeneration(start, totalWillBeWritten, REGION_AMOUNT, THREAD_AMOUNT));
        }
        pool.shutdown();
    }
}
