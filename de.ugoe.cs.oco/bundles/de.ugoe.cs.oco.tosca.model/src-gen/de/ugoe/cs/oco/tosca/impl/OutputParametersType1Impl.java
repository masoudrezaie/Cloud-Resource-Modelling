/**
 */
package de.ugoe.cs.oco.tosca.impl;

import de.ugoe.cs.oco.tosca.OutputParametersType1;
import de.ugoe.cs.oco.tosca.TParameter;
import de.ugoe.cs.oco.tosca.ToscaPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Output Parameters Type1</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.ugoe.cs.oco.tosca.impl.OutputParametersType1Impl#getOutputParameter <em>Output Parameter</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OutputParametersType1Impl extends MinimalEObjectImpl.Container implements OutputParametersType1 {
	/**
	 * The cached value of the '{@link #getOutputParameter() <em>Output Parameter</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputParameter()
	 * @generated
	 * @ordered
	 */
	protected EList<TParameter> outputParameter;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OutputParametersType1Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ToscaPackage.Literals.OUTPUT_PARAMETERS_TYPE1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TParameter> getOutputParameter() {
		if (outputParameter == null) {
			outputParameter = new EObjectContainmentEList<TParameter>(TParameter.class, this, ToscaPackage.OUTPUT_PARAMETERS_TYPE1__OUTPUT_PARAMETER);
		}
		return outputParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ToscaPackage.OUTPUT_PARAMETERS_TYPE1__OUTPUT_PARAMETER:
				return ((InternalEList<?>)getOutputParameter()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ToscaPackage.OUTPUT_PARAMETERS_TYPE1__OUTPUT_PARAMETER:
				return getOutputParameter();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ToscaPackage.OUTPUT_PARAMETERS_TYPE1__OUTPUT_PARAMETER:
				getOutputParameter().clear();
				getOutputParameter().addAll((Collection<? extends TParameter>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ToscaPackage.OUTPUT_PARAMETERS_TYPE1__OUTPUT_PARAMETER:
				getOutputParameter().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ToscaPackage.OUTPUT_PARAMETERS_TYPE1__OUTPUT_PARAMETER:
				return outputParameter != null && !outputParameter.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //OutputParametersType1Impl
