package test;


import com.jaunt.Element;
import com.jaunt.Elements;
import com.jaunt.NotFound;
import com.jaunt.UserAgent;
import java.util.*;


public class Moodle {

	String username,password;
	UserAgent userAgent;
	public Moodle(String u,String p)
	{
		username=u;
		password=p;
		login();
	}
	
	void login()
	{
		try
		{
		userAgent= new UserAgent(); 
		String passing = "username="+username+"&password="+password;
	
		userAgent.sendPOST("http://112.133.242.241/moodle/login/index.php", 
				  passing);
		 
		}
		catch(Exception e){}
		
		visit();
	}
	
	void visit()
	{
		try
		{
		 userAgent.visit("http://112.133.242.241/moodle/grade/report/overview/index.php");
		}
		catch(Exception e){}
	}
	
	LinkedList<String> fetchAttendance()
	{
		int i=0,j=0;
		LinkedList<String> attendance =new LinkedList<String>();
		
		try
		{
			Element table = userAgent.doc.findFirst("<table id=\"overview-grade\">");  //find table element
		
		  Elements trs = table.findFirst("<tbody>").findEach("<tr>");                         //find non-nested td/th elements
		  for(Element tr: trs)
		  {
			  
			if(!tr.getAt("class").equals("emptyrow"))
			{
			    Elements tds = tr.findEach("<td>");
			    Element td1=tds;
			    Element a=null;	
			    
			    td1.findFirst("<a>");
			    for(Element td:tds)
			    {
			    	try
			    	{
			    		a = td.findFirst("<a href>");
			    		if(i==0)
			    		{
			    			i++;
			    		}
			    		else
			    		{
			    			attendance.add(a.getText());
			    		}
			    	}
			    	catch(NotFound e)
			    	{
			    		if(j==0)
			    		{
			    			j++;
			    		}
			    		else
			    		{
			    			attendance.add(td.getText().trim());
			    		}	
			    	}	
			    }
			 	}
		  }
		}
		catch(Exception e){}
		
		return attendance;
	}
	
}
