package compiladorinstructionlist.edit;

import javax.swing.JComboBox;

public class Language {
    
    private static String lingua = "PT-BR";
    
    public static void setLingua(String lingua){
        Language.lingua = lingua;
    }
    
    public static JComboBox getArquivar(){
        JComboBox<String> jComboBox = new JComboBox();
        if(lingua.equals("EN")){
            jComboBox.addItem("File");
        }else if(lingua.equals("JA")){
            jComboBox.addItem("ファイル");
        }else if(lingua.equals("DE")){
            jComboBox.addItem("Datei");
        }else{
            jComboBox.addItem("Arquivo");
        }
        return jComboBox;
    }
    
    public static JComboBox getEditar(){
        JComboBox<String> jComboBox = new JComboBox();
        if(lingua.equals("EN")){
            jComboBox.addItem("Edit");
        }else if(lingua.equals("JA")){
            jComboBox.addItem("編集");
        }else if(lingua.equals("DE")){
            jComboBox.addItem("Bearbeiten");
        }else{
            jComboBox.addItem("Editar");
        }
        return jComboBox;
    }
    
    public static JComboBox getAjudar(){
        JComboBox<String> jComboBox = new JComboBox();
        if(lingua.equals("EN")){
            jComboBox.addItem("Help");
        }else if(lingua.equals("JA")){
            jComboBox.addItem("ヘルプ");
        }else if(lingua.equals("DE")){
            jComboBox.addItem("Helfen");
        }else{
            jComboBox.addItem("Ajuda");
        }
        return jComboBox;
    }
    
    public static JComboBox getSobre(){
        JComboBox<String> jComboBox = new JComboBox();
        if(lingua.equals("EN")){
            jComboBox.addItem("About");
        }else if(lingua.equals("JA")){
            jComboBox.addItem("について");
        }else if(lingua.equals("DE")){
            jComboBox.addItem("Um");
        }else{
            jComboBox.addItem("Sobre");
        }
        return jComboBox;
    }
    
    public static JComboBox getSimulação(){
        JComboBox<String> jComboBox = new JComboBox();
        if(lingua.equals("EN")){
            jComboBox.addItem("simulation");
        }else if(lingua.equals("JA")){
            jComboBox.addItem("シミュレーション");
        }else if(lingua.equals("DE")){
            jComboBox.addItem("Simulation");
        }else{
            jComboBox.addItem("Simulação");
        }
        return jComboBox;
    }
    
    public static String getDelay(){
        if(lingua.equals("EN")){
            return "Time delay (ms):";
        }else if(lingua.equals("JA")){
            return "遅延時間 (ミリ秒):";
        }else if(lingua.equals("DE")){
            return "Zeitverzögerung (ms):";
        }
        return "Tempo de delay (ms):";
    }
    
    public static String getEntradas(){
        if(lingua.equals("EN")){
            return "Inputs";
        }else if(lingua.equals("JA")){
            return "入力";
        }else if(lingua.equals("DE")){
            return "Eingaben";
        }
        return "Entradas";
    }
    
    public static String getSaidas(){
        if(lingua.equals("EN")){
            return "Outputs";
        }else if(lingua.equals("JA")){
            return "出力";
        }else if(lingua.equals("DE")){
            return "Ausgänge";
        }
        return "Saídas";
    }
    
    public static String getCodigo(){
        if(lingua.equals("EN")){
            return "Code";
        }else if(lingua.equals("JA")){
            return "コード";
        }else if(lingua.equals("DE")){
            return "Code";
        }
        return "Código";
    }
    
    public static String getValor(){
        if(lingua.equals("EN")){
            return "Value:";
        }else if(lingua.equals("JA")){
            return "価値:";
        }else if(lingua.equals("DE")){
            return "Wert:";
        }
        return "Valor:";
    }
    
    public static String getType(){
        if(lingua.equals("EN")){
            return "Type:";
        }else if(lingua.equals("JA")){
            return "タイプ:";
        }else if(lingua.equals("DE")){
            return "Typ:";
        }
        return "Tipo";
    }

    public static String getPreset(){
        if(lingua.equals("EN")){
            return "Preset:";
        }else if(lingua.equals("JA")){
            return "プリセット:";
        }else if(lingua.equals("DE")){
            return "Voreingestellt:";
        }
        return "Predefinição:";
    }
}
