package com.concesionario.service;

import org.springframework.web.multipart.MultipartFile;

public interface FirebaseStorageService {
    
    public String cargaImagen (MultipartFile archivoLocalCliente, String carpeta, Long id);
    
    //El BuketName es el <id_del_proyecto> + ".appspot.com"
    final String BucketName = "concesionario-8a294.appspot.com";

    //Esta es la ruta básica de este proyecto Techshop
    final String rutaSuperiorStorage = "concesionario";

    //Ubicación donde se encuentra el archivo de configuración Json
    final String rutaJsonFile = "firebase";
    
    //El nombre del archivo Json
    final String archivoJsonFile = "concesionario-8a294-firebase-adminsdk-m2x6i-8b0a205484.json";
    
}
