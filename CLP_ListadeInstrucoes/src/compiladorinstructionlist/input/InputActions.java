package compiladorinstructionlist.input;

import java.util.Map;
/*import com.intelligt.modbus.jlibmodbus.Modbus;
import com.intelligt.modbus.jlibmodbus.master.ModbusMaster;
import com.intelligt.modbus.jlibmodbus.master.ModbusMasterFactory;
import com.intelligt.modbus.jlibmodbus.exception.ModbusIOException;
import com.intelligt.modbus.jlibmodbus.serial.SerialParameters;
import com.intelligt.modbus.jlibmodbus.serial.SerialPort;
import com.intelligt.modbus.jlibmodbus.serial.SerialPortFactoryJSSC;
import com.intelligt.modbus.jlibmodbus.serial.SerialPortFactoryPJC;
import com.intelligt.modbus.jlibmodbus.serial.SerialPortFactoryRXTX;
import com.intelligt.modbus.jlibmodbus.serial.SerialUtils;*/

// Classe para as ações relacionadas com as entradas
public class InputActions {
    
    final static private int slaveId = 1;
    
    public static Map create(Map inputs) {
        // Cria as 16 entradas
        Input I1 = new Input("I1", false);
        Input I2 = new Input("I2", false);
        Input I3 = new Input("I3", false);
        Input I4 = new Input("I4", false);
        Input I5 = new Input("I5", false);
        Input I6 = new Input("I6", false);
        Input I7 = new Input("I7", false);
        Input I8 = new Input("I8", false);
        Input I9 = new Input("I9", false);
        Input I10 = new Input("I10", false);
        Input I11 = new Input("I11", false);
        Input I12 = new Input("I12", false);
        Input I13 = new Input("I13", false);
        Input I14 = new Input("I14", false);
        Input I15 = new Input("I15", false);
        Input I16 = new Input("I16", false);
        
        // Adiciona no hash
        inputs.put(I1.id, I1.currentValue);
        inputs.put(I2.id, I2.currentValue);
        inputs.put(I3.id, I3.currentValue);
        inputs.put(I4.id, I4.currentValue);
        inputs.put(I5.id, I5.currentValue);
        inputs.put(I6.id, I6.currentValue);
        inputs.put(I7.id, I7.currentValue);
        inputs.put(I8.id, I8.currentValue);
        inputs.put(I9.id, I9.currentValue);
        inputs.put(I10.id, I10.currentValue);
        inputs.put(I11.id, I11.currentValue);
        inputs.put(I12.id, I12.currentValue);
        inputs.put(I13.id, I13.currentValue);
        inputs.put(I14.id, I14.currentValue);
        inputs.put(I15.id, I15.currentValue);
        inputs.put(I16.id, I16.currentValue);
        
        return inputs;
    }
    
    public static Map createType(Map inputsType) {        
        // Adiciona no hash
        inputsType.put("I1", 0);
        inputsType.put("I2", 0);
        inputsType.put("I3", 0);
        inputsType.put("I4", 0);
        inputsType.put("I5", 0);
        inputsType.put("I6", 0);
        inputsType.put("I7", 0);
        inputsType.put("I8", 0);
        inputsType.put("I9", 0);
        inputsType.put("I10", 0);
        inputsType.put("I11", 0);
        inputsType.put("I12", 0);
        inputsType.put("I13", 0);
        inputsType.put("I14", 0);
        inputsType.put("I15", 0);
        inputsType.put("I16", 0);
        
        return inputsType;
    }
    
    // "Simula" leitura
    public static Map<String, Boolean> dummyRead(Map inputs) {
        // Lê os valores de cada entrada vindos do módulo
        boolean[] arrayBoolean = convertValueRead(49);
        System.out.println("[Dummy] Valor lido do módulo: 33");
        
        //for (int i = 0; i < 8; i++) {
        //    System.out.println(arrayBoolean[i]);
        //}
        
        // Atualiza no hash
        inputs.put("I1", arrayBoolean[15]);
        inputs.put("I2", arrayBoolean[14]);
        inputs.put("I3", arrayBoolean[13]);
        inputs.put("I4", arrayBoolean[12]);
        inputs.put("I5", arrayBoolean[11]);
        inputs.put("I6", arrayBoolean[10]);
        inputs.put("I7", arrayBoolean[9]);
        inputs.put("I8", arrayBoolean[8]);
        inputs.put("I9", arrayBoolean[7]);
        inputs.put("I10", arrayBoolean[6]);
        inputs.put("I11", arrayBoolean[5]);
        inputs.put("I12", arrayBoolean[4]);
        inputs.put("I13", arrayBoolean[3]);
        inputs.put("I14", arrayBoolean[2]);
        inputs.put("I15", arrayBoolean[1]);
        inputs.put("I16", arrayBoolean[0]);
        
        return inputs;
    }
       
    // Leitura
    public static Map read(Map inputs) {
        // Lê os valores de cada entrada vindos do módulo
        /*SerialParameters sp = new SerialParameters();
        Modbus.setLogLevel(Modbus.LogLevel.LEVEL_DEBUG);
        
        Integer valueRead = 0;
        
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

                int slaveId = 0x01;
                int offset = 0x00C0;
                int quantity = 2;
 
                try {
                    int[] registerValues = m.readHoldingRegisters(slaveId, offset, quantity);

                    // Impressão dos valores lidos
                    System.out.println("Valores dos Registradores:");
                    for (int value : registerValues) {
                        System.out.println("Endereço: " + offset + ", Valor: " + value);
                    }
                    
                    valueRead = registerValues[0];
                    System.out.println("Valor lido do módulo: " + valueRead);
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
        }
        
        // Converte para boolean
        boolean[] arrayBoolean = convertValueRead(valueRead);
        
        // Atualiza no hash
        inputs.put("I1", arrayBoolean[7]);
        inputs.put("I2", arrayBoolean[6]);
        inputs.put("I3", arrayBoolean[5]);
        inputs.put("I4", arrayBoolean[4]);
        inputs.put("I5", arrayBoolean[3]);
        inputs.put("I6", arrayBoolean[2]);
        inputs.put("I7", arrayBoolean[1]);
        inputs.put("I8", arrayBoolean[0]);*/
        
        return inputs;
    }
    
    // Converte para boolean
    public static boolean[] convertValueRead(int value) {
        // Converte para binário de 16 bits
        String binary = String.format("%16s", Integer.toBinaryString(value)).replaceAll(" ", "0");

        // Extrair os 8 bits mais significativos
        String importantBits = binary.substring(0, 16);

        // Converter para array de booleanos
        boolean[] resultado = new boolean[16];
        for (int i = 0; i < 16; i++) {
            resultado[i] = importantBits.charAt(i) == '1';
        }
        
        return resultado;
    }
}
