class Comp{
    public static void main(String[] args){
        int a=72,b=72,c=21,d=0,e=153,f=36,k=36,l=72,m=72,n=108;
        for(int i=0;i<55;i++){
            for(int j=0;j<153;j++){
                if((j>=a && j<=b && i<f) || ((i>=c && i<f)&&((j>=d && j<=e))) || (i>=f && ((j>=k && j<=l) || (j>=m && j<=n))))
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            a--;b++;
            if(i>=c){
                d+=4;e-=4;
            }
            if(i>=f){k--;l-=3;m+=3;n++;
            }
            System.out.println();
        }
    }
}