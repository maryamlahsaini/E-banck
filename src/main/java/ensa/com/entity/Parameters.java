package ensa.com.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;
@Component
@XmlRootElement(name="Parameters")
@Entity
public class Parameters implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long ID;
	private Long etd;
	private Long dtd;
	public Long getID() {
		return ID;
	}
	public void setID(Long iD) {
		ID = iD;
	}
	public Parameters() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getEtd() {
		return etd;
	}
	public void setEtd(Long etd) {
		this.etd = etd;
	}
	public Long getDtd() {
		return dtd;
	}
	public void setDtd(Long dtd) {
		this.dtd = dtd;
	}
	public Parameters(Long iD, Long etd, Long dtd) {
		super();
		ID = iD;
		this.etd = etd;
		this.dtd = dtd;
	}
	
	
}