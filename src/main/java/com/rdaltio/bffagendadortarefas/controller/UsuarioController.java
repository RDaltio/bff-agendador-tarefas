package com.rdaltio.bffagendadortarefas.controller;


import com.rdaltio.bffagendadortarefas.business.UsuarioService;
import com.rdaltio.bffagendadortarefas.business.dto.in.EnderecoDTORequest;
import com.rdaltio.bffagendadortarefas.business.dto.in.LoginDTORequest;
import com.rdaltio.bffagendadortarefas.business.dto.in.TelefoneDTORequest;
import com.rdaltio.bffagendadortarefas.business.dto.in.UsuarioDTORequest;
import com.rdaltio.bffagendadortarefas.business.dto.out.EnderecoDTOResponse;
import com.rdaltio.bffagendadortarefas.business.dto.out.TelefoneDTOResponse;
import com.rdaltio.bffagendadortarefas.business.dto.out.UsuarioDTOResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
@Tag(name = "Usuário", description = "Cadastro e login de usuários")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    @Operation(summary = "Salvar Usuários", description = "Cria um novo usuário")
    @ApiResponse(responseCode = "200", description = "Usuário salvo com sucesso")
    @ApiResponse(responseCode = "400", description = "Usuário já cadastrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<UsuarioDTOResponse> salvaUsuario(@RequestBody UsuarioDTORequest usuarioDTO){
        return ResponseEntity.ok(usuarioService.salvaUsuario(usuarioDTO));
    }

    @PostMapping("/login")
    @Operation(summary = "Login de Usuários", description = "Login do usuário")
    @ApiResponse(responseCode = "200", description = "Usuário logado com sucesso")
    @ApiResponse(responseCode = "401", description = "Credenciais inválidas")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public String login(@RequestBody LoginDTORequest usuarioDTO){
        return usuarioService.loginUsuario(usuarioDTO);
    }

    @GetMapping
    @Operation(summary = "Buscar dados de Usuários por email", description = "Buscar dados do usuário")
    @ApiResponse(responseCode = "200", description = "Usuário encontrado com sucesso")
    @ApiResponse(responseCode = "403", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    @ApiResponse(responseCode = "401", description = "Credenciais inválidas")
    public ResponseEntity<UsuarioDTOResponse> buscaUsuarioPorEmail(@RequestParam("email") String email,
                                                                   @RequestHeader(name = "Authorization", required = false) String token){
        return ResponseEntity.ok(usuarioService.buscaUsuarioPorEmail(email, token));
    }

    @DeleteMapping("/{email}")
    @Operation(summary = "Deleta Usuários por email", description = "Deleta um usuário")
    @ApiResponse(responseCode = "200", description = "Usuário deletado com sucesso")
    @ApiResponse(responseCode = "403", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    @ApiResponse(responseCode = "401", description = "Credenciais inválidas")
    public ResponseEntity<Void> deletaUsuarioPorEmail(@PathVariable String email,
                                                      @RequestHeader(name = "Authorization", required = false) String token){
        usuarioService.deletaUsuarioPorEmail(email, token);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @Operation(summary = "Atualizar dados de Usuários", description = "Atualiza dados de um usuário")
    @ApiResponse(responseCode = "200", description = "Usuário atualizado com sucesso")
    @ApiResponse(responseCode = "403", description = "Usuário não cadastrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    @ApiResponse(responseCode = "401", description = "Credenciais inválidas")
    public ResponseEntity<UsuarioDTOResponse> atualizaDadosUsuario(@RequestBody UsuarioDTORequest dto,
                                                                   @RequestHeader(name = "Authorization", required = false) String token){
        return ResponseEntity.ok(usuarioService.atualizaDadosUsuario(token, dto));
    }

    @PutMapping("/endereco")
    @Operation(summary = "Atualizar endereço de Usuários", description = "Atualiza endereço de um usuário")
    @ApiResponse(responseCode = "200", description = "Endereço atualizado com sucesso")
    @ApiResponse(responseCode = "403", description = "Usuário não cadastrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    @ApiResponse(responseCode = "401", description = "Credenciais inválidas")
    public ResponseEntity<EnderecoDTOResponse> atualizaEndereco(@RequestBody EnderecoDTORequest dto,
                                                                @RequestParam("id") Long id,
                                                                @RequestHeader(name = "Authorization", required = false) String token){
        return ResponseEntity.ok(usuarioService.atualizaEndereco(id, dto, token));
    }

    @PutMapping("/telefone")
    @Operation(summary = "Atualizar telefone de Usuários", description = "Atualiza telefone de um usuário")
    @ApiResponse(responseCode = "200", description = "Telefone atualizado com sucesso")
    @ApiResponse(responseCode = "403", description = "Usuário não cadastrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    @ApiResponse(responseCode = "401", description = "Credenciais inválidas")
    public ResponseEntity<TelefoneDTOResponse> atualizaTelefone(@RequestBody TelefoneDTORequest dto,
                                                                @RequestParam("id") Long id,
                                                                @RequestHeader(name = "Authorization", required = false) String token){
        return ResponseEntity.ok(usuarioService.atualizaTelefone(id, dto, token));
    }

    @PostMapping("/endereco")
    @Operation(summary = "Salva endereço de Usuários", description = "Salva endereço de um usuário")
    @ApiResponse(responseCode = "200", description = "Endereço salvo com sucesso")
    @ApiResponse(responseCode = "403", description = "Usuário não cadastrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    @ApiResponse(responseCode = "401", description = "Credenciais inválidas")
    public ResponseEntity<EnderecoDTOResponse> cadastraEndereco(@RequestBody EnderecoDTORequest dto,
                                                                @RequestHeader(name = "Authorization", required = false) String token){
        return ResponseEntity.ok(usuarioService.cadastraEndereco(token, dto));
    }

    @PostMapping("/telefone")
    @Operation(summary = "Salva telefone de Usuários", description = "Salva telefone de um usuário")
    @ApiResponse(responseCode = "200", description = "Telefone salvo com sucesso")
    @ApiResponse(responseCode = "403", description = "Usuário não cadastrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    @ApiResponse(responseCode = "401", description = "Credenciais inválidas")
    public ResponseEntity<TelefoneDTOResponse> cadastraTelefone(@RequestBody TelefoneDTORequest dto,
                                                                @RequestHeader(name = "Authorization", required = false) String token){
        return ResponseEntity.ok(usuarioService.cadastraTelefone(token, dto));
    }
}