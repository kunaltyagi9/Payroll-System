import java.awt.*;
import javax.swing.*;

class splash{
    public static void main(String s[]){
        sframe f1 = new sframe("Payroll System  Free Licence Version 2.0"); 
        f1.setVisible(true); //show
        int i;
        int x=1;
        for(i=2;i<=600;i+=4,x+=1){
            f1.setLocation((800-((i+x)/2) ),500-(i/2));
            f1.setSize(i+x,i);
            
            try{
                Thread.sleep(10);
            }catch(Exception e) { }
        }
    }
}
class sframe extends JFrame implements Runnable{
    Thread t1;
    sframe(String s){
        super(s);
        setLayout(new FlowLayout());
        ImageIcon c1 = new ImageIcon(ClassLoader.getSystemResource("icon/payroll_system.jpg"));
        Image i1 = c1.getImage().getScaledInstance(730, 550,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        
        JLabel m1 = new JLabel(i2);
        add(m1);
        t1= new Thread(this);
        t1.start();
    }
    public void run(){
        try{
            Thread.sleep(7000);
            this.setVisible(false);
            login f1 = new login();
            
        }catch(Exception e){
            e.printStackTrace(); 
        }
    }
}