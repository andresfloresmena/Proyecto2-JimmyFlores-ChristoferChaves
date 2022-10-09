package CLIENT.presentation.navegación;

import java.util.Observable;

public class View extends javax.swing.JFrame implements java.util.Observer {
     
    //**************  MVC ***********
    Controller controller;
    Model model;
    
    public void setController(Controller controller){
        this.controller=controller;
    }

    public Controller getController() {
        return controller;
    }
    
    public void setModel(Model model){
        this.model=model;
         model.addObserver(this);
    }

    public Model getModel() {
        return model;
    }
    
    @Override
    public void update(Observable o, Object arg) {
        
    }
//************** END MVC ***********
    
   
    public View() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        salir = new javax.swing.JButton();
        changePass = new javax.swing.JButton();
        retiros = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        changePass.setText("Cambiar Contrasena");
        changePass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePassActionPerformed(evt);
            }
        });

        retiros.setText("Retiros");
        retiros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                retirosMouseClicked(evt);
            }
        });
        retiros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retirosActionPerformed(evt);
            }
        });

        jLabel1.setText("BIENVENIDO/A");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel1))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(changePass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(retiros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(salir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(111, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(retiros)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(changePass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(salir)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void retirosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_retirosMouseClicked
      
    }//GEN-LAST:event_retirosMouseClicked

    private void retirosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retirosActionPerformed
        // TODO add your handling code here:
        controller.retiroShow();
    }//GEN-LAST:event_retirosActionPerformed

    private void changePassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePassActionPerformed
        // TODO add your handling code here:
        controller.cambioContraseñaShow();
    }//GEN-LAST:event_changePassActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        controller.exit();
    }//GEN-LAST:event_formWindowClosing

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        // TODO add your handling code here:
         controller.salir();
    }//GEN-LAST:event_salirActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton changePass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton retiros;
    private javax.swing.JButton salir;
    // End of variables declaration//GEN-END:variables
}
