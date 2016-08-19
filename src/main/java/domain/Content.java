package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="contents")
public class Content {
	@Id
	@GeneratedValue(generator = "increment2")
	@GenericGenerator(name = "increment2", strategy = "increment")
	private Long id;
	
	
	@Column(name="catalog_id")
	private Long catalog;
	
	@Column(name="discription")
	private String text;
	
	@Column(name="price")
	private int price;
	
	
	@Column(name="user_id")
	private Long user;
	
	@Column(name="date")
	private String date;
	
	public Content() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCatalog() {
		return catalog;
	}

	public void setCatalog(Long catalog) {
		this.catalog = catalog;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Long getUser() {
		return user;
	}

	public void setUser(Long user) {
		this.user = user;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Content [id=" + id + ", catalog=" + catalog + ", text=" + text + ", price=" + price + ", user=" + user
				+ ", date=" + date + "]";
	}
	
	
	

}
