package com.veterianariaapp.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.veterianariaapp.model.Perfil;
import com.veterianariaapp.model.Usuario;
// import com.veterianariaapp.model.Usuario;
import com.veterianariaapp.model.Veterinaria;
import com.veterianariaapp.service.interfaces.UsuarioService;
import com.veterianariaapp.service.interfaces.VeterinariaService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired
    VeterinariaService veterinariaService;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String home(Model model) {

        List<Veterinaria> lista = veterinariaService.getVeterinarias();

        model.addAttribute("veterinarias", lista);

        return "home";
    }

    @GetMapping("/form")
    public String form(Model model) {

        return "form";
    }

    @GetMapping("/formimg/{id}")
    public String formImg(@PathVariable int id, Model model) {

        Veterinaria veterinaria = veterinariaService.findVeterinariaById(id);

        model.addAttribute("veterinaria", veterinaria);

        return "formupload";
    }

    // ======== AUTH ==========

    @GetMapping("/index")
    public String mostrarIndex(Authentication authentication, HttpSession session) {

        // Como el usuario ya ingreso, ya podemos agregar a la session el objeto
        // usuario.
        String username = authentication.getName();

        for (GrantedAuthority rol : authentication.getAuthorities()) {
            System.out.println("ROL: " + rol.getAuthority());
        }

        if (session.getAttribute("usuario") == null) {
            Usuario usuario = usuarioService.buscarPorUsername(username);
            // System.out.println("Usuario: " + usuario);
            session.setAttribute("usuario", usuario);
        }

        return "redirect:/";
    }

    @GetMapping("/login")
    public String mostrarLogin() {
        return "formLogin";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
        logoutHandler.logout(request, null, null);
        return "redirect:/";
    }

    @GetMapping("/bcrypt/{texto}")
    @ResponseBody
    public String encriptar(@PathVariable("texto") String texto) {
        return texto + " Encriptado en Bcrypt: " + passwordEncoder.encode(texto);
    }

    @GetMapping("/signup")
    public String registrarse(Usuario usuario) {
        // public String registrarse() {
        // model.addAttribute("usuario", new Usuario());
        return "formRegistro";
    }

    @PostMapping("/signup")
    public String guardarRegistro(Usuario usuario, RedirectAttributes attributes) {
        // Recuperamos el password en texto plano
        String pwdPlano = usuario.getPassword();
        // Encriptamos el pwd BCryptPasswordEncoder
        String pwdEncriptado = passwordEncoder.encode(pwdPlano);
        // Hacemos un set al atributo password (ya viene encriptado)
        usuario.setPassword(pwdEncriptado);
        usuario.setEstatus(1); // Activado por defecto
        usuario.setFechaRegistro(new Date()); // Fecha de Registro, la fecha actual del servidor

        // Creamos el Perfil que le asignaremos al usuario nuevo
        Perfil perfil = new Perfil();
        perfil.setId(3); // Perfil USUARIO
        usuario.agregar(perfil);

        /**
         * Guardamos el usuario en la base de datos. El Perfil se guarda automaticamente
         */
        usuarioService.saveUsuario(usuario);

        attributes.addFlashAttribute("msg", "Has sido registrado. ¡Ahora puedes ingresar al sistema!");

        return "redirect:/login";
    }

}
