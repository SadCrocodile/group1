package com.woniu.XIoVII;

public class NToMChange {
	
//	public static final int TWO=2;
//	public static final int EIGHT=8;
//	public static final int SIXTEEN=16;

	public static String TenToN(int x, int n) {

		String result = "";

		while (x > 0) {
			char s = 0 ;
			if (x % n > 10) 
				s = (char) (x % n + 55);
			result =  s==0?(x % n)+"":s+ result;
			x = x / n;
		}
		return result;
	}
	
	
	public static Double NToTen(String x,int n){
		
		Double result= 0d;
		int len = x.length();
		double a=0;
		
		while(len>0){
			
			result+=Math.pow(n,a++)*Integer.parseInt(x.substring(--len));
			x=x.substring(0,len);
			
		}
		return result;
	}
}



//Stupid Method


// String s = (x%n)+"";
// x=x/n;
// switch(s){
// case "10":
// s="A";
// break;
// case "11":
// s="B";
// break;
// case "12":
// s="C";
// break;
// case "13":
// s="D";
// break;
// case "14":
// s="E";
// break;
// case "15":
// s="F";
// break;
// }
//
//result =  s==0?(x % n)+"":new String(new char[]{s})+ result;