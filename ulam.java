import java.util.*;

class ulam{
    public static void main(String[] args){
        Scanner sn=new Scanner(System.in);
        System.out.print("ENTER AN ODD NUMBER : ");
        int n=sn.nextInt();
        int m=n/2;
        int[][] arr=new int[n][n];
        HashMap<Integer,Integer> hashmap=new HashMap<>();
        hashmap.put(2,1);
        hashmap.put(3,1);
        for(int i=4;i<n*n;i++){
            for(int j=2;j<i;j++){
                if(i%j==0)
                    break;
                if(j==i-1 && i%j!=0)
                    hashmap.put(i,1);
            }
        }
        int count=1;
        int x=0;
        arr[m][m]=count;
        for(int i=1;i<n;i++){
            if(i%2!=0){
                for(int j=0;j<i;j++){
                    count++;
                    try{
                        arr[m+x][m-x+1+j]=count;
                    }catch(Exception e){}
                }
                for(int j=0;j<i;j++){
                    count++;
                    try{
                        arr[m+x-1-j][m+x+1]=count;
                    }catch(Exception e){}
                }
            }else{
                x++;
                for(int j=0;j<i;j++){
                    count++;
                    try{
                        arr[m-x][m+x-j-1]=count;
                    }catch(Exception e){}
                }
                for(int j=0;j<i;j++){
                    count++;
                    try{
                        arr[m-x+1+j][m-x]=count;
                    }catch(Exception e){}
                }
            }
        }
        if(n%2!=0){
            for(int i=0;i<n-1;i++){
                count++;
                arr[n-1][i+1]=count;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                try{
                    if(hashmap.containsKey(arr[i][j]))
                        System.out.print("* ");
                    else
                        System.out.print("  ");
                }catch(Exception e){}
            }
            System.out.println();
        }
    }
}
