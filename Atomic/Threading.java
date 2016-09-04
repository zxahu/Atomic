/* Project of UGC team

======================
Authors:zhangxin

======================
Description:


======================
*/
package com.zxahu.Atomic;

public class Threading implements Runnable {

    private Memory memory;

    private Processor processor;

    public Threading(Memory memory, Processor processor) {
        this.memory = memory;
        this.processor = processor;
    }

    @Override
    public void run() {
        while (memory.getNum() != 100) {
            int next = processor.increase();
            System.out.println(Thread.currentThread().getName() + " increase success, num=" + next);

            try {
                Thread.yield();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]) {
        Memory mem = new Memory(0);
        Threading ing1 = new Threading(mem, new Processor(mem));
        Threading ing2 = new Threading(mem, new Processor(mem));
        Thread th1 = new Thread(ing1);
        Thread th2 = new Thread(ing2);
        th1.start();
        th2.start();
    }
}
