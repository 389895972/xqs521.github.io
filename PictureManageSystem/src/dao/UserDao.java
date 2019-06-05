package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entity.User;

public class UserDao {	
	Scanner sc=new Scanner(System.in);
	   List<String> list=new ArrayList<>();
	   FirstDao firstDao=new FirstDao();
      public void regist() throws Exception {
    	     System.out.println("\t\t**********************************");
			 System.out.println("\t\t*       ��ӭע��                *");
			 System.out.println("\t\t*     �������û���          *");
			 String name=sc.next();
			 System.out.println("\t\t*      ����������            *");
			 String password=sc.next();
			 System.out.println("\t\t*     �����뻭����          *");
			 String picture=sc.next();
			 System.out.println("\t\t*     ����������          *");
			 int age=sc.nextInt();
			 System.out.println("\t\t*     �������Ա�          *");
			 String sex=sc.next();	  
    	     BufferedWriter bw=new BufferedWriter(new FileWriter("f:\\picture\\user.txt",true));   	    
    	     BufferedReader br=new BufferedReader(new FileReader("f:\\picture\\user.txt"));
    	     String line=null;
    	     boolean flag = true;
    	     while((line=br.readLine())!=null) {    	   
//    	    	 int index=line.indexOf(":");
//    	    	 String s=line.substring(index+1, 5);
    	    	 String[] arr=line.split(",");
    	    	 if(name.equals(arr[0])) {
    	     		  flag=false;
    	     	    }    	   
    	     	    }
    	    if(flag) {
    		    User user=new User(name, password,picture,age,sex);
        	    bw.write(user.toString());
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
    	    	System.out.println("ע��ʧ�ܣ��Ѵ����û�");
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

    	      System.out.println("���¼");
			  System.out.println("�������û���");
			  String loginname=sc.next();
			  System.out.println("����������");
			  String loginpassword=sc.next();
	    	  BufferedReader br=new BufferedReader(new FileReader("f:\\\\picture\\\\user.txt"));
	    	  String line=null;
	    	  boolean flag=false;
	    	  while((line=br.readLine())!=null) {
	    		   String[] arr=line.split(",");
	    		   if(arr[0].equals(loginname)&&arr[1].equals(loginpassword)) {
	    			     flag=true;
	    			     for(int i=0;i<arr.length;i++) {
	    			    	 list.add(arr[i]);
	    			     }
	    			     break;
	    		   }  		
	    		   
	    	   }
	    	  if(flag) {
 				  System.out.println("�û�"+list.get(0)+"��¼�ɹ�,");  			  
 			    userPage();
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
    public void userPage() throws Exception {
		System.out.println("��ѡ�������");
		System.out.println("1.��ѯ������Ϣ 2.�޸ı�����Ϣ 3.�޸ı��˻��� 4.�˳�"); 
	    int x=sc.nextInt();
	    if(x==1) {
	    	query();
	    }else if(x==2) {
	    	update();
	    }else if(x==3) {
	    	updatePicture();
	    }else if(x==4) {
	    	firstDao.firstPage();
	    }else {
	    	System.out.println("�����������������");
	    }
    }
    public void show() throws IOException {
    	System.out.println("������Ϣ��");
    	System.out.println("����,���� ,���� ,����,�Ա�");
    	System.out.println(list);
    	
    }
    public void query() throws Exception {
    	System.out.println("������Ϣ��");
    	System.out.println("����,���� ,���� ,����,�Ա�");
    	System.out.println(list);
    	userPage();
    }
    public void update() throws Exception {
    	show();
    	System.out.println("==�޸�==");
    	System.out.println("��ѡ����Ҫ�޸ĵ��1.���� 2.���� 3.���� 4 �Ա�");
        int k=sc.nextInt();
        System.out.println("�������޸ĺ��ֵ");       
        String n=sc.next();
        list.set(k,n);
        System.out.println("�޸ĺ����Ϣ��");
        System.out.println("����,���� ,���� ,����,�Ա�");
        System.out.println(list);
        String ln=list.get(0);
        StringBuffer sb=new StringBuffer();
		BufferedReader br=new BufferedReader(new FileReader("f:\\picture\\user.txt"));
		String line=null;
		while ((line=br.readLine())!=null) {			
			   String[] arr=line.split(",");				
			   if(arr[0].equals(ln)) {
				   for(int i=0;i<list.size();i++) {
					   if(i<list.size()-1){
						   sb.append(list.get(i)+",");
						   } else {
							 sb.append(list.get(i)).append("\r\n");							
						   }					   
					   
				   }continue;			   
			   }sb.append(line).append("\r\n");  
			   }		
		BufferedWriter bw=new BufferedWriter(new FileWriter("f:\\picture\\user.txt"));   	    
	   // System.out.println(sb.toString());
		bw.write(sb.toString());
		bw.close();
		System.out.println("���³ɹ�����ѡ��");
		userPage();
    }
    public void updatePicture() throws Exception {
    	show();
    	System.out.println("==�޸Ļ���==");
    	System.out.println("�����뻭����");
    	String pn=sc.next();
    	StringBuffer sb=new StringBuffer();
		 BufferedReader br=new BufferedReader(new FileReader("f:\\picture\\user.txt"));
		 String line=null;
		while ((line=br.readLine())!=null) {			
			   String[] arr=line.split(",");				
			   if(arr[0].equals(list.get(0))) {
				System.out.println("�޸��û�<"+arr[0]+">�������Ϣ�ɹ�");
				 System.out.println("����,���� ,���� ,����,�Ա�");
				String s2=line.replace(arr[2],pn);
				System.out.println(s2);
				sb.append(s2).append("\r\n");
				continue;
			    }
			    sb.append(line).append("\r\n");			   
			    }
		BufferedWriter bw=new BufferedWriter(new FileWriter("f:\\picture\\user.txt"));   	    
	  // System.out.println(sb.toString());
		bw.write(sb.toString());
		bw.close();
		userPage();
    }
}
