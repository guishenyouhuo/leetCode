package com.wangfei.leecode;

public class NumberTransForm {

	public static void main(String[] args) {

		NumberTransForm ntf = new NumberTransForm();
		System.out.println(ntf.toHex(0));
		
		System.out.println(Integer.toHexString(-128));
	}
	
	/**
	 * 给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用 补码运算 方法。
		注意:
		十六进制中所有字母(a-f)都必须是小写。
		十六进制字符串中不能包含多余的前导零。如果要转化的数为0，那么以单个字符'0'来表示；对于其他情况，十六进制字符串中的第一个字符将不会是0字符。 
		给定的数确保在32位有符号整数范围内。
		不能使用任何由库提供的将数字直接转换或格式化为十六进制的方法。
		示例 1：
		输入:
		26
		输出:
		"1a"
		示例 2：
		输入:
		-1
		输出:
		"ffffffff"
	 * @param num
	 * @return
	 */
    public String toHex(int num) {
    	char[] hexChar = new char[16];
    	for(int i = 0; i < hexChar.length; i++){
    		if(i > 9){
    			hexChar[i] = (char)('a' + i - 10);
    			continue;
    		}
    		hexChar[i] = (char)(i + '0');
    	}
    	char[] buf = new char[32];
        int charPos = 32;
        int radix = 1 << 4;
        int mask = radix - 1;
        do {
            buf[--charPos] = hexChar[num & mask];
            num >>>= 4;
        } while (num != 0);

        return new String(buf, charPos, (32 - charPos));
    }
    public void test(){

    }

}
