package headfirst.command.undo;

import java.util.*;

//
// This is the invoker
//
public class RemoteControlWithUndo {
  private Command[] onCommands;
  private Command[] offCommands;
  
  //private Command undoCommand;
  private Stack<Command> undoCommands = new Stack<Command>();

  public RemoteControlWithUndo() {
    onCommands = new Command[7];
    offCommands = new Command[7];

    Command noCommand = new NoCommand();
    for (int i = 0; i < 7; i++) {
      onCommands[i] = noCommand;
      offCommands[i] = noCommand;
    }
    //undoCommand = noCommand;
  }

  public void setCommand(int slot, Command onCommand, Command offCommand) {
    onCommands[slot] = onCommand;
    offCommands[slot] = offCommand;
  }

  public void onButtonWasPushed(int slot) {
    onCommands[slot].execute();
    //undoCommand = onCommands[slot];
    undoCommands.push(onCommands[slot]);
  }

  public void offButtonWasPushed(int slot) {
    offCommands[slot].execute();
    //undoCommand = offCommands[slot];
    undoCommands.push(offCommands[slot]);
  }

  public void undoButtonWasPushed() {
    //undoCommand.undo();
	if (!undoCommands.isEmpty())
    undoCommands.pop().undo();
  }

  public String toString() {
    StringBuffer stringBuff = new StringBuffer();
    stringBuff.append("\n------ Remote Control -------\n");
    for (int i = 0; i < onCommands.length; i++) {
      stringBuff.append("[slot " + i + "] " + onCommands[i].getClass().getName() + "    "
                        + offCommands[i].getClass().getName() + "\n");
    }
    for (int i = undoCommands.size() - 1; i >= 0; i--) {
    	stringBuff.append("[undo] " + undoCommands.get(i).getClass().getName() + "\n");
    }
    return stringBuff.toString();
  }
}
