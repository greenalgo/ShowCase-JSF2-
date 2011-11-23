package com.green.ida.entity.animal.idacase.result.pojos;

import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.green.ida.entity.animal.idacase.result.enums.IdaCaseResultType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "idaCaseResultType", discriminatorType = DiscriminatorType.STRING)
public class IdaCaseResult {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Enumerated(EnumType.STRING)
	private IdaCaseResultType idaResultType;
	@Temporal(TemporalType.TIMESTAMP)
	private Date closureDate;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setIdaResultType(IdaCaseResultType idaResultType) {
		this.idaResultType = idaResultType;
	}

	public IdaCaseResultType getIdaResultType() {
		return idaResultType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		IdaCaseResult other = (IdaCaseResult) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

	public Date getClosureDate() {
		return closureDate;
	}

	public void setClosureDate(Date closureDate) {
		this.closureDate = closureDate;
	}

	public void setSuperValues(IdaCaseResult idaCaseResult) {
		setIdaResultType(idaCaseResult.getIdaResultType());
		setClosureDate(idaCaseResult.getClosureDate());
	}

}
