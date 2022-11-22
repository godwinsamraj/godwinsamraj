import java.util.*;

class Palindrome{
    public static void main(String[] args){
        Scanner sn=new Scanner(System.in);
        int pn=sn.nextInt();
        int y=0;
        int temp=pn;
        while(temp>0){
            y*=10;
            y+=(temp%10);
            temp/=10;
        }
        if(y==pn)
            System.out.println("Palindrome Number");
        else
            System.out.println("Not a Palindrome Number");
    }
}
