# Ciclo4

Web project for MisiónTIC cycle 4 

# Overview

This code is an API micro-services implementation. This works a blended systems integrated by an API Gateway as follow:
- An API REST for invoices made with Spring Boot
- An API REST for user authentication made with Django
- An API Gateway for integrate the two previous micro-services APIs made with GraphQL

# Arquitecture representation

A preliminar version of the components using micro-services and a API Gateway is [here](https://is.gd/z17RKR).

The components developed were as follows:

![Arquitecture representation](https://github.com/dzarkV/Ciclo4/blob/main/Arquitectura_C4.png?raw=true)

Was a require the languages diversity with SQL and NoSQL data bases and the Docker handle for each micro-service.

# User stories

Some of the user stories were:

> - Como administrador, debe poderse crear roles entre vendedor y administrador, asignando un usuario y contraseña.
> - Como administrador/vendedor, se requiere poder crear la facturación una vez se efectúa una venta, en la cual se incluirán datos básicos como fecha, producto, cantidad, valor de cada producto y valor total, con la posibilidad de modificación.
> - Como administrador, requiero poder crear cuentas de vendedor, en las que se incluirán datos generales (como el número de identificación), así como datos de contacto (como la fecha de contratación), entre otros.
> - Como administrador/vendedor, se requiere crear los atributos de los productos, teniendo en cuenta su identificación, cantidad en stock, valor unitario y tipo de producto.

# To Do

Vue front-end
