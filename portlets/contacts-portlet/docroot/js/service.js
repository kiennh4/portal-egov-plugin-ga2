Liferay.Service.register("Liferay.Service.contacts", "com.portal_egov.portlet.contacts.service", "contacts-portlet");

Liferay.Service.registerClass(
	Liferay.Service.contacts, "Contacts",
	{
		getContact: true,
		getGroupContacts: true,
		getDepartmentContacts: true,
		findByKeyword: true,
		updateContactState: true,
		updateContactDepartment: true,
		deleteContacts: true,
		getContactPortraitURL: true
	}
);

Liferay.Service.registerClass(
	Liferay.Service.contacts, "ContactsDepartment",
	{
		getDepartment: true,
		getGroupDepartments: true,
		getChildDepartments: true,
		countChildDepartment: true,
		updateDepartmentState: true,
		updateDepartmentParent: true,
		deleteDepartment: true
	}
);