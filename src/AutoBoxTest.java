import java.lang.String;

/**
 * 自动拆箱和装箱
 */
public class AutoBoxTest {
    public static void main(String[] args) {
        long beginTime = System.currentTimeMillis();

        Long sum = 0L;//10872ms
        //long sum = 0L;//964ms
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.print(String.format("costTime=[%d],sum[%d]", (System.currentTimeMillis() - beginTime), sum));
    }
}
