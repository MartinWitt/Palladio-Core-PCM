/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package LqnCore.tests;

import junit.textui.TestRunner;
import LqnCore.ActivityMakingCallType;
import LqnCore.LqnCoreFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Activity Making Call Type</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ActivityMakingCallTypeTest extends MakingCallTypeTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ActivityMakingCallTypeTest.class);
	}

	/**
	 * Constructs a new Activity Making Call Type test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivityMakingCallTypeTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Activity Making Call Type test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected ActivityMakingCallType getFixture() {
		return (ActivityMakingCallType)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(LqnCoreFactory.eINSTANCE.createActivityMakingCallType());
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

} //ActivityMakingCallTypeTest
