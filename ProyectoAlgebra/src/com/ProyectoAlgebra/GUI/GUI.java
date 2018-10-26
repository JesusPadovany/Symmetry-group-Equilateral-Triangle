/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProyectoAlgebra.GUI;
import com.ProyectoAlgebra.clases.Permutacion;
import com.ProyectoAlgebra.clases.Subgrupo;
import com.ProyectoAlgebra.clases.TrianguloEquilatero;
import java.net.URL;
import java.util.ArrayList;
import java.util.Stack;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



public class GUI extends javax.swing.JFrame {
    
    //Atributos
    protected DefaultTableModel modelT;                                         //Moldes para las tablas y la Jlist
    protected DefaultTableModel modeloSubG;
    protected DefaultListModel modeloLista;
    protected TrianguloEquilatero miTriangulo;        
    protected Subgrupo sb;
    private  boolean generados;                                                 //Bandera global. No se puede mostrar la tabla de un subg, sin haberlos generado
    protected String textoE;
    
    //Constructor
    public GUI() {
        this.setResizable(false);
        this.setTitle("Permutaciones: Triángulo Equilátero");                   //Asignamos un nombre a la ventana     
        
        initComponents();
        Jtable();
        generados = false;                                              
        modeloLista = new DefaultListModel();
        miTriangulo = new TrianguloEquilatero();  
        modeloSubG = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int filas, int columnas) {
                return columnas==5;
            }
            
        };
        sb = new Subgrupo();
        llenaTabla(tabla);
        
        URL url = getClass().getResource("triangulos/elementoG.png");           //Dirección de la imagen dentro de los paquetes
        ImageIcon elementos = new ImageIcon(url);
        elementosGrupoImagen.setIcon(elementos);
    }
   
    //Método usado por Jtable. Valores predeterminados para la tabla (Toda la columna 0)
    private void vertical(String n){
        String []Datos=new String [1];
        for (int i=0; i<3;i++){
            Datos [0] =   n+i;                            
            modelT.addRow(Datos);   
        }
    }
    
    //Asigna el modelo a la tabla. Se definen los valores predeterminados
    public void Jtable(){
        modelT= new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int i, int i1) {
                return  i1==7; //To change body of generated methods, choose Tools | Templates.
            }
          
        };                                        
        //Tabla de la pestaña Grupo D3
        modelT.addColumn(" ° ");                  //Añadiendo las columnas de la tabla
        modelT.addColumn("Pi0");                     
        modelT.addColumn("Pi1");
        modelT.addColumn("Pi2");
        modelT.addColumn("R0");
        modelT.addColumn("R1");
        modelT.addColumn("R2");
        this.tabla.setModel(modelT);
        //Definiendo la columa 0
        vertical("Pi");
        vertical("R");
       
    }
  
    //Llenando tabla de la pestaña D3
    private void llenaTabla(JTable tabla){
        String aux1,aux2,valor;
        Permutacion perm;
        for(int i = 0; i<tabla.getColumnCount()-1;i++){
            aux1=(String)tabla.getValueAt(i, 0);
            for (int j =1; j <= tabla.getRowCount(); j++) {
               aux2=(String)tabla.getModel().getColumnName(j);
               perm=miTriangulo.operarPermutaciones(miTriangulo.buscaPermutacion(aux1), miTriangulo.buscaPermutacion(aux2));
               valor=perm.getNombre();
               tabla.setValueAt(valor, i, j);
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane2 = new javax.swing.JTabbedPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jFrame1 = new javax.swing.JFrame();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        labelGrupoSimetria = new javax.swing.JLabel();
        labelPi0 = new javax.swing.JLabel();
        labelP1 = new javax.swing.JLabel();
        labelPi2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        comboSubGrupo = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaSubGrupo = new javax.swing.JTable();
        labelVerTablaSG = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        lista = new javax.swing.JList<>();
        botonGenerar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnCalcular = new javax.swing.JButton();
        pantallaCalc = new javax.swing.JTextField();
        LabelInfo = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnPi0 = new javax.swing.JButton();
        btnPi1 = new javax.swing.JButton();
        btnPi2 = new javax.swing.JButton();
        btnR0 = new javax.swing.JButton();
        btnR1 = new javax.swing.JButton();
        btnR2 = new javax.swing.JButton();
        btnParA = new javax.swing.JButton();
        btnParC = new javax.swing.JButton();
        btnOperador = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        imagenT = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textExplicativo = new javax.swing.JTextPane();
        jPanel5 = new javax.swing.JPanel();
        elementosGrupoImagen = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(jList1);

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelGrupoSimetria.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        labelGrupoSimetria.setText("Grupo de simetia del triángulo");

        labelPi0.setText("Pi0 (360°)");

        labelP1.setText("Pi1 (120°)");

        labelPi2.setText("Pi2 (240°)");

        tabla.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabla.getTableHeader().setResizingAllowed(false);
        tabla.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tabla);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelPi2)
                            .addComponent(labelP1)
                            .addComponent(labelGrupoSimetria)
                            .addComponent(labelPi0)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(labelGrupoSimetria)
                .addGap(18, 18, 18)
                .addComponent(labelPi0)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelP1)
                .addGap(9, 9, 9)
                .addComponent(labelPi2)
                .addGap(64, 64, 64)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Grupo D3", jPanel2);

        comboSubGrupo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----", "S1", "S2", "S3", "S4", "S5" }));
        comboSubGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSubGrupoActionPerformed(evt);
            }
        });

        tablaSubGrupo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        tablaSubGrupo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaSubGrupo.setColumnSelectionAllowed(true);
        tablaSubGrupo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tablaSubGrupo.getTableHeader().setResizingAllowed(false);
        tablaSubGrupo.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tablaSubGrupo);

        labelVerTablaSG.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        labelVerTablaSG.setText("Ver Tabla del Sub Grupo");

        lista.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jScrollPane5.setViewportView(lista);

        botonGenerar.setText("Generar");
        botonGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGenerarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel2.setText("Los primeros dos Subgrupos son los los SubG. triviales");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(labelVerTablaSG)
                                .addGap(18, 18, 18)
                                .addComponent(comboSubGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(159, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botonGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(44, 44, 44))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(botonGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(48, 48, 48)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelVerTablaSG)
                    .addComponent(comboSubGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );

        jTabbedPane1.addTab("Subgrupos", jPanel4);

        btnCalcular.setText("¡Calcular!");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });

        pantallaCalc.setEditable(false);
        pantallaCalc.setBackground(new java.awt.Color(255, 255, 255));

        LabelInfo.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        LabelInfo.setText("Donde \" * \" es la composición ");

        jPanel3.setLayout(new java.awt.GridLayout(3, 3));

        btnPi0.setText("Pi0");
        btnPi0.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnPi0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPi0ActionPerformed(evt);
            }
        });
        jPanel3.add(btnPi0);

        btnPi1.setText("Pi1");
        btnPi1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPi1ActionPerformed(evt);
            }
        });
        jPanel3.add(btnPi1);

        btnPi2.setText("Pi2");
        btnPi2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPi2ActionPerformed(evt);
            }
        });
        jPanel3.add(btnPi2);

        btnR0.setText("R0");
        btnR0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnR0ActionPerformed(evt);
            }
        });
        jPanel3.add(btnR0);

        btnR1.setText("R1");
        btnR1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnR1ActionPerformed(evt);
            }
        });
        jPanel3.add(btnR1);

        btnR2.setText("R2");
        btnR2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnR2ActionPerformed(evt);
            }
        });
        jPanel3.add(btnR2);

        btnParA.setText("(");
        btnParA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnParAActionPerformed(evt);
            }
        });
        jPanel3.add(btnParA);

        btnParC.setText(")");
        btnParC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnParCActionPerformed(evt);
            }
        });
        jPanel3.add(btnParC);

        btnOperador.setText("*");
        btnOperador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOperadorActionPerformed(evt);
            }
        });
        jPanel3.add(btnOperador);

        btnBorrar.setText("<-");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        imagenT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        imagenT.setMaximumSize(new java.awt.Dimension(210, 202));

        textExplicativo.setEditable(false);
        jScrollPane1.setViewportView(textExplicativo);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LabelInfo)
                .addGap(231, 231, 231))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(imagenT, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(btnCalcular)
                                    .addGap(27, 27, 27)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(pantallaCalc, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(65, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBorrar)
                            .addComponent(pantallaCalc))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCalcular)
                        .addGap(31, 31, 31))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(LabelInfo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(imagenT, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        jTabbedPane1.addTab("Operaciones", jPanel1);

        elementosGrupoImagen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel1.setText("Nota: R0, R1, R2 son las reflexiones en cuanto a los ejes ");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel1))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(elementosGrupoImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(73, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addComponent(elementosGrupoImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );

        jTabbedPane1.addTab("Elementos del Grupo", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    //Método usado por BotonCalcular. Imprimira el triángulo correspodiente en el label
    private void imprimirTriangulo(String T){    
        int n=0;
        switch (T){                 //Dependiendo del resultado de la operacion dependera
            case "Pi0":             //el número de la imagen a mostrar
                n=6;
                break;
            case "Pi1":
                n=4;
                break;
            case "Pi2":
                n=5;
                break;
            case "R0":
                n=1;
                break;
            case "R1":
                n=2;
                break;
            case "R2":
                n=3;
                break;}       
        //Dirección de la imagen
        URL url = getClass().getResource("triangulos/000"+n+".png");        
        ImageIcon triangulo = new ImageIcon(url);                           
        imagenT.setIcon(triangulo);     
    }
    
    // Boton calcular. 
    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        String operacion = pantallaCalc.getText();                              //Obtenemos el contenido de la caja de texto
        if ( ! pantallaCalc.getText().isEmpty() ){                              //Si no esta vacia
            boolean bandera= false,operador=false;                                  
            int a=0,cantOperandos=0;
            char c = 0;String aux="";
            Permutacion resultado = null;
            Stack<String> primeraOperacion = new Stack<String>();               //Para operaciones entre paréntesis. 
            Stack<String> segundaOperacion = new Stack<String>();               //Aquellos que estan por fuera
            
            
            /*
                Si hay elementos en la pila PrimeraOperacion (Aquella dentro de "()"), se debe realizar primero esa operación y el resultado componerla 
                con el unico elemento que esta en la otra pila.
                Si la primera pila esta vacia. Es una operacion de una sola composición Ej. r1*pi2
                Si la segunda pila esta vacia, hay dos elementos en la primeraPila. Es una operación de una sola composición
            */
                       
            
            //Separando elementos de la expresión
            for (int n = 0; n < operacion.length(); n++) { 
                c = operacion.charAt(n);
                if ( c != '(' && c != '*' &&  c != ' ' && c != ')'  ){          //Mientras no sea un caracter especial
                    aux+=c;                                                     //Acumulamos
                }else{
                    if (bandera)                                                
                        primeraOperacion.push(aux);                             
                    else{
                        if (c == '(')                                           
                            bandera= true;
                        else{
                            if (a!=1)
                                segundaOperacion.push(aux);                             
                        }
                    }
                    if (c == ')'){                                             
                        a=1;                                                
                        bandera=false;
                    }
                    aux="";
                }    
            }
            if ( c!= ')' && bandera==false){  
                segundaOperacion.push(aux);  
                operador = true;                  
            }
          
            //SUMA ENTRE PILAS
            cantOperandos = primeraOperacion.size() + segundaOperacion.size();
            
            // Si la suma de las dos pilas es 3, hay dos elementos en la 1eraprila y uno en la 2da pila          
            if (cantOperandos > 1 && cantOperandos < 4  && validaEntrada(operacion,cantOperandos)) {
                Permutacion auxiliar1,auxiliar2;
                if(cantOperandos == 3){                                                // si (R0 * R1)
                    auxiliar1 = miTriangulo.buscaPermutacion(primeraOperacion.pop());  //Este es R1
                    auxiliar2 = miTriangulo.buscaPermutacion(primeraOperacion.pop());  //Este es R0
                    resultado = miTriangulo.operarPermutaciones(auxiliar2,auxiliar1);
                    muestraExplicacion(auxiliar2,auxiliar1,false);
                    auxiliar2 = miTriangulo.buscaPermutacion(segundaOperacion.pop());
                    //Si operador=true. Es de esta forma. Ej: (R0*R1) * Pi0
                    if (operador){
                       muestraExplicacion(resultado, auxiliar2,true);
                       resultado = miTriangulo.operarPermutaciones(resultado,auxiliar2); 
                    }else {   //Sino, es Ej: Pi0*(R0*R1) 
                        muestraExplicacion(auxiliar2,resultado,true);
                        resultado = miTriangulo.operarPermutaciones(auxiliar2,resultado);
                    } 
                    //PRUEBAS
                    System.out.println("Resultado: ");
                    resultado.imprimir();
                }
                else if(cantOperandos==2){
                    //Si 1era pila es 2. La operación fue ingresada como (Pi0*R0)
                    if ( primeraOperacion.size() == 2){
                        auxiliar1=miTriangulo.buscaPermutacion(primeraOperacion.pop());
                        auxiliar2=miTriangulo.buscaPermutacion(primeraOperacion.pop());
                        resultado=miTriangulo.operarPermutaciones(auxiliar2, auxiliar1);
                    }
                    else{
                        auxiliar1=miTriangulo.buscaPermutacion(segundaOperacion.pop());
                        auxiliar2=miTriangulo.buscaPermutacion(segundaOperacion.pop());
                        resultado=miTriangulo.operarPermutaciones(auxiliar2,auxiliar1);
                    }
                    muestraExplicacion(auxiliar2, auxiliar1,false);
                    System.out.println("El resultado es: ");
                    resultado.imprimir();
                }
                //Actualizamos el triángulo  
                imprimirTriangulo(resultado.getNombre());                       
                pantallaCalc.setText(resultado.getNombre());
            }else {
                JOptionPane.showMessageDialog(null,"Debe indicar una expresión válida ");
                pantallaCalc.setText("");
            }
        }else JOptionPane.showMessageDialog(null,"Debe indicar una operación ");  
        
    }//GEN-LAST:event_btnCalcularActionPerformed
    
    //Validaciones para la expresión 
    private boolean validaEntrada(String entrada, int cantElementos){
        
        int parAbriendo=0,parCerrando=0;//Cantidad de parentesis
        
        //si empieza o termina con un * no es una operacion valida
        if(entrada.charAt(0) == '*' || entrada.charAt(entrada.length()-1) == '*' )
            return false;
       
        //recorre la operacion
        for (int i = 0; i < entrada.length(); i++) {
            System.out.println("i = " +i);
            if(entrada.charAt(i) == '*' ){
                //si lo que le sigue a un * es otro * es invalido
                if(entrada.charAt(i+1) == '*')
                    return false;
                //si lo que le sigue a un * es ) es invalido
                if(entrada.charAt(i+1) ==')')
                    return false;
            }
            
            if(entrada.charAt(i) == '(' && (i+1) <= entrada.length() ){
                //se aumenta la cantidad de parentesis abriendo para luego comparar (si todo va bien)
                parAbriendo++;
                if ((i+1) == entrada.length())
                    continue;
                //si lo que le sigue a un ( es un * es invalido
                if(entrada.charAt(i+1) == '*')
                    return false;
                //si lo que le sigue a un ( es otro parentesis, es invalido
                if(entrada.charAt(i+1) == ')' || entrada.charAt(i+1) == '(')
                    return false;
                //Si son 3 elementos no puede haber elementos solos encerrado en (). EJ: (pi1)*pi2*r0
                if((entrada.charAt(i+3)== ')' || entrada.charAt(i+4) == ')') && (cantElementos == 3))
                    return false;
            }
            
            if(entrada.charAt(i) == ')' && (i+1) <= entrada.length()){
                //se aumenta la cantidad de parentesis cerrando para luego comparar (si todo va bien)
                parCerrando++; 
                if ((i+1) == entrada.length())
                    continue;
                //Si lo que le sigue a un ) no es * es invalido
                if (entrada.charAt(i+1) == 'R' || entrada.charAt(i+1) == 'P' || entrada.charAt(i+1) == ')'
                        || entrada.charAt(i+1) == '(')
                    return false;
                    
            }
            
            if (entrada.charAt(i) == 'R' && (i+2) <= entrada.length()){
                if((i+2) < entrada.length()){
                    //Si lo que le sigue es otro elemento, es invalido
                    if((entrada.charAt(i+2) == 'R' || entrada.charAt(i+2) == 'P' || entrada.charAt(i+2) == '(')){
                       return false;
                    }
                }
            }else if(entrada.charAt(i) == 'P' && (i+3) <= entrada.length()){
                if((i+3) < entrada.length()){
                    //Si lo que le sigue es otro elemento, es invalido
                    if((entrada.charAt(i+3) == 'R' || entrada.charAt(i+3) == 'P' || entrada.charAt(i+3) == '(')){
                       return false;
                    }
                }
            }
            
        }
        
        //Si es una operacion de 3 elementos, ajuro debe tener parentesis, si no tiene, no es valida
        if(cantElementos == 3){
            if(parAbriendo == 0 || parCerrando == 0){
                return false;
            }
        }
         
        //Si tiene la misma cantidad de parentesis (aun siendo 0 y 0) devuelve true
        return (parAbriendo==parCerrando);
    }
    
    //Explicación de la composición
    private void muestraExplicacion(Permutacion p1, Permutacion p2, boolean tipo){
        
        String operador1="",operador2="", principal="",secundario,resultado="",transitividad;
        int par1,par2,par3,par4,par5,par6;
        Permutacion auxiliar = miTriangulo.operarPermutaciones(p1, p2);
        String paresOrdenados[] = new String[9];
        
         
        paresOrdenados[0]="(1,"+p1.getVertice(1)+")";
        paresOrdenados[1]="(2,"+p1.getVertice(2)+")";
        paresOrdenados[2]="(3,"+p1.getVertice(3)+")";
        
        paresOrdenados[3]="(1,"+p2.getVertice(1)+")";
        paresOrdenados[4]="(2,"+p2.getVertice(2)+")";
        paresOrdenados[5]="(3,"+p2.getVertice(3)+")";
        
        paresOrdenados[6]="(1,"+auxiliar.getVertice(1)+")";
        paresOrdenados[7]="(2,"+auxiliar.getVertice(2)+")";
        paresOrdenados[8]="(3,"+auxiliar.getVertice(3)+")";
        
        par1=parCorrespondiente(paresOrdenados[0],paresOrdenados,false);
        par2=parCorrespondiente(paresOrdenados[1],paresOrdenados,false);
        par3=parCorrespondiente(paresOrdenados[2],paresOrdenados,false);
        par4=parCorrespondiente(paresOrdenados[0],paresOrdenados,true);
        par5=parCorrespondiente(paresOrdenados[1],paresOrdenados,true);
        par6=parCorrespondiente(paresOrdenados[2],paresOrdenados,true);
       
        principal="Vease las permutaciones como pares ordenados (x,y), donde 'x' es el numero superior e 'y' el inferior";
        operador1="\nDescomponemos la permitacion " + p1.getNombre() + " en pares ordenados: \n"+paresOrdenados[0]+ " | "+paresOrdenados[1]+" | "+paresOrdenados[2]+"\n\n";
        operador2="Descomponemos la permitacion " + p2.getNombre() + " en pares ordenados: \n"+paresOrdenados[3]+ " | "+paresOrdenados[4]+" | "+paresOrdenados[5]+"\n\n";
        secundario="\nTeniendo estos pares ordenados, seguimos con la transitividad:\n";
        
        transitividad=paresOrdenados[0]+" / " + paresOrdenados[par1] +
                " = " + paresOrdenados[par4]+"\n" + paresOrdenados[1]+" / " + paresOrdenados[par2] +
                " = " + paresOrdenados[par5]+"\n" + paresOrdenados[2]+" / " + paresOrdenados[par3] +
                " = " + paresOrdenados[par6]+"\n\n";
        
        resultado="Teniendo como resultado los pares ordenados: "+"\n"
                +paresOrdenados[par4]+"\n"+paresOrdenados[par5]+"\n"+paresOrdenados[par6]+"\n"
                + "\nQue son los de la permutacion " + auxiliar.getNombre()+"\n"+"\n"+"\n";
        
        //Si tipo=1. La operacion tiene mas de dos elementos
        if (tipo)
            textExplicativo.setText(textoE+principal+operador1+operador2+secundario+transitividad+resultado);
        else{
            textoE=principal+operador1+operador2+secundario+transitividad+resultado;
            textExplicativo.setText(principal+operador1+operador2+secundario+transitividad+resultado);
        }
      
        
    }
    
    //Método empleado por muestraExplicación
    private int parCorrespondiente(String par,String pares[],boolean resultado){
        int result=0;
        if(!resultado){
        for (int i = 3; i < 6; i++) {
            if(par.charAt(3)==pares[i].charAt(1)){
                result = i;
                break;
            }
        }
        }else{
            for (int i = 6; i < 9; i++) {
                if(par.charAt(1) == pares[i].charAt(1)){
                    result = i;
                    break;
                }
            }
        }
        return result;
    }
    
    
    //ActionEvents. Tomara el valor del boton seleccionado y lo agregara a la caja de texto(operación)
    private void btnR0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnR0ActionPerformed
        pantallaCalc.setText(pantallaCalc.getText()+"R0");
    }//GEN-LAST:event_btnR0ActionPerformed
   
    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        pantallaCalc.setText("");
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnPi0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPi0ActionPerformed
        pantallaCalc.setText(pantallaCalc.getText()+"Pi0");
    }//GEN-LAST:event_btnPi0ActionPerformed

    private void btnPi1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPi1ActionPerformed
        pantallaCalc.setText(pantallaCalc.getText()+"Pi1");
    }//GEN-LAST:event_btnPi1ActionPerformed

    private void btnPi2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPi2ActionPerformed
        pantallaCalc.setText(pantallaCalc.getText()+"Pi2");
    }//GEN-LAST:event_btnPi2ActionPerformed

    private void btnR1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnR1ActionPerformed
       pantallaCalc.setText(pantallaCalc.getText()+"R1");
    }//GEN-LAST:event_btnR1ActionPerformed

    private void btnR2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnR2ActionPerformed
        pantallaCalc.setText(pantallaCalc.getText()+"R2");
    }//GEN-LAST:event_btnR2ActionPerformed

    private void btnParAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnParAActionPerformed
        pantallaCalc.setText(pantallaCalc.getText()+"(");
    }//GEN-LAST:event_btnParAActionPerformed

    private void btnParCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnParCActionPerformed
        pantallaCalc.setText(pantallaCalc.getText()+")");
    }//GEN-LAST:event_btnParCActionPerformed

    private void btnOperadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOperadorActionPerformed
        pantallaCalc.setText(pantallaCalc.getText()+"*");
    }//GEN-LAST:event_btnOperadorActionPerformed

    
    //Método empleado por el botonGenerar. Agrega un elemento en el modelo de la Jlist. Pestaña subGrupos
    private void agregarALista(String a, int i){
        modeloLista.addElement(a+sb.imprimirSub((ArrayList<Permutacion>) sb.getSubGrupos().get(i))+ " }" );
    }
    
    //Generar los subgrupos e imprimirlos en el Jlist
    private void botonGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGenerarActionPerformed
        //Si aun no se han generado
        if (generados==false){              
            for (int i = 0; i < miTriangulo.getGrupo().size(); i++) 
                sb.generadorCiclico((Permutacion) miTriangulo.getGrupo().get(i));   //Busca los subG
       
            //Agregando a la lista los sub encontrados
            for(int i = 0; i< sb.getSubGrupos().size(); i++)
                agregarALista("S"+i+ ": {", i);
            lista.setModel(modeloLista);
            generados=true;
        }
        
     
    }//GEN-LAST:event_botonGenerarActionPerformed

    //Método empleado por comboSubGrupo. Método que elimina toda la tabla
    private void vaciarTablaSubGrupo(){        
        modeloSubG.setColumnCount(0);
        modeloSubG.setRowCount(0);
    }
    
    //Método empleado por comboSubGrupo. Carga la tabla del subgrupo seleccionado en el combobox
    private void jTableLista(ArrayList<String> elemento){
        String []Datos =new String [1];
        //Valor por defecto para la primera columna
        modeloSubG.addColumn("  °  ");                                                    
        //Agregando el subg a la tabla
        for (int i=0; i<elemento.size();i++){                                             
            Datos [0] =   elemento.get(i);   
            modeloSubG.addColumn(elemento.get(i));
            modeloSubG.addRow(Datos);   
        }
        this.tablaSubGrupo.setModel(modeloSubG);
        llenaTabla(tablaSubGrupo);
    }
    
    //ActionEvent para el elemento seleccionado al combo
    private void comboSubGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSubGrupoActionPerformed
        int indice = comboSubGrupo.getSelectedIndex();                                    //Obtiene el elemento seleccionado por número
        if (generados){                                                                   //Si ya se buscaron los subG
            if (indice!=0 ){     
                ArrayList <String> aux = new ArrayList(3);
                vaciarTablaSubGrupo();                                                    //Limpiar tabla subgrupo
                sb.getSub(aux, (ArrayList<Permutacion>) sb.getSubGrupos().get(indice));   //Obtenemos una copia del subg en la variable aux
                jTableLista(aux);                                                         //Cargar el subg seleccionado en la tabla 
                aux.clear();                                                              //Vaciando arraylist
            }
        }else JOptionPane.showMessageDialog(null,"Se deben generar los subgrupos primero");  
    }//GEN-LAST:event_comboSubGrupoActionPerformed

    
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelInfo;
    private javax.swing.JButton botonGenerar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnOperador;
    private javax.swing.JButton btnParA;
    private javax.swing.JButton btnParC;
    private javax.swing.JButton btnPi0;
    private javax.swing.JButton btnPi1;
    private javax.swing.JButton btnPi2;
    private javax.swing.JButton btnR0;
    private javax.swing.JButton btnR1;
    private javax.swing.JButton btnR2;
    private javax.swing.JComboBox<String> comboSubGrupo;
    private javax.swing.JLabel elementosGrupoImagen;
    private javax.swing.JLabel imagenT;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel labelGrupoSimetria;
    private javax.swing.JLabel labelP1;
    private javax.swing.JLabel labelPi0;
    private javax.swing.JLabel labelPi2;
    private javax.swing.JLabel labelVerTablaSG;
    private javax.swing.JList<String> lista;
    private javax.swing.JTextField pantallaCalc;
    private javax.swing.JTable tabla;
    private javax.swing.JTable tablaSubGrupo;
    private javax.swing.JTextPane textExplicativo;
    // End of variables declaration//GEN-END:variables

    private int separarElementos(Stack<String> primeraOperacion, Stack<String> segundaOperacion, String operacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
