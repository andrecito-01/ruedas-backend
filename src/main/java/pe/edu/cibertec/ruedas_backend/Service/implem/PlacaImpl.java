package pe.edu.cibertec.ruedas_backend.Service.implem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.ruedas_backend.Service.PlacaService;
import pe.edu.cibertec.ruedas_backend.dto.PlacaRequestDTO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class PlacaImpl implements PlacaService {

    @Autowired
    ResourceLoader resourceLoader;

    @Override
    public String[] identificarPlacas(PlacaRequestDTO placaRequestDTO) throws IOException {

        String[] infplaca=null;
        Resource resource= resourceLoader.getResource("classpath:Placas.txt");













        try(BufferedReader br=new BufferedReader(new FileReader(resource.getFile()))) {


            String linea;

            while((linea=br.readLine())!=null){


                String[] datosP=linea.split(";");

                if (placaRequestDTO.Placa().equals(datosP[0])){

                    infplaca=new String[5];
                    infplaca[0]=datosP[1];
                    infplaca[1]=datosP[2];
                    infplaca[2]=datosP[3];
                    infplaca[3]=datosP[4];
                    infplaca[4]=datosP[5];

                }

            }







        }catch (IOException e){
            infplaca=null;
            throw new IOException(e);
        }











        return infplaca;
    }
}
