/* Project of UGC team

======================
Authors:zhangxin

======================
Description:


======================
*/
package com.zxahu.Atomic;

public class Processor {

    private Memory mem;

    private int num;

    public Processor(Memory mem){
        this.mem = mem;
        this.num = mem.getNum();
    }

    private boolean compareAndSet(int expect, int update) {
        if (mem.getNum() == expect) {
            mem.setNum(update);
            num = update;
            return true;
        }
        return false;
    }

    public int increase() {
        for (; ; ) {
            int current = num;
            int next = num + 1;
            if (compareAndSet(current, next)) {
                return next;
            }
        }
    }

}
