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
		 System.out.println("\t\t*       欢迎管理员注册                *");
		 System.out.println("\t\t*     请输入用户名          *");
		 String name=sc.next();
		 System.out.println("\t\t*      请输入密码            *");
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
    	    System.out.println("注册成功,请选择操作：1注册 2.登录");
    	    int i=sc.nextInt();
			if(i==1) {
				 regist();    						
			 }else if(i==2) {
				login();
			 }else {
				 System.out.println("输入错误");
			 }
	    }else {	
	    	System.out.println("注册失败，已存在管理员");
	    	System.out.println("请选择操作：1.注册 2.登录");
			int i=sc.nextInt();
			if(i==1) {
				 regist();    						
			 }else if(i==2) {
				login();
			 }else {
				 System.out.println("输入错误");
			 }
	    }
    	 
    	 
     } 
	public void login() throws Exception {
    	     boolean flag = false;
    	     System.out.println("请输入管理员账户");
    	     String adminname=sc.next();
    	     System.out.println("请输入管理员密码");
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
				  System.out.print("管理员登录成功，");
				 adminpage();
			  }else {
				  System.out.println("登录失败");
				  System.out.println("请选择操作：1.注册 2.重新登录");
					 int j=sc.nextInt();
					 if(j==1) {
						   regist();
					 }else if(j==2) {
		                  login();
					 }else {
						 System.out.println("输入错误");
					 }
			  }			 
      }
	 public void query() throws Exception {
		 BufferedReader br=new BufferedReader(new FileReader("f:\\picture\\user.txt"));
		 String line=null;	
		 System.out.println("学生信息：");
		 System.out.println("姓名,密码 ,画像 ,年龄,性别");
		 while ((line=br.readLine())!=null) {			
			String[] arr=line.split(",");				
			for(String s:arr) {
				 System.out.print(s+",");				
			 }System.out.println("");
		 }
		 System.out.println("查询成功，");
		 adminpage();
	 }
	 public void add() throws Exception {
		 System.out.println("请输入增加学生的具体信息：");
		 System.out.println("请输入姓名：");
		 String name=sc.next();
		 System.out.println("请输入密码：");
		 String password=sc.next();
		 System.out.println("请输入画像：");
		 String picture=sc.next();
		 System.out.println("请输入年龄：");
		 int age=sc.nextInt();
		 System.out.println("请输入性别：");
		 String sex=sc.next();
         BufferedWriter bw=new BufferedWriter(new FileWriter("f:\\picture\\user.txt",true));		 		 
		 User user=new User(name,password,picture,age,sex);
 	     bw.write(user.toString());
 	     bw.newLine();
 	     bw.close();
 	     System.out.println("添加成功，");
 	    adminpage();
	 }
	 public void update() throws Exception {
		 show();
		 System.out.println("=====请修改=====");
		 System.out.println("请输入需要修改的用户姓名");
		 String s=sc.next();
		 System.out.println("请输入修改项：1.密码 2.画像 3.年龄 4.性别");
		 int m=sc.nextInt();
		 System.out.println("请输入替换的值");
		 String s1=sc.next();
		 StringBuffer sb=new StringBuffer();
		 BufferedReader br=new BufferedReader(new FileReader("f:\\picture\\user.txt"));
		String line=null;
		while ((line=br.readLine())!=null) {			
			   String[] arr=line.split(",");				
			   if(arr[0].equals(s)) {
				System.out.println("修改用户<"+arr[0]+">的相关信息成功");
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
		System.out.println("更新成功，");
		adminpage();
	 }
	 public void delete() throws Exception {
		 show();
		 System.out.println("请输入用户姓名");
		 String s=sc.next();
		 StringBuffer sb=new StringBuffer();
		 BufferedReader br=new BufferedReader(new FileReader("f:\\picture\\user.txt"));
		 String line=null;		
		 while ((line=br.readLine())!=null) {			
			   String[] arr=line.split(",");				
			   if(arr[0].equals(s)) {				
				   System.out.println("已查到学生"+arr[0]+",=====删除成功");		
			    }else {
			    	sb.append(line).append("\r\n");
			    }
			    }
		 BufferedWriter bw=new BufferedWriter(new FileWriter("f:\\picture\\user.txt"));   	    
	     System.out.println(sb.toString());
		 bw.write(sb.toString());
		 bw.close();
		 System.out.println("删除成功，");
		 adminpage();
	 }
	 public void adminpage() throws Exception {
		  System.out.println("请选择操作："); 
		  System.out.println("1.查询学生信息 2.增加学生信息 3.修改学生信息 4.删除学生信息 5.退出"); 
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
	    	  
	    	   System.out.println("=======退出成功，欢迎再次使用======");
	  	  
			 quit();
	      } else {
	    	  System.out.println("输入错误，请输入正确的数字");
	      }
	 }
	 public void show() throws Exception {
		 BufferedReader br=new BufferedReader(new FileReader("f:\\picture\\user.txt"));
		 String line=null;	
		 System.out.println("学生信息：");
		 System.out.println("姓名,密码 ,画像 ,年龄,性别");
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
		 System.out.println("欢迎管理员，请选择操作：1 .管理员登录 2.管理员注册3.退出");
	     int p=sc.nextInt();
		 if(p==1) {
			 login();
		 }else if(p==2) {
			 regist();
		 }else if(p==3) {
			 System.out.println("=======退出成功，欢迎再次使用======");
			firstDao.firstPage();
			
	
		 }else {
			 System.out.println("请正确输入");
			 firstDao.firstPage();
		 }
	 }
}
