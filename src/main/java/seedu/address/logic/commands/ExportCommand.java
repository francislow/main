package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.util.CsvUtil;
import seedu.address.model.Model;

/**
 * Exports Person data from the AddressBook
 */

public class ExportCommand extends Command {

    public static final String COMMAND_WORD = "export";

    public static final String MESSAGE_SUCCESS = "Export success!";


    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);

        return new CommandResult(MESSAGE_SUCCESS);
    }
}
