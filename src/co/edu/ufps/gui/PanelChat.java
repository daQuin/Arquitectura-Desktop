/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.gui;

import co.edu.ufps.controlador.Conexion;
import co.edu.ufps.modelo.Mensaje;
import co.edu.ufps.modelo.Usuario;
import java.awt.BorderLayout;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

/**
 *
 * @author dairo
 */
public class PanelChat extends javax.swing.JPanel {

    public FrameChat fc;
    public Conexion con;
    public Usuario remitente;
    public Usuario[] lista;

    /**
     * Creates new form PanelChat
     */
    public PanelChat(FrameChat frc, Usuario remi) {
        initComponents();
        fc = frc;
        fc.getContentPane().add(this, BorderLayout.CENTER);
        fc.pack();
        remitente = remi;
        this.lblUsuarioAct.setText("Bienvenido " + remitente.getUsuario());
        this.listarUsuarios();
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
        listUsuarios = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtChat = new javax.swing.JTextArea();
        txtMensaje = new javax.swing.JTextField();
        btnEnviar = new javax.swing.JButton();
        btnRefrsh = new javax.swing.JButton();
        lblUsuarioSel = new javax.swing.JLabel();
        lblUsuarioAct = new javax.swing.JLabel();

        listUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listUsuarios);

        jLabel1.setText("Lista de Usuarios");

        txtChat.setEditable(false);
        txtChat.setColumns(20);
        txtChat.setRows(5);
        jScrollPane2.setViewportView(txtChat);

        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        btnRefrsh.setText("Refresh");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addComponent(lblUsuarioAct, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblUsuarioSel, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(210, 210, 210)
                        .addComponent(btnRefrsh))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(txtMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnEnviar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUsuarioAct, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUsuarioSel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefrsh))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEnviar)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        // TODO add your handling code here:
        String mensaje = this.txtMensaje.getText();
        if (!mensaje.isEmpty()) {
            int id = this.listUsuarios.getSelectedIndex();
            Usuario destinatario = lista[id];
            try {
                con.enviarMensaje(mensaje, remitente, destinatario);
                Mensaje[] m = con.listarMensaje();
                for (int i = 0; i < m.length; i++) {
                    this.txtChat.setText(m[i].getRemitente().getUsuario() + " - " + m[i].getTexto());
                }
            } catch (IOException ex) {
                Logger.getLogger(PanelChat.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.txtMensaje.setText("");
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void listUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listUsuariosMouseClicked
        // TODO add your handling code here:
        String usuario = this.listUsuarios.getSelectedValue();
        this.lblUsuarioSel.setText(usuario);
    }//GEN-LAST:event_listUsuariosMouseClicked

    public void listarUsuarios() {
        DefaultListModel modeloLista = new DefaultListModel();
        this.listUsuarios.setModel(modeloLista);
        lista = con.listarUsuarios();
        modeloLista.addElement(lista);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton btnRefrsh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblUsuarioAct;
    private javax.swing.JLabel lblUsuarioSel;
    private javax.swing.JList<String> listUsuarios;
    private javax.swing.JTextArea txtChat;
    private javax.swing.JTextField txtMensaje;
    // End of variables declaration//GEN-END:variables
}
