package Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//List<List<String>>  list1=new ArrayList<>();
		 Scanner sc=new Scanner(System.in);
//		 List<String>  list=new ArrayList<>();
//		 BufferedReader br=new BufferedReader(new FileReader("f:\\picture\\user.txt"));
//		 String line=null;	
//		 System.out.println("ѧ����Ϣ��");
//		 System.out.println("����,���� ,���� ,����,�Ա�");
//		 System.out.println("����");
//		 String s=sc.next();
//		 System.out.println("�滻��");
//		 String s1=sc.next();
//		 while ((line=br.readLine())!=null) {			
//			 String[] arr=line.split(",");				
//			   if(arr[0].equals(s)) {
//				System.out.print(arr[0]+",");		
//				String s2=line.replace(s,s1);
//				System.out.println(s2);
//			    }
//			}
		 System.out.println("=====���޸�=====");
		 System.out.println("��������Ҫ�޸ĵ��û�����");
		 String s=sc.next();
		 System.out.println("�������޸��1.���� 2.���� 3.���� 4.�Ա�");
		 int m=sc.nextInt();
		 System.out.println("�������滻��ֵ");
		 String s1=sc.next();
		 //String ln=list.get(0);
		 StringBuffer sb=new StringBuffer();
		 BufferedReader br=new BufferedReader(new FileReader("f:\\picture\\user.txt"));
		String line=null;
		while ((line=br.readLine())!=null) {			
			   String[] arr=line.split(",");				
			   if(arr[0].equals(s)) {
				System.out.println("�޸��û�<"+arr[0]+">�������Ϣ�ɹ�");
				String c=arr[m];
				String s2=line.replace(c,s1);
				System.out.println(s2);
				sb.append(s2).append("\r\n");
				continue;
			    }
			    sb.append(line).append("\r\n");			   
			    }
		BufferedWriter bw=new BufferedWriter(new FileWriter("f:\\picture\\user.txt"));   	    
	    System.out.println(sb.toString());
		bw.write(sb.toString());
		bw.close();
	}
}