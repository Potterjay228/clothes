package model;

public class Porder {
	private Integer id;
	private String name;
	private Integer shirt;
	private Integer trousers;
	private Integer sneakers;
	
	public Porder() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Porder(String name, Integer shirt, Integer trousers, Integer sneakers) {
		super();
		this.name = name;
		this.shirt = shirt;
		this.trousers = trousers;
		this.sneakers = sneakers;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getShirt() {
		return shirt;
	}
	public void setShirt(Integer shirt) {
		this.shirt = shirt;
	}
	public Integer getTrousers() {
		return trousers;
	}
	public void setTrousers(Integer trousers) {
		this.trousers = trousers;
	}
	public Integer getSneakers() {
		return sneakers;
	}
	public void setSneakers(Integer sneakers) {
		this.sneakers = sneakers;
	}

}
