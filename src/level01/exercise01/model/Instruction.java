package level01.exercise01.model;

import level01.exercise01.enums.InstructionsEnum;
import level01.exercise01.exeptions.Hal9000Exception;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * PROGRAM: Instruction
 * AUTHOR: Diego Balaguer
 * DATE: 27/05/2025
 */

public class Instruction {
    private static final List<String> COMMANDS = Arrays.stream(InstructionsEnum.values())
            .map(e -> e.name().toLowerCase())
            .collect(Collectors.toList());
    private String text;
    private InstructionsEnum command;

    public Instruction(String text) throws Hal9000Exception {
        setText(text);
    }

    private void isCorrect() throws Hal9000Exception {
        if(!COMMANDS.contains(getTextCommand())) {
            throw new Hal9000Exception("Invalid instruction");
        }
    }

    private void setText(String text) throws Hal9000Exception {
        if (text.isEmpty()) {
            throw new Hal9000Exception("Text cannot be empty");
        }
        this.text = text.toLowerCase();

        isCorrect();
        setCommand();
    }

    private void setCommand() {
        for(InstructionsEnum command : InstructionsEnum.values()) {
            if(command.name().equals(getTextCommand())) {
                this.command = command;
                return;
            }
        }
    }

    private String getTextCommand() {
        return textParam(0);
    }

    public InstructionsEnum getCommand() {
        return command;
    }

    public String getParameter() throws Hal9000Exception {
        if(numberParams() == 0) {
            throw new Hal9000Exception("Number of parameters must be greater than zero");
        }
        return Arrays.stream(splitText())
                .skip(1)
                .collect(Collectors.joining(" "));
    }

    public String getText() {
        return text;
    }

    private int numberParams() {
        return splitText().length-1;
    }

    private String textParam(int index) {
        return splitText()[index];
    }

    private String[] splitText() {
        return text.split("\\s+");
    }

    @Override
    public String toString() {
        return "InstructionText{" +
                "text='" + text + '\'' +
                '}';
    }
}
