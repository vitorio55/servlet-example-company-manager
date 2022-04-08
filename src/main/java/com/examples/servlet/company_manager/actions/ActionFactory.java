package com.examples.servlet.company_manager.actions;

public class ActionFactory {

	public Action createAction(String actionName) {
		Action action = null;
		if (actionName.equals("ListCompanies")) {
			action = new ListCompanies();
		} else if (actionName.equals("DeleteCompany")) {
			action = new DeleteCompany();
		} else if (actionName.equals("EditCompany")) {
			action = new EditCompany();
		} else if (actionName.equals("ShowCompany")) {
			action = new ShowCompany();
		} else if (actionName.equals("CreateCompany")) {
			action = new CreateCompany();
		} else if (actionName.equals("FormCreateCompany")) {
			action = new FormCreateCompany();
		}
		return action;
	}
}
