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
			 System.out.println("\t\t*       欢迎注册                *");
			 System.out.println("\t\t*     请输入用户名          *");
			 String name=sc.next();
			 System.out.println("\t\t*      请输入密码            *");
			 String password=sc.next();
			 System.out.println("\t\t*     请输入画像名          *");
			 String picture=sc.next();
			 System.out.println("\t\t*     请输入年龄          *");
			 int age=sc.nextInt();
			 System.out.println("\t\t*     请输入性别          *");
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
    	    	System.out.println("注册失败，已存在用户");
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

    	      System.out.println("请登录");
			  System.out.println("请输入用户名");
			  String loginname=sc.next();
			  System.out.println("请输入密码");
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
 				  System.out.println("用户"+list.get(0)+"登录成功,");  			  
 			    userPage();
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
    public void userPage() throws Exception {
		System.out.println("请选择操作：");
		System.out.println("1.查询本人信息 2.修改本人信息 3.修改本人画像 4.退出"); 
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
	    	System.out.println("输入错误，请重新输入");
	    }
    }
    public void show() throws IOException {
    	System.out.println("您的信息：");
    	System.out.println("姓名,密码 ,画像 ,年龄,性别");
    	System.out.println(list);
    	
    }
    public void query() throws Exception {
    	System.out.println("您的信息：");
    	System.out.println("姓名,密码 ,画像 ,年龄,性别");
    	System.out.println(list);
    	userPage();
    }
    public void update() throws Exception {
    	show();
    	System.out.println("==修改==");
    	System.out.println("请选择需要修改的项：1.密码 2.画像 3.年龄 4 性别");
        int k=sc.nextInt();
        System.out.println("请输入修改后的值");       
        String n=sc.next();
        list.set(k,n);
        System.out.println("修改后的信息：");
        System.out.println("姓名,密码 ,画像 ,年龄,性别");
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
		System.out.println("更新成功，请选择：");
		userPage();
    }
    public void updatePicture() throws Exception {
    	show();
    	System.out.println("==修改画像==");
    	System.out.println("请输入画像名");
    	String pn=sc.next();
    	StringBuffer sb=new StringBuffer();
		 BufferedReader br=new BufferedReader(new FileReader("f:\\picture\\user.txt"));
		 String line=null;
		while ((line=br.readLine())!=null) {			
			   String[] arr=line.split(",");				
			   if(arr[0].equals(list.get(0))) {
				System.out.println("修改用户<"+arr[0]+">的相关信息成功");
				 System.out.println("姓名,密码 ,画像 ,年龄,性别");
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
