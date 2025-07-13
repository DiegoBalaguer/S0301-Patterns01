package level01.exercise01.model;

import level01.exercise01.exeptions.Hal9000Exception;
import utils.ConsoleUtils;

import java.util.List;

import static level01.exercise01.enums.InstructionsEnum.ret;

/**
 * PROGRAM: ConsoleApp
 * AUTHOR: Diego Balaguer
 * DATE: 27/05/2025
 */

public class ConsoleApp {

    private static final String LINE = System.lineSeparator();
    private static final Undo undoList = Undo.getUndoApp();
    private static boolean exit = false;
    private static final String DIRECTORY_HOME = System.getProperty("user.dir");
    private String directory = DIRECTORY_HOME;
    private static ConsoleApp consoleApp;

    private ConsoleApp() {}

    public static ConsoleApp getConsoleApp() {
        if (consoleApp == null) {
            synchronized (Undo.class) {
                if (consoleApp == null) {
                    consoleApp = new ConsoleApp();
                }
            }
        }
        return consoleApp;
    }

    public void call() {
        System.out.println(LINE + "INTERFACE HAL 9000.................." + LINE + "* for help, type help + [ENTER]" + LINE);

        do {
            try {
                String input = ConsoleUtils.readValueString(directory + ">:");
                Instruction instruction = new Instruction(input);
                executeInstruction(instruction);
            } catch (Hal9000Exception e) {
                System.err.println(e.getMessage());
            }
        } while (!exit);
    }

    private void executeInstruction(Instruction instruction) throws Hal9000Exception {
        undoList.addInstruction(instruction);
        run(instruction);
    }

    private void run(Instruction instruction) throws Hal9000Exception {
        if (instruction.getCommand().equals(ret)) {
            int index = Integer.parseInt(instruction.getParameter());
            Instruction instructionLoad = retrieveInstruction(index);
            if (instructionLoad.getCommand().equals(ret)) {
                throw new Hal9000Exception("ret can't call another ret.");
            } else {
                System.out.println(directory + ">: " + retrieveInstruction(Integer.parseInt(instruction.getParameter())).getText());
            }
        }
        switch (instruction.getCommand()) {
            case help -> showHelp();
            case history -> showHistory();
            case undo -> undoInstruction();
            case cd -> changeDirectory(instruction);
            case ret -> run(retrieveInstruction(Integer.parseInt(instruction.getParameter())));
            case exit -> exit = true;
            default -> System.out.println("Ejecute: " + instruction.getText());
        }
    }

    private void undoInstruction() throws Hal9000Exception {
        Instruction instruction = null;
        // se duplica para borrar la instrucción de undo
        instruction = undoList.popInstruction();
        instruction = undoList.popInstruction();
        System.out.println(directory + ">: undo instruction " + instruction.getText());
        run(undoList.peekInstruction());
    }

    private void showHelp() {
        StringBuilder message = new StringBuilder("");
        message.append("List of accepted commands:").append(LINE);
        message.append("* help:   \tdisplays this help.").append(LINE);
        message.append("* history:\tdisplays the command history.").append(LINE);
        message.append("* undo:   \tundo last command input.").append(LINE);
        message.append("* ret:    \tret <number> -> returns the instruction <number> from the history.").append(LINE);
        message.append("* copy:   \tcopy <source> <destination> -> copies a file.").append(LINE);
        message.append("* cd:     \tcd <directory> -> moves to the specified directory.").append(LINE);
        message.append("* cd home:\tcd home -> moves to the user's home directory.").append(LINE);
        message.append("* run:    \trun <file>: executes the given file.").append(LINE);
        message.append("* delete: \tdelete <file> deletes the specified file.").append(LINE);
        message.append("* exit:   \texits the program").append(LINE);
        System.out.println(message.toString());
        System.out.println(undoList);
    }

    private void showHistory() {
        String message = "HISTORY" + LINE;
        List<Instruction> instructions = undoList.getHistoric();
        for (int i = 0; i < instructions.size() - 1; i++) {
            message += "* " + i + " " + instructions.get(i).getText() + LINE;
        }
        System.out.println(message);
    }

    private Instruction retrieveInstruction(int index) throws Hal9000Exception {
        return undoList.retriveInstruction(index);
    }

    private void changeDirectory(Instruction instruction) throws Hal9000Exception {
        if (instruction.getParameter().equals("home")) {
            directory = DIRECTORY_HOME;
        } else directory = instruction.getParameter();
    }
}
