package Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.xml.crypto.Data;

import dao.AdminDao;
import dao.FirstDao;
import dao.UserDao;

public class First {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub			
		AdminDao ad=new AdminDao();
		UserDao ud=new UserDao();
		Date date=new Date();
		Map<String, String> map=new HashMap<String, String>();
		map.put("admin","123456");
		FirstDao firstDao=new FirstDao();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String s=sdf.format(date);	
		 Scanner sc=new Scanner(System.in);
		 System.out.println("\t\t**********************************");
		 System.out.println("\t\t*             ��ӭʹ��                        *");
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
			  String ss=map.get("admin");
			  if(adpw.equals(ss)) {
				  System.out.println("===����Ա��¼�ɹ�===");
				  ad.index();
				  }else {
					  System.out.println("�����ǹ���Ա");
					  firstDao.firstPage();
				  }
		      break;
		 default: System.out.println("������������������");
			break;
		}
	}
}
