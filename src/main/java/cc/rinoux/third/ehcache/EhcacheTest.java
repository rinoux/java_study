package cc.rinoux.third.ehcache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sf.ehcache.config.CacheConfiguration;
import net.sf.ehcache.config.Configuration;
import net.sf.ehcache.config.DiskStoreConfiguration;
import net.sf.ehcache.config.PersistenceConfiguration;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author rinoux
 * @version 10.0
 * Created by rinoux on 2020/8/3*/


public class EhcacheTest {


    private static final double ONE_KB = 1024;

    public static void main(String[] args) {


        System.out.println(formatBytesSize(Runtime.getRuntime().freeMemory()));
        Configuration configuration = new Configuration();

        configuration.setName("testCacheManager");
        configuration.setMaxBytesLocalHeap(500000000L);
        configuration.setMaxBytesLocalDisk(10000000000L);

        DiskStoreConfiguration diskStoreConfiguration = new DiskStoreConfiguration();
        diskStoreConfiguration.setPath("/Users/rinoux/Downloads/test");
        configuration.diskStore(diskStoreConfiguration);


        CacheManager cacheManager = new CacheManager(configuration);

        CacheConfiguration cacheConfiguration = new CacheConfiguration();
        cacheConfiguration.setName("swaptest");
        cacheConfiguration.setEternal(true);
        cacheConfiguration.setMemoryStoreEvictionPolicy("LRU");
        cacheConfiguration.setTimeToIdleSeconds(120);
        cacheConfiguration.setTimeToLiveSeconds(120);
        cacheConfiguration.setDiskExpiryThreadIntervalSeconds(120);

        PersistenceConfiguration pc = new PersistenceConfiguration();
        pc.setStrategy(PersistenceConfiguration.Strategy.LOCALTEMPSWAP.name());


        cacheConfiguration.persistence(pc);

        Cache ehcache = new Cache(cacheConfiguration);

        cacheManager.addCache(ehcache);


        List<Object[]> data = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            data.add(new Object[]{
                    "1111111111111" + i, "2222222222" + i, "333333333333" + i
            });
        }

        for (int i = 0; i < 100000; i++) {

            ehcache.put(new Element("key" + i, data));


            if (i % 1000 == 0) {
                System.out.println(i);
                System.out.println("heap:" + formatBytesSize(ehcache.getStatistics().getLocalHeapSizeInBytes()));
                System.out.println("disk:" + formatBytesSize(ehcache.getStatistics().getLocalDiskSizeInBytes()));
                System.out.println("heap:" + BigDecimal.valueOf(ehcache.getStatistics().getLocalHeapSizeInBytes() / 500000000f).setScale(3, BigDecimal.ROUND_HALF_UP).toPlainString());
                System.out.println("disk:" + BigDecimal.valueOf(ehcache.getStatistics().getLocalDiskSizeInBytes() / 10000000000f).setScale(3, BigDecimal.ROUND_HALF_UP).toPlainString());
                System.out.println(ehcache.getSize());
                System.out.println(formatBytesSize(Runtime.getRuntime().freeMemory()));
                System.out.println(formatBytesSize(Runtime.getRuntime().maxMemory()));
                System.out.println("---------------");
            }

        }


        ehcache.dispose();
        cacheManager.shutdown();

        System.out.println(0);

    }

    public static String formatBytesSize(double bytesSize) {
        //单位有KMGTPEZYDN
        String unitStr;
        BigDecimal bd;
        if (bytesSize >= ONE_KB) {
            //取log以1024为底的值，计算合理单位index
            int power = (int) (Math.log(bytesSize) / Math.log(ONE_KB));
            unitStr = ("KMGTPEZYDN").charAt(power - 1) + "B";
            bd = new BigDecimal(String.valueOf(bytesSize / Math.pow(ONE_KB, power)));
        } else {
            unitStr = "byte" + (Objects.equals(bytesSize, 0) ? "" : "s");
            bd = BigDecimal.valueOf(bytesSize);
        }

        //保留2位小数&向上近似
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        return bd.toPlainString() + " " + unitStr;
    }

}
