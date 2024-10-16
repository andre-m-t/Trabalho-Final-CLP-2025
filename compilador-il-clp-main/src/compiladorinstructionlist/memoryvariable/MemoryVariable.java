package compiladorinstructionlist.memoryvariable;

// Classe variável de memória

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class MemoryVariable {
    public String id;
    public Boolean currentValue;
    public Boolean endTimer;
    public int counter;
    public int maxTimer;
    public Timer timer;

    public MemoryVariable(String id) {
        this.id = id;
        this.counter = 0;
        this.currentValue = false;
        this.maxTimer = 0;
        this.endTimer = false;
        this.timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if(counter<maxTimer){
                    counter++;
                }
                if(counter == maxTimer){
                    endTimer = id.charAt(1) == 'O' ? true:false;
                    timer.stop();
                }
            }
        });
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public Boolean getEndTimer(){
        return this.endTimer;
    }
    
    public Boolean getEndCounter(){
        return this.endTimer;
    }

    public Boolean getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(Boolean currentValue) {
        this.currentValue = currentValue;
    }

    @Override
    public String toString() {
        return "MemoryVariable{" + "id=" + id + ", currentValue=" + currentValue + '}';
    }
}
