package com.eric.firstejbproj.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class AddEjb
 */
@Stateless(mappedName = "AddEjb")
@LocalBean
public class AddEjb implements AddEjbRemote, AddEjbLocal {

    /**
     * Default constructor. 
     */
    public AddEjb() {
        // TODO Auto-generated constructor stub
    }

}
