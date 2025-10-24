# Projeto de Observabilidade: API Spring Boot com Prometheus e Grafana

Este projeto demonstra a implementação de um stack completo de observabilidade (monitoramento) para uma API RESTful desenvolvida em Spring Boot. A aplicação é totalmente containerizada usando Docker e orquestrada com Docker Compose.

O stack é composto por:
* **API (Spring Boot):** Uma API REST para gerenciamento de "Tarefas" que expõe métricas de saúde e de aplicação via **Spring Boot Actuator**.
* **Prometheus:** Um servidor de monitoramento configurado para "raspar" (scrape) as métricas expostas pela API.
* **Grafana:** Um dashboard de visualização configurado para ler os dados do Prometheus e exibi-los em gráficos em tempo real.

![Print do Dashboard do Grafana]([COLOQUE O LINK DO SEU PRINT AQUI])

---

## 🚀 Tecnologias Utilizadas

* **Backend:** Java 17, Spring Boot 3, Spring Data JPA
* **Banco de Dados:** H2 (em memória)
* **Métricas:** Spring Boot Actuator, Micrometer
* **Monitoramento:** Prometheus
* **Visualização:** Grafana
* **Containerização:** Docker & Docker Compose

---

## 📦 Como Executar o Projeto

**Pré-requisitos:**
* [Docker](https://www.docker.com/products/docker-desktop/)
* [Docker Compose](https://docs.docker.com/compose/install/) (já vem com o Docker Desktop)

O projeto é 100% containerizado. Para executá-lo, basta seguir os passos:

1.  **Clone este repositório:**
    ```bash
    git clone [COLOQUE A URL DO SEU REPOSITÓRIO AQUI]
    cd [NOME-DO-SEU-REPOSITÓRIO]
    ```

2.  **Suba o stack com Docker Compose:**
    Este comando irá construir a imagem da API e iniciar todos os três containers (API, Prometheus, Grafana).
    ```bash
    docker compose up --build
    ```

3.  **Aguarde os serviços iniciarem.** O processo pode levar alguns minutos na primeira vez.

---

## 🌐 Endpoints e Serviços

Após a execução, os seguintes serviços estarão disponíveis no seu `localhost`:

* ### 1. API de Tarefas (Spring Boot)
    * **URL:** `http://localhost:8080`
    * **Endpoint (GET):** `http://localhost:8080/tarefas` (Lista todas as tarefas)
    * **Endpoint (POST):** `http://localhost:8080/tarefas` (Cria uma nova tarefa)
        * *Exemplo de JSON (Body):*
          ```json
          {
            "descricao": "Minha nova tarefa",
            "concluida": false
          }
          ```
    * **Métricas (Prometheus):** `http://localhost:8080/actuator/prometheus`

* ### 2. Prometheus (Coletor)
    * **URL:** `http://localhost:9090`
    * **Status dos Alvos (Targets):** `http://localhost:9090/targets`
        *(Verifique aqui se o "State" da `api-observabilidade` está "UP" (verde))*

* ### 3. Grafana (Dashboard)
    * **URL:** `http://localhost:3000`
    * **Usuário:** `admin`
    * **Senha:** `admin`

### Configuração do Grafana (Primeiro Acesso)
1.  Acesse o Grafana (`http://localhost:3000`).
2.  Faça login (`admin`/`admin`).
3.  Vá em **Configuration ⚙️ > Data Sources > Add data source > Prometheus**.
4.  No campo **URL**, insira: `http://prometheus:9090`
5.  Clique em **"Save & test"**.
6.  Para importar um dashboard pronto rapidamente:
    * Vá em **Create + > Import dashboard**.
    * Cole o ID `10280` (JVM (Micrometer) Dashboard) e clique em **"Load"**.
    * Selecione seu Data Source "Prometheus" e importe.