package lesson5;

public class Computer {

    PowerState state;
    public enum PowerState {
        OFF("The power is off"),
        ON("The power usage is high"),
        SUSPENDED("The power usage is low");

        private String desc;
        private PowerState(String d) {
            desc = d;
        }
        public String getDesc() {
            return desc;
        }
    }

    public PowerState getState() {
        return state;
    }

    public void setState(PowerState state) {
        this.state = state;
    }

}
