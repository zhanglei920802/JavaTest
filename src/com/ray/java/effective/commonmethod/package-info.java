/**
 * Created by 80107442 on 2016-12-07.
 */
package com.ray.java.effective.commonmethod;
/**
 * TODO
 * 需要着重看下
 * <p>
 * Effective Java 第二章测试
 * <p>
 * 计算hashCode规则
 * <code>
 * 1.把某个非零的常数值，比如说17，保存在一个result的int 类型的变量中。
 * 2.对于某个对象中每个关键字f(指equals方法中涉及的每个域)，完成以下步骤：
 * a:为该域计算int类型的散列码c:
 * 1) 如果该域是boolean类型，则计算(f?1:0)
 * 2)如果该域是byte,char,short或者int类型,则计算(int)f
 * 3)如果该域是int类型,则计算(int)(f^(f>>>32))。
 * 4)如果该域是long类型,则计算Float.floatToIntBits(f)。
 * 5)如果该域是double类型,则计算Double.DoubleToLongBits(f),然后再按照3),为得到的long类型值计算散列值
 * 6)如果该类型是对象引用，并且该类的equals方法通过递归调用equals的方式来比较这个域，则同样为这个域递归调用hasCode。如果需要更复杂的比较，则为这个域计算一个“范式”，然后针对这个范式调用hashCode
 * 。如果这个值为null,则返回0。
 * 7)如果该域是一个数组，则要把每一个元素当做单独的域来处理。也就是说，递归调用上诉的规则。也可使用Arrays.hashCode方法。
 * b.计算：result = 31 * result +c
 * 3.返回result
 * </code>
 * <p>
 * 1.如果散列码计算开销比较大，可以将散列码缓存起来
 * <p>
 * <p>
 * <p>
 * </p>
 * toString返回的:
 * return getClass().getName() + "@" + Integer.toHexString(hashCode());
 * <p>
 * <p>
 * <p/>
 * compareTo
 * 当该对象小于，等于或大于指定对象的时候，分别返回一个负整数，0或者正整数。如果无法比较，则抛出ClassCastException
 */