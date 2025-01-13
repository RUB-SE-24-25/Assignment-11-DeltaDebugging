package rub.deltadebugging;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Simple test class for the recursive and iterative ddmin implementation.
 */
public class DeltaDebuggerTest {

  static final boolean LOG = true;

  /**
   * Mystery program from the class. Based on: https://www.debuggingbook.org/html/DeltaDebugger.html
   */
  public static void mystery(String input) {
    int x = input.indexOf("\u0028");
    int y = input.indexOf("\u0029");
    if (x >= 0 && y >= 0 && x < y) {
      throw new RuntimeException("Invalid Input");
    } else {
      return;
    }
  }

  @Test
  void ddmin_mystery_iterative_test() {
    DeltaDebugger db = new IterativeDeltaDebugger((p1) -> {
      try {
        mystery(p1);
        if (LOG) {
          System.out.println("test(" + p1 + ") -> PASS");
        }
        return DeltaDebugger.Result.PASS;
      } catch (Exception e) {
        if (LOG) {
          System.out.println("test(" + p1 + ") -> FAIL");
        }
        return DeltaDebugger.Result.FAIL;
      }
    });

    String input = "V#/+!aF-(V4EOz*+s/Q,7)2@0_";
    if (LOG) {
      System.out.println(input);
    }
    input = db.ddmin(input);
    if (LOG) {
      System.out.println(input);
    }
    assertEquals("()", input);
  }

  @Test
  void ddmin_mystery_recursive_test() {
    DeltaDebugger db = new RecursiveDeltaDebugger((p1) -> {
      try {
        mystery(p1);
        if (LOG) {
          System.out.println("test(" + p1 + ") -> PASS");
        }
        return DeltaDebugger.Result.PASS;
      } catch (Exception e) {
        if (LOG) {
          System.out.println("test(" + p1 + ") -> FAIL");
        }
        return DeltaDebugger.Result.FAIL;
      }
    });

    String input = "V#/+!aF-(V4EOz*+s/Q,7)2@0_";
    if (LOG) {
      System.out.println(input);
    }
    input = db.ddmin(input);
    if (LOG) {
      System.out.println(input);
    }
    assertEquals("()", input);
  }

}
