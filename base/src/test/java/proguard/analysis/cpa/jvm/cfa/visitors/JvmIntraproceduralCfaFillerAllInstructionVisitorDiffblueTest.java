package proguard.analysis.cpa.jvm.cfa.visitors;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.analysis.cpa.jvm.cfa.JvmCfa;
import proguard.analysis.cpa.jvm.cfa.edges.JvmAssumeExceptionCfaEdge;
import proguard.analysis.cpa.jvm.cfa.edges.JvmCfaEdge;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmCatchCfaNode;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmCfaNode;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmUnknownCfaNode;
import proguard.classfile.ClassConstants;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.MethodSignature;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.instruction.visitor.InstructionVisitor;

class JvmIntraproceduralCfaFillerAllInstructionVisitorDiffblueTest {
  /**
   * Test {@link JvmIntraproceduralCfaFillerAllInstructionVisitor#visitCodeAttribute(Clazz, Method,
   * CodeAttribute)}.
   *
   * <p>Method under test: {@link
   * JvmIntraproceduralCfaFillerAllInstructionVisitor#visitCodeAttribute(Clazz, Method,
   * CodeAttribute)}
   */
  @Test
  @DisplayName("Test visitCodeAttribute(Clazz, Method, CodeAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.cfa.visitors.JvmIntraproceduralCfaFillerAllInstructionVisitor.visitCodeAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute)"
  })
  void testVisitCodeAttribute() {
    // Arrange
    ArrayList<JvmCatchCfaNode> jvmCatchCfaNodeList = new ArrayList<>();
    jvmCatchCfaNodeList.add(
        new JvmCatchCfaNode(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 2, 1, new LibraryClass()));
    JvmCfa cfa = mock(JvmCfa.class);
    when(cfa.getFunctionCatchNodes(Mockito.<MethodSignature>any())).thenReturn(jvmCatchCfaNodeList);
    JvmIntraproceduralCfaFillerAllInstructionVisitor
        jvmIntraproceduralCfaFillerAllInstructionVisitor =
            new JvmIntraproceduralCfaFillerAllInstructionVisitor(cfa);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod();

    // Act
    jvmIntraproceduralCfaFillerAllInstructionVisitor.visitCodeAttribute(
        clazz, method, new CodeAttribute(1));

    // Assert
    verify(cfa).getFunctionCatchNodes(isA(MethodSignature.class));
  }

  /**
   * Test {@link JvmIntraproceduralCfaFillerAllInstructionVisitor#visitCodeAttribute(Clazz, Method,
   * CodeAttribute)}.
   *
   * <p>Method under test: {@link
   * JvmIntraproceduralCfaFillerAllInstructionVisitor#visitCodeAttribute(Clazz, Method,
   * CodeAttribute)}
   */
  @Test
  @DisplayName("Test visitCodeAttribute(Clazz, Method, CodeAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.cfa.visitors.JvmIntraproceduralCfaFillerAllInstructionVisitor.visitCodeAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute)"
  })
  void testVisitCodeAttribute2() {
    // Arrange
    JvmCatchCfaNode jvmCatchCfaNode = mock(JvmCatchCfaNode.class);
    doNothing().when(jvmCatchCfaNode).addLeavingEdge(Mockito.<JvmCfaEdge>any());
    JvmCfa cfa = mock(JvmCfa.class);
    when(cfa.addNodeIfAbsent(Mockito.<MethodSignature>any(), anyInt(), Mockito.<Clazz>any()))
        .thenReturn(jvmCatchCfaNode);
    when(cfa.getFunctionCatchNodes(Mockito.<MethodSignature>any())).thenReturn(new ArrayList<>());
    JvmIntraproceduralCfaFillerAllInstructionVisitor
        jvmIntraproceduralCfaFillerAllInstructionVisitor =
            new JvmIntraproceduralCfaFillerAllInstructionVisitor(cfa);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod();

    // Act
    jvmIntraproceduralCfaFillerAllInstructionVisitor.visitCodeAttribute(
        clazz,
        method,
        new CodeAttribute(1, 3, 3, 3, new byte[] {-87, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));

    // Assert
    verify(cfa, atLeast(1)).addNodeIfAbsent(isA(MethodSignature.class), anyInt(), isA(Clazz.class));
    verify(cfa).getFunctionCatchNodes(isA(MethodSignature.class));
    verify(jvmCatchCfaNode, atLeast(1)).addLeavingEdge(Mockito.<JvmCfaEdge>any());
  }

  /**
   * Test {@link JvmIntraproceduralCfaFillerAllInstructionVisitor#visitCodeAttribute(Clazz, Method,
   * CodeAttribute)}.
   *
   * <p>Method under test: {@link
   * JvmIntraproceduralCfaFillerAllInstructionVisitor#visitCodeAttribute(Clazz, Method,
   * CodeAttribute)}
   */
  @Test
  @DisplayName("Test visitCodeAttribute(Clazz, Method, CodeAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.cfa.visitors.JvmIntraproceduralCfaFillerAllInstructionVisitor.visitCodeAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute)"
  })
  void testVisitCodeAttribute3() {
    // Arrange
    JvmCatchCfaNode jvmCatchCfaNode = mock(JvmCatchCfaNode.class);
    doNothing().when(jvmCatchCfaNode).addEnteringEdge(Mockito.<JvmCfaEdge>any());
    doNothing().when(jvmCatchCfaNode).addLeavingEdge(Mockito.<JvmCfaEdge>any());
    JvmCfa cfa = mock(JvmCfa.class);
    when(cfa.addNodeIfAbsent(Mockito.<MethodSignature>any(), anyInt(), Mockito.<Clazz>any()))
        .thenReturn(jvmCatchCfaNode);
    when(cfa.getFunctionCatchNodes(Mockito.<MethodSignature>any())).thenReturn(new ArrayList<>());
    JvmIntraproceduralCfaFillerAllInstructionVisitor
        jvmIntraproceduralCfaFillerAllInstructionVisitor =
            new JvmIntraproceduralCfaFillerAllInstructionVisitor(cfa);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod();

    // Act
    jvmIntraproceduralCfaFillerAllInstructionVisitor.visitCodeAttribute(
        clazz,
        method,
        new CodeAttribute(1, 3, 3, 3, new byte[] {'A', -87, 'A', 'X', 'A', 'X', 'A', 'X'}));

    // Assert
    verify(cfa, atLeast(1)).addNodeIfAbsent(isA(MethodSignature.class), anyInt(), isA(Clazz.class));
    verify(cfa).getFunctionCatchNodes(isA(MethodSignature.class));
    verify(jvmCatchCfaNode).addEnteringEdge(isA(JvmCfaEdge.class));
    verify(jvmCatchCfaNode, atLeast(1)).addLeavingEdge(Mockito.<JvmCfaEdge>any());
  }

  /**
   * Test {@link JvmIntraproceduralCfaFillerAllInstructionVisitor#visitCodeAttribute(Clazz, Method,
   * CodeAttribute)}.
   *
   * <ul>
   *   <li>Given {@link JvmCatchCfaNode} {@link JvmCatchCfaNode#getCatchType()} return zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * JvmIntraproceduralCfaFillerAllInstructionVisitor#visitCodeAttribute(Clazz, Method,
   * CodeAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitCodeAttribute(Clazz, Method, CodeAttribute); given JvmCatchCfaNode getCatchType() return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.cfa.visitors.JvmIntraproceduralCfaFillerAllInstructionVisitor.visitCodeAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute)"
  })
  void testVisitCodeAttribute_givenJvmCatchCfaNodeGetCatchTypeReturnZero() {
    // Arrange
    ArrayList<JvmCfaEdge> jvmCfaEdgeList = new ArrayList<>();
    jvmCfaEdgeList.add(new JvmAssumeExceptionCfaEdge(true, 1));
    JvmCatchCfaNode jvmCatchCfaNode = mock(JvmCatchCfaNode.class);
    when(jvmCatchCfaNode.getCatchType()).thenReturn(0);
    when(jvmCatchCfaNode.getLeavingEdges()).thenReturn(jvmCfaEdgeList);

    ArrayList<JvmCatchCfaNode> jvmCatchCfaNodeList = new ArrayList<>();
    jvmCatchCfaNodeList.add(jvmCatchCfaNode);
    JvmCfa cfa = mock(JvmCfa.class);
    when(cfa.getFunctionCatchNodes(Mockito.<MethodSignature>any())).thenReturn(jvmCatchCfaNodeList);
    JvmIntraproceduralCfaFillerAllInstructionVisitor
        jvmIntraproceduralCfaFillerAllInstructionVisitor =
            new JvmIntraproceduralCfaFillerAllInstructionVisitor(cfa);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod();
    CodeAttribute codeAttribute = mock(CodeAttribute.class);
    doNothing()
        .when(codeAttribute)
        .instructionsAccept(
            Mockito.<Clazz>any(), Mockito.<Method>any(), Mockito.<InstructionVisitor>any());

    // Act
    jvmIntraproceduralCfaFillerAllInstructionVisitor.visitCodeAttribute(
        clazz, method, codeAttribute);

    // Assert
    verify(cfa).getFunctionCatchNodes(isA(MethodSignature.class));
    verify(jvmCatchCfaNode).getCatchType();
    verify(jvmCatchCfaNode).getLeavingEdges();
    verify(codeAttribute)
        .instructionsAccept(isA(Clazz.class), isA(Method.class), isA(InstructionVisitor.class));
  }

  /**
   * Test {@link JvmIntraproceduralCfaFillerAllInstructionVisitor#visitCodeAttribute(Clazz, Method,
   * CodeAttribute)}.
   *
   * <ul>
   *   <li>Given {@link JvmCfa} {@link JvmCfa#addNodeIfAbsent(MethodSignature, int, Clazz)} return
   *       {@link JvmUnknownCfaNode#INSTANCE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JvmIntraproceduralCfaFillerAllInstructionVisitor#visitCodeAttribute(Clazz, Method,
   * CodeAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitCodeAttribute(Clazz, Method, CodeAttribute); given JvmCfa addNodeIfAbsent(MethodSignature, int, Clazz) return INSTANCE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.cfa.visitors.JvmIntraproceduralCfaFillerAllInstructionVisitor.visitCodeAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute)"
  })
  void testVisitCodeAttribute_givenJvmCfaAddNodeIfAbsentReturnInstance()
      throws UnsupportedEncodingException {
    // Arrange
    JvmCfa cfa = mock(JvmCfa.class);
    when(cfa.addNodeIfAbsent(Mockito.<MethodSignature>any(), anyInt(), Mockito.<Clazz>any()))
        .thenReturn(JvmUnknownCfaNode.INSTANCE);
    when(cfa.getFunctionCatchNodes(Mockito.<MethodSignature>any())).thenReturn(new ArrayList<>());
    JvmIntraproceduralCfaFillerAllInstructionVisitor
        jvmIntraproceduralCfaFillerAllInstructionVisitor =
            new JvmIntraproceduralCfaFillerAllInstructionVisitor(cfa);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod();

    // Act
    jvmIntraproceduralCfaFillerAllInstructionVisitor.visitCodeAttribute(
        clazz, method, new CodeAttribute(1, 3, 3, 3, "AXAXAXAX".getBytes("UTF-8")));

    // Assert
    verify(cfa, atLeast(1)).addNodeIfAbsent(isA(MethodSignature.class), anyInt(), isA(Clazz.class));
    verify(cfa).getFunctionCatchNodes(isA(MethodSignature.class));
  }

  /**
   * Test {@link JvmIntraproceduralCfaFillerAllInstructionVisitor#visitCodeAttribute(Clazz, Method,
   * CodeAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link JvmCfaNode#addEnteringEdge(JvmCfaEdge)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JvmIntraproceduralCfaFillerAllInstructionVisitor#visitCodeAttribute(Clazz, Method,
   * CodeAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitCodeAttribute(Clazz, Method, CodeAttribute); then calls addEnteringEdge(JvmCfaEdge)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.cfa.visitors.JvmIntraproceduralCfaFillerAllInstructionVisitor.visitCodeAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute)"
  })
  void testVisitCodeAttribute_thenCallsAddEnteringEdge() throws UnsupportedEncodingException {
    // Arrange
    JvmCatchCfaNode jvmCatchCfaNode = mock(JvmCatchCfaNode.class);
    doNothing().when(jvmCatchCfaNode).addEnteringEdge(Mockito.<JvmCfaEdge>any());
    doNothing().when(jvmCatchCfaNode).addLeavingEdge(Mockito.<JvmCfaEdge>any());
    JvmCfa cfa = mock(JvmCfa.class);
    when(cfa.addNodeIfAbsent(Mockito.<MethodSignature>any(), anyInt(), Mockito.<Clazz>any()))
        .thenReturn(jvmCatchCfaNode);
    when(cfa.getFunctionCatchNodes(Mockito.<MethodSignature>any())).thenReturn(new ArrayList<>());
    JvmIntraproceduralCfaFillerAllInstructionVisitor
        jvmIntraproceduralCfaFillerAllInstructionVisitor =
            new JvmIntraproceduralCfaFillerAllInstructionVisitor(cfa);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod();

    // Act
    jvmIntraproceduralCfaFillerAllInstructionVisitor.visitCodeAttribute(
        clazz, method, new CodeAttribute(1, 3, 3, 3, "AXAXAXAX".getBytes("UTF-8")));

    // Assert
    verify(cfa, atLeast(1)).addNodeIfAbsent(isA(MethodSignature.class), anyInt(), isA(Clazz.class));
    verify(cfa).getFunctionCatchNodes(isA(MethodSignature.class));
    verify(jvmCatchCfaNode, atLeast(1)).addEnteringEdge(Mockito.<JvmCfaEdge>any());
    verify(jvmCatchCfaNode, atLeast(1)).addLeavingEdge(Mockito.<JvmCfaEdge>any());
  }

  /**
   * Test {@link JvmIntraproceduralCfaFillerAllInstructionVisitor#visitCodeAttribute(Clazz, Method,
   * CodeAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link JvmCfa#getFunctionExceptionExitNode(MethodSignature, Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JvmIntraproceduralCfaFillerAllInstructionVisitor#visitCodeAttribute(Clazz, Method,
   * CodeAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitCodeAttribute(Clazz, Method, CodeAttribute); then calls getFunctionExceptionExitNode(MethodSignature, Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.cfa.visitors.JvmIntraproceduralCfaFillerAllInstructionVisitor.visitCodeAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute)"
  })
  void testVisitCodeAttribute_thenCallsGetFunctionExceptionExitNode() {
    // Arrange
    ArrayList<JvmCfaEdge> jvmCfaEdgeList = new ArrayList<>();
    jvmCfaEdgeList.add(new JvmAssumeExceptionCfaEdge(true, 1));
    JvmCatchCfaNode jvmCatchCfaNode = mock(JvmCatchCfaNode.class);
    doNothing().when(jvmCatchCfaNode).addLeavingEdge(Mockito.<JvmCfaEdge>any());
    when(jvmCatchCfaNode.getCatchType()).thenReturn(1);
    when(jvmCatchCfaNode.getLeavingEdges()).thenReturn(jvmCfaEdgeList);

    ArrayList<JvmCatchCfaNode> jvmCatchCfaNodeList = new ArrayList<>();
    jvmCatchCfaNodeList.add(jvmCatchCfaNode);
    JvmCfa cfa = mock(JvmCfa.class);
    when(cfa.getFunctionExceptionExitNode(Mockito.<MethodSignature>any(), Mockito.<Clazz>any()))
        .thenReturn(JvmUnknownCfaNode.INSTANCE);
    when(cfa.getFunctionCatchNodes(Mockito.<MethodSignature>any())).thenReturn(jvmCatchCfaNodeList);
    JvmIntraproceduralCfaFillerAllInstructionVisitor
        jvmIntraproceduralCfaFillerAllInstructionVisitor =
            new JvmIntraproceduralCfaFillerAllInstructionVisitor(cfa);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod();
    CodeAttribute codeAttribute = mock(CodeAttribute.class);
    doNothing()
        .when(codeAttribute)
        .instructionsAccept(
            Mockito.<Clazz>any(), Mockito.<Method>any(), Mockito.<InstructionVisitor>any());

    // Act
    jvmIntraproceduralCfaFillerAllInstructionVisitor.visitCodeAttribute(
        clazz, method, codeAttribute);

    // Assert
    verify(cfa).getFunctionCatchNodes(isA(MethodSignature.class));
    verify(cfa).getFunctionExceptionExitNode(isA(MethodSignature.class), isA(Clazz.class));
    verify(jvmCatchCfaNode, atLeast(1)).getCatchType();
    verify(jvmCatchCfaNode).addLeavingEdge(isA(JvmCfaEdge.class));
    verify(jvmCatchCfaNode).getLeavingEdges();
    verify(codeAttribute)
        .instructionsAccept(isA(Clazz.class), isA(Method.class), isA(InstructionVisitor.class));
  }

  /**
   * Test {@link JvmIntraproceduralCfaFillerAllInstructionVisitor#visitCodeAttribute(Clazz, Method,
   * CodeAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link JvmCfaNode#getLeavingEdges()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JvmIntraproceduralCfaFillerAllInstructionVisitor#visitCodeAttribute(Clazz, Method,
   * CodeAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitCodeAttribute(Clazz, Method, CodeAttribute); then calls getLeavingEdges()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.cfa.visitors.JvmIntraproceduralCfaFillerAllInstructionVisitor.visitCodeAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute)"
  })
  void testVisitCodeAttribute_thenCallsGetLeavingEdges() {
    // Arrange
    JvmCatchCfaNode jvmCatchCfaNode = mock(JvmCatchCfaNode.class);
    when(jvmCatchCfaNode.getLeavingEdges()).thenReturn(new ArrayList<>());

    ArrayList<JvmCatchCfaNode> jvmCatchCfaNodeList = new ArrayList<>();
    jvmCatchCfaNodeList.add(jvmCatchCfaNode);
    JvmCfa cfa = mock(JvmCfa.class);
    when(cfa.getFunctionCatchNodes(Mockito.<MethodSignature>any())).thenReturn(jvmCatchCfaNodeList);
    JvmIntraproceduralCfaFillerAllInstructionVisitor
        jvmIntraproceduralCfaFillerAllInstructionVisitor =
            new JvmIntraproceduralCfaFillerAllInstructionVisitor(cfa);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod();
    CodeAttribute codeAttribute = mock(CodeAttribute.class);
    doNothing()
        .when(codeAttribute)
        .instructionsAccept(
            Mockito.<Clazz>any(), Mockito.<Method>any(), Mockito.<InstructionVisitor>any());

    // Act
    jvmIntraproceduralCfaFillerAllInstructionVisitor.visitCodeAttribute(
        clazz, method, codeAttribute);

    // Assert
    verify(cfa).getFunctionCatchNodes(isA(MethodSignature.class));
    verify(jvmCatchCfaNode).getLeavingEdges();
    verify(codeAttribute)
        .instructionsAccept(isA(Clazz.class), isA(Method.class), isA(InstructionVisitor.class));
  }

  /**
   * Test {@link JvmIntraproceduralCfaFillerAllInstructionVisitor#visitCodeAttribute(Clazz, Method,
   * CodeAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link CodeAttribute#instructionsAccept(Clazz, Method, InstructionVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JvmIntraproceduralCfaFillerAllInstructionVisitor#visitCodeAttribute(Clazz, Method,
   * CodeAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitCodeAttribute(Clazz, Method, CodeAttribute); then calls instructionsAccept(Clazz, Method, InstructionVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.cfa.visitors.JvmIntraproceduralCfaFillerAllInstructionVisitor.visitCodeAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute)"
  })
  void testVisitCodeAttribute_thenCallsInstructionsAccept() {
    // Arrange
    JvmCfa cfa = mock(JvmCfa.class);
    when(cfa.getFunctionCatchNodes(Mockito.<MethodSignature>any())).thenReturn(new ArrayList<>());
    JvmIntraproceduralCfaFillerAllInstructionVisitor
        jvmIntraproceduralCfaFillerAllInstructionVisitor =
            new JvmIntraproceduralCfaFillerAllInstructionVisitor(cfa);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod();
    CodeAttribute codeAttribute = mock(CodeAttribute.class);
    doNothing()
        .when(codeAttribute)
        .instructionsAccept(
            Mockito.<Clazz>any(), Mockito.<Method>any(), Mockito.<InstructionVisitor>any());

    // Act
    jvmIntraproceduralCfaFillerAllInstructionVisitor.visitCodeAttribute(
        clazz, method, codeAttribute);

    // Assert
    verify(cfa).getFunctionCatchNodes(isA(MethodSignature.class));
    verify(codeAttribute)
        .instructionsAccept(isA(Clazz.class), isA(Method.class), isA(InstructionVisitor.class));
  }

  /**
   * Test {@link JvmIntraproceduralCfaFillerAllInstructionVisitor#visitCodeAttribute(Clazz, Method,
   * CodeAttribute)}.
   *
   * <ul>
   *   <li>When {@link CodeAttribute#CodeAttribute(int)} with u2attributeNameIndex is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * JvmIntraproceduralCfaFillerAllInstructionVisitor#visitCodeAttribute(Clazz, Method,
   * CodeAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitCodeAttribute(Clazz, Method, CodeAttribute); when CodeAttribute(int) with u2attributeNameIndex is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.cfa.visitors.JvmIntraproceduralCfaFillerAllInstructionVisitor.visitCodeAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute)"
  })
  void testVisitCodeAttribute_whenCodeAttributeWithU2attributeNameIndexIsOne() {
    // Arrange
    JvmCfa cfa = mock(JvmCfa.class);
    when(cfa.getFunctionCatchNodes(Mockito.<MethodSignature>any())).thenReturn(new ArrayList<>());
    JvmIntraproceduralCfaFillerAllInstructionVisitor
        jvmIntraproceduralCfaFillerAllInstructionVisitor =
            new JvmIntraproceduralCfaFillerAllInstructionVisitor(cfa);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod();

    // Act
    jvmIntraproceduralCfaFillerAllInstructionVisitor.visitCodeAttribute(
        clazz, method, new CodeAttribute(1));

    // Assert
    verify(cfa).getFunctionCatchNodes(isA(MethodSignature.class));
  }

  /**
   * Test {@link JvmIntraproceduralCfaFillerAllInstructionVisitor#visitCodeAttribute(Clazz, Method,
   * CodeAttribute)}.
   *
   * <ul>
   *   <li>When {@link CodeAttribute#CodeAttribute()}.
   *   <li>Then calls {@link JvmCfa#getFunctionCatchNodes(MethodSignature)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JvmIntraproceduralCfaFillerAllInstructionVisitor#visitCodeAttribute(Clazz, Method,
   * CodeAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitCodeAttribute(Clazz, Method, CodeAttribute); when CodeAttribute(); then calls getFunctionCatchNodes(MethodSignature)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.cfa.visitors.JvmIntraproceduralCfaFillerAllInstructionVisitor.visitCodeAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute)"
  })
  void testVisitCodeAttribute_whenCodeAttribute_thenCallsGetFunctionCatchNodes() {
    // Arrange
    JvmCfa cfa = mock(JvmCfa.class);
    when(cfa.getFunctionCatchNodes(Mockito.<MethodSignature>any())).thenReturn(new ArrayList<>());
    JvmIntraproceduralCfaFillerAllInstructionVisitor
        jvmIntraproceduralCfaFillerAllInstructionVisitor =
            new JvmIntraproceduralCfaFillerAllInstructionVisitor(cfa);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod();

    // Act
    jvmIntraproceduralCfaFillerAllInstructionVisitor.visitCodeAttribute(
        clazz, method, new CodeAttribute());

    // Assert
    verify(cfa).getFunctionCatchNodes(isA(MethodSignature.class));
  }
}
