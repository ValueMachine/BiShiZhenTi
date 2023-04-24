package 锁;

public class SynchronizedDemo {
   static class Ticker{
        private int number  = 100;
        private  synchronized  void sale(){
            if (number>0){
                System.out.println(Thread.currentThread().getName()+"：卖出"+(number--) +"剩下："+number);
            }
        }
    }
public static class SaleTicket{
    public static void main(String[] args) {
                Ticker ticket =  new Ticker();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i<40; i++){
                            ticket.sale();
                        }
                    }
                },"aa").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i<40; i++){
                    ticket.sale();
                }
            }
        },"bb").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i<40; i++){
                    ticket.sale();
                }
            }
        },"cc").start();
    }
}
}
