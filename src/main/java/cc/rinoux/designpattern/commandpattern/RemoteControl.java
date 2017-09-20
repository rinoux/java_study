package cc.rinoux.designpattern.commandpattern;

import java.util.Arrays;

/**
 * Created by rinoux on 2017/7/13.
 */
public class RemoteControl {

    Command[] onCommands;
    Command[] offCommands;

    public RemoteControl() {
        offCommands = new Command[7];
        onCommands = new Command[7];

        Command noCommand = new NoCommand();

        for (int i = 0; i < 7; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
    }



    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPushed(int slot) {
        onCommands[slot].execute();
    }

    public void offButtonWasPushed(int slot) {
        offCommands[slot].execute();
    }


    @Override
    public String toString() {
        return "RemoteControl{" +
                "onCommands=" + Arrays.toString(onCommands) +
                ", offCommands=" + Arrays.toString(offCommands) +
                '}';
    }


    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();
        Light livingRoomLight = new Light("living room");
        Light kitchenLight = new Light("kitchen");

        LightOnCommand livingLightOnCommand = new LightOnCommand(livingRoomLight);
        LightOffCommand livingLightOffCommand = new LightOffCommand(livingRoomLight);

        LightOnCommand kitchenLightOnCommand = new LightOnCommand(kitchenLight);
        LightOffCommand kitchenLightOffCommand = new LightOffCommand(kitchenLight);

        remoteControl.setCommand(1, livingLightOnCommand, livingLightOffCommand);
        remoteControl.setCommand(2, kitchenLightOnCommand, kitchenLightOffCommand);


        remoteControl.onButtonWasPushed(1);
    }
}
