/**
 */
package de.ugoe.cs.oco.tosca.impl;

import de.ugoe.cs.oco.tosca.CapabilityDefinitionsType1;
import de.ugoe.cs.oco.tosca.InterfacesType;
import de.ugoe.cs.oco.tosca.RequirementDefinitionsType1;
import de.ugoe.cs.oco.tosca.TNodeType;
import de.ugoe.cs.oco.tosca.TTopologyElementInstanceStates;
import de.ugoe.cs.oco.tosca.ToscaPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TNode Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.ugoe.cs.oco.tosca.impl.TNodeTypeImpl#getRequirementDefinitions <em>Requirement Definitions</em>}</li>
 *   <li>{@link de.ugoe.cs.oco.tosca.impl.TNodeTypeImpl#getCapabilityDefinitions <em>Capability Definitions</em>}</li>
 *   <li>{@link de.ugoe.cs.oco.tosca.impl.TNodeTypeImpl#getInstanceStates <em>Instance States</em>}</li>
 *   <li>{@link de.ugoe.cs.oco.tosca.impl.TNodeTypeImpl#getInterfaces <em>Interfaces</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TNodeTypeImpl extends TEntityTypeImpl implements TNodeType {
	/**
	 * The cached value of the '{@link #getRequirementDefinitions() <em>Requirement Definitions</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequirementDefinitions()
	 * @generated
	 * @ordered
	 */
	protected RequirementDefinitionsType1 requirementDefinitions;

	/**
	 * The cached value of the '{@link #getCapabilityDefinitions() <em>Capability Definitions</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCapabilityDefinitions()
	 * @generated
	 * @ordered
	 */
	protected CapabilityDefinitionsType1 capabilityDefinitions;

	/**
	 * The cached value of the '{@link #getInstanceStates() <em>Instance States</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstanceStates()
	 * @generated
	 * @ordered
	 */
	protected TTopologyElementInstanceStates instanceStates;

	/**
	 * The cached value of the '{@link #getInterfaces() <em>Interfaces</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterfaces()
	 * @generated
	 * @ordered
	 */
	protected InterfacesType interfaces;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TNodeTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ToscaPackage.Literals.TNODE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequirementDefinitionsType1 getRequirementDefinitions() {
		return requirementDefinitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRequirementDefinitions(RequirementDefinitionsType1 newRequirementDefinitions, NotificationChain msgs) {
		RequirementDefinitionsType1 oldRequirementDefinitions = requirementDefinitions;
		requirementDefinitions = newRequirementDefinitions;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ToscaPackage.TNODE_TYPE__REQUIREMENT_DEFINITIONS, oldRequirementDefinitions, newRequirementDefinitions);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequirementDefinitions(RequirementDefinitionsType1 newRequirementDefinitions) {
		if (newRequirementDefinitions != requirementDefinitions) {
			NotificationChain msgs = null;
			if (requirementDefinitions != null)
				msgs = ((InternalEObject)requirementDefinitions).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ToscaPackage.TNODE_TYPE__REQUIREMENT_DEFINITIONS, null, msgs);
			if (newRequirementDefinitions != null)
				msgs = ((InternalEObject)newRequirementDefinitions).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ToscaPackage.TNODE_TYPE__REQUIREMENT_DEFINITIONS, null, msgs);
			msgs = basicSetRequirementDefinitions(newRequirementDefinitions, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ToscaPackage.TNODE_TYPE__REQUIREMENT_DEFINITIONS, newRequirementDefinitions, newRequirementDefinitions));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CapabilityDefinitionsType1 getCapabilityDefinitions() {
		return capabilityDefinitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityDefinitions(CapabilityDefinitionsType1 newCapabilityDefinitions, NotificationChain msgs) {
		CapabilityDefinitionsType1 oldCapabilityDefinitions = capabilityDefinitions;
		capabilityDefinitions = newCapabilityDefinitions;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ToscaPackage.TNODE_TYPE__CAPABILITY_DEFINITIONS, oldCapabilityDefinitions, newCapabilityDefinitions);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityDefinitions(CapabilityDefinitionsType1 newCapabilityDefinitions) {
		if (newCapabilityDefinitions != capabilityDefinitions) {
			NotificationChain msgs = null;
			if (capabilityDefinitions != null)
				msgs = ((InternalEObject)capabilityDefinitions).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ToscaPackage.TNODE_TYPE__CAPABILITY_DEFINITIONS, null, msgs);
			if (newCapabilityDefinitions != null)
				msgs = ((InternalEObject)newCapabilityDefinitions).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ToscaPackage.TNODE_TYPE__CAPABILITY_DEFINITIONS, null, msgs);
			msgs = basicSetCapabilityDefinitions(newCapabilityDefinitions, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ToscaPackage.TNODE_TYPE__CAPABILITY_DEFINITIONS, newCapabilityDefinitions, newCapabilityDefinitions));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TTopologyElementInstanceStates getInstanceStates() {
		return instanceStates;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInstanceStates(TTopologyElementInstanceStates newInstanceStates, NotificationChain msgs) {
		TTopologyElementInstanceStates oldInstanceStates = instanceStates;
		instanceStates = newInstanceStates;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ToscaPackage.TNODE_TYPE__INSTANCE_STATES, oldInstanceStates, newInstanceStates);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstanceStates(TTopologyElementInstanceStates newInstanceStates) {
		if (newInstanceStates != instanceStates) {
			NotificationChain msgs = null;
			if (instanceStates != null)
				msgs = ((InternalEObject)instanceStates).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ToscaPackage.TNODE_TYPE__INSTANCE_STATES, null, msgs);
			if (newInstanceStates != null)
				msgs = ((InternalEObject)newInstanceStates).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ToscaPackage.TNODE_TYPE__INSTANCE_STATES, null, msgs);
			msgs = basicSetInstanceStates(newInstanceStates, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ToscaPackage.TNODE_TYPE__INSTANCE_STATES, newInstanceStates, newInstanceStates));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InterfacesType getInterfaces() {
		return interfaces;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInterfaces(InterfacesType newInterfaces, NotificationChain msgs) {
		InterfacesType oldInterfaces = interfaces;
		interfaces = newInterfaces;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ToscaPackage.TNODE_TYPE__INTERFACES, oldInterfaces, newInterfaces);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInterfaces(InterfacesType newInterfaces) {
		if (newInterfaces != interfaces) {
			NotificationChain msgs = null;
			if (interfaces != null)
				msgs = ((InternalEObject)interfaces).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ToscaPackage.TNODE_TYPE__INTERFACES, null, msgs);
			if (newInterfaces != null)
				msgs = ((InternalEObject)newInterfaces).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ToscaPackage.TNODE_TYPE__INTERFACES, null, msgs);
			msgs = basicSetInterfaces(newInterfaces, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ToscaPackage.TNODE_TYPE__INTERFACES, newInterfaces, newInterfaces));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ToscaPackage.TNODE_TYPE__REQUIREMENT_DEFINITIONS:
				return basicSetRequirementDefinitions(null, msgs);
			case ToscaPackage.TNODE_TYPE__CAPABILITY_DEFINITIONS:
				return basicSetCapabilityDefinitions(null, msgs);
			case ToscaPackage.TNODE_TYPE__INSTANCE_STATES:
				return basicSetInstanceStates(null, msgs);
			case ToscaPackage.TNODE_TYPE__INTERFACES:
				return basicSetInterfaces(null, msgs);
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
			case ToscaPackage.TNODE_TYPE__REQUIREMENT_DEFINITIONS:
				return getRequirementDefinitions();
			case ToscaPackage.TNODE_TYPE__CAPABILITY_DEFINITIONS:
				return getCapabilityDefinitions();
			case ToscaPackage.TNODE_TYPE__INSTANCE_STATES:
				return getInstanceStates();
			case ToscaPackage.TNODE_TYPE__INTERFACES:
				return getInterfaces();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ToscaPackage.TNODE_TYPE__REQUIREMENT_DEFINITIONS:
				setRequirementDefinitions((RequirementDefinitionsType1)newValue);
				return;
			case ToscaPackage.TNODE_TYPE__CAPABILITY_DEFINITIONS:
				setCapabilityDefinitions((CapabilityDefinitionsType1)newValue);
				return;
			case ToscaPackage.TNODE_TYPE__INSTANCE_STATES:
				setInstanceStates((TTopologyElementInstanceStates)newValue);
				return;
			case ToscaPackage.TNODE_TYPE__INTERFACES:
				setInterfaces((InterfacesType)newValue);
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
			case ToscaPackage.TNODE_TYPE__REQUIREMENT_DEFINITIONS:
				setRequirementDefinitions((RequirementDefinitionsType1)null);
				return;
			case ToscaPackage.TNODE_TYPE__CAPABILITY_DEFINITIONS:
				setCapabilityDefinitions((CapabilityDefinitionsType1)null);
				return;
			case ToscaPackage.TNODE_TYPE__INSTANCE_STATES:
				setInstanceStates((TTopologyElementInstanceStates)null);
				return;
			case ToscaPackage.TNODE_TYPE__INTERFACES:
				setInterfaces((InterfacesType)null);
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
			case ToscaPackage.TNODE_TYPE__REQUIREMENT_DEFINITIONS:
				return requirementDefinitions != null;
			case ToscaPackage.TNODE_TYPE__CAPABILITY_DEFINITIONS:
				return capabilityDefinitions != null;
			case ToscaPackage.TNODE_TYPE__INSTANCE_STATES:
				return instanceStates != null;
			case ToscaPackage.TNODE_TYPE__INTERFACES:
				return interfaces != null;
		}
		return super.eIsSet(featureID);
	}

} //TNodeTypeImpl
