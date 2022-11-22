import java.util.*;

class CGPA{
    public static void main(String[] args){
        Scanner sn=new Scanner(System.in);
        HashMap <String,Integer>values=new HashMap<>();
        hashMap(values);
        System.out.print("NO-OF-SUBJECTS:");
        int ts=sn.nextInt();
        double subscr=0;
        double crdscr=0;
        for(int i=0;i<ts;i++){
            System.out.print("GRADE AND CREDIT-SCORE:");
            int mrks=values.get(sn.next());
            int crdt=sn.nextInt();
            subscr+=mrks*crdt;
            crdscr+=crdt;
        }
        System.out.println("GPA -> "+subscr/crdscr);
    }
    public static HashMap<String,Integer> hashMap(HashMap<String,Integer> values){
        values.put("U",5);
        values.put("B",6);
        values.put("B+",7);
        values.put("A",8);
        values.put("A+",9);
        values.put("O",10);
        return values;
    }
}