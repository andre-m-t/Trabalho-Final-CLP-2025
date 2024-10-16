package compiladorinstructionlist.memoryvariable;

// Classe variável de memória
public class MemoryVariable {
    public String id;
    public  Boolean currentValue;
    public  Boolean endTimer;
    public  int counter;
    public  int maxTimer;

    public MemoryVariable(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
