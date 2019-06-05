package dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class FirstDao {
     public void firstPage() throws Exception {
    	 AdminDao ad=new AdminDao();
 		UserDao ud=new UserDao();
 		Date date=new Date();
 		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
 		String s=sdf.format(date);	
 		 Scanner sc=new Scanner(System.in);
 		 System.out.println("\t\t**********************************");
 		 System.out.println("\t\t*                 欢迎使用                        *");
 		 System.out.println("\t\t*  请选择：1.注册 2.用户登录 3.管理员登录           *");
 		 System.out.println("\t\t\t\t\t\t"+s);
 		 String n=sc.next();
 		 switch (n) {
 		 case "1":
 			  ud.regist();			
 			 break;
 		 case "2":
 			  ud.login();
 			  break;
 		 case "3":
 			 System.out.println("请输入管理后台密码");
 			  String adpw=sc.next(); 			 
 			  if(adpw.equals("123456")) {
 				  ad.login();
 				  }else {
 					  System.out.println("您不是管理员");
 					  firstPage();
 				  }
 		      break;
 		 default: System.out.println("输入有误，请重新输入");
 			break;
 		}
 	}	
}
