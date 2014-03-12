package net.earthcoder.ganoderma.man;

public abstract class AbstractHuman implements Human {
    
    protected Integer serialNumber;
    
    public AbstractHuman(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Integer getID() {
        return serialNumber;
    }
    
    public abstract String name();
    
    @Override
    public int hashCode() {
        return serialNumber.hashCode();
    }
    
    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (null == otherObject) {
            return false;
        }
        if (this.getClass() != otherObject.getClass()) {
            return false;
        }
        Human otherHuman = (Human) otherObject;
        return this.serialNumber.equals(otherHuman.getID());
    }
    
    @Override
    public String toString() {
        return serialNumber.toString();
    }
}
