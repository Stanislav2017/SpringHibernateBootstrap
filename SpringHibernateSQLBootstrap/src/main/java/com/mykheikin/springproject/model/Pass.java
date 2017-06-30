package com.mykheikin.springproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PASSES")
public class Pass {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "DAY_START")
	private String dayStart;
	@Column(name = "TIME_START")
	private String timeStart;
	@Column(name = "TIME_END")
	private String timeEnd;
	@Column(name = "PASS_NUMBER")
	private int passNumber;

	public Pass() {
	}

	public Pass(int id, String dayStart, String timeStart, String timeEnd, int passNumber) {
		super();
		this.id = id;
		this.dayStart = dayStart;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
		this.passNumber = passNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDayStart() {
		return dayStart;
	}

	public void setDayStart(String dayStart) {
		this.dayStart = dayStart;
	}

	public String getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(String timeStart) {
		this.timeStart = timeStart;
	}

	public String getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(String timeEnd) {
		this.timeEnd = timeEnd;
	}

	public int getPassNumber() {
		return passNumber;
	}

	public void setPassNumber(int passNumber) {
		this.passNumber = passNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dayStart == null) ? 0 : dayStart.hashCode());
		result = prime * result + id;
		result = prime * result + passNumber;
		result = prime * result + ((timeEnd == null) ? 0 : timeEnd.hashCode());
		result = prime * result + ((timeStart == null) ? 0 : timeStart.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pass other = (Pass) obj;
		if (dayStart == null) {
			if (other.dayStart != null)
				return false;
		} else if (!dayStart.equals(other.dayStart))
			return false;
		if (id != other.id)
			return false;
		if (passNumber != other.passNumber)
			return false;
		if (timeEnd == null) {
			if (other.timeEnd != null)
				return false;
		} else if (!timeEnd.equals(other.timeEnd))
			return false;
		if (timeStart == null) {
			if (other.timeStart != null)
				return false;
		} else if (!timeStart.equals(other.timeStart))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pass [id=" + id + ", dayStart=" + dayStart + ", timeStart=" + timeStart + ", timeEnd=" + timeEnd
				+ ", passNumber=" + passNumber + "]";
	}
}