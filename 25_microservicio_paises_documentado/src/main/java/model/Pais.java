package model;


import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Pais {
	
	@JsonAlias("name") //Solo lo tiene en cuenta cuando lo pide, no cuando lo devuelve
	private String pais;
	private String capital;
	@JsonAlias("region")
	private String continente;
	@JsonAlias("population")
	private long habitantes;
	@JsonAlias("flags")
	private Banderas banderas;
}
