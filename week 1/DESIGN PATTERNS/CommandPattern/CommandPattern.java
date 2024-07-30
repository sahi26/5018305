public class CommandPattern {
    public interface Command {
        void execute();
    }

    public static class LightOnCommand implements Command {
        private Light light;

        public LightOnCommand(Light light) {
            this.light = light;
        }

        @Override
        public void execute() {
            light.turnOn();
        }
    }

    public static class LightOffCommand implements Command {
        private Light light;

        public LightOffCommand(Light light) {
            this.light = light;
        }

        @Override
        public void execute() {
            light.turnOff();
        }
    }

    public static class RemoteControl {
        private Command command;

        public void setcommand(Command command) {
            this.command = command;
        }

        public void press() {
            command.execute();
        }
    }

    public static class Light {

        public void turnOn() {
            System.out.println("light ON");
        }

        public void turnOff() {
            System.out.println("light OFF");
        }
    }

    public static void main(String[] args) {
        Light room = new Light();
        Command on = new LightOnCommand(room);
        Command off = new LightOffCommand(room);
        RemoteControl remote = new RemoteControl();
        remote.setcommand(on);
        remote.press();
        remote.setcommand(off);
        remote.press();

    }
}
