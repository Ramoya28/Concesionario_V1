package com.concesionario.controller;

import com.concesionario.domain.Categoria;
import com.concesionario.domain.Usuario;
import com.concesionario.service.CategoriaService;
import com.concesionario.service.UsuarioService;
import com.concesionario.service.impl.FirebaseStorageServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@Slf4j
@RequestMapping("/marcas") //(marcas/listado)
public class ConcesionarioController {

    @Autowired
    private CategoriaService marcasService;
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var marcass = marcasService.getCategorias(false);
        model.addAttribute("marcass", marcass);
        model.addAttribute("totalCategorias", marcass.size());
        return "/marcas/listado";
    }

    @GetMapping("/registro")
    public String inicioU(Model model) {
        var usuarios = usuarioService.getInformacion(0);
        model.addAttribute("marcass", usuarios);
        model.addAttribute("totalCategorias", usuarios.size());
        return "/marcas/registro";
    }

    @GetMapping("/login")
    public String login() {
        return "/marcas/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("correo") String correo,
            @RequestParam("contrasena") String contrasena,
            Model model) {
        Usuario usuario = usuarioService.validateUser(correo, contrasena);
        if (usuario != null) {
            // Lógica después de iniciar sesión con éxito
            model.addAttribute("usuario", usuario);
            return "redirect:/marcas/listado"; // Cambia a la vista que desees mostrar después del login
        } else {
            // Lógica para manejo de error de login
            model.addAttribute("error", "Correo o contraseña incorrectos");
            return "/marcas/login";
        }
    }

    @GetMapping("/nuevo")
    public String marcasNuevo(Categoria marcas) {
        return "/marcas/modifica";
    }

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;

    @PostMapping("/guardar")
    public String marcasGuardar(Categoria marcas,
            @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            marcasService.save(marcas);
            marcas.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile,
                            "marcas",
                            marcas.getIdCategoria()));
        }
        marcasService.save(marcas);
        return "redirect:/marcas/listado";
    }

    @GetMapping("/eliminar/{idCategoria}")
    public String marcasEliminar(Categoria marcas) {
        marcasService.delete(marcas);
        return "redirect:/marcas/listado";
    }

    @GetMapping("/modificar/{idCategoria}")
    public String marcasModificar(Categoria marcas, Model model) {
        marcas = marcasService.getCategoria(marcas);
        model.addAttribute("marcas", marcas);
        return "/marcas/modifica";
    }

    /*--------USUARIO-------*/
    @GetMapping("/usuario")
    public String registroUsuario(Usuario usuario) {
        return "/marcas/usuario";
    }

    @GetMapping("/usuario/nuevo")
    public String formualarioRegistro(Model model, Usuario usuario) {
        model.addAttribute("usuario", usuario);
        return "usuarioNuevo";
    }

    @PostMapping("marcas/guardarUsuario")
    public String guardarUsuario(Usuario usuario) {
        usuarioService.save(usuario);
        return "redirect:/marcas/registro";
    }

    /*@GetMapping("eliminar/{idUsuario}")
    public String eliminarUsuario(Usuario usuario) {
        usuarioService.delete(usuario);
        return "redirect:/marcas/usuario";
    }*/

}
