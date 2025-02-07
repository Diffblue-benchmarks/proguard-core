package proguard.evaluation.util.jsonprinter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BranchTargetRecordDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BranchTargetRecord#BranchTargetRecord(List, List, int)}
   *   <li>{@link BranchTargetRecord#getStartOffset()}
   *   <li>{@link BranchTargetRecord#getStartStack()}
   *   <li>{@link BranchTargetRecord#getStartVariables()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.util.jsonprinter.BranchTargetRecord.<init>(java.util.List, java.util.List, int)",
    "int proguard.evaluation.util.jsonprinter.BranchTargetRecord.getStartOffset()",
    "java.util.List proguard.evaluation.util.jsonprinter.BranchTargetRecord.getStartStack()",
    "java.util.List proguard.evaluation.util.jsonprinter.BranchTargetRecord.getStartVariables()"
  })
  void testGettersAndSetters() {
    // Arrange
    ArrayList<String> variables = new ArrayList<>();
    ArrayList<String> stack = new ArrayList<>();

    // Act
    BranchTargetRecord actualBranchTargetRecord = new BranchTargetRecord(variables, stack, 1);
    int actualStartOffset = actualBranchTargetRecord.getStartOffset();
    List<String> actualStartStack = actualBranchTargetRecord.getStartStack();
    List<String> actualStartVariables = actualBranchTargetRecord.getStartVariables();

    // Assert
    assertEquals(1, actualStartOffset);
    assertTrue(actualStartStack.isEmpty());
    assertTrue(actualStartVariables.isEmpty());
    assertSame(stack, actualStartStack);
    assertSame(variables, actualStartVariables);
  }

  /**
   * Test {@link BranchTargetRecord#toJson(StringBuilder)}.
   *
   * <p>Method under test: {@link BranchTargetRecord#toJson(StringBuilder)}
   */
  @Test
  @DisplayName("Test toJson(StringBuilder)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.StringBuilder proguard.evaluation.util.jsonprinter.BranchTargetRecord.toJson(java.lang.StringBuilder)"
  })
  void testToJson() {
    // Arrange
    ArrayList<String> variables = new ArrayList<>();
    BranchTargetRecord branchTargetRecord = new BranchTargetRecord(variables, new ArrayList<>(), 1);
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualToJsonResult = branchTargetRecord.toJson(builder);

    // Assert
    assertEquals(
        "foo{\"startOffset\":1,\"startStack\":[],\"startVariables\":[]}", builder.toString());
    assertSame(builder, actualToJsonResult);
  }

  /**
   * Test {@link BranchTargetRecord#toJson(StringBuilder)}.
   *
   * <p>Method under test: {@link BranchTargetRecord#toJson(StringBuilder)}
   */
  @Test
  @DisplayName("Test toJson(StringBuilder)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.StringBuilder proguard.evaluation.util.jsonprinter.BranchTargetRecord.toJson(java.lang.StringBuilder)"
  })
  void testToJson2() {
    // Arrange
    ArrayList<String> variables = new ArrayList<>();
    variables.add("{");
    BranchTargetRecord branchTargetRecord = new BranchTargetRecord(variables, new ArrayList<>(), 1);
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualToJsonResult = branchTargetRecord.toJson(builder);

    // Assert
    assertEquals(
        "foo{\"startOffset\":1,\"startStack\":[],\"startVariables\":[\"{\"]}", builder.toString());
    assertSame(builder, actualToJsonResult);
  }

  /**
   * Test {@link BranchTargetRecord#toJson(StringBuilder)}.
   *
   * <p>Method under test: {@link BranchTargetRecord#toJson(StringBuilder)}
   */
  @Test
  @DisplayName("Test toJson(StringBuilder)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.StringBuilder proguard.evaluation.util.jsonprinter.BranchTargetRecord.toJson(java.lang.StringBuilder)"
  })
  void testToJson3() {
    // Arrange
    ArrayList<String> variables = new ArrayList<>();
    variables.add("startOffset");
    variables.add("{");
    BranchTargetRecord branchTargetRecord = new BranchTargetRecord(variables, new ArrayList<>(), 1);
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualToJsonResult = branchTargetRecord.toJson(builder);

    // Assert
    assertEquals(
        "foo{\"startOffset\":1,\"startStack\":[],\"startVariables\":[\"startOffset\",\"{\"]}",
        builder.toString());
    assertSame(builder, actualToJsonResult);
  }
}
