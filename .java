import java.util.*;
import java.math.*;

class Solution{
    public static BigInteger fact(BigInteger n){
        int x=n.compareTo(new BigInteger("2");
        if(x==-1) return new BigInteger("1");
        return n.multiply(fact(n.subtract(new BigInteger("1"))));
    }
    public static int gcd(int n,int m){
        if(n==m) return m;
        return n<m ? gcd(m-n,n) : gcd(n-m,m);
    }
    public static void probablityOfTriplet(int x,int[] arr){
        int count=0;
        for(int i=0;i<arr.length;i++) if(arr[i]==x) count++;
        BigInteger num=fact(new BigInteger(String.valueOf(count))).divide((fact(new BigInteger(String.valueOf(count-3))).multiply(new BigInteger("6"))));
        BigInteger den=fact(new BigInteger(String.valueOf(arr.length))).divide((fact(new BigInteger(String.valueOf(arr.length-3))).multiply(new BigInteger("6"))));
        String m=String.valueOf(gcd(num.intValue(),den.intValue()));
        System.out.println(num.divide(new BigInteger(m))+"/"+den.divide(new BigInteger(m)));
    }
    public static void main(String[] args){
        Scanner sn=new Scanner(System.in);
        int n=sn.nextInt(),x=sn.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++) arr[i]=sn.nextInt();
        sn.close();
        probablityOfTriplet(x,arr);
    }
}