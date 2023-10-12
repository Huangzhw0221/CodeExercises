package com.Recruitment;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @author: Huang Zhiwei
 * @time: 2023/9/18 19:32
 */
public class printABC {
    private Lock lock;
    private Condition condition;
    private int count;
    public static void main(String[] args) {
        printABC printABC = new printABC();
        Thread threadA = new Thread(() -> printABC.printLetter('A'));
        Thread threadB = new Thread(() -> printABC.printLetter('B'));
        Thread threadC = new Thread(() -> printABC.printLetter('C'));

        threadA.start();
        threadB.start();
        threadC.start();

        try {
            threadA.join();
            threadB.join();
            threadC.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public printABC(){
        lock = new ReentrantLock();
        condition = lock.newCondition();
        count = 0;
    }
    public void printLetter(char letter){
        for(int i =0;i< 10;i++){
            lock.lock();
            try {
                while ((letter -'A' != count %3)){
                    condition.await();
                }
                System.out.print(letter);
                condition.signalAll();
                count++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

}
