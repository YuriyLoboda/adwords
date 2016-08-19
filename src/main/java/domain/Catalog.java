package domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="catalogs")
public class Catalog {
	@Id
	@GeneratedValue(generator = "increment2")
	@GenericGenerator(name = "increment2", strategy = "increment")
	private Long id;
	
	@Column(name="name")
	private String name;
	
	
	@Override
	public String toString() {
		return "Catalog [id=" + id + ", name=" + name + ", content=" + content + "]";
	}

	@OneToMany(mappedBy="catalog",fetch=FetchType.EAGER)
	@Cascade({CascadeType.ALL})
	private List<Content> content;
	
	public List<Content> getContent() {
		return content;
	}


	public void setContent(List<Content> content) {
		this.content = content;
	}


	public Catalog() {
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
	

}
