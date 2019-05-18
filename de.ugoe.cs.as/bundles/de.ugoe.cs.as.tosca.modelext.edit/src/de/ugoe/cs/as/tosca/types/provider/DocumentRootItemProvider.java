/**
 */
package de.ugoe.cs.as.tosca.types.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import de.ugoe.cs.as.tosca.types.DocumentRoot;
import de.ugoe.cs.as.tosca.types.TypesFactory;
import de.ugoe.cs.as.tosca.types.TypesPackage;

/**
 * This is the item provider adapter for a {@link de.ugoe.cs.as.tosca.types.DocumentRoot} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class DocumentRootItemProvider 
	extends ItemProviderAdapter
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DocumentRootItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

		}
		return itemPropertyDescriptors;
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(TypesPackage.Literals.DOCUMENT_ROOT__CLOUDIFY_AGENT_PROPERTIES);
			childrenFeatures.add(TypesPackage.Literals.DOCUMENT_ROOT__FLOATING_IP_PROPERTIES);
			childrenFeatures.add(TypesPackage.Literals.DOCUMENT_ROOT__KEY_PAIR_PROPERTIES);
			childrenFeatures.add(TypesPackage.Literals.DOCUMENT_ROOT__MPI_HOST_PROPERTIES);
			childrenFeatures.add(TypesPackage.Literals.DOCUMENT_ROOT__OPEN_STACK_FLOATING_IP_PROPERTIES);
			childrenFeatures.add(TypesPackage.Literals.DOCUMENT_ROOT__OPEN_STACK_PROPERTIES);
			childrenFeatures.add(TypesPackage.Literals.DOCUMENT_ROOT__OPEN_STACK_VOLUME_PROPERTIES);
			childrenFeatures.add(TypesPackage.Literals.DOCUMENT_ROOT__SCALING_GROUP_PROPERTIES);
			childrenFeatures.add(TypesPackage.Literals.DOCUMENT_ROOT__VOLUME_HOST_PROPERTIES_TYPE);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns DocumentRoot.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/DocumentRoot"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_DocumentRoot_type");
	}
	

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(DocumentRoot.class)) {
			case TypesPackage.DOCUMENT_ROOT__CLOUDIFY_AGENT_PROPERTIES:
			case TypesPackage.DOCUMENT_ROOT__FLOATING_IP_PROPERTIES:
			case TypesPackage.DOCUMENT_ROOT__KEY_PAIR_PROPERTIES:
			case TypesPackage.DOCUMENT_ROOT__MPI_HOST_PROPERTIES:
			case TypesPackage.DOCUMENT_ROOT__OPEN_STACK_FLOATING_IP_PROPERTIES:
			case TypesPackage.DOCUMENT_ROOT__OPEN_STACK_PROPERTIES:
			case TypesPackage.DOCUMENT_ROOT__OPEN_STACK_VOLUME_PROPERTIES:
			case TypesPackage.DOCUMENT_ROOT__SCALING_GROUP_PROPERTIES:
			case TypesPackage.DOCUMENT_ROOT__VOLUME_HOST_PROPERTIES_TYPE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.DOCUMENT_ROOT__CLOUDIFY_AGENT_PROPERTIES,
				 TypesFactory.eINSTANCE.createCloudifyAgentPropertiesType()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.DOCUMENT_ROOT__FLOATING_IP_PROPERTIES,
				 TypesFactory.eINSTANCE.createFloatingIPPropertiesType()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.DOCUMENT_ROOT__KEY_PAIR_PROPERTIES,
				 TypesFactory.eINSTANCE.createKeyPairPropertiesType()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.DOCUMENT_ROOT__MPI_HOST_PROPERTIES,
				 TypesFactory.eINSTANCE.createHostPropertiesType()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.DOCUMENT_ROOT__OPEN_STACK_FLOATING_IP_PROPERTIES,
				 TypesFactory.eINSTANCE.createOpenStackFloatingIPPropertiesType()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.DOCUMENT_ROOT__OPEN_STACK_PROPERTIES,
				 TypesFactory.eINSTANCE.createOpenStackServerPropertiesType()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.DOCUMENT_ROOT__OPEN_STACK_VOLUME_PROPERTIES,
				 TypesFactory.eINSTANCE.createOpenStackVolumePropertiesType()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.DOCUMENT_ROOT__SCALING_GROUP_PROPERTIES,
				 TypesFactory.eINSTANCE.createScalingGroupPropertiesType()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.DOCUMENT_ROOT__VOLUME_HOST_PROPERTIES_TYPE,
				 TypesFactory.eINSTANCE.createVolumeHostPropertiesType()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return PropertyTypesEditPlugin.INSTANCE;
	}

}