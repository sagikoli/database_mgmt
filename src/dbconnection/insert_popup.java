/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author sagik
 */
public class insert_popup extends javax.swing.JFrame {
int col=0;
 String colm[]=new String[10];
 String type[]=new String[10];
    /**
     * Creates new form insert_popup
     */
    public insert_popup() throws SQLException {
        initComponents();
        this.setVisible(true);
String url=variables.url+variables.dbname;
        Connection c=DriverManager.getConnection(url, "root", "pass@123");
        PreparedStatement p=c.prepareStatement("select * from "+variables.table);
        ResultSet rs=p.executeQuery();
        ResultSetMetaData rmd=rs.getMetaData();
       col=rmd.getColumnCount();
        DefaultTableModel m=(DefaultTableModel) DbUtils.resultSetToTableModel(rs);
        jTable1.setModel(m);
        m.addRow(new Object[col]);
      
        
    
       for(int i=0;i<col;i++)
       {
          
           colm[i]=rmd.getColumnName(i+1);
           type[i]=rmd.getColumnTypeName(i+1);
       }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("refresh table");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("add");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(149, 149, 149))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(62, 62, 62))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    try {
        String query="Insert into "+variables.table;
         int i=0;
        //for(i=0;i<col-1;i++)
        //query+=colm[i]+",";
        //query+=colm[i]+")";
        query+=" values(";    
        int r=jTable1.getRowCount();
        r--;
        i=1;
        System.out.println(type[1]);
        for( i=0;i<col-1;i++)
        {
            
            if(type[i].equals("VARCHAR"))
                query+="'"+(String)jTable1.getValueAt(r, i)+"'"+",";
            else
                query+=(String)jTable1.getValueAt(r, i)+",";
        }
        if(type[i].equals("VARCHAR"))
            query+="'"+(String)jTable1.getValueAt(r, i)+"'";
        else
            query+=(String)jTable1.getValueAt(r, i);
        query+=")";
        System.out.println(query);
        String url=variables.url+variables.dbname;
        Connection c=DriverManager.getConnection(url, "root", "pass@123");
        Statement st=c.createStatement();
        st.executeUpdate(query);
        
    } catch (SQLException ex) {
        Logger.getLogger(insert_popup.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    try {
        // TODO add your handling code here:
        String url=variables.url+variables.dbname;
        Connection c=DriverManager.getConnection(url, "root", "pass@123");
        PreparedStatement p=c.prepareStatement("select * from "+variables.table);
        ResultSet rs=p.executeQuery();
        ResultSetMetaData rmd=rs.getMetaData();
        col=rmd.getColumnCount();
        DefaultTableModel m=(DefaultTableModel) DbUtils.resultSetToTableModel(rs);
        jTable1.setModel(m);
        m.addRow(new Object[col]);
        
        
        
        for(int i=0;i<col;i++)
        {
            
            colm[i]=rmd.getColumnName(i+1);
            type[i]=rmd.getColumnTypeName(i+1);
        }
    } catch (SQLException ex) {
        Logger.getLogger(insert_popup.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
