import java.util.Scanner;

class Username{
	public static void main(String[] args){
		Scanner sn=new Scanner(System.in);
		int tc=sn.nextInt();
		String result[]=new String[tc];
		sn.nextLine();
		for(int i=0;i<tc;i++){
			String un=sn.nextLine();
			if(un.length()>7 && un.length()<31){
				if((un.charAt(0)>96 && un.charAt(0)<123)||(un.charAt(0)>64 && un.charAt(0)<91)){
					int count=0;
					for(int j=0;j<un.length();j++){	
						if(un.charAt(j)>96 && un.charAt(j)<123)
							count++;
						if(un.charAt(j)>64 && un.charAt(j)<91)
							count++;
						if((un.charAt(j)>47 && un.charAt(j)<58)||un.charAt(j)==95)
							count++;
					}
					if(count>un.length()-1)
						result[i]="Valid";
					else
						result[i]="Invalid";
				}
				else
					result[i]="Invalid";
			}
			else
				result[i]="Invalid";
		}
		for(int i=0;i<tc;i++)
			System.out.println(result[i]);
	}
}