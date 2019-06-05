package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entity.Admin;
import entity.User;

public class AdminDao {
	Scanner sc=new Scanner(System.in);
	FirstDao firstDao=new FirstDao();
     public void regist() throws Exception {
    	 System.out.println("\t\t**********************************");
		 System.out.println("\t\t*       ��ӭ����Աע��                *");
		 System.out.println("\t\t*     �������û���          *");
		 String name=sc.next();
		 System.out.println("\t\t*      ����������            *");
		 String password=sc.next();
    	 BufferedWriter bw=new BufferedWriter(new FileWriter("f:\\picture\\admin.txt",true));   	    
	     BufferedReader br=new BufferedReader(new FileReader("f:\\picture\\admin.txt"));
	     String line=null;
	     boolean flag = true;
	     while((line=br.readLine())!=null) {    	   
	    	 String[] arr=line.split(",");
	    	 if(name.equals(arr[0])) {
	     		  flag=false;
	     	    }    	   
	     	    }
	    if(flag) {
		    Admin admin=new Admin(name, password);
    	    bw.write(admin.toString());
    	    bw.newLine();
    	    bw.close();
    	    System.out.println("ע��ɹ�,��ѡ�������1ע�� 2.��¼");
    	    int i=sc.nextInt();
			if(i==1) {
				 regist();    						
			 }else if(i==2) {
				login();
			 }else {
				 System.out.println("�������");
			 }
	    }else {	
	    	System.out.println("ע��ʧ�ܣ��Ѵ��ڹ���Ա");
	    	System.out.println("��ѡ�������1.ע�� 2.��¼");
			int i=sc.nextInt();
			if(i==1) {
				 regist();    						
			 }else if(i==2) {
				login();
			 }else {
				 System.out.println("�������");
			 }
	    }
    	 
    	 
     } 
	public void login() throws Exception {
    	     boolean flag = false;
    	     System.out.println("���������Ա�˻�");
    	     String adminname=sc.next();
    	     System.out.println("���������Ա����");
			 String adminpassword=sc.next();
			 BufferedReader br=new BufferedReader(new FileReader("f:\\picture\\admin.txt"));
	    	  String line=null;
	    	  boolean flag1=false;
	    	  while((line=br.readLine())!=null) {
	    		   String[] arr=line.split(",");
	    		   if(arr[0].equals(adminname)&&arr[1].equals(adminpassword)) {
	    			     flag=true;
	    			     break;
	    		   }  		   
	    	   }
			  if(flag) {
				  System.out.print("����Ա��¼�ɹ���");
				 adminpage();
			  }else {
				  System.out.println("��¼ʧ��");
				  System.out.println("��ѡ�������1.ע�� 2.���µ�¼");
					 int j=sc.nextInt();
					 if(j==1) {
						   regist();
					 }else if(j==2) {
		                  login();
					 }else {
						 System.out.println("�������");
					 }
			  }			 
      }
	 public void query() throws Exception {
		 BufferedReader br=new BufferedReader(new FileReader("f:\\picture\\user.txt"));
		 String line=null;	
		 System.out.println("ѧ����Ϣ��");
		 System.out.println("����,���� ,���� ,����,�Ա�");
		 while ((line=br.readLine())!=null) {			
			String[] arr=line.split(",");				
			for(String s:arr) {
				 System.out.print(s+",");				
			 }System.out.println("");
		 }
		 System.out.println("��ѯ�ɹ���");
		 adminpage();
	 }
	 public void add() throws Exception {
		 System.out.println("����������ѧ���ľ�����Ϣ��");
		 System.out.println("������������");
		 String name=sc.next();
		 System.out.println("���������룺");
		 String password=sc.next();
		 System.out.println("�����뻭��");
		 String picture=sc.next();
		 System.out.println("���������䣺");
		 int age=sc.nextInt();
		 System.out.println("�������Ա�");
		 String sex=sc.next();
         BufferedWriter bw=new BufferedWriter(new FileWriter("f:\\picture\\user.txt",true));		 		 
		 User user=new User(name,password,picture,age,sex);
 	     bw.write(user.toString());
 	     bw.newLine();
 	     bw.close();
 	     System.out.println("��ӳɹ���");
 	    adminpage();
	 }
	 public void update() throws Exception {
		 show();
		 System.out.println("=====���޸�=====");
		 System.out.println("��������Ҫ�޸ĵ��û�����");
		 String s=sc.next();
		 System.out.println("�������޸��1.���� 2.���� 3.���� 4.�Ա�");
		 int m=sc.nextInt();
		 System.out.println("�������滻��ֵ");
		 String s1=sc.next();
		 StringBuffer sb=new StringBuffer();
		 BufferedReader br=new BufferedReader(new FileReader("f:\\picture\\user.txt"));
		String line=null;
		while ((line=br.readLine())!=null) {			
			   String[] arr=line.split(",");				
			   if(arr[0].equals(s)) {
				System.out.println("�޸��û�<"+arr[0]+">�������Ϣ�ɹ�");
				String c=arr[m];
				String s2=line.replace(c,s1);
				//System.out.println(s2);
				sb.append(s2).append("\r\n");
				continue;
			    }
			    sb.append(line).append("\r\n");			   
			    }
		BufferedWriter bw=new BufferedWriter(new FileWriter("f:\\picture\\user.txt"));   	    
	    System.out.println(sb.toString());
		bw.write(sb.toString());
		bw.close();
		System.out.println("���³ɹ���");
		adminpage();
	 }
	 public void delete() throws Exception {
		 show();
		 System.out.println("�������û�����");
		 String s=sc.next();
		 StringBuffer sb=new StringBuffer();
		 BufferedReader br=new BufferedReader(new FileReader("f:\\picture\\user.txt"));
		 String line=null;		
		 while ((line=br.readLine())!=null) {			
			   String[] arr=line.split(",");				
			   if(arr[0].equals(s)) {				
				   System.out.println("�Ѳ鵽ѧ��"+arr[0]+",=====ɾ���ɹ�");		
			    }else {
			    	sb.append(line).append("\r\n");
			    }
			    }
		 BufferedWriter bw=new BufferedWriter(new FileWriter("f:\\picture\\user.txt"));   	    
	     System.out.println(sb.toString());
		 bw.write(sb.toString());
		 bw.close();
		 System.out.println("ɾ���ɹ���");
		 adminpage();
	 }
	 public void adminpage() throws Exception {
		  System.out.println("��ѡ�������"); 
		  System.out.println("1.��ѯѧ����Ϣ 2.����ѧ����Ϣ 3.�޸�ѧ����Ϣ 4.ɾ��ѧ����Ϣ 5.�˳�"); 
	      int m=sc.nextInt();
	      if(m==1) {
	    	  query();
	      }else if(m==2) {
	    	   add();
	      }else if(m==3) {
	    	 update();
	      }else if(m==4) {
	    	  delete();
	      }else if (m==5){
	    	  
	    	   System.out.println("=======�˳��ɹ�����ӭ�ٴ�ʹ��======");
	  	  
			 quit();
	      } else {
	    	  System.out.println("���������������ȷ������");
	      }
	 }
	 public void show() throws Exception {
		 BufferedReader br=new BufferedReader(new FileReader("f:\\picture\\user.txt"));
		 String line=null;	
		 System.out.println("ѧ����Ϣ��");
		 System.out.println("����,���� ,���� ,����,�Ա�");
		 while ((line=br.readLine())!=null) {			
			String[] arr=line.split(",");				
			for(String s:arr) {
				 System.out.print(s+",");				
			 }System.out.println("");
		 } 
	 }
	 public void quit() throws Exception {
		 firstDao.firstPage();
	 }
	 public void index() throws Exception {
		 System.out.println("��ӭ����Ա����ѡ�������1 .����Ա��¼ 2.����Աע��3.�˳�");
	     int p=sc.nextInt();
		 if(p==1) {
			 login();
		 }else if(p==2) {
			 regist();
		 }else if(p==3) {
			 System.out.println("=======�˳��ɹ�����ӭ�ٴ�ʹ��======");
			firstDao.firstPage();
			
	
		 }else {
			 System.out.println("����ȷ����");
			 firstDao.firstPage();
		 }
	 }
}
