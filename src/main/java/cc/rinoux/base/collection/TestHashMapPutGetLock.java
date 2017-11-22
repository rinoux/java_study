package cc.rinoux.base.collection;

import java.util.HashMap;

/**
 * Created by rinoux on 2017/3/10.
 */
public class TestHashMapPutGetLock {

    private HashMap map = new HashMap();

    public TestHashMapPutGetLock(final String t) {
        Thread t1 = new Thread() {
            public void run() {
                for (int i = 0; i < 50000; i++) {
                    map.put("key" + i, i);
                }
                System.out.println(t + " t1 over");
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                for (int i = 0; i < 50000; i++) {
                    map.put("key" + i, i);
                }

                System.out.println(t +" t2 over");
            }
        };

        Thread t3 = new Thread() {
            public void run() {
                for (int i = 0; i < 50000; i++) {
                    map.put("key" + i, i);
                }

                System.out.println(t +" t3 over");
            }
        };

        Thread t4 = new Thread() {
            public void run() {
                for (int i = 0; i < 50000; i++) {
                    map.put("key" + i, i);
                }

                System.out.println(t + " t4 over");
            }
        };

        Thread t5 = new Thread() {
            public void run() {
                for (int i = 0; i < 50000; i++) {
                    map.put("key" + i, i);
                }

                System.out.println(t +" t5 over");
            }
        };

        Thread t6 = new Thread() {
            public void run() {
                for (int i = 0; i < 50000; i++) {
                    map.get("key" + i);
                }

                System.out.println(t +" t6 over");
            }
        };

        Thread t7 = new Thread() {
            public void run() {
                for (int i = 0; i < 50000; i++) {
                    map.get("key" + i);
                }

                System.out.println(t +" t7 over");
            }
        };

        Thread t8 = new Thread() {
            public void run() {
                for (int i = 0; i < 50000; i++) {
                    map.get("key" + i);
                }

                System.out.println(t +" t8 over");
            }
        };

        Thread t9 = new Thread() {
            public void run() {
                for (int i = 0; i < 50000; i++) {
                    map.get("key" + i);
                }

                System.out.println(t +" t9 over");
            }
        };

        Thread t10 = new Thread() {
            public void run() {
                for (int i = 0; i < 50000; i++) {
                    map.get("key" + i);
                }

                System.out.println(t +" t10 over");
            }
        };

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();
    }

    public static void main(String[] args) throws InterruptedException {
        /*
        Thread.sleep(2000);
        for (int i = 0; i < 100; i++) {
            new TestHashMapPutGetLock(i + "_time -");
        }
        */

        int a = -1;
        assert a > 0 : "something goes wrong here, a cannot be less than 0";
        System.out.println(a);

    }
}

