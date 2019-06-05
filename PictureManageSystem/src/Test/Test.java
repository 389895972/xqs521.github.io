package Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//List<List<String>>  list1=new ArrayList<>();
		 Scanner sc=new Scanner(System.in);
//		 List<String>  list=new ArrayList<>();
//		 BufferedReader br=new BufferedReader(new FileReader("f:\\picture\\user.txt"));
//		 String line=null;	
//		 System.out.println("学生信息：");
//		 System.out.println("姓名,密码 ,画像 ,年龄,性别");
//		 System.out.println("姓名");
//		 String s=sc.next();
//		 System.out.println("替换后");
//		 String s1=sc.next();
//		 while ((line=br.readLine())!=null) {			
//			 String[] arr=line.split(",");				
//			   if(arr[0].equals(s)) {
//				System.out.print(arr[0]+",");		
//				String s2=line.replace(s,s1);
//				System.out.println(s2);
//			    }
//			}
		 System.out.println("删除 姓名");
		 String s=sc.next();
	
		StringBuffer sb=new StringBuffer();
		BufferedReader br=new BufferedReader(new FileReader("f:\\picture\\user.txt"));
		String line=null;
		while ((line=br.readLine())!=null) {			
			   String[] arr=line.split(",");				
			   if(arr[0].equals(s)) {
				System.out.print(arr[0]+",");		
				//String s2=line.replace(s,s1);
				//System.out.println(s2);
			    }else {
			    	sb.append(line).append("\r\n");
			    }
			    }
		BufferedWriter bw=new BufferedWriter(new FileWriter("f:\\picture\\user.txt"));   	    
	    System.out.println(sb.toString());
		bw.write(sb.toString());
		bw.close();
	}
}