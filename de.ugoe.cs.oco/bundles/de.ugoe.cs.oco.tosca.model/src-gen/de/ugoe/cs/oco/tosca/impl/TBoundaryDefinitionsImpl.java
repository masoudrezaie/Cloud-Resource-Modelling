/**
 */
package de.ugoe.cs.oco.tosca.impl;

import de.ugoe.cs.oco.tosca.CapabilitiesType2;
import de.ugoe.cs.oco.tosca.InterfacesType2;
import de.ugoe.cs.oco.tosca.PoliciesType2;
import de.ugoe.cs.oco.tosca.PropertiesType1;
import de.ugoe.cs.oco.tosca.PropertyConstraintsType1;
import de.ugoe.cs.oco.tosca.RequirementsType2;
import de.ugoe.cs.oco.tosca.TBoundaryDefinitions;
import de.ugoe.cs.oco.tosca.ToscaPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TBoundary Definitions</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.ugoe.cs.oco.tosca.impl.TBoundaryDefinitionsImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link de.ugoe.cs.oco.tosca.impl.TBoundaryDefinitionsImpl#getPropertyConstraints <em>Property Constraints</em>}</li>
 *   <li>{@link de.ugoe.cs.oco.tosca.impl.TBoundaryDefinitionsImpl#getRequirements <em>Requirements</em>}</li>
 *   <li>{@link de.ugoe.cs.oco.tosca.impl.TBoundaryDefinitionsImpl#getCapabilities <em>Capabilities</em>}</li>
 *   <li>{@link de.ugoe.cs.oco.tosca.impl.TBoundaryDefinitionsImpl#getPolicies <em>Policies</em>}</li>
 *   <li>{@link de.ugoe.cs.oco.tosca.impl.TBoundaryDefinitionsImpl#getInterfaces <em>Interfaces</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TBoundaryDefinitionsImpl extends MinimalEObjectImpl.Container implements TBoundaryDefinitions {
	/**
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected PropertiesType1 properties;

	/**
	 * The cached value of the '{@link #getPropertyConstraints() <em>Property Constraints</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyConstraints()
	 * @generated
	 * @ordered
	 */
	protected PropertyConstraintsType1 propertyConstraints;

	/**
	 * The cached value of the '{@link #getRequirements() <em>Requirements</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequirements()
	 * @generated
	 * @ordered
	 */
	protected RequirementsType2 requirements;

	/**
	 * The cached value of the '{@link #getCapabilities() <em>Capabilities</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCapabilities()
	 * @generated
	 * @ordered
	 */
	protected CapabilitiesType2 capabilities;

	/**
	 * The cached value of the '{@link #getPolicies() <em>Policies</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPolicies()
	 * @generated
	 * @ordered
	 */
	protected PoliciesType2 policies;

	/**
	 * The cached value of the '{@link #getInterfaces() <em>Interfaces</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterfaces()
	 * @generated
	 * @ordered
	 */
	protected InterfacesType2 interfaces;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TBoundaryDefinitionsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ToscaPackage.Literals.TBOUNDARY_DEFINITIONS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertiesType1 getProperties() {
		return properties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProperties(PropertiesType1 newProperties, NotificationChain msgs) {
		PropertiesType1 oldProperties = properties;
		properties = newProperties;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ToscaPackage.TBOUNDARY_DEFINITIONS__PROPERTIES, oldProperties, newProperties);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProperties(PropertiesType1 newProperties) {
		if (newProperties != properties) {
			NotificationChain msgs = null;
			if (properties != null)
				msgs = ((InternalEObject)properties).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ToscaPackage.TBOUNDARY_DEFINITIONS__PROPERTIES, null, msgs);
			if (newProperties != null)
				msgs = ((InternalEObject)newProperties).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ToscaPackage.TBOUNDARY_DEFINITIONS__PROPERTIES, null, msgs);
			msgs = basicSetProperties(newProperties, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ToscaPackage.TBOUNDARY_DEFINITIONS__PROPERTIES, newProperties, newProperties));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyConstraintsType1 getPropertyConstraints() {
		return propertyConstraints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPropertyConstraints(PropertyConstraintsType1 newPropertyConstraints, NotificationChain msgs) {
		PropertyConstraintsType1 oldPropertyConstraints = propertyConstraints;
		propertyConstraints = newPropertyConstraints;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ToscaPackage.TBOUNDARY_DEFINITIONS__PROPERTY_CONSTRAINTS, oldPropertyConstraints, newPropertyConstraints);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPropertyConstraints(PropertyConstraintsType1 newPropertyConstraints) {
		if (newPropertyConstraints != propertyConstraints) {
			NotificationChain msgs = null;
			if (propertyConstraints != null)
				msgs = ((InternalEObject)propertyConstraints).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ToscaPackage.TBOUNDARY_DEFINITIONS__PROPERTY_CONSTRAINTS, null, msgs);
			if (newPropertyConstraints != null)
				msgs = ((InternalEObject)newPropertyConstraints).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ToscaPackage.TBOUNDARY_DEFINITIONS__PROPERTY_CONSTRAINTS, null, msgs);
			msgs = basicSetPropertyConstraints(newPropertyConstraints, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ToscaPackage.TBOUNDARY_DEFINITIONS__PROPERTY_CONSTRAINTS, newPropertyConstraints, newPropertyConstraints));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequirementsType2 getRequirements() {
		return requirements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRequirements(RequirementsType2 newRequirements, NotificationChain msgs) {
		RequirementsType2 oldRequirements = requirements;
		requirements = newRequirements;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ToscaPackage.TBOUNDARY_DEFINITIONS__REQUIREMENTS, oldRequirements, newRequirements);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequirements(RequirementsType2 newRequirements) {
		if (newRequirements != requirements) {
			NotificationChain msgs = null;
			if (requirements != null)
				msgs = ((InternalEObject)requirements).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ToscaPackage.TBOUNDARY_DEFINITIONS__REQUIREMENTS, null, msgs);
			if (newRequirements != null)
				msgs = ((InternalEObject)newRequirements).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ToscaPackage.TBOUNDARY_DEFINITIONS__REQUIREMENTS, null, msgs);
			msgs = basicSetRequirements(newRequirements, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ToscaPackage.TBOUNDARY_DEFINITIONS__REQUIREMENTS, newRequirements, newRequirements));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CapabilitiesType2 getCapabilities() {
		return capabilities;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilities(CapabilitiesType2 newCapabilities, NotificationChain msgs) {
		CapabilitiesType2 oldCapabilities = capabilities;
		capabilities = newCapabilities;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ToscaPackage.TBOUNDARY_DEFINITIONS__CAPABILITIES, oldCapabilities, newCapabilities);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilities(CapabilitiesType2 newCapabilities) {
		if (newCapabilities != capabilities) {
			NotificationChain msgs = null;
			if (capabilities != null)
				msgs = ((InternalEObject)capabilities).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ToscaPackage.TBOUNDARY_DEFINITIONS__CAPABILITIES, null, msgs);
			if (newCapabilities != null)
				msgs = ((InternalEObject)newCapabilities).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ToscaPackage.TBOUNDARY_DEFINITIONS__CAPABILITIES, null, msgs);
			msgs = basicSetCapabilities(newCapabilities, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ToscaPackage.TBOUNDARY_DEFINITIONS__CAPABILITIES, newCapabilities, newCapabilities));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PoliciesType2 getPolicies() {
		return policies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPolicies(PoliciesType2 newPolicies, NotificationChain msgs) {
		PoliciesType2 oldPolicies = policies;
		policies = newPolicies;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ToscaPackage.TBOUNDARY_DEFINITIONS__POLICIES, oldPolicies, newPolicies);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPolicies(PoliciesType2 newPolicies) {
		if (newPolicies != policies) {
			NotificationChain msgs = null;
			if (policies != null)
				msgs = ((InternalEObject)policies).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ToscaPackage.TBOUNDARY_DEFINITIONS__POLICIES, null, msgs);
			if (newPolicies != null)
				msgs = ((InternalEObject)newPolicies).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ToscaPackage.TBOUNDARY_DEFINITIONS__POLICIES, null, msgs);
			msgs = basicSetPolicies(newPolicies, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ToscaPackage.TBOUNDARY_DEFINITIONS__POLICIES, newPolicies, newPolicies));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InterfacesType2 getInterfaces() {
		return interfaces;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInterfaces(InterfacesType2 newInterfaces, NotificationChain msgs) {
		InterfacesType2 oldInterfaces = interfaces;
		interfaces = newInterfaces;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ToscaPackage.TBOUNDARY_DEFINITIONS__INTERFACES, oldInterfaces, newInterfaces);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInterfaces(InterfacesType2 newInterfaces) {
		if (newInterfaces != interfaces) {
			NotificationChain msgs = null;
			if (interfaces != null)
				msgs = ((InternalEObject)interfaces).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ToscaPackage.TBOUNDARY_DEFINITIONS__INTERFACES, null, msgs);
			if (newInterfaces != null)
				msgs = ((InternalEObject)newInterfaces).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ToscaPackage.TBOUNDARY_DEFINITIONS__INTERFACES, null, msgs);
			msgs = basicSetInterfaces(newInterfaces, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ToscaPackage.TBOUNDARY_DEFINITIONS__INTERFACES, newInterfaces, newInterfaces));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ToscaPackage.TBOUNDARY_DEFINITIONS__PROPERTIES:
				return basicSetProperties(null, msgs);
			case ToscaPackage.TBOUNDARY_DEFINITIONS__PROPERTY_CONSTRAINTS:
				return basicSetPropertyConstraints(null, msgs);
			case ToscaPackage.TBOUNDARY_DEFINITIONS__REQUIREMENTS:
				return basicSetRequirements(null, msgs);
			case ToscaPackage.TBOUNDARY_DEFINITIONS__CAPABILITIES:
				return basicSetCapabilities(null, msgs);
			case ToscaPackage.TBOUNDARY_DEFINITIONS__POLICIES:
				return basicSetPolicies(null, msgs);
			case ToscaPackage.TBOUNDARY_DEFINITIONS__INTERFACES:
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
			case ToscaPackage.TBOUNDARY_DEFINITIONS__PROPERTIES:
				return getProperties();
			case ToscaPackage.TBOUNDARY_DEFINITIONS__PROPERTY_CONSTRAINTS:
				return getPropertyConstraints();
			case ToscaPackage.TBOUNDARY_DEFINITIONS__REQUIREMENTS:
				return getRequirements();
			case ToscaPackage.TBOUNDARY_DEFINITIONS__CAPABILITIES:
				return getCapabilities();
			case ToscaPackage.TBOUNDARY_DEFINITIONS__POLICIES:
				return getPolicies();
			case ToscaPackage.TBOUNDARY_DEFINITIONS__INTERFACES:
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
			case ToscaPackage.TBOUNDARY_DEFINITIONS__PROPERTIES:
				setProperties((PropertiesType1)newValue);
				return;
			case ToscaPackage.TBOUNDARY_DEFINITIONS__PROPERTY_CONSTRAINTS:
				setPropertyConstraints((PropertyConstraintsType1)newValue);
				return;
			case ToscaPackage.TBOUNDARY_DEFINITIONS__REQUIREMENTS:
				setRequirements((RequirementsType2)newValue);
				return;
			case ToscaPackage.TBOUNDARY_DEFINITIONS__CAPABILITIES:
				setCapabilities((CapabilitiesType2)newValue);
				return;
			case ToscaPackage.TBOUNDARY_DEFINITIONS__POLICIES:
				setPolicies((PoliciesType2)newValue);
				return;
			case ToscaPackage.TBOUNDARY_DEFINITIONS__INTERFACES:
				setInterfaces((InterfacesType2)newValue);
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
			case ToscaPackage.TBOUNDARY_DEFINITIONS__PROPERTIES:
				setProperties((PropertiesType1)null);
				return;
			case ToscaPackage.TBOUNDARY_DEFINITIONS__PROPERTY_CONSTRAINTS:
				setPropertyConstraints((PropertyConstraintsType1)null);
				return;
			case ToscaPackage.TBOUNDARY_DEFINITIONS__REQUIREMENTS:
				setRequirements((RequirementsType2)null);
				return;
			case ToscaPackage.TBOUNDARY_DEFINITIONS__CAPABILITIES:
				setCapabilities((CapabilitiesType2)null);
				return;
			case ToscaPackage.TBOUNDARY_DEFINITIONS__POLICIES:
				setPolicies((PoliciesType2)null);
				return;
			case ToscaPackage.TBOUNDARY_DEFINITIONS__INTERFACES:
				setInterfaces((InterfacesType2)null);
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
			case ToscaPackage.TBOUNDARY_DEFINITIONS__PROPERTIES:
				return properties != null;
			case ToscaPackage.TBOUNDARY_DEFINITIONS__PROPERTY_CONSTRAINTS:
				return propertyConstraints != null;
			case ToscaPackage.TBOUNDARY_DEFINITIONS__REQUIREMENTS:
				return requirements != null;
			case ToscaPackage.TBOUNDARY_DEFINITIONS__CAPABILITIES:
				return capabilities != null;
			case ToscaPackage.TBOUNDARY_DEFINITIONS__POLICIES:
				return policies != null;
			case ToscaPackage.TBOUNDARY_DEFINITIONS__INTERFACES:
				return interfaces != null;
		}
		return super.eIsSet(featureID);
	}

} //TBoundaryDefinitionsImpl
