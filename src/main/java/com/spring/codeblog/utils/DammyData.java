package com.spring.codeblog.utils;

import com.spring.codeblog.model.Post;
import com.spring.codeblog.model.Usuario;
import com.spring.codeblog.repository.CodeblogRepository;
import com.spring.codeblog.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DammyData {

    @Autowired
    CodeblogRepository codeblogRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    //@PostConstruct
    public void savePost(){
//        List<Post> postList = new ArrayList<>();
//        Post post1 = new Post();
//        post1.setAutor("Fernanda Alves");
//        post1.setData(LocalDate.now());
//        post1.setTitulo("Docker");
//        post1.setTexto("De forma resumida, o Docker é uma " +
//                "plataforma de código aberto, desenvolvido" +
//                " na linguagem Go e criada pelo próprio " +
//                "Google. Por ser de alto desempenho, o " +
//                "software garante maior facilidade na " +
//                "criação e administração de ambientes isolados," +
//                " garantindo a rápida disponibilização de " +
//                "programas para o usuário final.");
//
//        Post post2 = new Post();
//        post2.setAutor("Fernanda Alves");
//        post2.setData(LocalDate.now());
//        post2.setTitulo("Node JS");
//        post2.setTexto("O Node.js pode ser definido como um " +
//                "ambiente de execução Javascript server-side. " +
//                "Isso significa que com o Node.js é possível criar " +
//                "aplicações Javascript para rodar como uma aplicação" +
//                "standalone em uma máquina, não dependendo de um " +
//                "browser para a execução, como estamos acostumados.");
//
//        postList.add(post1);
//        postList.add(post2);
//
//        for (Post post: postList) {
//            Post postSaved = codeblogRepository.save(post);
//            System.out.println(postSaved.getId());
//        }

//        Usuario usuario = new Usuario();
//        usuario.setLogin("fernanda");
//        usuario.setSenha(new BCryptPasswordEncoder().encode("1234"));
//
//        usuarioRepository.save(usuario);

    }



}
