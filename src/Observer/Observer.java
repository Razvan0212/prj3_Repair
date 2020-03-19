package Observer;

import interfaces.Updatable;

abstract class Observer {
    protected Updatable updatable;
    public abstract void update();
    public abstract void setUpdatable(Updatable updatable);
}
