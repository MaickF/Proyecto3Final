/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication6;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Fabian
 */
public class Eleccion extends javax.swing.JFrame {

    /**
     * Creates new form eleccion
     */
    public Eleccion() {
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

        panelEleccion = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        botonIngresar = new javax.swing.JButton();
        botonIgnorar = new javax.swing.JButton();
        labelFila = new javax.swing.JLabel();
        labelColumna = new javax.swing.JLabel();
        labelColor1 = new javax.swing.JLabel();
        labelColor2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Filas:");

        jLabel2.setText("Columnas:");

        jLabel3.setText("Color Jugador1:");

        jLabel4.setText("Color Jugador2:");

        botonIngresar.setText("Ingresar");
        botonIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIngresarActionPerformed(evt);
            }
        });

        botonIgnorar.setText("Ignorar");

        labelFila.setText("jLabel5");

        labelColumna.setText("jLabel6");

        labelColor1.setText("jLabel7");

        labelColor2.setText("jLabel8");

        javax.swing.GroupLayout panelEleccionLayout = new javax.swing.GroupLayout(panelEleccion);
        panelEleccion.setLayout(panelEleccionLayout);
        panelEleccionLayout.setHorizontalGroup(
            panelEleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEleccionLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(panelEleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botonIngresar)
                    .addGroup(panelEleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel4)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGroup(panelEleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEleccionLayout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(panelEleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelColor1)
                            .addComponent(labelColor2)
                            .addComponent(labelColumna)
                            .addComponent(labelFila))
                        .addContainerGap(52, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEleccionLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonIgnorar)
                        .addGap(44, 44, 44))))
        );
        panelEleccionLayout.setVerticalGroup(
            panelEleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEleccionLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(panelEleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(labelFila))
                .addGap(36, 36, 36)
                .addGroup(panelEleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(labelColumna))
                .addGap(34, 34, 34)
                .addGroup(panelEleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(labelColor1))
                .addGap(49, 49, 49)
                .addGroup(panelEleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(labelColor2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addGroup(panelEleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonIngresar)
                    .addComponent(botonIgnorar))
                .addGap(49, 49, 49))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelEleccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelEleccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIngresarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonIngresarActionPerformed

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
            java.util.logging.Logger.getLogger(Eleccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Eleccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Eleccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Eleccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Eleccion().setVisible(true);
            }
        });
    }

    public JButton getBotonIgnorar() {
        return botonIgnorar;
    }

    public void setBotonIgnorar(JButton botonIgnorar) {
        this.botonIgnorar = botonIgnorar;
    }

    public JButton getBotonIngresar() {
        return botonIngresar;
    }

    public void setBotonIngresar(JButton botonIngresar) {
        this.botonIngresar = botonIngresar;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    public JLabel getjLabel3() {
        return jLabel3;
    }

    public void setjLabel3(JLabel jLabel3) {
        this.jLabel3 = jLabel3;
    }

    public JLabel getjLabel4() {
        return jLabel4;
    }

    public void setjLabel4(JLabel jLabel4) {
        this.jLabel4 = jLabel4;
    }

    public JLabel getLabelColor1() {
        return labelColor1;
    }

    public void setLabelColor1(JLabel labelColor1) {
        this.labelColor1 = labelColor1;
    }

    public JLabel getLabelColor2() {
        return labelColor2;
    }

    public void setLabelColor2(JLabel labelColor2) {
        this.labelColor2 = labelColor2;
    }

    public JLabel getLabelColumna() {
        return labelColumna;
    }

    public void setLabelColumna(JLabel labelColumna) {
        this.labelColumna = labelColumna;
    }

    public JLabel getLabelFila() {
        return labelFila;
    }

    public void setLabelFila(JLabel labelFila) {
        this.labelFila = labelFila;
    }

    public JPanel getPanelEleccion() {
        return panelEleccion;
    }

    public void setPanelEleccion(JPanel panelEleccion) {
        this.panelEleccion = panelEleccion;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonIgnorar;
    private javax.swing.JButton botonIngresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel labelColor1;
    private javax.swing.JLabel labelColor2;
    private javax.swing.JLabel labelColumna;
    private javax.swing.JLabel labelFila;
    private javax.swing.JPanel panelEleccion;
    // End of variables declaration//GEN-END:variables
}