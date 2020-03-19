package Observer;

import interfaces.Updatable;

public class BoatObserver extends Observer {
    @Override
    public void update() {
        updatable.update();
    }

    @Override
    public void setUpdatable(Updatable object) {
        this.updatable = object;
    }
}
