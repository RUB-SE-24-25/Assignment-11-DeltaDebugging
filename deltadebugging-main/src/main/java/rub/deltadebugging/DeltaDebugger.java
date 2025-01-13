package rub.deltadebugging;

/**
 * Implements the ddmin, i.e., the "Minimizing Delta Debugging Algorithm".
 * https://www.cs.purdue.edu/homes/xyzhang/fall07/Papers/delta-debugging.pdf
 */
public interface DeltaDebugger {

  /**
   * Represents the result types of a test case.
   */
  public static enum Result {
    PASS, FAIL, UNRESOLVED;
  }

  /**
   * General interface the program under test needs to provide.
   */
  public interface Function {
    Result execute(String input);
  }

  /**
   * Minimizes a given input String so that it is still failing. It assumes that the current input
   * is failing.
   *
   * @param input - String that fails the program under test
   * @return String - minimized failing input
   */
  public String ddmin(String input);

}
