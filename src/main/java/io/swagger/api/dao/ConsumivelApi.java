/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.8).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api.dao;

import java.util.List;

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
import io.swagger.model.ConsumivelDto;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-09-19T18:58:26.782Z")

@Api(value = "consumivel", description = "the Consumivel API")
public interface ConsumivelApi {

	@ApiOperation(value = "Cadastro de um novo consumivel.", nickname = "cadastraNova", notes = "Esta operação tem como objetivo cadastra um novo consumivel.", response = ConsumivelDto.class, tags = {
			"Cadastro", })
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Sucesso ao cadastrar um novo consumivel.", response = ConsumivelDto.class),
			@ApiResponse(code = 400, message = "Cadastro inválido."),
			@ApiResponse(code = 401, message = "Cadastro não autorizado"),
			@ApiResponse(code = 500, message = "Erro interno ao tentar realizar o cadastro.") })
	@RequestMapping(value = "/consumivel", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.POST)
	ResponseEntity<Void> cadastraNova(@ApiParam(value = "", required = true) @Valid @RequestBody ConsumivelDto consumivel);

	@ApiOperation(value = "Consulta um consumivel existente por Id.", nickname = "consultaPorId", notes = "Essa consulta tem como objetivo consultar um consumivel existente por Id.", response = ConsumivelDto.class, tags = {
			"Consulta", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Sucesso ao consultar consumivel existente por Id.", response = ConsumivelDto.class),
			@ApiResponse(code = 400, message = "Consulta invalida."),
			@ApiResponse(code = 401, message = "Consulta não autorizada"),
			@ApiResponse(code = 404, message = "Nenhum consumivel encontrada para a consulta por Id."),
			@ApiResponse(code = 500, message = "Erro interno ao tentar consultar por Id") })
	@RequestMapping(value = "/consumivel/{id}", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.GET)
	ResponseEntity<ConsumivelDto> consultaPorId(
			@ApiParam(value = "Numero do Id do consumivel.", required = true) @PathVariable("id") Integer id);

	@ApiOperation(value = "Exclui um consumivel existente.", nickname = "excluiExistente", notes = "Essa operção tem como objetivo exluir uma arma existente.", tags = {
			"Exclusao", })
	@ApiResponses(value = { @ApiResponse(code = 204, message = "Sucesso ao excluir um consumivel existente."),
			@ApiResponse(code = 400, message = "Exclusão inválida."),
			@ApiResponse(code = 401, message = "Exclusão não autorizada."),
			@ApiResponse(code = 500, message = "Erro interno ao tentar fazer a exclusão.") })
	@RequestMapping(value = "/consumivel/{id}", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.DELETE)
	ResponseEntity<Void> excluiExistente(
			@ApiParam(value = "Numero do Id do consumivel.", required = true) @PathVariable("id") Integer id);

	@ApiOperation(value = "Consulta todos.", nickname = "Consulta todos\"", notes = "Essa operção tem como objetivo exluir uma consumivel existente.", tags = {
			"Consulta todos", })
//	@ApiResponses(value = { @ApiResponse(code = 200, message = "Sucesso ao excluir um consumivel existente."),
//			@ApiResponse(code = 400, message = "Exclusão inválida."),
//			@ApiResponse(code = 401, message = "Exclusão não autorizada."),
//			@ApiResponse(code = 500, message = "Erro interno ao tentar fazer a exclusão.") })
	@RequestMapping(value = "/consumiveis", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.GET)
	ResponseEntity<List<ConsumivelDto>> consultarTodos();



}