package com.sun.springboothello.order;

import java.util.Arrays;

public class test2 {

    public static void main(String[] args) {
        int num[] = {3,9,-1,20,10};
        int orderNum[] = order(num);
        System.out.println(Arrays.toString(orderNum));
    }

    private static int[] order(int num[]){
        for (int i = 1; i < num.length; i++) {
            int temp = num[i];
            int j = i-1;
            while (j>=0 && num[j]>temp){
                num[j+1] = num[j];
                j--;
            }
            num[j+1] = temp;
        }
        return num;
    }
}
