package States.BridgeStates;

import interfaces.BridgeStatesInterface;
import objects.Bridge;

public class Lowered implements BridgeStatesInterface {

    @Override
    public void next(Bridge bridge) {
        bridge.setState(new Raising());
    }

    @Override
    public String toString(){
        return "Lowered";
    }
}
