import components.map.Map;
import components.program.Program;
import components.statement.Statement;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class renameStatement {

    /**
     * No argument constructor--private to prevent instantiation.
     *
     * @return
     */
    private void renameInstruction(Program stmt, String oldName,
            String newName) {

        Map<String, Statement> ctxt = stmt.newContext();
        stmt.swapContext(ctxt);
        Map<String, Statement> temp = ctxt.newInstance();
        temp.transferFrom(ctxt);

        while (temp.size() > 0) {
            Map.Pair<String, Statement> pair = temp.removeAny();
            if (pair.key().equals(oldName)) {
                temp.add(newName, pair.value());
            } else {
                temp.add(pair.key(), pair.value());
            }
        }

        ctxt.transferFrom(temp);

    }

    public static void main(String[] args) {
        /*
         * Put your main program code here
         */
    }

}
