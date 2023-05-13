# UCE Génie Logiciel Avancé : Techniques de tests

## Badges

![namebadge](https://img.shields.io/static/v1?label=Nom&message=Anthony%20NAVARRO&color=orange)
![groupbadge](https://img.shields.io/static/v1?label=Groupe&message=ILSEN-ALT-Gr1&color=yellow)
[![CircleCI](https://dl.circleci.com/status-badge/img/gh/anthony-navarro/ceri-m1-techniques-de-test/tree/master.svg?style=svg)](https://dl.circleci.com/status-badge/redirect/gh/anthony-navarro/ceri-m1-techniques-de-test/tree/master)

[![codecov](https://codecov.io/gh/anthony-navarro/ceri-m1-techniques-de-test/branch/master/graph/badge.svg?token=4XQPG8194S)](https://codecov.io/gh/anthony-navarro/ceri-m1-techniques-de-test)
![Checkstyle](./docs/badges/checkstyle-result.svg)

## Documentation

Pour accéder à la Javadoc cliquer [ici](https://anthony-navarro.github.io/ceri-m1-techniques-de-test/fr/univavignon/pokedex/api/package-summary.html)

## TP6 - Rapport

Pour commencer, j'ai testé l'implémentation de RocketPokemonFactory avec les mêmes tests que PokemonFactory. 
Contrairement à PokemonFactory, tous les tests ont échoué pour RocketPokemonFactory.

- Pour le test shouldCreatePokemon : Le résultat attendu était le nom du Pokémon Salamèche, mais c'est MISSINGNO à la place qui a été reçu.
- Pour le test shouldThrowWhenIndexTooLowOrHigh : Aucune exception (PokedexException) n'a été déclenchée pour des index invalides, c'est-à-dire inférieurs à 0 et supérieurs à 150.

Après avoir étudié le code de RocketPokemonFactory, je me suis aperçu que la génération des statistiques de l'Attaque, de la Défense et de la Stamina sont aléatoires, ce qui signifie que ces valeurs ne correspondent pas aux statistiques réelles du Pokémon. 
De plus, les IV des Pokémon générés par le code de RocketPokemonFactory ne peuvent avoir que deux valeurs, 0 ou 1, ce qui ne correspond pas non plus aux statistiques réelles du Pokémon.

Et enfin, j'ai modifié les tests de l'implémentation RocketPokemonFactory pour qu'ils fonctionnent avec ses particularités.
