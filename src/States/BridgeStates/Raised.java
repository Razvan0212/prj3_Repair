package States.BridgeStates;

import interfaces.BridgeStatesInterface;
import objects.Bridge;

public class Raised implements BridgeStatesInterface {

    @Override
    public void next(Bridge bridge) {
        bridge.setState(new Lowering());
    }

    @Override
    public String toString(){
        return "Raised";
    }
}
