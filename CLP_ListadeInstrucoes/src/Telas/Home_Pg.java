/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Telas;


import compiladorinstructionlist.input.InputActions;
import compiladorinstructionlist.interpreter.Interpreter;
import compiladorinstructionlist.memoryvariable.MemoryVariable;
import compiladorinstructionlist.output.OutputActions;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.text.BadLocationException;

/**
 *
 * @author vinic
 */
public class Home_Pg extends javax.swing.JFrame {

    /**
     * Creates new form Home_Pg
     */
            
     // Cria variáveis
    static Map<String, Boolean> inputs;
    static Map<String, Boolean> outputs;
    static Map<String, MemoryVariable> memoryVariables = new HashMap<String, MemoryVariable>();
    static Integer mode = 1;
    
    private static javax.swing.JButton run_BT;
    
    public Home_Pg() {
        initComponents();
        //setando informaçoes iniciais
        ImageIcon icon = new ImageIcon("src/Assets/led_desligado.png");
        icon.setImage( icon.getImage().getScaledInstance(Saida_1.getWidth(), Saida_1.getHeight(),1));
        Saida_1.setIcon(icon);
        Saida_2.setIcon(icon);
        Saida_3.setIcon(icon);
        Saida_4.setIcon(icon);
        Saida_5.setIcon(icon);
        Saida_6.setIcon(icon);
        Saida_7.setIcon(icon);
        Saida_8.setIcon(icon);
        ImageIcon icon1 = new ImageIcon("src/Assets/chave_aberta.png");
        icon1.setImage( icon1.getImage().getScaledInstance(Saida_1.getWidth(), Saida_1.getHeight(),1));
        Entrada_1.setIcon(icon1);
        Entrada_2.setIcon(icon1);
        Entrada_3.setIcon(icon1);
        Entrada_4.setIcon(icon1);
        Entrada_5.setIcon(icon1);
        Entrada_6.setIcon(icon1);
        Entrada_7.setIcon(icon1);
        Entrada_8.setIcon(icon1);
        ImageIcon iconplay = new ImageIcon("src/Assets/start.png");
        iconplay.setImage( iconplay.getImage().getScaledInstance(Run_BT.getWidth(), Run_BT.getHeight(),1));
        Run_BT.setIcon(iconplay);
        ImageIcon iconpause = new ImageIcon("src/Assets/pause.png");
        iconpause.setImage( iconpause.getImage().getScaledInstance(Pause_BT.getWidth(), Pause_BT.getHeight(),1));
        Pause_BT.setIcon(iconpause);
        
        //setando textos para linguagem
        //Simulacoes.setModel();
        //Arquivar_BT.setModel();
        //Editar_BT.setModel();
        Help_BT.setText("Ajuda");
        Sobre_BT.setText("Sobre");
        Label_Delay.setText("Tempo de Delay em ms:");
        Label_Saidas.setText("Saidas");
        Label_Entradas.setText("Entradas");
        
         inputs = new HashMap<>();
        outputs = new HashMap<>();

        inputs = InputActions.create(inputs);
        System.out.println("HashMap de entradas criado:" + inputs);

        outputs = OutputActions.create(outputs);
        System.out.println("HashMap de saídas criado:" + outputs);

        run_BT = Run_BT;
        
        // Atualiza entradas e saídas na tela
        updateScreen();
    }
    
    public void setColor(Boolean value, JLabel label) {
        if (value) {
            label.setForeground(Color.green);
        } else {
            label.setForeground(Color.red);
        }
    }

    // Atualiza entradas e saídas na tela
    public void updateScreen() {
        /*jl_input1_value.setText(inputs.get("I1").toString());
        setColor(inputs.get("I1"), jl_input1_value);

        jl_input2_value.setText(inputs.get("I2").toString());
        setColor(inputs.get("I2"), jl_input2_value);

        jl_input3_value.setText(inputs.get("I3").toString());
        setColor(inputs.get("I3"), jl_input3_value);

        jl_input4_value.setText(inputs.get("I4").toString());
        setColor(inputs.get("I4"), jl_input4_value);

        jl_input5_value.setText(inputs.get("I5").toString());
        setColor(inputs.get("I5"), jl_input5_value);

        jl_input6_value.setText(inputs.get("I6").toString());
        setColor(inputs.get("I6"), jl_input6_value);

        jl_input7_value.setText(inputs.get("I7").toString());
        setColor(inputs.get("I7"), jl_input7_value);

        jl_input8_value.setText(inputs.get("I8").toString());
        setColor(inputs.get("I8"), jl_input8_value);*/
        

        Troca_Led_Saida(Saida_1, outputs.get("Q1").toString());
        Troca_Led_Saida(Saida_2, outputs.get("Q2").toString());
        Troca_Led_Saida(Saida_3, outputs.get("Q3").toString());
        Troca_Led_Saida(Saida_4, outputs.get("Q4").toString());
        Troca_Led_Saida(Saida_5, outputs.get("Q5").toString());
        Troca_Led_Saida(Saida_6, outputs.get("Q6").toString());
        Troca_Led_Saida(Saida_7, outputs.get("Q7").toString());
        Troca_Led_Saida(Saida_8, outputs.get("Q8").toString());

        Troca_Led_Saida(Saida_1, outputs.get("Q1").toString());
        Troca_Led_Saida(Saida_2, outputs.get("Q2").toString());
        Troca_Led_Saida(Saida_3, outputs.get("Q3").toString());
        Troca_Led_Saida(Saida_4, outputs.get("Q4").toString());
        Troca_Led_Saida(Saida_5, outputs.get("Q5").toString());
        Troca_Led_Saida(Saida_6, outputs.get("Q6").toString());
        Troca_Led_Saida(Saida_7, outputs.get("Q7").toString());
        Troca_Led_Saida(Saida_8, outputs.get("Q8").toString());
        /*jl_output1_value.setText(outputs.get("Q1").toString());
        setColor(outputs.get("Q1"), jl_output1_value);

        jl_output2_value.setText(outputs.get("Q2").toString());
        setColor(outputs.get("Q2"), jl_output2_value);

        jl_output3_value.setText(outputs.get("Q3").toString());
        setColor(outputs.get("Q3"), jl_output3_value);

        jl_output4_value.setText(outputs.get("Q4").toString());
        setColor(outputs.get("Q4"), jl_output4_value);

        jl_output5_value.setText(outputs.get("Q5").toString());
        setColor(outputs.get("Q5"), jl_output5_value);

        jl_output6_value.setText(outputs.get("Q6").toString());
        setColor(outputs.get("Q6"), jl_output6_value);

        jl_output7_value.setText(outputs.get("Q7").toString());
        setColor(outputs.get("Q7"), jl_output7_value);

        jl_output8_value.setText(outputs.get("Q8").toString());
        setColor(outputs.get("Q8"), jl_output8_value);*/
    }

    // Atualiza o modo atual na tela
    public void updateMode() {
        System.out.println("Modo atual: " + mode);
        if (mode == 1) {
            //jl_mode_value.setText("Program");
            Codigo_Camp.setEditable(true);
            jSpinner1.setEnabled(true);
        } else if (mode == 2) {
            //jl_mode_value.setText("Stop");
            Codigo_Camp.setEditable(false);
            jSpinner1.setEnabled(true);
            //jt_time.setEditable(false);
        } else {
            //jl_mode_value.setText("Run");
            Codigo_Camp.setEditable(false);
            jSpinner1.setEnabled(true);
            //jt_time.setEditable(false);
        }
    }

    // Atualiza as variáveis de memória na tela
    public void updateMemoryVariables() {
        /*jta_memory_variables.setText("");

        String line = "";

        for (Map.Entry<String, MemoryVariable> variable : memoryVariables.entrySet()) {
            if(variable.getKey().charAt(0) == 'M')
                line = variable.getKey() + " = " + variable.getValue().currentValue + "\n";
            else
                line = variable.getKey() + " = " + variable.getValue().currentValue + ", " + variable.getValue().counter+ ", " + variable.getValue().maxTimer+ ", " + variable.getValue().endTimer + "\n";
            jta_memory_variables.setText(jta_memory_variables.getText() + line);
        }*/
    }
    
    public static void showErrorMessage(String message) {
        mode = 1;
        ImageIcon icon = new ImageIcon("src/Assets/start.png");
        icon.setImage(icon.getImage().getScaledInstance(run_BT.getWidth(), run_BT.getHeight(),1));
        run_BT.setIcon(icon);
        JOptionPane.showMessageDialog(null, message);
    }
    
    public void setaStart(){
        ImageIcon icon = new ImageIcon("src/Assets/start.png");
        icon.setImage(icon.getImage().getScaledInstance(Run_BT.getWidth(), Run_BT.getHeight(),1));
        Run_BT.setIcon(icon);
    }

   
    private void Troca_Led_Saida(javax.swing.JLabel Saida, String modo){
        ImageIcon icon = new ImageIcon("src/Assets/led_desligado.png");
        icon.setImage(icon.getImage().getScaledInstance(Saida.getWidth(), Saida.getHeight(),1));
        ImageIcon icon2 = new ImageIcon("src/Assets/led_ligado.png");
        icon2.setImage(icon2.getImage().getScaledInstance(Saida.getWidth(), Saida.getHeight(),1));
        
        if (modo.equals("true"))
        {
            Saida.setIcon(icon2);
        }else{
            Saida.setIcon(icon);
        }
        
    }
    
    private List<String> saveLines(List<String> lineList) {
        int quant = Codigo_Camp.getLineCount();

        for (int i = 0; i < quant; i++) {
            try {
                Integer start = Codigo_Camp.getLineStartOffset(i);
                Integer end = Codigo_Camp.getLineEndOffset(i);
                String line = Codigo_Camp.getText(start, end - start);
                lineList.add(line);
            } catch (BadLocationException ex) {
                Logger.getLogger(Home_Pg.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        System.out.println("Lista de linhas: " + lineList);
        return lineList;
    }
    
    public Map setaBit(Map<String,Boolean> inputs){
        Boolean input = inputs.get("I1");
        inputs.clear();
        inputs.put("I1", !input);
        inputs.put("I2", !input);
        inputs.put("I3", !input);
        inputs.put("I4", !input);
        inputs.put("I5", !input);
        inputs.put("I6", !input);
        inputs.put("I7", !input);
        inputs.put("I8", !input);
        return inputs;
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Simulacoes = new javax.swing.JComboBox<>();
        Run_BT = new javax.swing.JButton();
        Arquivar_BT = new javax.swing.JComboBox<>();
        Editar_BT = new javax.swing.JComboBox<>();
        Help_BT = new javax.swing.JButton();
        Sobre_BT = new javax.swing.JButton();
        Pause_BT = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Codigo_Camp = new javax.swing.JTextArea();
        Variaveis_BT = new javax.swing.JButton();
        jSpinner1 = new javax.swing.JSpinner();
        Label_Delay = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        Saida_1 = new javax.swing.JLabel();
        Saida_2 = new javax.swing.JLabel();
        Saida_4 = new javax.swing.JLabel();
        Saida_3 = new javax.swing.JLabel();
        Saida_5 = new javax.swing.JLabel();
        Saida_6 = new javax.swing.JLabel();
        Saida_7 = new javax.swing.JLabel();
        Saida_8 = new javax.swing.JLabel();
        Label_Entradas = new javax.swing.JLabel();
        Label_Saidas = new javax.swing.JLabel();
        Entrada_5 = new javax.swing.JLabel();
        Entrada_1 = new javax.swing.JLabel();
        Entrada_6 = new javax.swing.JLabel();
        Entrada_2 = new javax.swing.JLabel();
        Entrada_8 = new javax.swing.JLabel();
        Entrada_4 = new javax.swing.JLabel();
        Entrada_7 = new javax.swing.JLabel();
        Entrada_3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Simulacoes.setBackground(new java.awt.Color(8, 94, 131));
        Simulacoes.setForeground(new java.awt.Color(0, 0, 0));
        Simulacoes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Painel", "Simulação 1", "Simulação 2", "Simulação 3" }));
        Simulacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SimulacoesActionPerformed(evt);
            }
        });

        Run_BT.setFont(new java.awt.Font("Segoe UI", 0, 5)); // NOI18N
        Run_BT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/start.png"))); // NOI18N
        Run_BT.setToolTipText("");
        Run_BT.setAlignmentY(0.0F);
        Run_BT.setAutoscrolls(true);
        Run_BT.setBorder(null);
        Run_BT.setDisabledIcon(null);
        Run_BT.setIconTextGap(0);
        Run_BT.setMaximumSize(new java.awt.Dimension(50, 50));
        Run_BT.setMinimumSize(new java.awt.Dimension(50, 50));
        Run_BT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Run_BTBT_Run_Pressionado(evt);
            }
        });

        Arquivar_BT.setForeground(new java.awt.Color(0, 0, 0));
        Arquivar_BT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Arquivar", "Salvar", "Item 3", "Item 4" }));

        Editar_BT.setForeground(new java.awt.Color(0, 0, 0));
        Editar_BT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Editar", "Tema", "Idioma" }));

        Help_BT.setForeground(new java.awt.Color(0, 0, 0));
        Help_BT.setText("Help");

        Sobre_BT.setForeground(new java.awt.Color(0, 0, 0));
        Sobre_BT.setText("Sobre");
        Sobre_BT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Sobre_BTActionPerformed(evt);
            }
        });

        Pause_BT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/pause.png"))); // NOI18N
        Pause_BT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Pause_BTActionPerformed(evt);
            }
        });

        Codigo_Camp.setBackground(new java.awt.Color(131, 177, 246));
        Codigo_Camp.setColumns(20);
        Codigo_Camp.setRows(5);
        jScrollPane1.setViewportView(Codigo_Camp);

        jSpinner1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        Label_Delay.setForeground(new java.awt.Color(0, 0, 0));
        Label_Delay.setText("Tempo de Delay em ms:");

        jPanel1.setBackground(new java.awt.Color(142, 177, 199));

        Saida_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/led_desligado.png"))); // NOI18N

        Saida_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/led_desligado.png"))); // NOI18N

        Saida_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/led_desligado.png"))); // NOI18N

        Saida_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/led_desligado.png"))); // NOI18N

        Saida_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/led_desligado.png"))); // NOI18N

        Saida_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/led_desligado.png"))); // NOI18N

        Saida_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/led_desligado.png"))); // NOI18N

        Saida_8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/led_desligado.png"))); // NOI18N

        Label_Entradas.setFont(new java.awt.Font("Segoe UI Black", 2, 24)); // NOI18N
        Label_Entradas.setForeground(new java.awt.Color(0, 0, 0));
        Label_Entradas.setText("Entradas");

        Label_Saidas.setFont(new java.awt.Font("Segoe UI Black", 2, 24)); // NOI18N
        Label_Saidas.setForeground(new java.awt.Color(0, 0, 0));
        Label_Saidas.setText("Saidas");

        Entrada_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/chave_aberta.png"))); // NOI18N

        Entrada_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/chave_aberta.png"))); // NOI18N

        Entrada_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/chave_aberta.png"))); // NOI18N

        Entrada_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/chave_aberta.png"))); // NOI18N

        Entrada_8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/chave_aberta.png"))); // NOI18N

        Entrada_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/chave_aberta.png"))); // NOI18N

        Entrada_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/chave_aberta.png"))); // NOI18N

        Entrada_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/chave_aberta.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Entrada_1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(Entrada_5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Entrada_2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(Entrada_6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Entrada_3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(Entrada_7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Entrada_4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(Entrada_8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Saida_4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Saida_3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Saida_1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Saida_2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Saida_8, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Saida_7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Saida_5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Saida_6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(88, 88, 88))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(Label_Entradas, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(454, Short.MAX_VALUE)
                    .addComponent(Label_Saidas, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(78, 78, 78)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(Label_Entradas, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Saida_5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Saida_8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Saida_1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Entrada_5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Entrada_1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Entrada_6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Entrada_2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Entrada_7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Entrada_3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Entrada_8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Entrada_4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Saida_6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Saida_2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Saida_3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Saida_7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addComponent(Saida_4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(49, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(Label_Saidas, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(328, Short.MAX_VALUE)))
        );

        jPanel2.setBackground(new java.awt.Color(8, 94, 131));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 221, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Simulacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(Run_BT, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Pause_BT, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Label_Delay)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Arquivar_BT, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Editar_BT, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Help_BT)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Sobre_BT)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Variaveis_BT, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(Variaveis_BT, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Sobre_BT)
                            .addComponent(Help_BT)
                            .addComponent(Editar_BT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Arquivar_BT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Simulacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Run_BT, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Pause_BT, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Label_Delay)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SimulacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SimulacoesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SimulacoesActionPerformed
    private void Run_BTBT_Run_Pressionado(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Run_BTBT_Run_Pressionado
         System.out.println("\nBotão run clicado!");
         
        if(mode != 3){
            ImageIcon icon = new ImageIcon("src/Assets/start_verde.png");
            icon.setImage(icon.getImage().getScaledInstance(Run_BT.getWidth(), Run_BT.getHeight(),1));
            Run_BT.setIcon(icon);

            mode = 3;
            // Verificando tempo de delay
            String stringTime = jSpinner1.getValue().toString();
            Integer time = 0;

            if (!stringTime.equals("")) {
                try {
                    time = Integer.parseInt(stringTime);
                } catch (NumberFormatException e) {
                    mode = 1;
                    updateMode();
                    showErrorMessage("Tempo de delay inválido! Insira um número inteiro.");
                }

                System.out.println("Tempo de delay: " + time + "\n");
            }

            // Executa o laço corretamente sem travar a tela 
            Timer timer = new Timer(time, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    // Salva linhas da área de texto
                    List<String> lineList = new ArrayList<String>();
                    lineList = saveLines(lineList);

                    if (mode == 3) {
                        //inputs = InputActions.dummyRead(inputs);
                        inputs = InputActions.read(inputs);
                        outputs = OutputActions.setAllFalse(outputs);
                        outputs = Interpreter.receiveLines(lineList, inputs, outputs, memoryVariables);
                        for(Map.Entry<String, MemoryVariable> variable : memoryVariables.entrySet()){
                            if(variable.getKey().charAt(0) == 'T' && variable.getValue().timerType.equals("ON") && variable.getValue().currentValue == true)
                                variable.getValue().timer.start();
                            else if(variable.getKey().charAt(0) == 'T' && variable.getValue().timerType.equals("ON") && variable.getValue().currentValue == false){
                                variable.getValue().timer.stop();
                                variable.getValue().counter = 0;
                                variable.getValue().endTimer = false;
                            }
                            if(variable.getKey().charAt(0) == 'T' && variable.getValue().timerType.equals("OFF") && variable.getValue().currentValue == true){
                                variable.getValue().timer.stop();
                                variable.getValue().counter = 0;
                                variable.getValue().endTimer = true;
                            }else if(variable.getKey().charAt(0) == 'T' && variable.getValue().timerType.equals("OFF") && variable.getValue().currentValue == false){
                                variable.getValue().timer.start();
                            }
                        }
                        //outputs = OutputActions.dummyWrite(outputs);
                        outputs = OutputActions.write(outputs);
                        updateMode();
                        updateScreen();
                        updateMemoryVariables();
                    } else {
                        ((Timer) evt.getSource()).stop();
                    }
                }
            });

            timer.setInitialDelay(0); // começa sem atraso
            timer.start();
        }else{
            ImageIcon icon = new ImageIcon("src/Assets/start.png");
            icon.setImage(icon.getImage().getScaledInstance(Run_BT.getWidth(), Run_BT.getHeight(),1));
            Run_BT.setIcon(icon);
            mode = 2;
            for (Map.Entry<String, MemoryVariable> variable : memoryVariables.entrySet()) {
                if(variable.getKey().charAt(0) == 'T'){
                    variable.getValue().timer.stop();
                }
            }
            updateMemoryVariables();
            updateMode();
        }
        

    }//GEN-LAST:event_Run_BTBT_Run_Pressionado

    private void Pause_BTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Pause_BTActionPerformed
        System.out.println("\nBotão program clicado!");
        
        ImageIcon icon = new ImageIcon("src/Assets/start.png");
        icon.setImage(icon.getImage().getScaledInstance(Run_BT.getWidth(), Run_BT.getHeight(),1));
        Run_BT.setIcon(icon);
        
        mode = 1;
        for (Map.Entry<String, MemoryVariable> variable : memoryVariables.entrySet()) {
            if(variable.getKey().charAt(0) == 'T'){
                variable.getValue().counter = 0;
                variable.getValue().timer.stop();
            }
        }
        updateMemoryVariables();
        updateMode();
    }//GEN-LAST:event_Pause_BTActionPerformed

    private void Sobre_BTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Sobre_BTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Sobre_BTActionPerformed

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
            java.util.logging.Logger.getLogger(Home_Pg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home_Pg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home_Pg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home_Pg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home_Pg().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Arquivar_BT;
    private javax.swing.JTextArea Codigo_Camp;
    private javax.swing.JComboBox<String> Editar_BT;
    private javax.swing.JLabel Entrada_1;
    private javax.swing.JLabel Entrada_2;
    private javax.swing.JLabel Entrada_3;
    private javax.swing.JLabel Entrada_4;
    private javax.swing.JLabel Entrada_5;
    private javax.swing.JLabel Entrada_6;
    private javax.swing.JLabel Entrada_7;
    private javax.swing.JLabel Entrada_8;
    private javax.swing.JButton Help_BT;
    private javax.swing.JLabel Label_Delay;
    private javax.swing.JLabel Label_Entradas;
    private javax.swing.JLabel Label_Saidas;
    private javax.swing.JButton Pause_BT;
    private javax.swing.JButton Run_BT;
    private javax.swing.JLabel Saida_1;
    private javax.swing.JLabel Saida_2;
    private javax.swing.JLabel Saida_3;
    private javax.swing.JLabel Saida_4;
    private javax.swing.JLabel Saida_5;
    private javax.swing.JLabel Saida_6;
    private javax.swing.JLabel Saida_7;
    private javax.swing.JLabel Saida_8;
    private javax.swing.JComboBox<String> Simulacoes;
    private javax.swing.JButton Sobre_BT;
    private javax.swing.JButton Variaveis_BT;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    // End of variables declaration//GEN-END:variables
}
