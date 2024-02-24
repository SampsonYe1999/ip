package sam.command;

import sam.SamException;
import sam.Storage;
import sam.TaskList;
import sam.Ui;
import sam.task.Event;

/**
 * Represents a command to add an event task.
 */
public class EventCommand extends Command {
    private final String description;
    private final String from;
    private final String to;
    /**
     * Constructs an EventCommand with the specified event details.
     *
     * Initializes an EventCommand with the provided event details. If the task info does not contain
     * "/from" or "/to" indicating the event's start and end times, throws a SamException with a message
     * indicating the invalid format. If any of the event details (description, start time, end time) are blank,
     * throws a SamException with a message indicating the need to provide all required details.
     *
     * @param taskInfo the string containing event details (description, start time, end time)
     * @throws SamException if the task info is missing "/from" or "/to", or if any of the event details are blank
     */
    public EventCommand(String taskInfo) throws SamException {
        if (!taskInfo.contains("/from") || !taskInfo.contains("/to")) {
            throw new SamException("Invalid format for event, please provide event details by using /from and /to.");
        }

        String[] details = taskInfo.split(" /from | /to ");
        if (details[0].isBlank() || details[1].isBlank() || details[2].isBlank()) {
            throw new SamException("Please provide description, /from, and /to");
        }
        this.description = details[0];
        this.from = details[1];
        this.to = details[2];
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws SamException {
        tasks.addTask(new Event(this.description, this.from, this.to));
        storage.save(tasks);
    }
}
