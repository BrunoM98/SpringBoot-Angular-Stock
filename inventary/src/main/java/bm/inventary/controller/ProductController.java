package bm.inventary.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//maneja peticiones http y devuelve JSON  se utiliza en APis REST;
@RestController
//Asocia una URL y metodo HTTP a un controllador o metodo se utiliza a nivel clase o metodo;
@RequestMapping("stock-app")
//se da permisos dependiendo de la peticion y el lenguaje que se utilize si no resiviriamos peticiones de 8080;
@CrossOrigin(value = "http://localhost:4200") // puerto default de angular;
public class ProductController {

    

}
