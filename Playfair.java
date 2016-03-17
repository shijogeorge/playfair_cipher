/*
	Java Program to implement playfair algorithm
*/
import java.io.*;
class Playfair
{
	public static void main(String args[])throws Exception
	{
		DataInputStream in=new DataInputStream(System.in);
		String key;
		int p=0,c=65,k=0;
		
		System.out.println();
		System.out.print("Enter key :\t");
		key=in.readLine();
		
		char ch[][]=new char[5][5];
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				
				if(p<key.length())
				{
					ch[i][j]=key.charAt(p);
					p++;
				}			
				 
				else
				{
					
					if((char)c=='J')c++;	
					for(;k<key.length();)
					{
						if((char)c==key.charAt(k))
						{
							k=0;
							c++;
						}
						k++;	
					}
					ch[i][j]=(char)c;
					c++;
					k=0;
				}	
			}

		}
		System.out.print("\nEnter plain text :\t");	
		String txt=in.readLine();
		
		char x,y;
		int rows[]=new int[2];
		int cols[]=new int[2];
		String en="";
		p=0;		
		for(k=0;k<txt.length()/2;k++)
		{
			x=txt.charAt(p);
			p++;	
			y=txt.charAt(p);
			for(int i=0;i<5;i++)
			{
				for(int j=0;j<5;j++)
				{
					if(ch[i][j]==x)
					{
						rows[0]=i;
						cols[0]=j;	
					}
					if(ch[i][j]==y)
					{
						rows[1]=i;
						cols[1]=j;
					}
					
				}
					
			}
			en=en+ch[rows[0]][cols[1]]+ch[rows[1]][cols[0]]+" ";
			p++;
		}				
		System.out.println("\nMatrix of characters:\n");				
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				System.out.print(ch[i][j]+"\t");				
			}
			System.out.println();
		}
		System.out.print("\nEncrypted text:\t"+en);		
	}
}
