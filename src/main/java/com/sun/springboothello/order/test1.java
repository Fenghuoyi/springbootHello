package com.sun.springboothello.order;

import java.util.Arrays;

public class test1 {

    public static void main(String[] args) {
        int num[] = {3,9,-1,20,10};
        int orderNum[] = order(num);
        System.out.println(Arrays.toString(orderNum));
    }

    private static int[] order(int num[]){
        if(num == null){
            return null;
        }
        for (int i = 0; i < num.length; i++) {
            for(int j = 0; j<num.length-i-1;j++){
                if(num[j]>num[j+1]){
                    int temp = num[j+1];
                    num[j+1] = num[j];
                    num[j] = temp;
                }
            }
        }
        return num;
    }

}
