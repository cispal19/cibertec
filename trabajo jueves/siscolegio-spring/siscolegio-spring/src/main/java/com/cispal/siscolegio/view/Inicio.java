
package com.cispal.siscolegio.view;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Inicio extends javax.swing.JFrame {

    private ApplicationContext ctx;

    public void setCtx(ApplicationContext ctx) {
        this.ctx = ctx;
    }
    
    
    
    public Inicio() {
        initComponents();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        menualumnos = new javax.swing.JMenu();
        menucursos = new javax.swing.JMenu();
        menuprofesores = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        jMenu3.setText("jMenu3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenuBar1.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N

        jMenu4.setText("Inicio");
        jMenuBar1.add(jMenu4);

        jMenu5.setText("Mantenimiento");
        jMenu5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu5MouseClicked(evt);
            }
        });

        menualumnos.setText("Alumnos");
        menualumnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menualumnosMouseClicked(evt);
            }
        });
        jMenu5.add(menualumnos);

        menucursos.setText("Cursos");
        menucursos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menucursosMouseClicked(evt);
            }
        });
        jMenu5.add(menucursos);

        menuprofesores.setText("Profesores");
        menuprofesores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuprofesoresMouseClicked(evt);
            }
        });
        jMenu5.add(menuprofesores);

        jMenuBar1.add(jMenu5);

        jMenu6.setText("Consultas");

        jMenuItem1.setText("Consulta Alumno");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem1);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 998, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 538, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menualumnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menualumnosMouseClicked
        // TODO add your handling code here:
//        FRMAlumnos f=new FRMAlumnos();
//        f.show();
    }//GEN-LAST:event_menualumnosMouseClicked

    private void menucursosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menucursosMouseClicked
        // TODO add your handling code here:
//        FRMCursos f=new FRMCursos();
//        f.show();
    }//GEN-LAST:event_menucursosMouseClicked

    private void menuprofesoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuprofesoresMouseClicked
        // TODO add your handling code here:
//        FRMProfesores f=new FRMProfesores();
//        f.show();
    }//GEN-LAST:event_menuprofesoresMouseClicked

    private void jMenu5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jMenu5MouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
       ConsultaAlumnoDniCache a = new ConsultaAlumnoDniCache();
       a.show();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               Inicio ini= new Inicio();
               ini.setCtx(new AnnotationConfigApplicationContext(com.cispal.siscolegio.ApplicationContext.class));
                ini.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenu menualumnos;
    private javax.swing.JMenu menucursos;
    private javax.swing.JMenu menuprofesores;
    // End of variables declaration//GEN-END:variables
}
