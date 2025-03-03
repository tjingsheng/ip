package tasks;

import java.time.LocalDate;
import java.util.Objects;

import enums.TaskType;

/**
 * The `DeadlineTask` class represents a task with a specific deadline in the Woof application.
 * It extends the `Task` class and includes the deadline information.
 */
public class DeadlineTask extends Task {
    /**
     * The deadline date of the task.
     */
    private final LocalDate endDate;

    /**
     * Constructs a `DeadlineTask` with the given description and deadline date.
     *
     * @param description The description of the task.
     * @param endDate     The deadline date of the task.
     */
    public DeadlineTask(String description, LocalDate endDate) {
        super(description);
        this.endDate = endDate;
    }

    /**
     * Constructs a `DeadlineTask` with the given description and deadline date.
     *
     * @param description The description of the task.
     * @param endDate     The deadline date of the task.
     * @param isDone      The optional is done to mark a task as per is done.
     */
    public DeadlineTask(String description, LocalDate endDate, Boolean isDone) {
        super(description, isDone);
        this.endDate = endDate;
    }

    /**
     * Gets the deadline date formatted as a string.
     *
     * @return A string representation of the deadline date.
     */
    public String getDeadline() {
        return String.format("%s~By: %s\n", getTabStopTwo(), parseDateTimeOut(endDate));
    }

    /**
     * Retrieves the type of task associated with this object, which is "DEADLINE."
     *
     * @return The task type, which is "DEADLINE" for objects of this class.
     */
    @Override
    public TaskType getTaskType() {
        return TaskType.DEADLINE;
    }

    /**
     * Retrieves the datetime associated with deadlines, the end date and time, represented as a long value.
     *
     * @return The end date and time as a long value.
     */
    @Override
    public long getDateTimeLong() {
        return this.endDate.toEpochDay();
    }

    /**
     * Generates a string representation of the `DeadlineTask`.
     *
     * @return A string representation of the task, including its symbol, description, and deadline.
     */
    @Override
    public String toString() {
        return String.format("%s%s%s", TaskType.DEADLINE.toSymbol(), super.toString() , getDeadline());
    }

    /**
     * Checks if this `DeadlineTask` is equal to another object.
     *
     * @param o The object to compare to.
     * @return `true` if the objects are equal, `false` otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DeadlineTask)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        DeadlineTask otherDeadlineTask = (DeadlineTask) o;
        return this.endDate.equals(otherDeadlineTask.endDate);
    }

    /**
     * Generates a hash code for this `DeadlineTask`.
     *
     * @return A hash code for the task, including its description and deadline.
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.endDate);
    }
}
