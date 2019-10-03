package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Consumivel
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-09-19T18:58:26.782Z")

public class ConsumivelDto {
	@JsonProperty("id")
	private Integer id = null;

	@JsonProperty("nome")
	private String nome = null;

	@JsonProperty("cura")
	private Integer cura = null;

	/**
	 * Gets or Sets tipo
	 */

public ConsumivelDto id(Integer id) {
		this.id = id;
		return this;
	}

	/**
	 * identificador da arma.
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "identificador do consumivel.")

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ConsumivelDto nome(String nome) {
		this.nome = nome;
		return this;
	}

	/**
	 * Nome da arma.
	 * 
	 * @return nome
	 **/
	@ApiModelProperty(value = "Nome da arma.")

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	/**
	 * Cura do consumivel.
	 * 
	 * @return dano
	 **/
	@ApiModelProperty(value = "Cura do consumivel.")

	public Integer getCura() {
		return cura;
	}

	public void setCura(Integer cura) {
		this.cura = cura;
	}

@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ConsumivelDto arma = (ConsumivelDto) o;
		return Objects.equals(this.id, arma.id) && Objects.equals(this.nome, arma.nome)
				&& Objects.equals(this.cura, arma.cura);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome, cura);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Arma {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
		sb.append("    cura: ").append(toIndentedString(cura)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
