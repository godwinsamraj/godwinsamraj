import java.util.*;

class FirstRepeat{
    public static void main(String[] args){
        Scanner sn=new Scanner(System.in);
        String str=sn.next();
        char rp=Repeat(str); 
        System.out.println(rp);
        char nrp=NonRepeat(str);
        System.out.println(nrp);
    }
    public static char Repeat(String str){
        HashMap<Character,Integer> hashmap=new HashMap<>();
        for(int i=0;i<str.length();i++){
            if(!hashmap.containsKey(str.charAt(i)))
                hashmap.put(str.charAt(i),1);
            else
                hashmap.put(str.charAt(i),(hashmap.get(str.charAt(i))+1));
        }
        for(int i=0;i<str.length();i++)
            if(hashmap.get(str.charAt(i))!=1)
                return str.charAt(i);
        return str.charAt(0);
    }
    public static char NonRepeat(String str){
        HashMap<Character,Integer> hashmap=new HashMap<>();
        for(int i=0;i<str.length();i++){
            if(!hashmap.containsKey(str.charAt(i)))
                hashmap.put(str.charAt(i),1);
            else
                hashmap.put(str.charAt(i),(hashmap.get(str.charAt(i))+1));
        }
        for(int i=0;i<str.length();i++)
            if(hashmap.get(str.charAt(i))==1)
                return str.charAt(i);
        return str.charAt(0);
    }
}