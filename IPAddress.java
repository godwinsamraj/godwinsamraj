import java.util.Scanner;

class Solution{
    public static void main(String s[]){ 
        Scanner line=new Scanner(System.in);
        int count=1;
        String str="";
        while(line.hasNextLine()){
            String ln=line.nextLine();
            str+=ln+"*";
            count++;    
        }
        String val[]=str.split("[*]");
        String result[]=new String[val.length];
        for(int i=0;i<val.length;i++){
            String arr[]=val[i].split("[.]");
            int v=0;
            if(arr.length==4)
                for(int j=0;j<4;j++){
                    if(arr[j].length()<4 && Integer.parseInt(arr[j])<256){
                        v++;
                        if(v==4)
                            result[i]="true";
                        if(j==3 && v<4)
                            result[i]="false";
                    }
                    else{
                        result[i]="false";
                        break;
                    }
                }
            else
                result[i]="false";
        }
        for(int i=0;i<val.length;i++)
            System.out.println(result[i]);
    }
}