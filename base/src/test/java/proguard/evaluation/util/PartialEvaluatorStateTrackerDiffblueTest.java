package proguard.evaluation.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.attribute.CodeAttribute;
import proguard.evaluation.Variables;
import proguard.evaluation.util.jsonprinter.JsonPrinter;

class PartialEvaluatorStateTrackerDiffblueTest {
  /**
   * Test {@link PartialEvaluatorStateTracker#startCodeAttribute(Clazz, Method, CodeAttribute,
   * Variables)}.
   *
   * <p>Method under test: {@link PartialEvaluatorStateTracker#startCodeAttribute(Clazz, Method,
   * CodeAttribute, Variables)}
   */
  @Test
  @DisplayName("Test startCodeAttribute(Clazz, Method, CodeAttribute, Variables)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PartialEvaluatorStateTracker.startCodeAttribute(Clazz, Method, CodeAttribute, Variables)"
  })
  void testStartCodeAttribute() {
    // Arrange
    JsonPrinter jsonPrinter = new JsonPrinter();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");
    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    jsonPrinter.startCodeAttribute(clazz, method, codeAttribute, new Variables(3));

    // Assert
    assertEquals(
        "{\"codeAttributes\":[{\"clazz\":\"null\",\"method\":\"NameDescriptor\",\"instructions\":[],\"parameters\":[\"empty\""
            + ",\"empty\",\"empty\"],\"blockEvaluations\":[]}]}",
        jsonPrinter.getJson());
  }
}
