/**
 */
package de.ugoe.cs.oco.tosca.impl;

import de.ugoe.cs.oco.tosca.PropertyConstraintsType1;
import de.ugoe.cs.oco.tosca.TPropertyConstraint;
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
 * An implementation of the model object '<em><b>Property Constraints Type1</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.ugoe.cs.oco.tosca.impl.PropertyConstraintsType1Impl#getPropertyConstraint <em>Property Constraint</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PropertyConstraintsType1Impl extends MinimalEObjectImpl.Container implements PropertyConstraintsType1 {
	/**
	 * The cached value of the '{@link #getPropertyConstraint() <em>Property Constraint</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyConstraint()
	 * @generated
	 * @ordered
	 */
	protected EList<TPropertyConstraint> propertyConstraint;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertyConstraintsType1Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ToscaPackage.Literals.PROPERTY_CONSTRAINTS_TYPE1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TPropertyConstraint> getPropertyConstraint() {
		if (propertyConstraint == null) {
			propertyConstraint = new EObjectContainmentEList<TPropertyConstraint>(TPropertyConstraint.class, this, ToscaPackage.PROPERTY_CONSTRAINTS_TYPE1__PROPERTY_CONSTRAINT);
		}
		return propertyConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ToscaPackage.PROPERTY_CONSTRAINTS_TYPE1__PROPERTY_CONSTRAINT:
				return ((InternalEList<?>)getPropertyConstraint()).basicRemove(otherEnd, msgs);
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
			case ToscaPackage.PROPERTY_CONSTRAINTS_TYPE1__PROPERTY_CONSTRAINT:
				return getPropertyConstraint();
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
			case ToscaPackage.PROPERTY_CONSTRAINTS_TYPE1__PROPERTY_CONSTRAINT:
				getPropertyConstraint().clear();
				getPropertyConstraint().addAll((Collection<? extends TPropertyConstraint>)newValue);
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
			case ToscaPackage.PROPERTY_CONSTRAINTS_TYPE1__PROPERTY_CONSTRAINT:
				getPropertyConstraint().clear();
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
			case ToscaPackage.PROPERTY_CONSTRAINTS_TYPE1__PROPERTY_CONSTRAINT:
				return propertyConstraint != null && !propertyConstraint.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //PropertyConstraintsType1Impl
