import java.util.*;

class ViterbiAlgorithm{
    public static void main(String[] args){
        Scanner sn=new Scanner(System.in);
        System.out.println("BINARY INPUT");
        String input=sn.next();
        sn.close();
        String start="A0";
        String[] arr=new String[(input.length()/2)];
        HashMap<String,Integer> metric=new HashMap<>();
        HashMap<String,String> hashmap=new HashMap<>();
        putValues(hashmap);
        metric.put(start,0);
        Structure(input,start,metric,hashmap);
        findSurvivalPath(metric,arr);
        String str=start;
        for(int i=0;i<(input.length()/2);i++)
            str+="->"+arr[i];
        System.out.println("OUTPUT");
        System.out.println("METRIC VALUE"+"    "+metric.get(arr[arr.length-1]));
        System.out.println("SURVIVAL PATH"+"   "+str);
        String dc="";
        dc+=hashmap.get("A"+"->"+arr[0].charAt(0));
        for(int i=0;i<(input.length()/2)-1;i++)
            dc+=hashmap.get(arr[i].charAt(0)+"->"+arr[i+1].charAt(0));
        System.out.println("DECODED OUTPUT  "+dc);
    }
    public static void Structure(String input,String str,HashMap<String,Integer> metric,HashMap<String,String> hashmap){
        char val=str.charAt(0);
        int pos=Integer.parseInt(str.substring(1));
        if((val=='A' || val=='C') && pos<input.length()/2){
            if(!metric.containsKey("A"+(pos+1)) || (metric.containsKey("A"+(pos+1)) && metric.get("A"+(pos+1))>metric.get(str)+getValues(hashmap.get(str.charAt(0)+"->"+"A"),input.substring(pos*2,(pos+1)*2))))
                metric.put("A"+(pos+1),metric.get(str)+getValues(hashmap.get(str.charAt(0)+"->"+"A"),input.substring(pos*2,(pos+1)*2)));
            if(!metric.containsKey("B"+(pos+1)) || (metric.containsKey("B"+(pos+1)) && metric.get("B"+(pos+1))>metric.get(str)+getValues(hashmap.get(str.charAt(0)+"->"+"B"),input.substring(pos*2,(pos+1)*2))))
                metric.put("B"+(pos+1),metric.get(str)+getValues(hashmap.get(str.charAt(0)+"->"+"B"),input.substring(pos*2,(pos+1)*2)));
            Structure(input,"A"+(pos+1),metric,hashmap);
            Structure(input,"B"+(pos+1),metric,hashmap);
        }
        else if((val=='B' || val=='D') && pos<input.length()/2){
            if(!metric.containsKey("C"+(pos+1)) || (metric.containsKey("C"+(pos+1)) && metric.get("C"+(pos+1))>metric.get(str)+getValues(hashmap.get(str.charAt(0)+"->"+"C"),input.substring(pos*2,(pos+1)*2))))
                metric.put("C"+(pos+1),metric.get(str)+getValues(hashmap.get(str.charAt(0)+"->"+"C"),input.substring(pos*2,(pos+1)*2)));
            if(!metric.containsKey("D"+(pos+1)) || (metric.containsKey("D"+(pos+1)) && metric.get("D"+(pos+1))>metric.get(str)+getValues(hashmap.get(str.charAt(0)+"->"+"D"),input.substring(pos*2,(pos+1)*2))))
                metric.put("D"+(pos+1),metric.get(str)+getValues(hashmap.get(str.charAt(0)+"->"+"D"),input.substring(pos*2,(pos+1)*2)));
            Structure(input,"C"+(pos+1),metric,hashmap);
            Structure(input,"D"+(pos+1),metric,hashmap);
        }
    }
    
    public static String[] findSurvivalPath(HashMap<String,Integer> metric,String[] arr){
        int l=arr.length;
        String str="";
        while(l>0){
            int min=Integer.MAX_VALUE;
            String minStr="";
            try{
                if(str.equals("") || str.charAt(0)=='A' || str.charAt(0)=='B'){
                    if(metric.get("A"+l)<min){
                        min=metric.get("A"+l);
                        minStr="A"+l;
                    }
                    if(metric.get("C"+l)<min){
                        min=metric.get("C"+l);
                        minStr="C"+l;
                    }
                }
                if(str.equals("") || str.charAt(0)=='C' || str.charAt(0)=='D'){
                    if(metric.get("B"+l)<min){
                        min=metric.get("B"+l);
                        minStr="B"+l;
                    }
                    if(metric.get("D"+l)<min){
                        min=metric.get("D"+l);
                        minStr="D"+l;
                    }
                }
            }
            catch(Exception e){}
            l--;
            arr[l]=minStr;
            str=minStr;
        }
        return arr;
    }
    public static int getValues(String s1,String s2 ){
        int count=0;
        if(s1.charAt(0)!=s2.charAt(0))
            count++;
        if(s1.charAt(1)!=s2.charAt(1))
            count++;
        return count;
    }
    public static void putValues(HashMap<String,String> hashmap){
        hashmap.put("A->A","00");
        hashmap.put("A->B","11");
        hashmap.put("B->C","01");
        hashmap.put("B->D","10");
        hashmap.put("C->A","11");
        hashmap.put("C->B","00");
        hashmap.put("D->C","10");
        hashmap.put("D->D","01");
    }
}