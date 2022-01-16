# Ciclo4

Web project for MisiónTIC cycle 4 

# Overview

This code is an API micro-services implementation. This works a blended systems integrated by an API Gateway as follow:
- An API REST for invoices made with Spring Boot
- An API REST for user authentication made with Django
- An API Gateway for integrate the two previous micro-services APIs made with GraphQL

Each repository's branch is a component.

# Arquitecture representation

A preliminar version of the components using micro-services and a API Gateway is [here](https://is.gd/z17RKR).

The components developed were as follows:

<img src="https://github.com/dzarkV/Ciclo4/blob/main/Arquitectura_C4.png" width=50% height=50%>
<!--- ![Arquitecture representation](https://github.com/dzarkV/Ciclo4/blob/main/Arquitectura_C4.png?raw=true) -->

Was a require the languages diversity with SQL and NoSQL data bases and the Docker handle for each micro-service.

# User stories

Some of the user stories were:

> - Como administrador, debe poderse crear roles entre vendedor y administrador, asignando un usuario y contraseña.
> - Como administrador/vendedor, se requiere poder crear la facturación una vez se efectúa una venta, en la cual se incluirán datos básicos como fecha, producto, cantidad, valor de cada producto y valor total, con la posibilidad de modificación.
> - Como administrador, requiero poder crear cuentas de vendedor, en las que se incluirán datos generales (como el número de identificación), así como datos de contacto (como la fecha de contratación), entre otros.
> - Como administrador/vendedor, se requiere crear los atributos de los productos, teniendo en cuenta su identificación, cantidad en stock, valor unitario y tipo de producto.

# Test

Some tests on Postman and GraphQL are:

| <ul><li>- [x] Create products</li></ul>      |    <ul><li>- [x] Update products</li></ul>  |
|:--------------:|:-----------:|
| <img src="https://github.com/dzarkV/Ciclo4/blob/main/pics/create-prod.png" width=100% height=100%> | <img src="https://github.com/dzarkV/Ciclo4/blob/main/pics/update-prod.png" width=100% height=100%>   | 
| **<ul><li>- [x] Create invoices</li></ul>**      | **<ul><li>- [x] Check out users</li></ul>**   |
| <img src="https://github.com/dzarkV/Ciclo4/blob/main/pics/create-inv.png" width=100% height=100%> | <img src="https://github.com/dzarkV/Ciclo4/blob/main/pics/users.png" width=100% height=100%>   |
| **<ul><li>- [x] Check out products</li></ul>**      | **<ul><li>- [x] Check out invoices</li></ul>**   |
| <img src="https://github.com/dzarkV/Ciclo4/blob/main/pics/products.png" width=100% height=100%> | <img src="https://github.com/dzarkV/Ciclo4/blob/main/pics/invoices.png" width=100% height=100%>   |



# To Do

Vue front-end
