package compiladorinstructionlist.output;

/*import com.intelligt.modbus.jlibmodbus.Modbus;
import com.intelligt.modbus.jlibmodbus.exception.ModbusIOException;
import com.intelligt.modbus.jlibmodbus.master.ModbusMaster;
import com.intelligt.modbus.jlibmodbus.master.ModbusMasterFactory;
import com.intelligt.modbus.jlibmodbus.serial.SerialParameters;
import com.intelligt.modbus.jlibmodbus.serial.SerialPort;
import com.intelligt.modbus.jlibmodbus.serial.SerialPortFactoryPJC;
import com.intelligt.modbus.jlibmodbus.serial.SerialUtils;*/
import java.util.Map;

// Classe para as ações relacionadas com as saídas
public class OutputActions {
    
    public static Map create(Map outputs) {
        // Cria as 16 saídas
        Output Q1 = new Output("Q1", false);
        Output Q2 = new Output("Q2", false);
        Output Q3 = new Output("Q3", false);
        Output Q4 = new Output("Q4", false);
        Output Q5 = new Output("Q5", false);
        Output Q6 = new Output("Q6", false);
        Output Q7 = new Output("Q7", false);
        Output Q8 = new Output("Q8", false);
        Output Q9 = new Output("Q9", false);
        Output Q10 = new Output("Q10", false);
        Output Q11 = new Output("Q11", false);
        Output Q12 = new Output("Q12", false);
        Output Q13 = new Output("Q13", false);
        Output Q14 = new Output("Q14", false);
        Output Q15 = new Output("Q15", false);
        Output Q16 = new Output("Q16", false);
        
        // Adiciona no hash
        outputs.put(Q1.id, Q1.currentValue);
        outputs.put(Q2.id, Q2.currentValue);
        outputs.put(Q3.id, Q3.currentValue);
        outputs.put(Q4.id, Q4.currentValue);
        outputs.put(Q5.id, Q5.currentValue);
        outputs.put(Q6.id, Q6.currentValue);
        outputs.put(Q7.id, Q7.currentValue);
        outputs.put(Q8.id, Q8.currentValue);
        outputs.put(Q9.id, Q9.currentValue);
        outputs.put(Q10.id, Q10.currentValue);
        outputs.put(Q11.id, Q11.currentValue);
        outputs.put(Q12.id, Q12.currentValue);
        outputs.put(Q13.id, Q13.currentValue);
        outputs.put(Q14.id, Q14.currentValue);
        outputs.put(Q15.id, Q15.currentValue);
        outputs.put(Q16.id, Q16.currentValue);
        
        return outputs;
    }
    // Leitura
    public static Map read(Map outputs) {
        return outputs;
    }
    
    // "Limpa" values do hash de saída
    public static Map setAllFalse(Map outputs) {
        outputs.put("Q1", false);
        outputs.put("Q2", false);
        outputs.put("Q3", false);
        outputs.put("Q4", false);
        outputs.put("Q5", false);
        outputs.put("Q6", false);
        outputs.put("Q7", false);
        outputs.put("Q8", false);
        outputs.put("Q9", false);
        outputs.put("Q10", false);
        outputs.put("Q11", false);
        outputs.put("Q12", false);
        outputs.put("Q13", false);
        outputs.put("Q14", false);
        outputs.put("Q15", false);
        outputs.put("Q16", false);
        
        return outputs;
    }
    
    // "Simula" escrita
    public static Map<String, Boolean> dummyWrite(Map outputs) {
        // Escreve os valores de cada saída no módulo
        // ...
        Integer valueWrite = convertValueWrite(outputs);
        System.out.println("[Dummy] Valor enviado para escrita no módulo: " + valueWrite);
        
        return outputs;
    }
    
    // Escrita
    public static Map write(Map outputs) {   
        // Escreve os valores de cada saída no módulo
        /*SerialParameters sp = new SerialParameters();
        Modbus.setLogLevel(Modbus.LogLevel.LEVEL_DEBUG);
        
        // Converte para inteiro
        Integer valueWrite = convertValueWrite(outputs);
        System.out.println("Valor enviado para escrita no módulo: " + valueWrite);
        
        try {
            // Seta porta
            sp.setDevice("COM5");
            
            if (sp.getDevice() != null) {
                // Parâmetros de configuração
                sp.setBaudRate(SerialPort.BaudRate.BAUD_RATE_9600);
                sp.setDataBits(8);
                sp.setParity(SerialPort.Parity.NONE);
                sp.setStopBits(1);

                SerialUtils.setSerialPortFactory(new SerialPortFactoryPJC());

                ModbusMaster m = ModbusMasterFactory.createModbusMasterRTU(sp);
                //m.connect();

                int writeAddress = 0x0070;
 
                try {
                    m.writeMultipleRegisters(1, writeAddress, new int[]{valueWrite, 0});
           
                } catch (RuntimeException e) {
                    throw e;
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        m.disconnect();
                    } catch (ModbusIOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        
        return outputs;
    }
    
    // Converte para inteiro
    public static int convertValueWrite(Map<String, Boolean> outputs) {
        StringBuilder binaryString = new StringBuilder();

        for (int i = 16; i >= 1; i--) {
            binaryString.append(outputs.getOrDefault("Q" + i, false) ? '1' : '0');
        }

        // Converte a string binária para inteiro
        return Integer.parseInt(binaryString.toString(), 2);
    }
}
