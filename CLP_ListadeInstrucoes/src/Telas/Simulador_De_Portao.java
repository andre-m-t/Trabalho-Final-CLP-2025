/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Telas;

import static Telas.Home_Pg.memoryVariables;
import static Telas.Home_Pg.showErrorMessage;
import compiladorinstructionlist.edit.Language;
import compiladorinstructionlist.input.InputActions;
import compiladorinstructionlist.interpreter.Interpreter;
import compiladorinstructionlist.memoryvariable.MemoryVariable;
import compiladorinstructionlist.output.OutputActions;
import java.awt.Graphics;
import java.awt.MediaTracker;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLayeredPane;
import javax.swing.Timer;
import javax.swing.text.BadLocationException;
import save.Save;

/**
 *
 * @author André
 */
public class Simulador_De_Portao extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Simulador_De_Portao.class.getName());

    //Variaveis Para controle
    private int alturaAtual = 400; // Altura inicial do portão 343
    private final int ALTURA_MIN = 50;
    private final int ALTURA_MAX = 400;//343
    private final int VELOCIDADE_PORTAO = 2;
    private javax.swing.Timer timerPortao;
    private boolean recolhendo = true;
    private boolean updating = false; 
    static Map<String, Boolean> inputs;
    static Map<String, Boolean> outputs;
    
    //Carregando imagens
    ImageIcon BL_Apertado = new ImageIcon(getClass().getResource("/Assets/EntortasBarSimulation/BotaoVerdeApertado.png"));
    ImageIcon BL_NaoApertado = new ImageIcon(getClass().getResource("/Assets/EntortasBarSimulation/BotaoVerde.png"));
    ImageIcon BD_Apertado = new ImageIcon(getClass().getResource("/Assets/EntortasBarSimulation/BotaoVermelhoApertado.png"));
    ImageIcon BD_NaoApertado = new ImageIcon(getClass().getResource("/Assets/EntortasBarSimulation/BotaoVermelho.png"));
    ImageIcon Lamp_Ligada = new ImageIcon(getClass().getResource("/Assets/EntortasBarSimulation/LampadaAcesa.png"));
    ImageIcon Lamp_Desligada = new ImageIcon(getClass().getResource("/Assets/EntortasBarSimulation/LampadaApagada.png"));
    
    
    /**
     * Creates new form Simulador_De_Portao
     */
    public Simulador_De_Portao() {
        initComponents();
        

        // Deixando Text Area Transparente
        Codigo_Camp.setOpaque(false); // Isso permite transparência
        Codigo_Camp.setBackground(new java.awt.Color(0, 0, 0, 0)); // Fundo 100% transparente
        
        //Desgin do Bloco para Codigo
        ImageIcon iconCampo = new ImageIcon(getClass().getResource("/Assets/bloco_notas.png"));
        iconCampo.setImage( iconCampo.getImage().getScaledInstance(Codigo_Camp.getWidth(),Codigo_Camp.getHeight(),1));
        Image_Camp.setIcon(iconCampo);
        
        //Inserindo imagem do Portao
        ImageIcon portaoIco = new ImageIcon(getClass().getResource("/Assets/EntortasBarSimulation/PortaoEntorta.png"));
        portaoIco.setImage(portaoIco.getImage().getScaledInstance(PortaoLabel.getWidth(),PortaoLabel.getHeight(),1));
        PortaoLabel.setIcon(portaoIco);
        
        //Definindo imagem inicial dos botões
        BL_Apertado.setImage(BL_Apertado.getImage().getScaledInstance(BotaoDeCima.getWidth(),BotaoDeCima.getHeight(),1));
        BL_NaoApertado.setImage(BL_NaoApertado.getImage().getScaledInstance(BotaoDeCima.getWidth(),BotaoDeCima.getHeight(),1));
        
        BotaoDeCima.setIcon(BL_NaoApertado);
        
        
        BD_Apertado.setImage(BD_Apertado.getImage().getScaledInstance(BotaoDeCima.getWidth(),BotaoDeCima.getHeight(),1));
        BD_NaoApertado.setImage(BD_NaoApertado.getImage().getScaledInstance(BotaoDeCima.getWidth(),BotaoDeCima.getHeight(),1));
        
        BotaoDeBaixo.setIcon(BD_NaoApertado);
        
        //Definindo imagem inicial das luzes indicadoras
        Lamp_Ligada.setImage(Lamp_Ligada.getImage().getScaledInstance(OpenLamp.getWidth(),OpenLamp.getHeight(),1));
        Lamp_Desligada.setImage(Lamp_Desligada.getImage().getScaledInstance(OpenLamp.getWidth(),OpenLamp.getHeight(),1));
        
        OpenLamp.setIcon(Lamp_Desligada);
        AjarLamp.setIcon(Lamp_Desligada);
        CloseLamp.setIcon(Lamp_Desligada);
        
        //Inicializa entradas e saídas
        //inputsType = new HashMap<>();
        inputs = new HashMap<>();
        outputs = new HashMap<>();
        //inputsType = InputActions.createType(inputsType);
        inputs = InputActions.create(inputs);
        System.out.println("HashMap de entradas criado:" + inputs);
        outputs = OutputActions.create(outputs);
        System.out.println("HashMap de saídas criado:" + outputs);
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Color_Camp = new javax.swing.JPanel();
        Codigo_Camp = new javax.swing.JTextArea();
        Image_Camp = new javax.swing.JLabel();
        PainelDeOpcoes = new javax.swing.JPanel();
        Arquivar_BT = new javax.swing.JComboBox<>();
        PLC_Status = new javax.swing.JComboBox<>();
        Help_BT = new javax.swing.JButton();
        Sobre_BT = new javax.swing.JButton();
        jSpinner1 = new javax.swing.JSpinner();
        Label_Delay = new javax.swing.JLabel();
        BarPanel = new Telas.PainelComImagem();
        PortaoLabel = new javax.swing.JLabel();
        BotaoDeCima = new javax.swing.JLabel();
        BotaoDeBaixo = new javax.swing.JLabel();
        OpenLabel = new javax.swing.JLabel();
        OpenLamp = new javax.swing.JLabel();
        AjarLabel = new javax.swing.JLabel();
        AjarLamp = new javax.swing.JLabel();
        CloseLabel = new javax.swing.JLabel();
        CloseLamp = new javax.swing.JLabel();
        BotaoCima_Label = new javax.swing.JLabel();
        BotaoBaixoLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1088, 913));

        Color_Camp.setBackground(new java.awt.Color(0, 102, 204));
        Color_Camp.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Codigo_Camp.setColumns(20);
        Codigo_Camp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Codigo_Camp.setForeground(new java.awt.Color(255, 255, 255));
        Codigo_Camp.setRows(5);
        Codigo_Camp.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        Codigo_Camp.setDragEnabled(true);
        Codigo_Camp.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        Codigo_Camp.setSelectionColor(new java.awt.Color(204, 204, 204));
        Color_Camp.add(Codigo_Camp, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 350, 750));
        Color_Camp.add(Image_Camp, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 750));

        Arquivar_BT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Arquivo", "Salvar", "Carregar" }));
        Arquivar_BT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Arquivar_BTActionPerformed(evt);
            }
        });

        PLC_Status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PROGRAM", "STOP", "RUN" }));
        PLC_Status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PLC_StatusActionPerformed(evt);
            }
        });

        Help_BT.setText("Help");

        Sobre_BT.setText("Sobre");
        Sobre_BT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Sobre_BTActionPerformed(evt);
            }
        });

        jSpinner1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        Label_Delay.setText("Tempo de Delay em ms:");

        javax.swing.GroupLayout PainelDeOpcoesLayout = new javax.swing.GroupLayout(PainelDeOpcoes);
        PainelDeOpcoes.setLayout(PainelDeOpcoesLayout);
        PainelDeOpcoesLayout.setHorizontalGroup(
            PainelDeOpcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelDeOpcoesLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(Arquivar_BT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PLC_Status, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Help_BT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Sobre_BT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(Label_Delay)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90))
        );
        PainelDeOpcoesLayout.setVerticalGroup(
            PainelDeOpcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelDeOpcoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PainelDeOpcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Arquivar_BT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PLC_Status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Help_BT)
                    .addComponent(Sobre_BT)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label_Delay))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout BarPanelLayout = new javax.swing.GroupLayout(BarPanel);
        BarPanel.setLayout(BarPanelLayout);
        BarPanelLayout.setHorizontalGroup(
            BarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PortaoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        BarPanelLayout.setVerticalGroup(
            BarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PortaoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
                .addContainerGap())
        );

        BotaoDeCima.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotaoDeCimaMouseClicked(evt);
            }
        });

        BotaoDeBaixo.setVerifyInputWhenFocusTarget(false);
        BotaoDeBaixo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotaoDeBaixoMouseClicked(evt);
            }
        });

        OpenLabel.setText("Aberto (Q1)");

        AjarLabel.setText("Entreaberto (Q2)");

        CloseLabel.setText("Fechado (Q3)");

        BotaoCima_Label.setText("Botao 1 (I1)");

        BotaoBaixoLabel.setText("Botao 2 (I2)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PainelDeOpcoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(BotaoDeCima, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                .addComponent(BotaoDeBaixo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(OpenLabel)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(AjarLabel)
                                        .addComponent(CloseLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addGap(6, 6, 6)
                                            .addComponent(CloseLamp, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(OpenLamp, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(AjarLamp, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(BotaoCima_Label))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(BotaoBaixoLabel)))
                        .addGap(33, 33, 33)
                        .addComponent(BarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Color_Camp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Color_Camp, javax.swing.GroupLayout.PREFERRED_SIZE, 764, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PainelDeOpcoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(OpenLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(OpenLamp, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(AjarLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(AjarLamp, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(CloseLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CloseLamp, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(BotaoDeCima, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BotaoCima_Label)
                                .addGap(22, 22, 22)
                                .addComponent(BotaoDeBaixo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(BarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BotaoBaixoLabel)))
                .addGap(188, 188, 188))
        );

        BotaoDeCima.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                // Quando o botão for pressionado, muda para a imagem de pressionado
                BotaoDeCima.setIcon(BL_Apertado);
                // Cria o Timer para subir o portão
                timerPortao = new javax.swing.Timer(15, e -> subirPortao()); // Passa a função abaixarPortao
                timerPortao.start(); //Primeiramente sem logica
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                // Quando o botão for solto, volta para a imagem inicial
                BotaoDeCima.setIcon(BL_NaoApertado);
                if(timerPortao != null)
                timerPortao.stop();
            }
        });
        BotaoDeBaixo.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                // Quando o botão for pressionado, muda para a imagem de pressionado
                BotaoDeBaixo.setIcon(BD_Apertado);
                // Cria o Timer para descer o portão
                timerPortao = new javax.swing.Timer(15, e -> abaixarPortao()); // Passa a função abaixarPortao
                timerPortao.start(); //Primeiramente sem logica
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                // Quando o botão for solto, volta para a imagem inicial
                BotaoDeBaixo.setIcon(BD_NaoApertado);
                if(timerPortao != null)
                timerPortao.stop();
            }
        });

        getAccessibleContext().setAccessibleName("Bar Simulation");
        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void subirPortao(){
        if (alturaAtual > ALTURA_MIN) {
                alturaAtual -= VELOCIDADE_PORTAO;
                PortaoLabel.setSize(PortaoLabel.getWidth(), alturaAtual);
                PortaoLabel.repaint();
        }
    }
    
    private void abaixarPortao(){
        if (alturaAtual < ALTURA_MAX ) {
                alturaAtual += VELOCIDADE_PORTAO;
                PortaoLabel.setSize(PortaoLabel.getWidth(), alturaAtual);
                PortaoLabel.repaint();
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
                Logger.getLogger(Simulador_De_Portao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        System.out.println("Lista de linhas: " + lineList);
        return lineList;
    }
    
    private void iniciarAnimacaoPortao() {
    if (timerPortao != null && timerPortao.isRunning()) return;

    recolhendo = !recolhendo;

    timerPortao = new javax.swing.Timer(15, e -> {
        if (recolhendo) {
            if (alturaAtual > ALTURA_MIN) {
                alturaAtual -= VELOCIDADE_PORTAO;
                PortaoLabel.setSize(PortaoLabel.getWidth(), alturaAtual);
                PortaoLabel.repaint();
            } else {
                timerPortao.stop();
            }
        } else {
            if (alturaAtual < ALTURA_MAX) {
                alturaAtual += VELOCIDADE_PORTAO;
                PortaoLabel.setSize(PortaoLabel.getWidth(), alturaAtual);
                PortaoLabel.repaint();
            } else {
                timerPortao.stop();
            }
        }
    });
    timerPortao.start();
}
    private void Arquivar_BTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Arquivar_BTActionPerformed
         if (updating) return;
            if(Language.getArquivar().getItemAt(2) == (Arquivar_BT.getSelectedItem().toString())){
                JFileChooser c = new JFileChooser();
                String filename = "";
                String dir = "";
                // Demonstrate "Open" dialog:
                int rVal = c.showOpenDialog(Simulador_De_Portao.this);
                if (rVal == JFileChooser.APPROVE_OPTION) {
                  filename = (c.getSelectedFile().getName());
                  dir = (c.getCurrentDirectory().toString());
                }
                List<String> memory = new ArrayList<>();
                try {
                    memory = Save.load(dir+"\\"+filename);
                    Codigo_Camp.setText("");
                    for(int i = 0; i < memory.size(); i++){
                        Codigo_Camp.append(memory.get(i));
                        Codigo_Camp.append("\n");
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Simulador_De_Portao.class.getName()).log(Level.SEVERE, null, ex);
                }
                Arquivar_BT.setSelectedIndex(0);
            }

            if(Arquivar_BT.getItemAt(1)==(Arquivar_BT.getSelectedItem()) ){

                Arquivar_BT.setSelectedIndex(0);

                JFileChooser c = new JFileChooser();
                String filename = "";
                String dir = "";
                // Demonstrate "Save" dialog:
                int rVal = c.showSaveDialog(Simulador_De_Portao.this);
                if (rVal == JFileChooser.APPROVE_OPTION) {
                  filename = (c.getSelectedFile().getName());
                  dir = (c.getCurrentDirectory().toString());
                }

                List<String> memory = new ArrayList<>();
                memory = saveLines(memory);
                try {
                    Save.save(dir+"\\"+filename, memory);
                } catch (IOException ex) {
                    Logger.getLogger(Simulador_De_Portao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    }//GEN-LAST:event_Arquivar_BTActionPerformed

    private void PLC_StatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PLC_StatusActionPerformed
        if(PLC_Status.getSelectedItem().toString() == "RUN"){
            //Bloqueia campo de codigo
            Codigo_Camp.setEditable(false);
            
            
            
            // Verificando tempo de delay
            String stringTime = jSpinner1.getValue().toString();
            Integer time = 0;

            if (!stringTime.equals("")) {
                try {
                    time = Integer.valueOf(stringTime);
                } catch (NumberFormatException e) {
                    showErrorMessage("Tempo de delay inválido! Insira um número inteiro.");
                }

                System.out.println("Tempo de delay: " + time + "\n");
            }
            
            // Executa o laço corretamente sem travar a tela 
            @SuppressWarnings("unchecked")
            Timer timer = new Timer(time, (ActionEvent evt1) -> {
                //Salva o codigo digitado num array
                List<String> lineList = saveLines(new ArrayList<>());
                lineList = saveLines(lineList);
                if (PLC_Status.getSelectedItem().toString() == "RUN") {
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
                    updateScreen();
                    updateMemoryVariables();
                } else {
                    ((Timer) evt1.getSource()).stop();
                }
            });

            timer.setInitialDelay(0); // começa sem atraso
            timer.start();
            
            
        }
        if(PLC_Status.getSelectedItem().toString() == "PROGRAM"){
            Codigo_Camp.setEditable(true);
        }
        if(PLC_Status.getSelectedItem().toString() == "STOP"){
            //Bloqueia Campo de codigo
            Codigo_Camp.setEditable(false);
            //Botao Stop Clicado
            for (Map.Entry<String, MemoryVariable> variable : memoryVariables.entrySet()) {
                if(variable.getKey().charAt(0) == 'T'){
                    variable.getValue().timer.stop();
                }
            }
            updateMemoryVariables();
        }

    }//GEN-LAST:event_PLC_StatusActionPerformed

    private void Sobre_BTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Sobre_BTActionPerformed
        // TODO add your handling code here:
        iniciarAnimacaoPortao();
    }//GEN-LAST:event_Sobre_BTActionPerformed

    private void BotaoDeCimaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoDeCimaMouseClicked
        // TODO add your handling code here: 
        //BotaoDeCima.setIcon(BL_Apertado);
        //subirPortao();
     
    }//GEN-LAST:event_BotaoDeCimaMouseClicked

    private void BotaoDeBaixoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoDeBaixoMouseClicked
        // TODO add your handling code here:
        //BotaoDeBaixo.setIcon(BD_Apertado);
        //abaixarPortao();
    }//GEN-LAST:event_BotaoDeBaixoMouseClicked

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Simulador_De_Portao().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AjarLabel;
    private javax.swing.JLabel AjarLamp;
    private javax.swing.JComboBox<String> Arquivar_BT;
    private javax.swing.JPanel BarPanel;
    private javax.swing.JLabel BotaoBaixoLabel;
    private javax.swing.JLabel BotaoCima_Label;
    private javax.swing.JLabel BotaoDeBaixo;
    private javax.swing.JLabel BotaoDeCima;
    private javax.swing.JLabel CloseLabel;
    private javax.swing.JLabel CloseLamp;
    private javax.swing.JTextArea Codigo_Camp;
    private javax.swing.JPanel Color_Camp;
    private javax.swing.JButton Help_BT;
    private javax.swing.JLabel Image_Camp;
    private javax.swing.JLabel Label_Delay;
    private javax.swing.JLabel OpenLabel;
    private javax.swing.JLabel OpenLamp;
    private javax.swing.JComboBox<String> PLC_Status;
    private javax.swing.JPanel PainelDeOpcoes;
    private javax.swing.JLabel PortaoLabel;
    private javax.swing.JButton Sobre_BT;
    private javax.swing.JSpinner jSpinner1;
    // End of variables declaration//GEN-END:variables
}