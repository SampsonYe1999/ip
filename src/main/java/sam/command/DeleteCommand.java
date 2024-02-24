package sam.command;

import sam.Storage;
import sam.TaskList;
import sam.Ui;
import sam.SamException;

/**
 * Represents a command to delete a task.
 */
public class DeleteCommand extends Command {
    private int index;

    public DeleteCommand(String taskInfo) throws SamException {
        if (taskInfo.isBlank()) {
            throw new SamException("Please provide the task number to delete.");
        }
        try {
            this.index = Integer.parseInt(taskInfo) - 1;
        } catch (NumberFormatException e) {
            throw new SamException("Please provide a number");
        }
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws SamException {
        tasks.deleteTask(index);
        storage.save(tasks);
    }
}