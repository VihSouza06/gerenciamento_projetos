package com.bn.exercicio9.Controllers;

import com.bn.exercicio9.Models.ProjetoModel;
import com.bn.exercicio9.Services.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @GetMapping
    public ResponseEntity<List<ProjetoModel>> findAll(){
        List<ProjetoModel> projetos = projetoService.findAll();
        return ResponseEntity.ok().body(projetos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjetoModel> buscarProjetoPorId(@PathVariable Long id){
       ProjetoModel projeto =  projetoService.buscarProjetoPorId(id);
       return ResponseEntity.ok(projeto);
    }

    @PostMapping
    public ResponseEntity<ProjetoModel> criarProjeto(@RequestBody ProjetoModel projetoModel){
        ProjetoModel projetoCriado = projetoService.criarProjeto(projetoModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(projetoModel.getId()).toUri();
        return ResponseEntity.created(uri).body(projetoCriado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarProjeto(@PathVariable Long id){
        projetoService.deletarProjeto(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjetoModel> atualizarProjeto
            (@PathVariable Long id, @RequestBody ProjetoModel projetoModel){
        ProjetoModel projetoAtualizada = projetoService.atualizarProjeto(id, projetoModel);
        return ResponseEntity.ok(projetoAtualizada);
    }
}
