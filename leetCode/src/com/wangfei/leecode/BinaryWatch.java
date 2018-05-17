package com.wangfei.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryWatch {

	public static void main(String[] args) {

		BinaryWatch  bw = new BinaryWatch();
		System.out.println(Arrays.toString(bw.readBinaryWatch(7).toArray()));
	}

	/**
	 * 二进制手表顶部有 4 个 LED 代表小时（0-11），底部的 6 个 LED 代表分钟（0-59）。
		每个 LED 代表一个 0 或 1，最低位在右侧。
		例如，上面的二进制手表读取 “3:25”。
		给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间。
		案例:
		输入: n = 1
		返回: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
		注意事项:
		输出的顺序没有要求。
		小时不会以零开头，比如 “01:00” 是不允许的，应为 “1:00”。
		分钟必须由两位数组成，可能会以零开头，比如 “10:2” 是无效的，应为 “10:02”。
	 * @param num
	 * @return
	 */
    public List<String> readBinaryWatch(int num) {
        
    	List<String> result = new ArrayList<>();
        for (int onesHour = 0; onesHour <= num; onesHour++) {
            int onesMinute = num - onesHour;
            List<Integer> hours = new ArrayList<>();
            List<Integer> minutes = new ArrayList<>();
            getCombination(4, onesHour, 0, hours);
            getCombination(6, onesMinute, 0, minutes);
            for (int hour : hours) {
                if (hour > 11) {
                    continue;
                }
                for (int minute : minutes) {
                    if (minute > 59) {
                        continue;
                    }
                    result.add(String.format("%d:%02d", hour, minute));
                }
            }
        }
        return result;
    }
    
    
    private void getCombination(int length, int numOnes, int base, List<Integer> pool){
    	if(numOnes == 0){
    		pool.add(base);
    		return;
    	}
    	if(length == 0 || length < numOnes){
    		return;
    	}
    	getCombination(length - 1, numOnes - 1, base + (1 << (length - 1)), pool);
    	getCombination(length - 1, numOnes, base, pool);
    }
}
