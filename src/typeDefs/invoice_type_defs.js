const { gql } = require('apollo-server');

const invoiceTypeDefs = gql`
    type Invoice {
        idFactura: Int!
        productos: [Product]!
        fechaVenta: String
        username: String!
        detailsUser: UserDetail
        valorFactura: Float!
    }
    
    input CreateInvoiceInput {
        idFactura: Int!
        codigosProducto: [String]!
    }
    extend type Mutation {
        crearInvoice(userInput: CreateInvoiceInput): Invoice!
        actualizarInvoice(userInput: CreateInvoiceInput): Invoice!
    }
    
    extend type Query {
        getInvoiceById(idFactura: Int!): Invoice!
        allInvoices: [Invoice]!
        
    }
`;
module.exports = invoiceTypeDefs;