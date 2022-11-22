import java.util.Scanner;

class Password
{
	public static void main(String s[])
	{
		Scanner sn=new Scanner(System.in);
		
		int tc=sn.nextInt();
		String result[]=new String[tc];
		
		for(int i=0;i<tc;i++)
		{
			String pass=sn.next();
			int uc=0,lc=0,nc=0,sc=0;
			if(pass.length()<=9)
				result[i]="NO";
			else if(pass.charAt(0)>=48 && pass.charAt(0)<=57)
				result[i]="NO";
			else if(pass.charAt(pass.length()-1)>=48 && pass.charAt(pass.length()-1)<=57 )
				result[i]="NO";
			else
			{
				for(int j=0;j<pass.length();j++)
				{
					int av=pass.charAt(j);
					if(av>47 && av<58)
						nc++;
					else if(av>64 && av<91)
						uc++;
					else if(av>96 && av<123)
						lc++;
					else if(av==64 || av==35 || av==37 || av==38 || av==63)
						sc++;
				}
			}
			
			if(nc>0 && lc>0 && uc>0 && sc>0)
				result[i]="YES";
			else
				result[i]="NO";
		}
		for(int i=0;i<tc;i++)
			System.out.println(result[i]);
	}
}