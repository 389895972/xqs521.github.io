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
 		 System.out.println("\t\t*                 ��ӭʹ��                        *");
 		 System.out.println("\t\t*  ��ѡ��1.ע�� 2.�û���¼ 3.����Ա��¼           *");
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
 			 System.out.println("����������̨����");
 			  String adpw=sc.next(); 			 
 			  if(adpw.equals("123456")) {
 				  ad.login();
 				  }else {
 					  System.out.println("�����ǹ���Ա");
 					  firstPage();
 				  }
 		      break;
 		 default: System.out.println("������������������");
 			break;
 		}
 	}	
}
