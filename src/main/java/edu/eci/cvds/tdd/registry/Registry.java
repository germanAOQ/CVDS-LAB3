package edu.eci.cvds.tdd.registry;

import java.util.ArrayList;


public class Registry {
	private ArrayList<Integer> id = new ArrayList<Integer>();
	/**
	 * Registra a la persona en el sistema si es valida.
	 * @param p persona a registrar
	 * @return el estado de su registro
	 */
	public RegisterResult registerVoter(Person p) {
		RegisterResult temp = null;
		if(!p.isAlive()) {
			temp = RegisterResult.DEAD;
		}else if(p.getAge()<18 && p.getAge()>=0) {
			temp = RegisterResult.UNDERAGE;
		}else if(p.getAge()<0 || p.getAge()>110) {
			temp = RegisterResult.INVALID_AGE;
		}else if(id.contains(p.getId())) {
			temp = RegisterResult.DUPLICATED;
		}else {
			temp = RegisterResult.VALID;
			id.add(p.getId());
		}
		return temp;
    }

}
