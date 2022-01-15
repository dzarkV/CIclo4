const productResolver = require('./product_resolver');
const invoiceResolver = require('./invoice_resolver');
const authResolver = require('./auth_resolver');
const lodash = require('lodash');
const resolvers = lodash.merge(authResolver, productResolver, invoiceResolver);
module.exports = resolvers;