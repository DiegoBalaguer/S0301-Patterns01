package level01.exercise01.model;

import level01.exercise01.exeptions.Hal9000Exception;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * PROGRAM: Undo
 * AUTHOR: Diego Balaguer
 * DATE: 27/05/2025
 */

public class Undo {
    private Deque<Instruction> instructions = new ArrayDeque<>();
    private static Undo undoApp = null;

    private Undo() {
    }

    public static Undo getUndoApp() {
        if (undoApp == null) {
            synchronized (Undo.class) {
                if (undoApp == null) {
                    undoApp = new Undo();
                }
            }
        }
        return undoApp;
    }

    public void addInstruction(Instruction instruction) {
        instructions.push(instruction);
    }

    public Instruction popInstruction() throws Hal9000Exception {
        if (instructions.isEmpty()) {
            throw new Hal9000Exception("List instructions is empty.");
        }
        return instructions.pop();
    }

    public Instruction peekInstruction() throws Hal9000Exception {
        if (instructions.isEmpty()) {
            throw new Hal9000Exception("List instructions is empty.");
        }
        return instructions.peek();
    }

    public Instruction retriveInstruction(int index) throws Hal9000Exception {
        if (instructions.isEmpty() || index < 0 || index > instructions.size() - 1) {
            throw new Hal9000Exception("Invalid index command");
        }
        return getInstructionForIndex(index);
    }

    public List<Instruction> getHistoric() {
        return instructions.stream().toList();
    }

    private Instruction getInstructionForIndex(int index) {
        return instructions.stream()
                .skip(index)
                .findFirst()
                .orElse(null);
    }
}
