package com.study.myhash;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jiayq
 * @Date 2020-04-21
 */
public class HashMain {

    private int myHash;

    public HashMain(){
        this.myHash = hashCode();
    }

    public static void main(String[] args){
        HashMain hashMain = new HashMain();
        //输出hashCode（hashCode一般以16进制进行展示或者运算）
        System.out.println(Integer.toHexString(hashMain.hashCode()));
        //调用Object的toString方法
        System.out.println(hashMain);
        System.out.println(27 & 0b1110);
        // 27 = 0b 0001 1011 & 0b 0000 1110 => 0b 0000 1010
        System.out.println(27 ^ 0xE);
        // 27 = 0b 0001 1011 ^ 14 => 0b 0000 1110 => 0001 0101 = 21
        HashMain hashMain1 = hashMain;
        //比较引用
        System.out.println(hashMain == hashMain1);
        //比较equals
        System.out.println(hashMain.equals(hashMain1));
        //设置属性
        hashMain.myHash = 1;
        //创建不同的对象
        hashMain1 = new HashMain();
        //设置属性
        hashMain1.myHash = 1;
        //比较equals
        System.out.println(hashMain.equals(hashMain1));
        //输出hashCode
        System.out.println(hashMain.hashCode());
        System.out.println(hashMain1.hashCode());
        //调用Object的toString输出
        System.out.println(hashMain);
        System.out.println(hashMain1);
        //Set不允许重复数据，其重复的标准是equals方法
        //如果hashCode相同，那么会将数据放到同一个哈希桶里
        //如果equals相同，那么不会进行存储，注意，在判断equals之前会判断hashCode相等
        //也就是说，如果两个对象的hashCode不同，其equals相同，那么Set也会将这两个对象当做不同的数据进行存储
        //反之，如果两个对象的hashCode相同，那么会继续判断equals
        //1.hashCode不同，equals相同
        Set<HashMain> set = new HashSet<>();
        set.add(hashMain);
        set.add(hashMain1);
        System.out.println(set);
        set.clear();
        //2.hashCode相同，equals不同
        hashMain1.myHash = 2;
        set.add(hashMain);
        set.add(hashMain1);
        System.out.println(set);
    }


    /**
     * 重写了子类的hashCode的方法
     * @return
     */
    @Override
    public int hashCode() {
        // 0b1111 = 1+2+4+8 = 15
        // value & 0b1111 -> [0,15]
        // value & (ob1111 - 1) -> [0,14] => 0b 1110 & value => 高 3 位
        //调用Object的hashCode方法，将返回的结果取低4位(0~15),类似将数值 >>> 60
        //同时 value % 16 等价于 value & 0b1111 <=> value &0xF
        //场景1.hashCode不同，equals相同
//        return super.hashCode() & 0b1111;
        //2.hashCode相同，equals不同
        return this.getClass().getName().hashCode();
    }


    /**
     * 重写了子类的equals方法
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        //类型相同
        if (obj instanceof HashMain){
            HashMain main = (HashMain) obj;
            //属性相同
            return this.myHash == main.myHash;
        }
        return false;
    }

}
