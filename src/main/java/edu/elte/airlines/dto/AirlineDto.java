package edu.elte.airlines.dto;

public class AirlineDto implements DtoInterface<Integer> {
	private Integer id;

	@Override
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
