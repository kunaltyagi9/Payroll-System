import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class List_Attendence extends JFrame implements ActionListener{
  
    JTable j1;
    JButton b1;
    String h[]={"Emp id","Date Time","First Half","Second Half"};
    String d[][]=new String[15][4];  
    int i=0,j=0;
    
    List_Attendence(){
        super("View Employees Attendence");
        setSize(800,300);
        setLocation(450,150);

        try{
            String q="select * from attendence";
            conn c1=new conn();
            ResultSet rs=c1.s.executeQuery(q);
            while(rs.next()){
                d[i][j++]=rs.getString("id");
                d[i][j++]=rs.getString("date_tm");
                d[i][j++]=rs.getString("f_half");
                d[i][j++]=rs.getString("s_half");
                i++;
                j=0;
            }
        
            j1=new JTable(d,h);

        }catch(Exception e){}
        
        b1=new JButton("Print");
        add(b1,"South");
        JScrollPane s1=new JScrollPane(j1);
        add(s1);
        
        b1.addActionListener(this);
    
    }
    public void actionPerformed(ActionEvent ae){
        try{
            j1.print();
        }catch(Exception e){}
    }
    
    public static void main(String[] args){
        new List_Attendence().setVisible(true);
    }
}

