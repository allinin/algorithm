package JUC.DeadLockDemo;

/**
 * @author zbl
 * @version 1.0
 * @content:
 * @date 2020/3/22 18:26
 */
public class DeadLockDemo2 implements Runnable {

    private Account account1;
    private Account account2;
    private int count;

    public DeadLockDemo2(Account account1, Account account2, int count) {
        this.account1 = account1;
        this.account2 = account2;
        this.count = count;
    }

    @Override
    public void run() {
        synchronized (account1){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (account2){
                account1.money-=count;
                account2.money-=count;
                System.out.println(account1.money);
                System.out.println(account2.money);
            }
        }
    }


    public static class Account{
        private int money;
    }


    public static void main(String[] args) {
        Account account1=new Account();
        Account account2=new Account();
        new Thread(new DeadLockDemo2(account1,account2,10),"thread1").start();;
        new Thread(new DeadLockDemo2(account2,account1,10),"thread2").start();
    }
}
