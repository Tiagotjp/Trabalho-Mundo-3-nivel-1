#  Material de orientações para desenvolvimento da missão prática do 1º nível de conhecimento.

## RPG0014  - Iniciando o caminho pelo Java

Implementação de um cadastro de clientes em modo texto, com persistência
em arquivos, baseado na tecnologia Java.

## Objetivos da prática

•	Utilizar herança e polimorfismo na  definição de entidades

•	 Utilizar persistência de objetos em arquivos binários.

•	Implementar uma interface cadastral em modo texto.

•	 Utilizar o controle de exceções da plataforma Java.

•	No final do projeto, o aluno terá implementado um sistema cadastral em
    Java, utilizando os recursos da programação orientada a objetos e a
    persistência em arquivos binários.


## 📍 Materiais necessários para a prática

•	 JDK e IDE NetBeans.

•	 Equipamentos: Computador com JDK e NetBeans instalados.

# 👉 1º Procedimento | Criação das Entidades e Sistema de Persistência

  1. Criar um projeto do tipo Ant..Java Application no NetBeans, utilizando o
  nome CadastroPOO para o projeto.

<img width="547" alt="00001111" src="https://github.com/Tiagotjp/Gerador-de-Senhas/assets/132152335/fc9fd07c-78d5-47f1-9b0f-25ef67c0fd11">

## 2. Criar um pacote com o nome "model", para as entidades e gerenciadores.

## 3. No pacote model criar as entidades, com as seguintes características:

a - Classe Pessoa, com os campos id (inteiro) e nome (texto), método
exibir, para impressão dos dados, construtor padrão e completo, além
de getters e setters para todos os campos.

b - Classe PessoaFisica, herdando de Pessoa, com o acréscimo dos
campos cpf (texto) e idade (inteiro), método exibir polimórfico,
construtores, getters e setters.

c - Classe PessoaJuridica, herdando de Pessoa, com o acréscimo do
campo cnpj (texto), método exibir polimórfico, construtores, getters e
setters.

d - Adicionar interface Serializable em todas as classes

## 4. No pacote model criar os gerenciadores, com as seguintes
características:

a - Classe PessoaFisicaRepo, contendo um ArrayList de PessoaFisica,
nível de acesso privado, e métodos públicos inserir, alterar, excluir,
obter e obterTodos, para gerenciamento das entidades contidas no
ArrayList.

b- Classe PessoaJuridicaRepo, com um ArrayList de PessoaJuridica,
nível de acesso privado, e métodos públicos inserir, alterar, excluir,
obter e obterTodos, para gerenciamento das entidades contidas no
ArrayList .

c - Em ambos os gerenciadores adicionar o método público persistir, com
a recepção do nome do arquivo, para armazenagem dos dados no
disco.

d - Em ambos os gerenciadores adicionar o método público recuperar,
com a recepção do nome do arquivo, para recuperação dos dados do
disco

e - Os métodos persistir e recuperar devem ecoar (throws) exceções

f - O método obter deve retornar uma entidade a partir do id

g - Os métodos inserir e alterar devem ter entidades como parâmetros

h - O método excluir deve receber o id da entidade para exclusão

i - O método obterTodos deve retornar o conjunto completo de entidades.

## 5. Alterar o método main da classe principal para testar os repositórios:

a - Instanciar um repositório de pessoas físicas (repo1).

b - Adicionar duas pessoas físicas, utilizando o construtor completo.

c - Invocar o método de persistência em repo1, fornecendo um nome de
arquivo fixo, através do código.

d -Instanciar outro repositório de pessoas físicas (repo2).

e - Invocar o método de recuperação em repo2, fornecendo o mesmo
nome de arquivo utilizado anteriormente.

f - Exibir os dados de todas as pessoas físicas recuperadas.

g - Instanciar um repositório de pessoas jurídicas (repo3).

h - Adicionar duas pessoas jurídicas, utilizando o construtor completo.

i - Invocar o método de persistência em repo3, fornecendo um nome de
arquivo fixo, através do código.

j - Instanciar outro repositório de pessoas jurídicas (repo4).

k - Invocar o método de recuperação em repo4, fornecendo o mesmo
nome de arquivo utilizado anteriormente.

l - Exibir os dados de todas as pessoas jurídicas recuperadas.

# 6. Ajustar as características para obter uma execução como a seguinte:

<img width="395" alt="resultadodoprimeiroprocesso01" src="https://github.com/Tiagotjp/Gerador-de-Senhas/assets/132152335/2913c044-5c25-42bc-8663-db8fdb119606">

# 👉 2º Procedimento | Criação do Cadastro em Modo Texto

## 1. Alterar o método main da classe principal do projeto, para
implementação do cadastro em modo texto:

a - Apresentar as opções do programa para o usuário, sendo 1 para incluir,
2 para alterar, 3 para excluir, 4 para exibir pelo id, 5 para exibir todos, 6
para salvar dados, 7 para recuperar dados e 0 para finalizar a
execução.

b - Selecionada a opção incluir, escolher o tipo (Física ou Jurídica),
receber os dados a partir do teclado e adicionar no repositório correto.

c - Selecionada a opção alterar, escolher o tipo (Física ou Jurídica),
receber o id a partir do teclado, apresentar os dados atuais, solicitar os
novos dados e alterar no repositório correto.

d - Selecionada a opção excluir, escolher o tipo (Física ou Jurídica),
receber o id a partir do teclado e remover do repositório correto.

e - Selecionada a opção obter, escolher o tipo (Física ou Jurídica), receber
o id a partir do teclado e apresentar os dados atuais para a entidade.

f - Selecionada a opção obterTodos, escolher o tipo (Física ou Jurídica) e
apresentar os dados de todas as entidades do repositório correto.

g - Selecionada a opção salvar, solicitar o prefixo dos arquivos e persistir
os dados nos arquivos [prefixo].fisica.bin e [prefixo].juridica.bin.

h - Selecionada a opção recuperar, solicitar o prefixo dos arquivos e obter
os dados a partir dos arquivos [prefixo].fisica.bin e
[prefixo].juridica.bin.

i - Nas opções salvar e recuperar devem ser tratadas as exceções.

j - Selecionada a opção sair, finalizar a execução do sistema.

## 2. Ajustar as características para obter uma execução como a seguinte.

<img width="509" alt="000066666666" src="https://github.com/Tiagotjp/Gerador-de-Senhas/assets/132152335/40f44d86-e762-4202-8f1d-9b2400592410">


<img width="509" alt="frewrt43" src="https://github.com/Tiagotjp/Gerador-de-Senhas/assets/132152335/2c1430ba-1bdc-4fb2-ab87-f8c8b2a079f2">






