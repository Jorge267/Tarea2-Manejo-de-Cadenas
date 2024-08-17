/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package vista;

/**
 *
 * @author JDani
 */
public class Buscar extends javax.swing.JDialog {

    private Ventana ventanaPrincipal;

    public Buscar(java.awt.Frame parent, boolean modal) {
        if(parent instanceof Ventana ventana) {
            this.ventanaPrincipal = ventana;
        } else {
            throw new IllegalArgumentException("El padre debe ser una instancia de Ventana.");
        }
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_texto_ingresado = new javax.swing.JTextField();
        btn_buscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btn_buscar.setText("Buscar");
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txt_texto_ingresado, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(btn_buscar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_texto_ingresado, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_buscar)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
           String textoBuscado = txt_texto_ingresado.getText().trim(); 
    String textoEnArea = ventanaPrincipal.getTxtAreaTexto().getText();

    System.out.println("Texto a buscar: " + textoBuscado);
    System.out.println("Texto en el área de texto: " + textoEnArea);

    if (textoBuscado.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this, "Ingrese un texto para buscar.", "Advertencia", javax.swing.JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    int posicion = textoEnArea.toLowerCase().indexOf(textoBuscado.toLowerCase()); 

    if (posicion >= 0) {
        ventanaPrincipal.getTxtAreaTexto().setCaretPosition(posicion);
        ventanaPrincipal.getTxtAreaTexto().select(posicion, posicion + textoBuscado.length());
    } else {
        javax.swing.JOptionPane.showMessageDialog(this, "Texto no encontrado", "Resultado de búsqueda", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }
    }//GEN-LAST:event_btn_buscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_buscar;
    private javax.swing.JTextField txt_texto_ingresado;
    // End of variables declaration//GEN-END:variables
}
