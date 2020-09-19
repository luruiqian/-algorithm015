package com.leetode.application;

class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int size = bills.length;
        int fivenum = 0;
        int tennum = 0;
        for (int i = 0; i < size; i++) {
            if (bills[i] == 5) {
                fivenum += 1;
            }
            if (bills[i] == 10) {
                if (fivenum < 1) {
                    return false;
                } else {
                    fivenum -= 1;
                    tennum += 1;
                }
            }
            if (bills[i] == 20) {
                if (tennum >= 1 && fivenum >= 1) {
                    tennum -= 1;
                    fivenum -= 1;
                } else if (fivenum >= 3) {
                    fivenum -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
