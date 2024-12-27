# SPARQL Management

SPARQL (SPARQL Protocol and RDF Query Language) is a powerful query language and protocol designed specifically for retrieving and manipulating data stored in the Resource Description Framework (RDF) format. RDF is a foundational standard for representing information in a structured, linked-data format, enabling the creation of semantic data models.

Semantic data models go beyond traditional relational database models by incorporating meaning and relationships directly into the data. They leverage ontologies, vocabularies, and schemas to define how data entities relate to each other, enabling more intelligent and context-aware data integration, search, and analysis.

SPARQL plays a crucial role in semantic data models by allowing users to:

- Query interconnected datasets using graph patterns.
- Navigate relationships and extract meaningful insights from complex datasets.
- Perform operations such as filtering, aggregation, and subqueries across distributed RDF datasets.

This combination of SPARQL and semantic data models is fundamental in domains like knowledge graphs, linked data, and AI-driven systems, providing a framework for working with highly interconnected and contextually rich information.

## Restful Api Application

In this application, we aim to manage queries in rest-api-mode.

## Setup

1. **Clone the repository:**

   ```bash
   git clone https://github.com/j-imsa/SPARQL-Management.git
   cd SPARQL-Management-master
   ```


2. **Prerequisites:**
    - Java 21 (sdkman)
    - Maven (sdkman)
    - Postman
    - curl


3. **Build the project:**

   ```bash
   mvn clean install
   ```
   
4. **Run the app:**

   ```bash
   cd target
   java -jar SPARQL-Management-0.0.1.jar 
   ```

## Request / Response

> you can find the Postman exported collections and environment to import them!
> 
> [SPARQL Management.postman_collection.json](SPARQL%20Management.postman_collection.json)
> 
> [SPARQL Management Env.postman_environment.json](SPARQL%20Management%20Env.postman_environment.json)


1. Get All

   ```bash
   curl --location 'http://localhost:8085/sparql-management/sparql'
   ```

2. Get

   ```bash
   curl --location 'http://localhost:8085/sparql-management/sparql/wzBJ1Dq9Qd8lTXhJrgImxl4XoB9rQkCzsZizS6ztdsmyncmJH7pz4DC7PDZ_KFhG' 
   ```

3. Post

   ```bash
   curl --location 'http://localhost:8085/sparql-management/sparql' \
   --header 'Content-Type: application/json' \
   --header 'Authorization: Basic YWRtaW46aWhhdmV0aGVwb3dlcg==' \
   --data '{
      "name": "Amin",
      "description": "test description",
      "query": "select Iman from candidiates :)",
      "creator": "Alireza"
   }'
   ```

4. Put

   ```bash
   curl --location --request PUT 'http://localhost:8085/sparql-management/sparql/YWXuspA5kfpB8i5Wb74dy8G-82hyGfhwqBaXSH9NQ-PotukSGIr2F41hkWaz-eYY' \
   --header 'Content-Type: application/json' \
   --header 'Authorization: Basic YWxpcmV6YWVtYWQ6aWhhdmVub3NlY3JldHM=' \
   --data '{
      "name": "Amin",
      "description": "test description",
      "query": "select Iman from candidiates :)",
      "creator": "Alireza"
   }'
   ```

5. Delete

   ```bash
   curl --location --request DELETE 'http://localhost:8085/sparql-management/sparql/YWXuspA5kfpB8i5Wb74dy8G-82hyGfhwqBaXSH9NQ-PotukSGIr2F41hkWaz-eYY' \
   --header 'Authorization: Basic dGltYmVybmVyc2xlZTp3b3JsZHdpZGV3ZWI=' 
   ```


## UI

- Swagger:
  - http://localhost:8085/sparql-management/docs-ui
  - http://localhost:8085/sparql-management/api-docs
  - ![Screenshot from 2024-12-27 15-41-03.png](Screenshot%20from%202024-12-27%2015-41-03.png)
- DB:
  - http://localhost:8085/sparql-management/h2-console
  - ![Screenshot from 2024-12-27 15-40-22.png](Screenshot%20from%202024-12-27%2015-40-22.png)



### License

This project is licensed under the Apache License, Version 2.0 - see the [LICENSE](https://www.apache.org/licenses/LICENSE-2.0) file for details.