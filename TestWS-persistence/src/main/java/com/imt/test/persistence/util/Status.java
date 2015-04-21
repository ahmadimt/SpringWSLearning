/**
 * 
 */
package com.imt.test.persistence.util;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

/**
 * @author imteyaza
 *
 */
@JsonFormat(shape = Shape.OBJECT)
public enum Status {

	COMPLETED("Completed"), CREATED("Created"), MODIFIED("Modified"), NEW("New"), ACTIVE(
			"Active"), INACTIVE("In Active");

	private String status;

	/**
	 * @param status
	 */
	private Status(String status) {
		this.status = status;
	}

	/**
	 * @return
	 */
	public String getStatus() {
		return status;
	}

	public static Status fromStatus(String status) {
		if (status == null) {
			return null;
		}

		for (Status st : Status.values()) {
			if (st.getStatus().equals(status)) {
				return st;
			}
		}

		return null;
	}

}
