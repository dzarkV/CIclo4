const invoiceResolver = {
    Query: {
        getInvoiceById: async (_, { idFactura }, { dataSources }) => {
            return await dataSources.invoiceAPI.getInvoice(idFactura);
        },
        allInvoices: async (_, { }, { dataSources }) => {
            return await dataSources.invoiceAPI.getAllInvoices();
        },
    },
    Invoice: {
        detailsUser: async (_, { }, { dataSources }) => {
            username = _.username
            const [detailsUser] = (await dataSources.authAPI.getUserByUserName(username))
            return detailsUser;
        },
    },
    Mutation: {
        crearInvoice: async (_, { userInput }, { dataSources, userIdToken }) => {
            usernameToken = (await dataSources.authAPI.getUser(userIdToken)).username
            
            // if (invoice.username == usernameToken) {
            const invoiceInput = {
                idFactura: userInput.idFactura,
                codigosProducto: userInput.codigosProducto,
                username: usernameToken,
            }
            return await dataSources.invoiceAPI.createInvoice(invoiceInput);
            // }
            // else
            //     return null
        },
        actualizarInvoice: async (_, { userInput }, { dataSources, userIdToken }) => {
            usernameToken = (await dataSources.authAPI.getUser(userIdToken)).username
            // if (invoice.username == usernameToken) {
            const codFacturaInput = userInput.idFactura
            const invoiceInput = {
                idFactura: userInput.idFactura,
                codigosProducto: userInput.codigosProducto,
                username: usernameToken,
            }
            return await dataSources.invoiceAPI.updateInvoice(codFacturaInput, invoiceInput);
            // }
            // else
            //     return null
        },
    },
};
module.exports = invoiceResolver;