package sam.command;

import sam.Storage;
import sam.TaskList;
import sam.Ui;
import sam.SamException;

<<<<<<< HEAD
=======
/**
 * Represents a command to exit the program.
 */
>>>>>>> branch-A-JavaDoc
public class ByeCommand extends Command {
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws SamException {
        System.out.println("Hope you enjoy my help.");
    }

    public boolean isExit() {
        return true;
    }
}