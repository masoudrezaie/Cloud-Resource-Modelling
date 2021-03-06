/**
 */
package de.ugoe.cs.oco.tosca.tests;

import de.ugoe.cs.oco.tosca.TOperation;
import de.ugoe.cs.oco.tosca.ToscaFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>TOperation</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class TOperationTest extends TExtensibleElementsTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(TOperationTest.class);
	}

	/**
	 * Constructs a new TOperation test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TOperationTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this TOperation test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected TOperation getFixture() {
		return (TOperation)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ToscaFactory.eINSTANCE.createTOperation());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //TOperationTest
