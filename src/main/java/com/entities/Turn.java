package com.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

@Entity

public class Turn extends Agenda implements Serializable {
	private static final long serialVersionUID = 1L;

	
		private Date fecha;

		public Date getFecha() {
			return fecha;
		}

		public void setFecha(Date fecha) {
			this.fecha = fecha;
		}
		
		
		
		
		
		
		
		
}
