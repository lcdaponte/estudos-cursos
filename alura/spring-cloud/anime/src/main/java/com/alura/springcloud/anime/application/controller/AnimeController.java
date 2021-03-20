package com.alura.springcloud.anime.application.controller;

import com.alura.springcloud.anime.application.builder.AnimeDtoBuilder;
import com.alura.springcloud.anime.application.dto.AnimeDTO;
import com.alura.springcloud.anime.domain.anime.Anime.Anime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping(value = "/v1/api")
public class AnimeController {

    private List<Anime> animes = Arrays.asList(
        new Anime("Boku no Hero Academia", "A história segue Izuku Midoriya, um menino que nasceu sem individualidade em mundo que é normal tê-los, mas mesmo assim sonha em se tornar um super-herói. Após ajudar o maior herói do mundo, que fica fraco depois de um tempo por causa de um ferimento, a capturar um vilão, este compartilha os seus poderes, o One for All, com Izuku depois de reconhecer o seu valor e o ajuda a se matricular em uma escola para heróis em formação (a U.A)", LocalDate.of(2016, 6, 26)),
        new Anime("Fullmetal Alchemist: Brotherhood", "O mundo de Fullmetal Alchemist é baseado no período após a Revolução Industrial Europeia. Situado em um universo ficcional em que a alquimia é uma das mais avançadas técnicas científicas conhecidas pelo homem, a história centra-se nos irmãos Edward Elric e Alphonse Elric, que estão procurando a pedra filosofal para restaurar seus corpos após uma desastrosa tentativa de trazer a mãe falecida de volta à vida através da alquimia.", LocalDate.of(2009, 4, 5)),
        new Anime("Jujutsu Kaisen", "Yuuji Itadori é um estudante do ensino médio que vive em Sendai com seu avô. Ele evita regularmente a equipe de pista devido à sua aversão ao atletismo, apesar de seu talento inato para o esporte. Em vez disso, ele decide ingressar no Clube de Pesquisa Oculta, onde pode relaxar e sair com seus veteranos, e deixar a escola às 17h para visitar seu avô no hospital. Enquanto ele está no leito de morte, seu avô envia duas mensagens poderosas dentro de Yuuji - 'sempre ajude as pessoas' e 'morra cercado por uma multidão'.", LocalDate.of(2020, 10, 3)),
		new Anime("One Piece", "One Piece conta as aventuras de Monkey D. Luffy, um jovem cujo corpo ganhou as propriedades de borracha após ter comido uma fruta do diabo acidentalmente. Com sua tripulação, os Piratas do Chapéu de Palha, Luffy explora a Grand Line em busca do tesouro mais procurado do mundo, o \"One Piece\", a fim de se tornar o próximo Rei dos Piratas.", LocalDate.of(1999, 10, 20)));

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<AnimeDTO>> getAllAnime(){

        var animesdto = animes
                .stream()
                .map(anime -> new AnimeDtoBuilder()
                        .withName(anime.getName())
                        .withDescription(anime.getDescription())
                        .withReleaseDate(anime.getRelease_date())
                        .convertAnimeIntoAnimeDto())
                .collect(toList());


        return new ResponseEntity<List<AnimeDTO>>(animesdto, HttpStatus.OK);
    }
}
