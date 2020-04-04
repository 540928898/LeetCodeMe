package OnlineTest;

import sun.jvm.hotspot.debugger.ThreadAccess;

import java.util.concurrent.atomic.AtomicInteger;

public class TwoThread {
    public static AtomicInteger t1 = new AtomicInteger(0);
    public static void run1(){
        while(true){
            if (t1.get() %2 == 0){
                System.out.println(Thread.currentThread().getName()+t1.get());
                t1.getAndIncrement();
            }
        }

    }
    public static void run2(){
        while(true){
            if (t1.get()%2 != 0 ){
                System.out.println(Thread.currentThread().getName()+t1.get());
                t1.getAndIncrement();
            }
        }

    }

    public static void main(String[] args) {
        new Thread(TwoThread::run1,"Thread1").start();
        new Thread((TwoThread::run2),"Thread2").start();
    }
}
