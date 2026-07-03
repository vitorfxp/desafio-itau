package dev.jv.DesafioItau.repository;

import dev.jv.DesafioItau.dto.TransacaoDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TransacaoRepository {

    List<TransacaoDTO> dataList = new ArrayList<>();

    public void salvarData(TransacaoDTO data){
        dataList.add(data);
    }

    public void limparDados () {

    }

    public void deletarDados(){
        dataList.clear();
    }

}
