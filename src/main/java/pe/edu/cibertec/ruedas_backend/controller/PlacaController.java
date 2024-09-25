package pe.edu.cibertec.ruedas_backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.ruedas_backend.Service.PlacaService;
import pe.edu.cibertec.ruedas_backend.dto.PlacaRequestDTO;
import pe.edu.cibertec.ruedas_backend.dto.PlacaResponseDTO;

import java.io.IOException;

@RestController
@RequestMapping("/buscador")
public class PlacaController {


    @Autowired
    PlacaService placaService;

@PostMapping("/info")
public PlacaResponseDTO buscar(@RequestBody PlacaRequestDTO placaRequestDTO){


    try {
        String[] infplaca=placaService.identificarPlacas(placaRequestDTO);

        if (infplaca == null){
            return new PlacaResponseDTO("01","","01","","01");
        }

        return new PlacaResponseDTO(infplaca[0],infplaca[1],infplaca[2],infplaca[3],infplaca[4]);
    } catch (IOException e) {

        System.out.println(e.getMessage());

        return new PlacaResponseDTO("01","","01","","01");

    }


}



}
