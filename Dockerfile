# Estágio 1: Build (Construir o .jar)
# Usamos uma imagem que já vem com o Maven (para compilar)
FROM maven:3.9-eclipse-temurin-17-focal AS build

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia o 'plano' do projeto (pom.xml)
COPY pom.xml .

# Copia o código-fonte
COPY src ./src

# Roda o comando do Maven para baixar dependências e criar o arquivo .jar
# O -DskipTests pula os testes (acelera o build)
RUN mvn package -DskipTests

# Estágio 2: Run (Rodar a Aplicação)
# Usamos uma imagem leve, que só tem o Java 17, para rodar
FROM eclipse-temurin:17-jre-focal

# Define o diretório de trabalho
WORKDIR /app

# Copia APENAS o arquivo .jar que foi criado no estágio 1
COPY --from=build /app/target/*.jar app.jar

# Expõe a porta 8080 (a porta padrão do Spring Boot)
EXPOSE 8080

# Comando para iniciar a aplicação quando o container rodar
ENTRYPOINT ["java", "-jar", "app.jar"]