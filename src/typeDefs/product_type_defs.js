const { gql } = require('apollo-server');

const productTypeDefs = gql`

    input CreateProduct {
        codProducto: String!
        nombreProducto: String!
        descripcionProducto: String!
        precioProducto: Float!
    }
    type Product {
        codProducto: String!
        nombreProducto: String!
        descripcionProducto: String!
        precioProducto: Float!
        isActive: Boolean
    }
    type Mutation {
        crearProducto(userInput: CreateProduct): Product!
        actualizarProducto(userInput: CreateProduct): Product!
    }
    extend type Query {
        getProductoById(codProducto: String!): Product!
        allProducts: [Product]!
        
    }
`;
module.exports = productTypeDefs;