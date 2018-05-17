package com.wangfei.leecode;

public class AddDigits {

	public static void main(String[] args) {

		AddDigits ad = new AddDigits();
		System.out.println(ad.addDigits(100));
	}
	/**
	 * 给一个非负整数 num，反复添加所有的数字，直到结果只有一个数字。
		例如:
		设定 num = 38，过程就像： 3 + 8 = 11, 1 + 1 = 2。 由于 2 只有1个数字，所以返回它。
		进阶:
		你可以不用任何的循环或者递归算法，在 O(1) 的时间内解决这个问题么？
	 * @param num
	 * @return
	 */
    public int addDigits(int num) {
    	return (num - 1) % 9 + 1;
    }
    
    /**
     * 解题方法2
		另一个方法比较简单，可以举例说明一下。假设输入的数字是一个5位数字num，则num的各位分别为a、b、c、d、e。
		有如下关系：num = a * 10000 + b * 1000 + c * 100 + d * 10 + e
		即：num = (a + b + c + d + e) + (a * 9999 + b * 999 + c * 99 + d * 9)
		因为 a * 9999 + b * 999 + c * 99 + d * 9 一定可以被9整除，因此num模除9的结果与 a + b + c + d + e 模除9的结果是一样的。
		对数字 a + b + c + d + e 反复执行同类操作，最后的结果就是一个 1-9 的数字加上一串数字，最左边的数字是 1-9 之间的，右侧的数字永远都是可以被9整除的。
		这道题最后的目标，就是不断将各位相加，相加到最后，当结果小于10时返回。因为最后结果在1-9之间，得到9之后将不会再对各位进行相加，因此不会出现结果为0的情况。因为 (x + y) % z = (x % z + y % z) % z，又因为 x % z % z = x % z，因此结果为 (num - 1) % 9 + 1，只模除9一次，并将模除后的结果加一返回。
     */
}
