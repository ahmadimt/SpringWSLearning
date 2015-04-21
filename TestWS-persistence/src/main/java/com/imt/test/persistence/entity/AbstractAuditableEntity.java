/**
 * 
 */
package com.imt.test.persistence.entity;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.data.domain.Auditable;
import org.springframework.data.jpa.domain.AbstractPersistable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.imt.test.persistence.util.Status;

/**
 * @author imteyaza
 *
 */
@SuppressWarnings("serial")
@MappedSuperclass
public abstract class AbstractAuditableEntity extends AbstractPersistable<Long>
		implements Auditable<String, Long> {

	@Version
	@Column(name = "version")
	protected Long version;

	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@JsonProperty("createdDate")
	protected DateTime createdDate;

	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@JsonProperty("lastModifiedDate")
	protected DateTime lastModifiedDate;

	protected String createdBy;

	protected String lastModifiedBy;

	@Enumerated(EnumType.STRING)
	protected Status status;

}
