//Se llama al typedef (esquema) de cada submodulo
const productTypeDefs = require('./product_type_defs');
const invoiceTypeDefs = require('./invoice_type_defs');
const authTypeDefs = require('./auth_type_defs');
//Se unen
const schemasArrays = [authTypeDefs, productTypeDefs, invoiceTypeDefs];
//Se exportan
module.exports = schemasArrays;