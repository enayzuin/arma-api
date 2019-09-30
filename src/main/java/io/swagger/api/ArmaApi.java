/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.8).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.model.Arma;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-09-19T18:58:26.782Z")

@Api(value = "arma", description = "the arma API")
public interface ArmaApi {

	@ApiOperation(value = "Altera uma arma existente.", nickname = "alteraArma", notes = "Esta opereção tem como objetivo alterar uma arma existente.", response = Arma.class, tags = {
			"Manutencao", })
	@ApiResponses(value = {
			@ApiResponse(code = 202, message = "Sucesso ao alterar uma arma existente.", response = Arma.class),
			@ApiResponse(code = 400, message = "Alteração inválida."),
			@ApiResponse(code = 401, message = "Alteração não autorizada."),
			@ApiResponse(code = 500, message = "Erro interno ao tentar realizar a alteração.") })
	@RequestMapping(value = "/arma/{id}", method = RequestMethod.PUT)
	ResponseEntity<Arma> alteraArma(@ApiParam(value = "Id da arma.", required = true) @PathVariable("id") Integer id,
			@ApiParam(value = "", required = true) @Valid @RequestBody Arma arma);

	@ApiOperation(value = "Alteração de status da arma por id.", nickname = "alteraStatusPorId", notes = "Esta operação tem  por objetivo alterar o status da arma por Id.", response = Arma.class, tags = {
			"Manutencao", })
	@ApiResponses(value = {
			@ApiResponse(code = 202, message = "Sucesso ao alterar o status de uma arma existente", response = Arma.class),
			@ApiResponse(code = 400, message = "Alteração de status invalida."),
			@ApiResponse(code = 401, message = "Alteração de status não autorizada."),
			@ApiResponse(code = 500, message = "Erro interno ao tentar realizar a altereção de status.") })
	@RequestMapping(value = "/arma/{status}/{id}", method = RequestMethod.PUT)
	ResponseEntity<Arma> alteraStatusPorId(
			@ApiParam(value = "Status da arma.", required = true, allowableValues = "\"ativo\", \"cofre\"") @PathVariable("status") String status,
			@ApiParam(value = "Numero do id da arma.", required = true) @PathVariable("id") Integer id);

	@ApiOperation(value = "Cadastro de uma nova arma.", nickname = "cadastraNova", notes = "Esta operação tem como objetivo cadastra uma nova arma.", response = Arma.class, tags = {
			"Cadastro", })
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Sucesso ao cadastrar uma nova arma.", response = Arma.class),
			@ApiResponse(code = 400, message = "Cadastro inválido."),
			@ApiResponse(code = 401, message = "Cadastro não autorizado"),
			@ApiResponse(code = 500, message = "Erro interno ao tentar realizar o cadastro.") })
	@RequestMapping(value = "/arma", method = RequestMethod.POST)
	ResponseEntity<Arma> cadastraNova(@ApiParam(value = "", required = true) @Valid @RequestBody Arma arma);

	@ApiOperation(value = "Consulta uma arma existente por Id.", nickname = "consultaPorId", notes = "Essa consulta tem como objetivo consultar uma arma existente por Id.", response = Arma.class, tags = {
			"Consulta", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Sucesso ao consultar arma existente por Id.", response = Arma.class),
			@ApiResponse(code = 400, message = "Consulta invalida."),
			@ApiResponse(code = 401, message = "Consulta não autorizada"),
			@ApiResponse(code = 404, message = "Nenhuma arma encontrada para a consulta por Id."),
			@ApiResponse(code = 500, message = "Erro interno ao tentar consultar por Id") })
	@RequestMapping(value = "/arma/{id}", method = RequestMethod.GET)
	ResponseEntity<Arma> consultaPorId(
			@ApiParam(value = "Numero do Id da arma.", required = true) @PathVariable("id") Integer id);

	@ApiOperation(value = "Consulta arma existente por raridade.", nickname = "consultaPorRaridade", notes = "Esta operação tem por objetivo consultar uma arma existente por raridade.", response = Arma.class, tags = {
			"Consulta", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Sucesso ao consultar arma por raridade", response = Arma.class),
			@ApiResponse(code = 400, message = "Consulta invalida."),
			@ApiResponse(code = 401, message = "Consulta não autorizada."),
			@ApiResponse(code = 404, message = "Nenhuma arma encontrada para a pesquisa."),
			@ApiResponse(code = 500, message = "Erro interno ao tentar realizar a consulta por raridade.") })
	@RequestMapping(value = "/arma/consulta/{raridade}", method = RequestMethod.GET)
	ResponseEntity<Arma> consultaPorRaridade(
			@ApiParam(value = "Raridade da arma", required = true) @PathVariable("raridade") String raridade);

	@ApiOperation(value = "Exclui uma arma existente.", nickname = "excluiExistente", notes = "Essa operção tem como objetivo exluir uma arma existente.", tags = {
			"Exclusao", })
	@ApiResponses(value = { @ApiResponse(code = 204, message = "Sucesso ao excluir uma arma existente."),	
			@ApiResponse(code = 400, message = "Exclusão inválida."),
			@ApiResponse(code = 401, message = "Exclusão não autorizada."),
			@ApiResponse(code = 500, message = "Erro interno ao tentar fazer a exclusão.") })
	@RequestMapping(value = "/arma/{id}", method = RequestMethod.DELETE)
	ResponseEntity<Void> excluiExistente(
			@ApiParam(value = "Numero do Id da arma.", required = true) @PathVariable("id") Integer id);

}
