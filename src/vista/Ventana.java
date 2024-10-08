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
    
    private String convertirAMurcielago(String texto) {
        // Definir los caracteres murciélago y sus equivalentes
        String[] letrasMurcielago = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "ñ", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        String[] letrasCodigoMurcielago = {"@", "|3", "[", "|)", "3", "|=", "6", "|-|", "1", "|_|", "|<", "|_", "|\\/|", "|\\|", "~", "0", "|*", "|_", "|2", "5", "|_|", "\\/\\/", "><", "'/", "2"};

        // Convertir el texto a minúsculas para la conversión
        texto = texto.toLowerCase();
        StringBuilder resultado = new StringBuilder();

        // Iterar sobre cada carácter del texto
        for (char c : texto.toCharArray()) {
            boolean encontrado = false;
            // Buscar el carácter en el arreglo de letras murciélago
            for (int i = 0; i < letrasMurcielago.length; i++) {
                if (c == letrasMurcielago[i].charAt(0)) {
                    // Agregar el equivalente del código murciélago
                    resultado.append(letrasCodigoMurcielago[i]);
                    encontrado = true;
                    break;
                }
            }
            // Si no se encuentra el carácter, agregarlo tal cual
            if (!encontrado) {
                resultado.append(c);
            }
        }

        return resultado.toString();
    }


    public void setClipboard(String texto){
        StringSelection txt = new StringSelection(texto);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(txt, this);
    }
    
    public void cutClipboard() {
        String texto = txt_texto_murcielago.getText();  // Obtener todo el texto del área de texto
        if (texto != null && !texto.isEmpty()) {
            StringSelection stringSelection = new StringSelection(texto);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
            txt_texto_murcielago.setText("");  // Eliminar todo el texto del área de texto
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
        txt_texto_murcielago = new javax.swing.JTextArea();
        btn_procesar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbl_longitud_texto = new javax.swing.JLabel();
        lbl_total_palabras = new javax.swing.JLabel();
        lbl_primera_letra = new javax.swing.JLabel();
        lbl_ultima_letra = new javax.swing.JLabel();
        lbl_letra_central = new javax.swing.JLabel();
        lbl_primera_palabra = new javax.swing.JLabel();
        lbl_palabra_central = new javax.swing.JLabel();
        lbl_ultima_palabra = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbl_cant_palabras_impar = new javax.swing.JLabel();
        lbl_repeticiones_a = new javax.swing.JLabel();
        lbl_repeticiones_e = new javax.swing.JLabel();
        lbl_repeticiones_i = new javax.swing.JLabel();
        lbl_repeticiones_o = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbl_repeticiones_u = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lbl_cant_pablabras_par = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
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

        txt_texto_murcielago.setColumns(20);
        txt_texto_murcielago.setFont(new java.awt.Font("Calibri Light", 2, 14)); // NOI18N
        txt_texto_murcielago.setRows(5);
        jScrollPane1.setViewportView(txt_texto_murcielago);

        btn_procesar.setFont(new java.awt.Font("Candara Light", 2, 14)); // NOI18N
        btn_procesar.setText("PROCESAR INFORMACION");
        btn_procesar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_procesarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Candara Light", 2, 14)); // NOI18N
        jLabel1.setText("Longitud del texto:");

        jLabel2.setFont(new java.awt.Font("Candara Light", 2, 14)); // NOI18N
        jLabel2.setText("Total de palabras:");

        jLabel3.setFont(new java.awt.Font("Candara Light", 2, 14)); // NOI18N
        jLabel3.setText("Primera letra del texto:");

        jLabel4.setFont(new java.awt.Font("Candara Light", 2, 14)); // NOI18N
        jLabel4.setText("Ultima letra del texto:");

        jLabel5.setFont(new java.awt.Font("Candara Light", 2, 14)); // NOI18N
        jLabel5.setText("Letra central del texto:");

        jLabel6.setFont(new java.awt.Font("Candara Light", 2, 14)); // NOI18N
        jLabel6.setText("Primera palabra:");

        jLabel7.setFont(new java.awt.Font("Candara Light", 2, 14)); // NOI18N
        jLabel7.setText("Palabra del medio:");

        jLabel8.setFont(new java.awt.Font("Candara Light", 2, 14)); // NOI18N
        jLabel8.setText("Ultima palabra:");

        lbl_longitud_texto.setFont(new java.awt.Font("Candara Light", 2, 14)); // NOI18N
        lbl_longitud_texto.setText("_");

        lbl_total_palabras.setFont(new java.awt.Font("Candara Light", 2, 14)); // NOI18N
        lbl_total_palabras.setText("_");

        lbl_primera_letra.setFont(new java.awt.Font("Candara Light", 2, 14)); // NOI18N
        lbl_primera_letra.setText("_");

        lbl_ultima_letra.setFont(new java.awt.Font("Candara Light", 2, 14)); // NOI18N
        lbl_ultima_letra.setText("_");

        lbl_letra_central.setFont(new java.awt.Font("Candara Light", 2, 14)); // NOI18N
        lbl_letra_central.setText("_");

        lbl_primera_palabra.setFont(new java.awt.Font("Candara Light", 2, 14)); // NOI18N
        lbl_primera_palabra.setText("_");

        lbl_palabra_central.setFont(new java.awt.Font("Candara Light", 2, 14)); // NOI18N
        lbl_palabra_central.setText("_");

        lbl_ultima_palabra.setFont(new java.awt.Font("Candara Light", 2, 14)); // NOI18N
        lbl_ultima_palabra.setText("_");

        jLabel9.setFont(new java.awt.Font("Candara Light", 2, 14)); // NOI18N
        jLabel9.setText("Repeticiones de \"A\" / \"a\"");

        jLabel10.setFont(new java.awt.Font("Candara Light", 2, 14)); // NOI18N
        jLabel10.setText("Repeticiones de \"E\" / \"e\"");

        lbl_cant_palabras_impar.setFont(new java.awt.Font("Candara Light", 2, 14)); // NOI18N
        lbl_cant_palabras_impar.setText("_");

        lbl_repeticiones_a.setFont(new java.awt.Font("Candara Light", 2, 14)); // NOI18N
        lbl_repeticiones_a.setText("_");

        lbl_repeticiones_e.setFont(new java.awt.Font("Candara Light", 2, 14)); // NOI18N
        lbl_repeticiones_e.setText("_");

        lbl_repeticiones_i.setFont(new java.awt.Font("Candara Light", 2, 14)); // NOI18N
        lbl_repeticiones_i.setText("_");

        lbl_repeticiones_o.setFont(new java.awt.Font("Candara Light", 2, 14)); // NOI18N
        lbl_repeticiones_o.setText("_");

        jLabel11.setFont(new java.awt.Font("Candara Light", 2, 14)); // NOI18N
        jLabel11.setText("Repeticiones de \"I\" / \"i\"");

        lbl_repeticiones_u.setFont(new java.awt.Font("Candara Light", 2, 14)); // NOI18N
        lbl_repeticiones_u.setText("_");

        jLabel12.setFont(new java.awt.Font("Candara Light", 2, 14)); // NOI18N
        jLabel12.setText("Repeticiones de \"O\" / \"o\"");

        lbl_cant_pablabras_par.setFont(new java.awt.Font("Candara Light", 2, 14)); // NOI18N
        lbl_cant_pablabras_par.setText("_");

        jLabel13.setFont(new java.awt.Font("Candara Light", 2, 14)); // NOI18N
        jLabel13.setText("Repeticiones de \"U\" / \"u\"");

        jLabel14.setFont(new java.awt.Font("Candara Light", 2, 14)); // NOI18N
        jLabel14.setText("Cant de palabras con longitud par");

        jLabel15.setFont(new java.awt.Font("Candara Light", 2, 14)); // NOI18N
        jLabel15.setText("Cant de palabras con longitud impar");

        txt_area_texto.setColumns(20);
        txt_area_texto.setFont(new java.awt.Font("Calibri Light", 2, 14)); // NOI18N
        txt_area_texto.setRows(5);
        jScrollPane2.setViewportView(txt_area_texto);

        bar_archivo.setText("Archivo");
        bar_archivo.setFont(new java.awt.Font("Calibri Light", 2, 14)); // NOI18N

        jMenuItem6.setText("Abrir");
        bar_archivo.add(jMenuItem6);

        item_guardar.setText("Guardar");
        bar_archivo.add(item_guardar);

        item_guardar_como.setText("Guardar como");
        bar_archivo.add(item_guardar_como);

        jMenuBar1.add(bar_archivo);

        bar_editar.setText("Editar");
        bar_editar.setFont(new java.awt.Font("Calibri Light", 2, 14)); // NOI18N

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_procesar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_longitud_texto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_total_palabras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_primera_letra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_ultima_letra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_letra_central, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_primera_palabra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_palabra_central, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_ultima_palabra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_repeticiones_a)
                            .addComponent(lbl_repeticiones_e)
                            .addComponent(lbl_repeticiones_i)
                            .addComponent(lbl_repeticiones_o)
                            .addComponent(lbl_repeticiones_u)
                            .addComponent(lbl_cant_pablabras_par)
                            .addComponent(lbl_cant_palabras_impar))
                        .addGap(70, 70, 70)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(btn_procesar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel10)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel11)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel12)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel13)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel14)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel15))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(lbl_repeticiones_a)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lbl_repeticiones_e)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lbl_repeticiones_i)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lbl_repeticiones_o)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lbl_repeticiones_u)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lbl_cant_pablabras_par)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lbl_cant_palabras_impar)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel8))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lbl_longitud_texto)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lbl_total_palabras)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lbl_primera_letra)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lbl_ultima_letra)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lbl_letra_central)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lbl_primera_palabra)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lbl_palabra_central)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lbl_ultima_palabra))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(345, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void item_copiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_copiarActionPerformed
        setClipboard(txt_texto_murcielago.getText());
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

    private void btn_procesarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_procesarActionPerformed
        String textoOriginal = txt_area_texto.getText();

         // Verificar que el texto no esté vacío
         if (textoOriginal.isEmpty()) {
             lbl_longitud_texto.setText("0");
             lbl_total_palabras.setText("0");
             lbl_primera_letra.setText("_");
             lbl_ultima_letra.setText("_");
             lbl_letra_central.setText("_");
             lbl_primera_palabra.setText("_");
             lbl_palabra_central.setText("_");
             lbl_ultima_palabra.setText("_");
             lbl_cant_pablabras_par.setText("0");
             lbl_cant_palabras_impar.setText("0");
             lbl_repeticiones_a.setText("0");
             lbl_repeticiones_e.setText("0");
             lbl_repeticiones_i.setText("0");
             lbl_repeticiones_o.setText("0");
             lbl_repeticiones_u.setText("0");
             txt_texto_murcielago.setText("");
             return;
         }

         // Longitud del texto
         int longitudTexto = textoOriginal.length();

         // Total de palabras
         String[] palabras = textoOriginal.split("\\s+");
         int totalPalabras = palabras.length;

         // Primer, última y letra central del texto
         char primeraLetra = textoOriginal.charAt(0);
         char ultimaLetra = textoOriginal.charAt(longitudTexto - 1);
         char letraCentral = textoOriginal.charAt(longitudTexto / 2);

         // Primera, central y última palabra
         String primeraPalabra = palabras[0];
         String ultimaPalabra = palabras[palabras.length - 1];
         String palabraCentral = palabras[palabras.length / 2];

         // Inicializar contadores para las vocales
         int repeticionesA = 0;
         int repeticionesE = 0;
         int repeticionesI = 0;
         int repeticionesO = 0;
         int repeticionesU = 0;

         // Inicializar contadores para palabras con longitud par e impar
         int cantPalabrasPar = 0;
         int cantPalabrasImpar = 0;

         // Contar las repeticiones de las vocales y palabras con longitud par e impar
         for (String palabra : palabras) {
             int longitudPalabra = palabra.length();
             if (longitudPalabra % 2 == 0) {
                 cantPalabrasPar++;
             } else {
                 cantPalabrasImpar++;
             }

             for (char c : palabra.toCharArray()) {
                 switch (Character.toLowerCase(c)) {
                     case 'a':
                         repeticionesA++;
                         break;
                     case 'e':
                         repeticionesE++;
                         break;
                     case 'i':
                         repeticionesI++;
                         break;
                     case 'o':
                         repeticionesO++;
                         break;
                     case 'u':
                         repeticionesU++;
                         break;
                 }
             }
         }

         // Actualizar los JLabels con los resultados
         lbl_longitud_texto.setText(String.valueOf(longitudTexto));
         lbl_total_palabras.setText(String.valueOf(totalPalabras));
         lbl_primera_letra.setText(String.valueOf(primeraLetra));
         lbl_ultima_letra.setText(String.valueOf(ultimaLetra));
         lbl_letra_central.setText(String.valueOf(letraCentral));
         lbl_primera_palabra.setText(primeraPalabra);
         lbl_palabra_central.setText(palabraCentral);
         lbl_ultima_palabra.setText(ultimaPalabra);
         lbl_cant_pablabras_par.setText(String.valueOf(cantPalabrasPar));
         lbl_cant_palabras_impar.setText(String.valueOf(cantPalabrasImpar));
         lbl_repeticiones_a.setText(String.valueOf(repeticionesA));
         lbl_repeticiones_e.setText(String.valueOf(repeticionesE));
         lbl_repeticiones_i.setText(String.valueOf(repeticionesI));
         lbl_repeticiones_o.setText(String.valueOf(repeticionesO));
         lbl_repeticiones_u.setText(String.valueOf(repeticionesU));

         // Convertir el texto a código murciélago
         String textoConvertido = convertirAMurcielago(textoOriginal);

         // Mostrar el texto convertido en otro JTextArea
         txt_texto_murcielago.setText(textoConvertido);
       }//GEN-LAST:event_btn_procesarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu bar_archivo;
    private javax.swing.JMenu bar_editar;
    private javax.swing.JButton btn_procesar;
    private javax.swing.JMenuItem item_buscar;
    private javax.swing.JMenuItem item_copiar;
    private javax.swing.JMenuItem item_cortar;
    private javax.swing.JMenuItem item_guardar;
    private javax.swing.JMenuItem item_guardar_como;
    private javax.swing.JMenuItem item_pegar;
    private javax.swing.JMenuItem item_procesar;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_cant_pablabras_par;
    private javax.swing.JLabel lbl_cant_palabras_impar;
    private javax.swing.JLabel lbl_letra_central;
    private javax.swing.JLabel lbl_longitud_texto;
    private javax.swing.JLabel lbl_palabra_central;
    private javax.swing.JLabel lbl_primera_letra;
    private javax.swing.JLabel lbl_primera_palabra;
    private javax.swing.JLabel lbl_repeticiones_a;
    private javax.swing.JLabel lbl_repeticiones_e;
    private javax.swing.JLabel lbl_repeticiones_i;
    private javax.swing.JLabel lbl_repeticiones_o;
    private javax.swing.JLabel lbl_repeticiones_u;
    private javax.swing.JLabel lbl_total_palabras;
    private javax.swing.JLabel lbl_ultima_letra;
    private javax.swing.JLabel lbl_ultima_palabra;
    private javax.swing.JTextArea txt_area_texto;
    private javax.swing.JTextArea txt_texto_murcielago;
    // End of variables declaration//GEN-END:variables

    @Override
    public void lostOwnership(Clipboard clipboard, Transferable contents) {
        throw new UnsupportedOperationException("Not supported yet."); 
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}



