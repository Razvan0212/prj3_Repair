package States.BridgeStates;

import interfaces.BridgeStatesInterface;
import objects.Bridge;

public class Raising implements BridgeStatesInterface {

    @Override
    public void next(Bridge bridge) {
        bridge.setState(new Raised());
    }

    @Override
    public String toString(){
        return "Raising";
    }
}
