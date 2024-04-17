import java.io.*;
import java.sql.*;
public class jdbcSetb1
{
    
    public static void main(String g[])
    {
   	 int ch;
   	 int rn;
   	 String nm="";
   	 float per;
   	 Statement st;
   	 Connection con;
   	 ResultSet rs,rs1;
   	 PreparedStatement pst1 ,pst2 ,pst3,pst4;
   	 BufferedReader br;
   	 
   	 try
   	 {
   		 Class.forName("org.postgresql.Driver");
   		 con=DriverManager.getConnection("jdbc:postgresql://localhost/stud","postgres","");
   		 br=new BufferedReader(new InputStreamReader(System.in));
   		 do
   		 {
   			 System.out.println("*********MENU*********"); System.out.println("\n1:Insert  \n2:Modify  \n3:Delete  \n4:Search  \n5:View All  \n6:Exit");
   			 System.out.println("\nEnter Your choice:");
   			 ch=Integer.parseInt(br.readLine());
   		 
   			 switch(ch)
   			 {
   				 case 1:
   					 System.out.println("Enter Roll no:");
   					 rn=Integer.parseInt(br.readLine());
   					 System.out.println("Enter Name:");
   					 nm=br.readLine();
   					 System.out.println("Enter Percentage:");
   					 per=Float.parseFloat(br.readLine());
   					 pst1=con.prepareStatement("Insert into student values(?,?,?)");
   					 pst1.setInt(1,rn);
   					 pst1.setString(2,nm);
   					 pst1.setFloat(3,per);
   					 pst1.executeUpdate();
   					 break;
   					 
   				 case 2:
   					 pst3=con.prepareStatement("update student set sname=?,per=? where rno=?");
   					 System.out.println("Enter roll no of student to update the datails:");
   					 rn=Integer.parseInt(br.readLine());
   					 System.out.println("Enter Name:");
   					 nm=br.readLine();
   					 System.out.println("Enter Percentage:");
   					 per=Float.parseFloat(br.readLine());
   					 pst3.setString(1,nm);
   					 pst3.setFloat(2,per);
   					 pst3.setInt(3,rn);
   					 pst3.executeUpdate();
   					 break;
   					 
   				 case 3:
   					 pst2=con.prepareStatement("delete from student where rno=?");
   					 System.out.println("Enter roll no of student should be deleted:");
   					 rn=Integer.parseInt(br.readLine());
   					 pst2.setInt(1,rn);
   					 pst2.executeUpdate();
   					 break;
   				 
   				 case 4:
   					 pst4=con.prepareStatement("select * from student where rno=?");
   					 System.out.println("Enter roll no of student to search the details:");
   					 rn=Integer.parseInt(br.readLine());
   					 pst4.setInt(1,rn);
   					 rs1=pst4.executeQuery();
   					 while(rs1.next())
   					 {
   						 System.out.println("\n");
   						 System.out.println(rs1.getInt(1));
   						 System.out.println(rs1.getString(2));
   						 System.out.println(rs1.getFloat(3)+"\n");
   					 }
   					 break;
   					 
   				 case 5:
   					 st=con.createStatement();
   				 rs=st.executeQuery("select * from student");
   					 System.out.println("\n");
   					 while(rs.next())
   					 {
   						 System.out.println(rs.getInt(1));
   						 System.out.println(rs.getString(2));
   						 System.out.println(rs.getFloat(3)+"\n");
   					 }
   					 break;
   				 
   				 case 6:
   					 System.exit(0);    
   					 break;
   			 }
   		 }
   		 while(ch!=6);
   	 }
   	 catch(Exception e){e.printStackTrace();}
    }
}


