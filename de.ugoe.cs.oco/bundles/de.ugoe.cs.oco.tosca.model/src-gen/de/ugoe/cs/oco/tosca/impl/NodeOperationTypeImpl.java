/**
 */
package de.ugoe.cs.oco.tosca.impl;

import de.ugoe.cs.oco.tosca.NodeOperationType;
import de.ugoe.cs.oco.tosca.TNodeType;
import de.ugoe.cs.oco.tosca.ToscaPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node Operation Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.ugoe.cs.oco.tosca.impl.NodeOperationTypeImpl#getInterfaceName <em>Interface Name</em>}</li>
 *   <li>{@link de.ugoe.cs.oco.tosca.impl.NodeOperationTypeImpl#getNodeRef <em>Node Ref</em>}</li>
 *   <li>{@link de.ugoe.cs.oco.tosca.impl.NodeOperationTypeImpl#getOperationName <em>Operation Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NodeOperationTypeImpl extends MinimalEObjectImpl.Container implements NodeOperationType {
	/**
	 * The default value of the '{@link #getInterfaceName() <em>Interface Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterfaceName()
	 * @generated
	 * @ordered
	 */
	protected static final String INTERFACE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInterfaceName() <em>Interface Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterfaceName()
	 * @generated
	 * @ordered
	 */
	protected String interfaceName = INTERFACE_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getNodeRef() <em>Node Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodeRef()
	 * @generated
	 * @ordered
	 */
	protected TNodeType nodeRef;

	/**
	 * The default value of the '{@link #getOperationName() <em>Operation Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperationName()
	 * @generated
	 * @ordered
	 */
	protected static final String OPERATION_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOperationName() <em>Operation Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperationName()
	 * @generated
	 * @ordered
	 */
	protected String operationName = OPERATION_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NodeOperationTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ToscaPackage.Literals.NODE_OPERATION_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInterfaceName() {
		return interfaceName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInterfaceName(String newInterfaceName) {
		String oldInterfaceName = interfaceName;
		interfaceName = newInterfaceName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ToscaPackage.NODE_OPERATION_TYPE__INTERFACE_NAME, oldInterfaceName, interfaceName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TNodeType getNodeRef() {
		return nodeRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNodeRef(TNodeType newNodeRef) {
		TNodeType oldNodeRef = nodeRef;
		nodeRef = newNodeRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ToscaPackage.NODE_OPERATION_TYPE__NODE_REF, oldNodeRef, nodeRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOperationName() {
		return operationName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperationName(String newOperationName) {
		String oldOperationName = operationName;
		operationName = newOperationName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ToscaPackage.NODE_OPERATION_TYPE__OPERATION_NAME, oldOperationName, operationName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ToscaPackage.NODE_OPERATION_TYPE__INTERFACE_NAME:
				return getInterfaceName();
			case ToscaPackage.NODE_OPERATION_TYPE__NODE_REF:
				return getNodeRef();
			case ToscaPackage.NODE_OPERATION_TYPE__OPERATION_NAME:
				return getOperationName();
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
			case ToscaPackage.NODE_OPERATION_TYPE__INTERFACE_NAME:
				setInterfaceName((String)newValue);
				return;
			case ToscaPackage.NODE_OPERATION_TYPE__NODE_REF:
				setNodeRef((TNodeType)newValue);
				return;
			case ToscaPackage.NODE_OPERATION_TYPE__OPERATION_NAME:
				setOperationName((String)newValue);
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
			case ToscaPackage.NODE_OPERATION_TYPE__INTERFACE_NAME:
				setInterfaceName(INTERFACE_NAME_EDEFAULT);
				return;
			case ToscaPackage.NODE_OPERATION_TYPE__NODE_REF:
				setNodeRef((TNodeType)null);
				return;
			case ToscaPackage.NODE_OPERATION_TYPE__OPERATION_NAME:
				setOperationName(OPERATION_NAME_EDEFAULT);
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
			case ToscaPackage.NODE_OPERATION_TYPE__INTERFACE_NAME:
				return INTERFACE_NAME_EDEFAULT == null ? interfaceName != null : !INTERFACE_NAME_EDEFAULT.equals(interfaceName);
			case ToscaPackage.NODE_OPERATION_TYPE__NODE_REF:
				return nodeRef != null;
			case ToscaPackage.NODE_OPERATION_TYPE__OPERATION_NAME:
				return OPERATION_NAME_EDEFAULT == null ? operationName != null : !OPERATION_NAME_EDEFAULT.equals(operationName);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (interfaceName: ");
		result.append(interfaceName);
		result.append(", operationName: ");
		result.append(operationName);
		result.append(')');
		return result.toString();
	}

} //NodeOperationTypeImpl
