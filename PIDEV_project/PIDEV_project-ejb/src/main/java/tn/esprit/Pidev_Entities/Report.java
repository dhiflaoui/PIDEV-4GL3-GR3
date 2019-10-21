package tn.esprit.Pidev_Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Report   implements Serializable {

	private static final long serialVersionUID = 35501844688441792L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private long price;
	private String description;
	private ReportNature nature;
	private ReportState state;
	@Temporal(TemporalType.DATE)
	private Date date;
	private String Image;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_mission", nullable = true, insertable = false, updatable = false)
	private Mission id_M;

	public Report(Long id, String name, long price, String description, ReportNature nature, ReportState state,
			Date date, String image, Mission id_M) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.nature = nature;
		this.state = state;
		this.date = date;
		Image = image;
		this.id_M = id_M;
	}

	public Report() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ReportNature getNature() {
		return nature;
	}

	public void setNature(ReportNature nature) {
		this.nature = nature;
	}

	public ReportState getState() {
		return state;
	}

	public void setState(ReportState state) {
		this.state = state;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getImage() {
		return Image;
	}

	public void setImage(String image) {
		Image = image;
	}

	public Mission getId_M() {
		return id_M;
	}

	public void setId_M(Mission id_M) {
		this.id_M = id_M;
	}

}
