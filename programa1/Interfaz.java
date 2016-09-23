/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.programa1;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author orlandojose
 */
public class Interfaz extends javax.swing.JFrame {

    /**
     * Creates new form Interfaz
     */
    public Interfaz() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaSismos = new javax.swing.JTable();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        Fecha = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        Magnitud = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        Profundidad = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        OrigenSismo = new javax.swing.JComboBox(Origen.values());
        jLabel13 = new javax.swing.JLabel();
        ProvinciaSismo = new javax.swing.JComboBox(Provincia.values());
        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Descripcion = new javax.swing.JTextArea();
        jLabel15 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        Latitud = new javax.swing.JTextField();
        Longitud = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox(Provincia.values());
        jLabel6 = new javax.swing.JLabel();
        NotificarCorreo = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        NotificarCelular = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout());

        jTabbedPane1.setToolTipText("Sismos");

        TablaSismos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Magnitud", "Profundidad", "Valor Magnitud", "Origen", "Provincia", "Descripcion", "Latitud", "Longitud", "Mapa", "Editar"
            }
        ));
        jScrollPane2.setViewportView(TablaSismos);

        jTabbedPane1.addTab("Sismos", jScrollPane2);

        jPanel2.setLayout(new java.awt.GridLayout(9, 2));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Fecha y Hora (Formato: dd/MM/yyyy HH:mm:ss)");
        jPanel2.add(jLabel8);
        jPanel2.add(Fecha);

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Magnitud");
        jPanel2.add(jLabel10);

        Magnitud.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        Magnitud.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                MagnitudFocusGained(evt);
            }
        });
        jPanel2.add(Magnitud);

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Profundidad (kilómetros)");
        jPanel2.add(jLabel11);

        Profundidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProfundidadActionPerformed(evt);
            }
        });
        jPanel2.add(Profundidad);

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Origen");
        jPanel2.add(jLabel12);

        OrigenSismo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrigenSismoActionPerformed(evt);
            }
        });
        jPanel2.add(OrigenSismo);

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Provincia");
        jPanel2.add(jLabel13);

        jPanel2.add(ProvinciaSismo);

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Descripción");
        jPanel2.add(jLabel14);

        Descripcion.setColumns(20);
        Descripcion.setRows(5);
        jScrollPane1.setViewportView(Descripcion);

        jPanel2.add(jScrollPane1);

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Ubicación Exacta (Latitud,Longitud)");
        jPanel2.add(jLabel15);

        jPanel5.setLayout(new java.awt.GridLayout(1, 2));

        Latitud.setToolTipText("");
        Latitud.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                LatitudFocusGained(evt);
            }
        });
        Latitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LatitudActionPerformed(evt);
            }
        });
        jPanel5.add(Latitud);

        Longitud.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                LongitudFocusGained(evt);
            }
        });
        Longitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LongitudActionPerformed(evt);
            }
        });
        jPanel5.add(Longitud);

        jPanel2.add(jPanel5);

        jButton3.setText("Registrar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);

        jTabbedPane2.addTab("Nuevo Sismo", jPanel2);

        jTabbedPane1.addTab("Registrar Sismo", jTabbedPane2);

        jPanel1.setLayout(new java.awt.GridLayout(7, 2));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Nombre");
        jPanel1.add(jLabel2);
        jPanel1.add(jTextField2);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Correo");
        jPanel1.add(jLabel3);
        jPanel1.add(jTextField3);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Celular");
        jPanel1.add(jLabel4);
        jPanel1.add(jTextField4);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Provincias");
        jPanel1.add(jLabel5);

        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox2);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Notificar Correo");
        jPanel1.add(jLabel6);
        jPanel1.add(NotificarCorreo);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Notificar Celular");
        jPanel1.add(jLabel7);
        jPanel1.add(NotificarCelular);

        jButton1.setText("Registrar");
        jPanel1.add(jButton1);

        jTabbedPane4.addTab("Nuevo Usuario", jPanel1);

        jTabbedPane1.addTab("Registrar Usuario", jTabbedPane4);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LongitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LongitudActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LongitudActionPerformed

    private void OrigenSismoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrigenSismoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_OrigenSismoActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void LatitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LatitudActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LatitudActionPerformed

    private void LatitudFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_LatitudFocusGained
       
    }//GEN-LAST:event_LatitudFocusGained

    private void LongitudFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_LongitudFocusGained
   
    }//GEN-LAST:event_LongitudFocusGained

    private void MagnitudFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_MagnitudFocusGained
       
    }//GEN-LAST:event_MagnitudFocusGained

    private void ProfundidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProfundidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProfundidadActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Sismo s1 = new Sismo(Fecha.getText(),
                Profundidad.getText(),
                (Origen)OrigenSismo.getSelectedItem(),
                Magnitud.getText(),
                Latitud.getText(),
                Longitud.getText(),
                Descripcion.getText(),
                (Provincia)ProvinciaSismo.getSelectedItem());
        DefaultTableModel model = (DefaultTableModel) TablaSismos.getModel();
        model.addRow(new Object[]{s1.getFecha(),
                                  s1.getMagnitud(),
                                  s1.getProfundidad(),
                                  "---",
                                  s1.getOrigen(),
                                  s1.getProvincia(),
                                  s1.getDescripcion(),
                                  s1.getLatitud(),
                                  s1.getLongitud(),
                                  "-",
                                  "-"});
        TablaSismos.setModel(model);
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Descripcion;
    private javax.swing.JTextField Fecha;
    private javax.swing.JTextField Latitud;
    private javax.swing.JTextField Longitud;
    private javax.swing.JTextField Magnitud;
    private javax.swing.JRadioButton NotificarCelular;
    private javax.swing.JRadioButton NotificarCorreo;
    private javax.swing.JComboBox OrigenSismo;
    private javax.swing.JTextField Profundidad;
    private javax.swing.JComboBox ProvinciaSismo;
    private javax.swing.JTable TablaSismos;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}