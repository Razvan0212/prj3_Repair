package States.BridgeStates;

import interfaces.BridgeStatesInterface;
import objects.Bridge;

public class Lowering implements BridgeStatesInterface {

    @Override
    public void next(Bridge bridge) {
        bridge.setState(new Lowered());
    }

    @Override
    public String toString(){
        return "Lowering";
    }
}


