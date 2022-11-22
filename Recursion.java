import java.util.*;

class Recursion
{
    public static void RecurString(String str,int l,int r){
        if(l==r)
            System.out.println(str);
        else
            for(int i=l;i<=r;i++){
                str=swap(str,l,i);
                RecurString(str,l+1,r);
                str=swap(str,l,i);
            }
    } 
    public static String swap(String str,int a,int b){
        char[] arr=str.toCharArray();
        char temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
        return String.valueOf(arr);
    }
    public static void main (String[] args){
        Scanner sn=new Scanner(System.in);
        String str=sn.next();
        RecurString(str,0,str.length()-1);
    }
}