import java.util.Scanner;

class Solution{
    public static void main(String s[]){
        Scanner sn=new Scanner(System.in);
        int tc=sn.nextInt();
		String result[]=new String[tc];
		for(int i=0;i<tc;i++){
            int tn=sn.nextInt();
            int lp=sn.nextInt();
			sn.nextLine();
			String str=sn.nextLine();
			str=str.replaceAll(" ","");
			int j=0;
			int x=0;
			int y=0;
			while(j<tn){
				if(j+lp>=tn || j+1==tn){
					result[i]="YES";
					break;
				}
				else if(j<tn-1 && str.charAt(j+1)=='0' && x==0 && y==0)
					j++;
				
				else if(j+lp<tn && str.charAt(j+lp)=='0' && x<lp && y<lp){
						j=j+lp;
						x=0;
				}
				else if(j+lp<tn && str.charAt(j+lp)=='1'&& j>0 && str.charAt(j-1)=='0'){
						j--;
						x++;
				}
				else if(j+lp<tn && str.charAt(j+lp)=='1' && j>0 && str.charAt(j-1)=='1' && j-lp>0 && str.charAt(j-lp-1)=='0'){
					j=j-lp-1;
					y++;
				}
				else{
					result[i]="NO";
					break;
				}
			}
        }
		for(int i=0;i<tc;i++)
			System.out.println(result[i]);
    }
}
