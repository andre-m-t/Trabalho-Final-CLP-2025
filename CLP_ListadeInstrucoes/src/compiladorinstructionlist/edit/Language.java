package compiladorinstructionlist.edit;

import javax.swing.JComboBox;

public class Language {
    
    private static String lingua = "PT-BR";
    
    public static void setLingua(){
        if(null == lingua){
            lingua = "PT-BR";
        }else lingua = switch (lingua) {
            case "PT-BR" -> "EN";
            case "EN" -> "JA";
            case "JA" -> "DE";
            case "DE" -> "PT-BR";
            default -> "PT-BR";
        };
    }
    
    public static String getLingua(){
        return lingua;
    }
    
    public static JComboBox getArquivar(){
        JComboBox<String> jComboBox = new JComboBox();
        if(lingua.equals("EN")){
            jComboBox.addItem("File");
            jComboBox.addItem("Salvar");
            jComboBox.addItem("Item 3");
            jComboBox.addItem("Item 4");
        }else if(lingua.equals("JA")){
            jComboBox.addItem("ファイル");
            jComboBox.addItem("Salvar");
            jComboBox.addItem("Item 3");
            jComboBox.addItem("Item 4");
        }else if(lingua.equals("DE")){
            jComboBox.addItem("Datei");
            jComboBox.addItem("Salvar");
            jComboBox.addItem("Item 3");
            jComboBox.addItem("Item 4");
        }else{
            jComboBox.addItem("Arquivo");
            jComboBox.addItem("Salvar");
            jComboBox.addItem("Item 3");
            jComboBox.addItem("Item 4");
        }
        return jComboBox;
    }
    
    public static JComboBox getEditar(){
        JComboBox<String> jComboBox = new JComboBox();
        if(lingua.equals("EN")){
            jComboBox.addItem("Edit");
            jComboBox.addItem("Tema");
            jComboBox.addItem("Idioma");
        }else if(lingua.equals("JA")){
            jComboBox.addItem("編集");
            jComboBox.addItem("Tema");
            jComboBox.addItem("Idioma");
        }else if(lingua.equals("DE")){
            jComboBox.addItem("Bearbeiten");
            jComboBox.addItem("Tema");
            jComboBox.addItem("Idioma");
        }else{
            jComboBox.addItem("Editar");
            jComboBox.addItem("Tema");
            jComboBox.addItem("Idioma");
        }
        return jComboBox;
    }
    
    public static String getAjudar(){
        if(lingua.equals("EN")){
            return "Help";
        }else if(lingua.equals("JA")){
            return "ヘルプ";
        }else if(lingua.equals("DE")){
            return "Helfen";
        }else{
            return "Ajuda";
        }
    }
    
    public static String getSobre(){
        if(lingua.equals("EN")){
            return "About";
        }else if(lingua.equals("JA")){
            return "について";
        }else if(lingua.equals("DE")){
            return "Um";
        }else{
            return "Sobre";
        }
    }
    
    public static JComboBox getSimulação(){
        JComboBox<String> jComboBox = new JComboBox();
        if(lingua.equals("EN")){
            jComboBox.addItem("simulation");
            jComboBox.addItem("Simulação 1");
            jComboBox.addItem("Simulação 2");
            jComboBox.addItem("Simulação 3");
        }else if(lingua.equals("JA")){
            jComboBox.addItem("シミュレーション");
            jComboBox.addItem("Simulação 1");
            jComboBox.addItem("Simulação 2");
            jComboBox.addItem("Simulação 3");
        }else if(lingua.equals("DE")){
            jComboBox.addItem("Simulation");
            jComboBox.addItem("Simulação 1");
            jComboBox.addItem("Simulação 2");
            jComboBox.addItem("Simulação 3");
        }else{
            jComboBox.addItem("Painel");
            jComboBox.addItem("Simulação 1");
            jComboBox.addItem("Simulação 2");
            jComboBox.addItem("Simulação 3");
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
