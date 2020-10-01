package com.capg.omts.sreen_show.model;

import javax.persistence.*;

public class Role {

	   @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;

	    @Enumerated(EnumType.STRING)
	    @Column
	    private RoleType name;

	    public Role() {
	    }

	    public Role(RoleType name) {
	        this.name = name;
	    }

	    public long getId() {
	        return id;
	    }

	    public void setId(long id) {
	        this.id = id;
	    }

	    public RoleType getName() {
	        return name;
	    }

	    public void setName(RoleType name) {
	        this.name = name;
	    }

}
