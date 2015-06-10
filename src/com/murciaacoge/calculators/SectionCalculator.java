package com.murciaacoge.calculators;

import org.openxava.calculators.*;
import org.openxava.jpa.*;
import org.openxava.util.*;

import com.murciaacoge.model.*;

public class SectionCalculator implements ICalculator{

	private static final long serialVersionUID = -5059490909827494071L;

	@Override
	public Object calculate() throws Exception {
		String userCode = Users.getCurrent();
		Gestor user = XPersistence.getManager().find(Gestor.class, userCode);
		if (user == null)
			return null;
		else
			return user.getSection();
	}

}
