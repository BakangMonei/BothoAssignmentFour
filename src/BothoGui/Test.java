/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BothoGui;


import javax.swing.*; 
import java.sql.*; 

    public class Test extends JFrame{ 
    JComboBox jc = new JComboBox(); 
    JPanel panel = new JPanel(); 
    Connection con; 
    Statement st; 
    ResultSet rs; 
    public Test() {
    this.setSize(400, 400); 
    this.setLocationRelativeTo(null); 
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
  
          try{ con = DriverManager.getConnection("jdbc:mysql://localhost/test_db","root",""); 
          st = con.createStatement(); 
          String s = "select * from users"; 
          rs = st.executeQuery(s); 
          while(rs.next()) { 
          jc.addItem(rs.getString(1)+" === "+rs.getString(2)); 
              } 
        }catch(Exception e){ 
             JOptionPane.showMessageDialog(null, "ERROR"); 
                    }finally{ 
             try{ 
                st.close(); 
                rs.close(); 
                con.close(); 
             }catch(Exception e){ 
                    JOptionPane.showMessageDialog(null, "ERROR CLOSE"); 
             } 
          } panel.add(jc); 
          this.getContentPane().add(panel); 
          this.setVisible(true); 
         } 
          public static void main(String[] args){ 
          new Test(); 
          }
 }