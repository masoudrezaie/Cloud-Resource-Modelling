/**
 */
package de.ugoe.cs.oco.tosca.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>tosca</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class ToscaTests extends TestSuite {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(suite());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Test suite() {
		TestSuite suite = new ToscaTests("tosca Tests");
		suite.addTestSuite(DefinitionsTypeTest.class);
		suite.addTestSuite(DocumentRootTest.class);
		suite.addTestSuite(TArtifactReferenceTest.class);
		suite.addTestSuite(TDefinitionsTest.class);
		suite.addTestSuite(TDocumentationTest.class);
		suite.addTestSuite(TTopologyTemplateTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ToscaTests(String name) {
		super(name);
	}

} //ToscaTests