package lock;

import java.util.concurrent.locks.ReentrantLock;

class Ticket{
    private int number  = 100;


    private  final ReentrantLock lock = new ReentrantLock();
    void sale(){
        try { lock.lock();
            if (number>0){
                System.out.println(Thread.currentThread().getName()+"：卖出"+(number--) +"剩下："+number);
            }
        } finally {
            lock.unlock();
        }
    }
}
public class LockSaleTicket {


    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(()->{
            for (int i = 0; i<40; i++){
                ticket.sale();
            }
        },"aa").start();
        new Thread(()->{
            for (int i = 0; i<40; i++){
                ticket.sale();
            }
        },"bb").start();
        new Thread(()->{
            for (int i = 0; i<40; i++){
                ticket.sale();
            }
        },"cc").start();

    }
}
