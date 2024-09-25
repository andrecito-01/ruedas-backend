package pe.edu.cibertec.ruedas_backend.Service;

import pe.edu.cibertec.ruedas_backend.dto.PlacaRequestDTO;

import java.io.IOException;

public interface PlacaService {

    String[] identificarPlacas(PlacaRequestDTO placaRequestDTO)throws IOException;

}
