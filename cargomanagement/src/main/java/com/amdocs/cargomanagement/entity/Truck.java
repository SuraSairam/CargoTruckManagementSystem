package com.amdocs.cargomanagement.entity;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity

public class Truck {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "TRUCKNO")
		private int truckno;
		@ManyToOne
		@JoinColumn(name="cid")
		private Cargo cargo;
		@Column(name = "DRIVERNAME")
		private String driverName;
		@Column(name = "liscence")
		private String liscence; 

		
		public Cargo getCargo() {
			return cargo;
		}
		public void setCargo(Cargo cargo) {
			this.cargo = cargo;
		}
		public int getTruckno() {
			return truckno;
		}
		public void setTruckno(int truckno) {
			this.truckno = truckno;
		}

		
		public String getDriverName() {
			return driverName;
		}

		public void setDriverName(String driverName) {
			this.driverName = driverName;
		}
		public String getLiscence() {
			return liscence;
		}
		public void setLiscence(String liscence) {
			this.liscence = liscence;
		}
		
		
		
	}

