package com.leetode.application;

class PlusOne {
    public int[] plusOne(int[] digits) {
        //进位标识
        int carry = 1;
        int cur = 0;
        int size = digits.length;
        for (int i = size - 1; i >= 0; i--) {
            if (carry == 0) {
                return digits;
            }
            cur = (digits[i] + carry) % 10;
            carry = (digits[i] + carry) >= 10 ? 1 : 0;
            digits[i] = cur;
        }
        if(carry == 1){
            int[] copy = new int[size + 1];
            copy[0] = 1;
            return copy;
        }
        return digits;
    }
}
