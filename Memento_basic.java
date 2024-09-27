package DP;

import java.util.ArrayList;
import java.util.List;

class OriginatorObject {
    private int temperature;
    private int volume;

    public OriginatorObject(int t, int v)
    {
        temperature = t;
        volume = v;
    }
    public void setTemperature(int t)
    {
        temperature =t;
    }
    public void setVolume(int v)
    {
        volume=v;
    }
    public int getVolume()
    {
        return temperature;
    }
    public int setVolume()
    {
        return volume;
    }
    public MementoObject saveStateDetailToMemento()
    {
        return new MementoObject(temperature,volume);
    }
    public void operateMachine()
    {
        System.out.println("Machine operating with temperature : "+temperature+" and volume of "+volume);
    }
    public void restoreState(MementoObject m)      // Name can be 'undoState' as well
    {
        temperature = m.getTemperature();
        volume = m.getVolume();
    }
    public String toString()
    {
        return "Temperature : "+temperature+" Volume : "+volume;
    }
}

class MementoObject { //Memento class can not have setter method apart from constructor
    private int temperature;
    private int volume;

    public MementoObject(int t, int v)
    {
        temperature=t;
        volume=v;
    }
    public int getVolume()
    {
        return volume;
    }
    public int getTemperature()
    {
        return temperature;
    }
    public String toString()
    {
        return "Temperature : "+temperature+" Volume : "+volume;
    }
}

class CareTakerObject
{
    private List <MementoObject> list = new ArrayList<MementoObject>();

    public void add(MementoObject m)
    {
        list.add(m);
    }

    public MementoObject getState(int i)
    {
        return list.get(i);
    }
}
public class Memento_basic {
    public static void main(String[] args) {

        // 1. create the object of Originator
        OriginatorObject o1 = new OriginatorObject(25,10);

        // 2. Call business method on originator method
        o1.operateMachine();

        // 3. Save the state of the originator
        CareTakerObject c1 = new CareTakerObject();
        c1.add(o1.saveStateDetailToMemento());

        o1.setTemperature(30);
        o1.setVolume(15);
        o1.operateMachine();

        o1.setTemperature(40);
        o1.setVolume(5);
        o1.operateMachine();

        // 4. Restore the first state (c1.get(0))
        System.out.println("Restored State : ");
        o1.restoreState(c1.getState(0));
        o1.operateMachine();
    }
}