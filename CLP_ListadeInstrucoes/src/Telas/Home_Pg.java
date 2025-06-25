/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Telas;

import compiladorinstructionlist.edit.Colors;
import compiladorinstructionlist.edit.Language;
import javax.swing.ImageIcon;
import compiladorinstructionlist.interpreter.Interpreter;
import compiladorinstructionlist.input.InputActions;
import compiladorinstructionlist.memoryvariable.MemoryVariable;
import compiladorinstructionlist.output.OutputActions;
import compiladorinstructionlist.uppercasedocumentfilter.UpperCaseDocumentFilter;
import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import save.Save;

/**
 *
 * @author vinic
 */
public final class Home_Pg extends javax.swing.JFrame {

    /**
     * Creates new form Home_Pg
     */

     // Cria variáveis
    static Map<String, Integer> inputsType;
    static Map<String, Boolean> inputs;
    static Map<String, Boolean> outputs;
    @SuppressWarnings("Convert2Diamond")
    static Map<String, MemoryVariable> memoryVariables = new HashMap<String, MemoryVariable>();
    static Integer mode = 1;
    static Integer color = 1;
    Lista_de_variaveis_Pg tela2 = new Lista_de_variaveis_Pg();
    Simulador_De_Portao telaPortao = new Simulador_De_Portao();
    private JTextArea Lista_de_variaveis = null;
    private boolean updating = false;
    
    @SuppressWarnings("unchecked")
    public Home_Pg() {
        initComponents();
        Lista_de_variaveis = tela2.getListaDeVariaveis();
        //setando informaçoes iniciais
        ImageIcon iconplay = new ImageIcon(getClass().getResource("/Assets/start.png"));
        iconplay.setImage( iconplay.getImage().getScaledInstance(Run_BT.getWidth(), Run_BT.getHeight(),1));
        Run_BT.setIcon(iconplay);
        ImageIcon iconpause = new ImageIcon(getClass().getResource("/Assets/pause.png"));
        
        iconpause.setImage( iconpause.getImage().getScaledInstance(Pause_BT.getWidth(), Pause_BT.getHeight(),1));
        Pause_BT.setIcon(iconpause);
        
        
        ImageIcon iconBarra = new ImageIcon(getClass().getResource("/Assets/Barra_Lateral.png"));
        iconBarra.setImage( iconBarra.getImage().getScaledInstance(Variaveis_BT.getWidth(),Variaveis_BT.getHeight(),1));
        Variaveis_BT.setIcon(iconBarra);
        
        
        ImageIcon iconCampo = new ImageIcon(getClass().getResource("/Assets/bloco_notas.png"));
        iconCampo.setImage( iconCampo.getImage().getScaledInstance(Codigo_Camp.getWidth(),Codigo_Camp.getHeight(),1));
        Image_Camp.setIcon(iconCampo);
        
        
        Codigo_Camp.setOpaque(false);
        
        //adicionando icones de contador e timer
        ImageIcon icontimer = new ImageIcon(getClass().getResource("/Assets/temporizador.png"));
        icontimer.setImage( icontimer.getImage().getScaledInstance(Timer_1.getWidth(), Timer_1.getHeight(),1));
        Timer_1.setIcon(icontimer);       
        Timer_2.setIcon(icontimer);
        Timer_3.setIcon(icontimer);
        Timer_4.setIcon(icontimer);
        Timer_5.setIcon(icontimer);
        Timer_6.setIcon(icontimer);
        Timer_7.setIcon(icontimer);
        Timer_8.setIcon(icontimer);
        Timer_9.setIcon(icontimer);
        Timer_10.setIcon(icontimer);
        ImageIcon iconCont = new ImageIcon(getClass().getResource("/Assets/contador.png"));
        iconCont.setImage( iconCont.getImage().getScaledInstance(Contador_1.getWidth(), Contador_1.getHeight(),1));
        Contador_1.setIcon(iconCont);
        Contador_2.setIcon(iconCont);
        Contador_3.setIcon(iconCont);
        Contador_4.setIcon(iconCont);
        Contador_5.setIcon(iconCont);
        Contador_6.setIcon(iconCont);
        Contador_7.setIcon(iconCont);
        Contador_8.setIcon(iconCont);
        Contador_9.setIcon(iconCont);
        Contador_10.setIcon(iconCont);
        
        
        AbstractDocument doc = (AbstractDocument) Codigo_Camp.getDocument();
        doc.setDocumentFilter(new UpperCaseDocumentFilter());
        //Inicializa entradas e saídas
        inputsType = new HashMap<>();
        inputs = new HashMap<>();
        outputs = new HashMap<>();
        inputsType = InputActions.createType(inputsType);
        inputs = InputActions.create(inputs);
        System.out.println("HashMap de entradas criado:" + inputs);
        outputs = OutputActions.create(outputs);
        System.out.println("HashMap de saídas criado:" + outputs);
        // Atualiza entradas e saídas na tela
        updateScreen();
        // Ativa o interceptador de clique com mensagem
    setGlassPane(new java.awt.Panel() {
        {
            //setOpaque(false); // invisível
            addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mousePressed(java.awt.event.MouseEvent e) {
                    JOptionPane.showMessageDialog(null,
                        "A simulação de portão está em execução.\nFeche essa janela para continuar.",
                        "Janela Bloqueada",
                        JOptionPane.WARNING_MESSAGE);
                }
            });
        }
    });
        
        
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
        ImageIcon icon1 = new ImageIcon(getClass().getResource("/Assets/chave_aberta.png"));
        icon1.setImage(icon1.getImage().getScaledInstance(Saida_1.getWidth(), Saida_1.getHeight(), 1));

        ImageIcon icon2 = new ImageIcon(getClass().getResource("/Assets/chave_fechada.png"));
        icon2.setImage(icon2.getImage().getScaledInstance(Saida_1.getWidth(), Saida_1.getHeight(), 1));

        ImageIcon icon3 = new ImageIcon(getClass().getResource("/Assets/buttom.png"));
        icon3.setImage(icon3.getImage().getScaledInstance(Saida_1.getWidth(), Saida_1.getHeight(), 1));

        ImageIcon icon4 = new ImageIcon(getClass().getResource("/Assets/botao_fechado.png"));
        icon4.setImage(icon4.getImage().getScaledInstance(Saida_1.getWidth(), Saida_1.getHeight(), 1));

        ImageIcon icon5 = new ImageIcon(getClass().getResource("/Assets/button_pi_aberto.png"));
        icon5.setImage(icon5.getImage().getScaledInstance(Saida_1.getWidth(), Saida_1.getHeight(), 1));

        ImageIcon icon6 = new ImageIcon(getClass().getResource("/Assets/buttom_pi.png"));
        icon6.setImage(icon6.getImage().getScaledInstance(Saida_1.getWidth(), Saida_1.getHeight(), 1));


        
        Entrada_1.setIcon(inputsType.get("I1") == 0? inputs.get("I1")?icon2:icon1:inputsType.get("I1") == 1?inputs.get("I1")?icon4:icon3:inputsType.get("I1") == 2? inputs.get("I1")?icon6:icon5:icon1);
        Entrada_2.setIcon(inputsType.get("I2") == 0? inputs.get("I2")?icon2:icon1:inputsType.get("I2") == 1?inputs.get("I2")?icon4:icon3:inputsType.get("I2") == 2? inputs.get("I2")?icon6:icon5:icon1);
        Entrada_3.setIcon(inputsType.get("I3") == 0? inputs.get("I3")?icon2:icon1:inputsType.get("I3") == 1?inputs.get("I3")?icon4:icon3:inputsType.get("I3") == 2? inputs.get("I3")?icon6:icon5:icon1);
        Entrada_4.setIcon(inputsType.get("I4") == 0? inputs.get("I4")?icon2:icon1:inputsType.get("I4") == 1?inputs.get("I4")?icon4:icon3:inputsType.get("I4") == 2? inputs.get("I4")?icon6:icon5:icon1);
        Entrada_5.setIcon(inputsType.get("I5") == 0? inputs.get("I5")?icon2:icon1:inputsType.get("I5") == 1?inputs.get("I5")?icon4:icon3:inputsType.get("I5") == 2? inputs.get("I5")?icon6:icon5:icon1);
        Entrada_6.setIcon(inputsType.get("I6") == 0? inputs.get("I6")?icon2:icon1:inputsType.get("I6") == 1?inputs.get("I6")?icon4:icon3:inputsType.get("I6") == 2? inputs.get("I6")?icon6:icon5:icon1);
        Entrada_7.setIcon(inputsType.get("I7") == 0? inputs.get("I7")?icon2:icon1:inputsType.get("I7") == 1?inputs.get("I7")?icon4:icon3:inputsType.get("I7") == 2? inputs.get("I7")?icon6:icon5:icon1);
        Entrada_8.setIcon(inputsType.get("I8") == 0? inputs.get("I8")?icon2:icon1:inputsType.get("I8") == 1?inputs.get("I8")?icon4:icon3:inputsType.get("I8") == 2? inputs.get("I8")?icon6:icon5:icon1);
        
        
        icon3 = new ImageIcon(getClass().getResource("/Assets/led_desligado.png"));
        icon3.setImage( icon3.getImage().getScaledInstance(Saida_1.getWidth(), Saida_1.getHeight(),1));
        icon4 = new ImageIcon(getClass().getResource("/Assets/led_ligado.png"));
        icon4.setImage( icon4.getImage().getScaledInstance(Saida_1.getWidth(), Saida_1.getHeight(),1));
        Saida_1.setIcon(outputs.get("Q1")?icon4:icon3);
        Saida_2.setIcon(outputs.get("Q2")?icon4:icon3);
        Saida_3.setIcon(outputs.get("Q3")?icon4:icon3);
        Saida_4.setIcon(outputs.get("Q4")?icon4:icon3);
        Saida_5.setIcon(outputs.get("Q5")?icon4:icon3);
        Saida_6.setIcon(outputs.get("Q6")?icon4:icon3);
        Saida_7.setIcon(outputs.get("Q7")?icon4:icon3);
        Saida_8.setIcon(outputs.get("Q8")?icon4:icon3);
    }

    // Atualiza o modo atual na tela
    public void updateMode() {
        System.out.println("Modo atual: " + mode);
        if (null == mode) {
            Codigo_Camp.setEditable(false);
            ImageIcon icon1 = new ImageIcon(getClass().getResource("/Assets/start_verde.png"));
            icon1.setImage( icon1.getImage().getScaledInstance(Run_BT.getWidth(), Run_BT.getHeight(),1));
            Run_BT.setIcon(icon1);
        } else switch (mode) {
            case 1 ->                 {
                    Codigo_Camp.setEditable(true);
                    ImageIcon icon1 = new ImageIcon(getClass().getResource("/Assets/start.png"));
                    icon1.setImage( icon1.getImage().getScaledInstance(Run_BT.getWidth(), Run_BT.getHeight(),1));
                    Run_BT.setIcon(icon1);
                //jSpinner1.setEditable(true);
                }
            case 2 ->                 {
                    Codigo_Camp.setEditable(false);
                    ImageIcon icon1 = new ImageIcon(getClass().getResource("/Assets/start.png"));
                    icon1.setImage( icon1.getImage().getScaledInstance(Run_BT.getWidth(), Run_BT.getHeight(),1));
                    Run_BT.setIcon(icon1);
                }
            default ->                 {
                    Codigo_Camp.setEditable(false);
                    ImageIcon icon1 = new ImageIcon(getClass().getResource("/Assets/start_verde.png"));
                    icon1.setImage( icon1.getImage().getScaledInstance(Run_BT.getWidth(), Run_BT.getHeight(),1));
                    Run_BT.setIcon(icon1);
                }
        }
    }

    // Atualiza as variáveis de memória na tela
    public void updateMemoryVariables() {
        Lista_de_variaveis.setText("");
    
        String line = "";
        List<MemoryVariable> tVariables = new ArrayList<>();
        List<MemoryVariable> cVariables = new ArrayList<>();
        int contC = 1;
        int contT = 1;
    
        for (Map.Entry<String, MemoryVariable> variable : memoryVariables.entrySet()) {
            switch (variable.getKey().charAt(0)) {
                case 'M' -> {
                    line = variable.getKey() + " = " + variable.getValue().currentValue + "\n";
                }
                case 'T' -> {
                    line = variable.getKey() + " = " + variable.getValue().currentValue + ", " + variable.getValue().counter + ", " + variable.getValue().maxTimer + ", " + variable.getValue().endTimer + "\n";
                    if (tVariables.size() < 10) {
                        tVariables.add(variable.getValue());
                    }
                }
                case 'C' -> {
                    line = variable.getKey() + " = " + variable.getValue().counter + ", " + variable.getValue().maxTimer + ", " + variable.getValue().endTimer + "\n";
                    if (cVariables.size() < 10) {
                        cVariables.add(variable.getValue());
                    }
                }
                default -> {
                }
            }
    
            Lista_de_variaveis.setText(Lista_de_variaveis.getText() + line);
        }
    
        // Exemplo de como você pode usar as listas tVariables e cVariables
        for (MemoryVariable tVariable : tVariables) {
            // System.out.println("ID: " + tVariable.id + ", Counter: " + tVariable.counter + ", MaxTimer: " + tVariable.maxTimer);
            switch (contT) {
                case 1 -> {
                    Timer_1.setText(String.valueOf(tVariable.id));
                    Timer_1.setHorizontalTextPosition(JLabel.CENTER);
                    Timer_1.setVerticalTextPosition(JLabel.CENTER);
                    Timer_1.setForeground(Color.WHITE);

                    Temp_atual_1.setText(String.valueOf(tVariable.counter));
                    Temp_atual_1.setHorizontalAlignment(SwingConstants.CENTER);
            
                    Temp_parada_1.setText(String.valueOf(tVariable.maxTimer));
                    Temp_parada_1.setHorizontalAlignment(SwingConstants.CENTER);
                }
                case 2 -> {
                    Timer_2.setText(String.valueOf(tVariable.id));
                    Timer_2.setHorizontalTextPosition(JLabel.CENTER);
                    Timer_2.setVerticalTextPosition(JLabel.CENTER);
                    Timer_2.setForeground(Color.WHITE);

                    Temp_atual_2.setText(String.valueOf(tVariable.counter));
                    Temp_atual_2.setHorizontalAlignment(SwingConstants.CENTER);
            
                    Temp_parada_2.setText(String.valueOf(tVariable.maxTimer));
                    Temp_parada_2.setHorizontalAlignment(SwingConstants.CENTER);
                }
                case 3 -> {
                    Timer_3.setText(String.valueOf(tVariable.id));
                    Timer_3.setHorizontalTextPosition(JLabel.CENTER);
                    Timer_3.setVerticalTextPosition(JLabel.CENTER);
                    Timer_3.setForeground(Color.WHITE);

                    Temp_atual_3.setText(String.valueOf(tVariable.counter));
                    Temp_atual_3.setHorizontalAlignment(SwingConstants.CENTER);
            
                    Temp_parada_3.setText(String.valueOf(tVariable.maxTimer));
                    Temp_parada_3.setHorizontalAlignment(SwingConstants.CENTER);
                }
                case 4 -> {
                    Timer_4.setText(String.valueOf(tVariable.id));
                    Timer_4.setHorizontalTextPosition(JLabel.CENTER);
                    Timer_4.setVerticalTextPosition(JLabel.CENTER);
                    Timer_4.setForeground(Color.WHITE);

                    Temp_atual_4.setText(String.valueOf(tVariable.counter));
                    Temp_atual_4.setHorizontalAlignment(SwingConstants.CENTER);
            
                    Temp_parada_4.setText(String.valueOf(tVariable.maxTimer));
                    Temp_parada_4.setHorizontalAlignment(SwingConstants.CENTER);
                }
                case 5 -> {
                    Timer_5.setText(String.valueOf(tVariable.id));
                    Timer_5.setHorizontalTextPosition(JLabel.CENTER);
                    Timer_5.setVerticalTextPosition(JLabel.CENTER);
                    Timer_5.setForeground(Color.WHITE);

                    Temp_atual_5.setText(String.valueOf(tVariable.counter));
                    Temp_atual_5.setHorizontalAlignment(SwingConstants.CENTER);
            
                    Temp_parada_5.setText(String.valueOf(tVariable.maxTimer));
                    Temp_parada_5.setHorizontalAlignment(SwingConstants.CENTER);
                }
                case 6 -> {
                    Timer_6.setText(String.valueOf(tVariable.id));
                    Timer_6.setHorizontalTextPosition(JLabel.CENTER);
                    Timer_6.setVerticalTextPosition(JLabel.CENTER);
                    Timer_6.setForeground(Color.WHITE);

                    Temp_atual_6.setText(String.valueOf(tVariable.counter));
                    Temp_atual_6.setHorizontalAlignment(SwingConstants.CENTER);
            
                    Temp_parada_6.setText(String.valueOf(tVariable.maxTimer));
                    Temp_parada_6.setHorizontalAlignment(SwingConstants.CENTER);
                }
                case 7 -> {
                    Timer_7.setText(String.valueOf(tVariable.id));
                    Timer_7.setHorizontalTextPosition(JLabel.CENTER);
                    Timer_7.setVerticalTextPosition(JLabel.CENTER);
                    Timer_7.setForeground(Color.WHITE);

                    Temp_atual_7.setText(String.valueOf(tVariable.counter));
                    Temp_atual_7.setHorizontalAlignment(SwingConstants.CENTER);
            
                    Temp_parada_7.setText(String.valueOf(tVariable.maxTimer));
                    Temp_parada_7.setHorizontalAlignment(SwingConstants.CENTER);
                }
                case 8 -> {
                    Timer_8.setText(String.valueOf(tVariable.id));
                    Timer_8.setHorizontalTextPosition(JLabel.CENTER);
                    Timer_8.setVerticalTextPosition(JLabel.CENTER);
                    Timer_8.setForeground(Color.WHITE);

                    Temp_atual_8.setText(String.valueOf(tVariable.counter));
                    Temp_atual_8.setHorizontalAlignment(SwingConstants.CENTER);
            
                    Temp_parada_8.setText(String.valueOf(tVariable.maxTimer));
                    Temp_parada_8.setHorizontalAlignment(SwingConstants.CENTER);
                }
                case 9 -> {
                    Timer_9.setText(String.valueOf(tVariable.id));
                    Timer_9.setHorizontalTextPosition(JLabel.CENTER);
                    Timer_9.setVerticalTextPosition(JLabel.CENTER);
                    Timer_9.setForeground(Color.WHITE);

                    Temp_atual_9.setText(String.valueOf(tVariable.counter));
                    Temp_atual_9.setHorizontalAlignment(SwingConstants.CENTER);
            
                    Temp_parada_9.setText(String.valueOf(tVariable.maxTimer));
                    Temp_parada_9.setHorizontalAlignment(SwingConstants.CENTER);
                }
                case 10 -> {
                    Timer_10.setText(String.valueOf(tVariable.id));
                    Timer_10.setHorizontalTextPosition(JLabel.CENTER);
                    Timer_10.setVerticalTextPosition(JLabel.CENTER);
                    Timer_10.setForeground(Color.WHITE);

                    Temp_atual_10.setText(String.valueOf(tVariable.counter));
                    Temp_atual_10.setHorizontalAlignment(SwingConstants.CENTER);
            
                    Temp_parada_10.setText(String.valueOf(tVariable.maxTimer));
                    Temp_parada_10.setHorizontalAlignment(SwingConstants.CENTER);
                }
            }
            contT++;
        }
        for (MemoryVariable cVariable : cVariables) {
            // System.out.println("ID: " + cVariable.id + ", Counter: " + cVariable.counter + ", MaxTimer: " + cVariable.maxTimer);
            switch(contC) {
                case 1 -> {
                    Contador_1.setText(String.valueOf(cVariable.id));
                    Contador_1.setHorizontalTextPosition(JLabel.CENTER);
                    Contador_1.setVerticalTextPosition(JLabel.CENTER);
                    Contador_1.setForeground(Color.WHITE);
                    
                    Contagem_atual_1.setText(String.valueOf(cVariable.counter));
                    Contagem_atual_1.setHorizontalAlignment(SwingConstants.CENTER);
            
                    Contagem_parada_1.setText(String.valueOf(cVariable.maxTimer));
                    Contagem_parada_1.setHorizontalAlignment(SwingConstants.CENTER);
                }
                case 2 -> {
                    Contador_2.setText(String.valueOf(cVariable.id));
                    Contador_2.setHorizontalTextPosition(JLabel.CENTER);
                    Contador_2.setVerticalTextPosition(JLabel.CENTER);
                    Contador_2.setForeground(Color.WHITE);

                    Contagem_atual_2.setText(String.valueOf(cVariable.counter));
                    Contagem_atual_2.setHorizontalAlignment(SwingConstants.CENTER);
            
                    Contagem_parada_2.setText(String.valueOf(cVariable.maxTimer));
                    Contagem_parada_2.setHorizontalAlignment(SwingConstants.CENTER);
                }
                case 3 -> {
                    Contador_3.setText(String.valueOf(cVariable.id));
                    Contador_3.setHorizontalTextPosition(JLabel.CENTER);
                    Contador_3.setVerticalTextPosition(JLabel.CENTER);
                    Contador_3.setForeground(Color.WHITE);

                    Contagem_atual_3.setText(String.valueOf(cVariable.counter));
                    Contagem_atual_3.setHorizontalAlignment(SwingConstants.CENTER);
            
                    Contagem_parada_3.setText(String.valueOf(cVariable.maxTimer));
                    Contagem_parada_3.setHorizontalAlignment(SwingConstants.CENTER);
                }
                case 4 -> {
                    Contador_4.setText(String.valueOf(cVariable.id));
                    Contador_4.setHorizontalTextPosition(JLabel.CENTER);
                    Contador_4.setVerticalTextPosition(JLabel.CENTER);
                    Contador_4.setForeground(Color.WHITE);

                    Contagem_atual_4.setText(String.valueOf(cVariable.counter));
                    Contagem_atual_4.setHorizontalAlignment(SwingConstants.CENTER);
            
                    Contagem_parada_4.setText(String.valueOf(cVariable.maxTimer));
                    Contagem_parada_4.setHorizontalAlignment(SwingConstants.CENTER);
                }
                case 5 -> {
                    Contador_5.setText(String.valueOf(cVariable.id));
                    Contador_5.setHorizontalTextPosition(JLabel.CENTER);
                    Contador_5.setVerticalTextPosition(JLabel.CENTER);
                    Contador_5.setForeground(Color.WHITE);

                    Contagem_atual_5.setText(String.valueOf(cVariable.counter));
                    Contagem_atual_5.setHorizontalAlignment(SwingConstants.CENTER);
            
                    Contagem_parada_5.setText(String.valueOf(cVariable.maxTimer));
                    Contagem_parada_5.setHorizontalAlignment(SwingConstants.CENTER);
                }
                case 6 -> {
                    Contador_6.setText(String.valueOf(cVariable.id));
                    Contador_6.setHorizontalTextPosition(JLabel.CENTER);
                    Contador_6.setVerticalTextPosition(JLabel.CENTER);
                    Contador_6.setForeground(Color.WHITE);

                    Contagem_atual_6.setText(String.valueOf(cVariable.counter));
                    Contagem_atual_6.setHorizontalAlignment(SwingConstants.CENTER);
            
                    Contagem_parada_6.setText(String.valueOf(cVariable.maxTimer));
                    Contagem_parada_6.setHorizontalAlignment(SwingConstants.CENTER);
                }
                case 7 -> {
                    Contador_7.setText(String.valueOf(cVariable.id));
                    Contador_7.setHorizontalTextPosition(JLabel.CENTER);
                    Contador_7.setVerticalTextPosition(JLabel.CENTER);
                    Contador_7.setForeground(Color.WHITE);

                    Contagem_atual_7.setText(String.valueOf(cVariable.counter));
                    Contagem_atual_7.setHorizontalAlignment(SwingConstants.CENTER);
            
                    Contagem_parada_7.setText(String.valueOf(cVariable.maxTimer));
                    Contagem_parada_7.setHorizontalAlignment(SwingConstants.CENTER);
                }
                case 8 -> {
                    Contador_8.setText(String.valueOf(cVariable.id));
                    Contador_8.setHorizontalTextPosition(JLabel.CENTER);
                    Contador_8.setVerticalTextPosition(JLabel.CENTER);
                    Contador_8.setForeground(Color.WHITE);

                    Contagem_atual_8.setText(String.valueOf(cVariable.counter));
                    Contagem_atual_8.setHorizontalAlignment(SwingConstants.CENTER);
            
                    Contagem_parada_8.setText(String.valueOf(cVariable.maxTimer));
                    Contagem_parada_8.setHorizontalAlignment(SwingConstants.CENTER);
                }
                case 9 -> {
                    Contador_9.setText(String.valueOf(cVariable.id));
                    Contador_9.setHorizontalTextPosition(JLabel.CENTER);
                    Contador_9.setVerticalTextPosition(JLabel.CENTER);
                    Contador_9.setForeground(Color.WHITE);

                    Contagem_atual_9.setText(String.valueOf(cVariable.counter));
                    Contagem_atual_9.setHorizontalAlignment(SwingConstants.CENTER);
            
                    Contagem_parada_9.setText(String.valueOf(cVariable.maxTimer));
                    Contagem_parada_9.setHorizontalAlignment(SwingConstants.CENTER);
                }
                case 10 -> {
                    Contador_10.setText(String.valueOf(cVariable.id));
                    Contador_10.setHorizontalTextPosition(JLabel.CENTER);
                    Contador_10.setVerticalTextPosition(JLabel.CENTER);
                    Contador_10.setForeground(Color.WHITE);

                    Contagem_atual_10.setText(String.valueOf(cVariable.counter));
                    Contagem_atual_10.setHorizontalAlignment(SwingConstants.CENTER);
            
                    Contagem_parada_10.setText(String.valueOf(cVariable.maxTimer));
                    Contagem_parada_10.setHorizontalAlignment(SwingConstants.CENTER);
                }
            }
            contC++;
        }
    }

    // Mostra mensagem de erro na tela
    public static void showErrorMessage(String message) {
        mode = 1;
        JOptionPane.showMessageDialog(null, message);
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
    
    @SuppressWarnings("rawtypes")
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
        Variaveis_BT = new javax.swing.JButton();
        jSpinner1 = new javax.swing.JSpinner();
        Label_Delay = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Temp_parada_1 = new javax.swing.JLabel();
        Temp_parada_2 = new javax.swing.JLabel();
        Temp_parada_3 = new javax.swing.JLabel();
        Temp_parada_4 = new javax.swing.JLabel();
        Temp_parada_5 = new javax.swing.JLabel();
        Temp_parada_6 = new javax.swing.JLabel();
        Temp_parada_7 = new javax.swing.JLabel();
        Temp_parada_8 = new javax.swing.JLabel();
        Temp_parada_9 = new javax.swing.JLabel();
        Temp_parada_10 = new javax.swing.JLabel();
        Contagem_parada_1 = new javax.swing.JLabel();
        Contagem_parada_2 = new javax.swing.JLabel();
        Contagem_parada_3 = new javax.swing.JLabel();
        Contagem_parada_4 = new javax.swing.JLabel();
        Contagem_parada_5 = new javax.swing.JLabel();
        Contagem_parada_6 = new javax.swing.JLabel();
        Contagem_parada_7 = new javax.swing.JLabel();
        Contagem_parada_8 = new javax.swing.JLabel();
        Contagem_parada_9 = new javax.swing.JLabel();
        Contagem_parada_10 = new javax.swing.JLabel();
        Temp_atual_1 = new javax.swing.JLabel();
        Temp_atual_2 = new javax.swing.JLabel();
        Temp_atual_3 = new javax.swing.JLabel();
        Temp_atual_4 = new javax.swing.JLabel();
        Temp_atual_5 = new javax.swing.JLabel();
        Temp_atual_6 = new javax.swing.JLabel();
        Temp_atual_7 = new javax.swing.JLabel();
        Temp_atual_8 = new javax.swing.JLabel();
        Temp_atual_9 = new javax.swing.JLabel();
        Temp_atual_10 = new javax.swing.JLabel();
        Contagem_atual_1 = new javax.swing.JLabel();
        Contagem_atual_2 = new javax.swing.JLabel();
        Contagem_atual_3 = new javax.swing.JLabel();
        Contagem_atual_4 = new javax.swing.JLabel();
        Contagem_atual_5 = new javax.swing.JLabel();
        Contagem_atual_6 = new javax.swing.JLabel();
        Contagem_atual_7 = new javax.swing.JLabel();
        Contagem_atual_8 = new javax.swing.JLabel();
        Contagem_atual_9 = new javax.swing.JLabel();
        Contagem_atual_10 = new javax.swing.JLabel();
        Timer_1 = new javax.swing.JLabel();
        Timer_2 = new javax.swing.JLabel();
        Timer_3 = new javax.swing.JLabel();
        Timer_4 = new javax.swing.JLabel();
        Timer_5 = new javax.swing.JLabel();
        Timer_6 = new javax.swing.JLabel();
        Timer_7 = new javax.swing.JLabel();
        Timer_8 = new javax.swing.JLabel();
        Timer_9 = new javax.swing.JLabel();
        Timer_10 = new javax.swing.JLabel();
        Contador_1 = new javax.swing.JLabel();
        Contador_2 = new javax.swing.JLabel();
        Contador_3 = new javax.swing.JLabel();
        Contador_4 = new javax.swing.JLabel();
        Contador_5 = new javax.swing.JLabel();
        Contador_6 = new javax.swing.JLabel();
        Contador_7 = new javax.swing.JLabel();
        Contador_8 = new javax.swing.JLabel();
        Contador_9 = new javax.swing.JLabel();
        Contador_10 = new javax.swing.JLabel();
        label_1 = new javax.swing.JLabel();
        label_2 = new javax.swing.JLabel();
        label_3 = new javax.swing.JLabel();
        label_4 = new javax.swing.JLabel();
        label_5 = new javax.swing.JLabel();
        label_6 = new javax.swing.JLabel();
        label_7 = new javax.swing.JLabel();
        label_8 = new javax.swing.JLabel();
        label_9 = new javax.swing.JLabel();
        label_10 = new javax.swing.JLabel();
        label_11 = new javax.swing.JLabel();
        label_12 = new javax.swing.JLabel();
        label_13 = new javax.swing.JLabel();
        label_14 = new javax.swing.JLabel();
        label_15 = new javax.swing.JLabel();
        label_16 = new javax.swing.JLabel();
        label_17 = new javax.swing.JLabel();
        label_18 = new javax.swing.JLabel();
        label_19 = new javax.swing.JLabel();
        label_20 = new javax.swing.JLabel();
        Color_Camp = new javax.swing.JPanel();
        Codigo_Camp = new javax.swing.JTextArea();
        Image_Camp = new javax.swing.JLabel();
        simulador_portao_BT = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lista de Instruçoes CLP");
        setBackground(new java.awt.Color(255, 255, 255));

        Simulacoes.setBackground(new java.awt.Color(8, 94, 131));
        Simulacoes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Painel", "Simulação 1", "Simulação 2", "Simulação 3" }));
        Simulacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SimulacoesActionPerformed(evt);
            }
        });

        Run_BT.setFont(new java.awt.Font("Segoe UI", 0, 5)); // NOI18N
        Run_BT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/start.png"))); // NOI18N
        Run_BT.setToolTipText("");
        Run_BT.setAlignmentY(0.0F);
        Run_BT.setAutoscrolls(true);
        Run_BT.setBorder(null);
        Run_BT.setIconTextGap(0);
        Run_BT.setMaximumSize(new java.awt.Dimension(50, 50));
        Run_BT.setMinimumSize(new java.awt.Dimension(50, 50));
        Run_BT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Run_BTBT_Run_Pressionado(evt);
            }
        });

        Arquivar_BT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Arquivar", "Salvar", "Carregar" }));
        Arquivar_BT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Arquivar_BTActionPerformed(evt);
            }
        });

        Editar_BT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Editar", "Tema", "Idioma" }));
        Editar_BT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Editar_BTActionPerformed(evt);
            }
        });

        Help_BT.setText("Help");

        Sobre_BT.setText("Sobre");
        Sobre_BT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Sobre_BTActionPerformed(evt);
            }
        });

        Pause_BT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/pause.png"))); // NOI18N
        Pause_BT.setOpaque(true);
        Pause_BT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Pause_BTActionPerformed(evt);
            }
        });

        Variaveis_BT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Barra_Lateral.png"))); // NOI18N
        Variaveis_BT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Variaveis_BTA(evt);
            }
        });

        jSpinner1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        Label_Delay.setText("Tempo de Delay em ms:");

        jPanel2.setBackground(new java.awt.Color(8, 94, 131));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Temp_parada_1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(Temp_parada_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 50, 20));

        Temp_parada_2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(Temp_parada_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 50, 20));

        Temp_parada_3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(Temp_parada_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 50, 20));

        Temp_parada_4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(Temp_parada_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, 50, 20));

        Temp_parada_5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(Temp_parada_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 310, 50, 20));

        Temp_parada_6.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(Temp_parada_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, 50, 20));

        Temp_parada_7.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(Temp_parada_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, 50, 20));

        Temp_parada_8.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(Temp_parada_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, 50, 20));

        Temp_parada_9.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(Temp_parada_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 240, 50, 20));

        Temp_parada_10.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(Temp_parada_10, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 310, 50, 20));

        Contagem_parada_1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(Contagem_parada_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 50, 20));

        Contagem_parada_2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(Contagem_parada_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 50, 20));

        Contagem_parada_3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(Contagem_parada_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, 50, 20));

        Contagem_parada_4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(Contagem_parada_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, 50, 20));

        Contagem_parada_5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(Contagem_parada_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 310, 50, 20));

        Contagem_parada_6.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(Contagem_parada_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 30, 50, 20));

        Contagem_parada_7.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(Contagem_parada_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 100, 50, 20));

        Contagem_parada_8.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(Contagem_parada_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 170, 50, 20));

        Contagem_parada_9.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(Contagem_parada_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 240, 50, 20));

        Contagem_parada_10.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(Contagem_parada_10, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 310, 50, 20));

        Temp_atual_1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(Temp_atual_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 50, 20));

        Temp_atual_2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(Temp_atual_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 50, 20));

        Temp_atual_3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(Temp_atual_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 50, 20));

        Temp_atual_4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(Temp_atual_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 50, 20));

        Temp_atual_5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(Temp_atual_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, 50, 20));

        Temp_atual_6.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(Temp_atual_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 50, 20));

        Temp_atual_7.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(Temp_atual_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 80, 50, 20));

        Temp_atual_8.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(Temp_atual_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 150, 50, 20));

        Temp_atual_9.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(Temp_atual_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 220, 50, 20));

        Temp_atual_10.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(Temp_atual_10, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 290, 50, 20));

        Contagem_atual_1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(Contagem_atual_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 50, 20));

        Contagem_atual_2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(Contagem_atual_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 50, 20));

        Contagem_atual_3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(Contagem_atual_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, 50, 20));

        Contagem_atual_4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(Contagem_atual_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, 50, 20));

        Contagem_atual_5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(Contagem_atual_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 290, 50, 20));

        Contagem_atual_6.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(Contagem_atual_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, 50, 20));

        Contagem_atual_7.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(Contagem_atual_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 80, 50, 20));

        Contagem_atual_8.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(Contagem_atual_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 150, 50, 20));

        Contagem_atual_9.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(Contagem_atual_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 220, 50, 20));

        Contagem_atual_10.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(Contagem_atual_10, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 290, 50, 20));

        Timer_1.setText("jLabel1");
        jPanel2.add(Timer_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 130, 60));

        Timer_2.setText("jLabel1");
        jPanel2.add(Timer_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 130, 60));

        Timer_3.setText("jLabel1");
        jPanel2.add(Timer_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 130, 60));

        Timer_4.setText("jLabel1");
        jPanel2.add(Timer_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 130, 60));

        Timer_5.setText("jLabel1");
        jPanel2.add(Timer_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 130, 60));

        Timer_6.setText("jLabel1");
        jPanel2.add(Timer_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 290, 130, 60));

        Timer_7.setText("jLabel1");
        jPanel2.add(Timer_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 220, 130, 60));

        Timer_8.setText("jLabel1");
        jPanel2.add(Timer_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 150, 130, 60));

        Timer_9.setText("jLabel1");
        jPanel2.add(Timer_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, 130, 60));

        Timer_10.setText("jLabel1");
        jPanel2.add(Timer_10, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 130, 60));

        Contador_1.setText("jLabel1");
        jPanel2.add(Contador_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 130, 60));

        Contador_2.setText("jLabel1");
        jPanel2.add(Contador_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 130, 60));

        Contador_3.setText("jLabel1");
        jPanel2.add(Contador_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 130, 60));

        Contador_4.setText("jLabel1");
        jPanel2.add(Contador_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, 130, 60));

        Contador_5.setText("jLabel1");
        jPanel2.add(Contador_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, 130, 60));

        Contador_6.setText("jLabel1");
        jPanel2.add(Contador_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 290, 130, 60));

        Contador_7.setText("jLabel1");
        jPanel2.add(Contador_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 220, 130, 60));

        Contador_8.setText("jLabel1");
        jPanel2.add(Contador_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 150, 130, 60));

        Contador_9.setText("jLabel1");
        jPanel2.add(Contador_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, 130, 60));

        Contador_10.setText("jLabel1");
        jPanel2.add(Contador_10, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 130, 60));

        label_1.setForeground(new java.awt.Color(255, 255, 255));
        label_1.setText(" 1");
        jPanel2.add(label_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 30, 30));

        label_2.setForeground(new java.awt.Color(255, 255, 255));
        label_2.setText(" 2");
        jPanel2.add(label_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 30, 30));

        label_3.setForeground(new java.awt.Color(255, 255, 255));
        label_3.setText(" 3");
        jPanel2.add(label_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 30, 30));

        label_4.setForeground(new java.awt.Color(255, 255, 255));
        label_4.setText(" 4");
        jPanel2.add(label_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 30, 30));

        label_5.setForeground(new java.awt.Color(255, 255, 255));
        label_5.setText(" 5");
        jPanel2.add(label_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, 30, 30));

        label_6.setForeground(new java.awt.Color(255, 255, 255));
        label_6.setText(" 6");
        jPanel2.add(label_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, 30, 30));

        label_7.setForeground(new java.awt.Color(255, 255, 255));
        label_7.setText(" 7");
        jPanel2.add(label_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 110, 30, 30));

        label_8.setForeground(new java.awt.Color(255, 255, 255));
        label_8.setText(" 8");
        jPanel2.add(label_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 180, 30, 30));

        label_9.setForeground(new java.awt.Color(255, 255, 255));
        label_9.setText(" 9");
        jPanel2.add(label_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 250, 30, 30));

        label_10.setForeground(new java.awt.Color(255, 255, 255));
        label_10.setText("10");
        jPanel2.add(label_10, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 320, 30, 30));

        label_11.setForeground(new java.awt.Color(255, 255, 255));
        label_11.setText(" 1");
        jPanel2.add(label_11, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 30, 30));

        label_12.setForeground(new java.awt.Color(255, 255, 255));
        label_12.setText(" 2");
        jPanel2.add(label_12, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, 30, 30));

        label_13.setForeground(new java.awt.Color(255, 255, 255));
        label_13.setText(" 3");
        jPanel2.add(label_13, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 180, 30, 30));

        label_14.setForeground(new java.awt.Color(255, 255, 255));
        label_14.setText(" 4");
        jPanel2.add(label_14, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 250, 30, 30));

        label_15.setForeground(new java.awt.Color(255, 255, 255));
        label_15.setText(" 5");
        jPanel2.add(label_15, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 320, 30, 30));

        label_16.setForeground(new java.awt.Color(255, 255, 255));
        label_16.setText(" 6");
        jPanel2.add(label_16, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 40, 30, 30));

        label_17.setForeground(new java.awt.Color(255, 255, 255));
        label_17.setText(" 7");
        jPanel2.add(label_17, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 110, 30, 30));

        label_18.setForeground(new java.awt.Color(255, 255, 255));
        label_18.setText(" 8");
        jPanel2.add(label_18, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 180, 30, 30));

        label_19.setForeground(new java.awt.Color(255, 255, 255));
        label_19.setText(" 9");
        jPanel2.add(label_19, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 250, 30, 30));

        label_20.setForeground(new java.awt.Color(255, 255, 255));
        label_20.setText("10");
        jPanel2.add(label_20, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 320, 30, 30));

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
        Color_Camp.add(Codigo_Camp, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 350, 750));
        Color_Camp.add(Image_Camp, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, 6, 370, 750));

        simulador_portao_BT.setText("Simulador De Portão");
        simulador_portao_BT.setActionCommand("");
        simulador_portao_BT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tela_Portao(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(142, 177, 199));

        Saida_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/led_desligado.png"))); // NOI18N

        Saida_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/led_desligado.png"))); // NOI18N

        Saida_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/led_desligado.png"))); // NOI18N

        Saida_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/led_desligado.png"))); // NOI18N

        Saida_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/led_desligado.png"))); // NOI18N

        Saida_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/led_desligado.png"))); // NOI18N

        Saida_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/led_desligado.png"))); // NOI18N

        Saida_8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/led_desligado.png"))); // NOI18N

        Label_Entradas.setFont(new java.awt.Font("Segoe UI Black", 2, 24)); // NOI18N
        Label_Entradas.setText("Entradas");
        Label_Entradas.setFocusable(false);
        Label_Entradas.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        Label_Saidas.setFont(new java.awt.Font("Segoe UI Black", 2, 24)); // NOI18N
        Label_Saidas.setText("Saidas");
        Label_Saidas.setToolTipText("");
        Label_Saidas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Entrada_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/chave_aberta.png"))); // NOI18N
        Entrada_5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Entrada_5MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                Entrada_5MouseReleased(evt);
            }
        });

        Entrada_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/chave_aberta.png"))); // NOI18N
        Entrada_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Entrada_1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                Entrada_1MouseReleased(evt);
            }
        });

        Entrada_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/chave_aberta.png"))); // NOI18N
        Entrada_6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Entrada_6MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                Entrada_6MouseReleased(evt);
            }
        });

        Entrada_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/chave_aberta.png"))); // NOI18N
        Entrada_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Entrada_2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                Entrada_2MouseReleased(evt);
            }
        });

        Entrada_8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/chave_aberta.png"))); // NOI18N
        Entrada_8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Entrada_8MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                Entrada_8MouseReleased(evt);
            }
        });

        Entrada_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/chave_aberta.png"))); // NOI18N
        Entrada_4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Entrada_4MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                Entrada_4MouseReleased(evt);
            }
        });

        Entrada_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/chave_aberta.png"))); // NOI18N
        Entrada_7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Entrada_7MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                Entrada_7MouseReleased(evt);
            }
        });

        Entrada_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/chave_aberta.png"))); // NOI18N
        Entrada_3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Entrada_3MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                Entrada_3MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                .addComponent(Entrada_8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(Label_Entradas, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 157, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(Label_Saidas, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label_Entradas, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label_Saidas))
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
                .addContainerGap(80, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 425, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(Color_Camp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Arquivar_BT, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Editar_BT, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Help_BT)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Sobre_BT)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(simulador_portao_BT)
                                .addGap(21, 21, 21))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Simulacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(Run_BT, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Pause_BT, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Label_Delay))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 420, Short.MAX_VALUE)
                        .addComponent(Variaveis_BT, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Sobre_BT)
                            .addComponent(Help_BT)
                            .addComponent(Editar_BT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Arquivar_BT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(simulador_portao_BT))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Simulacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Run_BT, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Pause_BT, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Label_Delay)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(Variaveis_BT, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(Color_Camp, javax.swing.GroupLayout.PREFERRED_SIZE, 764, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SimulacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SimulacoesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SimulacoesActionPerformed
    private void Run_BTBT_Run_Pressionado(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Run_BTBT_Run_Pressionado
        if(mode != 3){
            System.out.println("\nBotão run clicado!");
            mode = 3;
            // Verificando tempo de delay
            String stringTime = jSpinner1.getValue().toString();
            Integer time = 0;

            if (!stringTime.equals("")) {
                try {
                    time = Integer.valueOf(stringTime);
                } catch (NumberFormatException e) {
                    mode = 1;
                    updateMode();
                    showErrorMessage("Tempo de delay inválido! Insira um número inteiro.");
                }

                System.out.println("Tempo de delay: " + time + "\n");
            }

            // Executa o laço corretamente sem travar a tela 
            @SuppressWarnings("unchecked")
            Timer timer = new Timer(time, (ActionEvent evt1) -> {
                // Salva linhas da área de texto
                List<String> lineList = new ArrayList<>();
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
                    ((Timer) evt1.getSource()).stop();
                }
            });

            timer.setInitialDelay(0); // começa sem atraso
            timer.start();
        }else{
            System.out.println("\nBotão stop clicado!");
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
    private void Variaveis_BTA(java.awt.event.ActionEvent evt){
        tela2.setVisible(true);
        tela2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tela2.setLocation(700,100);
    }    
    private void Pause_BTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Pause_BTActionPerformed
        System.out.println("\nBotão program clicado!");
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

    private void Entrada_1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Entrada_1MousePressed
        if(evt.getButton() == 1){
            if(inputsType.get("I1") == 0)
                inputs.put("I1", !inputs.get("I1"));
            if(inputsType.get("I1") == 1)
                inputs.put("I1", true);
            if(inputsType.get("I1") == 2)
                inputs.put("I1", false);
            updateScreen();
        }else if(evt.getButton() == 3){
            int val = inputsType.get("I1");
            val++;
            if(val>=3){
                val = 0;
            }
            inputsType.put("I1", val);
            if(val == 0 || val == 1){
                inputs.put("I1", false);
            }else{
                inputs.put("I1", true);
            }
            updateScreen();
        }
    }//GEN-LAST:event_Entrada_1MousePressed

    private void Entrada_2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Entrada_2MousePressed
        if(evt.getButton() == 1){
            if(inputsType.get("I2") == 0)
                inputs.put("I2", !inputs.get("I2"));
            if(inputsType.get("I2") == 1)
                inputs.put("I2", true);
            if(inputsType.get("I2") == 2)
                inputs.put("I2", false);
            updateScreen();
        }else if(evt.getButton() == 3){
            int val = inputsType.get("I2");
            val++;
            if(val>=3){
                val = 0;
            }
            inputsType.put("I2", val);
            if(val == 0 || val == 1){
                inputs.put("I2", false);
            }else{
                inputs.put("I2", true);
            }
            updateScreen();
        }
    }//GEN-LAST:event_Entrada_2MousePressed

    private void Entrada_3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Entrada_3MousePressed
        if(evt.getButton() == 1){
            if(inputsType.get("I3") == 0)
                inputs.put("I3", !inputs.get("I3"));
            if(inputsType.get("I3") == 1)
                inputs.put("I3", true);
            if(inputsType.get("I3") == 2)
                inputs.put("I3", false);
            updateScreen();
        }else if(evt.getButton() == 3){
            int val = inputsType.get("I3");
            val++;
            if(val>=3){
                val = 0;
            }
            inputsType.put("I3", val);
            if(val == 0 || val == 1){
                inputs.put("I3", false);
            }else{
                inputs.put("I3", true);
            }
            updateScreen();
        }
    }//GEN-LAST:event_Entrada_3MousePressed

    private void Entrada_4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Entrada_4MousePressed
        if(evt.getButton() == 1){
            if(inputsType.get("I4") == 0)
                inputs.put("I4", !inputs.get("I4"));
            if(inputsType.get("I4") == 1)
                inputs.put("I4", true);
            if(inputsType.get("I4") == 2)
                inputs.put("I4", false);
            updateScreen();
        }else if(evt.getButton() == 3){
            int val = inputsType.get("I4");
            val++;
            if(val>=3){
                val = 0;
            }
            inputsType.put("I4", val);
            if(val == 0 || val == 1){
                inputs.put("I4", false);
            }else{
                inputs.put("I4", true);
            }
            updateScreen();
        }
    }//GEN-LAST:event_Entrada_4MousePressed

    private void Entrada_5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Entrada_5MousePressed
        if(evt.getButton() == 1){
            if(inputsType.get("I5") == 0)
                inputs.put("I5", !inputs.get("I5"));
            if(inputsType.get("I5") == 1)
                inputs.put("I5", true);
            if(inputsType.get("I5") == 2)
                inputs.put("I5", false);
            updateScreen();
        }else if(evt.getButton() == 3){
            int val = inputsType.get("I5");
            val++;
            if(val>=3){
                val = 0;
            }
            inputsType.put("I5", val);
            if(val == 0 || val == 1){
                inputs.put("I5", false);
            }else{
                inputs.put("I5", true);
            }
            updateScreen();
        } 
    }//GEN-LAST:event_Entrada_5MousePressed

    private void Entrada_6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Entrada_6MousePressed
        if(evt.getButton() == 1){
            if(inputsType.get("I6") == 0)
                inputs.put("I6", !inputs.get("I6"));
            if(inputsType.get("I6") == 1)
                inputs.put("I6", true);
            if(inputsType.get("I6") == 2)
                inputs.put("I6", false);
            updateScreen();
        }else if(evt.getButton() == 3){
            int val = inputsType.get("I6");
            val++;
            if(val>=3){
                val = 0;
            }
            inputsType.put("I6", val);
            if(val == 0 || val == 1){
                inputs.put("I6", false);
            }else{
                inputs.put("I6", true);
            }
            updateScreen();
        }
    }//GEN-LAST:event_Entrada_6MousePressed

    private void Entrada_7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Entrada_7MousePressed
        if(evt.getButton() == 1){
            if(inputsType.get("I7") == 0)
                inputs.put("I7", !inputs.get("I7"));
            if(inputsType.get("I7") == 1)
                inputs.put("I7", true);
            if(inputsType.get("I7") == 2)
                inputs.put("I7", false);
            updateScreen();
        }else if(evt.getButton() == 3){
            int val = inputsType.get("I7");
            val++;
            if(val>=3){
                val = 0;
            }
            inputsType.put("I7", val);
            if(val == 0 || val == 1){
                inputs.put("I7", false);
            }else{
                inputs.put("I7", true);
            }
            updateScreen();
        }
    }//GEN-LAST:event_Entrada_7MousePressed

    private void Entrada_8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Entrada_8MousePressed
        if(evt.getButton() == 1){
            if(inputsType.get("I8") == 0)
                inputs.put("I8", !inputs.get("I8"));
            if(inputsType.get("I8") == 1)
                inputs.put("I8", true);
            if(inputsType.get("I8") == 2)
                inputs.put("I8", false);
            updateScreen();
        }else if(evt.getButton() == 3){
            int val = inputsType.get("I8");
            val++;
            if(val>=3){
                val = 0;
            }
            inputsType.put("I8", val);
            if(val == 0 || val == 1){
                inputs.put("I8", false);
            }else{
                inputs.put("I8", true);
            }
            updateScreen();
        }
    }//GEN-LAST:event_Entrada_8MousePressed

    private void Editar_BTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Editar_BTActionPerformed
 if(Editar_BT.getItemAt(1) == Editar_BT.getSelectedItem().toString()){
            Editar_BT.setSelectedIndex(0);
            color++;
            if(color >= 5){
                color = 1;
            }
            setaCores();
        }
        if(Editar_BT.getItemAt(2) == Editar_BT.getSelectedItem().toString()){
            Editar_BT.setSelectedIndex(0);
            Language.setLingua();
            setaLanguage();
        }
        
    }//GEN-LAST:event_Editar_BTActionPerformed

    private void Entrada_1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Entrada_1MouseReleased
        if(evt.getButton() == 1){
            if(inputsType.get("I1") == 1)
                inputs.put("I1", false);
            if(inputsType.get("I1") == 2)
                inputs.put("I1", true);
            updateScreen();
        }
    }//GEN-LAST:event_Entrada_1MouseReleased

    private void Entrada_2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Entrada_2MouseReleased
       if(evt.getButton() == 1){
            if(inputsType.get("I2") == 1)
                inputs.put("I2", false);
            if(inputsType.get("I2") == 2)
                inputs.put("I2", true);
            updateScreen();
        }
    }//GEN-LAST:event_Entrada_2MouseReleased

    private void Entrada_3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Entrada_3MouseReleased
        if(evt.getButton() == 1){
            if(inputsType.get("I3") == 1)
                inputs.put("I3", false);
            if(inputsType.get("I3") == 2)
                inputs.put("I3", true);
            updateScreen();
        }
    }//GEN-LAST:event_Entrada_3MouseReleased

    private void Entrada_4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Entrada_4MouseReleased
        if(evt.getButton() == 1){
            if(inputsType.get("I4") == 1)
                inputs.put("I4", false);
            if(inputsType.get("I4") == 2)
                inputs.put("I4", true);
            updateScreen();
        }
    }//GEN-LAST:event_Entrada_4MouseReleased

    private void Entrada_5MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Entrada_5MouseReleased
        if(evt.getButton() == 1){
            if(inputsType.get("I5") == 1)
                inputs.put("I5", false);
            if(inputsType.get("I5") == 2)
                inputs.put("I5", true);
            updateScreen();
        }
    }//GEN-LAST:event_Entrada_5MouseReleased

    private void Entrada_6MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Entrada_6MouseReleased
        if(evt.getButton() == 1){
            if(inputsType.get("I6") == 1)
                inputs.put("I6", false);
            if(inputsType.get("I6") == 2)
                inputs.put("I6", true);
            updateScreen();
        }
    }//GEN-LAST:event_Entrada_6MouseReleased

    private void Entrada_7MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Entrada_7MouseReleased
        if(evt.getButton() == 1){
            if(inputsType.get("I7") == 1)
                inputs.put("I7", false);
            if(inputsType.get("I7") == 2)
                inputs.put("I7", true);
            updateScreen();
        }
    }//GEN-LAST:event_Entrada_7MouseReleased

    private void Entrada_8MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Entrada_8MouseReleased
        if(evt.getButton() == 1){
            if(inputsType.get("I8") == 1)
                inputs.put("I8", false);
            if(inputsType.get("I8") == 2)
                inputs.put("I8", true);
            updateScreen();
        }
    }//GEN-LAST:event_Entrada_8MouseReleased

    private void Arquivar_BTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Arquivar_BTActionPerformed
        if (updating) return;
        
            if(Language.getArquivar().getItemAt(2) == (Arquivar_BT.getSelectedItem().toString())){
                JFileChooser c = new JFileChooser();
                String filename = "";
                String dir = "";
                // Demonstrate "Open" dialog:
                int rVal = c.showOpenDialog(Home_Pg.this);
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
                    Logger.getLogger(Home_Pg.class.getName()).log(Level.SEVERE, null, ex);
                }
                Arquivar_BT.setSelectedIndex(0);
            }

            if(Arquivar_BT.getItemAt(1)==(Arquivar_BT.getSelectedItem()) ){

                Arquivar_BT.setSelectedIndex(0);

                JFileChooser c = new JFileChooser();
                String filename = "";
                String dir = "";
                // Demonstrate "Save" dialog:
                int rVal = c.showSaveDialog(Home_Pg.this);
                if (rVal == JFileChooser.APPROVE_OPTION) {
                  filename = (c.getSelectedFile().getName());
                  dir = (c.getCurrentDirectory().toString());
                }

                List<String> memory = new ArrayList<>();
                memory = saveLines(memory);
                try {
                    Save.save(dir+"\\"+filename, memory);
                } catch (IOException ex) {
                    Logger.getLogger(Home_Pg.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        
        
    }//GEN-LAST:event_Arquivar_BTActionPerformed

    private void Tela_Portao(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tela_Portao
        // Minimiza e desativa a HomePage
        this.setState(JFrame.ICONIFIED);
        this.setEnabled(false);
        getGlassPane().setVisible(true); // ← ativa o interceptador

        // Cria e exibe o simulador de portão
        Simulador_De_Portao telaPortao = new Simulador_De_Portao();
        telaPortao.setLocationRelativeTo(null);
        telaPortao.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Reativa a HomePage quando o portão for fechado
        telaPortao.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                setEnabled(true);
                setState(JFrame.NORMAL);
                getGlassPane().setVisible(false);
                toFront(); // traz a janela pra frente
            }
        });

        telaPortao.setVisible(true);
    }//GEN-LAST:event_Tela_Portao
    
    private void setaCores(){
        Simulacoes.setBackground(Colors.firstColor(color));
        jPanel2.setBackground(Colors.firstColor(color));
        jPanel1.setBackground(Colors.secondColor(color));
        Color_Camp.setBackground(Colors.thirdColor(color));
    }
    
    private void setaLanguage(){
        @SuppressWarnings("rawtypes")
        JComboBox aux = Language.getArquivar();
        updating = true;
        Arquivar_BT.removeItemAt(0);
        Arquivar_BT.removeItemAt(0);
        Arquivar_BT.removeItemAt(0);
        Arquivar_BT.insertItemAt(aux.getItemAt(0).toString(), 0);
        Arquivar_BT.insertItemAt(aux.getItemAt(1).toString(), 1);
        Arquivar_BT.insertItemAt(aux.getItemAt(2).toString(), 2);
        Arquivar_BT.setSelectedIndex(0);
        updating = false;
        
        aux = Language.getEditar();
        Editar_BT.removeItemAt(0);
        Editar_BT.removeItemAt(0);
        Editar_BT.removeItemAt(0);
        Editar_BT.insertItemAt(aux.getItemAt(0).toString(), 0);
        Editar_BT.insertItemAt(aux.getItemAt(1).toString(), 1);
        Editar_BT.insertItemAt(aux.getItemAt(2).toString(), 2);
        Editar_BT.setSelectedIndex(0);
        
        aux = Language.getSimulação();
        Simulacoes.removeItemAt(0);
        Simulacoes.removeItemAt(0);
        Simulacoes.removeItemAt(0);
        Simulacoes.removeItemAt(0);
        Simulacoes.insertItemAt(aux.getItemAt(0).toString(), 0);
        Simulacoes.insertItemAt(aux.getItemAt(1).toString(), 1);
        Simulacoes.insertItemAt(aux.getItemAt(2).toString(), 2);
        Simulacoes.insertItemAt(aux.getItemAt(3).toString(), 3);
        Simulacoes.setSelectedIndex(0);
        
        Help_BT.setText(Language.getAjudar());
        Sobre_BT.setText(Language.getSobre());
        Label_Entradas.setText(Language.getEntradas());
        Label_Saidas.setText(Language.getSaidas());
        Label_Delay.setText(Language.getDelay());
    }
    
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home_Pg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Home_Pg().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Arquivar_BT;
    private javax.swing.JTextArea Codigo_Camp;
    private javax.swing.JPanel Color_Camp;
    private javax.swing.JLabel Contador_1;
    private javax.swing.JLabel Contador_10;
    private javax.swing.JLabel Contador_2;
    private javax.swing.JLabel Contador_3;
    private javax.swing.JLabel Contador_4;
    private javax.swing.JLabel Contador_5;
    private javax.swing.JLabel Contador_6;
    private javax.swing.JLabel Contador_7;
    private javax.swing.JLabel Contador_8;
    private javax.swing.JLabel Contador_9;
    private javax.swing.JLabel Contagem_atual_1;
    private javax.swing.JLabel Contagem_atual_10;
    private javax.swing.JLabel Contagem_atual_2;
    private javax.swing.JLabel Contagem_atual_3;
    private javax.swing.JLabel Contagem_atual_4;
    private javax.swing.JLabel Contagem_atual_5;
    private javax.swing.JLabel Contagem_atual_6;
    private javax.swing.JLabel Contagem_atual_7;
    private javax.swing.JLabel Contagem_atual_8;
    private javax.swing.JLabel Contagem_atual_9;
    private javax.swing.JLabel Contagem_parada_1;
    private javax.swing.JLabel Contagem_parada_10;
    private javax.swing.JLabel Contagem_parada_2;
    private javax.swing.JLabel Contagem_parada_3;
    private javax.swing.JLabel Contagem_parada_4;
    private javax.swing.JLabel Contagem_parada_5;
    private javax.swing.JLabel Contagem_parada_6;
    private javax.swing.JLabel Contagem_parada_7;
    private javax.swing.JLabel Contagem_parada_8;
    private javax.swing.JLabel Contagem_parada_9;
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
    private javax.swing.JLabel Image_Camp;
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
    private javax.swing.JLabel Temp_atual_1;
    private javax.swing.JLabel Temp_atual_10;
    private javax.swing.JLabel Temp_atual_2;
    private javax.swing.JLabel Temp_atual_3;
    private javax.swing.JLabel Temp_atual_4;
    private javax.swing.JLabel Temp_atual_5;
    private javax.swing.JLabel Temp_atual_6;
    private javax.swing.JLabel Temp_atual_7;
    private javax.swing.JLabel Temp_atual_8;
    private javax.swing.JLabel Temp_atual_9;
    private javax.swing.JLabel Temp_parada_1;
    private javax.swing.JLabel Temp_parada_10;
    private javax.swing.JLabel Temp_parada_2;
    private javax.swing.JLabel Temp_parada_3;
    private javax.swing.JLabel Temp_parada_4;
    private javax.swing.JLabel Temp_parada_5;
    private javax.swing.JLabel Temp_parada_6;
    private javax.swing.JLabel Temp_parada_7;
    private javax.swing.JLabel Temp_parada_8;
    private javax.swing.JLabel Temp_parada_9;
    private javax.swing.JLabel Timer_1;
    private javax.swing.JLabel Timer_10;
    private javax.swing.JLabel Timer_2;
    private javax.swing.JLabel Timer_3;
    private javax.swing.JLabel Timer_4;
    private javax.swing.JLabel Timer_5;
    private javax.swing.JLabel Timer_6;
    private javax.swing.JLabel Timer_7;
    private javax.swing.JLabel Timer_8;
    private javax.swing.JLabel Timer_9;
    private javax.swing.JButton Variaveis_BT;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JLabel label_1;
    private javax.swing.JLabel label_10;
    private javax.swing.JLabel label_11;
    private javax.swing.JLabel label_12;
    private javax.swing.JLabel label_13;
    private javax.swing.JLabel label_14;
    private javax.swing.JLabel label_15;
    private javax.swing.JLabel label_16;
    private javax.swing.JLabel label_17;
    private javax.swing.JLabel label_18;
    private javax.swing.JLabel label_19;
    private javax.swing.JLabel label_2;
    private javax.swing.JLabel label_20;
    private javax.swing.JLabel label_3;
    private javax.swing.JLabel label_4;
    private javax.swing.JLabel label_5;
    private javax.swing.JLabel label_6;
    private javax.swing.JLabel label_7;
    private javax.swing.JLabel label_8;
    private javax.swing.JLabel label_9;
    private javax.swing.JButton simulador_portao_BT;
    // End of variables declaration//GEN-END:variables
}
