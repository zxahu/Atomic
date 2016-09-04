/* Project of UGC team

======================
Authors:zhangxin

======================
Description:


======================
*/
package com.zxahu.Atomic;

public class Memory {

    private static int num;

    public Memory(int num){
        this.num = num;
    }

    public static int getNum() {
        return num;
    }

    public static void setNum(int num) {
        Memory.num = num;
    }
}
