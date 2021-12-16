package com.example.module1.PalindromeAndFactorialCheck;



class PalindromeAndFactorialCheck implements Palindrome , Factorial{


    @Override
    public boolean palindromeChecker(int num) {
        var reversed = 0;
        var remainder = 0;
        var temp = num;

        while(temp>0){
            remainder = temp%10;
            reversed = reversed*10 + remainder;
            temp = temp / 10;
        }
        return reversed == num;
    }

    @Override
    public int factorialChecker(int num) {
        var result =1;
        for(var i=num; i>1; i--){
            result = result * i;
        }
        return result;
    }
}
