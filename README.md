# TP-TAA

## Questions

### Qestion 1


### Rest API


Get an entity
    
    curl -H "Content-Type: application/json" -X GET http://localhost:8080/{object name}

Insert an entity

    curl -H "Content-Type: application/json" -X POST -d '{"name":"test","firstName":"t"}' http://localhost:8080/status/person
