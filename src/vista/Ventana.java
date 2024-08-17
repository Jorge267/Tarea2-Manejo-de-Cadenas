/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.DataFlavor;


public class Ventana extends javax.swing.JFrame implements ClipboardOwner{

    public Ventana() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    public void setClipboard(String texto){
        StringSelection txt = new StringSelection(texto);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(txt, this);
    }
    
    public void cutClipboard() {
        String texto = txt_area_texto.getText();  // Obtener todo el texto del área de texto
        if (texto != null && !texto.isEmpty()) {
            StringSelection stringSelection = new StringSelection(texto);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
            txt_area_texto.setText("");  // Eliminar todo el texto del área de texto
        } else {
            System.out.println("No hay texto para cortar.");
        }
    }
    
    public javax.swing.JTextArea getTxtAreaTexto() {
        return txt_area_texto;
    }
    
    public void pasteFromClipboard() {
        try {
            // Obtener el contenido del portapapeles
            Transferable t = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);

            // Verificar que el contenido sea de tipo texto
            if (t != null && t.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                String texto = (String) t.getTransferData(DataFlavor.stringFlavor);
                txt_area_texto.insert(texto, txt_area_texto.getCaretPosition());  // Insertar el texto en la posición actual del cursor
            }
        } catch (Exception e) {
            System.out.println("Error al pegar el contenido del portapapeles: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txt_area_texto = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        bar_archivo = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        item_guardar = new javax.swing.JMenuItem();
        item_guardar_como = new javax.swing.JMenuItem();
        bar_editar = new javax.swing.JMenu();
        item_copiar = new javax.swing.JMenuItem();
        item_cortar = new javax.swing.JMenuItem();
        item_pegar = new javax.swing.JMenuItem();
        item_buscar = new javax.swing.JMenuItem();
        item_procesar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txt_area_texto.setColumns(20);
        txt_area_texto.setRows(5);
        jScrollPane1.setViewportView(txt_area_texto);

        bar_archivo.setText("Archivo");

        jMenuItem6.setText("Abrir");
        bar_archivo.add(jMenuItem6);

        item_guardar.setText("Guardar");
        bar_archivo.add(item_guardar);

        item_guardar_como.setText("Guardar como");
        bar_archivo.add(item_guardar_como);

        jMenuBar1.add(bar_archivo);

        bar_editar.setText("Editar");

        item_copiar.setText("Copiar");
        item_copiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_copiarActionPerformed(evt);
            }
        });
        bar_editar.add(item_copiar);

        item_cortar.setText("Cortar");
        item_cortar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_cortarActionPerformed(evt);
            }
        });
        bar_editar.add(item_cortar);

        item_pegar.setText("Pegar");
        item_pegar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_pegarActionPerformed(evt);
            }
        });
        bar_editar.add(item_pegar);

        item_buscar.setText("Buscar");
        item_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_buscarActionPerformed(evt);
            }
        });
        bar_editar.add(item_buscar);

        item_procesar.setText("Procesar");
        bar_editar.add(item_procesar);

        jMenuBar1.add(bar_editar);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void item_copiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_copiarActionPerformed
        setClipboard(txt_area_texto.getText());
    }//GEN-LAST:event_item_copiarActionPerformed

    private void item_cortarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_cortarActionPerformed
        cutClipboard();  
    }//GEN-LAST:event_item_cortarActionPerformed

    private void item_pegarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_pegarActionPerformed
        pasteFromClipboard();  // Pegar el contenido del portapapeles
    }//GEN-LAST:event_item_pegarActionPerformed

    private void item_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_buscarActionPerformed
       Buscar buscar = new Buscar(this, true);
       buscar.setVisible(true);
    }//GEN-LAST:event_item_buscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu bar_archivo;
    private javax.swing.JMenu bar_editar;
    private javax.swing.JMenuItem item_buscar;
    private javax.swing.JMenuItem item_copiar;
    private javax.swing.JMenuItem item_cortar;
    private javax.swing.JMenuItem item_guardar;
    private javax.swing.JMenuItem item_guardar_como;
    private javax.swing.JMenuItem item_pegar;
    private javax.swing.JMenuItem item_procesar;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txt_area_texto;
    // End of variables declaration//GEN-END:variables

    @Override
    public void lostOwnership(Clipboard clipboard, Transferable contents) {
        throw new UnsupportedOperationException("Not supported yet."); 
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}



