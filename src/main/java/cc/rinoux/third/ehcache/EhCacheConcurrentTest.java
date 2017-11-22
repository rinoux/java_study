package cc.rinoux.third.ehcache;

import com.fr.third.net.sf.ehcache.Cache;
import com.fr.third.net.sf.ehcache.CacheManager;
import com.fr.third.net.sf.ehcache.Element;
import com.fr.third.net.sf.ehcache.config.CacheConfiguration;
import com.fr.third.net.sf.ehcache.config.Configuration;
import com.fr.third.net.sf.ehcache.config.DiskStoreConfiguration;
import com.fr.third.net.sf.ehcache.config.PersistenceConfiguration;

import java.io.Serializable;

/**
 * @author rinoux
 * @version 10.0
 * Created by rinoux on 2020/8/5*/


public class EhCacheConcurrentTest {


    public static void main(String[] args) {
        Configuration configuration = new Configuration();

        configuration.setName("testCacheManager");
        configuration.setMaxBytesLocalHeap(5000000L);
        configuration.setMaxBytesLocalDisk(100000000L);

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


        ehcache.put(new Element("1", new Data(1, "xxxxxxxxxxxskughfiwbfiuaegfiubr", System.currentTimeMillis())));


        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {

                    System.out.println(ehcache.get("1").getObjectValue());
                }
            }).start();
        }

    }


    static class Data implements Serializable {
        int id;
        String context;
        long timestamp;

        public Data(int id, String context, long timestamp) {
            this.id = id;
            this.context = context;
            this.timestamp = timestamp;
        }
    }
}
