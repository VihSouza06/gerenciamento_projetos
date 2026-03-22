package com.bn.exercicio9.Services;

import com.bn.exercicio9.Models.ProjetoModel;
import com.bn.exercicio9.Repositories.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    public List<ProjetoModel> findAll(){
        return projetoRepository.findAll();
    }

    public ProjetoModel criarProjeto(ProjetoModel projetoModel){
        return projetoRepository.save(projetoModel);
    }

    public void deletarProjeto(Long id){
        projetoRepository.deleteById(id);
    }

    public ProjetoModel buscarProjetoPorId(Long id){
        return projetoRepository.findById(id).get();
    }

    public ProjetoModel atualizarProjeto(Long id, ProjetoModel projetoModel){
        ProjetoModel novoProjeto = projetoRepository.findById(id).get();
        novoProjeto.setNome(projetoModel.getNome());
        novoProjeto.setDataInicio(projetoModel.getDataInicio());
        novoProjeto.setDataFim(projetoModel.getDataFim());
        return projetoRepository.save(novoProjeto);
    }




}
