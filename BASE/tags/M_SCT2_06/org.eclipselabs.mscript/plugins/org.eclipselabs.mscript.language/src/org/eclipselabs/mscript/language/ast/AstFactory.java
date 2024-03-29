/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.ast;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipselabs.mscript.language.ast.AstPackage
 * @generated
 */
public interface AstFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AstFactory eINSTANCE = org.eclipselabs.mscript.language.ast.impl.AstFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Module</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Module</em>'.
	 * @generated
	 */
	Module createModule();

	/**
	 * Returns a new object of class '<em>Enumeration Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enumeration Definition</em>'.
	 * @generated
	 */
	EnumerationDefinition createEnumerationDefinition();

	/**
	 * Returns a new object of class '<em>Enumeration Literal Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enumeration Literal Declaration</em>'.
	 * @generated
	 */
	EnumerationLiteralDeclaration createEnumerationLiteralDeclaration();

	/**
	 * Returns a new object of class '<em>Type Alias Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type Alias Definition</em>'.
	 * @generated
	 */
	TypeAliasDefinition createTypeAliasDefinition();

	/**
	 * Returns a new object of class '<em>Record Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Record Definition</em>'.
	 * @generated
	 */
	RecordDefinition createRecordDefinition();

	/**
	 * Returns a new object of class '<em>Record Field Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Record Field Declaration</em>'.
	 * @generated
	 */
	RecordFieldDeclaration createRecordFieldDeclaration();

	/**
	 * Returns a new object of class '<em>Function Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Function Definition</em>'.
	 * @generated
	 */
	FunctionDefinition createFunctionDefinition();

	/**
	 * Returns a new object of class '<em>Check</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Check</em>'.
	 * @generated
	 */
	Check createCheck();

	/**
	 * Returns a new object of class '<em>Template Parameter Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Template Parameter Declaration</em>'.
	 * @generated
	 */
	TemplateParameterDeclaration createTemplateParameterDeclaration();

	/**
	 * Returns a new object of class '<em>Input Parameter Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Input Parameter Declaration</em>'.
	 * @generated
	 */
	InputParameterDeclaration createInputParameterDeclaration();

	/**
	 * Returns a new object of class '<em>Output Parameter Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Output Parameter Declaration</em>'.
	 * @generated
	 */
	OutputParameterDeclaration createOutputParameterDeclaration();

	/**
	 * Returns a new object of class '<em>Assertion</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Assertion</em>'.
	 * @generated
	 */
	Assertion createAssertion();

	/**
	 * Returns a new object of class '<em>State Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>State Variable Declaration</em>'.
	 * @generated
	 */
	StateVariableDeclaration createStateVariableDeclaration();

	/**
	 * Returns a new object of class '<em>Function Object Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Function Object Declaration</em>'.
	 * @generated
	 */
	FunctionObjectDeclaration createFunctionObjectDeclaration();

	/**
	 * Returns a new object of class '<em>Equation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Equation</em>'.
	 * @generated
	 */
	Equation createEquation();

	/**
	 * Returns a new object of class '<em>Data Type Specifier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Type Specifier</em>'.
	 * @generated
	 */
	DataTypeSpecifier createDataTypeSpecifier();

	/**
	 * Returns a new object of class '<em>Let Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Let Expression</em>'.
	 * @generated
	 */
	LetExpression createLetExpression();

	/**
	 * Returns a new object of class '<em>Let Expression Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Let Expression Variable Declaration</em>'.
	 * @generated
	 */
	LetExpressionVariableDeclaration createLetExpressionVariableDeclaration();

	/**
	 * Returns a new object of class '<em>Let Expression Variable Declaration Part</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Let Expression Variable Declaration Part</em>'.
	 * @generated
	 */
	LetExpressionVariableDeclarationPart createLetExpressionVariableDeclarationPart();

	/**
	 * Returns a new object of class '<em>If Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>If Expression</em>'.
	 * @generated
	 */
	IfExpression createIfExpression();

	/**
	 * Returns a new object of class '<em>Switch Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Switch Expression</em>'.
	 * @generated
	 */
	SwitchExpression createSwitchExpression();

	/**
	 * Returns a new object of class '<em>Switch Case</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Switch Case</em>'.
	 * @generated
	 */
	SwitchCase createSwitchCase();

	/**
	 * Returns a new object of class '<em>Array Element Access</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Array Element Access</em>'.
	 * @generated
	 */
	ArrayElementAccess createArrayElementAccess();

	/**
	 * Returns a new object of class '<em>Array Subscript</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Array Subscript</em>'.
	 * @generated
	 */
	ArraySubscript createArraySubscript();

	/**
	 * Returns a new object of class '<em>Iteration Call</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Iteration Call</em>'.
	 * @generated
	 */
	IterationCall createIterationCall();

	/**
	 * Returns a new object of class '<em>Iteration Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Iteration Variable</em>'.
	 * @generated
	 */
	IterationVariable createIterationVariable();

	/**
	 * Returns a new object of class '<em>Iteration Accumulator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Iteration Accumulator</em>'.
	 * @generated
	 */
	IterationAccumulator createIterationAccumulator();

	/**
	 * Returns a new object of class '<em>Derivative Operator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Derivative Operator</em>'.
	 * @generated
	 */
	DerivativeOperator createDerivativeOperator();

	/**
	 * Returns a new object of class '<em>Array Construction Operator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Array Construction Operator</em>'.
	 * @generated
	 */
	ArrayConstructionOperator createArrayConstructionOperator();

	/**
	 * Returns a new object of class '<em>Array Construction Iteration Clause</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Array Construction Iteration Clause</em>'.
	 * @generated
	 */
	ArrayConstructionIterationClause createArrayConstructionIterationClause();

	/**
	 * Returns a new object of class '<em>Array Concatenation Operator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Array Concatenation Operator</em>'.
	 * @generated
	 */
	ArrayConcatenationOperator createArrayConcatenationOperator();

	/**
	 * Returns a new object of class '<em>Expression List</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Expression List</em>'.
	 * @generated
	 */
	ExpressionList createExpressionList();

	/**
	 * Returns a new object of class '<em>Unit Construction Operator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unit Construction Operator</em>'.
	 * @generated
	 */
	UnitConstructionOperator createUnitConstructionOperator();

	/**
	 * Returns a new object of class '<em>Parenthesized Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parenthesized Expression</em>'.
	 * @generated
	 */
	ParenthesizedExpression createParenthesizedExpression();

	/**
	 * Returns a new object of class '<em>End Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>End Expression</em>'.
	 * @generated
	 */
	EndExpression createEndExpression();

	/**
	 * Returns a new object of class '<em>Range Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Range Expression</em>'.
	 * @generated
	 */
	RangeExpression createRangeExpression();

	/**
	 * Returns a new object of class '<em>Implies Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Implies Expression</em>'.
	 * @generated
	 */
	ImpliesExpression createImpliesExpression();

	/**
	 * Returns a new object of class '<em>Logical Or Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Logical Or Expression</em>'.
	 * @generated
	 */
	LogicalOrExpression createLogicalOrExpression();

	/**
	 * Returns a new object of class '<em>Logical And Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Logical And Expression</em>'.
	 * @generated
	 */
	LogicalAndExpression createLogicalAndExpression();

	/**
	 * Returns a new object of class '<em>Equality Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Equality Expression</em>'.
	 * @generated
	 */
	EqualityExpression createEqualityExpression();

	/**
	 * Returns a new object of class '<em>Relational Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Relational Expression</em>'.
	 * @generated
	 */
	RelationalExpression createRelationalExpression();

	/**
	 * Returns a new object of class '<em>Type Test Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type Test Expression</em>'.
	 * @generated
	 */
	TypeTestExpression createTypeTestExpression();

	/**
	 * Returns a new object of class '<em>Additive Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Additive Expression</em>'.
	 * @generated
	 */
	AdditiveExpression createAdditiveExpression();

	/**
	 * Returns a new object of class '<em>Multiplicative Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Multiplicative Expression</em>'.
	 * @generated
	 */
	MultiplicativeExpression createMultiplicativeExpression();

	/**
	 * Returns a new object of class '<em>Power Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Power Expression</em>'.
	 * @generated
	 */
	PowerExpression createPowerExpression();

	/**
	 * Returns a new object of class '<em>Unary Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unary Expression</em>'.
	 * @generated
	 */
	UnaryExpression createUnaryExpression();

	/**
	 * Returns a new object of class '<em>Postfix Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Postfix Expression</em>'.
	 * @generated
	 */
	PostfixExpression createPostfixExpression();

	/**
	 * Returns a new object of class '<em>Variable Access</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variable Access</em>'.
	 * @generated
	 */
	VariableAccess createVariableAccess();

	/**
	 * Returns a new object of class '<em>Range Step Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Range Step Expression</em>'.
	 * @generated
	 */
	RangeStepExpression createRangeStepExpression();

	/**
	 * Returns a new object of class '<em>Additive Step Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Additive Step Expression</em>'.
	 * @generated
	 */
	AdditiveStepExpression createAdditiveStepExpression();

	/**
	 * Returns a new object of class '<em>Negate Step Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Negate Step Expression</em>'.
	 * @generated
	 */
	NegateStepExpression createNegateStepExpression();

	/**
	 * Returns a new object of class '<em>Step Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Step Literal</em>'.
	 * @generated
	 */
	StepLiteral createStepLiteral();

	/**
	 * Returns a new object of class '<em>Step N</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Step N</em>'.
	 * @generated
	 */
	StepN createStepN();

	/**
	 * Returns a new object of class '<em>Function Call</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Function Call</em>'.
	 * @generated
	 */
	FunctionCall createFunctionCall();

	/**
	 * Returns a new object of class '<em>Member Variable Access</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Member Variable Access</em>'.
	 * @generated
	 */
	MemberVariableAccess createMemberVariableAccess();

	/**
	 * Returns a new object of class '<em>Algorithm Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Algorithm Expression</em>'.
	 * @generated
	 */
	AlgorithmExpression createAlgorithmExpression();

	/**
	 * Returns a new object of class '<em>Compound</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Compound</em>'.
	 * @generated
	 */
	Compound createCompound();

	/**
	 * Returns a new object of class '<em>Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Assignment</em>'.
	 * @generated
	 */
	Assignment createAssignment();

	/**
	 * Returns a new object of class '<em>Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variable Declaration</em>'.
	 * @generated
	 */
	VariableDeclaration createVariableDeclaration();

	/**
	 * Returns a new object of class '<em>If Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>If Statement</em>'.
	 * @generated
	 */
	IfStatement createIfStatement();

	/**
	 * Returns a new object of class '<em>While Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>While Statement</em>'.
	 * @generated
	 */
	WhileStatement createWhileStatement();

	/**
	 * Returns a new object of class '<em>Do While Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Do While Statement</em>'.
	 * @generated
	 */
	DoWhileStatement createDoWhileStatement();

	/**
	 * Returns a new object of class '<em>For Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>For Statement</em>'.
	 * @generated
	 */
	ForStatement createForStatement();

	/**
	 * Returns a new object of class '<em>Continue Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Continue Statement</em>'.
	 * @generated
	 */
	ContinueStatement createContinueStatement();

	/**
	 * Returns a new object of class '<em>Break Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Break Statement</em>'.
	 * @generated
	 */
	BreakStatement createBreakStatement();

	/**
	 * Returns a new object of class '<em>Return Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Return Statement</em>'.
	 * @generated
	 */
	ReturnStatement createReturnStatement();

	/**
	 * Returns a new object of class '<em>Builtin Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Builtin Definition</em>'.
	 * @generated
	 */
	BuiltinDefinition createBuiltinDefinition();

	/**
	 * Returns a new object of class '<em>Builtin Function</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Builtin Function</em>'.
	 * @generated
	 */
	BuiltinFunction createBuiltinFunction();

	/**
	 * Returns a new object of class '<em>Builtin Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Builtin Variable</em>'.
	 * @generated
	 */
	BuiltinVariable createBuiltinVariable();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	AstPackage getAstPackage();

} //AstFactory
