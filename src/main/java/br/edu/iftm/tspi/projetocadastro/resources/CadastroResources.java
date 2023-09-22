package br.edu.iftm.tspi.projetocadastro.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import br.edu.iftm.tspi.projetocadastro.dto.CadastroDTO;


@Controller
public class CadastroResources {

    private List<CadastroDTO> cadastros = new ArrayList<>();

    @PostMapping("/cadastroPost")
    public String doPost(CadastroDTO dto, Model model){
        cadastros.add(dto);
        return doGet(model);
    }

    @RequestMapping("/cadastroGet")
    public String doGet(Model model){
        model.addAttribute("cadastros", cadastros);
        return "lista";
    }

    @GetMapping("/cadastroDelete/{id}")
    public String Delete(Model model, CadastroDTO dto, @PathVariable int id){
        int index = 0;
        for(CadastroDTO cadastro: cadastros){
            if(cadastro.getId() == (id)){
                
                break;
            } else{
                index++;
            }
        }
        cadastros.remove(index);
        return doGet(model);
}

@PostMapping("/cadastroEdit/{id}")
public String Edit(Model model, CadastroDTO dto, @PathVariable int id ){
    int index = 0;
    for (CadastroDTO cadastro : cadastros) {
        if(cadastro.getId() == id){
            cadastro.setEmail(cadastro.getEmail());
            cadastro.setName(cadastro.getName());
            cadastro.setAdress(cadastro.getAdress());
            break;
        } else{
            index++;
        }
    }
    return doGet(model);
}



}
