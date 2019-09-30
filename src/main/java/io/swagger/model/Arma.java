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
 * Arma
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-09-19T18:58:26.782Z")

public class Arma   {
  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("nome")
  private String nome = null;

  @JsonProperty("raridade")
  private String raridade = null;

  @JsonProperty("dano")
  private Integer dano = null;

  @JsonProperty("status")
  private Boolean status = null;

  @JsonProperty("dtAtualizacao")
  private OffsetDateTime dtAtualizacao = null;

  /**
   * Gets or Sets tipo
   */
  public enum TipoEnum {
    SMG("SMG"),
    
    AR("AR"),
    
    PISTOLA("PISTOLA");

    private String value;

    TipoEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TipoEnum fromValue(String text) {
      for (TipoEnum b : TipoEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("tipo")
  private TipoEnum tipo = null;

  public Arma id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * identificador da arma.
   * @return id
  **/
  @ApiModelProperty(value = "identificador da arma.")


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Arma nome(String nome) {
    this.nome = nome;
    return this;
  }

  /**
   * Nome da arma.
   * @return nome
  **/
  @ApiModelProperty(value = "Nome da arma.")


  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Arma raridade(String raridade) {
    this.raridade = raridade;
    return this;
  }

  /**
   * Raridade da arma.
   * @return raridade
  **/
  @ApiModelProperty(value = "Raridade da arma.")


  public String getRaridade() {
    return raridade;
  }

  public void setRaridade(String raridade) {
    this.raridade = raridade;
  }

  public Arma dano(Integer dano) {
    this.dano = dano;
    return this;
  }

  /**
   * Dano da arma.
   * @return dano
  **/
  @ApiModelProperty(value = "Dano da arma.")


  public Integer getDano() {
    return dano;
  }

  public void setDano(Integer dano) {
    this.dano = dano;
  }

  public Arma status(Boolean status) {
    this.status = status;
    return this;
  }

  /**
   * Status ativo ou cofre da arma
   * @return status
  **/
  @ApiModelProperty(value = "Status ativo ou cofre da arma")


  public Boolean isStatus() {
    return status;
  }

  public void setStatus(Boolean status) {
    this.status = status;
  }

  public Arma dtAtualizacao(OffsetDateTime dtAtualizacao) {
    this.dtAtualizacao = dtAtualizacao;
    return this;
  }

  /**
   * Data de atualização das armas
   * @return dtAtualizacao
  **/
  @ApiModelProperty(value = "Data de atualização das armas")

  @Valid

  public OffsetDateTime getDtAtualizacao() {
    return dtAtualizacao;
  }

  public void setDtAtualizacao(OffsetDateTime dtAtualizacao) {
    this.dtAtualizacao = dtAtualizacao;
  }

  public Arma tipo(TipoEnum tipo) {
    this.tipo = tipo;
    return this;
  }

  /**
   * Get tipo
   * @return tipo
  **/
  @ApiModelProperty(value = "")


  public TipoEnum getTipo() {
    return tipo;
  }

  public void setTipo(TipoEnum tipo) {
    this.tipo = tipo;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Arma arma = (Arma) o;
    return Objects.equals(this.id, arma.id) &&
        Objects.equals(this.nome, arma.nome) &&
        Objects.equals(this.raridade, arma.raridade) &&
        Objects.equals(this.dano, arma.dano) &&
        Objects.equals(this.status, arma.status) &&
        Objects.equals(this.dtAtualizacao, arma.dtAtualizacao) &&
        Objects.equals(this.tipo, arma.tipo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nome, raridade, dano, status, dtAtualizacao, tipo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Arma {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    raridade: ").append(toIndentedString(raridade)).append("\n");
    sb.append("    dano: ").append(toIndentedString(dano)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    dtAtualizacao: ").append(toIndentedString(dtAtualizacao)).append("\n");
    sb.append("    tipo: ").append(toIndentedString(tipo)).append("\n");
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

